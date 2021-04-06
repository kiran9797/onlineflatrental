package com.cg.ofr.service;

import java.util.List;

import com.cg.ofr.entities.Landlord;
import com.cg.ofr.exception.LandlordNotFoundException;

public interface ILandlordService {
	public Landlord addLandlord(Landlord landlord);

	/**
	 * This is an interface for Landlord service with methods of
	 * add,update,delete,get and getall Landlords
	 * 
	 * @author Y.Manideep * 
	 **/
	public Landlord updateLandlord(Landlord landlord);

	public Landlord deleteLandlord(Landlord landlord);

	public Landlord viewLandlord(int id) throws  LandlordNotFoundException;

	public List<Landlord> viewAllLandlord();
}
