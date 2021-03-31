package com.cg.ofr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ofr.entities.Landlord;

/************************************************************************************
 *  @author          Y.Manideep
 *  Description      It is a user repository interface that extends jpa repository 
                     that contains inbuilt methods for various operations
 *  Version          1.0
 *  Created Date     22-MARCH-2021
 ************************************************************************************/
@Repository
public interface ILandlordRepository extends JpaRepository<Landlord, Integer> {

}
