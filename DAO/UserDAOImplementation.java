package DAO;

import java.sql.*;
import DTO.User;

public class UserDAOImplementation implements UserDAOInterface{
	
	Connection connection = ConnectionManager.getInstance().getConnection();

	@Override
	public void updateUser(User user) throws SQLException {
			String query = "UPDATE user SET ime = ?, prezime = ?, username = ?, password = ? WHERE userID = ?";
			PreparedStatement statement = connection.prepareStatement(query);
				statement.setString(1, user.getIme());
				statement.setString(2, user.getPrezime());
				statement.setString(3, user.getUsername());
				statement.setString(4, user.getPassword());
				statement.setInt(5, user.getUserID());
				
				
				statement.executeUpdate();
				
				System.out.println("Racun je update- ovan!");
	}	

	@Override
	public void addUser(User user) throws SQLException {
		
		String query = "INSERT INTO user (ime, prezime, username, password) VALUES (?, ?, ?, ?)";
		
		try(PreparedStatement statement = connection.prepareStatement(query);){
			statement.setString(1, user.getIme());
			statement.setString(2, user.getPrezime());
			statement.setString(3, user.getUsername());
			statement.setString(4, user.getPassword());
			
			statement.executeUpdate();
			
			System.out.println("Registracija je uspjesna!");
		}
		
	}

	@Override
	public User findUserUsername(String username) throws SQLException {
		
		User user = null;
		
		String query = "SELECT * FROM user WHERE username = ?";
		
		ResultSet rs = null;
		
		try(PreparedStatement statement = connection.prepareStatement(query);){
			statement.setString(1, username);
			
			rs = statement.executeQuery();
			
			if(rs.next()) {
				user = new User(rs.getInt("userID"), 
						rs.getString("ime"), 
						rs.getString("prezime"),  
						rs.getString("username"), 
						rs.getString("password"));
				rs.close();
			}}
		
		return user;
	}
}