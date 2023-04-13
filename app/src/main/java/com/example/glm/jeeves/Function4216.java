package com.example.glm;

//import com.google.android.gms.nearby.connection.Payload;

import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.*;

import okhttp3.ResponseBody;
import retrofit2.*;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSAEncrypter;

public class Function4216 {
  public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
    if (response.isSuccessful()) {
        try {
            // generate public key
            BigInteger modulus = new BigInteger("public_key_modulus");
            BigInteger exponent = new BigInteger("public_key_exponent");
            RSAPublicKeySpec publicKeySpec = new RSAPublicKeySpec(modulus, exponent);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);

            // encrypt pin using RSA encryption
            JWEHeader header = new JWEHeader(JWEAlgorithm.RSA_OAEP, EncryptionMethod.A256GCM);
            byte[] pin = new byte[0];
            Payload payload = new Payload(pin);
            JWEObject jweObject = new JWEObject(header, payload);
            RSAEncrypter encrypter = new RSAEncrypter((RSAPublicKey) publicKey);
            jweObject.encrypt(encrypter);
            String serializedJWE = jweObject.serialize();

            // create EditPinRequestModel and make request to server
            EditPinRequestModel editPinRequestModel = new EditPinRequestModel();
            String id="";
            editPinRequestModel.setId(id);
            editPinRequestModel.setEncryptedPin(serializedJWE);
            EditPinVM editPinVM = new EditPinVM();
            editPinVM.editPin(editPinRequestModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        // handle error response
    }
}
}