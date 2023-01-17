import java.util.*;

public class Lab3P1 {
	public static void main(String[] args) {
		IntegerSet s = new IntegerSet();
		s.insert(1);
		s.insert(2);
		s.insert(3);
		s.insert(4);
		s.insert(5);
		s.toString();
		System.out.println(s);
		
		IntegerSet t = new IntegerSet();
		t.insert(2);
		t.insert(5);
		t.insert(6);
		t.insert(10);
		t.insert(11);
		t.toString();
		System.out.println(t);
		
		IntegerSet union = s.union(t);
		union.toString();
		System.out.println(union);
		
		IntegerSet intersection = s.intersection(t);
		intersection.toString();
		System.out.println(intersection);
		
		IntegerSet difference = s.difference(t);
		difference.toString();
		System.out.println(difference);
		
		IntegerSet y = new IntegerSet();
		y.insert(1);
		y.insert(2);
		
		IntegerSet u = new IntegerSet();
		u.insert(1);
		u.insert(2);
		
		System.out.println(s.equals(t));
		System.out.println(y.equals(u));
	}
}
class IntegerSet {
	private int[] a;
	
	public IntegerSet() {
		a = new int[100];
	}
		
	public void insert(int i) {
		if(i >= 0 && i < a.length) 
			a[i] = 1;
		else 
			System.out.println("Cannot insert");		
	}
	public void delete(int i) {
		if(i >= 0 && i < a.length)
			a[i] = 0;
		else
			System.out.println("Cannot delete");
	}
	public String toString() {
	    StringBuffer sb = new StringBuffer();
	           sb.append("{");
			   for(int i = 0; i < a.length; i++) {
				   if(a[i] == 1)
					   sb.append(i + ",");   
			   }
			   sb.append("}");
			   return sb.toString();
	          
	}
	public IntegerSet union(IntegerSet x) {
		IntegerSet b = new IntegerSet();
		for(int i = 0; i < a.length; i++) {
			if(this.a[i] == 1 || x.a[i] == 1)
				b.insert(i);
		}
		return b;
	} 
	public IntegerSet intersection(IntegerSet x) {
		IntegerSet e = new IntegerSet();
		for(int i = 0; i < a.length; i++) {
			if(this.a[i] == 1 && x.a[i] == 1)
				e.insert(i);
		}
		return e;
	}
	public IntegerSet difference(IntegerSet x) {
		IntegerSet c = new IntegerSet();
		for(int i = 0; i < a.length; i++) {
			if(this.a[i] == 1 && x.a[i] == 0)
				c.insert(i);
		}
		return c;
	}
	public boolean equals(IntegerSet x) {
		boolean identical = true;
		for(int i = 0; i < a.length; i++) {
			if(this.a[i] == 1 && x.a[i] == 0)
				identical = false;
		}
		return identical;
	}
}
