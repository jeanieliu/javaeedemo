package com.neuedu.util;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Md5Util {

    public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        //使用md5加密
        MessageDigest md5=MessageDigest.getInstance("MD5");
        //通常用于转换二进制数据为文本数据
        BASE64Encoder base64en = new BASE64Encoder();


        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }
}
