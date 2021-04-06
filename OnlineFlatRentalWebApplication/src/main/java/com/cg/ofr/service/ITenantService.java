package com.cg.ofr.service;

import java.util.List;


import com.cg.ofr.entities.Tenant;
import com.cg.ofr.exception.TenantNotFoundException;

/**
 * 
 * This is an interface for Tenant service with methods of
 * add,update,delete,view,viewAll and validate Tenants
 * 
 * @author E.Jagadeesh 
 * 
 **/
public interface ITenantService {
	public Tenant addTenant(Tenant tenant);

	public Tenant updateTenant(Tenant tenant);

	public Tenant deleteTenant(Tenant tenant);

	public Tenant viewTenant(int id) throws  TenantNotFoundException;

	public List<Tenant> viewAllTenant();

	public Tenant validateTenant(Tenant tenant) throws TenantNotFoundException;
}