package com.oleksandr.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.oleksandr.models.Fuel;
import com.oleksandr.service.FuelService;

/**
 * @author oleksandr
 *
 */
@Controller
public class FuelController {
	
	public static final Logger logger = LoggerFactory.getLogger(FuelController.class);
	
	@Autowired
	private FuelService fuelService;


	
	
	@RequestMapping(value= {"/","/list_fuels"} , method = RequestMethod.GET)
	public ModelAndView ListFuels(ModelAndView model) throws IOException {
		List<Fuel> listFuels = fuelService.getAllFuels();
		model.addObject("listFuels", listFuels);
		model.setViewName("fuels");
		
		return model;
	}
	
	@RequestMapping(value = "/add_fuel", method = RequestMethod.GET)
	public ModelAndView newFuel(ModelAndView model) {
		Fuel fuel = new Fuel();
		model.addObject("fuel", fuel);
		model.setViewName("addFuel");
		
		return model;
	}
	
	@RequestMapping(value = "/save_fuel", method = RequestMethod.POST)
	public ModelAndView saveFuel(@ModelAttribute Fuel fuel) {
		if (fuel.getId() == 0) { 
			fuelService.addFuel(fuel);
		} else {
			fuelService.updateFuel(fuel.getId() , fuel);
		}
		return new ModelAndView("redirect:/list_fuels");
	}
	
	@RequestMapping(value = "/edit_fuel", method = RequestMethod.GET)
	public ModelAndView updateFuel(HttpServletRequest request) {
		int fuelId = Integer.parseInt(request.getParameter("id"));
		Fuel fuel=fuelService.getFuel(fuelId);
		ModelAndView model = new ModelAndView("addFuel");
		model.addObject("fuel",fuel);
		
		return model;
	}
	
	@RequestMapping(value = "/delete_fuel", method = RequestMethod.GET)
	public ModelAndView deleteAuthor(HttpServletRequest request) {
		int fuelId = Integer.parseInt(request.getParameter("id"));
		fuelService.deleteFuel(fuelId);
		return new ModelAndView("redirect:/list_fuels");
	}
}
