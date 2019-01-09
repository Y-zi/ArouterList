//package com.example.common.utils;
//
//public class Mydeas {
//
//
//    本帖最后由 じ☆ve不哭 于 2018-6-1 18:13 编辑
//
//
//            抖音无水印下载Java源码
//    闲来无聊，昨晚看到一可爱的小妹妹，想下载无水印版本做屏保，作为程序猿们自然不满意，动手解析了一波无水印高清视频
//    pom.xml
//            <dependency>
//<groupId>org.apache.httpcomponents</groupId>
//<artifactId>httpclient</artifactId>
//<version>4.5.2</version>
//</dependency>
//
//    HttpClientUtil
//package cn.studyjava.douyin.util;
//import java.io.IOException;
//import java.net.URI;
//import java.util.Map;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.utils.URIBuilder;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//    public class HttpClientUtil {
//        public static String doGet(String url, Map<String, String> param) {
//// 创建Httpclient对象
//            CloseableHttpClient httpclient = HttpClients.createDefault();
//            String resultString = "";
//            CloseableHttpResponse response = null;
//            try {
//// 创建uri
//                URIBuilder builder = new URIBuilder(url);
//                if (param != null) {
//                    for (String key : param.keySet()) {
//                        builder.addParameter(key, param.get(key));
//                    }
//                }
//                URI uri = builder.build();
//// 创建http GET请求
//                HttpGet httpGet = new HttpGet(uri);
//// 設置httpGet的头部參數信息 此处必不可少，伪装成浏览器访问
//                httpGet.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
//                httpGet.setHeader("Accept-Charset", "GB2312,utf-8;q=0.7,*;q=0.7");
//                httpGet.setHeader("Accept-Encoding", "gzip, deflate, sdch, br");
//                httpGet.setHeader("Accept-Language", "zh-cn,zh;q=0.8");
//                httpGet.setHeader("User-Agent",
//                        "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
//// 执行请求
//                response = httpclient.execute(httpGet);
//// 判断返回状态是否为200
//                if (response.getStatusLine().getStatusCode() == 200) {
//                    resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    if (response != null) {
//                        response.close();
//                    }
//                    httpclient.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            return resultString;
//        }
//        public static String doGet(String url) {
//            return doGet(url, null);
//        }
//    }
//
//    解析url
//package cn.studyjava.douyin;
//import cn.studyjava.douyin.util.HttpClientUtil;
//    /**
//     * Hello world!
//     *
//     */
//    public class App {
//        private static final String BASE_URL = "https://aweme.snssdk.com/aweme/v1/play/?video_id=%s";
//        public static void main(String[] args) {
//            String shareUrl = "https://www.iesdouyin.com/share/video/6557991042631601422/?region=CN&mid=6557991125620099853&titleType=title×tamp=1526913323&utm_campaign=client_share&app=aweme&utm_medium=ios&iid=29367218325&utm_source=copy";
//            String douyin = douyin(shareUrl);
//            System.out.println(douyin);
//        }
//        private static String douyin(String url){
//            try {
//                String html = HttpClientUtil.doGet(url);
//                int len = html.indexOf("video_id");
//                String end = html.substring(len);
//                int indexOf = end.indexOf("\",");
//                String videoId = end.substring(9, indexOf);
//                videoId = videoId.replace("\\u0026", "&");
//                return String.format(BASE_URL, videoId);
//            } catch (Exception e) {
//                e.printStackTrace();
//                return null;
//            }
//        }
//    }
//}
