package EInvoiceSamples;

import adapter.AuthAdapter;
import adapter.EInvoiceAdapter;
import model.DownloadRequest;
import model.LoginRequest;
import org.junit.jupiter.api.*;
import response.EInvoiceResponse;
import sample.auth.AuthSample;

import java.io.IOException;
import java.net.URISyntaxException;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EInvoiceSample {
    static EInvoiceAdapter adapter;
    static EInvoiceResponse EInvoice;
    static EInvoiceResponse EInvoiceList;
    static EInvoiceResponse EInvoiceOutbox;
    static AuthAdapter AuthAdapter;

    static String Token ;
    public static String list;

    @BeforeAll
    public static void init() {
        //     AuthSample authSample= new AuthSample();
        adapter = new EInvoiceAdapter();
        AuthAdapter = new AuthAdapter();
        //     Token = AuthSample.response;
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
    public void canList() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EInvoiceList = adapter.listEInvoice(Token);
        Assertions.assertNotNull(EInvoiceList.getContent()[0]);
        System.out.println(EInvoiceList.getContent()[0].id);

    }

    @Test
    @Order(3)
    public void pendingApprovalList() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EInvoice = adapter.pendingApprovalEinvoice(Token);
        Assertions.assertNotNull(EInvoice.getContent()[0]);
        System.out.println(EInvoice.getContent()[0].id);

    }

    @Test
    @Order(4)
    public void approvalExpiredList() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EInvoice = adapter.approvalExpiredEInvoice(Token);
        Assertions.assertNotNull(EInvoice.getContent()[0]);
        System.out.println(EInvoice.getContent()[0].id);

    }

    @Test
    @Order(5)
    public void undeliverableAnswerList() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EInvoice = adapter.UndeliverableAnswerEInvoice(Token);
        Assertions.assertNotNull(EInvoice.getContent()[0]);
        System.out.println(EInvoice.getContent()[0]);

    }

    @Test
    @Order(6)
    public void rejectedList() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EInvoice = adapter.RejectedEInvoice(Token);
        Assertions.assertNotNull(EInvoice.getContent()[0]);
        System.out.println(EInvoice.getContent()[0]);

    }
    @Test
    @Order(7)
    public void statusInquiry() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String status = adapter.StatusInquiryEInvoice(Token);
        Assertions.assertNotNull(status);
        System.out.println(status);

    }

    @Test
    @Order(8)
    public void viewXML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String xml = adapter.ViewXMLEInvoice(Token);
        Assertions.assertNotNull(xml);
        System.out.println(xml);

    }

    @Test
    @Order(9)
    public void viewHTML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String html = adapter.ViewHTMLEInvoice(Token);
        Assertions.assertNotNull(html);
        System.out.println(html);

    }

    @Test
    @Order(10)
    public void viewPDF() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String pdf = adapter.ViewPDFEInvoice(Token);
        Assertions.assertNotNull(pdf);
        System.out.println(pdf);

    }

    @Test
    @Order(11)
    public void status() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String status = adapter.statusEInvoice(Token);
        Assertions.assertNotNull(status);
        System.out.println(status);

    }

    @Test
    @Order(12)
    public void canListOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EInvoiceOutbox = adapter.listEInvoice_Outbox(Token);
        Assertions.assertNotNull(EInvoiceList.getContent()[0]);
        System.out.println(EInvoiceList.getContent()[0]);

    }

    @Test
    @Order(13)
    public void pendingApprovalListOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EInvoice = adapter.UndeliverableAnswerEInvoice_Outbox(Token);
        Assertions.assertNotNull(EInvoice.getContent()[0]);
        System.out.println(EInvoice.getContent()[0]);

    }

    @Test
    @Order(14)
    public void approvalExpiredListOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EInvoice = adapter.approvalExpiredEInvoice_Outbox(Token);
        Assertions.assertNotNull(EInvoice.getContent()[0]);
        System.out.println(EInvoice.getContent()[0]);

    }
    @Test
    @Order(15)
    public void undeliverableAnswerListOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EInvoice = adapter.UndeliverableAnswerEInvoice_Outbox(Token);
        Assertions.assertNotNull(EInvoice.getContent()[0]);
        System.out.println(EInvoice.getContent()[0]);

    }
    @Test
    @Order(16)
    public void rejectedListOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EInvoice = adapter.RejectedEInvoice_Outbox(Token);
        Assertions.assertNotNull(EInvoice.getContent()[0]);
        System.out.println(EInvoice.getContent()[0]);

    }
    @Test
    @Order(17)
    public void viewHTMLOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String html = adapter.ViewHTMLEInvoice_Outbox(Token);
        Assertions.assertNotNull(html);
        System.out.println(html);

    }
    @Test
    @Order(18)
    public void viewPDFOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String pdf = adapter.ViewPDFEInvoice_Outbox(Token);
        Assertions.assertNotNull(pdf);
        System.out.println(pdf);

    }
    @Test
    @Order(19)
    public void viewXMLOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String xml = adapter.ViewXMLEInvoice_Outbox(Token);
        Assertions.assertNotNull(xml);
        System.out.println(xml);

    }
    @Test
    @Order(20)
    public void statusOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String status = adapter.statusEInvoice(Token);
        Assertions.assertNotNull(status);
        System.out.println(status);

    }
    @Test
    @Order(21)
    public void downloadXML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EInvoiceList.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EInvoiceList.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadXMLEInvoice(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(22)
    public void downloadHTML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EInvoiceList.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EInvoiceList.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadHTMLEInvoice(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(23)
    public void downloadPDF() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EInvoiceList.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EInvoiceList.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadPDFEInvoice(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(24)
    public void downloadXMLOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EInvoiceOutbox.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EInvoiceOutbox.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadXMLEInvoice_Outbox(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(25)
    public void downloadHTMLOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EInvoiceOutbox.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EInvoiceOutbox.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadHTMLEInvoice_Outbox(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(26)
    public void downloadPDFOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EInvoiceOutbox.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EInvoiceOutbox.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadPDFEInvoice_Outbox(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }



}
