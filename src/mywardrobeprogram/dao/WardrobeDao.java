package mywardrobeprogram.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import mywardrobeprogram.model.Brand;
import mywardrobeprogram.model.Clothing;
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
    private static final String GET_ALL_BRANDS_QUERY
            = "   SELECT "
            + "     brandID, "
            + "     brandName, "
            + "     reccommended, "
            + "     shoppingMall "
            + " FROM "
            + "     Brands ";
    private static final String INSERT_NEW_ITEM_OF_CLOTHING
            = "INSERT INTO "
            + " Clothing(itemType, size, colour, brandID, userID, style) "
            + "VALUES(?, ?, ?, ?, ?, ?) ";

    private static final String FIND_CLOTHING_BY_USERID
            = "SELECT "
            + " ID, "
            + " itemType,"
            + " size,"
            + " colour,"
            + " brandID, "
            + " userID, "
            + " style "
            + "FROM "
            + "  Clothing "
            + "WHERE"
            + "  USERID = ? ";

    private static final String FIND_BRAND_BY_ID
            = "SELECT "
            + "  brandID,"
            + "  brandName,"
            + "  reccommended,"
            + "  shoppingMall "
            + "FROM "
            + "  Brands "
            + "WHERE "
            + "  BrandID = ?";

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

    public static WardrobeDao getInstance() throws SQLException {
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

    public List<Brand> getAllBrands() throws SQLException {
        PreparedStatement statement = wardrobeConnection.prepareStatement(GET_ALL_BRANDS_QUERY);
        ResultSet rs = statement.executeQuery();
        List<Brand> allBrands = new ArrayList<>();
        while (rs.next()) {
            Brand brand = new Brand();
            brand.setId(rs.getInt("brandID"));
            brand.setName(rs.getString("brandName"));
            brand.setShoppingMall(rs.getString("shoppingMall"));
            brand.setRecommeneded(rs.getBoolean("reccommended"));

            allBrands.add(brand);
        }
        rs.close();
        return allBrands;
    }

    public void addWardrobeItem(Clothing newClothingItem) throws SQLException {
        PreparedStatement statement = wardrobeConnection.prepareStatement(INSERT_NEW_ITEM_OF_CLOTHING);
        statement.setString(1, newClothingItem.getType());
        statement.setString(2, newClothingItem.getSize());
        statement.setString(3, newClothingItem.getColour());
        statement.setInt(4, newClothingItem.getBrandID());
        statement.setInt(5, newClothingItem.getUserID());
        statement.setString(6, newClothingItem.getStyle());
        statement.executeUpdate();
    }

    public List<Clothing> findClothingByUserId(Integer userId) throws SQLException {
        PreparedStatement statement = wardrobeConnection.prepareStatement(FIND_CLOTHING_BY_USERID);
        statement.setInt(1, userId);

        List<Clothing> usersClothing = new ArrayList<>();

        try (ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                Clothing item = new Clothing();
                item.setId(rs.getInt("Id"));
                item.setSize(rs.getString("size"));
                item.setColour(rs.getString("colour"));
                item.setBrandID(rs.getInt("BrandID"));
                item.setUserID(rs.getInt("UserID"));
                item.setStyle(rs.getString("Style"));
                item.setType(rs.getString("itemType"));

                usersClothing.add(item);
            }
        } catch (SQLException sqle) {
            System.err.println("Unable to process the resultset");
            sqle.printStackTrace();

            throw sqle;
        }

        return usersClothing;
    }

    public Brand findBrandByID(Integer id) throws SQLException {
        PreparedStatement statement = wardrobeConnection.prepareStatement(FIND_BRAND_BY_ID);
        statement.setInt(1, id);

        Brand response = null;
        try (ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                response = new Brand();
                response.setId(rs.getInt("brandID"));
                response.setName(rs.getString("brandName"));
                response.setRecommeneded(rs.getBoolean("reccommended"));
                response.setShoppingMall(rs.getString("shoppingMall"));

            }
        }
        return response;
    }
}
