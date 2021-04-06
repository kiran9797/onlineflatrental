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

import com.cg.ofr.entities.Tenant;
import com.cg.ofr.exception.TenantNotFoundException;
import com.cg.ofr.service.ITenantService;

import io.swagger.annotations.Api;

@Api(value = "SwaggerDemoRestController")

/****
 * 
 * @author         E.Jagadeesh 
 * Description     It is a controller class that controls the
 *                 data flow into model object and used to get response for
 *                 add,update,delete and view the tenant detail. 
 * Version         1.0 
 * Created Date    26-MARCH-2021
 * 
 ****/

@RestController
public class TenantRest {

	@Autowired
	private ITenantService iTenantService;
	
	/**********
	 * 
	 * Method: 					 addTenant
	 * Description: 			 This method is used for add the tenant.
	 * @param tenant: 		     Tenant's reference variable.
	 * @returns tenant           It returns Tenant with details
	 * @PostMapping:             It is used to handle POST type of request method
	 * @RequestBody:             It maps the HttpRequest body to a transfer or domain object
	 * Created By                E.Jagadeesh
	 * Created Date              26-MARCH-2021
	 * 
	 **********/

	@PostMapping("/tenant")
	public Tenant addTenant(@RequestBody Tenant tenant) {
		Tenant tenant2 = null;
		tenant2 = this.iTenantService.addTenant(tenant);
		return tenant2;
	}
	
	/**********
	 * 
	 * Method: 					 updateTenant
	 * Description: 		   	 This method is used for update the tenant
	 * @param tenant: 		     Tenant's reference variable.
	 * @returns tenant           It returns updated details of existed Tenant 
	 * @PuttMapping: 		     It is used to handle PUT type of request method
	 * @RequestBody: 		     It maps the HttpRequest body to a transfer or domain object
	 * Created By 			     E.Jagadeesh
	 * Created Date              26-MARCH-2021
	 * 
	 **********/

	@PutMapping("/tenant")
	public Tenant updateTenant(@RequestBody Tenant tenant) {
		Tenant tenant2 = null;
		tenant2 = this.iTenantService.updateTenant(tenant);
		return tenant2;
	}
	
	/**********
	 * 
	 * Method: 					 deleteTenant
	 * Description: 			 This method is used to delete the tenant
	 * @param tenant: 		     Tenant's reference variable.
	 * @returns tenant           It returns Tenant that has been deleted 
	 * @DeleteMapping:           It is used to handle DELETE type of request method.
	 * @RequestBody:             It maps the HttpRequest body to a transfer 
	 						     or domain object
	 * Created By                E.Jagadeesh
	 * Created Date              26-MARCH-2021
	 * 
	 **********/
	
	@DeleteMapping("/tenant")
	public Tenant deleteTenant(@RequestBody Tenant tenant) {
		Tenant tenant2 = null;
		tenant2 = this.iTenantService.deleteTenant(tenant);
		return tenant2;
	}
	
	/**********
	 * 
	 * Method: 			                          viewTenant
	 * Description: 	                          This method is used for find tenant id and it return the details for specific id 
	 * @param id: 		                          id of the Tenant.
	 * @returns tenant                            It returns Tenant if tenant with id present else throws EntityNotFoundException
	 * @throws TenantNotFoundException            It is raised due to invalid TenantId
	 * @GetMapping:                               It is used to handle GET type of request method.
	 * @PathVariable:                             It is used for data passed in the URI and transfer its values
	                                              to parameter variables. 
	 * Created By                                 E.Jagadeesh
	 * Created Date                               26-MARCH-2021
	 *  
	 **********/

	@GetMapping("/tenant/{id}")
	public Tenant viewTenant(@PathVariable("id") Integer id) throws TenantNotFoundException {
		Tenant tenant = this.iTenantService.viewTenant(id);
		return tenant;
	}

		/**********
		 * 
		 * Method: 				       viewAllTenants 
		 * Description: 		       This method is used for view all tenant details
		 * @returns List<Tenant >      It returns all the tenants present in database
		 * @GetMapping: 		       It is used to handle GET type of request method.
		 * Created By                  E.Jagadeesh
		 * Created Date                26-MARCH-2021
		 * 
		 **********/

	@GetMapping("/tenants")
	public List<Tenant> viewAllTenant() {
		List<Tenant> tenants = this.iTenantService.viewAllTenant();
		return tenants;
	}

	/**********
	 * 
	 * Method: 						   validateTenant
	 * Description: 				   This method is used for find exists tenant id
	 * @param tenant: 		           Tenant's reference variable.
	 * @throws TenantNotFoundException 
	 * @returns tenant                 It returns Tenant if it exist in database
	 * @DeleteMapping:                 It is used to handle GET type of request method.
	 * @RequestBody:                   It maps the HttpRequest body to a transfer 
	 								   or domain object
	 * Created By                      E.Jagadeesh
	 * Created Date                    26-MARCH-2021
	 * 
	 **********/
	@PutMapping("/tenantexist")
	public Tenant validateTenant(@RequestBody Tenant tenant) throws TenantNotFoundException {
		Tenant tenant2 = null;
		tenant2 = this.iTenantService.validateTenant(tenant);
		return tenant2;
	}

}