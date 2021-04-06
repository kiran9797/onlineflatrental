package com.cg.ofr.service;

import java.util.List;

import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.exception.FlatBookingNotFoundException;
/**
 * This is an interface for FlatBooking service with methods of
 * add,update,delete,get and getall FlatBookings
 * 
 * @author E.Iswarya Lakshmi * 
 **/
public interface IFlatBookingService {
	
	public FlatBooking addFlatBooking(FlatBooking flatbooking);

	public FlatBooking updateFlatBooking(FlatBooking flatbooking);

	public FlatBooking deleteFlatBooking(FlatBooking flatbooking)  ;

	public FlatBooking viewFlatBooking(Integer id) throws FlatBookingNotFoundException  ;

	public List<FlatBooking> viewAllFlatBooking();



}
