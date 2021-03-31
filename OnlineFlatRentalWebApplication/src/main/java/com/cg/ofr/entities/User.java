package com.cg.ofr.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/************************************************************************************
 *          @author          B.Sai Kiran
 *          Description      It is a entity class that provides the details of the User  
  *         Version             1.0
  *         Created Date    22-MARCH-2021
 ************************************************************************************/

@Entity
@Table(name = "userDetails")
public class User {

	@Id
	private int userId;
	private String userName;
	private String password;
	private String userType;
	
	/************************************************************************************
	 * Method:                          User
     *Description:                      It is used to initialize the empty constructor.
                *Created By                                - B.Sai Kiran
                *Created Date                            - 22-MARCH-2021                           
	 
	 ************************************************************************************/
	public User() {
		
	}

	/************************************************************************************
	 * Method:                          User
     *Description:                      It is used to initialize the parameterized constructor.
     *@param userId:                    user's Id. 
     *@param userName:                  user's Name. 
     *@param password:                  user's Password. 
     *@param userType:                  user's Type. 
                *Created By                                - B.Sai Kiran
                *Created Date                            - 22-MARCH-2021                           
	 
	 ************************************************************************************/
	public User(int userId, String userName, String password, String userType) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userType = userType;
	}

	/************************************************************************************
	 * Method:                          getUserId
     *Description:                      It is used to get the user Id by getter method.
     *returns Integer:                  It returns user Id.
                *Created By                                - B.Sai Kiran
                *Created Date                            - 22-MARCH-2021                           
	 
	 ************************************************************************************/
	public int getUserId() {
		return userId;
	}

	/************************************************************************************
	 * Method:                          setUserId
     *Description:                      It is used to set the user Id by setter method.
     * @param userId:                   user's Id. 
                *Created By                                - B.Sai Kiran
                *Created Date                            - 22-MARCH-2021                           
	 
	 ************************************************************************************/
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/************************************************************************************
	 * Method:                          getUserName
     *Description:                      It is used to get the user Name by getter method.
     *returns String:                   It returns user Name.
                *Created By                                - B.Sai Kiran
                *Created Date                            - 22-MARCH-2021                           
	 
	 ************************************************************************************/
	public String getUserName() {
		return userName;
	}

	/************************************************************************************
	 * Method:                          setUserName
     *Description:                      It is used to set the user Name by setter method.
     * @param userName:                 user's Name. 
                *Created By                                - B.Sai Kiran
                *Created Date                            - 22-MARCH-2021                           
	 
	 ************************************************************************************/
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/************************************************************************************
	 * Method:                          getPassword
     *Description:                      It is used to get the user Password by getter method.
     *returns String:                   It returns user password.
                *Created By                                - B.Sai Kiran
                *Created Date                            - 22-MARCH-2021                           
	 
	 ************************************************************************************/
	public String getPassword() {
		return password;
	}


	/************************************************************************************
	 * Method:                          setPassword
     *Description:                      It is used to set the user password by setter method.
     * @param Password:                 user's Password. 
                *Created By                                - B.Sai Kiran
                *Created Date                            - 22-MARCH-2021                           
	 
	 ************************************************************************************/
	public void setPassword(String password) {
		this.password = password;
	}

	/************************************************************************************
	 * Method:                          getUserType
     *Description:                      It is used to get the user Type by getter method.
     *returns String:                   It returns user Type.
                *Created By                                - B.Sai Kiran
                *Created Date                            - 22-MARCH-2021                           
	 
	 ************************************************************************************/
	public String getUserType() {
		return userType;
	}

	/************************************************************************************
	 * Method:                          setUserType
     *Description:                      It is used to set the user Type by setter method.
     * @param userType:                 user's Type. 
                *Created By                                - B.Sai Kiran
                *Created Date                            - 22-MARCH-2021                           
	 
	 ************************************************************************************/
	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userType=" + userType
				+ "]";
	}

	
}
