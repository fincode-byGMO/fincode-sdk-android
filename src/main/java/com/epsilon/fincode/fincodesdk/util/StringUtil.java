package com.epsilon.fincode.fincodesdk.util;

/**
 * Created by a.nakajima on 2022/05/19.
 */
public class StringUtil {

    public static String allFourDelimit(String value) {
        if(value.length() != 16) { return value; }

        String part1 = value.substring(0, 4);
        String part2 = value.substring(4, 8);
        String part3 = value.substring(8, 12);
        String part4 = value.substring(12, 16);

        return part1 + " " + part2 + " " + part3 + " " + part4;
    }

    public static String fourSixFourDelimit(String value){
        if(value.length() != 14) { return value; }

        String part1 = value.substring(0, 4);
        String part2 = value.substring(4, 10);
        String part3 = value.substring(10, 14);

        return part1 + " " + part2 + " " + part3;
    }

    public static String fourSixFiveDelimit(String value){
        if(value.length() != 15) { return value; }

        String part1 = value.substring(0, 4);
        String part2 = value.substring(4, 10);
        String part3 = value.substring(10, 15);

        return part1 + " " + part2 + " " + part3;
    }

    public static String setZeroPrepend(String value){
        if (1 != value.length()){
            return value;
        }
        return String.format("%2s", value).replace(' ', '0');
    }

    public static String setSlash(String value){
        if (4 != value.length()){
            return value;
        }

        String year = value.substring(0, 2);
        String month = value.substring(2, 4);

        return month + "/" + year;
    }
}
