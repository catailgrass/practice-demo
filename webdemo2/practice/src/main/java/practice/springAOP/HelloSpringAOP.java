package practice.springAOP;

import org.springframework.stereotype.Component;

@Component
public class HelloSpringAOP {
    public HelloSpringAOP() {

    }
    public void execute() {
        System.out.println("Hello spring AOP ");
    }
}
