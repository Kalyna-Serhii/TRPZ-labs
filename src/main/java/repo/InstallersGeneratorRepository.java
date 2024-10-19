package repo;

import models.InstallersGenerator;
import models.File;
import models.User;
import models.InstallationOptions;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstallersGeneratorRepository implements Repository<InstallersGenerator> {

    public InstallersGeneratorRepository() {
        initializeDatabase();
    }

    private void initializeDatabase() {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            String sql = """
            CREATE TABLE IF NOT EXISTS installers_generator (
                id INT PRIMARY KEY AUTO_INCREMENT,
                file_id INT,
                user_id INT,
                installation_option INT,
                shortcut BOOLEAN NOT NULL DEFAULT FALSE,
                FOREIGN KEY (file_id) REFERENCES files(id) ON DELETE SET NULL,
                FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE SET NULL,
                FOREIGN KEY (installation_option) REFERENCES installation_options(id) ON DELETE SET NULL
            )
            """;
            stmt.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public InstallersGenerator save(InstallersGenerator installer) {
        String query = "INSERT INTO installers_generator (file_id, user_id, Installation_option, shortcut) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, installer.getFile().getId());
            statement.setInt(2, installer.getUser().getId());
            statement.setInt(3, installer.getInstallationOptions().getId());
            statement.setBoolean(4, installer.isShortcut());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error creating installer: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<InstallersGenerator> findAll() throws SQLException {
        return List.of();
    }

    @Override
    public InstallersGenerator findById(Long id) {
        String query = "SELECT * FROM installers_generator WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Отримуємо пов'язані дані про файл, користувача та опції інсталяції
                File file = new FileRepository().findById(resultSet.getLong("file_id"));
                User user = new UserRepository().findById(resultSet.getLong("user_id"));
                InstallationOptions options = new InstallationOptionsRepository().findById(resultSet.getLong("Installation_option"));

                return new InstallersGenerator(
                        resultSet.getInt("id"),
                        file,
                        user,
                        options,
                        resultSet.getBoolean("shortcut")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving installer: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM installers_generator WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error deleting installer: " + e.getMessage());
        }
    }
}
