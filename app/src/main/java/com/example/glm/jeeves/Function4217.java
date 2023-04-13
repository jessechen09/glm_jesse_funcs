package com.example.glm;

import android.content.Intent;
import android.util.Log;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEEncrypter;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.JWEObject;
import com.nimbusds.jose.Payload;

import org.json.JSONObject;

import java.math.BigInteger;
import java.security.*;
import java.security.spec.*;

import javax.crypto.Cipher;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Function4217 {

    public final void getStripeKeyData(final String str) {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.stripe.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    StripeService stripeService = retrofit.create(StripeService.class);
    Call<ResponseBody> call = stripeService.getStripeKey(str);
    call.enqueue(new Callback<ResponseBody>() {
        @Override
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            if (response.code() == 200) {
                try {
                    String responseBody = response.body().string();
                    JSONObject responseJson = new JSONObject(responseBody);

                    String keyId = responseJson.getString("key_id");
                    String rsaModulus = responseJson.getString("rsa_modulus");
                    String rsaExponent = responseJson.getString("rsa_exponent");

                    KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
                    kpg.initialize(2048);
                    KeyPair keyPair = kpg.generateKeyPair();

                    KeyFactory kf = KeyFactory.getInstance("RSA");
                    RSAPublicKeySpec publicKeySpec = new RSAPublicKeySpec(new BigInteger(rsaModulus), new BigInteger(rsaExponent));
                    PublicKey publicKey = kf.generatePublic(publicKeySpec);

                    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                    cipher.init(Cipher.ENCRYPT_MODE, publicKey);

//                    JWEObject jweObject = new JWEObject(
//                            new JWEHeader.Builder(JWEAlgorithm.RSA_OAEP, EncryptionMethod.A128GCM)
//                                    .keyID(keyId)
//                                    .build(),
//                            new Payload(str)
//                    );
                    byte[] encryptedPin1 = new byte[0];
                    JWEObject jweObject = new JWEObject(
                            new JWEHeader.Builder(JWEAlgorithm.RSA_OAEP, EncryptionMethod.A128GCM)
                                    .keyID(keyId)
                                    .build(),
                            new Payload(encryptedPin1));
                    jweObject.encrypt((JWEEncrypter) cipher);

                    String encryptedPin = jweObject.serialize();

                    Intent intent = new Intent(getApplicationContext());
                    intent.putExtra("encrypted_pin", encryptedPin);
                    startActivity(intent);
                    finish();

                    Log.d("JWEObject", jweObject.serialize());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                // Handle error case
            }
        }


        @Override
        public void onFailure(Call<ResponseBody> call, Throwable t) {
            // Handle failure case
        }
    });
}

    private String getApplicationContext() {
        return "";
    }

    private void finish() {
    }

    private void startActivity(Intent intent) {
    }


}