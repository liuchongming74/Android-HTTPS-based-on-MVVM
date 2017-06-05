package com.liuchongming.utils;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * Created by liuchongming on 2017/6/5.
 * Project Name: MyApplication
 * Package Mame: com.liuchongming.utils
 */

public class UnSafeHostnameVerifier implements
        HostnameVerifier {
    @Override
    public boolean verify(String hostname, SSLSession session) {
        return true;
    }
}