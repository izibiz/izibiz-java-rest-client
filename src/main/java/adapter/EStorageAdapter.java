package adapter;

import com.google.gson.Gson;
import model.DownloadRequest;
import response.ESmmResponse;
import response.EStorageResponse;
import java.io.IOException;
import java.net.URISyntaxException;

public class EStorageAdapter extends DocumentAdapter<EStorageResponse>{

    public String URL = BASE_URL + "/" + VERSION + "/archives" ;

    EStorageResponse eStorageResponse;

    public EStorageResponse listEInvoicesOutbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "/invoices/outbox?sort=asc&sortProperty=id";
        return list(token, url, EStorageResponse.class);
    }
    public EStorageResponse listEInvoicesInbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String url = URL + "/invoices/inbox?sort=asc&sortProperty=id";
        return list(token, url, EStorageResponse.class);
    }
    public EStorageResponse listEDespatchesOutbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL+ "/despatches/outbox?sort=asc&sortProperty=id";
        return list(token, url, EStorageResponse.class);
    }
    public EStorageResponse listEDespatchesInbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL+ "/despatches/inbox?sort=asc&sortProperty=id";
        return list(token, url, EStorageResponse.class);
    }
    public EStorageResponse listEDespatchReceiptsOutbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "/receipts/outbox?sort=asc&sortProperty=id";
        return list(token, url, EStorageResponse.class);
    }
    public EStorageResponse listEDespatchReceiptsInbox(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "/receipts/inbox?sort=asc&sortProperty=id";
        return list(token, url, EStorageResponse.class);
    }
    public EStorageResponse listECreditNotes(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL + "/creditnotes?sort=asc&sortProperty=id";
        return list(token, url, EStorageResponse.class);
    }

    public String downloadXMLEStorageEInvoicesInbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/invoices/inbox/download/ubl", "EStorage/EInvoice/XML/Inbox/Downloads/");
    }
    public String downloadHTMLEStorageEInvoicesInbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/invoices/inbox/download/html", "EStorage/EInvoice/HTML/Inbox/Downloads/");
    }
    public String downloadPDFEStorageEInvoicesInbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/invoices/inbox/download/pdf", "EStorage/EInvoice/PDF/Inbox/Downloads/");
    }


    public String downloadXMLEStorageEInvoicesOutbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/invoices/outbox/download/ubl", "EStorage/EInvoice/XML/Outbox/Downloads/");
    }
    public String downloadHTMLEStorageEInvoicesOutbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/invoices/outbox/download/html", "EStorage/EInvoice/HTML/Outbox/Downloads/");
    }
    public String downloadPDFEStorageEInvoicesOutbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/invoices/outbox/download/pdf", "EStorage/EInvoice/PDF/Outbox/Downloads/");
    }


    public String downloadXMLEStorageEDespatchesInbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/despatches/inbox/download/ubl", "EStorage/EDespatch/XML/Inbox/Downloads/");
    }
    public String downloadHTMLEStorageEDespatchesInbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/despatches/inbox/download/html", "EStorage/EDespatch/HTML/Inbox/Downloads/");
    }
    public String downloadPDFEStorageEDespatchesInbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/despatches/inbox/download/pdf", "EStorage/EDespatch/PDF/Inbox/Downloads/");
    }


    public String downloadXMLEStorageEDespatchesOutbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/despatches/outbox/download/ubl", "EStorage/EDespatch/XML/Outbox/Downloads/");
    }
    public String downloadHTMLEStorageEDespatchesOutbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/despatches/outbox/download/html", "EStorage/EDespatch/HTML/Outbox/Downloads/");
    }
    public String downloadPDFEStorageEDespatchesOutbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/despatches/outbox/download/pdf", "EStorage/EDespatch/PDF/Outbox/Downloads/");
    }


    public String downloadXMLEStorageEDespatchReceiptsInbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/receipts/inbox/download/ubl", "EStorage/EDespatchResponse/XML/Inbox/Downloads/");
    }
    public String downloadHTMLEStorageEDespatchReceiptsInbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/receipts/inbox/download/html", "EStorage/EDespatchResponse/HTML/Inbox/Downloads/");
    }
    public String downloadPDFEStorageEDespatchReceiptsInbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/receipts/inbox/download/pdf", "EStorage/EDespatchResponse/PDF/Inbox/Downloads/");
    }


    public String downloadXMLEStorageEDespatchReceiptsOutbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/receipts/outbox/download/ubl", "EStorage/EDespatchResponse/XML/Outbox/Downloads/");
    }
    public String downloadHTMLEStorageEDespatchReceiptsOutbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/receipts/outbox/download/html", "EStorage/EDespatchResponse/HTML/Outbox/Downloads/");
    }
    public String downloadPDFEStorageEDespatchReceiptsOutbox(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/receipts/outbox/download/pdf", "EStorage/EDespatchResponse/PDF/Outbox/Downloads/");
    }


    public String downloadXMLEStorageECreditNotes(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/creditnotes/download/ubl", "EStorage/ECreditNote/XML/Downloads/");
    }
    public String downloadHTMLEStorageECreditNotes(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/creditnotes/download/html", "EStorage/ECreditNote/HTML/Downloads/");
    }
    public String downloadPDFEStorageECreditNotes(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/creditnotes/download/pdf", "EStorage/ECreditNote/PDF/Downloads/");
    }


}
