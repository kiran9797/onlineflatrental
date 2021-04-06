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

import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.exception.FlatBookingNotFoundException;
import com.cg.ofr.service.IFlatBookingService;

import io.swagger.annotations.Api;
/****************************
 * @author         E.Iswarya Lakshmi 
 * Description     It is a controller class that controls the
          		   data flow into model object and updates the view whenever data
           		   changes 
 *  Version        1.0 
 *  Created Date   26-MARCH-2021
 ****************************/

@RestController
@Api(value = "Swagger2DemoRestController")

public class FlatBookingRest {
	@Autowired
	private IFlatBookingService flatBookingService;

	/****************************
	 * Method: 					addFlatBooking
	 * Description: 			It is used to add FlatBooking into Landlord_details table 
	 * @param FlatBooking: 		FlatBooking's reference variable.
	 * @returns FlatBooking        It returns FlatBooking with details
	 * @PostMapping:            It is used to handle POST type of request method
	 * @RequestBody:            It maps the HttpRequest body to a transfer or domain object
	 * Created By               E,Iswarya Lakshmi
	 * Created Date             26-MARCH-2021
	 * 
	 ****************************/
	@PostMapping("/flatbooking")
	public FlatBooking addFlatBooking(@RequestBody FlatBooking flatBooking) {
		FlatBooking flatBooking1 = null;
		flatBooking1 = flatBookingService.addFlatBooking(flatBooking);
		return flatBooking1;
	}

	/****************************
	 * Method: 						updateFlatBooking
	 * Description: 				It is used to update FlatBooking details into 
	 * 								FlatBooking_details table.
	 * @param FlatBooking: 			FlatBooking reference variable.
	 * @returns FlatBooking 		It returns updated details of the existed FlatBooking.
	 * @PuttMapping: 				It is used to handle PUT type of request method
	 * @RequestBody: 				It maps the HttpRequest body to a transfer or domain object
	 * Created By 					E. Iswarya Lakshmi
	 * Created Date                 26-MARCH-2021
	 * 
	 ****************************/
	@PutMapping("/flatbooking")
	public FlatBooking updateFlatBooking(@RequestBody FlatBooking flatBooking) {
		FlatBooking flatBooking2 = null;
		flatBooking2 = flatBookingService.updateFlatBooking(flatBooking);
		return flatBooking2;
	}
	/****************************
	 * Method: 						   removeFlatBooking
	 * Description: 				   It is used to remove user
	 * @param FlatBooking:			   FlatBooking reference variable.
	 * @returns FlatBooking            It returns the FlatBooking that has been deleted
	 * @DeleteMapping:                 It is used to handle DELETE type of request method.
	 * @RequestBody:                   It maps the HttpRequest body to a transfer 
	 								   or domain object
	 * Created By                      E .Iswarya Lakshmi
	 * Created Date                    26-MARCH-2021
	 ****************************/
	
	@DeleteMapping("/flatbooking")
	public FlatBooking deleteFlatBooking(@RequestBody FlatBooking flatBooking) {
		FlatBooking flatBooking3 = null;
		flatBooking3 = flatBookingService.deleteFlatBooking(flatBooking);
		return flatBooking3;
	}

	/****************************
	 * Method: 			                          viewFlatBooking
	 * Description: 	                          To display the FlatBooking by Id (Primary key) 
	 * @param id: 		                          id of the FlatBooking.
	 * @returns FlatBooking                       If FlatBooking with Id presents it returns FlatBooking else throws
	                                                   FlatBookingNotFoundException
	 * @throws FlatBookingNotFoundException       It is raised due to invalid LandlordId
	 * @GetMapping:                               It is used to handle GET type of request method.
	 * @PathVariable:                             It is used for data passed in the URI and transfer its values
	                                                   to parameter variables. 
	 * Created By                                 E.Iswarya Lakshmi
	 * Created Date                               26-MARCH-2021
	 
	 ****************************/
	@GetMapping("/flatbooking/{id}")
	public FlatBooking viewFlatBooking(@PathVariable Integer id) throws FlatBookingNotFoundException {
		FlatBooking flatBooking4 = flatBookingService.viewFlatBooking(id);
		return flatBooking4;
	}

	/****************************
	 * Method: 				            viewAllFlatBookings 
	 * Description: 		            To display all the users
	 * 
	 * @returns List<FlatBookings >      It returns all the FlatBookings  present in database
	 * @GetMapping: 		             It is used to handle GET type of request method.
	 * Created By                        E.Iswarya Lakshmi
	 * Created Date                      26-MARCH-2021
	 * 
	 ****************************/
	@GetMapping("/flatbookings")

	public List<FlatBooking> viewAllFlatBooking() {
		List<FlatBooking> flatBookings = flatBookingService.viewAllFlatBooking();
		return flatBookings;
	}

}