package com.cg.ofr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.Tenant;
import com.cg.ofr.exception.EmptyEntityListException;
import com.cg.ofr.exception.EntityCreationException;
import com.cg.ofr.exception.EntityDeletionException;
import com.cg.ofr.exception.EntityUpdationException;
import com.cg.ofr.repository.ITenantRepository;

/**
 * @author Student
 *
 */
@Service
@Transactional
public class TenantServiceImpl implements ITenantService {

	@Autowired
	private ITenantRepository tenantRepository;

	@Override
	public Tenant addTenant(Tenant tenant) {
		try {
			if (!tenantRepository.existsById(tenant.getTenantId())) {
				Tenant tenant2 = tenantRepository.save(tenant);
				return tenant2;
			} else {
				throw new EntityCreationException("Tenant already exists");
			}
		} catch (Exception e) {
			throw new EntityCreationException(e.getMessage());
		}
	}

	@Override
	public Tenant updateTenant(Tenant tenant) {
		try {
			Optional<Tenant> optionalTenant = tenantRepository.findById(tenant.getTenantId());
			Tenant tenant2 = null;
			if (optionalTenant.isPresent()) {
				tenant2 = tenantRepository.save(tenant);
				return tenant2;
			} else {
				throw new EntityUpdationException("Tenant cannot be updated with id " + tenant.getTenantId());
			}
		} catch (Exception e) {
			throw new EntityUpdationException(e.getMessage());
		}
	}

	@Override
	public Tenant deleteTenant(Tenant tenant) {
		try {
			Optional<Tenant> optionalTenant = tenantRepository.findById(tenant.getTenantId());
			Tenant tenant2 = null;
			if (optionalTenant.isPresent()) {
				tenant2 = optionalTenant.get();
				tenantRepository.delete(tenant);
				return tenant2;
			} else {
				throw new EntityDeletionException(
						"tenant cannot be deleted as tenant with id " + tenant.getTenantId() + " does not exist");
			}
		} catch (Exception e) {
			throw new EntityDeletionException(e.getMessage());
		}

	}

	@Override
	public Tenant viewTenant(int id) {
		try {
			Optional<Tenant> optionalTenant = tenantRepository.findById(id);
			if (optionalTenant.isPresent()) {
				return optionalTenant.get();
			} else {
				throw new EntityNotFoundException(" Tenant Id " + id + " is not found ");
			}

		} catch (Exception e) {
			throw new EntityNotFoundException(e.getMessage());
		}

	}

	@Override
	public List<Tenant> viewAllTenant() {
		List<Tenant> tenants = new ArrayList<>();

		try {
			tenants = tenantRepository.findAll();
			if (tenants.isEmpty()) {
				throw new EmptyEntityListException("No Tenant Found");
			} else {
				return tenants;
			}
		} catch (Exception e) {
			throw new EmptyEntityListException(e.getMessage());
		}
	}

	@Override
	public Tenant validateTenant(Tenant tenant) {
		try {
			if (tenant.getAge() <= 0) {
				throw new RuntimeException("Age is Invalid");
			} else {
				return tenant;
			}
		} catch (Exception e) {
			throw e;
		}
	}

}