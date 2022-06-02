package adapter;

import model.DownloadRequest;
import response.EArchiveInvoiceResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;


public class EArchiveInvoiceAdapter extends DocumentAdapter<EArchiveInvoiceResponse> {

    public String URL = BASE_URL + "/" + VERSION + "/earchives/" ;

    public EArchiveInvoiceResponse listEArchiveInvoice(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return list(token, URL, EArchiveInvoiceResponse.class);
    }
    public String ViewPDFEArchiveInvoice(String token,  List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return viewDocument(token, URL, idList, "pdf", "PDF", "EArchiveInvoice", "" );
    }
    public String ViewHTMLEArchiveInvoice(String token,  List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return viewDocument(token, URL, idList, "html", "HTML", "EArchiveInvoice", "" );
    }
    public String viewXMLEArchiveInvoice(String token, List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return viewDocument(token, URL, idList, "ubl", "XML", "EArchiveInvoice", "" );
    }
    public String statusEArchiveInvoice(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/lookup-statuses";
        return listStatus(token, url);
    }
    public String downloadXMLEArchiveInvoice(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/download/ubl", "EArchiveInvoice/XML/Downloads/");
    }
    public String downloadHTMLEArchiveInvoice(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/download/html", "EArchiveInvoice/HTML/Downloads/");
    }
    public String downloadPDFEArchiveInvoice(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/download/pdf", "EArchiveInvoice/PDF/Downloads/");
    }
}
