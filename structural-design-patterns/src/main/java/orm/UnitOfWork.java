package orm;

import java.util.ArrayList;
import java.util.List;

public class UnitOfWork {

    private final UserMapper userMapper;

    private final List<User> newUsers = new ArrayList<>();
    private final List<User> updateUsers = new ArrayList<>();
    private final List<User> deleteUsers = new ArrayList<>();

    public UnitOfWork(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void registerNew(User user) {
        this.newUsers.add(user);
    }

    public void registerUpdate(User user) {
        this.updateUsers.add(user);
    }

    public void registerDelete(User user) {
        this.deleteUsers.add(user);
    }

    public void commit() {
        for (User user: newUsers) {
            userMapper.insert(user);
        }
        for (User user: updateUsers) {
            userMapper.update(user);
        }
        for (User user: deleteUsers) {
            userMapper.delete(user);
        }

    }
}
