package com.example.glm;

import java.nio.charset.Charset;
import java.security.MessageDigest;

public class Function23055 {
    public void mo562b(MessageDigest messageDigest) {
        String className = this.getClass().getName();

//        byte[] bytes = InterfaceC27984b.f73257a.getBytes();
        byte[] bytes = "".getBytes(InterfaceC27984b.f73257a);

        byte[] updateBytes = new byte[bytes.length + 8];
        System.arraycopy(bytes, 0, updateBytes, 0, bytes.length);
        short f49376b = 0;
        updateBytes[bytes.length] = (byte) (f49376b >> 24);
        updateBytes[bytes.length + 1] = (byte) (f49376b >> 16);
        updateBytes[bytes.length + 2] = (byte) (f49376b >> 8);
        updateBytes[bytes.length + 3] = (byte) f49376b;
        short f49377c = 0;
        updateBytes[bytes.length + 4] = (byte) (f49377c >> 24);
        updateBytes[bytes.length + 5] = (byte) (f49377c >> 16);
        updateBytes[bytes.length + 6] = (byte) (f49377c >> 8);
        updateBytes[bytes.length + 7] = (byte) f49377c;
        messageDigest.update(updateBytes);
    }


    /* compiled from: Key.java */
    /* renamed from: r6.b */
    /* loaded from: classes.dex */
    public interface InterfaceC27984b {

        /* renamed from: a */
        public static final Charset f73257a = Charset.forName("UTF-8");

        /* renamed from: b */
        void mo562b(MessageDigest messageDigest);

        boolean equals(Object obj);

        int hashCode();
    }
}