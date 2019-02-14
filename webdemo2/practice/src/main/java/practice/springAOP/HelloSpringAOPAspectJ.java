package practice.springAOP;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class HelloSpringAOPAspectJ {

    @Before("execution(* practice.springAOP.HelloSpringAOP.*(..))")
    public void before() {
        System.out.println("do something before say hello springAOP");
    }
    @AfterReturning("execution(* practice.springAOP.HelloSpringAOP.execute(..))")
    public void afterReturn() {
        System.out.println("after say Hello ,do sth");
    }
}
