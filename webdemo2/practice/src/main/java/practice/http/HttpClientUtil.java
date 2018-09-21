package practice.http;


import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import practice.util.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.UnsupportedCharsetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {
    public static String doGet(String url) throws Exception{
        String result = "";
        try {
            URL resultUrl = new URL(url);
            URLConnection connection = resultUrl.openConnection();
            connection.setRequestProperty("accept","*/*");
            connection.setRequestProperty("connection","Keep-Alive");
//            connection.setRequestProperty("user-agent","*/*");
            connection.connect();
            Map<String,List<String>> headerMap = connection.getHeaderFields();
            for (String key:headerMap.keySet()){
                System.out.println(key+"----------->>"+headerMap.get(key));
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
            String line;
            while ((line = bufferedReader.readLine())!=null){
                result+=line+"\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    @Deprecated
    public static String doPost(String url,String json,int timeout) throws Exception{
        String result = "";
        try {
            URL resultUrl = new URL(url);
//            URLConnection 标识应用程序与url之间的通信链接
            //应用程序与 url之间的 http链接  有 setRequestMethod
            HttpURLConnection connection = (HttpURLConnection)resultUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            connection.setConnectTimeout(timeout);
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setRequestProperty("Charset", "UTF-8");
            // 设置文件类型:
            connection.setRequestProperty("Content-Type","application/json; charset=UTF-8");
            // 设置接收类型否则返回415错误
            //conn.setRequestProperty("accept","*/*")此处为暴力方法设置接受所有类型，以此来防范返回415;
            connection.setRequestProperty("accept","application/json");
            if(!StringUtils.isEmpty(json)){
                byte[] bytes = json.getBytes();
                connection.setRequestProperty("Content-Length",""+bytes.length);
                connection.connect();
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(bytes);
                outputStream.flush();
                outputStream.close();
            }
            if(connection.getResponseCode() == 200){
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    result = line;
                }
            }
//            Map<String,List<String>> headerMap = connection.getHeaderFields();
//            for (String key:headerMap.keySet()){
//                System.out.println(key+"----------->>"+headerMap.get(key));
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String doPostNew(String url,Map<String,String>headers,String json,int timeout,String encodeType) throws Exception{
        String result = "";
//        CloseableHttpClient httpClient = HttpClients.custom().build();
//        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        if(headers== null|| headers.size()==0){
            headers = new HashMap<>();
            headers.put("Accept","application/json ");
            headers.put("Content-Type","application/json;charset="+encodeType);
        }
        HttpPost httpPost = new HttpPost(url);
        for(String key:headers.keySet())
            httpPost.setHeader(key,headers.get(key));
        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(timeout).setSocketTimeout(timeout).build();
        httpPost.setConfig(requestConfig);
        try {
            httpPost.setEntity(new StringEntity(json,encodeType));
            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            result = EntityUtils.toString(httpEntity);
        } catch (UnsupportedCharsetException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
