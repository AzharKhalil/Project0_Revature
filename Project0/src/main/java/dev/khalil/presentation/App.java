package dev.khalil.presentation;

import java.util.List;
import java.util.Scanner;

import dev.khalil.entities.Admin;
import dev.khalil.entities.BankAccount;
import dev.khalil.entities.User;
import dev.khalil.exceptions.NotValidCharacter;
import dev.khalil.exceptions.TooShortException;
import dev.khalil.exceptions.UNAPValidaor;
import dev.khalil.exceptions.UserAlreadyExists;
import dev.khalil.services.AdminServicesImpl;
import dev.khalil.services.BankServices;
import dev.khalil.services.EmployeeServices;
import dev.khalil.services.EmployeeServicesImpl;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		EmployeeServices eserv = new EmployeeServicesImpl();
		AdminServicesImpl aserv = new AdminServicesImpl();
		BankServices bserv = new BankServices();
		UNAPValidaor unapv = new UNAPValidaor();

		int logInChoice;
		User logedInUser = null;
		Admin logedInAdmin = null;
		boolean isLogedinUser;
		boolean isLogedinAdmin;
		System.out.println("Welcome to Bank Employee Management!!!");
		while (true) {
			System.out.println("");
			System.out.println("");
			System.out.println("|      MENU SELECTION     |");
			System.out.println("|          Options:       |");
			System.out.println("|        1. Sign Up       |");
			System.out.println("|        2. Sign In       |");
			System.out.println("|        3. Exit          |");
			System.out.println("");
			System.out.println("        Select Option");
			logInChoice = scan.nextInt();
			isLogedinUser = false;
			isLogedinAdmin = false;
			switch (logInChoice) {

			case 1: {
				System.out.println("");
				System.out.println("");
				System.out.println("----------------------------------------------------------");
				System.out.println("                         Sign Up                      ");
				System.out.println("1: Admin");
				System.out.println("2: User");
				int choice;
				choice = scan.nextInt();
				switch (choice) {
				case 1: {
					System.out.print("Enter your Name: ");
					String adminName;
					adminName = scan.next();
					System.out.println("Enter Your User Name: ");
					System.out.println("(* Shouldn't have space)");
					String adminUserName = scan.next();
					try {

						unapv.validUN(adminUserName);
						unapv.adminUserNameAvailable(adminUserName);
					} catch (NotValidCharacter e) {
						System.out.println("User Name " + e.getMessage());
						break;
					} catch (UserAlreadyExists e) {
						System.out.println(e.getMessage());
						break;
					}

					System.out.println("Enter Your Password: ");
					System.out.println("(* Shouldn't have space)");
					System.out.println("(* At Least 8 characters)");
					String adminPassword = scan.next();
					try {
						unapv.validPass(adminPassword);

						boolean result = aserv.signUp(adminName, adminUserName, adminPassword);
						if (result) {
							System.out.println("Sucessfuly registered as admin");
						} else {
							System.out.println("Not Registered! Try Again");
						}

					} catch (TooShortException e) {
						System.out.println("Password Too Short!");
						System.out.println(e.getMessage() + " your password was " + e.length + " character long");
						break;
					} catch (NotValidCharacter e) {
						System.out.println("Password can't contain space! ");
					}
					break;
				}
				case 2: {

					System.out.print("Enter Your Full Name: ");
					String name = scan.next();
					System.out.println("Enter Your User Name: ");
					System.out.println("(* Shouldn't have space)");
					String userName = scan.next();
					try {

						unapv.userUserNameAailable(userName);
						unapv.validUN(userName);
					} catch (NotValidCharacter e) {
						System.out.println("User Name " + e.getMessage());
					} catch (UserAlreadyExists e) {
						System.out.println(e.getMessage());
						break;
					}

					System.out.println("Enter a Password: ");
					System.out.println("(* Shouldn't have space)");
					System.out.println("(* At Least 8 characters)");
					String password;
					password = scan.next();
					//

					try {
						unapv.validPass(password);

						boolean result = eserv.signUp(name, userName, password);
						if (result) {
							System.out.println("Successfuly Registered!");
						} else {
							System.out.println("Sorry. Try Again!");
						}

					} catch (TooShortException e) {
						System.out.println("Password Too Short!");
						System.out.println(e.getMessage() + " your password was " + e.length + " character long");

					} catch (NotValidCharacter e) {
						System.out.println("Password " + e.getMessage());
					}

					//

					System.out.println("---------------------------------------------------------");
					System.out.println("");
					System.out.println("");
					System.out.println("");

					break;
				}
				default: {
					System.out.println("Invalid Choice");
				}

				}

				break;

			}

			case 2: {
				System.out.println("");
				System.out.println("");
				System.out.println("                         Sign In                      ");
				System.out.println("1: Admin");
				System.out.println("2: User");
				int choice1;
				choice1 = scan.nextInt();

				switch (choice1) {
				case 1: {

					System.out.print("Enter Your Username:");
					String userName = scan.next();
					System.out.print("Enter your Password:");
					String password = scan.next();
					logedInAdmin = aserv.signIn(userName, password);
					System.out.println("Welcome " + logedInAdmin.getName());
					isLogedinAdmin = true;
					break;
				}

				case 2: {
					System.out.print("Enter Your User Name: ");
					String name = scan.next();
					System.out.print("Enter Your Password: ");
					String password = scan.next();
					logedInUser = eserv.signIn(name, password);
					System.out.println("Welcome! " + logedInUser.getName());
					isLogedinUser = true;
					break;
				}

				default: {
					System.out.println("Invalid Choice");
				}

				}
				break;
			}
			case 3: {
				System.out.println("Good Bye! Hope to see you again");
				System.exit(0);
				break;
			}

			default: {
				System.out.println("Invalid Choice");
			}

			}

			if (isLogedinUser) {
				while (true) {
					System.out.println("");
					System.out.println("");
					System.out.println("            User MENU              ");
					System.out.println("             Options:              ");
					System.out.println("1. Create A Bank Account      ");
					System.out.println("2. Already Have An Account    ");
					System.out.println("3. Logout                     ");
					int choice;
					choice = scan.nextInt();

					switch (choice) {
					case 1: {
						System.out.print("How much balance you want to open account with: ");
						float balance;
						balance = scan.nextFloat();

						try {
							unapv.validBalance(balance);
						} catch (NotValidCharacter e) {
							System.out.println("Balance Can't be Negative!");
							break;
						}

						System.out.print("Select a 4 Digit PIN: ");
						int pin;
						pin = scan.nextInt();
						try {
							unapv.validPin(pin);
						} catch (TooShortException e) {
							System.out.println("PIN should be of 4 of digits Your PIN was " + e.length + " Long");
							break;
						}

						int id = logedInUser.getUserID();
						boolean response = bserv.createAccont(balance, pin, id);
						if (response) {
							System.out.println("Account Created Successfly");
						} else {
							System.out.println("Could not Create Account.Try Again!");
						}

						break;
					}

					case 2: {
						System.out.println("1: View Accounts And Balance");
						System.out.println("2: Deposit");
						System.out.println("3: Withdraw");
						System.out.println("4: Delete Account");
						int decision = scan.nextInt();
						switch (decision) {

						case 1: {

							int id = logedInUser.getUserID();

							List<BankAccount> ba = bserv.getAccountsbyId(id);
							for (BankAccount ba1 : ba) {
								System.out.println(ba1);

							}
							break;

						}

						case 2: {

							System.out.print("Enter Account Number");
							int accNum = scan.nextInt();
							System.out.print("Enter PIN:");
							int pin = scan.nextInt();
							int userId = logedInUser.getUserID();

							BankAccount ba = bserv.validateInformation(accNum, pin, userId);
							if (ba != null) {
								System.out.println("Your Current Balance is: " + ba.getBalance());

								System.out.print("Enter Amount to Deposit: ");
								float amnt = scan.nextFloat();
								boolean tf = bserv.deposit(ba, amnt);

								double balance = ba.getBalance() + amnt;
								long round = Math.round(balance);

								if (tf) {
									System.out.println("Deposited into Account Number: " + ba.getBankId());
									System.out.println("Your new Balance is: " + (round - amnt));
								} else {
									System.out.println("Sorry! Could not be Deposited. Try Again!");
								}

							} else {
								System.out.println("Invalid Information!");
							}

							break;

						}

						case 3: {

							System.out.print("Enter Account Number");
							int accNum = scan.nextInt();
							System.out.print("Enter PIN:");
							int pin = scan.nextInt();
							int userId = logedInUser.getUserID();

							BankAccount ba = bserv.validateInformation(accNum, pin, userId);

							if (ba != null) {
								System.out.println("Your Current Balance is: " + ba.getBalance());
								System.out.print("Enter Amount to Withdraw: ");
								float amnt = scan.nextFloat();
								if (amnt <= ba.getBalance()) {

									boolean rslt = bserv.withdraw(ba, amnt);
									if (rslt) {
										System.out.println("WithDraw Successfuly!");
										System.out.println("Your new Balance is: " + ba.getBalance());
									}
								} else {
									System.out.println("Sorry!You don't have enough money!");
								}

							}

							break;

						}

						case 4: {
							System.out.println("Enter Account Number: ");
							int accNum = scan.nextInt();
							System.out.println("Enter Pin Number: ");
							int pin = scan.nextInt();

							int id = logedInUser.getUserID();
							BankAccount ba = bserv.validateInformation(accNum, pin, id);
							if (ba.getBalance() == 0) {

								boolean rslt = bserv.deleteAccount(accNum);
								if (rslt) {
									System.out.println("Account Deleted!");
								} else {
									System.out.println("Sorry! Try Again");
								}

							} else {

								System.out.println("Yo have $" + ba.getBalance() + " in your Account");
								System.out.println("Please withdraw remaning balance before deleting!");

							}
							break;

						}

						}

						break;

					}

					case 3: {
						System.out.println("Signed Out!");
						System.exit(0);
					}

					default: {
						System.out.println("Invalid Choice");
					}

					}
				}

			}

			if (isLogedinAdmin) {
				while (true) {

					System.out.println("");
					System.out.println("");
					System.out.println("         ADMIN MENU         ");
					System.out.println("          Options:          ");
					System.out.println("     1. View All Users      ");
					System.out.println("     2. Create New User     ");
					System.out.println("     3. Delete User         ");
					System.out.println("     4. Update User Record  ");
					System.out.println("     5. Logout              ");
					System.out.println("");
					System.out.println("       Select Option");
					int choice;
					choice = scan.nextInt();

					switch (choice) {

					case 1: {

						for (User user : eserv.getAllUsers()) {
							System.out.println(user);
						}
						break;

					}

					case 2: {
						System.out.print("Enter User Full Name: ");
						String name = scan.next();
						System.out.print("Enter User UserName: ");
						String userName = scan.next();
						// Test

						try {

							unapv.userUserNameAailable(userName);
							unapv.validUN(userName);
						} catch (NotValidCharacter e) {
							System.out.println("User Name " + e.getMessage());
						} catch (UserAlreadyExists e) {
							System.out.println(e.getMessage());
							break;
						}

						// Test
						System.out.print("Enter User Password: ");
						String password;
						password = scan.next();
						boolean result = eserv.signUp(name, userName, password);
						if (result) {
							System.out.println("Successfuly Registered a new User!");
						} else {
							System.out.println("Sorry");
						}
						break;

					}

					case 3: {
						System.out.print("Enter Username of user to Delete:");
						String userName = scan.next();
						eserv.deleteUser(userName);
						System.out.println("User Deleted Sucessfuly!");
						break;
					}

					case 4: {

						System.out.println("1: Update Username of user");
						System.out.println("2: Update password of user");
						System.out.println("3: Update 4-Digit PIN for Bank Account");
						int decision = scan.nextInt();

						switch (decision) {
						case 1: {

							System.out.println("Enter Current Username:");
							String puserName = scan.next();
							System.out.println("Enter New Username:");
							String nuserName = scan.next();
							//

							try {

								unapv.userUserNameAailable(nuserName);
								unapv.validUN(nuserName);
							} catch (NotValidCharacter e) {
								System.out.println("User Name " + e.getMessage());
							} catch (UserAlreadyExists e) {
								System.out.println(e.getMessage());
								break;
							}

							boolean result = eserv.updateuserName(puserName, nuserName);
							if (result) {
								System.out.println("Updated Successfuly");
							} else {
								System.out.println("Sorry! Try Again");
							}

							break;
						}

						case 2: {

							System.out.println("Enter Username of user: ");
							String userName = scan.next();
							List<User> users = eserv.getAllUsers();
							for (User user : users) {
								if (user.getUserName().equals(userName)) {

									System.out.println("Enter New Password:");
									String pass = scan.next();
									boolean result = eserv.updatePassword(userName, pass);
									if (result) {
										System.out.println("Password updated!");
									} else {
										System.out.println("Sorry!Try Again!");
									}

								}
							}

							break;
						}

						case 3: {

							System.out.println("Enter Bank Account Number:");
							int accNum = scan.nextInt();
							System.out.println("Enter New 4-Digit PIN:");
							int pin = scan.nextInt();
							boolean result = bserv.updatePin(accNum, pin);
							if (result) {
								System.out.println("Updated PIN!");
							} else {
								System.out.println("Sorry! Try Again");
							}

							break;

						}

						default: {
							break;
						}
						}

						break;

					}

					case 5: {

						System.out.println("Successflly loggedout!");
						System.exit(0);
						break;

					}
					default: {
						System.out.println("Invalid Choice!");
					}

					}

				}
			}

		}
	}

}
