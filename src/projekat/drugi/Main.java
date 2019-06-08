package projekat.drugi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        CashDesk desk1 = (CashDesk) context.getBean("cashDesk");
        System.out.println(desk1.getCashDesk_id());

        // simulation of articles database
        HashMap<String, ArrayList<Article>> articleBase = new HashMap<>();

        ArrayList<Article> cosmeticList = new ArrayList<>();

        Article article1 = new Article("Nivea shampoo", "cosmetics", 8.5, 1);
        cosmeticList.add(article1);

        Article article2 = new Article("STR8 gel", "cosmetics", 3.45, 2);
        cosmeticList.add(article2);

        Article article3 = new Article("Sensodyne tooth brush", "cosmetics", 2.15, 3);
        cosmeticList.add(article3);

        Article article4 = new Article("STR8 aftershave gel", "cosmetics", 3.0, 4);
        cosmeticList.add(article4);

        articleBase.put("cosmetics", cosmeticList);



    }

}
