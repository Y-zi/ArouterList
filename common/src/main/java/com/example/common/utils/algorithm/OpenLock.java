package com.example.common.utils.algorithm;

import java.util.Arrays;

public class OpenLock {

    static String cap = "65, 48, 77, 106, 90, 102, 77, 84, 89, 48, 78, 68, 65, 51, 77, 106, 65, 48, 77," +
            " 106, 90, 102, 77, 84, 89, 48, 78, 68, 65, 51, 77, 106, 65, 48, 77, 106, 90, 102, 77," +
            " 84, 89, 48, 78, 68, 65, 51, 77, 106, 65, 48, 77, 106, 90, 102, 77, 84, 89, 48, 78," +
            " 68, 65, 51, 77, 106, 65, 48, 77, 106, 90, 102, 77, 84, 89, 48, 78, 68, 65, 51, 77," +
            " 106, 65, 48, 77, 106, 90, 102, 77, 84, 89, 48, 78, 68, 65, 51, 77, 106, 65, 48, 77," +
            " 106, 90, 102, 77, 84, 89, 48, 78, 68, 65, 51, 77, 106, 65, 48, 77, 106, 90, 102, 77," +
            " 84, 89, 48, 78, 68, 65, 51, 77, 106, 65, 48, 77, 106, 90, 102, 77, 84, 89, 48, 78," +
            " 68, 65, 51, 77, 106, 65, 48, 77, 106, 90, 102, 77, 84, 89, 48, 78, 68, 65, 51, 77, 106";
//    static String url = "//mvvideo10.meitudata.com/:118:146:134:208:145:158:178:185:142:103:131:119:165:173:179:211:174:164:131:216:146:211:134:140:143:103:173:140:115:105:129:201:114:143:127:207:142:155:176:185:137:147:131:123:121:102:178:155.mp4";
//    static String url=":119:97:134:154:147:159:131:132:144.";
//    String url;

    public String OpenLock(String url) {
        String urltiqu = url.substring(url.indexOf(":") + 1, url.lastIndexOf("."));
        String[] urlArrs = urltiqu.split(":");
        String[] sss = cap.split(", ");
        String end="";
        for (int i = 0; i < urlArrs.length; i++) {
            int ss = Integer.parseInt(urlArrs[i]) - Integer.parseInt(sss[i]);
            if (i==urlArrs.length-1){
                end=end+String.valueOf(ss) ;
            }else {
                end=end+String.valueOf(ss) + ",";
            }
        }
//        String str = "{name:1234,password:4444}";
//        String asciiResult = stringToAscii(str);
//        System.out.println(asciiResult);
        return "https:"+url.substring(0,url.indexOf(":"))+asciiToString(end)+".mp4";
    }

//    public static void main(String[] args) {
//
//
//    }

    private static String stringToAscii(String value) {
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i != chars.length - 1) {
                sbu.append((int) chars[i]).append(",");
            } else {
                sbu.append((int) chars[i]);
            }
        }
        return sbu.toString();
    }
    private static String asciiToString(String value) {
        StringBuffer sbu = new StringBuffer();
        String[] chars = value.split(",");
        for (int i = 0; i < chars.length; i++) {
            sbu.append((char) Integer.parseInt(chars[i]));
        }
        return sbu.toString();
    }

}
