package mywardrobeprogram.model;

/**
 * Brand entity model 
 * 
 * @author Natalia Luiz
 */
public class Brand {
    /**
     * Primary key of the brand 
     */
    private Integer id;
    /**
     * name of the brand 
     */
    private String name;
    /**
     * shopping mall the brand can be found at 
     */
    private String shoppingMall;
    /**
     * recommendation of this brand
     */
    private String recommended;

    public Brand() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShoppingMall() {
        return shoppingMall;
    }

    public void setShoppingMall(String shoppingMall) {
        this.shoppingMall = shoppingMall;
    }

    public String getRecommended() {
        return recommended;
    }

    public void setRecommended(String recommended) {
        this.recommended = recommended;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
