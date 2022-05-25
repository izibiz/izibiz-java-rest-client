package EStorageSamples;

import adapter.AuthAdapter;
import adapter.EStorageAdapter;
import model.DownloadRequest;
import model.LoginRequest;
import org.junit.jupiter.api.*;
import response.EStorageResponse;
import java.io.IOException;
import java.net.URISyntaxException;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EStorageSample {
    static EStorageAdapter adapter;
    static EStorageResponse EStorageEInvoiceInbox;
    static EStorageResponse EStorageEInvoiceOutbox;
    static EStorageResponse EStorageEDespatchInbox;
    static EStorageResponse EStorageEDespatchOutbox;
    static EStorageResponse EStorageEDespatchReceiptInbox;
    static EStorageResponse EStorageEDespatchReceiptOutbox;
    static EStorageResponse EStorageECreditNote;
    static adapter.AuthAdapter AuthAdapter;

    static String Token ;


    @BeforeAll
    public static void init() {
        adapter = new EStorageAdapter();
        AuthAdapter = new AuthAdapter();
    }
    @Test
    @Order(1)
    public void login() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        LoginRequest body = new LoginRequest("izibiz-dev","izi321");
        Token = AuthAdapter.login(body);

        Assertions.assertNotNull(Token);
        System.out.println(Token);

    }
    @Test
    @Order(2)
    public void canListEInvoicesInbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EStorageEInvoiceInbox = adapter.listEInvoicesInbox(Token);
        Assertions.assertNotNull(EStorageEInvoiceInbox.getContent()[0]);
        System.out.println(EStorageEInvoiceInbox.getContent()[0].id);

    }
    @Test
    @Order(3)
    public void canListEInvoicesOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EStorageEInvoiceOutbox = adapter.listEInvoicesOutbox(Token);
        Assertions.assertNotNull(EStorageEInvoiceOutbox.getContent()[0]);
        System.out.println(EStorageEInvoiceOutbox.getContent()[0].id);

    }
    @Test
    @Order(4)
    public void canListEDespatchesInbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EStorageEDespatchInbox = adapter.listEDespatchesInbox(Token);
        Assertions.assertNotNull(EStorageEDespatchInbox.getContent()[0]);
        System.out.println(EStorageEDespatchInbox.getContent()[0].id);

    }
    @Test
    @Order(5)
    public void canListEDespatchesOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EStorageEDespatchOutbox = adapter.listEDespatchesOutbox(Token);
        Assertions.assertNotNull(EStorageEDespatchOutbox.getContent()[0]);
        System.out.println(EStorageEDespatchOutbox.getContent()[0].id);

    }
    @Test
    @Order(6)
    public void canListEDespatchReceiptsInbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EStorageEDespatchReceiptInbox = adapter.listEDespatchReceiptsInbox(Token);
        Assertions.assertNotNull(EStorageEDespatchReceiptInbox.getContent()[0]);
        System.out.println(EStorageEDespatchReceiptInbox.getContent()[0].id);

    }
    @Test
    @Order(7)
    public void canListEDespatchReceiptsOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EStorageEDespatchReceiptOutbox = adapter.listEDespatchReceiptsOutbox(Token);
        Assertions.assertNotNull(EStorageEDespatchReceiptOutbox.getContent()[0]);
        System.out.println(EStorageEDespatchReceiptOutbox.getContent()[0].id);

    }
    @Test
    @Order(8)
    public void canListECreditNotes() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EStorageECreditNote = adapter.listECreditNotes(Token);
        Assertions.assertNotNull(EStorageECreditNote.getContent()[0]);
        System.out.println(EStorageECreditNote.getContent()[0].id);

    }

    @Test
    @Order(9)
    public void downloadXMLEStorageEInvoiceInbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EStorageEInvoiceInbox.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EStorageEInvoiceInbox.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadXMLEStorageEInvoicesInbox(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(10)
    public void downloadHTMLEStorageEInvoiceInbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EStorageEInvoiceInbox.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EStorageEInvoiceInbox.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadHTMLEStorageEInvoicesInbox(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(11)
    public void downloadPDFEStorageEInvoiceInbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EStorageEInvoiceInbox.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EStorageEInvoiceInbox.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadPDFEStorageEInvoicesInbox(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }


    @Test
    @Order(12)
    public void downloadXMLEStorageEInvoiceOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EStorageEInvoiceOutbox.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EStorageEInvoiceOutbox.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadXMLEStorageEInvoicesOutbox(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(13)
    public void downloadHTMLEStorageEInvoiceOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EStorageEInvoiceOutbox.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EStorageEInvoiceOutbox.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadHTMLEStorageEInvoicesOutbox(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(14)
    public void downloadPDFEStorageEInvoiceOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EStorageEInvoiceOutbox.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EStorageEInvoiceOutbox.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadPDFEStorageEInvoicesOutbox(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }


    @Test
    @Order(15)
    public void downloadXMLEStorageEDespatchInbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EStorageEDespatchInbox.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EStorageEDespatchInbox.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadXMLEStorageEDespatchesInbox(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(16)
    public void downloadHTMLEStorageEDespatchInbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EStorageEDespatchInbox.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EStorageEDespatchInbox.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadHTMLEStorageEDespatchesInbox(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(17)
    public void downloadPDFEStorageEDespatchInbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EStorageEDespatchInbox.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EStorageEDespatchInbox.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadPDFEStorageEDespatchesInbox(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }


    @Test
    @Order(18)
    public void downloadXMLEStorageEDespatchOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EStorageEInvoiceOutbox.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EStorageEInvoiceOutbox.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadXMLEStorageEDespatchesOutbox(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(19)
    public void downloadHTMLEStorageEDespatchOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EStorageEDespatchOutbox.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EStorageEDespatchOutbox.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadHTMLEStorageEDespatchesOutbox(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(20)
    public void downloadPDFEStorageEDespatchOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EStorageEDespatchOutbox.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EStorageEDespatchOutbox.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadPDFEStorageEDespatchesOutbox(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }


    @Test
    @Order(21)
    public void downloadXMLEStorageEDespatchReceiptInbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EStorageEDespatchReceiptInbox.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EStorageEDespatchReceiptInbox.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadXMLEStorageEDespatchReceiptsInbox(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(22)
    public void downloadHTMLEStorageEDespatchReceiptInbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EStorageEDespatchReceiptInbox.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EStorageEDespatchReceiptInbox.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadHTMLEStorageEDespatchReceiptsInbox(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(23)
    public void downloadPDFEStorageEDespatchReceiptInbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EStorageEDespatchReceiptInbox.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EStorageEDespatchReceiptInbox.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadPDFEStorageEDespatchReceiptsInbox(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }


    @Test
    @Order(24)
    public void downloadXMLEStorageEDespatchReceiptOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EStorageEDespatchReceiptOutbox.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EStorageEDespatchReceiptOutbox.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadXMLEStorageEDespatchReceiptsOutbox(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(25)
    public void downloadHTMLEStorageEDespatchReceiptOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EStorageEDespatchReceiptOutbox.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EStorageEDespatchReceiptOutbox.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadHTMLEStorageEDespatchReceiptsOutbox(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(26)
    public void downloadPDFEStorageEDespatchReceiptOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EStorageEDespatchReceiptOutbox.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EStorageEDespatchReceiptOutbox.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadPDFEStorageEDespatchReceiptsOutbox(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }


    @Test
    @Order(27)
    public void downloadXMLEStorageECreditNote() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EStorageECreditNote.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EStorageECreditNote.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadXMLEStorageECreditNotes(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(28)
    public void downloadHTMLEStorageECreditNote() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EStorageECreditNote.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EStorageECreditNote.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadHTMLEStorageECreditNotes(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(29)
    public void downloadPDFEStorageECreditNote() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EStorageECreditNote.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EStorageECreditNote.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadPDFEStorageECreditNotes(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
}
