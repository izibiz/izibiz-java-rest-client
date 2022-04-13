package adapter;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
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

    public EDespatchResponse listEDespatches(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL ;
        String response = httpClient().send(token, url, "GET");
        eDespatchResponseList = new Gson().fromJson(response, EDespatchResponse.class);//java generic method
        return eDespatchResponseList;
    }

    public String StatusInquiryEDespatches(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String response="";
        for (ContentEDespatch content:eDespatchResponseList.contents) {
            String url = URL + "inbox/" + content.id;
            response = httpClient().send(token, url, "GET");
        }
        return response;
    }

    public String ViewPDFEDespatches(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEDespatch content:eDespatchResponseList.contents) {
            File file = new File(PATH + "EDespatch/Inbox/PDF", content.id+".pdf");
            String url = URL + "inbox/"+ content.id + "/preview/pdf";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewHTMLEDespatches(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEDespatch content:eDespatchResponseList.contents) {
            File file = new File(PATH + "EDespatch/Inbox/HTML", content.id+".html");
            String url = URL + "inbox/"+ content.id + "/preview/html";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewXMLEDespatches(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEDespatch content:eDespatchResponseList.contents) {
            File file = new File(PATH + "EDespatch/Inbox/XML", content.id+".xml");
            String url = URL + "inbox/"+ content.id + "/preview/ubl";
            response = httpClient().sendFile(token, url, file);
        }

        return response;
    }
    public EDespatchResponse listEDespatches_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "outbox?status=WaitingForResponse&page=0&pageSize=100&sortProperty=createDate&sort=asc" ;
        String response = httpClient().send(token, url, "GET");
        eDespatchResponseList_outbox = new Gson().fromJson(response, EDespatchResponse.class);//java generic method
        return eDespatchResponseList_outbox;
    }
    public String ViewPDFEDespatches_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEDespatch content:eDespatchResponseList.contents) {
            File file = new File(PATH + "EDespatch/Inbox/PDF", content.id+".pdf");
            String url = URL + "outbox/"+ content.id + "/preview/pdf";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewHTMLEDespatches_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEDespatch content:eDespatchResponseList.contents) {
            File file = new File(PATH + "EDespatch/Inbox/HTML", content.id+".html");
            String url = URL + "outbox/"+ content.id + "/preview/html";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewXMLEDespatches_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEDespatch content:eDespatchResponseList.contents) {
            File file = new File(PATH + "EDespatch/Inbox/XML", content.id+".xml");
            String url = URL + "outbox/"+ content.id + "/preview/ubl";
            response = httpClient().sendFile(token, url, file);
        }

        return response;
    }

    public String statusEDespathces(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/inbox"+ "/lookup-statuses";
        String response = httpClient().send(token, url, "GET");
        return response;
    }

    public String statusEDespathes_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/outbox"+ "/lookup-statuses";
        String response = httpClient().send(token, url, "GET");
        return response;
    }

}
