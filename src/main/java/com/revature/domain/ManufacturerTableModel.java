package com.revature.domain;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ManufacturerTableModel extends AbstractTableModel{

	private static final long serialVersionUID = -1093354600035603850L;

	private String [] columnNames = {"Manufacturer", "City", "State"};
	
	private List<Manufacturer> manufacturerList = new ArrayList<Manufacturer>();
	
	public void setManufacturerList(List<Manufacturer> manufacturerList){
        this.manufacturerList = manufacturerList;
    }

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return manufacturerList.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		Manufacturer manufacturer = manufacturerList.get(row);
        switch (column){
            case 0: return manufacturer.getCompanyName();
            case 1: return manufacturer.getCity();
            case 2: return manufacturer.getState();
        }
        return "";
	}

	@Override
    public String getColumnName(int column){
        return columnNames[column];
    }
}
