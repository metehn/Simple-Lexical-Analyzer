import java.util.Scanner;

public class Analyzer {

	public static void main(String[] args) {
		
		boolean q = true;
		Scanner in = new Scanner(System.in);
		Lex_Result lexer = new Lex_Result();
		
		while(q) {
	
			System.out.println("\n1-lex()\n2-Symbol table\n3-exit");
			switch (in.nextInt()) {
			case 1:
				if(lexer.get_index() >= lexer.leximes.size()) { // to avoid IndexOutOfBoundsException
					System.out.println("Done...");
					break;
				}
				Token temp = lexer.lex();	
				
				System.out.println(" ");
				
				if(temp.type.equals(Token.Type.ID)) {
					System.out.println("<token="+temp.type + ",index = " + temp.index + ">");
				}
				else if(temp.type.equals(Token.Type.INTEGER)) {			
					System.out.println("<token="+temp.type + ",integer_value = " + temp.index + ">");	
				}
				else if(temp.type.equals(Token.Type.FLOAT)) {
					System.out.println("<token="+temp.type + ",float_value = " + temp.val2 + ">");
				}
				else if(temp.type.equals(Token.Type.BITWISE_OR)) {
					System.out.println("<token="+temp.type +">");
				}
				else if(temp.type.equals(Token.Type.LOGICAL_OR)) {
					System.out.println("<token="+temp.type +">");
				}
				else if(temp.type.equals(Token.Type.BITWISE_AND)) {
					System.out.println("<token="+temp.type +">");
				}
				else if(lexer.lex().type.equals(Token.Type.LOGICAL_AND)) {
					System.out.println("<token="+temp.type +">");
				}
				else if(temp.type.equals(Token.Type.FOR)) {
					System.out.println("<token="+temp.type +">");
				}
				else if(temp.type.equals(Token.Type.WHILE)) {
					System.out.println("<token="+temp.type +">");
				}
				else if(temp.type.equals(Token.Type.IF)) {
					System.out.println("<token="+temp.type +">");
				}
				else if(temp.type.equals(Token.Type.ELSE)) {
					System.out.println("<token="+temp.type +">");
				}
				else if(temp.type.equals(Token.Type.ERROR)) {
					System.out.println("<token="+temp.type +"unrecognizded_string ="+ temp.unr +">");
				}
				else {
					System.out.println("No token, Error...");
				}
			
				lexer.index_increase();
				
				break;
			case 2:
				System.out.println("----Symbol Table ----");
				for (Token a  : lexer.symboltable) {
					System.out.println(a.type);
				}
				System.out.println("---------------------");
				break;
			case 3:
				q=false;
				break;
			default:
				System.out.println("Enter 1,2 or 3");
				break;
			}	  
		}	
	}
}
