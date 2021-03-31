package com.cg.ofr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ofr.entities.Payment;
@Repository
public interface IPaymentRepository extends JpaRepository<Payment,Integer>{

}
