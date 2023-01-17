import java.util.*;

public class Lab2P1 {
	public static void main(String[] args) {
		Circle t = new Circle();
		System.out.println(t);
		t.move(5, 12);
		System.out.println(t);
		Point p1 = new Point(3, 5);
		Circle y = new Circle(p1);
		System.out.println(y);
		Point p2 = new Point(4, 10);
		Circle r = new Circle(4);
		System.out.println(r.area());
		Circle e = new Circle(6, p2);
		System.out.println(e + " area: " + e.area() + " circumference: " + e.circumference());
		e.move(14, 10);
		System.out.println(e);
		
		
	}
}
class Point {
	private int x;
	private int y;
		
	public Point() {
		x = y = 0;
	}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public String toString() {
		String s = new String("x: " + this.x + " y: " + this.y);
		return s;
	}
}
class Circle {
	private int radius;
	private Point center;
		
	public Circle() {
		this.radius = 1;
		this.center = new Point(0, 0);
	}
	public Circle(int radius) {
		this.radius = radius;
		this.center = new Point(0, 0);
	}
	public Circle(Point center) {
		this.radius = 1;
		this.center = center;
	}
	public Circle(int radius, Point center) {
		this.radius = radius;
		this.center = center;
	}
	public void move(int x, int y) {
		center.move(x, y);
	}
	public double area() {
		double area = Math.PI * radius * radius;
		return area;	
	}
	public double circumference() {
		double circumference = Math.PI * 2 * radius;
		return circumference;
	}
	public String toString() {
		String src = center.toString() + " radius: " + radius + " center: " + center;
		return src;
	}
}
