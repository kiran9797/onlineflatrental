package com.cg.ofr.service;

import java.util.List;

import com.cg.ofr.entities.Landlord;

public interface ILandlordService {
	public Landlord addLandlord(Landlord landlord);

	public Landlord updateLandlord(Landlord landlord);

	public Landlord deleteLandlord(Landlord landlord);

	public Landlord viewLandlord(int id);

	public List<Landlord> viewAllLandlord();
}
