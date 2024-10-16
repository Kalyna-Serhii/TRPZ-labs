package repo;

import models.Documentation;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.List;

public class DocumentationRepository implements Repository<Documentation> {

    public DocumentationRepository() {
        initializeDatabase();
    }

    private void initializeDatabase() {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            String sql = """
            CREATE TABLE IF NOT EXISTS documentation (
                id INT PRIMARY KEY AUTO_INCREMENT,
                License VARCHAR(255) NOT NULL,
                user_id INT,
                Info TEXT,
                FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE SET NULL
            )
            """;
            stmt.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Documentation save(Documentation documentation) {
        String query = "INSERT INTO documentation (License, user_id, Info) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, documentation.getLicense());
            statement.setInt(2, documentation.getUser_id().getId());
            statement.setString(3, documentation.getInfo());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error creating documentation: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Documentation findById(Long id) {
        String query = "SELECT * FROM documentation WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Documentation(
                        resultSet.getInt("id"),
                        new UserRepository().findById(resultSet.getLong("user_id")),
                        resultSet.getString("License"),
                        resultSet.getString("Info")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving documentation: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Documentation> findAll() throws SQLException {
        return List.of();
    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
