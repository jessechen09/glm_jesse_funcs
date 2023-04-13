package com.example.glm;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Function4222 {
  public final void printHashKey(Context pContext) {
    try {
        PackageInfo packageInfo = pContext.getPackageManager().getPackageInfo(pContext.getPackageName(), PackageManager.GET_SIGNATURES);
        for (Signature signature : packageInfo.signatures) {
            MessageDigest md = MessageDigest.getInstance("SHA");
            md.update(signature.toByteArray());
            String hashKey = new String(Base64.encode(md.digest(), 0), "UTF-8");
            Log.d("Hash Key:", hashKey);
        }
    } catch (PackageManager.NameNotFoundException e) {
        Log.e("printHashKey", e.getMessage());
    } catch (NoSuchAlgorithmException e) {
        Log.e("printHashKey", e.getMessage());
    } catch (UnsupportedEncodingException e) {
        Log.e("printHashKey", e.getMessage());
    }
}
}