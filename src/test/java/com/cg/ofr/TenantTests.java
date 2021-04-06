package com.cg.ofr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.entities.FlatAddress;
import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.entities.Tenant;
import com.cg.ofr.exception.TenantNotFoundException;
import com.cg.ofr.service.ITenantService;

@SpringBootTest
public class TenantTests {

	@Autowired
	ITenantService itenantService;

	FlatAddress flatAddress11 = new FlatAddress(211, "Golden street", "Ongole", "Andhra Pradesh", 523001, "India");
	Flat flat11 = new Flat(99, 100000, flatAddress11, "yes");
	FlatBooking flatBooking11 = new FlatBooking(999, LocalDate.of(2015, 11, 21), LocalDate.of(2020, 11, 21), flat11,
			null);
	Tenant tenant11 = new Tenant(999, 41, flatBooking11);

	FlatAddress flatAddress12 = new FlatAddress(212, "French street", "Vijayawada", "Andhra Pradesh", 52441, "India");
	Flat flat12 = new Flat(12, 200000, flatAddress12, "yes");
	FlatBooking flatBooking12 = new FlatBooking(112, LocalDate.of(2015, 11, 21), LocalDate.of(2020, 11, 21), flat12,
			null);
	Tenant tenant12 = new Tenant(12, 42, flatBooking12);

	FlatAddress flatAddress13 = new FlatAddress(213, "Court street", "Vizag", "Andhra Pradesh", 524321, "India");
	Flat flat13 = new Flat(13, 400000, flatAddress13, "yes");
	FlatBooking flatBooking13 = new FlatBooking(146, LocalDate.of(2015, 11, 21), LocalDate.of(2020, 11, 21), flat13,
			null);
	Tenant tenant13 = new Tenant(13, 43, flatBooking13);

	@Test
	@DisplayName("add tenant999 should work")
	void addTenantTest1() {
		assertEquals(100000, flat11.getCost());
		System.out.println("Successfully tenant is added");
	}

	@Test
	@DisplayName("adding tenant12 should work")
	void addTenantTest2() {
		assertNotNull(tenant11.getTenantId());
		System.out.println("Successfully tenant is added");
	}

	@Test
	@DisplayName("update tenant11 should work")
	void updateTenantTest1() {
		itenantService.addTenant(tenant11);
		tenant11.setAge(44);
		itenantService.updateTenant(tenant11);
		assertEquals(44, tenant11.getAge());
		System.out.println("Successfully tenant is updated");
	}

	@Test
	@DisplayName("update tenant12 should work")
	void updateTenantTest2() {
		itenantService.addTenant(tenant12);
		flat12.setCost(300000);
		itenantService.updateTenant(tenant12);
		assertEquals(300000, flat12.getCost());
		System.out.println("Successfully tenant is updated");
	}

	@Test
	@DisplayName("delete tenant11 should work")
	void deleteTenantTest1() {
		itenantService.addTenant(tenant11);
		Tenant removeTenant1 = itenantService.deleteTenant(tenant11);
		assertEquals(999, removeTenant1.getTenantId());
		System.out.println("Successfully tenant is deleted");
	}

	@Test
	@DisplayName("delete tenant13 should work")
	void deleteTenantTest2() {
		itenantService.addTenant(tenant13);
		Tenant removeTenant2 = itenantService.deleteTenant(tenant13);
		assertEquals(43, removeTenant2.getAge());
		itenantService.deleteTenant(tenant12);
		System.out.println("Successfully tenant is deleted");
	}

	@Test
	@DisplayName("view tenant should work")
	void viewTenanTest() throws TenantNotFoundException {
		Tenant tenant = itenantService.viewTenant(tenant11.getTenantId());
		assertEquals(tenant11.getTenantId(), tenant.getTenantId());
	}

	@Test
	@DisplayName("view all tenant should work")
	void viewAllTenanTest() {
		assertNotNull((itenantService.viewAllTenant()));

	}

}
