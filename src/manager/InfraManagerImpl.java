package src.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import src.config.Config;

public class InfraManagerImpl implements InfraManager {
    private Config cfg;

    public InfraManagerImpl(Config cfg) {
        this.cfg = cfg;
    }

    @Override
    public Connection getConnection() throws SQLException {
        try {
            Class.forName(cfg.dbConfig.driver);
            String url = String.format("jdbc:postgresql://%s:%s/%s", cfg.dbConfig.host, cfg.dbConfig.port, cfg.dbConfig.name);
            return DriverManager.getConnection(url, cfg.dbConfig.user, cfg.dbConfig.password);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Database driver not found", e);
        }
    }
}