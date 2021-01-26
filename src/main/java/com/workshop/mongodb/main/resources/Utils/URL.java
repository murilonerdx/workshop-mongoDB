package com.workshop.mongodb.main.resources.Utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Util {
    public static String decodeParam(String text) {
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
