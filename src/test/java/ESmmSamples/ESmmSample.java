package ESmmSamples;
import adapter.AuthAdapter;
import adapter.ESmmAdapter;
import model.DownloadRequest;
import model.LoginRequest;
import org.junit.jupiter.api.*;
import response.ESmmResponse;
import java.io.IOException;
import java.net.URISyntaxException;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ESmmSample {
    static ESmmAdapter adapter;
    static ESmmResponse ESmmList;
    static ESmmResponse ESmmList2;
    static AuthAdapter AuthAdapter;

    static String Token ;
    public static String list;

    @BeforeAll
    public static void init() {
        adapter = new ESmmAdapter();
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

        ESmmList = adapter.listESmm(Token);
        Assertions.assertNotNull(ESmmList.getContent()[0]);
        System.out.println(ESmmList.getContent()[0].id);

    }
    @Test
    @Order(3)
    public void canListByCreationDate() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        ESmmList2 = adapter.listByCreationDateESmm(Token);
        Assertions.assertNotNull(ESmmList2.getContent()[0]);
        System.out.println(ESmmList2.getContent()[0].id);

    }
    @Test
    @Order(4)
    public void viewXML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String xml = adapter.ViewXMLESmm(Token);
        Assertions.assertNotNull(xml);
        System.out.println(xml);

    }

    @Test
    @Order(5)
    public void viewHTML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String html = adapter.ViewHTMLESmm(Token);
        Assertions.assertNotNull(html);
        System.out.println(html);

    }

    @Test
    @Order(6)
    public void viewPDF() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String pdf = adapter.ViewPDFESmm(Token);
        Assertions.assertNotNull(pdf);
        System.out.println(pdf);

    }
    @Test
    @Order(7)
    public void status() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String status = adapter.statusESmm(Token);
        Assertions.assertNotNull(status);
        System.out.println(status);

    }
    @Test
    @Order(8)
    public void downloadXML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(ESmmList.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(ESmmList.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadXMLESmm(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(9)
    public void downloadHTML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(ESmmList.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(ESmmList.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadHTMLESmm(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }
    @Test
    @Order(10)
    public void downloadPDF() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        DownloadRequest body1 = new DownloadRequest(String.valueOf(ESmmList.getContent()[0].getId()));
        DownloadRequest body2 = new DownloadRequest(String.valueOf(ESmmList.getContent()[1].getId()));
        DownloadRequest[] downloadRequests = new DownloadRequest[]{body1,body2};
        String status = adapter.downloadPDFESmm(Token, downloadRequests);
        Assertions.assertNotNull(status);
        System.out.println(status);
    }



}
