package projekat.drugi;

import java.util.ArrayList;

public class ShoppingBasket {

    private int basket_id;
    private ArrayList<Article> articles;
    private double total_price;
    private boolean isActive;

    public ShoppingBasket() {
        this.articles = new ArrayList<>();
        this.total_price = 0.0;
        this.isActive = false;
    }

    public ShoppingBasket(int basket_id, ArrayList<Article> articles, int total_price, boolean isActive) {
        this.basket_id = basket_id;
        this.articles = articles;
        this.total_price = total_price;
        this.isActive = false;
    }

    public int getBasket_id() {
        return basket_id;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean scanArticle(Article article, ArrayList<Article> articleBase){
        for(Article a : this.articles){
            if(a.getRfid_num() == article.getRfid_num()){
                this.articles.remove(a); // take article out from basket
                articleBase.add(article); // get back in market system
                this.total_price -= a.getPrice();

                if(this.articles.isEmpty()){
                    this.isActive = false;
                }
                return true;
            }
        }

        // article is not in the basket so check if it is in whole system
        for(Article a : articleBase){
            if(a.getRfid_num() == article.getRfid_num()){

                if(this.articles.isEmpty()){
                    this.isActive = true;
                }
                this.articles.add(a); // putted article into the basket
                articleBase.remove(article); // removed from the system
                this.total_price += a.getPrice();
                return true;
            }
        }

        return false; // article is not in the system
    }
}
