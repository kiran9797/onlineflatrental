package com.cg.ofr.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ofr.entities.User;
/************************************************************************************
 *          @author          B.Sai Kiran
 *          Description      It is a user repository interface that extends jpa repository 
 *                           that contains inbuilt methods for various operations
  *         Version             1.0
  *         Created Date    22-MARCH-2021
 ************************************************************************************/
@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

	/************************************************************************************
	 * Method:                          findByuserName
     *Description:                      It is used to search the User based on its username.
     * @param userName:                 user's name. 
                *Created By                                - B.Sai Kiran
                *Created Date                            - 23-MARCH-2021                           
	 
	 ************************************************************************************/
	public Optional<User> findByuserName(String userName);
}
