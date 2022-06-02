package adapter;

import model.DownloadRequest;
import response.ECreditNoteResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class ECreditNoteAdapter extends DocumentAdapter<ECreditNoteResponse> {
    public String URL = BASE_URL + "/" + VERSION + "/ecreditnotes" ;

    public ECreditNoteResponse listECreditNote(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return list(token, URL, ECreditNoteResponse.class);
    }
    public ECreditNoteResponse listByCreationDateECreditNote(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"?page=0&pageSize=20&sortProperty=createDate&sort=asc";
        return list(token, url, ECreditNoteResponse.class);
    }
    public String viewPDFECreditNote(String token,  List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return viewDocument(token, URL, idList, "pdf", "PDF", "ECreditNote","" );
    }
    public String viewHTMLECreditNote(String token,  List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return viewDocument(token, URL, idList, "html", "HTML", "ECreditNote","" );
    }
    public String viewXMLECreditNote(String token, List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return viewDocument(token, URL, idList, "ubl", "XML", "ECreditNote","" );
    }
    public String statusECreditNote(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/lookup-statuses";
        return listStatus(token, url);
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
