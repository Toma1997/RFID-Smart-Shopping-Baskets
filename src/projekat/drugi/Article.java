package projekat.drugi;

public class Article {

    private String name;
    private String category;
    private double price;
    private int [] barcode;


    public Article(String name, String category, double price, int[] barcode) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.barcode = barcode;

    }

    public int[] getBarcode() {
        return barcode;
    }

    public void setBarcode(int[] barcode) {
        this.barcode = barcode;
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
}
