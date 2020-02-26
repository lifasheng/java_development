package Proxy;

import DAO.IUserDao;
import Model.User;

public class UserDaoProxy implements IUserDao {
    private final IUserDao target;

    public UserDaoProxy(final IUserDao target) {
        this.target = target;
    }

    @Override
    public void saveUser(final User user) {
        final long startTime = System.currentTimeMillis();
        System.out.println("start transaction in UserDaoProxy.");
        target.saveUser(user);
        System.out.println("commit transaction in UserDaoProxy.");
        final long duration = System.currentTimeMillis() - startTime;
        System.out.println("duration in UserDaoProxy: " + duration);
    }
}
