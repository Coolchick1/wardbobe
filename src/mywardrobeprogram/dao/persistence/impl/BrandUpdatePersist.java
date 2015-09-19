package mywardrobeprogram.dao.persistence.impl;

import java.sql.SQLException;
import mywardrobeprogram.dao.WardrobeDao;
import mywardrobeprogram.dao.persistence.BrandPersist;
import mywardrobeprogram.model.Brand;

/**
 * Persistence object to update an existing brand 
 * 
 * @author Natalia Luiz
 */
public class BrandUpdatePersist implements BrandPersist{

    public BrandUpdatePersist() {
    }
/**
 * Update brand 
 * 
 * @param brand brand to update
 * 
 * @throws SQLException thrown if unable to persist changes 
 */
    @Override
    public void execute(Brand brand) throws SQLException {
        WardrobeDao.getInstance().updateBrand(brand);
    }
    
    
    
    
}
