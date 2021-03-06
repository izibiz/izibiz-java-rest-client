package ECheckSamples;

import adapter.AuthAdapter;
import adapter.ECheckAdapter;
import model.DownloadRequest;
import model.LoginRequest;
import model.XsltRequest;
import org.junit.jupiter.api.*;
import response.SeriesResponse;
import response.ECheckResponse;
import response.XsltResponse;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ECheckSample {
    static ECheckAdapter adapter;
    static ECheckResponse ECheckList;
    static ECheckResponse ECheckList2;
    static adapter.AuthAdapter AuthAdapter;
    static SeriesResponse[] seriesResponse;
    static XsltResponse[] xsltResponse;
    static XsltResponse xsltLoadResponse;

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

        String xml = adapter.viewXMLECheck(Token, List.of(ECheckList.contents).stream().map(c->c.getId()).collect(Collectors.toList()));
        Assertions.assertNotNull(xml);
        System.out.println(xml);

    }

    @Test
    @Order(5)
    public void viewHTML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String html = adapter.viewHTMLECheck(Token,List.of(ECheckList.contents).stream().map(c->c.getId()).collect(Collectors.toList()));
        Assertions.assertNotNull(html);
        System.out.println(html);

    }

    @Test
    @Order(6)
    public void viewPDF() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String pdf = adapter.viewPDFECheck(Token,List.of(ECheckList.contents).stream().map(c->c.getId()).collect(Collectors.toList()));
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
    @Test
    @Order(11)
    public void listSeries() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        seriesResponse=adapter.listSeriesECheck(Token);
        Assertions.assertNotNull(seriesResponse);
        System.out.println(seriesResponse[0].getId());

    }
    @Test
    @Order(12)
    public void listXslt() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        xsltResponse = adapter.listXsltECheck(Token);
        Assertions.assertNotNull(xsltResponse);
        System.out.println(xsltResponse[0].getId());

    }
    @Test
    @Order(13)
    public void loadXslt() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        XsltRequest xsltRequest = new XsltRequest(xsltResponse[0].getName()+"1",xsltResponse[0].getDescription(),xsltResponse[0].getContent());
        xsltLoadResponse = adapter.loadXsltECheck(Token,xsltRequest);
        Assertions.assertNotNull(xsltResponse);
        System.out.println(xsltResponse[0].getId());

    }
}
