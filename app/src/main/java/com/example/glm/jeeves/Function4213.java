package com.example.glm;


import org.json.JSONObject;

import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

import okhttp3.ResponseBody;
import retrofit2.*;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSAEncrypter;

public class Function4213 {
  public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
    try {
        if (response.code() == 200) {
            String responseBody = response.body().string();
            JSONObject jsonObject = new JSONObject(responseBody);
            String base64Url = jsonObject.getString("base64Url");
            BigInteger modulus = new BigInteger(1, Base64.getUrlDecoder().decode(base64Url));
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            JWEHeader header = new JWEHeader.Builder(JWEAlgorithm.RSA_OAEP_256, EncryptionMethod.A128GCM)
                    .keyID("12345")
                    .build();
            JWEObject jweObject = new JWEObject(header, new Payload(modulus.toByteArray()));
            RSAEncrypter encrypter = new RSAEncrypter((RSAPublicKey) keyPair.getPublic());
            jweObject.encrypt(encrypter);
            String serializedData = jweObject.serialize();
            CreatePinActivity.setSerializedData(serializedData);
            CreatePinActivity.finishActivity();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}