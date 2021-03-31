package com.cg.ofr.service;

import java.util.List;

import com.cg.ofr.entities.User;
import com.cg.ofr.exception.EntityNotFoundException;

public interface IUserService {
	public User viewUser(int id) throws EntityNotFoundException;

	public List<User> viewAllUser();

	public User validateUser(String username, String password);

	public User addUser(User user);

	public User updateUser(User user);

	public User updatePassword(User user, String newpass);

	public User removeUser(User user);
}
