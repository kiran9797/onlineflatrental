package com.cg.ofr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.entities.FlatAddress;
import com.cg.ofr.entities.Landlord;
import com.cg.ofr.exception.LandlordNotFoundException;
import com.cg.ofr.service.LandlordServiceImpl;

@SpringBootTest
public class LandlordTests extends OnlineFlatRentalApplicationTests {

	@Autowired
	private LandlordServiceImpl ilandlordserviceimpl;

	@Test
	public void testviewLandlord1() throws LandlordNotFoundException {
		assertNotNull(ilandlordserviceimpl.viewLandlord(170));
	}
	@Test
	public void testviewLandlord2() throws LandlordNotFoundException {
		assertNotNull(ilandlordserviceimpl.viewLandlord(180));
	}
	
	@Test
	public void testviewAllLandlord() {
		assertNotNull(ilandlordserviceimpl.viewAllLandlord());
	}

	@Test
	public void testaddLandlord1() {
		FlatAddress flatadress = new FlatAddress(112, "chennai", "india", "tamilnadu", 600062, "velnagar");
		Flat flat = new Flat(1000, 5000, flatadress, "yes");
		List<Flat> flatList = new ArrayList<Flat>();
		flatList.add(flat);
		Landlord landlord = new Landlord(170, "karthik", 45, flatList);
		ilandlordserviceimpl.addLandlord(landlord);
		assertEquals("karthik", landlord.getLandlordName());

	}

	@Test
	public void testaddLandlord2() {
		FlatAddress flatadress = new FlatAddress(113, "chennai", "india", "tamilnadu", 600062, "velnagar");
		Flat flat = new Flat(1010, 5000, flatadress, "yes");
		List<Flat> flatList = new ArrayList<Flat>();
		flatList.add(flat);
		Landlord landlord = new Landlord(180, "panda", 25, flatList);
		ilandlordserviceimpl.addLandlord(landlord);
		assertEquals("panda", landlord.getLandlordName());

	}

	@Test
	public void updateLandlord1() {
		FlatAddress flataddress = new FlatAddress(114, "chennai", "india", "tamilnadu", 600062, "velnagar");
		Flat flat = new Flat(1020, 5000, flataddress, "No");
		List<Flat> flatlist = new ArrayList<Flat>();
		flatlist.add(flat);
		Landlord landlord = new Landlord(190, "anil", 25, flatlist);
		landlord.setLandlordName("suresh");
		ilandlordserviceimpl.updateLandlord(landlord);
		assertEquals("suresh", landlord.getLandlordName());

	}

	@Test
	public void updateLandlord2() {
		FlatAddress flatadress = new FlatAddress(115, "chennai", "india", "tamilnadu", 600062, "velnagar");
		Flat flat = new Flat(1030, 5000, flatadress, "No");
		List<Flat> flatlist = new ArrayList<Flat>();
		flatlist.add(flat);
		Landlord landlord = new Landlord(170, "sunil", 25, flatlist);
		landlord.setLandlordAge(40);
		ilandlordserviceimpl.updateLandlord(landlord);
		assertEquals(40, landlord.getLandlordAge());

	}

	@Test
	public void deleteLandlord1() {
		FlatAddress flatadress = new FlatAddress(116, "chennai", "india", "tamilnadu", 600062, "velnagar");
		Flat flat = new Flat(1040, 5000, flatadress, "No");
		List<Flat> flatlist = new ArrayList<Flat>();
		flatlist.add(flat);
		Landlord landlord = new Landlord(120, "kishore", 25, flatlist);
		ilandlordserviceimpl.addLandlord(landlord);
		Landlord landlord1 = ilandlordserviceimpl.deleteLandlord(landlord);
		assertEquals("kishore", landlord1.getLandlordName());
	}

	@Test
	public void deleteLandlord2() {
		FlatAddress flatadress = new FlatAddress(117, "chennai", "india", "tamilnadu", 600062, "velnagar");
		Flat flat = new Flat(1050, 5000, flatadress, "No");
		List<Flat> flatlist = new ArrayList<Flat>();
		flatlist.add(flat);
		Landlord landlord = new Landlord(190, "rakesh", 25, flatlist);
		ilandlordserviceimpl.addLandlord(landlord);
		Landlord landlord1 = ilandlordserviceimpl.deleteLandlord(landlord);
		assertEquals("rakesh", landlord1.getLandlordName());

	}
}