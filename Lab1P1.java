import java.util.*;

public class Lab1P1{
	public static void main(String[] args) {
		int[] a = new int[10];
		init(a);
		findPrimes(a);
		print(a);
		
	}
	public static void init(int[] a) {
		for(int i = 2; i < a.length; i++) {
			a[i] = 1;
		}
	}
	public static void findPrimes(int[] a) {
		for(int i = 2; i < a.length; i++) {
			if(a[i] == 1) {
				for(int j = i*2; j < a.length; j = j+i) {
					a[j] = 0;
				}
			}
		}
	}
	public static void print(int[] a) {
		for(int i = 0; i < a.length; i++) {
			if(a[i] == 0)
				System.out.print(" ");
			else if(a[i] != 0)
				System.out.print(i + " ");
		}
	}	
}

