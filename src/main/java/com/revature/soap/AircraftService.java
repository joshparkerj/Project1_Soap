package com.revature.soap;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.revature.domain.Aircraft;
import com.revature.domain.Manufacturer;
import com.revature.service.AircraftDAO;
import com.revature.service.ManufacturerDAO;

@WebService
public class AircraftService {
	
	@WebMethod
	public Manufacturer getManufacturer(@WebParam(name = "manufacturer") String manufacturer) {
		Manufacturer result;
		ManufacturerDAO dao = ManufacturerDAO.getDAO();
		result = dao.getManufacturer(manufacturer);
		return result;
	}
	
	@WebMethod
	public List<Manufacturer> getAircraftManufacturers() {
		List<Manufacturer> list = new ArrayList<Manufacturer>();
		ManufacturerDAO dao = ManufacturerDAO.getDAO();
		list = dao.getAll();
		return list;
	}
	
	@WebMethod
	public List<Aircraft> getAllAircraft() {
		List<Aircraft> list = new ArrayList<Aircraft>();
		AircraftDAO dao = AircraftDAO.getDAO();
		list = dao.getAll();
		return list;
	}
	
	@WebMethod
	public List<Aircraft> getAircraftByManufacturer(@WebParam(name = "manufacturer") String manufacturer) {
		AircraftDAO dao = AircraftDAO.getDAO();
		List<Aircraft> list = dao.getAircraft(manufacturer);
		return list;
	}
	
	@WebMethod
	public Aircraft getAircraftByManufacturerAndModel(@WebParam(name = "manufacturer") String manufacturer, @WebParam(name = "model") String model) {
		AircraftDAO dao = AircraftDAO.getDAO();
		Aircraft aircraft = dao.getAircraft(manufacturer, model);
		return aircraft;
	}
}
