package practice.springIOC;

import java.util.Random;

public class HelloSpring {
    private String name;
    public HelloSpring(){
        this.name = ""+new Random().nextInt();
        System.out.println("执行了HelloSpring constructor "+name);
    }
    public String toString() {
        return "hello spring IOC."+name;
    }
}
