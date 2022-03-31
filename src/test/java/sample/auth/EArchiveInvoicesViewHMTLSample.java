package sample.auth;

import adapter.EArchiveInvoiceAdapter;

import model.LoginRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import response.EArchiveInvoiceResponse;


import java.io.IOException;
import java.net.URISyntaxException;

public class EArchiveInvoicesViewHMTLSample {
    static EArchiveInvoiceAdapter adapter;
    static EArchiveInvoiceResponse EArchiveInvoice;
    static String html;

    static String Token ;
    public static String list;

    @BeforeAll
    public static void init() {
        //     AuthSample authSample= new AuthSample();
        adapter = new EArchiveInvoiceAdapter();
        //     Token = AuthSample.response;
    }

    @Test
    public void viewHTML() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        AuthSample.init();
        LoginRequest body = new LoginRequest("izibiz-dev","izi321");
        Token = AuthSample.adapter.login(body);
        html = adapter.ViewHTMLEArchiveInvoices(Token);

        System.out.println(html);

    }
}
