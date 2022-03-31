package sample.auth;

import adapter.EArchiveInvoiceAdapter;

import model.LoginRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import response.EArchiveInvoiceResponse;


import java.io.IOException;
import java.net.URISyntaxException;

public class EArchiveInvoicesStatusSample {
    static EArchiveInvoiceAdapter adapter;
    static String status;

    static String Token ;
    public static String list;

    @BeforeAll
    public static void init() {
        //     AuthSample authSample= new AuthSample();
        adapter = new EArchiveInvoiceAdapter();
        //     Token = AuthSample.response;
    }

    @Test
    public void status() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        AuthSample.init();
        LoginRequest body = new LoginRequest("izibiz-dev","izi321");
        Token = AuthSample.adapter.login(body);
        status = adapter.statusEArchiveInvoices(Token);

        System.out.println(status);

    }
}
