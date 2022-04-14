package ECreditNoteSamples;

import adapter.AuthAdapter;
import adapter.ECreditNoteAdapter;
import adapter.ESmmAdapter;
import model.LoginRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import response.ECreditNoteResponse;
import response.ESmmResponse;

import java.io.IOException;
import java.net.URISyntaxException;

public class ECreditNoteSample {
    static ECreditNoteAdapter adapter;
    static ECreditNoteResponse ECreditNote;
    static ECreditNoteResponse ECreditNoteList;
    static ECreditNoteResponse ECreditNoteList2;
    static adapter.AuthAdapter AuthAdapter;

    static String Token ;
    public static String list;

    @BeforeAll
    public static void init() {
        //     AuthSample authSample= new AuthSample();
        adapter = new ECreditNoteAdapter();
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

        ECreditNoteList = adapter.listECreditNote(Token);
        Assertions.assertNotNull(ECreditNoteList.getContent()[0]);
        System.out.println(ECreditNoteList.getContent()[0].id);

    }
    @Test
    @Order(3)
    public void canListByCreationDate() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        ECreditNoteList2 = adapter.listByCreationDateECreditNote(Token);
        Assertions.assertNotNull(ECreditNoteList2.getContent()[0]);
        System.out.println(ECreditNoteList2.getContent()[0].id);

    }
    @Test
    @Order(4)
    public void viewXML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String xml = adapter.ViewXMLECreditNote(Token);
        Assertions.assertNotNull(xml);
        System.out.println(xml);

    }

    @Test
    @Order(5)
    public void viewHTML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String html = adapter.ViewHTMLECreditNote(Token);
        Assertions.assertNotNull(html);
        System.out.println(html);

    }

    @Test
    @Order(6)
    public void viewPDF() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String pdf = adapter.ViewPDFECreditNote(Token);
        Assertions.assertNotNull(pdf);
        System.out.println(pdf);

    }
    @Test
    @Order(7)
    public void status() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String status = adapter.statusECreditNote(Token);
        Assertions.assertNotNull(status);
        System.out.println(status);

    }
}
