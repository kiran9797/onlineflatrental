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
import com.cg.ofr.entities.Flat;
import com.cg.ofr.exception.FlatNotFoundException;
import com.cg.ofr.service.IFlatService;

/**************************************************************************************************
 * @author         Kiran kumar panda
 * Description     It is a controller class that controls the
          		   data flow into model object and updates the view whenever data
           		   changes 
 *  Version        1.0 
 *  Created Date   26-MARCH-2021
 *************************************************************************************************/


@RestController
public class FlatRest {

	@Autowired
	private IFlatService flatService;
	
	/*********************************************************************************************
	 * Method: 			viewFlats
	 * Description: 		To display all the flats
	 * 
	 * @returns List<Flat>  It returns all the flats present in database
	 * @GetMapping: 		It is used to handle GET type of request method.
	 * Created By           Kiran kumar panda
	 * Created Date         26-MARCH-2021
	 * 
	 *********************************************************************************************/

	@GetMapping("/flats")
	public List<Flat> viewFlats() {
		List<Flat> allFlats = flatService.viewAllFlat();
		return allFlats;
	}
	
	/*********************************************************************************************
	 * Method: 			viewFlatById 
	 * Description: 	To display the flat by Id (Primary key) 
	 * @param id: 		id of the flat.
	 * @throws           FlatNotFoundException 
	 * @returns flat    If landlord with Id presents it returns flat else throws
	                    EntityNotFoundException
	 * @GetMapping:      It is used to handle GET type of request method.
	 * @PathVariable:    It is used for data passed in the URI and transfer its values
	                     to parameter variables. 
	 * Created By        Kiran kumar panda
	 * Created Date      26-MARCH-2021
	 
	 ****************************************************************************************************/

	@GetMapping("/flat/{id}")
	public Flat viewFlatById(@PathVariable int id) throws FlatNotFoundException
	{
		Flat flat = flatService.viewFlat(id);
		return flat;
	}
	
	/*********************************************************************************************************
	 * Method: 					viewFlatByCostAndAvailability 
	 * Description: 			To display the flat by cost and availability
	 * @param cost: 			cost of the flat.
	 * @param availability:	 	availability of the flat
	 * @returns List<Flat>    		If Flat with by cost and availability presents it returns Flat else throws
	                    		EmptyEntityListException
	 * @throws EmptyEntityListException - It is raised due to Empty Flats by the provided cost and availability
	 * @GetMapping:      		It is used to handle GET type of request method.
	 * @PathVariable:    		It is used for data passed in the URI and transfer its values
	                     		to parameter variables. 
	 * Created By        		Kiran kumar panda
	 * Created Date      		26-MARCH-2021
	 
	 **************************************************************************************************************/

	@GetMapping("/flat/{cost}/{availability}")
	public List<Flat> viewFlatByCostAndAvailability(@PathVariable float cost, @PathVariable String availability) {
		List<Flat> allFlatsByCostAndAvailability = flatService.viewAllFlatByCost(cost, availability);
		return allFlatsByCostAndAvailability;
	}
	
	/*******************************************************************************************************
	 * Method: 					addFlat
	 * Description: 			It is used to add Flat into Flat table 
	 * @param flat: 			Flat reference variable.
	 * @returns Flat        	It returns Flat with details
	 * @PostMapping:            It is used to handle POST type of request method
	 * @RequestBody:            It maps the HttpRequest body to a transfer or domain object
	 * Created By               Kiran kumar panda
	 * Created Date             26-MARCH-2021
	 * 
	 ********************************************************************************************************/
	
	@PostMapping("/flat")
	public Flat addFlat(@RequestBody Flat flat) {
		Flat flat1 = null;
		flat1 = this.flatService.addFlat(flat);
		return flat1;

	}
	
	/*******************************************************************************************************
	 * Method: 						updateFlat
	 * Description: 				It is used to update Flat details into Flat table.
	 * @param flat: 				Flat reference variable.
	 * @throws FlatNotFoundException 
	 * @returns Flat 				It returns updated details of the existed Flat.
	 * @PuttMapping: 				It is used to handle PUT type of request method
	 * @RequestBody: 				It maps the HttpRequest body to a transfer or domain object
	 * Created By 					Kiran kumar panda
	 * Created Date                 26-MARCH-2021
	 * 
	 *******************************************************************************************************/

	@PutMapping("/flat")
	public Flat updateFlat(@RequestBody Flat flat) throws FlatNotFoundException {
		Flat flat1 = null;
		flat1 = flatService.updateFlat(flat);
		return flat1;
	}
	
	/******************************************************************************************************
	 * Method: 						   	deleteFlat
	 * Description: 				   	It is used to remove Flat
	 * @param flat:			       		Flat reference variable.
	 * @returns Flat               		It returns the Flat that has been deleted
	 * @DeleteMapping:                 	It is used to handle DELETE type of request method.
	 * @RequestBody:                  	It maps the HttpRequest body to a transfer 
	 								   	or domain object
	 * Created By                      	Kiran kumar panda
	 * Created Date                    	26-MARCH-2021
	 **********************************************************************************************************/

	@DeleteMapping("/flat")
	public Flat deleteFlat(@RequestBody Flat flat) {
		Flat deletedFlat = flatService.deleteFlat(flat);
		return deletedFlat;

	}

}
