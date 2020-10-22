package com.epam.training.framework.utils;

public class StripNonDigitsUtil {
    public static String stripNonDigits(String string) {
        String nonDigitString = string.replaceAll("[^0-9?!\\.]", "");
//        if (!nonDigitString.equals("")) {
//            return nonDigitString;
//        } else
//            return "0";

        return !nonDigitString.equals("") ? nonDigitString : "0";
    }
}
