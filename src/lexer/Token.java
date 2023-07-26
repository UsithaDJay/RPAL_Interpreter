package lexer;

/*
 Token.java

  This file contains the definition of the Token class, which represents a token given by the scanner
  to the parser. A token consists of a type and a value. The value is relevant for certain kinds of
  tokens (e.g., IDENTIFIER, INTEGER, STRING, OPERATOR), but unimportant for others (e.g., DELETE, L_PAREN).

  The Token class includes the following properties and methods:
  - type: Represents the type of the token (a TokenType enum value).
  - value: Represents the value of the token (used for IDENTIFIER, INTEGER, STRING, OPERATOR tokens).
  - sourceLineNumber: Represents the line number in the input source file where the token is located.

 */

 // Token class represents a token given by the scanner to the parser.
public class Token{
  private TokenType type;
  private String value;
  private int sourceLineNumber;

  // Getters and Setters for the Token properties
  
  public TokenType getType(){
    return type;
  }
  
  public void setType(TokenType type){
    this.type = type;
  }
  
  public String getValue(){
    return value;
  }
  
  public void setValue(String value){
    this.value = value;
  }

  public int getSourceLineNumber(){
    return sourceLineNumber;
  }

  public void setSourceLineNumber(int sourceLineNumber){
    this.sourceLineNumber = sourceLineNumber;
  }
}
