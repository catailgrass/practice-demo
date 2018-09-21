
import com.flycat.model.Admin;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.List;

public class Test {

    @org.junit.Test
    public void annotationTest(){
        try {
            Annotation[] annotations = new Admin().getClass().getMethod("getuName").getAnnotations();
            Method [] methods = Class.forName("com.flycat.model.Admin").getMethods();
            for (Method method : methods) {
                System.out.println(method.getName());
                try {
                    if (method.getName().equals("toString"))
                        System.out.println(method.getAnnotations().length);
//                        method.invoke(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            for (Annotation annotation : annotations)
                System.out.println(annotation.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
