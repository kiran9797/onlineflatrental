package com.cg.ofr.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.entities.Landlord;
import com.cg.ofr.service.ILandlordService;

/************************************************************************************
 * @author         Y.Manideep 
 * Description     It is a controller class that controls the
          		   data flow into model object and updates the view whenever data
           		   changes Version 1.0 Created Date 25-MARCH-2021
 ************************************************************************************/
@RestController
public class LandlordRest {

	@Autowired
	private ILandlordService Ilandlordservice;
	
	/************************************************************************************
	 * Method: 					addLandlord
	 * Description: 			It is used to add Landlord into Landlord_details table 
	 * @param landlord: 		Landlord's reference variable.
	 * @returns Landlord        It returns landlord with details
	 * @PostMapping:            It is used to handle POST type of request method
	 * @RequestBody:            It maps the HttpRequest body to a transfer or domain object
	 * Created By               Y.Manideep
	 * Created Date             25-MARCH-2021
	 * 
	 ************************************************************************************/
	
	@PostMapping("/landlord")
	public Landlord addLandlord(@RequestBody Landlord landlord) {
		Landlord landlord2 = null;
		landlord2=this.Ilandlordservice.addLandlord(landlord);
		return landlord2;
	}
	
	/************************************************************************************
	 * Method: 						updateLandlord
	 * Description: 				It is used to update landlord details into 
	 * 								landlord_details table.
	 * @param landlord: 			landlord's reference variable.
	 * @returns Landlord 			It returns updated details of the existed landlord.
	 * @PuttMapping: 				It is used to handle PUT type of request method
	 * @RequestBody: 				It maps the HttpRequest body to a transfer or domain object
	 * Created By 					Y.Manideep
	 * Created Date                 25-MARCH-2021
	 * 
	 ************************************************************************************/
	
	@PutMapping("/landlord")
	public Landlord updateLandlord(@RequestBody Landlord landlord) {
		Landlord landlord2 = null;
		landlord2 = this.Ilandlordservice.updateLandlord(landlord);
		return landlord2;
	}
	
	/************************************************************************************
	 * Method: 						   removeUser
	 * Description: 				   It is used to remove user
	 * @param landlord:			       landlord's reference variable.
	 * @returns landlord               It returns the landlord that has been deleted
	 * @throws UserNotFoundException:  It is raised due to invalid user.
	 * @DeleteMapping:                 It is used to handle DELETE type of request method.
	 * @RequestBody:                   It maps the HttpRequest body to a transfer 
	 								   or domain object
	 * Created By                      Y.Manideep
	 * Created Date - 25-MARCH-2021
	 * 
	 ************************************************************************************/
	
	@DeleteMapping("/landlord")
	public Landlord deleteLandlord(@RequestBody Landlord landlord) {
		Landlord landlord2 = null;
		landlord2 = this.Ilandlordservice.deleteLandlord(landlord);
		return landlord2;
	}
	
	/************************************************************************************
	 * Method: 			viewLandlord 
	 * Description: 	To display the landlord by Id (Primary key) 
	 * @param id: 		id of the landlord.
	 * @returns User -  If landlord with Id presents it returns landlord else throws
	                    LandlordNotFoundException
	 * @throws LandlordNotFoundException - It is raised due to invalid LandlordId
	 * @GetMapping:      It is used to handle GET type of request method.
	 * @PathVariable:    It is used for data passed in the URI and transfer its values
	                     to parameter variables. 
	 * Created By        Y.Manideep
	 * Created Date     25-MARCH-2021
	 
	 ************************************************************************************/
	
	@GetMapping("/landlord/{id}")
	public Landlord viewLandlord(@PathVariable int id)  {
		return Ilandlordservice.viewLandlord(id);
	
	}
	
	/************************************************************************************
	 * Method: 				viewAllUser 
	 * Description: 		To display all the users
	 * 
	 * @returns List<User>  It returns all the users present in database
	 * @GetMapping: 		It is used to handle GET type of request method.
	 * Created By           Y.Manideep
	 * Created Date         25-MARCH-2021
	 * 
	 ************************************************************************************/
	
	@GetMapping("/landlords")
	public List<Landlord> viewAlllandlord() {
		List<Landlord> landlord = this.Ilandlordservice.viewAllLandlord();
		return landlord;
	}

}