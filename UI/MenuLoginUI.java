package UI;

import java.sql.SQLException;
import java.util.Scanner;

import DAO.UserDAOImplementation;
import DTO.User;

public class MenuLoginUI {
	static User user = null;
	
	static Scanner unos = new Scanner(System.in);
	
	public static void logIn() throws SQLException {
		
		System.out.println("Unesite username: ");
		String username = unos.next();
		
		System.out.println("Unesite password: ");
		String password = unos.next();
		
		UserDAOImplementation login = new UserDAOImplementation();
		
		user = login.findUserUsername(username);
		if(user.getPassword().equals(password))
			{System.out.println("LogIn- ovali ste se!");
			
			System.out.println("Unesite 1 da se Log Out.");
			System.out.println("Unesite 2 da promijenite ime.");
			System.out.println("Unesite 3 da promijenite prezime.");
			
			int izbor = unos.nextInt();
			
			switch(izbor) {
			
			case 1: Run.printMenu(); break;
			
			case 2: 
				user = login.findUserUsername(username);
				System.out.println("Unesite novo ime: ");
				unos.nextLine();
				String novoIme = unos.nextLine();
				user.setIme(novoIme);
				UserDAOImplementation promjenaImena = new UserDAOImplementation();
				promjenaImena.updateUser(user);
				break;
				
			case 3: 
				user = login.findUserUsername(username);
				System.out.println("Unesite novo prezime: ");
				unos.nextLine();
				String novoPrezime = unos.nextLine();
				user.setPrezime(novoPrezime);
				UserDAOImplementation promjenaPrezimena = new UserDAOImplementation();
				promjenaPrezimena.updateUser(user);
				break;
				
			default:
				System.out.println("Unesite broj izmedu 1 i 3!");}}
			
		else 
			{System.out.println("Unijeli ste pogresan username ili password!");}
				
}}