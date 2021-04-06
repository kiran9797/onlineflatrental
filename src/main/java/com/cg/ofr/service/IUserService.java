package com.cg.ofr.service;

import java.util.List;


import com.cg.ofr.entities.User;
import com.cg.ofr.exception.UserNotFoundException;
/**
 * This is an interface for User service with methods of
 * add,update,delete,get and getall Users
 * 
 * @author B.Saikiran * 
 **/

public interface IUserService {
	public User viewUser(int id) throws UserNotFoundException;

	public List<User> viewAllUser();

	public User validateUser(String username, String password) throws UserNotFoundException;

	public User addUser(User user);

	public User updateUser(User user);

	public User updatePassword(User user, String newpass) throws UserNotFoundException;

	public User removeUser(User user);
}
