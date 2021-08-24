package com.flycat.common_practice.adapter;

import java.io.*;
import java.util.Date;
import java.util.Properties;

public class Adapter {
    /**
     * 使用继承 和 使用委托
     * client
     * use
     * target               adapter               adaptee
     * 我们把需求         用别人的方法来        被用来满足需求的
     * 定义为接口         实现目标的需求        道具
     * 因为它不需         继承道具 或者
     * 要关心具体的       封装道具
     * 实现
     */
    public static void main(String[] args) {
        FileIO fileIO = new FilePropertiesAdapter("D:\\java_project\\webdemo\\webdemo2\\webdemo2\\src\\main\\resources\\config");
        fileIO.setValue("name","tome");
        System.out.println(fileIO.getValue("name"));
        try {
            fileIO.writeToFile("D:\\java_project\\webdemo\\webdemo2\\webdemo2\\src\\main\\resources\\newfile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
interface FileIO {
    void readFromFile(String fileName);

    void writeToFile(String fileName) throws IOException;

    void setValue(String key, String value);

    String getValue(String key);
}
class FilePropertiesAdapter extends Properties implements FileIO{
    public FilePropertiesAdapter(String path) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(path));
            super.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void readFromFile(String fileName) {
        new FilePropertiesAdapter(fileName);
    }

    @Override
    public void writeToFile(String fileName) throws IOException{
        super.store(new FileOutputStream(new File(fileName)),"written adapter \n"+ new Date().toString());
    }

    @Override
    public void setValue(String key, String value) {
        super.setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return (String) super.get(key);
    }
}