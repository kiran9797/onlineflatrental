package com.cg.ofr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.entities.Tenant;
import com.cg.ofr.exception.EmptyEntityListException;
import com.cg.ofr.exception.EntityCreationException;
import com.cg.ofr.exception.EntityDeletionException;
import com.cg.ofr.exception.EntityUpdationException;
import com.cg.ofr.exception.FlatBookingNotFoundException;
import com.cg.ofr.repository.IFlatBookingRepository;
import com.cg.ofr.repository.ITenantRepository;

/****************************
 *          @author          E.Iswarya Lakshmi
 *          Description      It is a FlatBooking service implementation class that defines the methods
 *                           mentioned in its interface.
  *         Version             1.0
  *         Created Date    24-MARCH-2021
 ****************************/
@Service
@Transactional
public class FlatBookingServiceImpl implements IFlatBookingService {

	@Autowired
	private IFlatBookingRepository flatBookingRepository;
	@Autowired
	private ITenantRepository tenantRepository;

	/****************************
	 * Method:                                            addFlatBooking
     *Description:                                        It is used to add FlatBooking into FlatBooking_details table
     * @param FlatBooking:                                FlatBooking's reference variable.
	 * @throws EntityCreationException 
	 * @returns FlatBooking                               It returns FlatBooking with details
                *Created By                               E.Iswarya Lakshmi
                *Created Date                             24-MARCH-2021                           
	 
	 ****************************/
	@Override
	public FlatBooking addFlatBooking(FlatBooking flatBooking) {
		try {
			int checkAge = flatBooking.getTenant().getAge();
			if (checkAge > 0) {
				flatBooking.getFlat().setAvailibilty("No");
				return flatBookingRepository.save(flatBooking);
			}
		} catch (Exception e) {
			throw new EntityCreationException(e.getMessage());
		}
		return flatBooking;
	}

	/****************************
	 * Method:                                                updateFlatBooking
     *Description:                                            It is used to update FlatBooking details into FlatBooking_details table.
     * @param FlatBooking:                                    FlatBooking's reference variable.
	 * @throws EntityUpdationException 
	 * @returns FlatBooking                                   It returns updated details of the existed FlatBooking.
                *Created By                                    E.Iswarya Lakshmi
                *Created Date                                  23-MARCH-2021                           
	 
	 ****************************/
	@Override
	public FlatBooking updateFlatBooking(FlatBooking flatbooking) {
		try {
			Optional<FlatBooking> flatBooking1 = flatBookingRepository.findById(flatbooking.getBookingNo());
			if (flatBooking1.isPresent()) {
				FlatBooking flatbooking2 = flatBookingRepository.save(flatbooking);
				return flatbooking2;
			} else {
				throw new EntityUpdationException(
						"Cannot Update FlatBooking with bookingNo" + flatbooking.getBookingNo());
			}
		} catch (Exception e) {
			throw new EntityUpdationException(e.getMessage());
		}
	}

	/****************************
	 * Method:                                              removeFlatBooking
     *Description:                                          It is used to remove FlatBooking
     *@param FlatBooking:                                   FlatBooking's reference variable.
	 * @throws EntityDeletionException 
	 * @returns User                                        It returns the FlatBooking that has been deleted
                * Created By                                E.Iswarya Lakshmi
                *Created Date                               24-MARCH-2021                           
	 
	 ****************************/
	@Override
	public FlatBooking deleteFlatBooking(FlatBooking flatBooking) {
		try {
			Tenant tenant = flatBooking.getTenant();
			Optional<FlatBooking> flatBooking2 = flatBookingRepository.findById(flatBooking.getBookingNo());
			if (flatBooking2.isPresent()) {
				flatBooking.getFlat().setAvailibilty("Yes");
				tenantRepository.delete(tenant);
				flatBookingRepository.delete(flatBooking);
				return flatBooking2.get();
			} else {
				throw new EntityDeletionException("Cannot Delete flatbooking as the FlatBooking with"
						+ flatBooking.getBookingNo() + "does not exist");
			}
		} catch (Exception e) {
			throw new EntityDeletionException(e.getMessage());
		}
	}

	/****************************
	 * Method:                                        viewFlatbooking
     *Description:                                    To display the FlatBooking by Id (Primary key)
     *@param id:                                      id of the FlatBooking.
	 * @throws FlatbookingNotFoundException 
	 * @returns User                                  If user with Id presents it returns user else throws FlatbookingNotFoundException
	 * @throws FlatbookingNotFoundException           It is raised due to invalid  FlatbookingId 
     *Created By                                       E.Iswarya Lakshmi
     *Created Date                                     24-MARCH-2021                           
	 
	 ****************************/
	@Override
	public FlatBooking viewFlatBooking(Integer id) throws FlatBookingNotFoundException {
		try {
			Optional<FlatBooking> flatBooking = flatBookingRepository.findById(id);
			if (flatBooking.isPresent()) {
				return flatBooking.get();
			} else {
				throw new FlatBookingNotFoundException("the FlatBooking with id " + id + " is not found");
			}
		} catch (Exception e) {
			throw new FlatBookingNotFoundException(e.getMessage());
		}
	}

	/****************************
	 * Method:                                             viewAllFlatBookings
     *Description:                                         To display all the FlatBookings
	 * @throws EmptyEntityListException 
	 * @returns List<FlatBookings>                          It returns all the FlatBookings present in database
                *Created By                                -Eati.Iswarya Lakshmi
                *Created Date                               24-MARCH-2021                           
	 
	 ****************************/
	@Override
	public List<FlatBooking> viewAllFlatBooking() {
		List<FlatBooking> flatbookings = new ArrayList<>();
		try {
			flatbookings = flatBookingRepository.findAll();
			if (flatbookings.isEmpty()) {
				throw new EmptyEntityListException("No FlatBooking Found");
			} else
				return flatbookings;
		} catch (Exception e) {
			throw new EmptyEntityListException(e.getMessage());
		}

	}

}