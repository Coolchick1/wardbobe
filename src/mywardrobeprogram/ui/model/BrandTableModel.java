/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mywardrobeprogram.ui.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import mywardrobeprogram.model.Brand;

/**
 *
 * @author Natalia Luiz
 */
public class BrandTableModel extends AbstractTableModel{
    private List <Brand> brands;
    
    private static final String[] COLUNN_NAME = {"Name", "Recommended", "Shopping Mall"};
    
    public BrandTableModel(List <Brand> brands) {
        this.brands = brands;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return COLUNN_NAME[columnIndex];
    }

    @Override
    public int getRowCount() {
        return brands.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Brand selectedRow = brands.get(row);
        
        String value = null;
        
        switch (column){
            case 0: value = selectedRow.getName();
                    break;
            case 1: value = selectedRow.getRecommeneded();
                    break;
            case 2: value = selectedRow.getShoppingMall();
                    break;
                
        }
        return value;
    }
    public Brand getSelectedBrand (int row){
        return brands.get(row);
    }
}
