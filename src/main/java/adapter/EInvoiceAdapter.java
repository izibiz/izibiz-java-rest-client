package adapter;

import com.fasterxml.jackson.databind.JsonNode;

import com.google.gson.Gson;

import model.DownloadRequest;
import response.Content;
import response.EInvoiceResponse;


import java.io.File;

import java.io.IOException;

import java.net.URISyntaxException;

public class EInvoiceAdapter extends Adapter {
    public String URL = BASE_URL + "/" + VERSION + "/einvoices/" ;
    Adapter adapter = new Adapter();
    EInvoiceResponse eInvoiceResponseList;
    EInvoiceResponse eInvoiceResponseList_outbox;
    EInvoiceResponse eInvoiceResponse;

    public EInvoiceResponse listEInvoice(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"inbox?dateType=DELIVERY&status=New&startDate="+ adapter.startDate + "&endDate=" + adapter.endDate + "&page=1&pageSize=20&sort=desc&sortProperty=supplierName";
        String response = httpClient().send(token, url);
        eInvoiceResponseList = new Gson().fromJson(response,EInvoiceResponse.class);//java generic method
        return eInvoiceResponseList;
    }

    public EInvoiceResponse pendingApprovalEinvoice(String token)throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "outbox?page=0&sortProperty=customerName&sort=asc";
        String response = httpClient().send(token, url);
        eInvoiceResponse = new Gson().fromJson(response,EInvoiceResponse.class);
        return eInvoiceResponse;
    }

    public EInvoiceResponse approvalExpiredEInvoice(String token)throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "inbox?status=ResponseTimeExpired&page=0&pageSize=100&sortProperty=createDate&sort=asc";
        String response = httpClient().send(token, url);
        eInvoiceResponse = new Gson().fromJson(response,EInvoiceResponse.class);
        return eInvoiceResponse;
    }

    public EInvoiceResponse UndeliverableAnswerEInvoice(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "inbox?status=ResponseUnDelivered&dateType=DELIVERY&startDate="+ adapter.startDate + "&endDate="+ adapter.endDate+ "&pageSize=100&sortProperty=createDate&sort=asc";
        String response = httpClient().send(token, url);
        eInvoiceResponse = new Gson().fromJson(response,EInvoiceResponse.class);

        return eInvoiceResponse;

    }

    public EInvoiceResponse RejectedEInvoice(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "inbox?status=Rejected&dateType=DELIVERY&startDate="+ adapter.startDate + "&endDate="+ adapter.endDate+ "&page=0&pageSize=100&sortProperty=createDate&sort=asc";
        String response = httpClient().send(token, url);
        eInvoiceResponse = new Gson().fromJson(response,EInvoiceResponse.class);
        return eInvoiceResponse;

    }

    //public EInvoiceResponse StatusInquiryEInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{
    public String StatusInquiryEInvoice(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String response="";
        for (Content content:eInvoiceResponseList.contents) {
            String url = URL + "inbox/" + content.id;
            response = httpClient().send(token, url);
        }
        return response;

    }

    public String ViewPDFEInvoice(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (Content content:eInvoiceResponseList.contents) {
            File file = new File(PATH + "EInvoice/Inbox/PDF", content.id+".pdf");
            String url = URL + "inbox/"+ content.id + "/preview/pdf";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewHTMLEInvoice(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (Content content:eInvoiceResponseList.contents) {
            File file = new File(PATH + "EInvoice/Inbox/HTML", content.id+".html");
            String url = URL + "inbox/"+ content.id + "/preview/html";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewXMLEInvoice(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (Content content:eInvoiceResponseList.contents) {
            File file = new File(PATH + "EInvoice/Inbox/XML", content.id+".xml");
            String url = URL + "inbox/"+ content.id + "/preview/ubl";
            response = httpClient().sendFile(token, url, file);
        }

        return response;
    }

    public EInvoiceResponse listEInvoice_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"outbox?dateType=DELIVERY&status=New&startDate="+ adapter.startDate + "&endDate=" + adapter.endDate + "&page=1&pageSize=20&sort=desc&sortProperty=supplierName";
        String response = httpClient().send(token, url);
        eInvoiceResponseList_outbox = new Gson().fromJson(response,EInvoiceResponse.class);//java generic method
        return eInvoiceResponseList_outbox;
    }

    public EInvoiceResponse pendingApprovalEinvoice_Outbox(String token)throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "outbox?status=WaitingForResponse&page=0&pageSize=100&sortProperty=createDate&sort=asc";
        String response = httpClient().send(token, url);
        eInvoiceResponse = new Gson().fromJson(response,EInvoiceResponse.class);

        return eInvoiceResponse;
    }

    public EInvoiceResponse approvalExpiredEInvoice_Outbox(String token)throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "outbox?status=ResponseTimeExpired&page=0&pageSize=100&sortProperty=createDate&sort=asc";
        String response = httpClient().send(token, url);
        eInvoiceResponse = new Gson().fromJson(response,EInvoiceResponse.class);
        return eInvoiceResponse;
    }

    public EInvoiceResponse UndeliverableAnswerEInvoice_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "outbox?status=UnDelivered&dateType=DELIVERY&startDate="+adapter.startDate+"&endDate="+adapter.endDate+"&pageSize=100&sortProperty=createDate&sort=asc";
        String response = httpClient().send(token, url);
        eInvoiceResponse = new Gson().fromJson(response,EInvoiceResponse.class);
        return eInvoiceResponse;

    }

    public EInvoiceResponse RejectedEInvoice_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "outbox?status=Rejected&dateType=DELIVERY&startDate="+adapter.startDate+"&endDate="+adapter.endDate+"&page=0&pageSize=100&sortProperty=createDate&sort=asc";
        String response = httpClient().send(token, url);
        eInvoiceResponse = new Gson().fromJson(response,EInvoiceResponse.class);
        return eInvoiceResponse;

    }
    public String ViewPDFEInvoice_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (Content content:eInvoiceResponseList_outbox.contents) {
            File file = new File(PATH + "EInvoice/Outbox/PDF", content.id+".pdf");
            String url = URL + "outbox/"+ content.id + "/preview/pdf";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewHTMLEInvoice_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {
        String response="";
        for (Content content:eInvoiceResponseList_outbox.contents) {
            File file = new File(PATH + "EInvoice/Outbox/HTML", content.id+".html");
            String url = URL + "outbox/"+ content.id + "/preview/html";
            response = httpClient().sendFile(token, url, file);
        }

        return response;




    }
    public String ViewXMLEInvoice_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (Content content:eInvoiceResponseList_outbox.contents) {
            File file = new File(PATH + "EInvoice/Outbox/XML", content.id+".xml");
            String url = URL + "outbox/"+ content.id + "/preview/ubl";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }

    public String statusEInvoice(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/inbox"+ "/lookup-statuses";
        String response = httpClient().send(token, url);
        return response;
    }

    public String statusEInvoice_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/outbox"+ "/lookup-statuses";
        String response = httpClient().send(token, url);
        return response;
    }
    public String downloadXMLEInvoice(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/inbox/download/ubl", "EInvoice/Inbox/XML/Downloads/");
    }
    public String downloadHTMLEInvoice(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/inbox/download/html", "EInvoice/Inbox/HTML/Downloads/");
    }
    public String downloadPDFEInvoice(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/inbox/download/pdf", "EInvoice/Inbox/PDF/Downloads/");
    }
    public String downloadXMLEInvoice_Outbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/outbox/download/ubl", "EInvoice/Outbox/XML/Downloads/");
    }
    public String downloadHTMLEInvoice_Outbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/outbox/download/html", "EInvoice/Outbox/HTML/Downloads/");
    }
    public String downloadPDFEInvoice_Outbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/outbox/download/pdf", "EInvoice/Outbox/PDF/Downloads/");
    }

}
