package com.cg.ofr;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.ofr.entities.Flat;
import com.cg.ofr.entities.FlatAddress;
import com.cg.ofr.exception.FlatNotFoundException;
import com.cg.ofr.service.IFlatService;

/***************************************************************************************************
 *@author          Kiran kumar panda
 *Description      It is a FlatBooking Testcases implementation class that tests the
 *                 crud Operations defined in service interface
 *             
 *Version             1.0
 *Created Date    25-MARCH-2021
 ***************************************************************************************************/

@SpringBootTest
public class FlatTests extends OnlineFlatRentalApplicationTests {

	@Autowired
	private IFlatService flatService;

	Flat flat1 = new Flat(199, 8888,
			new FlatAddress(1000, "gandhi-nagar", "Srikakulam", "Andhra Pradesh", 532284, "India"), "Yes");
	Flat flat2 = new Flat(299, 7777,
			new FlatAddress(1020, "gandhi-nagar", "Srikakulam", "Andhra Pradesh", 532284, "India"), "Yes");
	Flat flat3 = new Flat(399, 6666,
			new FlatAddress(1030, "gandhi-nagar", "Srikakulam", "Andhra Pradesh", 532284, "India"), "Yes");
	
	/**********************************************************************************************
	 * Method:         addFlatTest
     * Description:    To test the addFlat Method of FlatService class
     * Created By      Kiran kumar panda
     * Created Date    25-MARCH-2021                           
	 **********************************************************************************************/ 

	@Test
	public void addFlatTest() throws FlatNotFoundException {
		Flat flat = flatService.addFlat(flat1);
		assertEquals(flat1.getFlatId(), flat.getFlatId());
		flatService.deleteFlat(flat1);

	}
	
	/**********************************************************************************************
	 * Method:         updateFlatTest
     * Description:    To test the updateFlat Method of FlatService class
     * Created By      Kiran kumar panda
     * Created Date    25-MARCH-2021                           
	 **********************************************************************************************/ 

	@Test
	public void updateFlatTest() throws FlatNotFoundException {
		flatService.addFlat(flat1);
		Flat newFlat = new Flat(199, 8888,
				new FlatAddress(100, "gandhi-nagar", "Srikakulam", "Andhra Pradesh", 532284, "India"), "No");
		Flat updatesFlat = flatService.updateFlat(newFlat);
		assertEquals(updatesFlat.getAvailibilty(), newFlat.getAvailibilty());
		flatService.deleteFlat(flat1);
	}
	
	/**********************************************************************************************
	 * Method:         viewFlatTest
     * Description:    To test the viewFlatTest Method of FlatService class
     * Created By      Kiran kumar panda
     * Created Date    25-MARCH-2021                           
	 **********************************************************************************************/

	@Test
	public void viewFlatTest() throws FlatNotFoundException {
		flatService.addFlat(flat3);
		Flat flat = flatService.viewFlat(399);
		assertEquals(flat.toString(), flat3.toString());
		flatService.deleteFlat(flat3);
	}
	/**********************************************************************************************
	 * Method:         viewByCostAndAvailibalityTest
     * Description:    To test the viewByCostAndAvailibality Method of FlatService class
     * Created By      Kiran kumar panda
     * Created Date    25-MARCH-2021                           
	 **********************************************************************************************/

	@Test
	public void viewByCostAndAvailibalityTest() {
		flatService.addFlat(flat1);
		flatService.addFlat(flat2);
		flatService.addFlat(flat3);
		List<Flat> flatList = flatService.viewAllFlatByCost(6666, "Yes");
		assertEquals(flatList.size(), 1);
		flatService.deleteFlat(flat1);
		flatService.deleteFlat(flat2);
		flatService.deleteFlat(flat3);

	}
	
	/**********************************************************************************************
	 * Method:         deleteFlatTest
     * Description:    To test the deleteFlat Method of FlatService class
     * Created By      Kiran kumar panda
     * Created Date    25-MARCH-2021                           
	 **********************************************************************************************/

	@Test
	public void deleteFlatTest() {
		flatService.addFlat(flat1);
		Flat deletedFlat = flatService.deleteFlat(flat1);
		assertNotNull(deletedFlat);

	}

}