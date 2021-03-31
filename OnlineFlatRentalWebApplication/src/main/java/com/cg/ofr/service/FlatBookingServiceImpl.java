/**
 * 
 */
package com.cg.ofr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.exception.EmptyEntityListException;
import com.cg.ofr.exception.EntityCreationException;
import com.cg.ofr.exception.EntityDeletionException;
import com.cg.ofr.exception.EntityUpdationException;
import com.cg.ofr.repository.IFlatBookingRepository;
import com.cg.ofr.repository.ITenantRepository;

/**
 * @author
 *
 */

@Service
@Transactional
public class FlatBookingServiceImpl implements IFlatBookingService {

	@Autowired
	private IFlatBookingRepository flatRepository;
	@Autowired
	private ITenantRepository tenantRepository;

	@Override
	public FlatBooking addFlatBooking(FlatBooking flatbooking) {
		try {
			int checkAge=flatbooking.getTenant().getAge();
			if(checkAge>0)
			{
				flatbooking.getFlat().setAvailibilty("No");
			}
			return flatRepository.save(flatbooking);
		} catch (Exception e) {
			throw new EntityCreationException(e.getMessage());
		}
	}

	@Override
	public FlatBooking updateFlatBooking(FlatBooking flatbooking) {
		FlatBooking flatbooking3 = null;
		try {
			Optional<FlatBooking> flatBooking = flatRepository.findById(flatbooking.getBookingNo());
			if (flatBooking.isPresent()) {
				flatbooking3 = flatRepository.save(flatbooking);
				return flatbooking3;
			}

			else {
				return null;
			}
		} catch (Exception e) {
			throw new EntityUpdationException(e.getMessage());
		}

	}

	@Override
	public FlatBooking deleteFlatBooking(FlatBooking flatbooking) {
		try {
			int tenantId=flatbooking.getTenant().getTenantId();
			Optional<FlatBooking> flatBooking = flatRepository.findById(flatbooking.getBookingNo());
			if (flatBooking.isPresent()) {
				flatbooking.getFlat().setAvailibilty("Yes");
				tenantRepository.deleteById(tenantId);
				flatRepository.delete(flatbooking);
				return flatBooking.get();
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new EntityDeletionException(e.getMessage());
		}

	}

	@Override
	public FlatBooking viewFlatBooking(int id) {
		try {
			Optional<FlatBooking> flatBooking = flatRepository.findById(id);
			if (flatBooking.isPresent()) {
				return flatBooking.get();
			} else {
				throw new EntityNotFoundException("FlatBooking with id " + id + " is not found");
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

	}

	@Override
	public List<FlatBooking> viewAllFlatBooking() {
		List<FlatBooking> flatbookings = new ArrayList<>();
		try {
			flatbookings = flatRepository.findAll();
			if (flatbookings.isEmpty()) {
				throw new EmptyEntityListException("No FlatBooking Found");
			} else
				return flatbookings;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

	}

}