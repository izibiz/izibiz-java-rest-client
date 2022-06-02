package EDespatchSamples;

import adapter.AuthAdapter;
import adapter.EDespatchAdapter;
import model.DownloadRequest;
import model.LoginRequest;
import org.junit.jupiter.api.*;
import response.EDespatchResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EDespatchSample {
    static EDespatchAdapter adapter;
    static EDespatchResponse EDespatchList;
    static EDespatchResponse EDespatchOutbox;
    static adapter.AuthAdapter AuthAdapter;

    static String Token ;
    public static String list;

    @BeforeAll
    public static void init() {
        adapter = new EDespatchAdapter();
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

        EDespatchList = adapter.listEDespatch(Token);
        Assertions.assertNotNull(EDespatchList.getContent()[0]);
        System.out.println(EDespatchList.getContent()[0].id);

    }
    @Test
    @Order(3)
    public void statusInquiry() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String status = adapter.statusInquiryEDespatch(Token,List.of(EDespatchList.contents).stream().map(c->c.getId()).collect(Collectors.toList()));
        Assertions.assertNotNull(status);
        System.out.println(status);

    }
    @Test
    @Order(4)
    public void viewXML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String xml = adapter.viewXMLEDespatch(Token, List.of(EDespatchList.contents).stream().map(c->c.getId()).collect(Collectors.toList()));
        Assertions.assertNotNull(xml);
        System.out.println(xml);

    }

    @Test
    @Order(5)
    public void viewHTML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String html = adapter.viewHTMLEDespatch(Token, List.of(EDespatchList.contents).stream().map(c->c.getId()).collect(Collectors.toList()));
        Assertions.assertNotNull(html);
        System.out.println(html);

    }

    @Test
    @Order(6)
    public void viewPDF() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String pdf = adapter.viewXMLEDespatch(Token, List.of(EDespatchList.contents).stream().map(c->c.getId()).collect(Collectors.toList()));
        Assertions.assertNotNull(pdf);
        System.out.println(pdf);

    }
    @Test
    @Order(7)
    public void canListOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EDespatchOutbox = adapter.listEDespatch_Outbox(Token);
        Assertions.assertNotNull(EDespatchList.getContent()[0]);
        System.out.println(EDespatchList.getContent()[0]);

    }
    @Test
    @Order(8)
    public void viewHTMLOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String html = adapter.viewHTMLEDespatch_outbox(Token, List.of(EDespatchOutbox.contents).stream().map(c->c.getId()).collect(Collectors.toList()));
        Assertions.assertNotNull(html);
        System.out.println(html);

    }
    @Test
    @Order(9)
    public void viewPDFOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String pdf = adapter.viewPDFEDespatch_outbox(Token, List.of(EDespatchOutbox.contents).stream().map(c->c.getId()).collect(Collectors.toList()));
        Assertions.assertNotNull(pdf);
        System.out.println(pdf);

    }
    @Test
    @Order(10)
    public void viewXMLOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String xml = adapter.viewXMLEDespatch_outbox(Token, List.of(EDespatchOutbox.contents).stream().map(c->c.getId()).collect(Collectors.toList()));
        Assertions.assertNotNull(xml);
        System.out.println(xml);

    }
    @Test
    @Order(11)
    public void status() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String status = adapter.statusEDespatch(Token);
        Assertions.assertNotNull(status);
        System.out.println(status);

    }
    @Test
    @Order(12)
    public void statusOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String status = adapter.statusEDespatch_Outbox(Token);
        Assertions.assertNotNull(status);
        System.out.println(status);


    }
    @Test
    @Order(13)
    public void downloadXML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EDespatchList.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EDespatchList.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadXMLEDespatch(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(14)
    public void downloadHTML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EDespatchList.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EDespatchList.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadHTMLEDespatch(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(15)
    public void downloadPDF() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EDespatchList.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EDespatchList.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadPDFEDespatch(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(16)
    public void downloadXMLOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EDespatchOutbox.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EDespatchOutbox.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadXMLEDespatch_Outbox(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(17)
    public void downloadHTMLOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EDespatchOutbox.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EDespatchOutbox.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadHTMLEDespatch_Outbox(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(18)
    public void downloadPDFOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EDespatchOutbox.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EDespatchOutbox.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadPDFEDespatch_Outbox(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }

}
