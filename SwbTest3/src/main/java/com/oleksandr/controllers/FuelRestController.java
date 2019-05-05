package com.oleksandr.controllers;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oleksandr.models.Fuel;
import com.oleksandr.service.FuelService;

/**
 * @author oleksandr
 *
 */
@RestController
@RequestMapping("/rest")
public class FuelRestController {
	
	public static final Logger logger = LoggerFactory.getLogger(FuelRestController.class);

	@Autowired
	private FuelService fuelService;

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/list_fuels" , method = RequestMethod.GET ,headers="Accept= application/json")
	public@ResponseBody ResponseEntity<Object> getListFuels() {
		
		List<Fuel> listFuels=fuelService.getAllFuels();
		
		List<JSONObject> fuels = new ArrayList<JSONObject>();
		
	    for (Fuel a : listFuels) {
	        JSONObject fuel = new JSONObject();
	        fuel.put("id", a.getId());
	        fuel.put("type", a.getType());
	        fuel.put("price", a.getPrice());
  	        fuel.put("volume", a.getVolume());
  	        fuel.put("date", a.getDate());
  	        fuel.put("driverid", a.getDriverid());
	        
	        fuels.add(fuel);
	    }
		return new ResponseEntity<Object>(fuels,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/add_fuels" , method = RequestMethod.POST , headers="Accept= application/json")
	public ResponseEntity<Fuel> addBooks(@RequestBody Fuel fuel){
		
		fuelService.addFuel(fuel);
		HttpHeaders header=new HttpHeaders();
		
		return new ResponseEntity<Fuel>(header,HttpStatus.CREATED);

	}
}
