package projekat.drugi;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {

    private int basket_id;
    //@Autowired
    private ArticlesList articlesList;
    private double total_price;
    private boolean isActive;

    public ShoppingBasket() {
        this.articlesList = new ArticlesList();
    }

    /* @Autowired
    public ShoppingBasket(int basket_id, ArticlesList articlesList, int total_price, boolean isActive) {
        this.basket_id = basket_id;
        this.articlesList = articlesList;
        this.total_price = total_price;
        this.isActive = isActive;
    } */

    public int getBasket_id() {
        return basket_id;
    }

    public void setBasket_id(int basket_id) {
        this.basket_id = basket_id;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public ArticlesList getArticlesList() {
        return articlesList;
    }

    @Autowired
    public void setArticlesList(ArticlesList articlesList) {
        this.articlesList = articlesList;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean scanArticle(Article article, ArrayList<Article> articleBase){
        for(Article a : this.articlesList.getArticles()){
            if(a.getRfid_num() == article.getRfid_num()){
                List<Article> temp = this.articlesList.getArticles();
                temp.remove(a); // izvucen artikal iz korpe
                this.articlesList.setArticles(temp);
                articleBase.add(article); // i vracen u sistem marketa
                this.total_price -= a.getPrice();

                if(this.articlesList.getArticles().isEmpty()){
                    this.isActive = false;
                }
                return true;
            }
        }

        // ako artikal nije u korpi, proveri jel u sistemu
        for(Article a : articleBase){
            if(a.getRfid_num() == article.getRfid_num()){

                if(this.articlesList.getArticles().isEmpty()){
                    this.isActive = true;
                }
                List<Article> temp = this.articlesList.getArticles();
                temp.add(a); // ubacen artikal u korpu
                this.articlesList.setArticles(temp);
                articleBase.remove(article); // i izbacen iz sistema
                this.total_price += a.getPrice();
                return true;
            }
        }

        return false; // artikal ne postoji ni u sistemu / donesen iz druge prodavnice
    }

}
