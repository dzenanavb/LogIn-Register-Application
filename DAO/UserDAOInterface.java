package DAO;

import java.sql.SQLException;

import DTO.User;

public interface UserDAOInterface {
	
	public void updateUser(User user) throws SQLException;
	
	public void addUser(User user) throws SQLException;
	
	public User findUserUsername(String username) throws SQLException;
}
