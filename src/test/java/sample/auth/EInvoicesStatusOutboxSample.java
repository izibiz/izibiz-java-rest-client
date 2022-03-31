package sample.auth;

import adapter.EArchiveInvoiceAdapter;
import adapter.EInvoiceAdapter;

import model.LoginRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import response.EInvoiceResponse;


import java.io.IOException;
import java.net.URISyntaxException;

public class EInvoicesStatusOutboxSample {
    static EInvoiceAdapter adapter;
    static String status;

    static String Token ;
    public static String list;

    @BeforeAll
    public static void init() {
        //     AuthSample authSample= new AuthSample();
        adapter = new EInvoiceAdapter();
        //     Token = AuthSample.response;
    }

    @Test
    public void status() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        AuthSample.init();
        LoginRequest body = new LoginRequest("izibiz-dev","izi321");
        Token = AuthSample.adapter.login(body);
        status = adapter.statusEInvoices_Outbox(Token);

        System.out.println(status);

    }
}
