package mywardrobeprogram.dao.persistence;

import java.sql.SQLException;
import mywardrobeprogram.model.Brand;

/**
 * Interface to give us a common mechanism to add and edit brands
 * 
 * @author Natalia Luiz
 */
public interface BrandPersist {
    /**
     * Persist data to database
     * 
     * @param brand brand data to persist
     * 
     * @throws SQLException thrown if unable to persist
     */
    void execute (Brand brand)throws SQLException;
    
}
