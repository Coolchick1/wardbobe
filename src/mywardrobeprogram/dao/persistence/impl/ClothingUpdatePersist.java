package mywardrobeprogram.dao.persistence.impl;

import java.sql.SQLException;
import mywardrobeprogram.dao.WardrobeDao;
import mywardrobeprogram.dao.persistence.ClothingPersist;
import mywardrobeprogram.model.Clothing;

/**
 *Persistence object to update existing clothing item 
 * 
 * @author Natalia Luiz
 */
public class ClothingUpdatePersist implements ClothingPersist {

    public ClothingUpdatePersist() {
    }
    /**
     * existing clothing item to update
     * 
     * @param item clothing item to update
     * 
     * @throws SQLException thrown if unable to persist changes 
     */
    @Override
    public void execute(Clothing item) throws SQLException {
        WardrobeDao.getInstance().updateClothing(item);
    }
}

