package adapter;

import com.google.gson.Gson;
import model.DownloadRequest;
import response.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class EDespatchReceiptAdapter extends Adapter{
    public String URL = BASE_URL + "/" + VERSION + "/edespatch-responses/" ;
    Adapter adapter = new Adapter();
    EDespatchReceiptResponse eDespatchReceiptResponse;
    EDespatchReceiptResponse eDespatchReceiptResponseList;
    EDespatchReceiptResponse eDespatchReceiptResponseList_outbox;

    public EDespatchReceiptResponse listEDespatchReceipt(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"inbox?dateType=DELIVERY&&status=New&startDate=" + adapter.startDate +"&endDate="+ adapter.endDate +"&page=1&pageSize=20&sort=desc&sortProperty=supplierName";
        String response = httpClient().send(token, url);
        eDespatchReceiptResponseList = new Gson().fromJson(response, EDespatchReceiptResponse.class);
        return eDespatchReceiptResponseList;
    }

    public String StatusInquiryEDespatchReceipt(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String response="";
        for (ContentEDespatchReceipt content:eDespatchReceiptResponseList.contents) {
            String url = URL + "inbox/" + content.id;
            response = httpClient().send(token, url);
        }
        return response;
    }

    public String ViewPDFEDespatchReceipt(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEDespatchReceipt content:eDespatchReceiptResponseList.contents) {
            File file = new File(PATH + "EDespatchResponse/Inbox/PDF", content.id+".pdf");
            String url = URL + "inbox/"+ content.id + "/preview/pdf";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewHTMLEDespatchReceipt(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEDespatchReceipt content:eDespatchReceiptResponseList.contents) {
            File file = new File(PATH + "EDespatchResponse/Inbox/HTML", content.id+".html");
            String url = URL + "inbox/"+ content.id + "/preview/html";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewXMLEDespatchReceipt(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

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
        String response = httpClient().send(token, url);
        eDespatchReceiptResponseList_outbox = new Gson().fromJson(response, EDespatchReceiptResponse.class);
        return eDespatchReceiptResponseList_outbox;
    }

    public String ViewPDFEDespatchReceipt_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEDespatchReceipt content:eDespatchReceiptResponseList_outbox.contents) {
            File file = new File(PATH + "EDespatchResponse/Outbox/PDF", content.id+".pdf");
            String url = URL + "outbox/"+ content.id + "/preview/pdf";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewHTMLEDespatchReceipt_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEDespatchReceipt content:eDespatchReceiptResponseList_outbox.contents) {
            File file = new File(PATH + "EDespatchResponse/Outbox/HTML", content.id+".html");
            String url = URL + "outbox/"+ content.id + "/preview/html";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewXMLEDespatchReceipt_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEDespatchReceipt content:eDespatchReceiptResponseList_outbox.contents) {
            File file = new File(PATH + "EDespatchResponse/Outbox/XML", content.id+".xml");
            String url = URL + "outbox/"+ content.id + "/preview/ubl";
            response = httpClient().sendFile(token, url, file);
        }

        return response;
    }

    public String statusEDespatchReceipt(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/inbox"+ "/lookup-statuses";
        String response = httpClient().send(token, url);
        return response;
    }

    public String statusEDespatchReceipt_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/outbox"+ "/lookup-statuses";
        String response = httpClient().send(token, url);
        return response;
    }
    public String downloadXMLEDespatchReceipt(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/inbox/download/ubl", "EDespatchResponse/Inbox/XML/Downloads/");
    }
    public String downloadHTMLEDespatchReceipt(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/inbox/download/html", "EDespatchResponse/Inbox/HTML/Downloads/");
    }
    public String downloadPDFEDespatchReceipt(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/inbox/download/pdf", "EDespatchResponse/Inbox/PDF/Downloads/");
    }
    public String downloadXMLEDespatchReceipt_Outbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/outbox/download/ubl", "EDespatchResponse/Outbox/XML/Downloads/");
    }
    public String downloadHTMLEDespatchReceipt_Outbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/outbox/download/html", "EDespatchResponse/Outbox/HTML/Downloads/");
    }
    public String downloadPDFEDespatchReceipt_Outbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/outbox/download/pdf", "EDespatchResponse/Outbox/PDF/Downloads/");
    }
}
