package adapter;


import com.google.gson.Gson;
import model.DownloadRequest;
import response.ESmmResponse;
import response.EStorageResponse;

import java.io.IOException;
import java.net.URISyntaxException;

public class EStorageAdapter extends Adapter{

    public String URL = BASE_URL + "/" + VERSION + "/archives" ;
    Adapter adapter = new Adapter();
    EStorageResponse eStorageResponse1;
    EStorageResponse eStorageResponse2;
    EStorageResponse eStorageResponse3;
    EStorageResponse eStorageResponse4;
    EStorageResponse eStorageResponse5;
    EStorageResponse eStorageResponse6;
    EStorageResponse eStorageResponse7;
    EStorageResponse eStorageResponse8;
    public EStorageResponse listEInviocesOutbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "/invoices/outbox?sort=asc&sortProperty=id";
        String response = httpClient().send(token, url);
        eStorageResponse1 = new Gson().fromJson(response, EStorageResponse.class);
        return eStorageResponse1;
    }
    public EStorageResponse listEInviocesInbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "/invoices/inbox?sort=asc&sortProperty=id";
        String response = httpClient().send(token, url);
        eStorageResponse1 = new Gson().fromJson(response, EStorageResponse.class);
        return eStorageResponse5;
    }
    public EStorageResponse listEDespatchesOutbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL+ "/despatches/outbox?sort=asc&sortProperty=id";
        String response = httpClient().send(token, url);
        eStorageResponse2 = new Gson().fromJson(response, EStorageResponse.class);
        return eStorageResponse2;
    }
    public EStorageResponse listEDespatchesInbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL+ "/despatches/inbox?sort=asc&sortProperty=id";
        String response = httpClient().send(token, url);
        eStorageResponse2 = new Gson().fromJson(response, EStorageResponse.class);
        return eStorageResponse2;
    }
    public EStorageResponse listEDespatchReceiptsOutbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "/receipts/outbox?sort=asc&sortProperty=id";
        String response = httpClient().send(token, url);
        eStorageResponse3 = new Gson().fromJson(response, EStorageResponse.class);
        return eStorageResponse3;
    }
    public EStorageResponse listEDespatchReceiptsInbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "/receipts/inbox?sort=asc&sortProperty=id";
        String response = httpClient().send(token, url);
        eStorageResponse3 = new Gson().fromJson(response, EStorageResponse.class);
        return eStorageResponse3;
    }
    public EStorageResponse listECreditnotes(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "/creditnotes?sort=asc&sortProperty=id";
        String response = httpClient().send(token, url);
        eStorageResponse4 = new Gson().fromJson(response, EStorageResponse.class);
        return eStorageResponse4;
    }

    public String downloadXMLEStrogeEInvoiceInbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/invoices/inbox/download/ubl", "EStorage/EInvoice/XML/Inbox/Downloads/");
    }
    public String downloadHTMLEStrogeEInvoiceInbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/invoices/inbox/download/html", "EStorage/EInvoice/HTML/Inbox/Downloads/");
    }
    public String downloadPDFEStrogeEInvoiceInbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/invoices/inbox/download/pdf", "EStorage/EInvoice/PDF/Inbox/Downloads/");
    }


    public String downloadXMLEStrogeEInvoiceOutbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/invoices/outbox/download/ubl", "EStorage/EInvoice/XML/Outbox/Downloads/");
    }
    public String downloadHTMLEStrogeEInvoiceOutbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/invoices/outbox/download/html", "EStorage/EInvoice/HTML/Outbox/Downloads/");
    }
    public String downloadPDFEStrogeEInvoiceOutbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/invoices/outbox/download/pdf", "EStorage/EInvoice/PDF/Outbox/Downloads/");
    }


    public String downloadXMLEStrogeEDespatchesInbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/despatches/inbox/download/ubl", "EStorage/EDespatch/XML/Inbox/Downloads/");
    }
    public String downloadHTMLEStrogeEDespatchesInbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/despatches/inbox/download/html", "EStorage/EDespatch/HTML/Inbox/Downloads/");
    }
    public String downloadPDFEStrogeEDespatchesInbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/despatches/inbox/download/pdf", "EStorage/EDespatch/PDF/Inbox/Downloads/");
    }


    public String downloadXMLEStrogeEDespatchesOutbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/despatches/outbox/download/ubl", "EStorage/EDespatch/XML/Outbox/Downloads/");
    }
    public String downloadHTMLEStrogeEDespatchesOutbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/despatches/outbox/download/html", "EStorage/EDespatch/HTML/Outbox/Downloads/");
    }
    public String downloadPDFEStrogeEDespatchesOutbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/despatches/outbox/download/pdf", "EStorage/EDespatch/PDF/Outbox/Downloads/");
    }


    public String downloadXMLEStrogeEDespatcheReceiptsInbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/receipts/inbox/download/ubl", "EStorage/EDespatchResponse/XML/Inbox/Downloads/");
    }
    public String downloadHTMLEStrogeEDespatcheReceiptsInbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/receipts/inbox/download/html", "EStorage/EDespatchResponse/HTML/Inbox/Downloads/");
    }
    public String downloadPDFEStrogeEDespatcheReceiptsInbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/receipts/inbox/download/pdf", "EStorage/EDespatchResponse/PDF/Inbox/Downloads/");
    }


    public String downloadXMLEStrogeEDespatcheReceiptsOutbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/receipts/outbox/download/ubl", "EStorage/EDespatchResponse/XML/Outbox/Downloads/");
    }
    public String downloadHTMLEStrogeEDespatcheReceiptsOutbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/receipts/outbox/download/html", "EStorage/EDespatchResponse/HTML/Outbox/Downloads/");
    }
    public String downloadPDFEStrogeEDespatcheReceiptsOutbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/receipts/outbox/download/pdf", "EStorage/EDespatchResponse/PDF/Outbox/Downloads/");
    }


    public String downloadXMLEStrogeECreditnotes(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/creditnotes/download/ubl", "CreditNote/XML/Downloads/");
    }
    public String downloadHTMLEStrogeECreditnotes(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/creditnotes/download/html", "CreditNote/HTML/Downloads/");
    }
    public String downloadPDFEStrogeECreditnotes(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/creditnotes/download/pdf", "CreditNote/PDF/Downloads/");
    }


}
