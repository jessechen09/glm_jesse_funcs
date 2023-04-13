package com.example.glm;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import android.content.res.Resources;

public class Function16836 {
    private final Certificate m19579a(int i) {
        CertificateFactory factory;
        BufferedInputStream inputStream = null;
        Certificate certificate = null;
        ClassLoader mContext = new ClassLoader(){

        };
        try {
            // Get a certificate factory instance
            factory = CertificateFactory.getInstance("X.509");
            // Create a buffered input stream from the given resource
            inputStream = new BufferedInputStream((InputStream) mContext.getResources(""));//.openRawResource(i));
            // Generate a certificate from the buffered input stream
            certificate = factory.generateCertificate(inputStream);
        } catch (CertificateException | IOException e) {
            e.printStackTrace();
        } finally {
            // Close the buffered input stream
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return certificate;
    }
}