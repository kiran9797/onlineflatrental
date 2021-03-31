package com.cg.ofr.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.entities.Tenant;
import com.cg.ofr.service.ITenantService;

import io.swagger.annotations.Api;

@Api(value="SwaggerDemoRestController")
@RestController
@RequestMapping("/tenant")
public class TenantRest {
	
	@Autowired 
	private ITenantService iTenantService;
	
	
	@PostMapping("/add")
	public Tenant addTenant(@RequestBody Tenant tenant) {
		Tenant tenant2=null;
		tenant2=this.iTenantService.addTenant(tenant);
		return tenant2;
	}
	
	@PutMapping("/update")
	public Tenant updateTenant(@RequestBody Tenant tenant) {
		Tenant tenant2=null;
		tenant2=this.iTenantService.updateTenant(tenant);
		return tenant2;
	}
	
	@DeleteMapping("/delete")
	public Tenant deleteTenant(@RequestBody Tenant tenant) {
		Tenant tenant2=null;
		tenant2=this.iTenantService.deleteTenant(tenant);
		return tenant2;
	}
	
	@GetMapping("/view/{id}")
		public Tenant viewTenant(@PathVariable("id") Integer id) {
		Tenant tenant=this.iTenantService.viewTenant(id);
		return tenant;
	}
	
	@GetMapping("/viewAll")
	public List<Tenant> viewAllTenant() {
		List<Tenant> tenants=this.iTenantService.viewAllTenant();
	    return tenants;
}
	@GetMapping("/exist")
	public Tenant validateTenant(@RequestBody Tenant tenant){
		 Tenant tenant2=null;
		 tenant2 = this.iTenantService.validateTenant(tenant);
		 return tenant2;
	}

}