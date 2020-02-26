package DAO;

import Aspect.TimeMetric;
import Model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserDao implements IUserDao {

    private static Logger logger = LogManager.getLogger(UserDao.class);

    @TimeMetric
    @Override
    public void saveUser(final User user) {
        logger.info(user + " has been saved!");
    }
}
