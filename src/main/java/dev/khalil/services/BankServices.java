package dev.khalil.services;

import java.util.List;

import dev.khalil.daos.BankAccountDAOS;
import dev.khalil.entities.BankAccount;
import dev.khalil.entities.User;

public class BankServices {

	BankAccountDAOS bdaos = new BankAccountDAOS();

	public boolean createAccont(double balance, int pin, int id) {

		BankAccount bac = new BankAccount(balance, pin, id);
		return bdaos.createAccount(bac);

	}

	public List<BankAccount> getAccountsbyId(int id) {
		return bdaos.getAccountsbyId(id);

	}

	public BankAccount validateInformation(int accNum, int pin, int userId) {

		for (BankAccount ba : bdaos.getAllAcounts()) {
			if ((ba.getBankId() == accNum) && (ba.getPin() == pin) && (ba.getUserId() == userId)) {

				return ba;

			}
		}

		return null;
	}
	
	
	
	
	public boolean deposit(BankAccount ba, double amount) {
		
		double total = ba.getBalance() + amount;
		ba.setBalance(total);
		return bdaos.deposit(ba);
		
		}
	
	
	public boolean withdraw(BankAccount ba, double amnt) {
		double total = ba.getBalance() - amnt;
		ba.setBalance(total);
		return bdaos.withdraw(ba);
	
	}
	
	
	

}
