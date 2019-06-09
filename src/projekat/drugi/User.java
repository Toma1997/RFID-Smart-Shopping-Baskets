package projekat.drugi;

public class User {

    private int user_id;
    private String name;
    private double moneyForShopping;

    public User() {

    }

    public User(int user_id, String name, double moneyForShopping) {
        this.user_id = user_id;
        this.name = name;
        this.moneyForShopping = moneyForShopping;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoneyForShopping() {
        return moneyForShopping;
    }

    public void setMoneyForShopping(double moneyForShopping) {
        this.moneyForShopping = moneyForShopping;
    }
}
