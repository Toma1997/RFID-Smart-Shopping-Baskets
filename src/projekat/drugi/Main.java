package projekat.drugi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        CashDesk desk1 = (CashDesk) context.getBean("cashDesk");
        System.out.println(desk1.getCashDesk_id());
    }

}
