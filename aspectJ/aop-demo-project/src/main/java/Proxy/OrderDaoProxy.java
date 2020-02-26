package Proxy;

import DAO.IOrderDao;
import Model.Order;

public class OrderDaoProxy implements IOrderDao {

    private IOrderDao target;

    public OrderDaoProxy(final IOrderDao target) {
        this.target = target;
    }

    @Override
    public void saveOrder(Order order) {
        final long startTime = System.currentTimeMillis();
        System.out.println("start transaction in OrderDaoProxy.");
        target.saveOrder(order);
        System.out.println("commit transaction in OrderDaoProxy.");
        final long duration = System.currentTimeMillis() - startTime;
        System.out.println("duration in OrderDaoProxy: " + duration);
    }
}
