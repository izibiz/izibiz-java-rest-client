package adapter;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import response.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;

public class EDespatchReceiptAdapter extends Adapter{
    public String URL = BASE_URL + "/" + VERSION + "/edespatch-responses/" ;
    Adapter adapter = new Adapter();
    EDespatchReceiptResponse eDespatchReceiptResponse;
    EDespatchReceiptResponse eDespatchReceiptResponseList;
    EDespatchReceiptResponse eDespatchReceiptResponseList_outbox;

    public EDespatchReceiptResponse listEDespatchesReceipt(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"inbox?dateType=DELIVERY&&status=New&startDate=" + adapter.startDate +"&endDate="+ adapter.endDate +"&page=1&pageSize=20&sort=desc&sortProperty=supplierName";
        String response = httpClient().send(token, url, "GET");
        eDespatchReceiptResponseList = new Gson().fromJson(response, EDespatchReceiptResponse.class);//java generic method
        return eDespatchReceiptResponseList;
    }

    public String StatusInquiryEDespatchesReceipt(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String response="";
        for (ContentEDespatchReceipt content:eDespatchReceiptResponseList.contents) {
            String url = URL + "inbox/" + content.id;
            response = httpClient().send(token, url, "GET");
        }
        return response;
    }

    public String ViewPDFEDespatchesReceipt(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEDespatchReceipt content:eDespatchReceiptResponseList.contents) {
            File file = new File(PATH + "EDespatchResponse/Inbox/PDF", content.id+".pdf");
            String url = URL + "inbox/"+ content.id + "/preview/pdf";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewHTMLEDespatchesReceipt(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEDespatchReceipt content:eDespatchReceiptResponseList.contents) {
            File file = new File(PATH + "EDespatchResponse/Inbox/HTML", content.id+".html");
            String url = URL + "inbox/"+ content.id + "/preview/html";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewXMLEDespatchesReceipt(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEDespatchReceipt content:eDespatchReceiptResponseList.contents) {
            File file = new File(PATH + "EDespatchResponse/Inbox/XML", content.id+".xml");
            String url = URL + "inbox/"+ content.id + "/preview/ubl";
            response = httpClient().sendFile(token, url, file);
        }

        return response;
    }

    public EDespatchReceiptResponse listEDespatchReceipts_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"outbox?status=WaitingForResponse&page=0&pageSize=100&sortProperty=createDate&sort=asc";
        String response = httpClient().send(token, url, "GET");
        eDespatchReceiptResponseList_outbox = new Gson().fromJson(response, EDespatchReceiptResponse.class);//java generic method
        return eDespatchReceiptResponseList_outbox;
    }

    public String ViewPDFEDespatchesReceipt_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEDespatchReceipt content:eDespatchReceiptResponseList_outbox.contents) {
            File file = new File(PATH + "EDespatchResponse/Outbox/PDF", content.id+".pdf");
            String url = URL + "outbox/"+ content.id + "/preview/pdf";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewHTMLEDespatchesReceipt_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEDespatchReceipt content:eDespatchReceiptResponseList_outbox.contents) {
            File file = new File(PATH + "EDespatchResponse/Outbox/HTML", content.id+".html");
            String url = URL + "outbox/"+ content.id + "/preview/html";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewXMLEDespatchesReceipt_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEDespatchReceipt content:eDespatchReceiptResponseList_outbox.contents) {
            File file = new File(PATH + "EDespatchResponse/Outbox/XML", content.id+".xml");
            String url = URL + "outbox/"+ content.id + "/preview/ubl";
            response = httpClient().sendFile(token, url, file);
        }

        return response;
    }

    public String statusEDespathcesReceipt(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/inbox"+ "/lookup-statuses";
        String response = httpClient().send(token, url, "GET");
        return response;
    }

    public String statusEDespathesReceipt_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/outbox"+ "/lookup-statuses";
        String response = httpClient().send(token, url, "GET");
        return response;
    }
}
