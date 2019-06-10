package projekat.drugi;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class MarketServer {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        // 1. PRIMER SA SETTER INJECTION
        CashDesk desk1 = (CashDesk) context.getBean("cashDesk1");
        CashDesk desk2 = (CashDesk) context.getBean("cashDesk2");
        /////////////////////////////////

        // simulacija baze podataka artikala
        HashMap<String, ArrayList<Article>> articleBase = new HashMap<>();

        // 2. PRIMER SA CONSTRUCTOR INJECTION PREKO TYPE SVOJSTVA
        ArrayList<Article> cosmeticList = new ArrayList<>();

        Article article1 = (Article) context.getBean("article1");
        cosmeticList.add(article1);

        Article article2 = (Article) context.getBean("article2");
        cosmeticList.add(article2);

        Article article3 = (Article) context.getBean("article3");
        cosmeticList.add(article3);

        Article article4 = (Article) context.getBean("article4");
        cosmeticList.add(article4);

        articleBase.put("cosmetics", cosmeticList);
        ///////////////////////////////////////

        // 3. PRIMER SA CONSTRUCTOR INJECTION PREKO INDEX SVOJSTVA
        ArrayList<Article> foodList = new ArrayList<>();

        Article article5 = (Article) context.getBean("article5");
        cosmeticList.add(article5);

        Article article6 = (Article) context.getBean("article6");
        cosmeticList.add(article6);

        Article article7 = (Article) context.getBean("article7");
        cosmeticList.add(article7);

        Article article8 = (Article) context.getBean("article8");
        cosmeticList.add(article8);

        articleBase.put("food", foodList);
        ///////////////////////////////////////

        // 4. PRIMER SA INJECTION OBJEKTA U DRUGI OBJEKAT
        CashWorker cashWorker1 = (CashWorker) context.getBean("cashWorker1");
        desk1.setCashWorker(cashWorker1);

        CashWorker cashWorker2 = (CashWorker) context.getBean("cashWorker2");
        desk2.setCashWorker(cashWorker2);
        ///////////////////////////////////////

        // 5. PRIMER SA INJECTION OBJEKTA U DRUGI OBJEKAT PREKO INNER BEAN KONCEPTA
        CashDesk desk3 = (CashDesk) context.getBean("cashDesk3");
        CashDesk desk4 = (CashDesk) context.getBean("cashDesk4");
        ///////////////////////////////////////

        // 6. PRIMER SA Autowired anotacijom za automatsko ozicavanje zrna
        Stack<ShoppingBasket> basketsStack = new Stack<>();
        ShoppingBasket shoppingBasket1 = (ShoppingBasket) context.getBean("shoppingBasket1");
        basketsStack.push(shoppingBasket1);

        ShoppingBasket shoppingBasket2 = (ShoppingBasket) context.getBean("shoppingBasket2");
        basketsStack.push(shoppingBasket1);

        ShoppingBasket shoppingBasket3 = (ShoppingBasket) context.getBean("shoppingBasket3");
        basketsStack.push(shoppingBasket1);

        ShoppingBasket shoppingBasket4 = (ShoppingBasket) context.getBean("shoppingBasket4");
        basketsStack.push(shoppingBasket1);

        System.out.println(shoppingBasket1.getArticlesList().getArticles().size());
        System.out.println(shoppingBasket2.getArticlesList().getArticles().size());
        System.out.println(shoppingBasket3.getArticlesList().getArticles().size());
        System.out.println(shoppingBasket4.getArticlesList().getArticles().size());

    }

}
