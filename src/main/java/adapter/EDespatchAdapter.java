package adapter;

import model.DownloadRequest;
import response.EDespatchResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;


public class EDespatchAdapter extends DocumentAdapter<EDespatchResponse> {
    public String URL = BASE_URL + "/" + VERSION + "/edespatches/" ;


    public EDespatchResponse listEDespatch(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return list(token, URL, EDespatchResponse.class);
    }

    public String statusInquiryEDespatch(String token, List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return statusInquiry(token, URL, idList,"inbox" );
    }

    public String viewPDFEDespatch(String token,  List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return viewDocument(token, URL, idList, "pdf", "PDF", "EDespatch","inbox" );
    }
    public String viewHTMLEDespatch(String token,  List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return viewDocument(token, URL, idList, "html", "HTML", "EDespatch","inbox" );
    }
    public String viewXMLEDespatch(String token, List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return viewDocument(token, URL, idList, "ubl", "XML", "EDespatch","inbox" );
    }
    public EDespatchResponse listEDespatch_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "outbox?status=WaitingForResponse&page=0&pageSize=100&sortProperty=createDate&sort=asc" ;
        return list(token, url, EDespatchResponse.class);
    }
    public String viewPDFEDespatch_outbox(String token,  List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return viewDocument(token, URL, idList, "pdf", "PDF", "EDespatch","outbox" );
    }
    public String viewHTMLEDespatch_outbox(String token,  List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return viewDocument(token, URL, idList, "html", "HTML", "EDespatch","outbox" );
    }
    public String viewXMLEDespatch_outbox(String token, List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return viewDocument(token, URL, idList, "ubl", "XML", "EDespatch","outbox" );
    }
    public String statusEDespatch(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/inbox"+ "/lookup-statuses";
        return listStatus(token, url);
    }

    public String statusEDespatch_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/outbox"+ "/lookup-statuses";
        return listStatus(token, url);
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
