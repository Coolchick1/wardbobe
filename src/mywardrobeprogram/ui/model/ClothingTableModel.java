package mywardrobeprogram.ui.model;

import java.sql.SQLException;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import mywardrobeprogram.dao.WardrobeDao;
import mywardrobeprogram.model.Clothing;

/**
 * Custom table model to display clothing model objects
 * 
 * @author Natalia Luiz
 */
public class ClothingTableModel extends AbstractTableModel{ 
    public List <Clothing> items;
    /**
     * Array of clothing item column names 
     */
    private static final String [] columnNames = new String [] {
        "Item Type",
        "Size",
        "Colour",
        "Brand",
        "Style"
    };
    /**
     * Constructor 
     * 
     * @param items clothing items our model is to display 
     */
    public ClothingTableModel(List <Clothing> items) {
        this.items = items;
    }
    /**
     * number of clothing items to display 
     * 
     * @return clothing item count return
     */
    @Override
    public int getRowCount() {
       return items.size();
    }
    /**
     * number of columns the table needs to display
     * 
     * @return column count returned
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    /**
     * get column name
     * 
     * @param i index of the column name requested
     * @return name returned
     */
    @Override
    public String getColumnName(int i) {
        return columnNames[i];
    }
    /**
     * retrieve a specific value for a selected item of clothing
     * 
     * @param row index of clothing item selected in JTable
     * @param column the index of that specific data item 
     * @return clothing data item returned
     */
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
    /**
     * get all data to display in table
     * @return all data returned
     */
    public List<Clothing> getItems() {
        return items;
    }
    /**
     * get selected item of clothing
     * 
     * @param row index of clothing item in table
     * @return selected clothing item returned 
     */
    public Clothing getSelected (int row ){
        return items.get(row);
    }
}