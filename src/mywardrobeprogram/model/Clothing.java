package mywardrobeprogram.model;

/**
 * Clothing entity 
 * 
 * @author Natalia Luiz
 */
public class Clothing {
    /**
     * Primary key for clothing item
     */
    private Integer id;
    /**
     * the type of clothing item
     */
    private String type;
    /**
     * the size of the clothing item
     */
    private String size;
    /**
     * the colour of the clothing item
     */
    private String colour;
    /**
     * the foreign key to the brand of the clothing item
     */
    private Integer brandID;
    /**
     * the foreign key to the user that this clothing item belongs to 
     */
    private Integer userID;
    /**
     * the style of the clothing item e.g. if jeans could be skinny 
     */
    private String style;

    public Clothing() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Integer getBrandID() {
        return brandID;
    }

    public void setBrandID(Integer brandID) {
        this.brandID = brandID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
    
}

 