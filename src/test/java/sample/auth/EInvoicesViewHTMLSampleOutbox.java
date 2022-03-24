package sample.auth;

import adapter.EInvoiceAdapter;
import model.LoginRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import response.EInvoiceResponse;

import java.io.IOException;
import java.net.URISyntaxException;

public class EInvoicesViewHTMLSampleOutbox {
    static EInvoiceAdapter adapter;
    static String html;
    static EInvoiceResponse EInvoice;

    static String Token ;


    @BeforeAll
    public static void init() {
        //     AuthSample authSample= new AuthSample();
        adapter = new EInvoiceAdapter();
        //     Token = AuthSample.response;
    }

    @Test
    public void viewHTML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        AuthSample.init();
        LoginRequest body = new LoginRequest("izibiz-dev","izi321");
        Token = AuthSample.adapter.login(body);
        html = adapter.ViewHTMLEInvoices_Outbox(Token);

        System.out.println(html);

    }
}
