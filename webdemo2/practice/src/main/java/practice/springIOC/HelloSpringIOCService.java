package practice.springIOC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

public class HelloSpringIOCService {

    //spring配置文件 需要由bean 才能成功注入
    //采用注解注入 不需要setter 或者 constructor  但是本质是setter注入
    @Autowired
    private HelloSpringAnnotation helloSpringAnnotation;

    //spring配置文件 需要由bean 才能成功注入
    //不采用注解注入 需要setter 或者 constructor
    private HelloSpring helloSpring;

    public void setHelloSpringAnnotation(HelloSpringAnnotation helloSpringAnnotation) {
        System.out.println("注解会不会调用setter");
        this.helloSpringAnnotation = helloSpringAnnotation;
    }
    public HelloSpringIOCService() {
        System.out.println("HelloSpringIOCService none arg constructor");
    }

    public HelloSpringIOCService(HelloSpring helloSpring) {
        System.out.println("HelloSpringIOCService one arg constructor");
        this.helloSpring = helloSpring;
    }
    public HelloSpring getHelloSpring() {
        return helloSpring;
    }

    public void setHelloSpring(HelloSpring helloSpring) {
        System.out.println("execute setHelloSpring");
        this.helloSpring = helloSpring;
    }

    public void execute() {
        if (helloSpring != null) {
            System.out.println(helloSpring.toString());
        }else {
            System.out.println("注入失败");
        }
        if (helloSpringAnnotation != null) {
            System.out.println("注入 helloSpringAnnotation 成功");
        }else {
            System.out.println("注入失败");
        }
    }
}
