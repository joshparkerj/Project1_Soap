package com.revature.domain;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class AircraftTableModel extends AbstractTableModel{

	private String [] columnNames = {"Manufacturer", "Aircraft", "Type"};
	
	private List<Aircraft> aircraftList = new ArrayList<Aircraft>();
	
	public void setAircraftList(List<Aircraft> aircraftList){
        this.aircraftList = aircraftList;
    }

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return aircraftList.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		Aircraft aircraft = aircraftList.get(row);
        switch (column){
            case 0: return aircraft.getManufacturer();
            case 1: return aircraft.getAircraftName();
            case 2: StringBuilder column3;
            	if (aircraft.getNumEngines() == 1)
            		column3 = new StringBuilder("Single Engine ");
            	else if (aircraft.getNumEngines() == 2)  
            		column3 = new StringBuilder("Twin Engine ");
            	else
            		column3 = new StringBuilder(aircraft.getNumEngines() + " Engine ");
            	column3.append(aircraft.getAircraftType());
            	return column3;
        }
        return "";
	}

	@Override
    public String getColumnName(int column){
        return columnNames[column];
    }
}
