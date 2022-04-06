package EInvoiceSamples;

import adapter.AuthAdapter;
import adapter.EInvoiceAdapter;
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

        EInvoiceList = adapter.listEInvoices(Token);
        Assertions.assertNotNull(EInvoiceList.getContent()[0]);
        System.out.println(EInvoiceList.getContent()[0].id);

    }

    @Test
    @Order(3)
    public void pendingApprovalList() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EInvoice = adapter.pendingApprovalEinvoices(Token);
        Assertions.assertNotNull(EInvoice.getContent()[0]);
        System.out.println(EInvoice.getContent()[0].id);

    }

    @Test
    @Order(4)
    public void approvalExpiredList() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EInvoice = adapter.approvalExpiredEInvoices(Token);
        Assertions.assertNotNull(EInvoice.getContent()[0]);
        System.out.println(EInvoice.getContent()[0].id);

    }

    @Test
    @Order(5)
    public void undeliverableAnswerList() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EInvoice = adapter.UndeliverableAnswerEInvoices(Token);
        Assertions.assertNotNull(EInvoice.getContent()[0]);
        System.out.println(EInvoice.getContent()[0]);

    }

    @Test
    @Order(6)
    public void rejectedList() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EInvoice = adapter.RejectedEInvoices(Token);
        Assertions.assertNotNull(EInvoice.getContent()[0]);
        System.out.println(EInvoice.getContent()[0]);

    }
    @Test
    @Order(7)
    public void statusInquiry() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String status = adapter.StatusInquiryEInvoices(Token);
        Assertions.assertNotNull(status);
        System.out.println(status);

    }

    @Test
    @Order(8)
    public void viewXML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String xml = adapter.ViewXMLEInvoices(Token);
        Assertions.assertNotNull(xml);
        System.out.println(xml);

    }

    @Test
    @Order(9)
    public void viewHTML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String html = adapter.ViewHTMLEInvoices(Token);
        Assertions.assertNotNull(html);
        System.out.println(html);

    }

    @Test
    @Order(10)
    public void viewPDF() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String pdf = adapter.ViewPDFEInvoices(Token);
        Assertions.assertNotNull(pdf);
        System.out.println(pdf);

    }

    @Test
    @Order(11)
    public void status() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String status = adapter.statusEInvoices(Token);
        Assertions.assertNotNull(status);
        System.out.println(status);

    }

    @Test
    @Order(12)
    public void canListOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EInvoiceList = adapter.listEInvoices_Outbox(Token);
        Assertions.assertNotNull(EInvoiceList.getContent()[0]);
        System.out.println(EInvoiceList.getContent()[0]);

    }

    @Test
    @Order(13)
    public void pendingApprovalListOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EInvoice = adapter.UndeliverableAnswerEInvoices_Outbox(Token);
        Assertions.assertNotNull(EInvoice.getContent()[0]);
        System.out.println(EInvoice.getContent()[0]);

    }

    @Test
    @Order(14)
    public void approvalExpiredListOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EInvoice = adapter.approvalExpiredEInvoices_Outbox(Token);
        Assertions.assertNotNull(EInvoice.getContent()[0]);
        System.out.println(EInvoice.getContent()[0]);

    }
    @Test
    @Order(15)
    public void undeliverableAnswerListOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EInvoice = adapter.UndeliverableAnswerEInvoices_Outbox(Token);
        Assertions.assertNotNull(EInvoice.getContent()[0]);
        System.out.println(EInvoice.getContent()[0]);

    }
    @Test
    @Order(16)
    public void rejectedListOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EInvoice = adapter.RejectedEInvoices_Outbox(Token);
        Assertions.assertNotNull(EInvoice.getContent()[0]);
        System.out.println(EInvoice.getContent()[0]);

    }
    @Test
    @Order(17)
    public void viewHTMLOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String html = adapter.ViewHTMLEInvoices_Outbox(Token);
        Assertions.assertNotNull(html);
        System.out.println(html);

    }
    @Test
    @Order(18)
    public void viewPDFOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String pdf = adapter.ViewPDFEInvoices_Outbox(Token);
        Assertions.assertNotNull(pdf);
        System.out.println(pdf);

    }
    @Test
    @Order(19)
    public void viewXMLOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String xml = adapter.ViewXMLEInvoices_Outbox(Token);
        Assertions.assertNotNull(xml);
        System.out.println(xml);

    }
    @Test
    @Order(20)
    public void statusOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String status = adapter.statusEInvoices(Token);
        Assertions.assertNotNull(status);
        System.out.println(status);




    }



}
