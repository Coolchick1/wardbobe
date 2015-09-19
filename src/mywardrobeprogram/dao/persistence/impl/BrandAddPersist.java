package mywardrobeprogram.dao.persistence.impl;

import java.sql.SQLException;
import mywardrobeprogram.dao.WardrobeDao;
import mywardrobeprogram.dao.persistence.BrandPersist;
import mywardrobeprogram.model.Brand;

/**
 * Persistence object to add a new brand 
 * 
 * @author Natalia Luiz
 */
public class BrandAddPersist implements BrandPersist{

    public BrandAddPersist() {
    }
/**
 * Add new brand 
 * 
 * @param brand brand persist
 * 
 * @throws SQLException thrown if unable to persist 
 */
    @Override
    public void execute(Brand brand) throws SQLException {
        WardrobeDao.getInstance().addBrand(brand);
    }
    
    
}
