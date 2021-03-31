package com.cg.ofr.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.service.IFlatService;

@RestController
public class FlatRest {

	@Autowired
	private IFlatService service;

	@GetMapping("/flat")
	public List<Flat> viewFlat() {
		List<Flat> allFlats = this.service.viewAllFlat();
		return allFlats;
	}

	@GetMapping("/flat/{id}")
	public Flat viewFlatById(@PathVariable int id) {
		Flat flat = service.viewFlat(id);
		return flat;
	}

	@GetMapping("/flat/{cost}/{availability}")
	public List<Flat> viewFlatByCostAndAvailability(@PathVariable float cost, @PathVariable String availability) {
		List<Flat> allFlatsByCostAndAvailability = this.service.viewAllFlatByCost(cost, availability);
		return allFlatsByCostAndAvailability;
	}

	@PostMapping("/flat")
	public Flat addFlat(@RequestBody Flat flat) {
		Flat flat1 = null;
		flat1 = this.service.addFlat(flat);
		return flat1;

	}

	@PutMapping("/flat")
	public Flat updateFlat(@RequestBody Flat flat) {
		Flat flat1 = null;
		flat1 = this.service.updateFlat(flat);
		return flat1;
	}

	@DeleteMapping("/flat")
	public Flat deleteFlat(@RequestBody Flat flat) {
		Flat deletedFlat = this.service.deleteFlat(flat);
		return deletedFlat;

	}

}