package com.cg.ofr.service;

import java.util.List;


import com.cg.ofr.entities.Flat;
import com.cg.ofr.exception.FlatNotFoundException;
/**
 * This is an interface for Flat service with methods of
 * add,update,delete,get and getall Flats
 * 
 * @author P.Kiran Kumar * 
 **/

public interface IFlatService {
	public Flat addFlat(Flat flat);

	public Flat updateFlat(Flat flat) throws FlatNotFoundException;

	public Flat deleteFlat(Flat flat);

	public Flat viewFlat(int id) throws FlatNotFoundException;

	public List<Flat> viewAllFlat();

	public List<Flat> viewAllFlatByCost(float cost, String availability);
}
