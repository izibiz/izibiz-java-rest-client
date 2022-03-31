package adapter;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import response.EArchiveInvoiceResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;

public class EArchiveInvoiceAdapter extends Adapter {

    public String URL = BASE_URL + "/" + VERSION + "/earchives/" ;
    Adapter adapter = new Adapter();
    response.EArchiveInvoiceResponse EArchiveInvoiceResponse;

    public EArchiveInvoiceResponse listEArchiveInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{


        System.out.println(URL);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URL))
                .setHeader("Authorization","Bearer " + token)
                .GET()
                .build();

        JsonNode responseData = (JsonNode) httpClient().send(request);

        System.out.println(responseData);
        String response = responseData.toString();
        //  eInvoiceResponse = mapper().readValue(response,EInvoiceResponse.class);
        EArchiveInvoiceResponse = new Gson().fromJson(response,EArchiveInvoiceResponse.class);

        System.out.println(EArchiveInvoiceResponse.contents[0]);

        if(null == response) {
            response = responseData.asText();
        }


        return EArchiveInvoiceResponse;
    }

    public String ViewPDFEArchiveInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {
        File file = new File("C:/Users/Özgür/Desktop/İzibiz/Kayit/EArchiveInvoice/PDF", ID+".pdf");
        URL = URL + ID + "/preview/pdf";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URL))
                .setHeader("Authorization","Bearer " + token)
                .GET()
                .build();

        byte[] responseData = httpClient().sendFile(request);

        FileOutputStream pdfFile = new FileOutputStream(file);
        byte[] decoder = responseData;

        pdfFile.write(decoder);

        return responseData.toString();

    }
    public String ViewHTMLEArchiveInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {
        File file = new File("C:/Users/Özgür/Desktop/İzibiz/Kayit/EArchiveInvoice/HTML", ID+".html");
        URL = URL +  ID + "/preview/html";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URL))
                .setHeader("Authorization","Bearer " + token)
                .GET()
                .build();

        byte[] responseData = httpClient().sendFile(request);

        FileOutputStream htmlFile = new FileOutputStream(file);
        byte[] decoder = responseData;

        htmlFile.write(decoder);

        return responseData.toString();

    }
    public String ViewXMLEArchiveInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {
        File file = new File("C:/Users/Özgür/Desktop/İzibiz/Kayit/EArchiveInvoice/XML", ID+".xml");
        URL = URL + ID + "/preview/ubl";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URL))
                .setHeader("Authorization","Bearer " + token)
                .GET()
                .build();

        byte[] responseData = httpClient().sendFile(request);

        FileOutputStream xmlFile = new FileOutputStream(file);
        byte[] decoder = responseData;

        xmlFile.write(decoder);

        return responseData.toString();

    }
    public String statusEArchiveInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        URL = URL + "/lookup-statuses";
        System.out.println(URL);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URL))
                .setHeader("Authorization","Bearer " + token)
                .GET()
                .build();

        JsonNode responseData = (JsonNode) httpClient().send(request);

        System.out.println(responseData);
        String response = responseData.toString();


        System.out.println(response);

        if(null == response) {
            response = responseData.asText();
        }

        return response;
    }
}
