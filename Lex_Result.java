import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Lex_Result {
	static Scanner scanner;
	
	 ArrayList<String> leximes = new ArrayList<String>();
	 ArrayList<Token> symboltable = new ArrayList<Token>(Arrays.asList(new Token(Token.Type.FOR),new Token(Token.Type.WHILE),new Token(Token.Type.IF),new Token(Token.Type.ELSE)));
	 int index =0;
	
	 

	public Lex_Result() {
		try {
			scanner = new Scanner(new File("/home/metehan/eclipse-workspace/Lexical Analyzer/src/data"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		put_in_list();
	}
	
	public  void put_in_list() {
		
		while (scanner.hasNextLine()) {
			Scanner s2 = new Scanner(scanner.nextLine());
			while (s2.hasNext()) {
				leximes.add(s2.next());
			}
		}
	}
	

	public  Token lex() {
		
		
		 if(is_int(leximes.get(index))) {
			 Token a = new Token(Token.Type.INTEGER,Integer.parseInt(leximes.get(index)));
			return a;
		}
		else if(is_float(leximes.get(index))) {
			Token a = new Token(Token.Type.FLOAT,Float.parseFloat(leximes.get(index)));	
			return a;			
		}
		else if(is_for(leximes.get(index))) {
			Token a = new Token(Token.Type.FOR);		
			return a;
		}
		else if(is_while(leximes.get(index))) {
			Token a = new Token(Token.Type.WHILE);		
			return a;
		}
		else if(is_if(leximes.get(index))) {
			Token a = new Token(Token.Type.IF);
			return a;
		}
		else if(is_else(leximes.get(index))) {
			Token a = new Token(Token.Type.ELSE);
			return a;
		}
		else if(is_bitwise_or(leximes.get(index))) {
			Token a = new Token(Token.Type.BITWISE_OR);
			return a;
		}
		else if(is_logical_or(leximes.get(index))) {
			Token a = new Token(Token.Type.LOGICAL_OR);
			return a;
		}
		else if(is_bitwise_and(leximes.get(index))) {
			Token a =  new Token(Token.Type.BITWISE_AND);
			return a;
		}
		else if(is_logical_and(leximes.get(index))) {
			Token a = new Token(Token.Type.LOGICAL_AND);
			return a;
		}
		else if(is_ID(leximes.get(index))) {
			if(find_ID(leximes.get(index)) != -1) {
				Token a = new Token(Token.Type.ID,leximes.get(index),find_ID(leximes.get(index)));
				return a;
			}
			Token a = new Token(Token.Type.ID,leximes.get(index),symboltable.size());
			add_symbol_list(a);
			return a;
		}
		else {
			Token a = new Token(Token.Type.ERROR,leximes.get(index));
			return a;
		}
				
	}	
		
	
	static boolean is_ID(String str) {
		  
	    // If first character is invalid 
	    if (!((str.charAt(0) >= 'a' && str.charAt(0) <= 'z') 
	        || (str.charAt(0)>= 'A' && str.charAt(1) <= 'Z') 
	        || str.charAt(0) == '_')) 
	        return false; 
	  
	    // Traverse the string for the rest of the characters 
	    for (int i = 1; i < str.length(); i++) 
	    { 
	        if (!((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') 
	            || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') 
	            || (str.charAt(i) >= '0' && str.charAt(i) <= '9') 
	            || str.charAt(i) == '_')) 
	            return false; 
	    } 
	  
	    // String is a valid identifier 
	    return true; 
	}
	
	public static boolean is_int(String val) {
		
		try {
			int num = Integer.parseInt(val);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public static boolean is_float(String val) {
		try {
			float num = Float.parseFloat(val);
		} catch (Exception e) {
			return false;
		}
		return true;
	}	
	
	public int find_ID(String str) {
		for (Token t : symboltable) {
			if(t.unr != null && t.unr.equals(str)){
				
				return symboltable.indexOf(t);
			}
			
		}
		return -1;
	}
	
	public boolean is_for(String val) {
		if(val.equals("for")) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean is_while(String val) {
		if(val.equals("while")) {
			return true;
		}
		else {
			return false;
		}
	
	}
	public boolean is_if(String val) {
		if(val.equals("if")) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean is_else(String val) {
		if(val.equals("else")) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean is_bitwise_or(String val) {
		if(val.equals("|")) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean is_logical_or(String val) {
		if(val.equals("||")) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean is_bitwise_and(String val) {
		if(val.equals("&")) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean is_logical_and(String val) {
		if(val.equals("&&")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void index_increase() {
		index++;
	}
	public void add_symbol_list(Token a) {
		symboltable.add(a);
	}
	public int get_index() {
		return index;
	}
	
}
