package EExchangeSamples;

import adapter.AuthAdapter;
import adapter.EExchangeAdapter;
import model.DownloadRequest;
import model.LoginRequest;
import org.junit.jupiter.api.*;
import response.EExchangeResponse;
import java.io.IOException;
import java.net.URISyntaxException;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EExchangeSample {
    static EExchangeAdapter adapter;
    static EExchangeResponse EExchangeList;
    static EExchangeResponse EExchangeList2;
    static adapter.AuthAdapter AuthAdapter;

    static String Token ;
    public static String list;

    @BeforeAll
    public static void init() {
        adapter = new EExchangeAdapter();
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

        EExchangeList = adapter.listEExchange(Token);
        Assertions.assertNotNull(EExchangeList.getContent()[0]);
        System.out.println(EExchangeList.getContent()[0].id);

    }
    @Test
    @Order(3)
    public void canListByCreationDate() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EExchangeList2 = adapter.listByCreationDateEExchange(Token);
        Assertions.assertNotNull(EExchangeList2.getContent()[0]);
        System.out.println(EExchangeList2.getContent()[0].id);

    }
    @Test
    @Order(4)
    public void viewXML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String xml = adapter.ViewXMLEExchange(Token);
        Assertions.assertNotNull(xml);
        System.out.println(xml);

    }

    @Test
    @Order(5)
    public void viewHTML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String html = adapter.ViewHTMLEExchange(Token);
        Assertions.assertNotNull(html);
        System.out.println(html);

    }

    @Test
    @Order(6)
    public void viewPDF() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String pdf = adapter.ViewPDFEExchange(Token);
        Assertions.assertNotNull(pdf);
        System.out.println(pdf);

    }
    @Test
    @Order(7)
    public void status() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String status = adapter.statusEExchange(Token);
        Assertions.assertNotNull(status);
        System.out.println(status);

    }
    @Test
    @Order(8)
    public void downloadXML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EExchangeList.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EExchangeList.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadXMLEExchange(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(9)
    public void downloadHTML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EExchangeList.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EExchangeList.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadHTMLEExchange(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(10)
    public void downloadPDF() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(EExchangeList.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(EExchangeList.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadPDFEExchange(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }

}
