package mywardrobeprogram.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import mywardrobeprogram.model.User;

/**
 *
 * @author Natalia Luiz
 */
public class WardrobeDao {

    private static final String FIND_USER_BY_USERNAME_QUERY = ""
            + " SELECT "
            + "     userID,"
            + "     username,"
            + "     surname,"
            + "     password"
            + " FROM "
            + "     Users "
            + " WHERE "
            + "     username = ?";
    private static final String INSERT_NEW_USER
            = "   INSERT INTO "
            + "     Users(name, surname, username, password) "
            + " VALUES(?, ?, ?, ?)";

    private static final String PROP_URL = "jdbc.url";
    private static final String PROP_USERNAME = "jdbc.username";
    private static final String PROP_PASSWORD = "jdbc.password";

    private Connection wardrobeConnection;
    private static WardrobeDao instance;

    private WardrobeDao() throws SQLException {
        Properties props = null;

        boolean loadedProps = false;

        try {
            props = new Properties();
            props.load(WardrobeDao.class.getResourceAsStream("jdbc.properties"));

            loadedProps = true;
        } catch (IOException io) {
            System.err.printf("Unable to find properties file :(");
        }

        if (loadedProps) {

            wardrobeConnection = DriverManager.getConnection(props.getProperty(PROP_URL));
        }
    }

    public static WardrobeDao getInstance() throws SQLException{
        if (instance != null) {
            return instance;
        }

        synchronized (WardrobeDao.class) {
            if (instance != null) {
                return instance;
            }
            instance = new WardrobeDao();
            return instance;
        }
    }

    public User addUser(User newUser) throws SQLException {
        PreparedStatement prepStatement = wardrobeConnection.prepareStatement(INSERT_NEW_USER);
        prepStatement.setString(1, newUser.getFirstName());
        prepStatement.setString(2, newUser.getSurname());
        prepStatement.setString(3, newUser.getUsername());
        prepStatement.setString(4, newUser.getPassword());
        prepStatement.executeUpdate();

        return findUserByUsername(newUser.getUsername());
    }

    public User findUserByUsername(String username) throws SQLException {
        PreparedStatement statement = wardrobeConnection.prepareStatement(FIND_USER_BY_USERNAME_QUERY);
        statement.setString(1, username);
        ResultSet rs = statement.executeQuery();

        User user = null;
        while (rs.next()) {
            user = new User();
            int userId = rs.getInt("userID");
            String password = rs.getString("password");
            String surname = rs.getString("surname");

            user.setId(userId);
            user.setUsername(username);
            user.setPassword(password);
            user.setSurname(surname);
        }
        rs.close();

        return user;
    }
}
