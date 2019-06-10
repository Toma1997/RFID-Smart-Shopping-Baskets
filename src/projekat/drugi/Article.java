package projekat.drugi;

public class Article {

    private String name;
    private String category;
    private double price;
    private int rfid_num;

    public Article() {

    }

    public Article(String name, String category, double price, int rfid_num) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.rfid_num = rfid_num;

    }

    public int getRfid_num() {
        return this.rfid_num;
    }

    public void setRfid_num(int rfid_num) {
        this.rfid_num = rfid_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Article{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", rfid_num=" + rfid_num +
                '}';
    }
}
