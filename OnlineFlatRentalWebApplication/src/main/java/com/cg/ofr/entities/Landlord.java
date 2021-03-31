package com.cg.ofr.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

/************************************************************************************
 *         @author          Y.Manideep
 *         Description      It is a entity class that provides the details of the User  
 *         Version          1.0
 *         Created Date     22-MARCH-2021
 ************************************************************************************/
@Entity
public class Landlord {

	@Id
	private int landlordId;
	private String landlordName;
	private int landlordAge;
	@Autowired
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "land_lord_ID")
	private List<Flat> flatList;
	
	/************************************************************************************
	 * Method:                          Landlord
     *Description:                      It is used to initialize the empty constructor.
     *Created By                        Y.Manideep
     *Created Date                      22-MARCH-2021                           
	 
	 ************************************************************************************/
	public Landlord() {
		
	}
	
	/************************************************************************************
	 * Method:                          Landlord
     *Description:                      It is used to initialize the parameterized constructor.
     *@param landlordId:                landlord's Id. 
     *@param landlordName:              landlord's Name. 
     *@param landlordAge:               landlord's Age. 
     *@param flatList:                  flat List. 
     *Created By                        Y.Manideep
     *Created Date                      22-MARCH-2021                           
	 
	 ************************************************************************************/

	public Landlord(int landlordId, String landlordName, int landlordAge, List<Flat> flatList) {
		super();
		this.landlordId = landlordId;
		this.landlordName = landlordName;
		this.landlordAge = landlordAge;
		this.flatList = flatList;
	}
	
	/************************************************************************************
	 * Method:                          getLandlordId
     *Description:                      It is used to get the Landlord Id by getter method.
     *returns Integer:                  It returns landlord Id.
     *Created By                        Y.Manideep
     *Created Date                      22-MARCH-2021                           
	 
	 ************************************************************************************/

	public int getLandlordId() {
		return landlordId;
	}
	
	/************************************************************************************
	 * Method:                          setLandlordId
     *Description:                      It is used to set the Landlord Id by setter method.
     * @param LandlordId:               landlord's Id. 
     *Created By                        Y.Manideep
     *Created Date                      22-MARCH-2021                           
	 
	 ************************************************************************************/
	public void setLandlordId(int landlordId) {
		this.landlordId = landlordId;
	}
	
	/************************************************************************************
	 * Method:                          getLandlordName
     *Description:                      It is used to get the Landlord Name by getter method.
     *returns String:                   It returns landlord Name.
     *Created By                        Y.Manideep
     *Created Date                      22-MARCH-2021                           
	 
	 ************************************************************************************/
	public String getLandlordName() {
		return landlordName;
	}
	
	/************************************************************************************
	 * Method:                          setLandlordName
     *Description:                      It is used to set the Landlord Name by setter method.
     * @param LandlordName:             landlord's Name
     *Created By                        Y.Manideep
     *Created Date                      22-MARCH-2021                           
	 
	 ************************************************************************************/
	public void setLandlordName(String landlordName) {
		this.landlordName = landlordName;
	}
	
	/************************************************************************************
	 * Method:                          getLandlordAge
     *Description:                      It is used to set the Landlord Age by setter method.
     *returns String:                   It returns landlord Age.
     *Created By                        Y.Manideep
     *Created Date                      22-MARCH-2021                           
	 
	 ************************************************************************************/
	public int getLandlordAge() {
		return landlordAge;
	}
	
	/************************************************************************************
	 * Method:                          setLandlordAge
     *Description:                      It is used to set the Landlord Age by setter method.
     * @param landlordAge:              landlord's Age. 
     *Created By                        Y.Manideep
     *Created Date                      22-MARCH-2021                           
	 
	 ************************************************************************************/
	public void setLandlordAge(int landlordAge) {
		this.landlordAge = landlordAge;
	}
	
	/************************************************************************************
	 * Method:                          getFlatList
     *Description:                      It is used to get the Flat List by setter method.
     *returns String:                   It returns FlatList.
     *Created By                        Y.Manideep
     *Created Date                      22-MARCH-2021                           
	 
	 ************************************************************************************/
	public List<Flat> getFlatList() {
		return flatList;
	}
	
	/************************************************************************************
	 * Method:                          setLandlordAge
     *Description:                      It is used to set the Flat List by setter method.
     * @param Flatlist:                 Flat List. 
     *Created By                        Y.Manideep
     *Created Date                      22-MARCH-2021                           
	 
	 ************************************************************************************/
	public void setFlatList(List<Flat> flatList) {
		this.flatList = flatList;
	}

	@Override
	public String toString() {
		return "Landlord [landlordId=" + landlordId + ", landlordName=" + landlordName + ", landlordAge=" + landlordAge
				+ ", flatList=" + flatList + "]";
	}

}
