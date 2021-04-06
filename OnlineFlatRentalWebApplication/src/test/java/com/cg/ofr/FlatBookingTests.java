package com.cg.ofr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.entities.FlatAddress;
import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.entities.Tenant;
import com.cg.ofr.exception.EntityDeletionException;
import com.cg.ofr.exception.FlatBookingNotFoundException;
import com.cg.ofr.service.IFlatBookingService;

@SpringBootTest
public class FlatBookingTests extends OnlineFlatRentalApplicationTests {

	@Autowired
	private IFlatBookingService flatBookingService;
	

	@Test
	public void addFlatBookingTest1() {
		FlatAddress flatAddress1 = new FlatAddress(200, "5", "Vizag", "Andhra Pradesh", 530012, "India");
		Flat flat1 = new Flat(107, 1000000, flatAddress1, "yes");
		Tenant tenant1 = new Tenant(1023, 40, null);
		FlatBooking flatBooking1 = new FlatBooking(148, LocalDate.of(2000, 01, 21), LocalDate.of(2005, 11, 26), flat1,
				tenant1);
		tenant1.setFlatbooking(flatBooking1);
		flatBookingService.addFlatBooking(flatBooking1);
		assertEquals(flatBooking1.getBookingFromDate(), LocalDate.of(2000, 01, 21));
		flatBookingService.deleteFlatBooking(flatBooking1);
	}
	@Test
	public void addFlatBookingTest2() {
		FlatAddress flatAddress1 = new FlatAddress(206, "5", "Vizag", "Andhra Pradesh", 530012, "India");
		Flat flat1 = new Flat(1007, 1000000, flatAddress1, "yes");
		Tenant tenant1 = new Tenant(90, 45, null);
		FlatBooking flatBooking1 = new FlatBooking(123, LocalDate.of(2000, 01, 21), LocalDate.of(2005, 11, 26), flat1,
				tenant1);
		tenant1.setFlatbooking(flatBooking1);
		flatBookingService.addFlatBooking(flatBooking1);
		assertEquals(flatBooking1.getBookingFromDate(), LocalDate.of(2000, 01, 21));
		flatBookingService.deleteFlatBooking(flatBooking1);
	}
	
	
	@Test
	public void updateFlatBookingTest1() {
		FlatAddress flatAddress3 = new FlatAddress(1080, "8", "Vizag", "AndhraPradesh", 530018, "India");
		Flat flat3 = new Flat(1005, 1200000, flatAddress3, "yes");
		Tenant tenant3 = new Tenant(301, 30, null);
		FlatBooking flatBooking3 = new FlatBooking(153, LocalDate.of(2020, 11, 21), LocalDate.of(2025, 06, 26), flat3,
				tenant3);
		tenant3.setFlatbooking(flatBooking3);
		flatBooking3.setBookingToDate(LocalDate.of(2020, 5, 9));
		assertEquals(flatBooking3.getBookingToDate(), LocalDate.of(2020, 5, 9));
	}
	@Test
	public void updateFlatBookingTest2() {
		FlatAddress flatAddress3 = new FlatAddress(110, "8", "Vizag", "AndhraPradesh", 530018, "India");
		Flat flat3 = new Flat(100, 1200000, flatAddress3, "yes");
		Tenant tenant3 = new Tenant(300, 30, null);
		FlatBooking flatBooking3 = new FlatBooking(155, LocalDate.of(2020, 11, 21), LocalDate.of(2025, 06, 26), flat3,
				tenant3);
		tenant3.setFlatbooking(flatBooking3);
		flatBooking3.setBookingToDate(LocalDate.of(2020, 05, 19));
		assertEquals(flatBooking3.getBookingToDate(), LocalDate.of(2020, 05, 19));

	}

	
	@Test
	public void deleteFlatBookingTest1() throws EntityDeletionException {
		FlatAddress flatAddress4 = new FlatAddress(205, "2", "Vizag", "AndhraPradesh", 530012, "India");
		Flat flat4 = new Flat(108, 200000, flatAddress4, "yes");
		Tenant tenant4 = new Tenant(100, 30, null);
		FlatBooking flatBooking4 = new FlatBooking(154, LocalDate.of(1996, 12, 21), LocalDate.of(2005, 11, 18), flat4,
				tenant4);
		tenant4.setFlatbooking(flatBooking4);
		flatBookingService.addFlatBooking(flatBooking4);
		FlatBooking deleteFlatBooking=flatBookingService.deleteFlatBooking(flatBooking4);
		assertNotNull(deleteFlatBooking);
	}
	@Test
	public void deleteFlatBookingTest2() throws EntityDeletionException {
		FlatAddress flatAddress4 = new FlatAddress(203, "2", "Vizag", "AndhraPradesh", 530012, "India");
		Flat flat4 = new Flat(1008, 200000, flatAddress4, "yes");
		Tenant tenant4 = new Tenant(50, 20, null);
		FlatBooking flatBooking4 = new FlatBooking(169, LocalDate.of(1996, 12, 1), LocalDate.of(2005, 12, 1), flat4,
				tenant4);
		tenant4.setFlatbooking(flatBooking4);
		flatBookingService.addFlatBooking(flatBooking4);
		FlatBooking deleteFlatBooking=flatBookingService.deleteFlatBooking(flatBooking4);
		assertNotNull(deleteFlatBooking);
	}

	
	@Test
	public void viewFlatBookingTest1() throws FlatBookingNotFoundException {
		FlatAddress flatAddress2 = new FlatAddress(101, "9", "Vizag", "AndhraPradesh", 530092, "India");
		Flat flat2 = new Flat(1002, 100000, flatAddress2, "no");
		Tenant tenant2 = new Tenant(600, 20, null);
		FlatBooking flatBooking2 = new FlatBooking(1091, LocalDate.of(2020, 01, 29), LocalDate.of(2025, 06, 26), flat2,
				tenant2);
		tenant2.setFlatbooking(flatBooking2);
		flatBookingService.addFlatBooking(flatBooking2);
		FlatBooking flatBookingTest = flatBookingService.viewFlatBooking(flatBooking2.getBookingNo());
		assertEquals(flatBookingTest.getBookingNo(), flatBooking2.getBookingNo());
		flatBookingService.deleteFlatBooking(flatBooking2);	
	}
	@Test
	public void viewFlatBookingTest2() throws FlatBookingNotFoundException {
		FlatAddress flatAddress2 = new FlatAddress(1230, "9", "Vizag", "AndhraPradesh", 530092, "India");
		Flat flat2 = new Flat(1020, 100000, flatAddress2, "no");
		Tenant tenant2 = new Tenant(200, 20, null);
		FlatBooking flatBooking2 = new FlatBooking(1095, LocalDate.of(2020, 06, 26), LocalDate.of(2025, 06, 26), flat2,
				tenant2);
		tenant2.setFlatbooking(flatBooking2);
		flatBookingService.addFlatBooking(flatBooking2);
		FlatBooking flatBookingTest = flatBookingService.viewFlatBooking(flatBooking2.getBookingNo());
		assertEquals(flatBookingTest.getBookingNo(), flatBooking2.getBookingNo());
		flatBookingService.deleteFlatBooking(flatBooking2);
	}
	@Test
	public void viewAllFlatBookingTest1() {
		assertNotNull(flatBookingService.viewAllFlatBooking());
	}

	@Test
	public void viewAllFlatBookingTest2() {
		assertNotNull(flatBookingService.viewAllFlatBooking());
	}
}