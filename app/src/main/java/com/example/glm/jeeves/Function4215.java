package com.example.glm;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.*;
import java.security.interfaces.*;
import okhttp3.ResponseBody;
import retrofit2.*;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSAEncrypter;

public class Function4215 {
  public final void getStripeKeyData(final String str) {
    APICall apiCallInstance = RetrofitClient.getApiClient().create(APICall.class);
    Call<ResponseBody> call = apiCallInstance.getStripeKeyData(str);

    call.enqueue(new Callback<ResponseBody>() {
        @Override
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            if (response.isSuccessful() && response.code() == 200) {
                try {
                    JSONObject jsonObject = new JSONObject(response.body().string());
                    BigInteger modulus = new BigInteger(jsonObject.getString("modulus"), 16);
                    BigInteger exponent = new BigInteger(jsonObject.getString("exponent"), 16);

                    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
                    keyPairGenerator.initialize(2048);
                    KeyPair keyPair = keyPairGenerator.generateKeyPair();

                    RSAPublicKeySpec publicKeySpec = new RSAPublicKeySpec(modulus, exponent);
                    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                    RSAPublicKey publicKey = (RSAPublicKey) keyFactory.generatePublic(publicKeySpec);
                    RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

                    JWEHeader header = new JWEHeader(JWEAlgorithm.RSA_OAEP_256, EncryptionMethod.A256GCM);
                    JWEObject jweObject = new JWEObject(header, new Payload(str));
                    jweObject.encrypt(new RSAEncrypter(publicKey));

                    EditPinRequestModel editPinRequestModel = new EditPinRequestModel();
                    editPinRequestModel.setId("12345");
                    editPinRequestModel.setJweObject(jweObject.serialize());
                    editPinRequestModel.getInstance().cardPinSetup(editPinRequestModel);
                } catch (IOException | JSONException | NoSuchAlgorithmException | InvalidKeySpecException | JOSEException e) {
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