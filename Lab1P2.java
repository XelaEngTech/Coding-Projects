import java.util.*;
import java.io.*;

public class Lab1P2 {
	public static void main(String[] args) throws IOException {
		String s = readFile(args[0]);
		tokenize(s);
	
		
	}
	public static String readFile(String s) throws IOException {
		File f = new File(s);
		int size = (int)f.length();
		char[] data = new char[size];
		
		FileReader in = new FileReader(f);
		in.read(data);
		in.close();
		
		return new String(data);
		
	}
	
	public static void tokenize(String s) {
		StringTokenizer st = new StringTokenizer(s);
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			if(isPsuedoOpCode(token))
				System.out.println(token + " is psuedo op code");
			else if(isOpCode(token))
				System.out.println(token + " is op code");
			else if(isOperand(token))
				System.out.println(token + " is operand");
			else if(isNumber(token))
				System.out.println(token + " is a number");
			else if(isLabel(token))
				System.out.println(token + " is a label");
		}
		
	}
	public static boolean isPsuedoOpCode(String s) {
		if(s.equals(".begin") || s.equals(".data") || s.equals(".end"))
			return true;
		else
			return false;
		
	}
	public static boolean isOpCode(String s) {
		if(s.equals("LOAD") || s.equals("STORE") || s.equals("CLEAR") || s.equals("ADD") || s.equals("INCREMENT") || s.equals("SUBTRACT") || s.equals("DECREMENT") || s.equals("COMPARE") || s.equals("JUMP") || s.equals("JUMPGT") || s.equals("JUMPEQ") || s.equals("JUMPLT") || s.equals("JUMPNEQ") || s.equals("IN") || s.equals("OUT") || s.equals("HALT"))
			return true;
		else
			return false;
		
	}
	public static boolean isOperand(String s) {
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(!Character.isLetter(c))
				return false;
		}
		return true;
		
	}
	public static boolean isLabel(String s) {
		String sub  = s.substring(0, s.length() - 1);
		char last  = s.charAt(s.length() - 1);
		if(isOperand(sub) && last == ':') {
			return true;
		}
		return false;
		
	}
	public static boolean isNumber(String s) {
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(!Character.isDigit(c))
				return false;
		}
		return true;
	}
		
}
	
	