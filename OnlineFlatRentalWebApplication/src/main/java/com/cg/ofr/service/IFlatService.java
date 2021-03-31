package com.cg.ofr.service;

import java.util.List;

import com.cg.ofr.entities.Flat;

public interface IFlatService {
	public Flat addFlat(Flat flat);

	public Flat updateFlat(Flat flat);

	public Flat deleteFlat(Flat flat);

	public Flat viewFlat(int id);

	public List<Flat> viewAllFlat();

	public List<Flat> viewAllFlatByCost(float cost, String availability);
}
