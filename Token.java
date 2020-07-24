
public class Token {
	
	float val2;
	Enum type;
	int index;
	String unr;
	
	public Token(Enum type) {
		this.type = type;
	}
	
	public Token(Enum type, int index) { // this constructor used for both ID and INTEGER type,
										 //for ID,index value is used for index in symbol table,
		this(type); 					 // for INTEGER ,index value is used for integer_value,
		this.index = index;
	}
	public Token(Enum type, String unr,int index) {//for id
		this(type); 
		this.unr = unr;
		this.index = index;
	}
	
	public Token(Enum type, float val2) {
		this(type); 
		this.val2 = val2;
	}
	public Token(Enum type, String unr) {
		this(type); 
		this.unr = unr;
	}

	public enum Type {
		INTEGER, 
		FLOAT, 
		ID, 
		BITWISE_OR, 
		LOGICAL_OR, 
		BITWISE_AND, 
		LOGICAL_AND, 
		FOR, 
		WHILE, 
		IF, 
		ELSE,
		ERROR	
	}
}
