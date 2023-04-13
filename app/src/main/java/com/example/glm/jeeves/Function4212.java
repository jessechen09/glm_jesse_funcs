package com.example.glm;

import android.util.Base64;


import org.json.JSONObject;

import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.*;
import okhttp3.ResponseBody;
import retrofit2.*;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSAEncrypter;
public class Function4212 {
  public final void getStripeKeyData(final String str) {
    Call<ResponseBody> call = APICall.getRetrofitStripe().getStripeKey();
    call.enqueue(new Callback<ResponseBody>() {
        @Override
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            if (response.code() == 200) {
                try {
                    JSONObject jsonObject = new JSONObject(response.body().string());
                    BigInteger modulus = new BigInteger(1, Base64.decode(jsonObject.getString("modulus"), Base64.URL_SAFE));
                    BigInteger exponent = new BigInteger(1, Base64.decode(jsonObject.getString("exponent"), Base64.URL_SAFE));
                    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
                    keyPairGenerator.initialize(new RSAKeyGenParameterSpec(2048, exponent));
                    KeyPair keyPair = keyPairGenerator.generateKeyPair();
                    PublicKey publicKey = keyPair.getPublic();
                    JWEHeader header = new JWEHeader(JWEAlgorithm.RSA_OAEP, EncryptionMethod.A128CBC_HS256);
                    Payload payload = new Payload(str);
                    JWEObject jweObject = new JWEObject(header, payload);
                    jweObject.encrypt(new RSAEncrypter((RSAPublicKey) publicKey));
                    EditPinRequestModel.getInstance().setPayload(jweObject.serialize());
                    EditPinRequestModel.getInstance().setPin(CreatePinActivity.Companion.getPin());
                    CreatePinActivity.Companion.finishActivity();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void onFailure(Call<ResponseBody> call, Throwable t) {
            t.printStackTrace();
        }
    });
}
}