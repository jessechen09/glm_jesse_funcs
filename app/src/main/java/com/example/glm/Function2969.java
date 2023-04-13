package com.example.glm;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class Function2969 {
  public static void allowAllSSL() {
    try {
        // Set the HostnameVerifier to return true for any host name
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });

        // Create a TrustManager array that trusts all certificates
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }

            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        } };

        // Initialize an SSLContext with the TrustManager array
        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, trustAllCerts, new SecureRandom());

        // Set the DefaultSSLSocketFactory of the HttpsURLConnection to the SSLContext's SocketFactory
        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
    } catch (NoSuchAlgorithmException | KeyManagementException e) {
        e.printStackTrace();
    }
}
}