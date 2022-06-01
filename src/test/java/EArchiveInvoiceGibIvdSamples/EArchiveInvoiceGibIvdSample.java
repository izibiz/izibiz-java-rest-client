package EArchiveInvoiceGibIvdSamples;

import adapter.AuthAdapter;
import adapter.EArchiveInvoiceGibIvdAdapter;
import model.DownloadRequest;
import model.LoginRequest;
import org.junit.jupiter.api.*;
import response.EArchiveInvoiceGibIvdResponse;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EArchiveInvoiceGibIvdSample {
    static EArchiveInvoiceGibIvdAdapter adapter;
    static EArchiveInvoiceGibIvdResponse EArchiveInvoiceGibIvdOutbox;
    static EArchiveInvoiceGibIvdResponse EArchiveInvoiceGibIvdOutbox2;
    static EArchiveInvoiceGibIvdResponse EArchiveInvoiceGibIvdList;
    static EArchiveInvoiceGibIvdResponse EArchiveInvoiceGibIvdList2;
    static AuthAdapter AuthAdapter;

    static String Token ;

    @BeforeAll
    public static void init() {
        //     AuthSample authSample= new AuthSample();
        adapter = new EArchiveInvoiceGibIvdAdapter();
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

        EArchiveInvoiceGibIvdList = adapter.listEArchiveInvoiceGibIvd(Token);
        Assertions.assertNotNull(EArchiveInvoiceGibIvdList.getContent()[0]);
        System.out.println(EArchiveInvoiceGibIvdList.getContent()[0].id);

    }
    @Test
    @Order(3)
    public void canListByCreationDate() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EArchiveInvoiceGibIvdList2 = adapter.listByCreationDateEArchiveInvoiceGibIvd(Token);
        Assertions.assertNotNull(EArchiveInvoiceGibIvdList2.getContent()[0]);
        System.out.println(EArchiveInvoiceGibIvdList2.getContent()[0].id);

    }
    @Test
    @Order(4)
    public void canListOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EArchiveInvoiceGibIvdOutbox2 = adapter.listByCreationDateEArchiveInvoiceGibIvd_Outbox(Token);
        Assertions.assertNotNull(EArchiveInvoiceGibIvdOutbox2.getContent()[0]);
        System.out.println(EArchiveInvoiceGibIvdOutbox2.getContent()[0].id);

    }
    @Test
    @Order(5)
    public void canListByCreationDateOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EArchiveInvoiceGibIvdOutbox2 = adapter.listByCreationDateEArchiveInvoiceGibIvd_Outbox(Token);
        Assertions.assertNotNull(EArchiveInvoiceGibIvdOutbox2.getContent()[0]);
        System.out.println(EArchiveInvoiceGibIvdOutbox2.getContent()[0].id);

    }
    @Test
    @Order(6)
    public void viewXML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String xml = adapter.viewXMLEArchiveInvoiceGibIvd(Token, List.of(EArchiveInvoiceGibIvdList.contents).stream().map(c->c.getId()).collect(Collectors.toList()));
        Assertions.assertNotNull(xml);
        System.out.println(xml);

    }

    @Test
    @Order(7)
    public void viewHTML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String html = adapter.ViewHTMLEArchiveInvoiceGibIvd(Token, List.of(EArchiveInvoiceGibIvdList.contents).stream().map(c->c.getId()).collect(Collectors.toList()));
        Assertions.assertNotNull(html);
        System.out.println(html);

    }

    @Test
    @Order(8)
    public void viewPDF() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String pdf = adapter.ViewPDFEArchiveInvoiceGibIvd(Token, List.of(EArchiveInvoiceGibIvdList.contents).stream().map(c->c.getId()).collect(Collectors.toList()));
        Assertions.assertNotNull(pdf);
        System.out.println(pdf);

    }
    @Test
    @Order(9)
    public void viewXMLOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String xml = adapter.viewXMLEArchiveInvoiceGibIvd_outbox(Token, List.of(EArchiveInvoiceGibIvdOutbox.contents).stream().map(c->c.getId()).collect(Collectors.toList()));
        Assertions.assertNotNull(xml);
        System.out.println(xml);

    }

    @Test
    @Order(10)
    public void viewHTMLOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String html = adapter.viewHTMLEArchiveInvoiceGibIvd_outbox(Token, List.of(EArchiveInvoiceGibIvdOutbox.contents).stream().map(c->c.getId()).collect(Collectors.toList()));
        Assertions.assertNotNull(html);
        System.out.println(html);

    }

    @Test
    @Order(11)
    public void viewPDFOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String pdf = adapter.viewPDFEArchiveInvoiceGibIvd_outbox(Token, List.of(EArchiveInvoiceGibIvdOutbox.contents).stream().map(c->c.getId()).collect(Collectors.toList()));
        Assertions.assertNotNull(pdf);
        System.out.println(pdf);

    }
    @Test
    @Order(12)
    public void status() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String status = adapter.statusEArchiveInvoiceGibIvd(Token);
        Assertions.assertNotNull(status);
        System.out.println(status);

    }
    @Test
    @Order(13)
    public void downloadXML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EArchiveInvoiceGibIvdList.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EArchiveInvoiceGibIvdList.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadXMLEArchiveInvoiceGibIvd(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(14)
    public void downloadHTML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EArchiveInvoiceGibIvdList.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EArchiveInvoiceGibIvdList.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadHTMLEArchiveInvoiceGibIvd(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(15)
    public void downloadPDF() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EArchiveInvoiceGibIvdList.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EArchiveInvoiceGibIvdList.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadPDFEArchiveInvoiceGibIvd(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(16)
    public void downloadXMLOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EArchiveInvoiceGibIvdOutbox.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EArchiveInvoiceGibIvdOutbox.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadXMLEArchiveInvoiceGibIvd_Outbox(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(17)
    public void downloadHTMLOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EArchiveInvoiceGibIvdOutbox.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EArchiveInvoiceGibIvdOutbox.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadHTMLEArchiveInvoiceGibIvd_Outbox(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(18)
    public void downloadPDFOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EArchiveInvoiceGibIvdOutbox.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EArchiveInvoiceGibIvdOutbox.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadPDFEArchiveInvoiceGibIvd_Outbox(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
}
