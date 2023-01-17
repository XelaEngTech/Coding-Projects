import java.util.*;

public class Lab4P2 {
	public static void main(String[] args) {
		Account a[] = new Account[2];
		a[0] = new Savings();
		a[1] = new Checking();
		a[0].deposit(1000.00);
		a[0].withdraw(200.00);
		a[0].dailyInterest();
		a[0].show();
		a[1].deposit(3000.00);
		a[1].withdraw(2500.00);
		a[1].show();
		a[1].dailyInterest();
		a[1].show();
		a[1].deposit(650.00);
		a[1].dailyInterest();
		a[1].show();
		
	}
}
abstract class Account {
	protected double amount;
	
	public Account() {
		this.amount = 0.00;
	}
	void deposit(double m) {
		double balance = amount + m;
		this.amount = balance;
		System.out.println("$" + m + " has been deposited into your account");
	}
	void withdraw(double m) {
		if(amount >= m) {
			double balance = amount - m;
			this.amount = balance;
			System.out.println("Successfully withdrew $" + m + " from your account.");
		}
		else
			System.out.println("Your account has insufficient funds!");
	}
	abstract public void show();
	abstract public double dailyInterest();	
}
class Savings extends Account {
	public double dailyInterest() {
		double interest = amount * 0.06;
		this.amount = amount + interest;
		return interest;
	}
	public void show() {
		System.out.println("Savings account balance: $" + this.amount);
	}
}
class Checking extends Account {
	public double dailyInterest() {
		double interest;
		if(amount >= 1000.0){
			interest = amount * 0.03;
			this.amount = amount + interest;
			return interest;
		}
		else
			return 0.00;
	}
	public void show() {
		System.out.println("Checking account balance: $" + this.amount);
	}
}