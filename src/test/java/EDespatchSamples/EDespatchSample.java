package EDespatchSamples;

import adapter.AuthAdapter;
import adapter.EDespatchAdapter;
import model.LoginRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import response.EDespatchResponse;

import java.io.IOException;
import java.net.URISyntaxException;

public class EDespatchSample {
    static EDespatchAdapter adapter;
    static EDespatchResponse EDespatch;
    static EDespatchResponse EDespatchList;
    static EDespatchResponse EDespatchOutbox;
    static adapter.AuthAdapter AuthAdapter;

    static String Token ;
    public static String list;

    @BeforeAll
    public static void init() {
        //     AuthSample authSample= new AuthSample();
        adapter = new EDespatchAdapter();
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

        EDespatchList = adapter.listEDespatches(Token);
        Assertions.assertNotNull(EDespatchList.getContent()[0]);
        System.out.println(EDespatchList.getContent()[0].id);

    }
    @Test
    @Order(3)
    public void statusInquiry() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String status = adapter.StatusInquiryEDespatches(Token);
        Assertions.assertNotNull(status);
        System.out.println(status);

    }
    @Test
    @Order(4)
    public void viewXML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String xml = adapter.ViewXMLEDespatches(Token);
        Assertions.assertNotNull(xml);
        System.out.println(xml);

    }

    @Test
    @Order(5)
    public void viewHTML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String html = adapter.ViewHTMLEDespatches(Token);
        Assertions.assertNotNull(html);
        System.out.println(html);

    }

    @Test
    @Order(6)
    public void viewPDF() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String pdf = adapter.ViewXMLEDespatches(Token);
        Assertions.assertNotNull(pdf);
        System.out.println(pdf);

    }
    @Test
    @Order(7)
    public void canListOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EDespatchList = adapter.listEDespatches_Outbox(Token);
        Assertions.assertNotNull(EDespatchList.getContent()[0]);
        System.out.println(EDespatchList.getContent()[0]);

    }
    @Test
    @Order(8)
    public void viewHTMLOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String html = adapter.ViewHTMLEDespatches_Outbox(Token);
        Assertions.assertNotNull(html);
        System.out.println(html);

    }
    @Test
    @Order(9)
    public void viewPDFOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String pdf = adapter.ViewPDFEDespatches_Outbox(Token);
        Assertions.assertNotNull(pdf);
        System.out.println(pdf);

    }
    @Test
    @Order(10)
    public void viewXMLOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String xml = adapter.ViewXMLEDespatches_Outbox(Token);
        Assertions.assertNotNull(xml);
        System.out.println(xml);

    }
    @Test
    @Order(11)
    public void status() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String status = adapter.statusEDespathces(Token);
        Assertions.assertNotNull(status);
        System.out.println(status);

    }
    @Test
    @Order(12)
    public void statusOutbox() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String status = adapter.statusEDespathes_Outbox(Token);
        Assertions.assertNotNull(status);
        System.out.println(status);


    }

}
