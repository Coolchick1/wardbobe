package mywardrobeprogram.dao.persistence.impl;

import java.sql.SQLException;
import mywardrobeprogram.dao.WardrobeDao;
import mywardrobeprogram.dao.persistence.ClothingPersist;
import mywardrobeprogram.model.Clothing;

/**
 * Persistence object to add new clothing object 
 * 
 * @author Natalia Luiz
 */
public class ClothingAddPersist implements ClothingPersist {

    public ClothingAddPersist() {
    }
    /**
     * add clothing item
     * 
     * @param item item to add
     * 
     * @throws SQLException thrown if unable to persist  
     */
    @Override
    public void execute(Clothing item) throws SQLException {
        WardrobeDao.getInstance().addWardrobeItem(item);
    }
}
