package mywardrobeprogram.dao.persistence.impl;

import java.sql.SQLException;
import mywardrobeprogram.dao.WardrobeDao;
import mywardrobeprogram.dao.persistence.ClothingPersist;
import mywardrobeprogram.model.Clothing;

/**
 *
 * @author Natalia Luiz
 */
public class ClothingUpdatePersist implements ClothingPersist {

    public ClothingUpdatePersist() {
    }

    @Override
    public void execute(Clothing item) throws SQLException {
        WardrobeDao.getInstance().updateClothing(item);
    }
}

