package DAO;

import Model.Order;

public interface IOrderDao {
    void saveOrder(final Order order);
}
