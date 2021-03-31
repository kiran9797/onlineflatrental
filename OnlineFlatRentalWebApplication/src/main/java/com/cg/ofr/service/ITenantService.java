package com.cg.ofr.service;

import java.util.List;

import com.cg.ofr.entities.Tenant;

public interface ITenantService {
	public Tenant addTenant(Tenant tenant);

	public Tenant updateTenant(Tenant tenant);

	public Tenant deleteTenant(Tenant tenant);

	public Tenant viewTenant(int id);

	public List<Tenant> viewAllTenant();

	public Tenant validateTenant(Tenant tenant);
}
