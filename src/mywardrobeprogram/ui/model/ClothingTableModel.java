/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mywardrobeprogram.ui.model;

import java.sql.SQLException;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import mywardrobeprogram.dao.WardrobeDao;
import mywardrobeprogram.model.Clothing;

/**
 *
 * @author Natalia Luiz
 */
public class ClothingTableModel extends AbstractTableModel{ 
    public List <Clothing> items;
    private String [] columnNames = new String [] {
        "Item Type",
        "Size",
        "Colour",
        "Brand",
        "Style"
    };

    public ClothingTableModel(List <Clothing> items) {
        this.items = items;
    }

    @Override
    public int getRowCount() {
       return items.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int i) {
        return columnNames[i];
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        Clothing selected = items.get(row);
        
        Object value = null;
        try {
            switch(column) {
                case 0 :    value = selected.getType();
                            break;
                case 1 :    value = selected.getSize();
                            break;
                case 2 :    value = selected.getColour();
                            break;
                case 3 :    value = WardrobeDao.getInstance().findBrandByID(selected.getBrandID()).getName();
                            break;
                case 4 :    value = selected.getStyle();
                            break;
            }
        }catch (SQLException sqle){
            System.out.println("Unable to retrieve brand");
        }
        return value;
    }   

    public List<Clothing> getItems() {
        return items;
    }
}