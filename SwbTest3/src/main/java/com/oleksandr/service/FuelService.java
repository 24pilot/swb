package com.oleksandr.service;

import java.util.List;

import com.oleksandr.models.Fuel;

/**
 * @author oleksandr
 *
 */
public interface FuelService {
	
	public void addFuel(Fuel fuel);	
	
	public Fuel getFuel(Integer fuelId);
	
	public Fuel updateFuel(Integer fuelId, Fuel fuel);
	
	public void deleteFuel(Integer fuelId);
			
	public List<Fuel> getAllFuels();
}
