package mywardrobeprogram.dao.persistence;

import java.sql.SQLException;
import mywardrobeprogram.model.Clothing;

/**
 * Interface to give us a common mechanism to persist clothing data
 * 
 * @author Natalia Luiz
 */
public interface ClothingPersist {
    /**
     * Persist data 
     * 
     * @param item clothing item data to persist 
     * 
     * @throws SQLException thrown if unable to persist 
     */
    void execute(Clothing item) throws SQLException ;
}


