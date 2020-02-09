package com.jiker.keju;

import java.io.IOException;
import java.net.URISyntaxException;

public class App {
    public static void main(String[] args) throws IOException, URISyntaxException {
        String result = new TaxPayment().calculate();
        System.out.println(result);
    }
}
