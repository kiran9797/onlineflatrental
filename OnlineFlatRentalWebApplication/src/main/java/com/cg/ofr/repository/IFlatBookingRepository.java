package com.cg.ofr.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ofr.entities.FlatBooking;



@Repository
public interface IFlatBookingRepository extends JpaRepository<FlatBooking, Integer> {


}
