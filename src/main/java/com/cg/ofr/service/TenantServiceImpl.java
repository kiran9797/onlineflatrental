package com.cg.ofr.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.Tenant;
import com.cg.ofr.exception.EmptyEntityListException;
import com.cg.ofr.exception.EntityCreationException;
import com.cg.ofr.exception.EntityDeletionException;
import com.cg.ofr.exception.EntityUpdationException;
import com.cg.ofr.exception.TenantNotFoundException;
import com.cg.ofr.repository.ITenantRepository;

/**********
 * 
 *           @author              E.Jagadeesh
 *           Description          It is a Tenant service implementation class
 *                                that defines the methods mentioned in its interface. 
 *           Version              1.0
 *           Created Date         24-MARCH-2021
 * 
 **********/
@Service
@Transactional
public class TenantServiceImpl implements ITenantService {

	@Autowired
	private ITenantRepository tenantRepository;

	/**********
	 * 
	 *       Method:                           addTenant 
	 *       Description:                      This method is used for add tenant and return type tenant
	 * 
	 *       @param tenant:                    Tenant's reference variable.
	 *       @throws EntityCreationException
	 *       @returns tenant                   It returns Tenant with details 
	 *       Created By                        E.Jagadeesh
	 *       Created Date                      24-MARCH-2021
	 * 
	 **********/
	@Override
	public Tenant addTenant(Tenant tenant) {
		try {
			return tenantRepository.save(tenant);

		} catch (Exception e) {
			throw new EntityCreationException(e.getMessage());
		}
	}

	/**********
	 * 
	 *       Method:                           updateTenant
	 *       Description:                      It is used to update Tenant details into Tenant table.
	 * 
	 *       @param tenant:                    Tenant's reference variable.
	 *       @throws EntityUpdationException
	 *       @returns tenant                   It returns updated details of the existed Tenant. 
	 *       Created By                        E.Jagadeesh 
	 *       Created Date                      23-MARCH-2021
	 *
	 **********/

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

	/**********
	 * 
	 *      Method:                            deleteTenant Description: It is used to remove Tenant
	 * 
	 *      @param tenant:                     Tenant's reference variable.
	 *      @throws EntityDeletionException
	 *      @returns tenant                    It returns the Tenant that has been deleted 
	 *      Created By                         E.Jagadeesh
	 *      Created Date                       24-MARCH-2021
	 *
	 **********/
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

	/**********
	 * 
	 *      Method:                               viewTenant 
	 *      Description:                          To display the Tenant by Id (Primary key)
	 * 
	 *      @param id:                            id of the Tenant.
	 *      @returns tenant                       If tenant with Id presents it returns tenant else throws
	 *                                            TenantNotFoundException
	 *      @throws TenantNotFoundException       It is raised due to invalid TenantId 
	 *      Created By                            E.Jagadeesh 
	 *      Created Date                          24-MARCH-2021
	 * 
	 **********/
	@Override
	public Tenant viewTenant(int id) throws TenantNotFoundException {
		try {
			Optional<Tenant> optionalTenant = tenantRepository.findById(id);
			if (optionalTenant.isPresent()) {
				return optionalTenant.get();
			} else {
				throw new TenantNotFoundException(" Tenant Id " + id + " is not found ");
			}

		} catch (Exception e) {
			throw new TenantNotFoundException(e.getMessage());
		}

	}

	/**********
	 * 
	 *      Method:                                viewAllTenant
	 *      Description:                           To display all the Tenants
	 * 
	 *      @throws EmptyEntityListException
	 *      @returns List<Tenants>            It returns all the Tenants present in database
	 *      Created By                             E.Jagadeesh 
	 *      Created Date                           24-MARCH-2021
	 * 
	 **********/
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

	/**********
	 * 
	 *      Method:                                validateTenant 
	 *      Description:                           This method is used for validate tenant by its tenant id
	 *      @param tenant:                         Tenant's reference variable.
	 *      @throws TenantNotFoundException
	 *      @returns tenant                        If Tenant with Id exist it returns tenant else throws
	 *                                             TenantNotFoundException
	 *      @throws TennatNotFoundException        It is raised due to invalid TenantId 
	 *      Created By                             E.Jagadeesh 
	 *      Created Date                           24-MARCH-2021
	 * 
	 **********/

	@Override
	public Tenant validateTenant(Tenant tenant) throws TenantNotFoundException {
		try {
			boolean tenant2 = tenantRepository.existsById(tenant.getTenantId());
			if (tenant2) {
				return tenant;
			} else {
				throw new TenantNotFoundException(" Tenant with id " + tenant.getTenantId() + " does not exist ");
			}
		} catch (Exception e) {
			throw new TenantNotFoundException(e.getMessage());
		}
	}

}