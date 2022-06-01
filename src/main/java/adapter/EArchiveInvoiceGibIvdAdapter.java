package adapter;

import com.google.gson.Gson;
import model.DownloadRequest;
import response.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class EArchiveInvoiceGibIvdAdapter extends DocumentAdapter<EArchiveInvoiceGibIvdResponse> {
    public String URL = BASE_URL + "/" + VERSION + "/earchives-gib-ivd" ;
    Adapter adapter = new Adapter();
    EArchiveInvoiceGibIvdResponse eArchiveInvoiceGibIvdResponse;
    EArchiveInvoiceGibIvdResponse eArchiveInvoiceGibIvdList;
    EArchiveInvoiceGibIvdResponse eArchiveInvoiceGibIvdResponseOutbox;
    EArchiveInvoiceGibIvdResponse eArchiveInvoiceGibIvdListOutbox;

    public EArchiveInvoiceGibIvdResponse listEArchiveInvoiceGibIvd(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "/inbox";
        return list(token, url, EArchiveInvoiceGibIvdResponse.class);
    }

    public EArchiveInvoiceGibIvdResponse listByCreationDateEArchiveInvoiceGibIvd(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/inbox?page=0&pageSize=20&sortProperty=createDate&sort=asc";
        return list(token, url, EArchiveInvoiceGibIvdResponse.class);
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
    public String ViewPDFEArchiveInvoiceGibIvd(String token,  List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return view(token, URL, idList, "pdf", "PDF", "EArchiveInvoiceGibIvd","inbox" );
    }
    public String ViewHTMLEArchiveInvoiceGibIvd(String token,  List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return view(token, URL, idList, "html", "HTML", "EArchiveInvoiceGibIvd","inbox" );
    }
    public String viewXMLEArchiveInvoiceGibIvd(String token, List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return view(token, URL, idList, "ubl", "XML", "EArchiveInvoiceGibIvd","inbox" );
    }
    public String viewPDFEArchiveInvoiceGibIvd_outbox(String token,  List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return view(token, URL, idList, "pdf", "PDF", "EArchiveInvoiceGibIvd", "outbox" );
    }
    public String viewHTMLEArchiveInvoiceGibIvd_outbox(String token,  List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return view(token, URL, idList, "html", "HTML", "EArchiveInvoiceGibIvd","outbox" );
    }
    public String viewXMLEArchiveInvoiceGibIvd_outbox(String token, List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return view(token, URL, idList, "ubl", "XML", "EArchiveInvoiceGibIvd","outbox" );
    }

    public String statusEArchiveInvoiceGibIvd(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/lookup-statuses";
        return listStatus(token, url);
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
