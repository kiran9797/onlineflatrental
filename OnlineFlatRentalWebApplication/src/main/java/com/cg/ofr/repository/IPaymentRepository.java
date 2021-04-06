package com.cg.ofr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ofr.entities.Payment;


/****************************
 *  @author          Nishitha.
 *  Description      It is a payment repository interface that extends jpa repository 
                     that contains inbuilt methods for various operations
 *  Version          1.0
 *  Created Date     23-MARCH-2021
 ****************************/
@Repository
public interface IPaymentRepository extends JpaRepository<Payment,Integer>{

}