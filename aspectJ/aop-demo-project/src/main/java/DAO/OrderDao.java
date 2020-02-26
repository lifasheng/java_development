package DAO;

import Model.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrderDao implements IOrderDao {
    private static Logger logger = LogManager.getLogger(OrderDao.class);

    @Override
    public void saveOrder(final Order order) {
        logger.info(order + " has been saved!");
    }
}
