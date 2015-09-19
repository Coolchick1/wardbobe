package mywardrobeprogram.ui.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import mywardrobeprogram.model.Brand;

/**
 * Custom table model to display brands in JTable 
 * 
 * @author Natalia Luiz
 */
public class BrandTableModel extends AbstractTableModel{
    private List <Brand> brands;
    /**
     * Names of the columns 
     */
    private static final String[] COLUNN_NAME = {"Name", "Recommended", "Shopping Mall"};
    /**
     * Constructor
     * 
     * @param brands brands we need to display
     */
    public BrandTableModel(List <Brand> brands) {
        this.brands = brands;
    }
    /**
     * Get the name of the column for a specific index 
     * 
     * @param columnIndex index of the column name we want 
     * 
     * @return column name returned
     */
    @Override
    public String getColumnName(int columnIndex) {
        return COLUNN_NAME[columnIndex];
    }
    /**
     * number of brands to display in table 
     * 
     * @return number of brands returned 
     */
    @Override
    public int getRowCount() {
        return brands.size();
    }
    /**
     * number of columns the table needs to display
     * 
     * @return column count returned
     */
    @Override
    public int getColumnCount() {
        return COLUNN_NAME.length;
    }
    /**
     * This will return a specific value for the brand 
     * 
     * @param row selected brand we want the value for 
     * @param column the actual brand value 
     * @return value requested returned
     */
    @Override
    public Object getValueAt(int row, int column) {
        Brand selectedRow = brands.get(row);
        
        String value = null;
        
        switch (column){
            case 0: value = selectedRow.getName();
                    break;
            case 1: value = selectedRow.getRecommended();
                    break;
            case 2: value = selectedRow.getShoppingMall();
                    break;
                
        }
        return value;
    }
    /**
     * retrieves brand the user selected in the table 
     * @param row position of brand listed in JTable
     * @return selected brand returned
     */
    public Brand getSelectedBrand (int row){
        return brands.get(row);
    }
}
