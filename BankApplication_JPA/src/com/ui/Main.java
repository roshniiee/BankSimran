package com.ui;

import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		int ch;
		char choice;
		User user = new User();
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.println("\n *********************\n 1. Create Account \n 2. Show Balance \n 3. Deposit \n"
					+ " 4. Withdraw \n 5. Fund Transfer \n 6. Print Transactions \n 7. Exit\n*********************");
			System.out.print("Enter your choice : ");
			ch = scan.nextInt();
			switch(ch) {
			case 1:
				user.createAccount();
				break;
			case 2:
				user.showBalance();
				break;
			case 3:
				user.deposit();
				break;
			case 4:
				user.withdraw();
				break;
			case 5:
				user.fundTransfer();
				break;
			case 6:
				user.printTransactions();
				break;
			case 7:
				System.exit(0);
			}
			System.out.print("Do you want to continue (y/n)...? : ");
			choice = scan.next().charAt(0);
			if(choice == 'y' || choice=='Y')
				continue;
			else {
				System.out.println("Thank You !");
				System.exit(0);
			}
		} while(ch != 7 );
		scan.close();
	}
}