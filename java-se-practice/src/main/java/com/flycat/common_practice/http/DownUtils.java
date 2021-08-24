package com.flycat.common_practice.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownUtils {
    private String path;
    private String targetFile;
    private int threadNum;
    private DownThread [] threads;
    private int fileSize;

    public DownUtils(String path, String targetFile, int threadNum) {
        this.path = path;
        this.targetFile = targetFile;
        this.threadNum = threadNum;
        threads = new DownThread[threadNum];
    }
    public static void main(String[] args){
        try {
            final DownUtils downUtils = new DownUtils("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2231340450,166221174" +
                    "1&fm=173&app=25&f=JPEG?w=640&h=373&s=969317CF44D2CDD61A2369260300A058","ios.png",4);
            downUtils.download();
            new Thread(){
                @Override
                public void run() {
                    while (downUtils.getCompleteRate()<1){
                        System.out.println("进度  :"+downUtils.getCompleteRate()*100+"%");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void download() throws Exception{
        URL url = new URL(path);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept","image/git,image/jpeg,image/pjpeg,");
        connection.setRequestProperty("Accept-Language","zh-CN");
        connection.setRequestProperty("Charset","UTF-8");
        connection.setRequestProperty("Connection","Keep-Alive");
        fileSize = connection.getContentLength();
        connection.disconnect();
        int currentSize = fileSize / threadNum+1;
        RandomAccessFile randomAccessFile = new RandomAccessFile(targetFile,"rw");
        randomAccessFile.setLength(fileSize);
        randomAccessFile.close();
        for(int i=0;i<threads.length;i++){
            int startPos = i*currentSize;
            RandomAccessFile currentPart = new RandomAccessFile(targetFile,"rw");
            currentPart.seek(startPos);
            threads[i] =  new DownThread(startPos,currentSize,currentPart);
            threads[i].start();
        }
    }
    public double getCompleteRate(){
        int sumSize = 0;
        for(int i=0;i<threadNum;i++){
            sumSize += threads[i].length;
        }
        return sumSize *1.0/fileSize;
    }
    class DownThread extends Thread {
        private int startPos;
        private int currentPartSize;
        private RandomAccessFile currentParrt;
        public int length;
        public DownThread(int startPos,int currentPartSize,RandomAccessFile currentParrt){
            this.startPos = startPos;
            this.currentPartSize = currentPartSize;
            this.currentParrt = currentParrt;
        }
        @Override
        public void run() {
            super.run();
            try {
                URL url = new URL(path);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Accept","image/git,image/jpeg,image/pjpeg,");
                connection.setRequestProperty("Accept-Language","zh-CN");
                connection.setRequestProperty("Charset","UTF-8");
//                connection.setRequestProperty("Connection","Keep-Alive");
                InputStream inputStream = connection.getInputStream();
                inputStream.skip(this.startPos);
                byte[] buffer = new byte[1024];
                int hasRead = 0;
                while (length<currentPartSize && (hasRead = inputStream.read(buffer))!=-1){
                    currentParrt.write(buffer,0,hasRead);
                    length +=hasRead;
                }
                currentParrt.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
