package UI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import DAO.ConnectionManager;
import DAO.UserDAOImplementation;
import DTO.User;

public class MenuRegisterUI {
	static Scanner unos = new Scanner (System.in);
	
	static Connection connection = ConnectionManager.getInstance().getConnection();
	
	public static void registerMenu() throws SQLException {
		String password = null;
		String username = null;
		
		System.out.println("Unesite ime: ");
		String ime = unos.nextLine();
		
		System.out.println("Unesite prezime: ");
		String prezime = unos.nextLine();
		
		System.out.println("Unesite username: ");
		username = unos.next();
		
		System.out.println("Unesite password: ");
		password = unos.next();
		
		Statement provjera = connection.createStatement();
		
		boolean postoji;
		
		String sql = "SELECT * FROM user WHERE username='"+ username +"'";
		
		ResultSet rs = provjera.executeQuery(sql);
		
		if(rs.next())
			{postoji = true;}
		
		else {postoji = false;}
		
		if(password.length() < 6 || postoji == true)
		{System.out.println("Registracija nije bila uspjesna, password ne smije biti kraci od 6 karaktera ili username vec postoji!");}
		
		else
		{User user = new User(ime, prezime, username, password);
		UserDAOImplementation registracija = new UserDAOImplementation();
		registracija.addUser(user);}}
	
	
}