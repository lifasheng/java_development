package Model;

import java.util.List;


public class Order {
    private int id;
    private User user;
    private List<String> products;
    private double totalPrice;

    public Order(int id, User user, List<String> products, double totalPrice) {
        this.id = id;
        this.user = user;
        this.products = products;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", products=" + products +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
