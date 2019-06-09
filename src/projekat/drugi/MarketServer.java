package projekat.drugi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;

public class MarketServer {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        // 1. PRIMER SA SETTER INJECTION
        CashDesk desk1 = (CashDesk) context.getBean("cashDesk1");
        CashDesk desk2 = (CashDesk) context.getBean("cashDesk2");
        CashDesk desk3 = (CashDesk) context.getBean("cashDesk3");
        CashDesk desk4 = (CashDesk) context.getBean("cashDesk4");
        /////////////////////////////////

        // simulacija baze podataka artikala
        HashMap<String, ArrayList<Article>> articleBase = new HashMap<>();

        ArrayList<Article> cosmeticList = new ArrayList<>();

        // 2. PRIMER SA CONSTRUCTOR INJECTION PREKO TYPE SVOJSTVA
        Article article1 = (Article) context.getBean("article1");
        cosmeticList.add(article1);

        Article article2 = (Article) context.getBean("article2");
        cosmeticList.add(article2);

        Article article3 = (Article) context.getBean("article3");
        cosmeticList.add(article3);

        Article article4 = (Article) context.getBean("article4");
        cosmeticList.add(article4);
        ///////////////////////////////////////

        articleBase.put("cosmetics", cosmeticList);



    }

}
