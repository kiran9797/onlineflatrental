package com.cg.ofr.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.exception.EmptyEntityListException;
import com.cg.ofr.exception.EntityCreationException;
import com.cg.ofr.exception.EntityDeletionException;
import com.cg.ofr.exception.EntityNotFoundException;
import com.cg.ofr.exception.EntityUpdationException;
import com.cg.ofr.repository.IFlatRepository;

/**
 * @author Student
 *
 */
@Service
@Transactional
public class FlatServiceImpl implements IFlatService {

	@Autowired
	private IFlatRepository flatRepository;

	@Override
	public Flat addFlat(Flat flat) {
		try {
			Flat flat1 = null;
			flat1 = flatRepository.save(flat);
			return flat1;
		} catch (Exception e) {
			throw new EntityCreationException("valid details of flat is not entered");

		}

	}

	@Override
	public Flat updateFlat(Flat flat) {
		Flat flat1 = null;
		try {
			if (flatRepository.existsById(flat.getFlatId())) {
				flat1 = flatRepository.saveAndFlush(flat);

			}
		} catch (Exception e) {
			throw new EntityUpdationException("no updation found");
		}
		return flat1;

	}

	@Override
	public Flat deleteFlat(Flat flat) {

		try {
			if (flatRepository.existsById(flat.getFlatId())) {
				Flat flat1 = flat;
				flatRepository.deleteById(flat1.getFlatId());
				return flat1;
			} else
				return null;
		} catch (Exception e) {
			throw new EntityDeletionException("invalid user details");
		}
	}

	@Override
	public Flat viewFlat(int id) throws EntityNotFoundException {
		Flat flat1 = null;
		try {
			if (flatRepository.existsById(id)) {
				flat1 = flatRepository.findById(id).get();
				return flat1;
			} else {
				throw new EntityNotFoundException("Flat with id " + id + " was not found");

			}

		} catch (Exception e) {
			throw new EntityNotFoundException(e.getMessage());
		}

	}

	@Override
	public List<Flat> viewAllFlat() {
		List<Flat> allFlats = new ArrayList<Flat>();

		try {

			allFlats = flatRepository.findAll();
			if (allFlats.isEmpty()) {
				throw new EmptyEntityListException("No Flats Found");
			} else
				return allFlats;
		} catch (Exception e) {
			throw new EmptyEntityListException(e.getMessage());

		}

	}

	/**
	 *
	 */
	@Override
	public List<Flat> viewAllFlatByCost(float cost, String availability) {

		List<Flat> allFlatsByCostAndavailability = flatRepository.viewAllFlatByCostAndAvailability(cost, availability);
		try {
			if (allFlatsByCostAndavailability.isEmpty()) {
				throw new EmptyEntityListException(
						"No Flats Found with cost = " + cost + " And availability = " + availability);
			} else
				return allFlatsByCostAndavailability;

		} catch (Exception e) {
			throw new EmptyEntityListException(e.getMessage());
		}

	}

}