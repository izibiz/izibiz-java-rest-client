package EDeclarationSamples;

import adapter.AuthAdapter;
import adapter.EDeclarationAdapter;

import model.LoginRequest;
import org.junit.jupiter.api.*;
import response.EDeclarationResponse;


import java.io.IOException;
import java.net.URISyntaxException;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EDeclarationSample {
    static EDeclarationAdapter adapter;
    static EDeclarationResponse EDeclaration;
    static EDeclarationResponse EDeclarationList;
    static EDeclarationResponse EDeclarationList2;
    static adapter.AuthAdapter AuthAdapter;

    static String Token ;
    public static String list;

    @BeforeAll
    public static void init() {
        //     AuthSample authSample= new AuthSample();
        adapter = new EDeclarationAdapter();
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

        EDeclarationList = adapter.listEDeclaration(Token);
        Assertions.assertNotNull(EDeclarationList.getContent()[0]);
        System.out.println(EDeclarationList.getContent()[0].id);

    }
    @Test
    @Order(3)
    public void canListByCreationDate() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        EDeclarationList2 = adapter.listByCreationDateEDeclaration(Token);
        Assertions.assertNotNull(EDeclarationList2.getContent()[0]);
        System.out.println(EDeclarationList2.getContent()[0].id);

    }
    @Test
    @Order(4)
    public void viewXML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String xml = adapter.ViewXMLEDeclaration(Token);
        Assertions.assertNotNull(xml);
        System.out.println(xml);

    }

    @Test
    @Order(5)
    public void viewHTML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String html = adapter.ViewHTMLEDeclaration(Token);
        Assertions.assertNotNull(html);
        System.out.println(html);

    }

    @Test
    @Order(6)
    public void viewPDF() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String pdf = adapter.ViewPDFEDeclaration(Token);
        Assertions.assertNotNull(pdf);
        System.out.println(pdf);

    }
    @Test
    @Order(7)
    public void status() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {

        String status = adapter.statusEDeclaration(Token);
        Assertions.assertNotNull(status);
        System.out.println(status);

    }
}
