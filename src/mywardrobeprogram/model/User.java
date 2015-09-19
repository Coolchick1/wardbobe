package mywardrobeprogram.model;

/**
 * User entity object
 * 
 * @author Natalia Luiz
 */
public class User {
    /**
     * Primary key 
     */
    private Integer id;
    /**
     * username assigned to this user
     */
    private String username;
    /**
     * user's password
     */
    private String password;
    /**
     * the user's surname
     */
    private String surname;
    /**
     * the user's name 
     */
    private String firstName ;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    
}
