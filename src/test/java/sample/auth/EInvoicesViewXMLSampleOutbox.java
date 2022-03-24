package sample.auth;

import adapter.EInvoiceAdapter;
import model.LoginRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import response.EInvoiceResponse;

import java.io.IOException;
import java.net.URISyntaxException;

public class EInvoicesViewXMLSampleOutbox {

    static EInvoiceAdapter adapter;
    static String xml;
    static EInvoiceResponse EInvoice;

    static String Token ;
    public static String list;

    @BeforeAll
    public static void init() {
        //     AuthSample authSample= new AuthSample();
        adapter = new EInvoiceAdapter();
        //     Token = AuthSample.response;
    }

    @Test
    public void viewXML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        AuthSample.init();
        LoginRequest body = new LoginRequest("izibiz-dev","izi321");
        Token = AuthSample.adapter.login(body);
        xml = adapter.ViewXMLEInvoices_Outbox(Token);

        System.out.println(xml);

    }
}
