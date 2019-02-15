package practice;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import practice.springAOP.HelloSpringAOP;
import practice.springIOC.HelloSpringIOCService;
import practice.springIOC.HelloSpringIOCService_annotaion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:springAOP.xml")
public class Test {
    @Autowired
    public HelloSpringAOP helloSpringAOP;
    @org.junit.Test
    public void test () {
        byte[] bytes = "ndfasdfa".getBytes();
        byte[] bytess = " ".getBytes();
        for (byte b: bytes
             ) {
            System.out.print(b);
            System.out.println(new String(new byte[]{
                    b
            }));
        }
        System.out.println(new String(bytes));
        System.out.println(new String(bytess));
    }
    @org.junit.Test
    public void testSpringIOC() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        HelloSpringIOCService_annotaion he = (HelloSpringIOCService_annotaion)applicationContext.getBean("helloSpringIOCService_annotaion");
        he.execute();
        HelloSpringIOCService helloSpring = (HelloSpringIOCService) applicationContext.getBean("helloSpringIOCService");
        helloSpring.execute();
    }
    @org.junit.Test
    public void testSpringAOP() {
        helloSpringAOP.execute();

    }
}
