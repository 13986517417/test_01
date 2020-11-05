package org.java.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class test02 {


    public static String getHtml(String url){
        BufferedReader in = null;

        StringBuffer stringBuffer = new StringBuffer();

        try{
            URL net = new URL(url);
            URLConnection connection = net.openConnection();
            in = new BufferedReader(
                    new InputStreamReader( connection.getInputStream())
            );
            String line = null;
            while ((line = in.readLine()) != null){
                stringBuffer.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("网路超时");
        }finally {
            try {
                in.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        String content = getHtml("https://www.baidu.com/");
        System.out.println(content);
    }

}
