package adapter;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import response.Content;
import response.ContentEArchiveInvoice;
import response.EArchiveInvoiceResponse;
import response.EInvoiceResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;

public class EArchiveInvoiceAdapter extends Adapter {

    public String URL = BASE_URL + "/" + VERSION + "/earchives/" ;
    Adapter adapter = new Adapter();
    EArchiveInvoiceResponse EArchiveInvoiceResponse;
    EArchiveInvoiceResponse eArchiveInvoiceResponseList;

    public EArchiveInvoiceResponse listEArchiveInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL;
        String response = httpClient().send(token, url, "GET");
        eArchiveInvoiceResponseList = new Gson().fromJson(response, EArchiveInvoiceResponse.class);

        return EArchiveInvoiceResponse;
    }

    public String ViewPDFEArchiveInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {


        String response="";
        for (ContentEArchiveInvoice content:eArchiveInvoiceResponseList.contents) {
            File file = new File(PATH + "EArchiveInvoice/PDF", content.id+".pdf");
            String url = URL + content.id + "/preview/pdf";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewHTMLEArchiveInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEArchiveInvoice content:eArchiveInvoiceResponseList.contents) {
            File file = new File(PATH + "EArchiveInvoice/HTML", content.id+".html");
            String url = URL + content.id + "/preview/html";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewXMLEArchiveInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEArchiveInvoice content:eArchiveInvoiceResponseList.contents) {
            File file = new File(PATH + "EArchiveInvoice/XML", content.id+".xml");
            String url = URL + content.id + "/preview/ubl";
            response = httpClient().sendFile(token, url, file);
        }

        return response;


    }
    public String statusEArchiveInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "/lookup-statuses";
        String response = httpClient().send(token, url, "GET");
        return response;
    }
}
