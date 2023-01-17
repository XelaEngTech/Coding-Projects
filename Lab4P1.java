import java.util.*;

public class Lab4P1 {
	public static void main(String[] args) {
		Salesperson s1 = new Salesperson(01, "Bob", 150000.0);
		Policy p1 = new Policy(300000.0, 10203040, "Mother");
		System.out.println(s1 + "\n" + "Sells the policy: " + p1);
		
	}
}
class Policy {
	private double amount;
	private int pid;
	private String beneficiary;
	
	public Policy(double amount, int pid, String beneficiary) {
		this.amount = amount;
		this.pid = pid;
		this.beneficiary = beneficiary;
	}
	
	public String toString() {
		return new String("Policy amount: " + this.amount + ", Policy ID: " + this.pid + ", Policy beneficiary: " + this.beneficiary);
	}
}
class Employee {
	protected int id;
	protected String name;
	protected double salary;
	
	public Employee() {
		id = 0;
		name = null;
		salary = 0.0;
	}
	
	public Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public String toString() {
		return new String("Employee: " + this.name + ", Employee id: " + this.id + ", Employee salary: " + this.salary);
	}
	
}
class Salesperson extends Employee {
	private Policy number;
	
	public Salesperson(Policy number) {
		this.number = number;
	}
	
	public Salesperson(int id, String name, double salary) {
		super(id, name, salary);
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
}