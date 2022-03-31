package adapter;

import com.fasterxml.jackson.databind.JsonNode;

import com.google.gson.Gson;
import response.EInvoiceResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class EInvoiceAdapter extends Adapter {
    public String URL = BASE_URL + "/" + VERSION + "/einvoices/" ;
    Adapter adapter = new Adapter();
    EInvoiceResponse eInvoiceResponse;

    public EInvoiceResponse listEInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        URL = URL +"inbox?dateType=DELIVERY&status=New&startDate="+ adapter.startDate + "&endDate=" + adapter.endDate + "&page=1&pageSize=20&sort=desc&sortProperty=supplierName";

        System.out.println(URL);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URL))
                .setHeader("Authorization","Bearer " + token)
                .GET()
                .build();

        JsonNode responseData = (JsonNode) httpClient().send(request);

        System.out.println(responseData);
        String response = responseData.toString();
    //  eInvoiceResponse = mapper().readValue(response,EInvoiceResponse.class);  //java generic method
        eInvoiceResponse = new Gson().fromJson(response,EInvoiceResponse.class);

        System.out.println(eInvoiceResponse.contents[0]);

        if(null == response) {// string utils apache commons
            response = responseData.asText();
        }


        return eInvoiceResponse;
    }

    public EInvoiceResponse pendingApprovalEinvoices(String token)throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{
        URL = URL + "outbox?page=0&sortProperty=customerName&sort=asc";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URL))
                .setHeader("Authorization","Bearer " + token)
                .GET()
                .build();

        JsonNode responseData = (JsonNode) httpClient().send(request);

        System.out.println(responseData);
        String response = responseData.toString();
        //  eInvoiceResponse = mapper().readValue(response,EInvoiceResponse.class);
        eInvoiceResponse = new Gson().fromJson(response,EInvoiceResponse.class);



        System.out.println(eInvoiceResponse.contents[0]);

        if(null == response) {
            response = responseData.asText();
        }

        return eInvoiceResponse;
    }

    public EInvoiceResponse approvalExpiredEInvoices(String token)throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{
        URL = URL + "inbox?status=ResponseTimeExpired&page=0&pageSize=100&sortProperty=createDate&sort=asc";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URL))
                .setHeader("Authorization","Bearer " + token)
                .GET()
                .build();

        JsonNode responseData = (JsonNode) httpClient().send(request);

        System.out.println(responseData);
        String response = responseData.toString();
        //  eInvoiceResponse = mapper().readValue(response,EInvoiceResponse.class);
        eInvoiceResponse = new Gson().fromJson(response,EInvoiceResponse.class);



        System.out.println(eInvoiceResponse.contents[0]);

        if(null == response) {
            response = responseData.asText();
        }

        return eInvoiceResponse;
    }

    public EInvoiceResponse UndeliverableAnswerEInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{
        URL = URL + "inbox?status=ResponseUnDelivered&dateType=DELIVERY&startDate="+ adapter.startDate + "&endDate="+ adapter.endDate+ "&pageSize=100&sortProperty=createDate&sort=asc";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URL))
                .setHeader("Authorization","Bearer " + token)
                .GET()
                .build();

        JsonNode responseData = (JsonNode) httpClient().send(request);

        System.out.println(responseData);
        String response = responseData.toString();
        //  eInvoiceResponse = mapper().readValue(response,EInvoiceResponse.class);
        eInvoiceResponse = new Gson().fromJson(response,EInvoiceResponse.class);



        System.out.println(eInvoiceResponse.contents[0]);

        if(null == response) {
            response = responseData.asText();
        }

        return eInvoiceResponse;

    }

    public EInvoiceResponse RejectedEInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{
        URL = URL + "inbox?status=Rejected&dateType=DELIVERY&startDate="+ adapter.startDate + "&endDate="+ adapter.endDate+ "&page=0&pageSize=100&sortProperty=createDate&sort=asc";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URL))
                .setHeader("Authorization","Bearer " + token)
                .GET()
                .build();

        JsonNode responseData = (JsonNode) httpClient().send(request);

        System.out.println(responseData);
        String response = responseData.toString();
        //  eInvoiceResponse = mapper().readValue(response,EInvoiceResponse.class);
        eInvoiceResponse = new Gson().fromJson(response,EInvoiceResponse.class);



        System.out.println(eInvoiceResponse.contents[0]);

        if(null == response) {
            response = responseData.asText();
        }

        return eInvoiceResponse;

    }

    //public EInvoiceResponse StatusInquiryEInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{
    public String StatusInquiryEInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{
        URL = URL + "inbox/"+ ID;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URL))
                .setHeader("Authorization","Bearer " + token)
                .GET()
                .build();

        JsonNode responseData = (JsonNode) httpClient().send(request);

        System.out.println(responseData);
        String response = responseData.toString();
        //  eInvoiceResponse = mapper().readValue(response,EInvoiceResponse.class);
        //eInvoiceResponse = new Gson().fromJson(response,EInvoiceResponse.class);



        //System.out.println(eInvoiceResponse.contents[0]);

        if(null == response) {
            response = responseData.asText();
        }

        //return eInvoiceResponse;
        return response;

    }

    public String ViewPDFEInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {
        File file = new File("C:/Users/Özgür/Desktop/İzibiz/Kayit/EInvoice/Inbox/PDF", ID+".pdf");
        URL = URL + "inbox/"+ ID + "/preview/pdf";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URL))
                .setHeader("Authorization","Bearer " + token)
                .GET()
                .build();

        byte[] responseData = httpClient().sendFile(request);

        FileOutputStream pdfFile = new FileOutputStream(file);//try with resource
        byte[] decoder = responseData;

        pdfFile.write(decoder);

        return responseData.toString();

    }
    public String ViewHTMLEInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {
        File file = new File("C:/Users/Özgür/Desktop/İzibiz/Kayit/EInvoice/Inbox/HTML", ID+".html");// files
        URL = URL + "inbox/"+ ID + "/preview/html";
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
    public String ViewXMLEInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {
        File file = new File("C:/Users/Özgür/Desktop/İzibiz/Kayit/EInvoice/Inbox/XML", ID+".xml");//file utils
        URL = URL + "inbox/"+ ID + "/preview/ubl";
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

    public EInvoiceResponse pendingApprovalEinvoices_Outbox(String token)throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{
        URL = URL + "outbox?status=WaitingForResponse&page=0&pageSize=100&sortProperty=createDate&sort=asc";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URL))
                .setHeader("Authorization","Bearer " + token)
                .GET()
                .build();

        JsonNode responseData = (JsonNode) httpClient().send(request);

        System.out.println(responseData);
        String response = responseData.toString();
        //  eInvoiceResponse = mapper().readValue(response,EInvoiceResponse.class);
        eInvoiceResponse = new Gson().fromJson(response,EInvoiceResponse.class);



        System.out.println(eInvoiceResponse.contents[0]);  //sonarlint eklentisi

        if(null == response) {
            response = responseData.asText();
        }

        return eInvoiceResponse;
    }

    public EInvoiceResponse approvalExpiredEInvoices_Outbox(String token)throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{
        URL = URL + "outbox?status=ResponseTimeExpired&page=0&pageSize=100&sortProperty=createDate&sort=asc";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URL))
                .setHeader("Authorization","Bearer " + token)
                .GET()
                .build();

        JsonNode responseData = (JsonNode) httpClient().send(request);

        System.out.println(responseData);
        String response = responseData.toString();
        //  eInvoiceResponse = mapper().readValue(response,EInvoiceResponse.class);
        eInvoiceResponse = new Gson().fromJson(response,EInvoiceResponse.class);



        System.out.println(eInvoiceResponse.contents[0]);

        if(null == response) {
            response = responseData.asText();
        }

        return eInvoiceResponse;
    }

    public EInvoiceResponse UndeliverableAnswerEInvoices_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{
        URL = URL + "outbox?status=UnDelivered&dateType=DELIVERY&startDate="+adapter.startDate+"&endDate="+adapter.endDate+"&pageSize=100&sortProperty=createDate&sort=asc";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URL))
                .setHeader("Authorization","Bearer " + token)
                .GET()
                .build();

        JsonNode responseData = (JsonNode) httpClient().send(request);

        System.out.println(responseData);
        String response = responseData.toString();
        //  eInvoiceResponse = mapper().readValue(response,EInvoiceResponse.class);
        eInvoiceResponse = new Gson().fromJson(response,EInvoiceResponse.class);



        System.out.println(eInvoiceResponse.contents[0]);

        if(null == response) {
            response = responseData.asText();
        }

        return eInvoiceResponse;

    }

    public EInvoiceResponse RejectedEInvoices_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{
        URL = URL + "outbox?status=Rejected&dateType=DELIVERY&startDate="+adapter.startDate+"&endDate="+adapter.endDate+"&page=0&pageSize=100&sortProperty=createDate&sort=asc";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URL))
                .setHeader("Authorization","Bearer " + token)
                .GET()
                .build();

        JsonNode responseData = (JsonNode) httpClient().send(request);

        System.out.println(responseData);
        String response = responseData.toString();
        //  eInvoiceResponse = mapper().readValue(response,EInvoiceResponse.class);
        eInvoiceResponse = new Gson().fromJson(response,EInvoiceResponse.class);



        System.out.println(eInvoiceResponse.contents[0]);

        if(null == response) {
            response = responseData.asText();
        }

        return eInvoiceResponse;

    }
    public String ViewPDFEInvoices_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {
        File file = new File("C:/Users/Özgür/Desktop/İzibiz/Kayit/EInvoice/Outbox/PDF", ID+".pdf");
        URL = URL + "outbox/"+ ID + "/preview/pdf";
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
    public String ViewHTMLEInvoices_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {
        File file = new File("C:/Users/Özgür/Desktop/İzibiz/Kayit/EInvoice/Outbox/HTML", ID+".html");
        URL = URL + "outbox/"+ ID + "/preview/html";
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
    public String ViewXMLEInvoices_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {
        File file = new File("C:/Users/Özgür/Desktop/İzibiz/Kayit/EInvoice/Outbox/XML", ID+".xml");
        URL = URL + "outbox/"+ ID + "/preview/ubl";
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

    public String statusEInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        URL = URL +"/inbox"+ "/lookup-statuses";
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

    public String statusEInvoices_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        URL = URL +"/outbox"+ "/lookup-statuses";
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
