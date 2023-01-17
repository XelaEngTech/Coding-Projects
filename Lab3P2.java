import java.util.*;

public class Lab3P2 {
	public static void main(String[] args) {
		int g = 40;
		int size = g;
		int u = 30;
		int rule = u;
		CellularAutomata c1 = new CellularAutomata(g, u);
		
		boolean[] nan = new boolean[size];
		
		System.out.println("                    x");
		
		for(int e = 0; e < size - size/2; e++){
			nan = c1.getState();
		
		for(int i = 0; i < size; i++) {
			if(nan[i] == true)
				System.out.print("x");
			else
				System.out.print(" ");
		}
		System.out.println("");
	}
	}
}
class CellularAutomata {
	private boolean[] cell;
	private int size;
	private int rule;
	private boolean[] ttable;
	
	public CellularAutomata(int size, int rule) {
		this.size = size;
		this.rule = rule;
		cell = new boolean[size];
		cell[size/2] = true;
		ttable = new boolean[8];
		
		for(int i = 0; i < ttable.length; i++) {
			if(rule % 2 == 0) {
				ttable[i] = false;
				rule=rule/2; 
			}
			else if(rule % 2 == 1) {
				ttable[i] = true;
				rule = (rule-1)/2;		
			}
		}
	}
	public boolean[] getState() {
		boolean[] temp = new boolean[size];
		
		for(int j = 0; j <= size - 1; j++) {
			temp[j] = cell[j];
		}
		
		for(int t = 0; t < size; t++) {
			cell[t] = false;
		}
		for(int i = 1; i < size - 1; i++) {
			boolean l = temp[i - 1];
			boolean m = temp[i];
			boolean r = temp[i + 1];
			if (l == true && m == true && r == true) cell[i] = ttable[7];
			else if (l == true && m == true && r == false) cell[i] = ttable[6];
			else if (l == true && m == false && r == true) cell[i] = ttable[5];
			else if (l == true && m == false && r == false) cell[i] = ttable[4];
			else if (l == false && m == true && r == true) cell[i] = ttable[3];
			else if (l == false && m == true && r == false) cell[i] = ttable[2];
			else if (l == false && m == false && r == true) cell[i] = ttable[1];
			else if (l == false && m == false && r == false) cell[i] = ttable[0];
		} return cell;		
	} 	
}