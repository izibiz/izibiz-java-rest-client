package adapter;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import model.DownloadRequest;
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

    public EArchiveInvoiceResponse listEArchiveInvoice(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL;
        String response = httpClient().send(token, url);
        eArchiveInvoiceResponseList = new Gson().fromJson(response, EArchiveInvoiceResponse.class);

        return eArchiveInvoiceResponseList;
    }

    public String ViewPDFEArchiveInvoice(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {


        String response="";
        for (ContentEArchiveInvoice content:eArchiveInvoiceResponseList.contents) {
            File file = new File(PATH + "EArchiveInvoice/PDF", content.id+".pdf");
            String url = URL + content.id + "/preview/pdf";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewHTMLEArchiveInvoice(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEArchiveInvoice content:eArchiveInvoiceResponseList.contents) {
            File file = new File(PATH + "EArchiveInvoice/HTML", content.id+".html");
            String url = URL + content.id + "/preview/html";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewXMLEArchiveInvoice(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEArchiveInvoice content:eArchiveInvoiceResponseList.contents) {
            File file = new File(PATH + "EArchiveInvoice/XML", content.id+".xml");
            String url = URL + content.id + "/preview/ubl";
            response = httpClient().sendFile(token, url, file);
        }

        return response;


    }
    public String statusEArchiveInvoice(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "/lookup-statuses";
        String response = httpClient().send(token, url);
        return response;
    }
    public String downloadXMLEArchiveInvoice(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/download/ubl", "EArchiveInvoice/XML/Downloads/");
    }
    public String downloadHTMLEArchiveInvoice(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/download/html", "EArchiveInvoice/HTML/Downloads/");
    }
    public String downloadPDFEArchiveInvoice(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/download/pdf", "EArchiveInvoice/PDF/Downloads/");
    }
}
