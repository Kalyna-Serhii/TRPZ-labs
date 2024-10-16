package repo;

import models.AdditionalFile;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.List;

public class AdditionalFileRepository implements Repository<AdditionalFile> {

    public AdditionalFileRepository() {
        initializeDatabase();
    }

    private void initializeDatabase() {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            String sql = """
            CREATE TABLE IF NOT EXISTS additional_files (
                id INT PRIMARY KEY AUTO_INCREMENT,
                fileName VARCHAR(255) NOT NULL,
                size BIGINT NOT NULL,
                path VARCHAR(255) NOT NULL,
                protection_params VARCHAR(255)
            )
            """;
            stmt.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public AdditionalFile save(AdditionalFile additionalFile) {
        String query = "INSERT INTO additional_files (fileName, size, path, protection_params) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, additionalFile.getFileName());
            statement.setLong(2, additionalFile.getSize());
            statement.setString(3, additionalFile.getPath());
            statement.setString(4, additionalFile.getProtectionParams());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error creating additional file: " + e.getMessage());
        }
        return null;
    }

    @Override
    public AdditionalFile findById(Long id) {
        String query = "SELECT * FROM additional_files WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new AdditionalFile(
                        resultSet.getInt("id"),
                        resultSet.getString("fileName"),
                        resultSet.getLong("size"),
                        resultSet.getString("path"),
                        resultSet.getString("protection_params")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving additional file: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<AdditionalFile> findAll() throws SQLException {
        return List.of();
    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
