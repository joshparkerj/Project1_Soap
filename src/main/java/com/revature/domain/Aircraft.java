package com.revature.domain;

public class Aircraft implements Comparable<Aircraft>{
	
	private Integer id;
	private String manufacturer;
	private String aircraftName;
	private String aircraftType;
	private Integer rangeNM;
	private Integer maxCruiseSpeedKtas;
	private Integer usefulLoad;
	private Integer numPassengers;
	private String engineManufacturer;
	private String engineModel;
	private String enginePower;
	private Integer numEngines;
	private Double lengthM;
	private Double heightM;
	private Double wingSpanM;
	private Integer serviceCeilingFt;
	
	public Aircraft() {
		super();
	}
	
	public Aircraft(String manufacturer, String aircraftName, String aircraftType, Integer rangeNM,
			Integer maxCruiseSpeedKtas, Integer usefulLoad, Integer numPassengers, String enginePower,
			String engineManufacturer, String engineModel, Integer numEngines, Double lengthM, Double heightM,
			Double wingSpanM, Integer serviceCeilingFt) {
		super();
		this.manufacturer = manufacturer;
		this.aircraftName = aircraftName;
		this.aircraftType = aircraftType;
		this.rangeNM = rangeNM;
		this.maxCruiseSpeedKtas = maxCruiseSpeedKtas;
		this.usefulLoad = usefulLoad;
		this.numPassengers = numPassengers;
		this.enginePower = enginePower;
		this.engineManufacturer = engineManufacturer;
		this.engineModel = engineModel;
		this.numEngines = numEngines;
		this.lengthM = lengthM;
		this.heightM = heightM;
		this.wingSpanM = wingSpanM;
		this.serviceCeilingFt = serviceCeilingFt;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getAircraftName() {
		return aircraftName;
	}
	public void setAircraftName(String aircraftName) {
		this.aircraftName = aircraftName;
	}
	public String getAircraftType() {
		return aircraftType;
	}
	public void setAircraftType(String aircraftType) {
		this.aircraftType = aircraftType;
	}
	public Integer getRangeNM() {
		return rangeNM;
	}
	public void setRangeNM(Integer rangeNM) {
		this.rangeNM = rangeNM;
	}
	public Integer getMaxCruiseSpeedKtas() {
		return maxCruiseSpeedKtas;
	}
	public void setMaxCruiseSpeedKtas(Integer maxCruiseSpeedKtas) {
		this.maxCruiseSpeedKtas = maxCruiseSpeedKtas;
	}
	public Integer getUsefulLoad() {
		return usefulLoad;
	}
	public void setUsefulLoad(Integer usefulLoad) {
		this.usefulLoad = usefulLoad;
	}
	public Integer getNumPassengers() {
		return numPassengers;
	}
	public void setNumPassengers(Integer numPassengers) {
		this.numPassengers = numPassengers;
	}
	public String getEnginePower() {
		return enginePower;
	}
	public void setEnginePower(String enginePower) {
		this.enginePower = enginePower;
	}
	public String getEngineManufacturer() {
		return engineManufacturer;
	}
	public void setEngineManufacturer(String engineManufacturer) {
		this.engineManufacturer = engineManufacturer;
	}
	public String getEngineModel() {
		return engineModel;
	}
	public void setEngineModel(String engineModel) {
		this.engineModel = engineModel;
	}
	public Integer getNumEngines() {
		return numEngines;
	}
	public void setNumEngines(Integer numEngines) {
		this.numEngines = numEngines;
	}
	public Double getLengthM() {
		return lengthM;
	}
	public void setLengthM(Double lengthM) {
		this.lengthM = lengthM;
	}
	public Double getHeightM() {
		return heightM;
	}
	public void setHeightM(Double heightM) {
		this.heightM = heightM;
	}
	public Double getWingSpanM() {
		return wingSpanM;
	}
	public void setWingSpanM(Double wingSpanM) {
		this.wingSpanM = wingSpanM;
	}
	public Integer getServiceCeilingFt() {
		return serviceCeilingFt;
	}
	public void setServiceCeilingFt(Integer serviceCeilingFt) {
		this.serviceCeilingFt = serviceCeilingFt;
	}
	
	@Override
	public int compareTo(Aircraft o) {
		String name = manufacturer + " " + aircraftName;
		String oName = o.getManufacturer() + " " + o.getAircraftName();
		return name.compareTo(oName);
	}	
}