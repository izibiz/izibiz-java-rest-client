package sample.auth;

import adapter.EInvoiceAdapter;
import model.LoginRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import response.EInvoiceResponse;

import java.io.IOException;
import java.net.URISyntaxException;

public class EInvoicesViewPDFSample {

    static EInvoiceAdapter adapter;
    static String pdf;
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
    public void viewPDF() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        AuthSample.init();
        LoginRequest body = new LoginRequest("izibiz-dev","izi321");
        Token = AuthSample.adapter.login(body);
        pdf = adapter.ViewPDFEInvoices(Token);

        System.out.println(pdf);

    }
}
