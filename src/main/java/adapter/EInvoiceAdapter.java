package adapter;

import model.DownloadRequest;
import response.EInvoiceResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class EInvoiceAdapter extends DocumentAdapter<EInvoiceResponse> {
    public String URL = BASE_URL + "/" + VERSION + "/einvoices/" ;
    Adapter adapter = new Adapter();

    public EInvoiceResponse listEInvoice(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"inbox?dateType=DELIVERY&status=New&startDate="+ adapter.startDate + "&endDate=" + adapter.endDate + "&page=1&pageSize=20&sort=desc&sortProperty=supplierName";
        return list(token, url, EInvoiceResponse.class);
    }

    public EInvoiceResponse pendingApprovalEInvoice(String token)throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "outbox?page=0&sortProperty=customerName&sort=asc";
        return list(token, url, EInvoiceResponse.class);
    }

    public EInvoiceResponse approvalExpiredEInvoice(String token)throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "inbox?status=ResponseTimeExpired&page=0&pageSize=100&sortProperty=createDate&sort=asc";
        return list(token, url, EInvoiceResponse.class);
    }

    public EInvoiceResponse UndeliverableAnswerEInvoice(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "inbox?status=ResponseUnDelivered&dateType=DELIVERY&startDate="+ adapter.startDate + "&endDate="+ adapter.endDate+ "&pageSize=100&sortProperty=createDate&sort=asc";
        return list(token, url, EInvoiceResponse.class);

    }

    public EInvoiceResponse RejectedEInvoice(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "inbox?status=Rejected&dateType=DELIVERY&startDate="+ adapter.startDate + "&endDate="+ adapter.endDate+ "&page=0&pageSize=100&sortProperty=createDate&sort=asc";
        return list(token, url, EInvoiceResponse.class);

    }

    public String statusInquiryEInvoice(String token, List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return statusInquiry(token, URL, idList,"inbox" );
    }

    public String viewPDFEInvoice(String token,  List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return viewDocument(token, URL, idList, "pdf", "PDF", "EInvoice","inbox" );
    }
    public String viewHTMLEInvoice(String token,  List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return viewDocument(token, URL, idList, "html", "HTML", "EInvoice","inbox" );
    }
    public String viewXMLEInvoice(String token, List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return viewDocument(token, URL, idList, "ubl", "XML", "EInvoice","inbox" );
    }

    public EInvoiceResponse listEInvoice_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"outbox?dateType=DELIVERY&status=New&startDate="+ adapter.startDate + "&endDate=" + adapter.endDate + "&page=1&pageSize=20&sort=desc&sortProperty=supplierName";
        return list(token, url, EInvoiceResponse.class);
    }

    public EInvoiceResponse pendingApprovalEInvoice_Outbox(String token)throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "outbox?status=WaitingForResponse&page=0&pageSize=100&sortProperty=createDate&sort=asc";
        return list(token, url, EInvoiceResponse.class);
    }

    public EInvoiceResponse approvalExpiredEInvoice_Outbox(String token)throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "outbox?status=ResponseTimeExpired&page=0&pageSize=100&sortProperty=createDate&sort=asc";
        return list(token, url, EInvoiceResponse.class);
    }

    public EInvoiceResponse UndeliverableAnswerEInvoice_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "outbox?status=UnDelivered&dateType=DELIVERY&startDate="+adapter.startDate+"&endDate="+adapter.endDate+"&pageSize=100&sortProperty=createDate&sort=asc";
        return list(token, url, EInvoiceResponse.class);

    }

    public EInvoiceResponse RejectedEInvoice_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "outbox?status=Rejected&dateType=DELIVERY&startDate="+adapter.startDate+"&endDate="+adapter.endDate+"&page=0&pageSize=100&sortProperty=createDate&sort=asc";
        return list(token, url, EInvoiceResponse.class);

    }
    public String viewPDFEInvoice_outbox(String token,  List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return viewDocument(token, URL, idList, "pdf", "PDF", "EInvoice","outbox" );
    }
    public String viewHTMLEInvoice_outbox(String token,  List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return viewDocument(token, URL, idList, "html", "HTML", "EInvoice","outbox" );
    }
    public String viewXMLEInvoice_outbox(String token, List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return viewDocument(token, URL, idList, "ubl", "XML", "EInvoice","outbox" );
    }

    public String statusEInvoice(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/inbox"+ "/lookup-statuses";
        return listStatus(token, url);
    }

    public String statusEInvoice_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/outbox"+ "/lookup-statuses";
        return listStatus(token, url);
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
