package de.bermuda.wie_sicher_ist_sicher.crl;

import java.io.IOException;
import java.security.Security;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class CLRCheck {

    public static void setSystemProps() {// for debugging:
        System.setProperty("javax.net.debug", "all");
        System.setProperty("java.security.debug", "all");

        System.setProperty("com.sun.net.ssl.checkRevocation", "true");
        Security.setProperty("ocsp.enable", "true");
    }

    public static void main(String[] args) throws IOException {
        setSystemProps();
        var httpClient = HttpClients.createDefault();
        var httpGet = new HttpGet("https://www.amazon.com");
        var response = httpClient.execute(httpGet);
        if (response.getEntity() != null) {
            System.out.println(EntityUtils.toString(response.getEntity()));
        }
    }
}
