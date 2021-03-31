package com.cg.ofr.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.User;
import com.cg.ofr.exception.EmptyEntityListException;
import com.cg.ofr.exception.EntityCreationException;
import com.cg.ofr.exception.EntityDeletionException;
import com.cg.ofr.exception.EntityNotFoundException;
import com.cg.ofr.exception.EntityUpdationException;
import com.cg.ofr.repository.IUserRepository;

/************************************************************************************
 *          @author          B.Sai Kiran
 *          Description      It is a user service implementation class that defines the methods
 *                           mentioned in its interface.
  *         Version             1.0
  *         Created Date    23-MARCH-2021
 ************************************************************************************/
@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepository;

	/************************************************************************************
	 * Method:                          viewUser
     *Description:                      To display the user by Id (Primary key)
     *@param id:                        id of the user.
	 * @throws EntityNotFoundException 
	 * @returns User                  - if user with Id presents it returns user else throws UserNotFoundException
	 * @throws UserNotFoundException -  It is raised due to invalid  UserId 
                *Created By                                - B.Sai Kiran
                *Created Date                            - 23-MARCH-2021                           
	 
	 ************************************************************************************/
	@Override
	public User viewUser(int id) throws EntityNotFoundException {
		try {
			Optional<User> user = userRepository.findById(id);
			if (user.isPresent()) {
				return user.get();
			} else {
				throw new EntityNotFoundException("User is not found for Id " + id);
			}

		} catch (Exception e) {
			throw new EntityNotFoundException(e.getMessage());

		}

	}

	/************************************************************************************
	 * Method:                          viewAllUser
     *Description:                      To display all the users
	 * @throws EmptyEntityListException 
	 * @returns List<User>            - It returns all the users present in database
                *Created By                                - B.Sai Kiran
                *Created Date                            - 23-MARCH-2021                           
	 
	 ************************************************************************************/
	@Override
	public List<User> viewAllUser() {
		try {
			List<User> userList = userRepository.findAll();
			if (userList.isEmpty()) {
				throw new EmptyEntityListException(" No Users found");
			} else {
				return userList;
			}
		} catch (Exception e) {
			throw new EmptyEntityListException(e.getMessage());
		}

	}

	/************************************************************************************
	 * Method:                          validateUser
     *Description:                      It is used to verify username and password of user
     * @param username:                 username for validating user.
     *  @param password:                password for validating user.
	 * @throws EntityNotFoundException 
	 * @returns User                  - it returns user details if the details are correct else it throws UserNotFoundException
	 * @throws UserNotFoundException -  It is raised due to invalid username or password.
                *Created By                                - B.Sai Kiran
                *Created Date                            - 23-MARCH-2021                           
	 
	 ************************************************************************************/
	@Override
	public User validateUser(String username, String password) throws EntityNotFoundException {
		try {
			Optional<User> user = userRepository.findByuserName(username);
			if (user.isPresent()) {
				if (username.equals(user.get().getUserName()) && (password.equals(user.get().getPassword()))) {
					return user.get();
				} else {
					throw new EntityNotFoundException("Password does not match for " + username);
				}
			} else {
				throw new EntityNotFoundException("User is not there with username :" + username);
			}
		} catch (Exception e) {
			throw new EntityNotFoundException(e.getMessage());
		}
	}

	/************************************************************************************
	 * Method:                          addUser
     *Description:                      It is used to add user into user_details table
     * @param user:                     User's reference variable.
	 * @throws EntityCreationException 
	 * @returns User                    It returns user with details
                *Created By                                - B.Sai Kiran
                *Created Date                            - 23-MARCH-2021                           
	 
	 ************************************************************************************/
	@Override
	public User addUser(User user) {
		try {
			return userRepository.save(user);
		} catch (Exception e) {
			throw new EntityCreationException("Valid details of user are not entered");
		}
	}

	/************************************************************************************
	 * Method:                          updateUser
     *Description:                      It is used to update user details into user_details table.
     * @param user:                     User's reference variable.
	 * @throws EntityUpdationException 
	 * @returns User                    It returns updated details of the existed user.
                *Created By                                - B.Sai Kiran
                *Created Date                            - 23-MARCH-2021                           
	 
	 ************************************************************************************/
	@Override
	public User updateUser(User user) {
		try {
			Optional<User> user1 = userRepository.findById(user.getUserId());
			if (user1.isPresent()) {
				return userRepository.save(user);
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new EntityUpdationException("No updation found");
		}

	}

	/************************************************************************************
	 * Method:                          updatePassword
     *Description:                      It is used to update password
     *@param user:                      User's reference variable.
     *@param newpass:                   new password for user.
	 * @throws EntityNotFoundException 
	 * @throws UserNotFoundException 
	 * @returns User                    It returns updated details of the existed user.
                *Created By                                - B.Sai Kiran
                *Created Date                            - 23-MARCH-2021                           
	 
	 ************************************************************************************/
	@Override
	public User updatePassword(User user, String newpass) {
		try {
			Optional<User> checkuser = userRepository.findByuserName(user.getUserName());
			Optional<User> checkuser1 = Optional
					.of(validateUser(checkuser.get().getUserName(), checkuser.get().getPassword()));
			if (checkuser1.isPresent()) {
				user.setPassword(newpass);
				userRepository.save(user);
				return user;
			} else {
				throw new EntityNotFoundException("No user found");
			}

		} catch (Exception e) {
			throw new EntityNotFoundException(e.getMessage());
		}
	}

	/************************************************************************************
	 * Method:                          removeUser
     *Description:                      It is used to remove user
     *@param user:                      User's reference variable.
	 * @throws EntityDeletionException 
	 * @returns User                    It returns the user that has been deleted
	 * @throws UserNotFoundException:   It is raised due to invalid user.
                * Created By                                - B.Sai Kiran
                *Created Date                            - 23-MARCH-2021                           
	 
	 ************************************************************************************/
	@Override
	public User removeUser(User user) {
		try {
			Optional<User> deletedUser = userRepository.findById(user.getUserId());
			if (deletedUser.isPresent()) {
				userRepository.delete(user);
			}
			return deletedUser.get();
		} catch (Exception e) {
			throw new EntityDeletionException("Invalid user details");
		}

	}

}
