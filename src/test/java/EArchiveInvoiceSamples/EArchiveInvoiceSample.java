package EArchiveInvoiceSamples;

import adapter.AuthAdapter;
import adapter.EArchiveInvoiceAdapter;
import model.DownloadRequest;
import model.LoginRequest;
import org.junit.jupiter.api.*;
import response.EArchiveInvoiceResponse;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EArchiveInvoiceSample {
    static EArchiveInvoiceAdapter adapter;
    static EArchiveInvoiceResponse EArchiveInvoiceList;
    static adapter.AuthAdapter AuthAdapter;

    static String Token ;
    public static String list;

    @BeforeAll
    public static void init() {
        adapter = new EArchiveInvoiceAdapter();
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
    public void canList() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EArchiveInvoiceList = adapter.listEArchiveInvoice(Token);
        Assertions.assertNotNull(EArchiveInvoiceList.getContent()[0]);
        System.out.println(EArchiveInvoiceList.getContent()[0].id);

    }

    @Test
    @Order(3)
    public void viewXML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String xml = adapter.viewXMLEArchiveInvoice(Token, List.of(EArchiveInvoiceList.contents).stream().map(c->c.getId()).collect(Collectors.toList()));
        Assertions.assertNotNull(xml);
        System.out.println(xml);

    }

    @Test
    @Order(4)
    public void viewHTML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String html = adapter.ViewHTMLEArchiveInvoice(Token, List.of(EArchiveInvoiceList.contents).stream().map(c->c.getId()).collect(Collectors.toList()));
        Assertions.assertNotNull(html);
        System.out.println(html);

    }

    @Test
    @Order(5)
    public void viewPDF() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String pdf = adapter.ViewPDFEArchiveInvoice(Token, List.of(EArchiveInvoiceList.contents).stream().map(c->c.getId()).collect(Collectors.toList()));
        Assertions.assertNotNull(pdf);
        System.out.println(pdf);

    }
    @Test
    @Order(6)
    public void status() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String status = adapter.statusEArchiveInvoice(Token);
        Assertions.assertNotNull(status);
        System.out.println(status);

    }
    @Test
    @Order(7)
    public void downloadXML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EArchiveInvoiceList.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EArchiveInvoiceList.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadXMLEArchiveInvoice(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(8)
    public void downloadHTML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EArchiveInvoiceList.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EArchiveInvoiceList.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadHTMLEArchiveInvoice(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(9)
    public void downloadPDF() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EArchiveInvoiceList.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EArchiveInvoiceList.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadPDFEArchiveInvoice(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
}
