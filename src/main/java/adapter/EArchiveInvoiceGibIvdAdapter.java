package adapter;

import com.google.gson.Gson;
import model.DownloadRequest;
import response.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;


public class EArchiveInvoiceGibIvdAdapter extends Adapter {
    public String URL = BASE_URL + "/" + VERSION + "/earchives-gib-ivd" ;
    Adapter adapter = new Adapter();
    EArchiveInvoiceGibIvdResponse eArchiveInvoiceGibIvdResponse;
    EArchiveInvoiceGibIvdResponse eArchiveInvoiceGibIvdList;
    EArchiveInvoiceGibIvdResponse eArchiveInvoiceGibIvdResponseOutbox;
    EArchiveInvoiceGibIvdResponse eArchiveInvoiceGibIvdListOutbox;

    public EArchiveInvoiceGibIvdResponse listEArchiveEArchiveInvoiceGibIvd(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "/inbox";
        String response = httpClient().send(token, url);
        eArchiveInvoiceGibIvdResponse = new Gson().fromJson(response, EArchiveInvoiceGibIvdResponse.class);

        return eArchiveInvoiceGibIvdResponse;
    }

    public EArchiveInvoiceGibIvdResponse listByCreationDateEArchiveInvoiceGibIvd(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/inbox?page=0&pageSize=20&sortProperty=createDate&sort=asc";
        String response = httpClient().send(token, url);
        eArchiveInvoiceGibIvdList = new Gson().fromJson(response, EArchiveInvoiceGibIvdResponse.class);//java generic method
        return eArchiveInvoiceGibIvdList;
    }

    public EArchiveInvoiceGibIvdResponse listEArchiveInvoiceGibIvd_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "/outbox";
        String response = httpClient().send(token, url);
        eArchiveInvoiceGibIvdResponseOutbox = new Gson().fromJson(response, EArchiveInvoiceGibIvdResponse.class);

        return eArchiveInvoiceGibIvdResponseOutbox;
    }

    public EArchiveInvoiceGibIvdResponse listByCreationDateEArchiveInvoiceGibIvd_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/outbox?page=0&pageSize=20&sortProperty=createDate&sort=asc";
        String response = httpClient().send(token, url);
        eArchiveInvoiceGibIvdListOutbox = new Gson().fromJson(response, EArchiveInvoiceGibIvdResponse.class);//java generic method
        return eArchiveInvoiceGibIvdListOutbox;
    }
    public String ViewPDFEArchiveInvoiceGibIvd(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEArchiveInvoiceGibIvd content:eArchiveInvoiceGibIvdResponse.contents) {
            File file = new File(PATH + "EArchiveInvoiceGibIvd/Inbox/PDF", content.id+".pdf");
            String url = URL + "inbox/"+ content.id + "/preview/pdf";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewHTMLEArchiveInvoiceGibIvd(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEArchiveInvoiceGibIvd content:eArchiveInvoiceGibIvdResponse.contents) {
            File file = new File(PATH + "EArchiveInvoiceGibIvd/Inbox/HTML", content.id+".html");
            String url = URL + "inbox/"+ content.id + "/preview/html";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewXMLEArchiveInvoiceGibIvd(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEArchiveInvoiceGibIvd content:eArchiveInvoiceGibIvdResponse.contents) {
            File file = new File(PATH + "EArchiveInvoiceGibIvd/Inbox/XML", content.id+".xml");
            String url = URL + "inbox/"+ content.id + "/preview/ubl";
            response = httpClient().sendFile(token, url, file);
        }

        return response;
    }
    public String ViewPDFEArchiveInvoiceGibIvd_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEArchiveInvoiceGibIvd content:eArchiveInvoiceGibIvdResponseOutbox.contents) {
            File file = new File(PATH + "EArchiveInvoiceGibIvd/Outbox/PDF", content.id+".pdf");
            String url = URL + "outbox/"+ content.id + "/preview/pdf";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewHTMLEArchiveInvoiceGibIvd_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {
        String response="";
        for (ContentEArchiveInvoiceGibIvd content:eArchiveInvoiceGibIvdResponseOutbox.contents) {
            File file = new File(PATH + "EArchiveInvoiceGibIvd/Outbox/HTML", content.id+".html");
            String url = URL + "outbox/"+ content.id + "/preview/html";
            response = httpClient().sendFile(token, url, file);
        }

        return response;




    }
    public String ViewXMLEArchiveInvoiceGibIvd_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEArchiveInvoiceGibIvd content:eArchiveInvoiceGibIvdResponseOutbox.contents) {
            File file = new File(PATH + "EArchiveInvoiceGibIvd/Outbox/XML", content.id+".xml");
            String url = URL + "outbox/"+ content.id + "/preview/ubl";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }

    public String statusEArchiveInvoiceGibIvd(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/inbox"+ "/lookup-statuses";
        String response = httpClient().send(token, url);
        return response;
    }

    public String downloadXMLEArchiveInvoiceGibIvd(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/inbox/download/ubl", "EArchiveInvoiceGibIvd_/Inbox/XML/Downloads/");
    }
    public String downloadHTMLEArchiveInvoiceGibIvd(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/inbox/download/html", "EArchiveInvoiceGibIvd_/Inbox/HTML/Downloads/");
    }
    public String downloadPDFEArchiveInvoiceGibIvd(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/inbox/download/pdf", "EArchiveInvoiceGibIvd_/Inbox/PDF/Downloads/");
    }
    public String downloadXMLEArchiveInvoiceGibIvd_Outbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/outbox/download/ubl", "EArchiveInvoiceGibIvd_/Outbox/XML/Downloads/");
    }
    public String downloadHTMLEArchiveInvoiceGibIvd_Outbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/outbox/download/html", "EArchiveInvoiceGibIvd_/Outbox/HTML/Downloads/");
    }
    public String downloadPDFEArchiveInvoiceGibIvd_Outbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/outbox/download/pdf", "EArchiveInvoiceGibIvd_/Outbox/PDF/Downloads/");
    }
}
