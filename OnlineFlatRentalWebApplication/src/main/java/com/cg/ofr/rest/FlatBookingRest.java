package com.cg.ofr.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.service.IFlatBookingService;

@RestController
@RequestMapping("/flatbooking")


public class FlatBookingRest {
@Autowired
	private IFlatBookingService flatBookingService;

	@PostMapping("/add")
	public FlatBooking addFlatBooking(@RequestBody FlatBooking flatbooking) {
		FlatBooking flatbooking1 = null;
		flatbooking1 = flatBookingService.addFlatBooking(flatbooking);
		return flatbooking1;
	}

	@PutMapping("/update")
	public FlatBooking updateFlatBooking(@RequestBody FlatBooking flatbooking) {
		FlatBooking flatbooking2 = null;
		flatbooking2 = flatBookingService.updateFlatBooking(flatbooking);
		return flatbooking2;
	}

	@DeleteMapping("/delete")
	public FlatBooking deleteFlatBooking(@RequestBody FlatBooking flatbooking) {
		FlatBooking flatbooking3 = null;
		flatbooking3 = flatBookingService.deleteFlatBooking(flatbooking);
		return flatbooking3;
	}

	@GetMapping("/viewById/{id}")
	public FlatBooking viewFlatBooking(@PathVariable("id") int id) {
		FlatBooking flatbooking = this.flatBookingService.viewFlatBooking(id);
		return flatbooking;
	}
	
	@GetMapping("/viewAll")

	public List<FlatBooking> viewAllFlatBooking() {
		List<FlatBooking> flatbookings = this.flatBookingService.viewAllFlatBooking();
		return flatbookings;
	}

}