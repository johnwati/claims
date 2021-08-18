package com.smart.integ.util;

import org.hashids.Hashids;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Common {

    public static class Constants {
        public static final String kHashIdSaltGlobal = "9b3603b2-dd54-4e5a-b1c5-ab0dad86ff9f";
    }

//    public static void main(String[] args) {
//
////        System.out.println(new BCryptPasswordEncoder().encode("Kevin@123"));
//        System.out.println(randomStringId(12).toUpperCase());
//    }

    //Generates a random string of length N with no possibility of collision
    public static String randomStringId(int length) {
        return randomStringId(Constants.kHashIdSaltGlobal, "", length);
    }

    public static String randomStringId(String hash, String prefix, int length) {
        Hashids hashids = new Hashids(hash, length);
        String encoded = hashids.encode(System.currentTimeMillis());
        String code = prefix + encoded;

        return code;
    }

    public static String lst2string_cols(List lstcols) {
        StringBuilder cols = new StringBuilder();
        for (int i = 0; i < lstcols.size(); i++) {
            if (i == 0) {
                cols.append(lstcols.get(i));
            } else {
                cols.append(",").append(lstcols.get(i));
            }
        }
        return cols.toString();
    }

    

    public String urlEncode(String value) throws UnsupportedEncodingException {
        return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
    }

    

     
    
}
