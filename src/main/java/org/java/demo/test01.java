package org.java.demo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;


public class test01 {


    private static String httpRequest(String requestUrl) throws IOException {
        StringBuffer buffer = null;
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        InputStream inputStream = null;
        HttpURLConnection httpURLConn = null;
        try {
            //建立get请求
            URL url = new URL(requestUrl);
            httpURLConn = (HttpURLConnection) url.openConnection();
            httpURLConn.setDoInput(true);
            httpURLConn.setRequestMethod("GET");
            //获取输入流
            inputStream = httpURLConn.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            //从输入流读取结果
            buffer = new StringBuffer();
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null)
                bufferedReader.close();
            if (inputStreamReader != null)
                inputStreamReader.close();
            if (inputStream != null)
                inputStream.close();
            if (httpURLConn != null)
                httpURLConn.disconnect();
        }
        return buffer.toString();
    }

    public static void main(String[] args) throws IOException {
        String html = httpRequest("https://www.zhihu.com/");
        String value = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = df.format(new Date());
        System.out.println(html);
    }
}
