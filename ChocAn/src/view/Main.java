package view;

import java.util.Scanner;

import beans.*;
import controller.LoginCtrl;

public class Main {

	public static void main(String[] args) {
		
		LoginCtrl loginCtrl = new LoginCtrl();
		Login login = new Login();
		User user = null;
		Menu menu = new Menu();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println(" =============================== LOGIN =============================== ");

		System.out.printf("\n\t ID: ");
		login.setFkIdUser(Integer.valueOf(scan.nextLine()));
		
		System.out.printf("\t Password: ");
		login.setPassword(scan.nextLine());
		
		if(loginCtrl.verifyLogin(login.getFkIdUser(), login.getPassword()) == 1){
			user = loginCtrl.retrieveUserType(login);
			
			if(user instanceof Manager){
				menu.startMenuManager(user);
			}else if (user instanceof Member){
				System.out.println("It is a Member!");
			}else if (user instanceof Operator){
				menu.startMenuOperator(user);
			}else if (user instanceof Provider){
				System.out.println("It is a Provider!");
			}else {
				System.out.println("It is a not defined user!");
			}
		}else{
			System.err.println("\n\n\t The system did not find any user!");
		}

		scan.close();
		
	}

}
