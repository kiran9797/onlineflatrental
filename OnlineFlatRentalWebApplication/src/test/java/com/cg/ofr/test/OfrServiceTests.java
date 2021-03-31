package com.cg.ofr.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.entities.FlatAddress;
import com.cg.ofr.entities.Landlord;
import com.cg.ofr.service.LandlordServiceImpl;

@SpringBootTest
public class OfrServiceTests {

	@Autowired
	private LandlordServiceImpl ilandlordserviceimpl;


	@Test
	public void testviewLandlord()  {
		assertEquals("panda", ilandlordserviceimpl.viewLandlord(5).getLandlordName());
	}

	@Test
	public void testviewAllLandlord() {
		assertEquals("karthik", ilandlordserviceimpl.viewAllLandlord().get(1).getLandlordName());
	}

	@Test
	public void testaddLandlord() {
		FlatAddress flatadress = new FlatAddress(12, "chennai", "india", "tamilnadu", 600062, "velnagar");
		Flat flat = new Flat(10, 5000, flatadress, "yes");
		List<Flat> flatList = new ArrayList<Flat>();
		flatList.add(flat);
		Landlord landlord = new Landlord(4, "karthik", 45, flatList);
		ilandlordserviceimpl.addLandlord(landlord);
		assertEquals("karthik", landlord.getLandlordName());

	}

	@Test
	public void testaddLandlord2() {
		FlatAddress flatadress = new FlatAddress(13, "chennai", "india", "tamilnadu", 600062, "velnagar");
		Flat flat = new Flat(11, 5000, flatadress, "yes");
		List<Flat> flatList = new ArrayList<Flat>();
		flatList.add(flat);
		Landlord landlord = new Landlord(5, "panda", 25, flatList);
		ilandlordserviceimpl.addLandlord(landlord);
		assertEquals("panda", landlord.getLandlordName());

	}

	@Test
	public void updateLandlord()  {
		FlatAddress flataddress = new FlatAddress(14, "chennai", "india", "tamilnadu", 600062, "velnagar");
		Flat flat = new Flat(11, 5000, flataddress, "No");
		List<Flat> flatlist = new ArrayList<Flat>();
		flatlist.add(flat);
		Landlord landlord = new Landlord(6, "anil", 25, flatlist);
		landlord.setLandlordName("suresh");
		ilandlordserviceimpl.updateLandlord(landlord);
		assertEquals("suresh", landlord.getLandlordName());

	}
	@Test
	public void updateLandlord2() {
		FlatAddress flatadress = new FlatAddress(15, "chennai", "india", "tamilnadu", 600062, "velnagar");
		Flat flat = new Flat(11, 5000, flatadress, "No");
		List<Flat> flatlist = new ArrayList<Flat>();
		flatlist.add(flat);
		Landlord landlord = new Landlord(7, "sunil", 25, flatlist);
		landlord.setLandlordAge(40);
		ilandlordserviceimpl.updateLandlord(landlord);
		assertEquals(40, landlord.getLandlordAge());

	}
	@Test
	public void deleteLandlord()  {
		FlatAddress flatadress = new FlatAddress(16, "chennai", "india", "tamilnadu", 600062, "velnagar");
		Flat flat = new Flat(12, 5000, flatadress, "No");
		List<Flat> flatlist = new ArrayList<Flat>();
		flatlist.add(flat);
		Landlord landlord = new Landlord(8, "kishore", 25, flatlist);
		ilandlordserviceimpl.addLandlord(landlord);
		Landlord landlord1=ilandlordserviceimpl.deleteLandlord(landlord);
		assertEquals("kishore", landlord1.getLandlordName());	
}
	@Test
	public void deleteLandlord2(){
		FlatAddress flatadress = new FlatAddress(17, "chennai", "india", "tamilnadu", 600062, "velnagar");
		Flat flat = new Flat(13, 5000, flatadress, "No");
		List<Flat> flatlist = new ArrayList<Flat>();
		flatlist.add(flat);
		Landlord landlord = new Landlord(9, "rakesh", 25, flatlist);
		ilandlordserviceimpl.addLandlord(landlord);
		Landlord landlord1=ilandlordserviceimpl.deleteLandlord(landlord);
		assertEquals("rakesh", landlord1.getLandlordName());
	
}
}
