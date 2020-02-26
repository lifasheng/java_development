package MyJavaTest;

import DAO.IUserDao;
import DAO.UserDao;
import Model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App
{
    private static Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("test log4j2");

        IUserDao userDao = new UserDao();
        final User user4 = new User(4, "Lily");
        userDao.saveUser(user4);

    }
}


