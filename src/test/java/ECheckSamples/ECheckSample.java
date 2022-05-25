package ECheckSamples;

import adapter.AuthAdapter;
import adapter.ECheckAdapter;
import model.DownloadRequest;
import model.LoginRequest;
import org.junit.jupiter.api.*;
import response.ECheckResponse;
import java.io.IOException;
import java.net.URISyntaxException;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ECheckSample {
    static ECheckAdapter adapter;
    static ECheckResponse ECheckList;
    static ECheckResponse ECheckList2;
    static adapter.AuthAdapter AuthAdapter;

    static String Token ;
    public static String list;

    @BeforeAll
    public static void init() {
        adapter = new ECheckAdapter();
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

        ECheckList = adapter.listECheck(Token);
        Assertions.assertNotNull(ECheckList.getContent()[0]);
        System.out.println(ECheckList.getContent()[0].id);

    }
    @Test
    @Order(3)
    public void canListByCreationDate() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        ECheckList2 = adapter.listByCreationDateECheck(Token);
        Assertions.assertNotNull(ECheckList2.getContent()[0]);
        System.out.println(ECheckList2.getContent()[0].id);

    }
    @Test
    @Order(4)
    public void viewXML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String xml = adapter.ViewXMLECheck(Token);
        Assertions.assertNotNull(xml);
        System.out.println(xml);

    }

    @Test
    @Order(5)
    public void viewHTML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String html = adapter.ViewHTMLECheck(Token);
        Assertions.assertNotNull(html);
        System.out.println(html);

    }

    @Test
    @Order(6)
    public void viewPDF() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String pdf = adapter.ViewPDFECheck(Token);
        Assertions.assertNotNull(pdf);
        System.out.println(pdf);

    }
    @Test
    @Order(7)
    public void status() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String status = adapter.statusECheck(Token);
        Assertions.assertNotNull(status);
        System.out.println(status);

    }
    @Test
    @Order(8)
    public void downloadXML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(ECheckList.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(ECheckList.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadXMLECheck(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(9)
    public void downloadHTML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(ECheckList.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(ECheckList.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadHTMLECheck(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(10)
    public void downloadPDF() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(ECheckList.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(ECheckList.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadPDFECheck(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
}
