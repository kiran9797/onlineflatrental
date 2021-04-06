package com.cg.ofr.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.ofr.entities.Flat;

/****************************************************************************************
 *  @author          Kiran kumar panda
 *  Description      It is a user repository interface that extends jpa repository 
                     that contains inbuilt methods for various operations
 *  Version          1.0
 *  Created Date     23-MARCH-2021
 ****************************************************************************************/


@Repository
public interface IFlatRepository extends JpaRepository<Flat, Integer> {
	
/*********************************************************************************************
* Method:                          	viewAllFlatByCostAndAvailability
*Description:                    	It is used to find the flat based on cost and availability
* @param cost:                 		cost of the flat 
* @param availability:             	availability of the flat (Yes/No)
*Created By                       	- Kiran kumar panda
*Created Date                     	- 23-MARCH-2021                           
	 
 **********************************************************************************************/
	@Query("select f from Flat f where f.cost=?1 and f.availibilty = ?2")
	public List<Flat> viewAllFlatByCostAndAvailability(float cost, String availability);
}
