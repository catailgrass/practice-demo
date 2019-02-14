package practice.springIOC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class HelloSpringIOCService_annotaion {
    @Autowired

    private HelloSpring helloSpring;

    public HelloSpringIOCService_annotaion(){
        System.out.println("HelloSpringIOCService_annotaion");
    }
    public void execute() {
        System.out.println("execute HelloSpringIOCService_annotaion");
    }
}
