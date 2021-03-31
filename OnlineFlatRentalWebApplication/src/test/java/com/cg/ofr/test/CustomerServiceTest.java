package com.cg.ofr.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ofr.entities.User;
import com.cg.ofr.service.IUserService;

@SpringBootTest
class IUserServiceTest {

	@Autowired
	private IUserService iUserServiceImpl;

	@Test
	public void testViewUser1()  {
		User user = new User(8, "suresh", "1237890", "Landlord");
		iUserServiceImpl.addUser(user);
		assertEquals("suresh", iUserServiceImpl.viewUser(8).getUserName());
	}

	@Test
	public void testViewUser2()  {
		User user = new User(9, "rajesh", "1237867", "Tenant");
		iUserServiceImpl.addUser(user);
		assertEquals("rajesh", iUserServiceImpl.viewUser(9).getUserName());
	}

	@Test
	public void testViewAllUser1() {
		assertEquals("kiran", iUserServiceImpl.viewAllUser().get(0).getUserName());
	}

	@Test
	public void testViewAllUser2() {
		assertEquals("sai", iUserServiceImpl.viewAllUser().get(1).getUserName());
	}

	@Test
	public void testUpdateUser1() {
		User user = new User(9, "rajesh", "1237867", "Tenant");
		iUserServiceImpl.addUser(user);
		user.setUserName("rakesh");
		iUserServiceImpl.updateUser(user);
		assertEquals("rakesh", iUserServiceImpl.viewUser(9).getUserName());
	}

	@Test
	public void testUpdateUser2() {
		User user = new User(8, "suresh", "1237890", "Landlord");
		iUserServiceImpl.addUser(user);
		user.setUserName("raghava");
		user.setUserType("Tenant");
		iUserServiceImpl.updateUser(user);
		assertEquals("Tenant", iUserServiceImpl.viewUser(8).getUserType());
	}

	@Test
	public void testUpdatePassword1() {
		User user = new User(3, "anil", "123456", "Landlord");
		iUserServiceImpl.updatePassword(user, "111");
		assertEquals("111", iUserServiceImpl.viewUser(3).getPassword());
	}

	@Test
	public void testUpdatePassword2() {
		User user = new User(4, "kumar", "123", "Tenant");
		iUserServiceImpl.updatePassword(user, "555");
		assertEquals("555", iUserServiceImpl.viewUser(4).getPassword());
	}

	@Test
	public void testValidateUser1() {
		User user = new User(3, "anil", "123456", "Landlord");
		iUserServiceImpl.addUser(user);
		User checkUser = iUserServiceImpl.validateUser(user.getUserName(), user.getPassword());
		assertEquals(user.toString(), checkUser.toString());
	}

	@Test
	public void testAddUser1() {
		User user = new User(3, "anil", "123456", "Landlord");
		iUserServiceImpl.addUser(user);
		assertEquals("anil", iUserServiceImpl.viewUser(3).getUserName());
	}

	@Test
	public void testAddUser2() {
		User user = new User(4, "kumar", "123", "Tenant");
		iUserServiceImpl.addUser(user);
		assertEquals("123", iUserServiceImpl.viewUser(4).getPassword());
	}

	@Test
	public void testRemoveUser1() {
		User user = new User(5, "ashok", "12378", "Tenant");
		iUserServiceImpl.addUser(user);
		User deletedUser = iUserServiceImpl.removeUser(user);
		assertEquals("ashok", deletedUser.getUserName());
	}

	@Test
	public void testRemoveUser2() {
		User user = new User(6, "ramesh", "123789", "Landlord");
		iUserServiceImpl.addUser(user);
		User deletedUser = iUserServiceImpl.removeUser(user);
		assertEquals(6, deletedUser.getUserId());
	}
}
