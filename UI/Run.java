package UI;

import java.sql.SQLException;
import java.util.Scanner;

public class Run {

	static Scanner unos = new Scanner(System.in);
	
	
	public static void printMenu() throws SQLException {
		System.out.println("Unesite 1 ako želite da se registrujete.");
		System.out.println("Unesite 2 ako želite da se loginujete.");
		int izbor = unos.nextInt();
		
		switch(izbor) {
		case 1:
			MenuRegisterUI.registerMenu();
			break;
		
		case 2: 
			do {
			MenuLoginUI.logIn();}
			while(true);
			
			
		default:
			System.out.println("Unesite 1 ili 2!");
			printMenu(); break;
		}
	}
}
