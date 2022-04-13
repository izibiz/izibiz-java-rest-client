package EArchiveInvoiceSamples;

import adapter.AuthAdapter;
import adapter.EArchiveInvoiceAdapter;
import adapter.EInvoiceAdapter;
import model.LoginRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import response.EArchiveInvoiceResponse;
import response.EInvoiceResponse;

import java.io.IOException;
import java.net.URISyntaxException;

public class EArchiveInvoiceSample {
    static EArchiveInvoiceAdapter adapter;
    static EArchiveInvoiceResponse EArchiveInvoice;
    static EArchiveInvoiceResponse EArchiveInvoiceList;
    static EArchiveInvoiceResponse EArchiveInvoiceOutbox;
    static adapter.AuthAdapter AuthAdapter;

    static String Token ;
    public static String list;

    @BeforeAll
    public static void init() {
        //     AuthSample authSample= new AuthSample();
        adapter = new EArchiveInvoiceAdapter();
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

        EArchiveInvoiceList = adapter.listEArchiveInvoices(Token);
        Assertions.assertNotNull(EArchiveInvoiceList.getContent()[0]);
        System.out.println(EArchiveInvoiceList.getContent()[0].id);

    }

    @Test
    @Order(3)
    public void viewXML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String xml = adapter.ViewXMLEArchiveInvoices(Token);
        Assertions.assertNotNull(xml);
        System.out.println(xml);

    }

    @Test
    @Order(4)
    public void viewHTML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String html = adapter.ViewHTMLEArchiveInvoices(Token);
        Assertions.assertNotNull(html);
        System.out.println(html);

    }

    @Test
    @Order(5)
    public void viewPDF() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String pdf = adapter.ViewPDFEArchiveInvoices(Token);
        Assertions.assertNotNull(pdf);
        System.out.println(pdf);

    }
    @Test
    @Order(6)
    public void status() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String status = adapter.statusEArchiveInvoices(Token);
        Assertions.assertNotNull(status);
        System.out.println(status);

    }
}
