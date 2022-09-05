package orm;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class UserRepository {

    private final Connection conn;

    private final UserMapper mapper;

    private final UnitOfWork unitOfWork;

    public UserRepository(Connection conn) {
        this.conn = conn;
        this.mapper = new UserMapper(conn);
        this.unitOfWork = new UnitOfWork(mapper);
    }

    public Optional<User> findById(long id) {
        return Optional.empty();
    }

    public void beginTransaction() {
        try {
            conn.setAutoCommit(false);
            commitTransaction();
        } catch (SQLException e) {
            e.printStackTrace();
            rollbackTransaction();
        }
    }

    public void insert(User user) {
        unitOfWork.registerNew(user);
    }

    public void update(User user) {
        unitOfWork.registerUpdate(user);
    }

    public void delete(User user) {
        unitOfWork.registerDelete(user);
    }

    public void commitTransaction() {
        try {
            unitOfWork.commit();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rollbackTransaction() {
        try {
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
