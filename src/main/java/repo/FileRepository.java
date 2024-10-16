package repo;

import models.File;
import utils.DatabaseConnection;

import java.sql.*;
import java.sql.SQLException;
import java.util.List;

public class FileRepository implements Repository<File> {

    public FileRepository() {
        initializeDatabase();
    }

    private void initializeDatabase() {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            String sql = """
            CREATE TABLE IF NOT EXISTS files (
                id INT PRIMARY KEY AUTO_INCREMENT,
                fileName VARCHAR(255) NOT NULL,
                size BIGINT NOT NULL,
                path VARCHAR(255) NOT NULL
            )
            """;
            stmt.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public File save(File file) {
        String query = "INSERT INTO files (fileName, size, path) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, file.getFileName());
            statement.setLong(2, file.getSize());
            statement.setString(3, file.getPath());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error creating file: " + e.getMessage());
        }
        return null;
    }

    @Override
    public File findById(Long id) throws SQLException {
        String query = "SELECT * FROM files WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new File(
                        resultSet.getInt("id"),
                        resultSet.getString("fileName"),
                        resultSet.getLong("size"),
                        resultSet.getString("path")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving file: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<File> findAll() throws SQLException {
        return List.of();
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM files WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error deleting file: " + e.getMessage());
        }
    }
}
