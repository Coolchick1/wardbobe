/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mywardrobeprogram.dao.persistence;

import java.sql.SQLException;
import mywardrobeprogram.model.Brand;

/**
 *
 * @author Natalia Luiz
 */
public interface BrandPersist {
    void execute (Brand brand)throws SQLException;
    
}
