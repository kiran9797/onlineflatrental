package com.cg.ofr.service;

import java.util.List;

import com.cg.ofr.entities.FlatBooking;

public interface IFlatBookingService {
	public FlatBooking addFlatBooking(FlatBooking flatbooking);

	public FlatBooking updateFlatBooking(FlatBooking flatbooking);

	public FlatBooking deleteFlatBooking(FlatBooking flatbooking);

	public FlatBooking viewFlatBooking(int id);

	public List<FlatBooking> viewAllFlatBooking();
}
