package projekat.drugi;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
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
        articleBase.put("bags", new ArrayList<>());

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
        foodList.add(article5);

        Article article6 = (Article) context.getBean("article6");
        foodList.add(article6);

        Article article7 = (Article) context.getBean("article7");
        foodList.add(article7);

        Article article8 = (Article) context.getBean("article8");
        foodList.add(article8);

        articleBase.put("food", foodList);
        ///////////////////////////////////////

        ArrayList<CashDesk> desks = new ArrayList<>();
        // 4. PRIMER SA INJECTION OBJEKTA U DRUGI OBJEKAT
        CashWorker cashWorker1 = (CashWorker) context.getBean("cashWorker1");
        desk1.setCashWorker(cashWorker1);
        desks.add(desk1);

        CashWorker cashWorker2 = (CashWorker) context.getBean("cashWorker2");
        desk2.setCashWorker(cashWorker2);
        desks.add(desk2);
        ///////////////////////////////////////

        // 5. PRIMER SA INJECTION OBJEKTA U DRUGI OBJEKAT PREKO INNER BEAN KONCEPTA
        CashDesk desk3 = (CashDesk) context.getBean("cashDesk3");
        desks.add(desk3);
        CashDesk desk4 = (CashDesk) context.getBean("cashDesk4");
        desks.add(desk4);
        ///////////////////////////////////////

        // 6. PRIMER SA Autowired ANOTACIJOM ZA AUTOMATSKO OZICAVANJE ZRNA
        Stack<ShoppingBasket> basketsStack = new Stack<>();
        ShoppingBasket shoppingBasket1 = (ShoppingBasket) context.getBean("shoppingBasket1");
        basketsStack.push(shoppingBasket1);

        ShoppingBasket shoppingBasket2 = (ShoppingBasket) context.getBean("shoppingBasket2");
        basketsStack.push(shoppingBasket2);

        ShoppingBasket shoppingBasket3 = (ShoppingBasket) context.getBean("shoppingBasket3");
        basketsStack.push(shoppingBasket3);

        ShoppingBasket shoppingBasket4 = (ShoppingBasket) context.getBean("shoppingBasket4");
        basketsStack.push(shoppingBasket4);
        ////////////////////////////////////////////////////////////////////

        // Simulacija kupovine sa pametnim RFID korpama
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to our supermarket, take your shopping bakset!");
        ShoppingBasket takenBasket = basketsStack.pop();

        do {
            // prikaz dosadasnje kupovine
            System.out.println("For now, in your basket you have:");
            if(takenBasket.getArticlesList().getArticles().size() > 0){
                for (Article a : takenBasket.getArticlesList().getArticles()) {
                    System.out.println(a.toString());
                }
            } else {
                System.out.println("Nothing!");
            }
            String choosenCategory = "";
            do {
                System.out.println("Choose category of articles in which you are interested in:");
                System.out.println("- food");
                System.out.println("- cosmetics");

                choosenCategory = input.nextLine().trim();
            } while (!choosenCategory.equals("food") && !choosenCategory.equals("cosmetics"));

            // odabrana je kategorija
            ArrayList<Article> currentList = articleBase.get(choosenCategory);
            System.out.println("Choose article you want to buy by entering name: ");
            for (Article a : currentList) {
                System.out.println(a.toString());
            }
            Article takenArticle = null;
            String articleName = input.nextLine().trim();
            for (Article a : currentList) {
                if(a.getName().equals(articleName)){
                    takenArticle = a;
                }
            }
            takenBasket.scanArticle(takenArticle, currentList);
            System.out.println("Do you still want to buy something? y/n");
        } while (input.nextLine().equals("y"));

        do{
            if(takenBasket.getArticlesList().getArticles().size() > 0){
                System.out.println("Do you want to take back something? y/n");
                if(input.nextLine().equals("y")){
                    System.out.println("Choose article you want to take out by entering name:");
                    for (Article a : takenBasket.getArticlesList().getArticles()) {
                        System.out.println(a.toString());
                    }
                    Article takenArticle = null;
                    String articleName = input.nextLine().trim();
                    for (Article a : takenBasket.getArticlesList().getArticles()) {
                        if(a.getName().equals(articleName)){
                            takenArticle = a;
                        }
                    }
                    takenBasket.scanArticle(takenArticle, articleBase.get(takenArticle.getCategory()));
                } else {
                    break;
                }
            } else {
                break;
            }
        } while (true);

        // zavrsena kupovina, odlazak na kasu
        CashDesk choosenDesk = null;
        do {
            System.out.println("Choose cash desk where you want to pay with entering cash desk id:");
            for (CashDesk desk : desks) {
                System.out.println(desk.toString());
            }

            int desk_id = input.nextInt();
            for (CashDesk desk : desks) {
                if(desk.getCashDesk_id() == desk_id){
                    choosenDesk = desk;
                }
            }
        } while (choosenDesk == null);

        // placanje svega iz korpe
        double bill = takenBasket.getTotal_price();
        if(choosenDesk.scanShoppingBasket(takenBasket)){
            System.out.printf("Your bill is %.2f euros\n", bill);
            System.out.println("Thank you for buying in our supermarket!");
        } else {
            System.out.println("We hope you will buy something next time.");
        }
    }
}
