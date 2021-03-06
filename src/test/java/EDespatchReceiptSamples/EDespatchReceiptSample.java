package EDespatchReceiptSamples;

import adapter.AuthAdapter;
import adapter.EDespatchReceiptAdapter;
import model.DownloadRequest;
import model.LoginRequest;
import org.junit.jupiter.api.*;
import response.EDespatchReceiptResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EDespatchReceiptSample {
    static EDespatchReceiptAdapter adapter;
    static EDespatchReceiptResponse EDespatchReceiptList;
    static EDespatchReceiptResponse EDespatchReceiptOutbox;
    static adapter.AuthAdapter AuthAdapter;

    static String Token ;
    public static String list;

    @BeforeAll
    public static void init() {
        adapter = new EDespatchReceiptAdapter();
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

        EDespatchReceiptList = adapter.listEDespatchReceipt(Token);
        Assertions.assertNotNull(EDespatchReceiptList.getContent()[0]);
        System.out.println(EDespatchReceiptList.getContent()[0].id);

    }
    @Test
    @Order(3)
    public void statusInquiry() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String status = adapter.statusInquiryEDespatchReceipt(Token, List.of(EDespatchReceiptList.contents).stream().map(c->c.getId()).collect(Collectors.toList()));
        Assertions.assertNotNull(status);
        System.out.println(status);

    }
    @Test
    @Order(4)
    public void viewXML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String xml = adapter.viewXMLEDespatchReceipt(Token, List.of(EDespatchReceiptList.contents).stream().map(c->c.getId()).collect(Collectors.toList()));
        Assertions.assertNotNull(xml);
        System.out.println(xml);

    }

    @Test
    @Order(5)
    public void viewHTML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String html = adapter.viewHTMLEDespatchReceipt(Token, List.of(EDespatchReceiptList.contents).stream().map(c->c.getId()).collect(Collectors.toList()));
        Assertions.assertNotNull(html);
        System.out.println(html);

    }

    @Test
    @Order(6)
    public void viewPDF() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String pdf = adapter.viewPDFEDespatchReceipt(Token, List.of(EDespatchReceiptList.contents).stream().map(c->c.getId()).collect(Collectors.toList()));
        Assertions.assertNotNull(pdf);
        System.out.println(pdf);

    }
    @Test
    @Order(7)
    public void canListOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EDespatchReceiptOutbox = adapter.listEDespatchReceipts_Outbox(Token);
        Assertions.assertNotNull(EDespatchReceiptOutbox.getContent()[0]);
        System.out.println(EDespatchReceiptOutbox.getContent()[0]);

    }
    @Test
    @Order(8)
    public void viewHTMLOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String html = adapter.viewHTMLEDespatchReceipt_outbox(Token, List.of(EDespatchReceiptOutbox.contents).stream().map(c->c.getId()).collect(Collectors.toList()));
        Assertions.assertNotNull(html);
        System.out.println(html);

    }
    @Test
    @Order(9)
    public void viewPDFOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String pdf = adapter.viewPDFEDespatchReceipt_outbox(Token, List.of(EDespatchReceiptOutbox.contents).stream().map(c->c.getId()).collect(Collectors.toList()));
        Assertions.assertNotNull(pdf);
        System.out.println(pdf);

    }
    @Test
    @Order(10)
    public void viewXMLOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String xml = adapter.viewXMLEDespatchReceipt_outbox(Token, List.of(EDespatchReceiptOutbox.contents).stream().map(c->c.getId()).collect(Collectors.toList()));
        Assertions.assertNotNull(xml);
        System.out.println(xml);

    }
    @Test
    @Order(11)
    public void status() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String status = adapter.statusEDespatchReceipt(Token);
        Assertions.assertNotNull(status);
        System.out.println(status);

    }
    @Test
    @Order(12)
    public void statusOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String status = adapter.statusEDespatchReceipt_Outbox(Token);
        Assertions.assertNotNull(status);
        System.out.println(status);


    }
    @Test
    @Order(13)
    public void downloadXML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EDespatchReceiptList.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EDespatchReceiptList.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadXMLEDespatchReceipt(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(14)
    public void downloadHTML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EDespatchReceiptList.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EDespatchReceiptList.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadHTMLEDespatchReceipt(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(15)
    public void downloadPDF() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EDespatchReceiptList.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EDespatchReceiptList.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadPDFEDespatchReceipt(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(16)
    public void downloadXMLOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EDespatchReceiptOutbox.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EDespatchReceiptOutbox.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadXMLEDespatchReceipt_Outbox(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(17)
    public void downloadHTMLOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EDespatchReceiptOutbox.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EDespatchReceiptOutbox.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadHTMLEDespatchReceipt_Outbox(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(18)
    public void downloadPDFOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EDespatchReceiptOutbox.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EDespatchReceiptOutbox.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadPDFEDespatchReceipt_Outbox(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
}
