import java.util.*;

public class Lab2P2 {
	public static void main(String[] args) {
		MyInteger a = new MyInteger(4);
		System.out.println(a.isEven());
		System.out.println(a.isOdd());
		System.out.println(a.isPrime());
		System.out.println(a.isPerfect());
		System.out.println(a.isPerfectSquare());
		a.primeFactors();
		MyInteger b = new MyInteger(19);
		System.out.println(b.isEven());
		System.out.println(b.isOdd());
		System.out.println(b.isPrime());
		System.out.println(b.isPerfect());
		System.out.println(b.isPerfectSquare());
		b.primeFactors();
		MyInteger c = new MyInteger(37);
		System.out.println(c.isEven());
		System.out.println(c.isOdd());
		System.out.println(c.isPrime());
		System.out.println(c.isPerfect());
		System.out.println(c.isPerfectSquare());
		c.primeFactors();
	}
}
class MyInteger {
	private int number;
	
	public MyInteger() {
		number = 0;
	}
	public MyInteger(int number) {
		this.number = number;
	}
	public String toString() {
		return new String("Number " + this.number);

	}
	public boolean isEven() {
		if(number % 2 == 0)
			return true;
		else
			return false;
	}
	public boolean isOdd() {
		if(number % 2 != 0)
			return true;
		else
			return false;
	}
	public boolean isPrime() {
		int count = 0;
		for(int i = 1; i <= number; i++) {
			if(number % i == 0)
			count++;
		}
		if(count == 2)
			return true;
		else 
			return false;
	}
	public boolean isPerfect() {
		int i = 1;
		int a = 0;
		while(i <= number) {
			if(number % i == 0)
			a = a + i;
			i++;
		}
		if(a == 2 * number)
			return true;
		else 
			return false;
	}
	public boolean isPerfectSquare() {
		if(number >= 0) {
			int sqr = (int)Math.sqrt(number);
			return ((sqr * sqr) == number);
		}
		return false;
	}
	public void primeFactors() {
		for(int i = 2; i < number; i++) {
			while(number % i == 0) {
				System.out.println(i + " ");
				number = number/i;
			}
		}
		if(number > 2) {
			System.out.println(number);
		}
	}
}
