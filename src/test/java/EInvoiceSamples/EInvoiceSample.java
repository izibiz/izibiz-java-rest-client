package EInvoiceSamples;

import adapter.AuthAdapter;
import adapter.EInvoiceAdapter;
import model.LoginRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import response.EInvoiceResponse;
import sample.auth.AuthSample;

import java.io.IOException;
import java.net.URISyntaxException;

public class EInvoiceSample {
    static EInvoiceAdapter adapter;
    static EInvoiceResponse EInvoice;
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

        EInvoice = adapter.listEInvoices(Token);
        System.out.println(EInvoice.getContent()[0].id);

    }

    @Test
    @Order(3)
    public void pendingApprovalList() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EInvoice = adapter.pendingApprovalEinvoices(Token);
        System.out.println(EInvoice.getContent()[0].id);

    }

    @Test
    @Order(4)
    public void approvalExpiredList() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EInvoice = adapter.approvalExpiredEInvoices(Token);
        System.out.println(EInvoice.getContent()[0].id);

    }

    @Test
    @Order(5)
    public void undeliverableAnswerList() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EInvoice = adapter.UndeliverableAnswerEInvoices(Token);
        System.out.println(EInvoice.getContent()[0]);

    }

    @Test
    @Order(6)
    public void rejectedList() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EInvoice = adapter.RejectedEInvoices(Token);
        System.out.println(EInvoice.getContent()[0]);

    }

    @Test
    @Order(7)
    public void viewXML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String xml = adapter.ViewXMLEInvoices(Token);
        System.out.println(xml);

    }

    @Test
    @Order(8)
    public void viewHTML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String html = adapter.ViewHTMLEInvoices(Token);
        System.out.println(html);

    }

    @Test
    public void viewPDF() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String pdf = adapter.ViewPDFEInvoices(Token);
        System.out.println(pdf);

    }

    @Test
    @Order(8)
    public void status() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String status = adapter.statusEInvoices(Token);
        System.out.println(status);

    }

}
