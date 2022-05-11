package adapter;

import com.fasterxml.jackson.databind.JsonNode;

import com.google.gson.Gson;

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

    public EInvoiceResponse listEInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"inbox?dateType=DELIVERY&status=New&startDate="+ adapter.startDate + "&endDate=" + adapter.endDate + "&page=1&pageSize=20&sort=desc&sortProperty=supplierName";
        String response = httpClient().send(token, url);
        eInvoiceResponseList = new Gson().fromJson(response,EInvoiceResponse.class);//java generic method
        return eInvoiceResponseList;
    }

    public EInvoiceResponse pendingApprovalEinvoices(String token)throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "outbox?page=0&sortProperty=customerName&sort=asc";
        String response = httpClient().send(token, url);
        eInvoiceResponse = new Gson().fromJson(response,EInvoiceResponse.class);
        return eInvoiceResponse;
    }

    public EInvoiceResponse approvalExpiredEInvoices(String token)throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "inbox?status=ResponseTimeExpired&page=0&pageSize=100&sortProperty=createDate&sort=asc";
        String response = httpClient().send(token, url);
        eInvoiceResponse = new Gson().fromJson(response,EInvoiceResponse.class);
        return eInvoiceResponse;
    }

    public EInvoiceResponse UndeliverableAnswerEInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "inbox?status=ResponseUnDelivered&dateType=DELIVERY&startDate="+ adapter.startDate + "&endDate="+ adapter.endDate+ "&pageSize=100&sortProperty=createDate&sort=asc";
        String response = httpClient().send(token, url);
        eInvoiceResponse = new Gson().fromJson(response,EInvoiceResponse.class);

        return eInvoiceResponse;

    }

    public EInvoiceResponse RejectedEInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "inbox?status=Rejected&dateType=DELIVERY&startDate="+ adapter.startDate + "&endDate="+ adapter.endDate+ "&page=0&pageSize=100&sortProperty=createDate&sort=asc";
        String response = httpClient().send(token, url);
        eInvoiceResponse = new Gson().fromJson(response,EInvoiceResponse.class);
        return eInvoiceResponse;

    }

    //public EInvoiceResponse StatusInquiryEInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{
    public String StatusInquiryEInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String response="";
        for (Content content:eInvoiceResponseList.contents) {
            String url = URL + "inbox/" + content.id;
            response = httpClient().send(token, url);
        }
        return response;

    }

    public String ViewPDFEInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (Content content:eInvoiceResponseList.contents) {
            File file = new File(PATH + "EInvoice/Inbox/PDF", content.id+".pdf");
            String url = URL + "inbox/"+ content.id + "/preview/pdf";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewHTMLEInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (Content content:eInvoiceResponseList.contents) {
            File file = new File(PATH + "EInvoice/Inbox/HTML", content.id+".html");
            String url = URL + "inbox/"+ content.id + "/preview/html";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewXMLEInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (Content content:eInvoiceResponseList.contents) {
            File file = new File(PATH + "EInvoice/Inbox/XML", content.id+".xml");
            String url = URL + "inbox/"+ content.id + "/preview/ubl";
            response = httpClient().sendFile(token, url, file);
        }

        return response;
    }

    public EInvoiceResponse listEInvoices_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"outbox?dateType=DELIVERY&status=New&startDate="+ adapter.startDate + "&endDate=" + adapter.endDate + "&page=1&pageSize=20&sort=desc&sortProperty=supplierName";
        String response = httpClient().send(token, url);
        eInvoiceResponseList_outbox = new Gson().fromJson(response,EInvoiceResponse.class);//java generic method
        return eInvoiceResponseList_outbox;
    }

    public EInvoiceResponse pendingApprovalEinvoices_Outbox(String token)throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "outbox?status=WaitingForResponse&page=0&pageSize=100&sortProperty=createDate&sort=asc";
        String response = httpClient().send(token, url);
        eInvoiceResponse = new Gson().fromJson(response,EInvoiceResponse.class);

        return eInvoiceResponse;
    }

    public EInvoiceResponse approvalExpiredEInvoices_Outbox(String token)throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "outbox?status=ResponseTimeExpired&page=0&pageSize=100&sortProperty=createDate&sort=asc";
        String response = httpClient().send(token, url);
        eInvoiceResponse = new Gson().fromJson(response,EInvoiceResponse.class);
        return eInvoiceResponse;
    }

    public EInvoiceResponse UndeliverableAnswerEInvoices_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "outbox?status=UnDelivered&dateType=DELIVERY&startDate="+adapter.startDate+"&endDate="+adapter.endDate+"&pageSize=100&sortProperty=createDate&sort=asc";
        String response = httpClient().send(token, url);
        eInvoiceResponse = new Gson().fromJson(response,EInvoiceResponse.class);
        return eInvoiceResponse;

    }

    public EInvoiceResponse RejectedEInvoices_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "outbox?status=Rejected&dateType=DELIVERY&startDate="+adapter.startDate+"&endDate="+adapter.endDate+"&page=0&pageSize=100&sortProperty=createDate&sort=asc";
        String response = httpClient().send(token, url);
        eInvoiceResponse = new Gson().fromJson(response,EInvoiceResponse.class);
        return eInvoiceResponse;

    }
    public String ViewPDFEInvoices_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (Content content:eInvoiceResponseList_outbox.contents) {
            File file = new File(PATH + "EInvoice/Outbox/PDF", content.id+".pdf");
            String url = URL + "outbox/"+ content.id + "/preview/pdf";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewHTMLEInvoices_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {
        String response="";
        for (Content content:eInvoiceResponseList_outbox.contents) {
            File file = new File(PATH + "EInvoice/Outbox/HTML", content.id+".html");
            String url = URL + "outbox/"+ content.id + "/preview/html";
            response = httpClient().sendFile(token, url, file);
        }

        return response;




    }
    public String ViewXMLEInvoices_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (Content content:eInvoiceResponseList_outbox.contents) {
            File file = new File(PATH + "EInvoice/Outbox/XML", content.id+".xml");
            String url = URL + "outbox/"+ content.id + "/preview/ubl";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }

    public String statusEInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/inbox"+ "/lookup-statuses";
        String response = httpClient().send(token, url);
        return response;
    }

    public String statusEInvoices_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/outbox"+ "/lookup-statuses";
        String response = httpClient().send(token, url);
        return response;
    }

}
