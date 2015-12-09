package view;

import java.util.Scanner;

public class Menu {
	
	Scanner sc ;
	
	public Menu() {
		sc = new Scanner (System.in);
	}
	
	public String InputLogin() {
		String in = "";
		boolean notValid = true;
		
		System.out.print("\t Login: ");
		while(notValid) {
			in = sc.nextLine();
			if(isNumeric(in) || !in.equals("")) {
				notValid = false;
			} else System.out.print("\t Invalid login. Re-enter: ");
		}
		return in; // return the input id -- WHAT TO DO NOW?
	}
	
	public String InputPassword() {
		String in = "";
		System.out.print("\t Password: ");
		in = sc.nextLine();
		return in; // return the input password -- WHAT TO DO NOW?
	}
	
	public void startMenuOperator() {
		System.out.println("\n\t Operator: " + " === NAME === ");
		System.out.println("\n\t Choose the type of user you want to operate: ");
		System.out.println("\t 1. Member"
					   + "\n\t 2. Provider"
					   + "\n\t 3. Logoff\n");
		printMenuOperator();
	}
	
	public void printMenuOperator() {
		String in = "";
		String option = "";
		int inInt = 0;
		boolean notValid = true;
		
		System.out.print("\t Option: ");
		while(notValid) {
			in = sc.nextLine();
			if(isNumeric(in) && (in.equals("1") || in.equals("2") || in.equals("3"))) {
				notValid = false;
			} else
				System.out.print("\t Invalid option. Re-enter: ");
		}
		
		inInt = Integer.valueOf(in);
		if(inInt == 1)
			option = "member";
		else if(inInt == 2)
			option = "provider";
		else if(inInt == 3) {
			System.out.println("\n\t Good bye!."); // fix this. It should return to Login screen
			return;
		}
			
		System.out.println("\n\t Choose the type of operation: ");
		System.out.println("\t 1. Add " + option
				       + "\n\t 2. Update " + option
				       + "\n\t 3. Delete " + option
				       + "\n\t 4. Back\n");
		
		notValid = true;
		System.out.print("\t Option: ");
		while(notValid) {
			in = sc.nextLine();
			if(isNumeric(in) && (in.equals("1") || in.equals("2") || in.equals("3") || in.equals("4"))) {
				notValid = false;
			} else
				System.out.print("\t Invalid option. Re-enter: ");
		}
		
		inInt = Integer.valueOf(in);
		if(inInt == 1)
			openMenuAdd(option);
		else if(inInt == 2)
			openMenuUpdate(option);
		else if(inInt == 3)
			openMenuDelete(option);
		else if(inInt == 4)
			startMenuOperator();
			
	}	
	
	public void openMenuAdd(String user) {
		System.out.println("\n\t Operation: Add " + user);
		System.out.print("\t First name    : ");
		System.out.print("\t Last name     : ");
		System.out.print("\t Email         : ");
		System.out.print("\t Cell phone    : ");
		System.out.print("\t Home phone    : ");
		System.out.print("\t Work phone    : ");
		System.out.print("\t Address       : ");
		System.out.print("\t Address line 2: ");
		System.out.print("\t City          : ");
		System.out.print("\t State         : ");
		System.out.print("\t Zip code      : ");
		System.out.print("\n\t Do you want to add this " + user + "? (Y/N) ");
	}
	
	public void openMenuUpdate(String user) {
		String in = "";
		boolean notValid = true;
		
		System.out.println("\n\t Operation: Update " + user);
		System.out.print("\t Enter the ID: ");
		while(notValid) {
			in = sc.nextLine();
			if(isNumeric(in)) { // valid ID
				notValid = false;
			} else
				System.out.print("\t Invalid ID. Re-enter: ");
		}
		System.out.print("\t First name    : "); // show the data of the user
		System.out.print("\t Last name     : ");
		System.out.print("\t Email         : ");
		System.out.print("\t Cell phone    : ");
		System.out.print("\t Home phone    : ");
		System.out.print("\t Work phone    : ");
		System.out.print("\t Address       : ");
		System.out.print("\t Address line 2: ");
		System.out.print("\t City          : ");
		System.out.print("\t State         : ");
		System.out.print("\t Zip code      : ");
		
		System.out.print("\t First name    : "); // fields to update data
		System.out.print("\t Last name     : ");
		System.out.print("\t Email         : ");
		System.out.print("\t Cell phone    : ");
		System.out.print("\t Home phone    : ");
		System.out.print("\t Work phone    : ");
		System.out.print("\t Address       : ");
		System.out.print("\t Address line 2: ");
		System.out.print("\t City          : ");
		System.out.print("\t State         : ");
		System.out.print("\t Zip code      : ");
		System.out.print("\n\t Do you want to update this " + user + "? (Y/N) ");
	}
	
	public void openMenuDelete(String user) {
		String in = "";
		boolean notValid = true;
		
		System.out.println("\n\t Operation: Delete " + user);
		System.out.print("\t Enter the ID: ");
		while(notValid) {
			in = sc.nextLine();
			if(isNumeric(in)) { // valid ID
				notValid = false;
			} else
				System.out.print("\t Invalid ID. Re-enter: ");
		}
		System.out.print("\t First name    : ");
		System.out.print("\t Last name     : ");
		System.out.print("\t Email         : ");
		System.out.print("\t Cell phone    : ");
		System.out.print("\t Home phone    : ");
		System.out.print("\t Work phone    : ");
		System.out.print("\t Address       : ");
		System.out.print("\t Address line 2: ");
		System.out.print("\t City          : ");
		System.out.print("\t State         : ");
		System.out.print("\t Zip code      : ");
		System.out.print("\n\t Do you want to delete this " + user + "? (Y/N) ");
	}
	
	public void startMenuManager() {
		System.out.println("\n\t Manager: " + " === NAME === ");
		System.out.print("\n\t Do you want to visualize the weekly report? (Y/N) ");
		// shows the weekly report		
	}
	
	public void validInput() {
		String in = "";
		in = sc.nextLine();
		while(in.equals(""))
			in = sc.nextLine();
	}
	
	public static boolean isNumeric(String str) { // verifies the input  
		try {  
			Integer.parseInt(str);
		} catch(NumberFormatException nfe) {  
			return false;  
		}  
		return true;  
	}
}
