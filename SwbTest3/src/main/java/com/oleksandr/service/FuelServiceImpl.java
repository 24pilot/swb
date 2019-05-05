package com.oleksandr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oleksandr.models.Fuel;
import com.oleksandr.repository.FuelRepository;

/**
 * @author oleksandr
 *
 */
@Service
public class FuelServiceImpl implements FuelService{

	@Autowired
	private FuelRepository fuelRepository;
	
	@Override
	public void addFuel(Fuel fuel) {
		fuelRepository.save(fuel);
	}

	@Override
	public Fuel getFuel(Integer fuelId) {
		return fuelRepository.findOne(fuelId);
	}

	@Override
	public Fuel updateFuel(Integer fuelId,Fuel fuel) {
		return fuelRepository.save(fuel);
	}
	
	@Override
	public void deleteFuel(Integer fuelId) {
		fuelRepository.delete(fuelId);
	}

	@Override
	public List<Fuel> getAllFuels() {
		List<Fuel> fuels=new ArrayList<>();
		fuelRepository.findAll().forEach(fuels::add);
		return fuels;
	}

}
