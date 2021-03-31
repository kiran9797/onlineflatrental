package com.cg.ofr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.Landlord;
import com.cg.ofr.exception.EmptyEntityListException;
import com.cg.ofr.exception.EntityCreationException;
import com.cg.ofr.exception.EntityDeletionException;
import com.cg.ofr.exception.EntityUpdationException;
import com.cg.ofr.repository.ILandlordRepository;

/************************************************************************************
 * @author          Y.Manideep
 * Description      It is a user service implementation class that defines the methods
                    mentioned in its interface.
 * Version          1.0
 * Created Date     23-MARCH-2021
 ************************************************************************************/

@Service
@Transactional
public class LandlordServiceImpl implements ILandlordService {

	@Autowired
	private ILandlordRepository landlordRepository;
	
	/************************************************************************************
	 * Method:                          addLandlord
     * Description:                     It is used to add landlord into landlord_details table
     * @param user:                     User's reference variable.
	 * @returns User                    It returns user with details
     * Created By                       Y.Manideep
     * Created Date                     23-MARCH-2021                           
	 
	 ************************************************************************************/
	
	@Override
	public Landlord addLandlord(Landlord landlord) {
		try {
			return landlordRepository.save(landlord);
		} catch (Exception e) {
			throw new EntityCreationException("valid details of landlord is not entered");
		}

	}
	
	/************************************************************************************
	 * Method:            updateLandlord
     * Description:       It is used to update landlord details into landlord_details table.
     * @param use         Landlord's reference variable.
	 * @returns User      It returns updated details of the existed user.
     * Created By         Y.Manideep
     * Created Date       23-MARCH-2021                           
	 
	 ************************************************************************************/
	
	@Override
	public Landlord updateLandlord(Landlord landlord) {
		try {
			Optional<Landlord> updatelandlord = landlordRepository.findById(landlord.getLandlordId());
			if (updatelandlord.isPresent()) {
				return landlordRepository.save(landlord);
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new EntityUpdationException("No updation found");
		}

	}
	
	/************************************************************************************
	 * Method:                          deleteLandlord
     * Description:                     It is used to remove landlord
     * @param user:                     Landlord's reference variable.
	 * @returns User                    It returns the landlord that has been deleted
	 * @throws UserNotFoundException:   It is raised due to invalid landlord.
     * Created By                       Y.Manideep
     * Created Date                     23-MARCH-2021                           
	 
	 ************************************************************************************/
	
	@Override
	public Landlord deleteLandlord(Landlord landlord) {
		try {

			Optional<Landlord> deletelandlord = landlordRepository.findById(landlord.getLandlordId());
			if (deletelandlord.isPresent()) {
				landlordRepository.delete(landlord);

			}
			return deletelandlord.get();

		} catch (Exception e) {
			throw new EntityDeletionException("landlord details are not valid");
		}

	}
	
	/************************************************************************************
	 * Method:                          viewLandlord
     * Description:                     To display the landlord by Id (Primary key)
     * @param id:                       landlord id of the landlord.
	 * @returns User                    if landlord with Id presents it returns user 
	                                    else throws UserNotFoundException
	 * @throws UserNotFoundException    It is raised due to invalid  LandlordId 
     * Created By                       Y.Manideep
     * Created Date                     23-MARCH-2021                           
	 
	 ************************************************************************************/
	
	@Override
	public Landlord viewLandlord(int id){
		try {
			Optional<Landlord> landlord = landlordRepository.findById(id);
			if (landlord.isPresent()) {
				return landlord.get();
			} else {
				throw new EntityNotFoundException("User is not found for Id " + id);
			}

		} catch (Exception e) {
			throw new EntityNotFoundException(e.getMessage());

		}
	}
	
	/************************************************************************************
	 * Method:                          viewAllLandlord
     * Description:                     To display all the landlord
	 * @returns List<User>              It returns all the landlord's present in database
     * Created By                       Y.Manideep
     * Created Date                     23-MARCH-2021                           
	 
	 ************************************************************************************/
	
	@Override
	public List<Landlord> viewAllLandlord() {
		List<Landlord> landlordlist = new ArrayList<Landlord>();
		try {
			landlordlist = landlordRepository.findAll();
			if (landlordlist.isEmpty()) {
				throw new EmptyEntityListException("No landlord found");

			} else {
				return landlordlist;
			}
		} catch (Exception e) {
			throw new EmptyEntityListException(e.getMessage());
		}

	}

}