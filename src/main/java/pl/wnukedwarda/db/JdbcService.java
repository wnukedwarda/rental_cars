package pl.wnukedwarda.db;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcService {

    protected final ConnectionProvider connectionProvider;

    public JdbcService(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    public void doWtihConnection(ConnectionConsumer callback) {

        try (Connection connection = connectionProvider.getConnection()) {
            callback.accept(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FunctionalInterface
    public interface ConnectionConsumer {
        void accept(Connection connection) throws SQLException;
    }
}
