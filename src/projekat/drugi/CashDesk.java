package projekat.drugi;

public class CashDesk {

    private int cashDesk_id;
    private CashWorker cashWorker;

    public int getCashDesk_id() {
        return cashDesk_id;
    }

    public void setCashDesk_id(int cashDesk_id) {
        this.cashDesk_id = cashDesk_id;
    }

    public CashWorker getCashWorker() {
        return cashWorker;
    }

    public void setCashWorker(CashWorker cashWorker) {
        this.cashWorker = cashWorker;
    }

    public boolean scanShoppingBasket(ShoppingBasket shoppingBasket){
        if(!shoppingBasket.isActive()){
            return false;
        } else {
            // resetuj korpu
            shoppingBasket.setArticles(null);
            shoppingBasket.setTotal_price(0.0);
            shoppingBasket.setActive(false);
            return true;
        }
    }

    @Override
    public String toString() {
        return "CashDesk{" +
                "cashDesk_id=" + cashDesk_id +
                ", cashWorker id =" + cashWorker.getWorker_id() +
                ", cashWorker name =  " + cashWorker.getName() +
                ", cashWorker experience " + cashWorker.getExperienceWithBaskets() +
                '}';
    }
}
