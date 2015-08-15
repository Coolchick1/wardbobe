package mywardrobeprogram.dao.persistence;

import java.sql.SQLException;
import mywardrobeprogram.model.Clothing;

/**
 *
 * @author Natalia Luiz
 */
public interface ClothingPersist {
    void execute(Clothing item) throws SQLException ;
}


