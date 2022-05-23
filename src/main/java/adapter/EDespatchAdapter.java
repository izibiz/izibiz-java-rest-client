package adapter;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import model.DownloadRequest;
import response.Content;
import response.ContentEDespatch;
import response.EDespatchResponse;
import response.EInvoiceResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;



public class EDespatchAdapter extends Adapter {
    public String URL = BASE_URL + "/" + VERSION + "/edespatches/" ;
    Adapter adapter = new Adapter();
    EDespatchResponse eDespatchResponse;
    EDespatchResponse eDespatchResponseList;
    EDespatchResponse eDespatchResponseList_outbox;

    public EDespatchResponse listEDespatch(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL ;
        String response = httpClient().send(token, url);
        eDespatchResponseList = new Gson().fromJson(response, EDespatchResponse.class);
        return eDespatchResponseList;
    }

    public String StatusInquiryEDespatch(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String response="";
        for (ContentEDespatch content:eDespatchResponseList.contents) {
            String url = URL + "inbox/" + content.id;
            response = httpClient().send(token, url);
        }
        return response;
    }

    public String ViewPDFEDespatch(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEDespatch content:eDespatchResponseList.contents) {
            File file = new File(PATH + "EDespatch/Inbox/PDF", content.id+".pdf");
            String url = URL + "inbox/"+ content.id + "/preview/pdf";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewHTMLEDespatch(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEDespatch content:eDespatchResponseList.contents) {
            File file = new File(PATH + "EDespatch/Inbox/HTML", content.id+".html");
            String url = URL + "inbox/"+ content.id + "/preview/html";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewXMLEDespatch(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEDespatch content:eDespatchResponseList.contents) {
            File file = new File(PATH + "EDespatch/Inbox/XML", content.id+".xml");
            String url = URL + "inbox/"+ content.id + "/preview/ubl";
            response = httpClient().sendFile(token, url, file);
        }

        return response;
    }
    public EDespatchResponse listEDespatch_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "outbox?status=WaitingForResponse&page=0&pageSize=100&sortProperty=createDate&sort=asc" ;
        String response = httpClient().send(token, url);
        eDespatchResponseList_outbox = new Gson().fromJson(response, EDespatchResponse.class);
        return eDespatchResponseList_outbox;
    }
    public String ViewPDFEDespatch_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEDespatch content:eDespatchResponseList.contents) {
            File file = new File(PATH + "EDespatch/Inbox/PDF", content.id+".pdf");
            String url = URL + "outbox/"+ content.id + "/preview/pdf";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewHTMLEDespatch_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEDespatch content:eDespatchResponseList.contents) {
            File file = new File(PATH + "EDespatch/Inbox/HTML", content.id+".html");
            String url = URL + "outbox/"+ content.id + "/preview/html";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewXMLEDespatch_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEDespatch content:eDespatchResponseList.contents) {
            File file = new File(PATH + "EDespatch/Inbox/XML", content.id+".xml");
            String url = URL + "outbox/"+ content.id + "/preview/ubl";
            response = httpClient().sendFile(token, url, file);
        }

        return response;
    }

    public String statusEDespatch(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/inbox"+ "/lookup-statuses";
        String response = httpClient().send(token, url);
        return response;
    }

    public String statusEDespatch_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/outbox"+ "/lookup-statuses";
        String response = httpClient().send(token, url);
        return response;
    }
    public String downloadXMLEDespatch(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/inbox/download/ubl", "EDespatch/Inbox/XML/Downloads/");
    }
    public String downloadHTMLEDespatch(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/inbox/download/html", "EDespatch/Inbox/HTML/Downloads/");
    }
    public String downloadPDFEDespatch(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/inbox/download/pdf", "EDespatch/Inbox/PDF/Downloads/");
    }
    public String downloadXMLEDespatch_Outbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/outbox/download/ubl", "EDespatch/Outbox/XML/Downloads/");
    }
    public String downloadHTMLEDespatch_Outbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/outbox/download/html", "EDespatch/Outbox/HTML/Downloads/");
    }
    public String downloadPDFEDespatch_Outbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/outbox/download/pdf", "EDespatch/Outbox/PDF/Downloads/");
    }
}
