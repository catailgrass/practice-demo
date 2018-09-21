package practice.reflect;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
/**
 * 1，类的加载 jvm把类的class文件 加载到内存 并分配 lang.Class 对象
 * 2，类的连接
 * 3，类的初始化 （如果父类没有被初始化 则线初始化父类）静态变量（初始化块）   依次执行
 * 4，类初始化的时机：
 * 创建类的实例
 * 调用类的静态成员
 * 强制初始化 Class.forName()
 * 初始化子类
 * java.exe 运行 class
 */
public class MyClassLoader {
    private static Properties properties = new Properties();
    private static Map<String, Object> objectMap = new HashMap<>();
    private static String path = "D:\\java_project\\webdemo2\\src\\main\\resources\\config";
    public static void init(){
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(path));
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object getObjectMem(String key) {
        return objectMap.get(key);
    }
    public static void test(){
        try {
            //类的反射 对象的实例化
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
//            classLoader.loadClass("practice.reflect.Person");
            Class.forName("practice.reflect.Person").newInstance();
            Class clazz = Class.forName("practice.reflect.Person");
            Constructor constructor = clazz.getConstructor(String.class, String.class);
            Person person = (Person) constructor.newInstance("12", "jack");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[]args){
//        test();
        //类的加载 连接 初始化 方法的调用
        init();
        initProperty();
    }
    public static void initProperty(){
        try {

            for (String key : properties.stringPropertyNames()) {
                String content = (String) properties.get(key);
                if (key.contains("%")) {
                    String value = key.split("%")[0];
                    String attr = key.split("%")[1];
                    Object object = getObjectMem(value);
                    Class<?> clazz = object.getClass();
                    Method set = clazz.getMethod("set" +attr.substring(0,1).toUpperCase()
                            +attr.substring(1),String.class);
                    set.invoke(object,content);
                } else {
                    objectMap.put(key, createObject(content));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Object createObject(String clazzName) throws Exception{
        return Class.forName(clazzName).newInstance();
    }
}
class Person{
    private int age = 16;
    private String name = "jack";
    static {
        System.out.println("Person 被初始化了");
    }

    public Person() {
        System.out.println("Person 的无参构造器");
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
        System.out.println("我叫"+name+"，今年"+age+"岁");
        System.out.println("Person 有参构造器");
    }
    public void selfIntroduct(){
        System.out.println("我叫"+name+"，今年"+age+"岁");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.selfIntroduct();
    }
}