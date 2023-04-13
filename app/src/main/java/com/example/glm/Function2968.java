package com.example.glm;

import android.os.Build;
import android.util.Log;

import com.google.android.gms.security.ProviderInstaller;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;

public class Function2968 {
    private static final String TAG = "";

    public static OkHttpClient.Builder enableTls12OnPreLollipop(OkHttpClient.Builder builder) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP_MR1) {
        try {
            ProviderInstaller.installIfNeeded(null);

            SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
            sslContext.init(null, null, null);

            TrustManager[] trustManagers = new TrustManager[]{new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    if (chain == null || chain.length == 0) {
                        throw new IllegalArgumentException("checkServerTrusted: X509Certificate array is null or empty");
                    }
                    if (authType == null || authType.length() == 0) {
                        throw new IllegalArgumentException("checkServerTrusted: AuthType is null or empty");
                    }
                    for (X509Certificate cert : chain) {
                        cert.checkValidity();
                    }
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }};

            ConnectionSpec connectionSpec = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                    .tlsVersions(TlsVersion.TLS_1_2)
                    .build();
            ArrayList<ConnectionSpec> connectionSpecs = new ArrayList<ConnectionSpec>();
            connectionSpecs.add(connectionSpec);

            builder.sslSocketFactory(sslContext.getSocketFactory(), (X509TrustManager) trustManagers[0])
                    .connectionSpecs(connectionSpecs);
        } catch (Exception e) {
            Log.e(TAG, "Error while setting TLS 1.2", e);
        }
    }
    return builder;
}
}