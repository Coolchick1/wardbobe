/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mywardrobeprogram.dao.persistence.impl;

import java.sql.SQLException;
import mywardrobeprogram.dao.WardrobeDao;
import mywardrobeprogram.dao.persistence.BrandPersist;
import mywardrobeprogram.model.Brand;

/**
 *
 * @author Natalia Luiz
 */
public class BrandAddPersist implements BrandPersist{

    public BrandAddPersist() {
    }

    @Override
    public void execute(Brand brand) throws SQLException {
        WardrobeDao.getInstance().addBrand(brand);
    }
    
    
}
