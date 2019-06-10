package projekat.drugi;

import java.util.ArrayList;
import java.util.List;


public class ArticlesList {

    private List<Article> articles;

    public ArticlesList() {
        this.articles = new ArrayList<>();
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

}
