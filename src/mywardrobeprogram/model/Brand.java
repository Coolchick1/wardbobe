/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mywardrobeprogram.model;

/**
 *
 * @author Natalia Luiz
 */
public class Brand {
    private Integer id;
    private String name;
    private String shoppingMall;
    private boolean recommeneded;

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

    public boolean isRecommeneded() {
        return recommeneded;
    }

    public void setRecommeneded(boolean recommeneded) {
        this.recommeneded = recommeneded;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
