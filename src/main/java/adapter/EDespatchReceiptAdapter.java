package adapter;

import model.DownloadRequest;
import response.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class EDespatchReceiptAdapter extends DocumentAdapter<EDespatchReceiptResponse>{
    public String URL = BASE_URL + "/" + VERSION + "/edespatch-responses/" ;
    Adapter adapter = new Adapter();

    public EDespatchReceiptResponse listEDespatchReceipt(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"inbox?dateType=DELIVERY&&status=New&startDate=" + adapter.startDate +"&endDate="+ adapter.endDate +"&page=1&pageSize=20&sort=desc&sortProperty=supplierName";
        return list(token, url, EDespatchReceiptResponse.class);
    }

    public String statusInquiryEDespatchReceipt(String token, List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return statusInquiry(token, URL, idList,"inbox" );
    }

    public String viewPDFEDespatchReceipt(String token,  List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return viewDocument(token, URL, idList, "pdf", "PDF", "EDespatchReceipt","inbox" );
    }
    public String viewHTMLEDespatchReceipt(String token,  List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return viewDocument(token, URL, idList, "html", "HTML", "EDespatchReceipt","inbox" );
    }
    public String viewXMLEDespatchReceipt(String token, List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return viewDocument(token, URL, idList, "ubl", "XML", "EDespatchReceipt","inbox" );
    }

    public EDespatchReceiptResponse listEDespatchReceipts_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"outbox?status=WaitingForResponse&page=0&pageSize=100&sortProperty=createDate&sort=asc";
        return list(token, url, EDespatchReceiptResponse.class);
    }

    public String viewPDFEDespatchReceipt_outbox(String token,  List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return viewDocument(token, URL, idList, "pdf", "PDF", "EDespatchReceipt","outbox" );
    }
    public String viewHTMLEDespatchReceipt_outbox(String token,  List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return viewDocument(token, URL, idList, "html", "HTML", "EDespatchReceipt","outbox" );
    }
    public String viewXMLEDespatchReceipt_outbox(String token, List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return viewDocument(token, URL, idList, "ubl", "XML", "EDespatchReceipt","outbox" );
    }

    public String statusEDespatchReceipt(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/inbox"+ "/lookup-statuses";
        return listStatus(token, url);
    }

    public String statusEDespatchReceipt_Outbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/outbox"+ "/lookup-statuses";
        return listStatus(token, url);
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
