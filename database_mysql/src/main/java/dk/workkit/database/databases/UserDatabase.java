package dk.workkit.database.databases;

import dk.workkit.database.connector.DbConnection;
import dk.workkit.database.tools.InsertStatementBuilder;
import dk.workkit.domain.User;
import dk.workkit.exceptions.repository.RepositoryException;
import dk.workkit.exceptions.repository.UniqueFieldViolationException;
import dk.workkit.repositories.UserRepository;
import dk.workkit.tools.FilterBuilder;

import java.sql.*;
import java.util.List;
import java.util.UUID;

public class UserDatabase implements UserRepository {

    private final static String TABLE_NAME = "users";
    private final Connection connection;

    public UserDatabase() {
        this.connection = DbConnection.getConnection();
    }

    @Override
    public User save(User user) {
        try {
            String uuid = UUID.randomUUID().toString();
            PreparedStatement stmt = new InsertStatementBuilder(connection, TABLE_NAME)
                    .set("ID", uuid)
                    .set("USERNAME", user.getUsername())
                    .set("EMAIL", user.getEmail())
                    .set("PASSWORD", user.getPassword())
                    .set("FIRST_NAME", user.getFirstName())
                    .set("LAST_NAME", user.getLastName())
                    .build();
            stmt.executeUpdate();
            User savedUser = new User.UserBuilder(user).setId(uuid).build();
            return savedUser;
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new UniqueFieldViolationException(e.getMessage(), e);
        } catch (SQLException e) {
            throw new RepositoryException("Could not insert user", e);
        }
    }

    @Override
    public void delete(User user) {
    }

    @Override
    public void delete(String id) {
    }

    @Override
    public User get(String id) {
        try {
            String query = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);

        } catch (SQLException e) {

        }
        return null;

    }

    @Override
    public List<User> filter(FilterBuilder filter, int from, int to) {
        return null;
    }
}
