package repo;

import models.InstallationOptions;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.List;

public class InstallationOptionsRepository implements Repository<InstallationOptions> {

    public InstallationOptionsRepository() {
        initializeDatabase();
    }

    private void initializeDatabase() {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            String sql = """
            CREATE TABLE IF NOT EXISTS installation_options (
                id INT PRIMARY KEY AUTO_INCREMENT,
                documentation_id INT,
                additional_file_id INT,
                pathProgram VARCHAR(255) NOT NULL,
                nameProgram VARCHAR(255) NOT NULL,
                FOREIGN KEY (documentation_id) REFERENCES documentation(id) ON DELETE SET NULL,
                FOREIGN KEY (additional_file_id) REFERENCES additional_files(id) ON DELETE SET NULL
            )
            """;
            stmt.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public InstallationOptions save(InstallationOptions options) {
        String query = "INSERT INTO installation_options (documentation_id, additional_file_id, pathProgram, nameProgram) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, options.getDocumentation().getId());
            statement.setInt(2, options.getAdditionalFile().getId());
            statement.setString(3, options.getPathProgram());
            statement.setString(4, options.getNameProgram());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error creating installation options: " + e.getMessage());
        }
        return null;
    }

    @Override
    public InstallationOptions findById(Long id) {
        String query = "SELECT * FROM installation_options WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new InstallationOptions(
                        resultSet.getInt("id"),
                        resultSet.getString("pathProgram"),
                        resultSet.getString("nameProgram"),
                        new AdditionalFileRepository().findById(resultSet.getLong("additional_file_id")),
                        new DocumentationRepository().findById(resultSet.getLong("documentation_id"))
                );
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving installation options: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<InstallationOptions> findAll() throws SQLException {
        return List.of();
    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
