import java.util.Objects;

public class Config {
    public static class ApiConfig {
        public final String apiPort;

        public ApiConfig(String apiPort) {
            this.apiPort = apiPort;
        }
    }

    public static class DbConfig {
        public final String host;
        public final String port;
        public final String name;
        public final String user;
        public final String password;
        public final String driver;

        public DbConfig(String host, String port, String name, String user, String password, String driver) {
            this.host = host;
            this.port = port;
            this.name = name;
            this.user = user;
            this.password = password;
            this.driver = driver;
        }
    }

    public final ApiConfig apiConfig;
    public final DbConfig dbConfig;

    public Config(ApiConfig apiConfig, DbConfig dbConfig) {
        this.apiConfig = Objects.requireNonNull(apiConfig);
        this.dbConfig = Objects.requireNonNull(dbConfig);
    }

    public static Config loadConfig() throws Exception {
        String apiPort = Objects.requireNonNull(System.getenv("API_PORT"));
        String dbHost = Objects.requireNonNull(System.getenv("DB_HOST"));
        String dbPort = Objects.requireNonNull(System.getenv("DB_PORT"));
        String dbName = Objects.requireNonNull(System.getenv("DB_NAME"));
        String dbUser = Objects.requireNonNull(System.getenv("DB_USER"));
        String dbPassword = Objects.requireNonNull(System.getenv("DB_PASSWORD"));
        String dbDriver = Objects.requireNonNull(System.getenv("DB_DRIVER"));

        return new Config(
            new ApiConfig(apiPort),
            new DbConfig(dbHost, dbPort, dbName, dbUser, dbPassword, dbDriver)
        );
    }

    public static void main(String[] args) {
        try {
            Config config = Config.loadConfig();
            // Do something with config
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exception
        }
    }
}