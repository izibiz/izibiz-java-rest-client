package adapter;

import com.google.gson.Gson;
import model.DownloadRequest;
import response.ContentECreditNote;
import response.ContentESmm;
import response.ECreditNoteResponse;
import response.ESmmResponse;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class ECreditNoteAdapter extends Adapter {
    public String URL = BASE_URL + "/" + VERSION + "/ecreditnotes" ;
    Adapter adapter = new Adapter();
    ECreditNoteResponse eCreditNoteResponseList;
    ECreditNoteResponse eCreditNoteResponseList_outbox;
    ECreditNoteResponse eCreditNoteResponse;
    public ECreditNoteResponse listECreditNote(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL;
        String response = httpClient().send(token, url);
        eCreditNoteResponseList = new Gson().fromJson(response, ECreditNoteResponse.class);
        return eCreditNoteResponseList;
    }
    public ECreditNoteResponse listByCreationDateECreditNote(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"?page=0&pageSize=20&sortProperty=createDate&sort=asc";
        String response = httpClient().send(token, url);
        eCreditNoteResponseList = new Gson().fromJson(response, ECreditNoteResponse.class);
        return eCreditNoteResponseList;
    }
    public String ViewPDFECreditNote(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentECreditNote content:eCreditNoteResponseList.contents) {
            File file = new File(PATH + "ECreditNote/PDF", content.id+".pdf");
            String url = URL + "/"+ content.id + "/preview/pdf";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewHTMLECreditNote(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentECreditNote content:eCreditNoteResponseList.contents) {
            File file = new File(PATH + "ECreditNote/HTML", content.id+".html");
            String url = URL + "/"+ content.id + "/preview/html";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewXMLECreditNote(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentECreditNote content:eCreditNoteResponseList.contents) {
            File file = new File(PATH + "ECreditNote/XML", content.id+".xml");
            String url = URL + "/"+ content.id + "/preview/ubl";
            response = httpClient().sendFile(token, url, file);
        }

        return response;
    }
    public String statusECreditNote(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/lookup-statuses";
        String response = httpClient().send(token, url);
        return response;
    }
    public String downloadXMLECreditNote(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/download/ubl", "ECreditNote/XML/Downloads/");
    }
    public String downloadHTMLECreditNote(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/download/html", "ECreditNote/HTML/Downloads/");
    }
    public String downloadPDFECreditNote(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/download/pdf", "ECreditNote/PDF/Downloads/");
    }
}
