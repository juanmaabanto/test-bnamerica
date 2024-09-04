import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBase {
    private final String url;
    private final String user;
    private final String password;

    public DataBase(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void save(String value) {
        String insertSQL = "INSERT INTO";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = conn.prepareStatement(insertSQL)) {

            statement.setString(1, value);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
