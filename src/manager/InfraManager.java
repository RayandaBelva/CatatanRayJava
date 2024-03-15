package src.manager;

import java.sql.Connection;
import java.sql.SQLException;

public interface InfraManager {
    Connection getConnection() throws SQLException;
}
