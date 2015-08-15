package mywardrobeprogram.dao.persistence.impl;

import java.sql.SQLException;
import mywardrobeprogram.dao.WardrobeDao;
import mywardrobeprogram.dao.persistence.ClothingPersist;
import mywardrobeprogram.model.Clothing;

/**
 *
 * @author Natalia Luiz
 */
public class ClothingAddPersist implements ClothingPersist {

    public ClothingAddPersist() {
    }

    @Override
    public void execute(Clothing item) throws SQLException {
        WardrobeDao.getInstance().addWardrobeItem(item);
    }
}
