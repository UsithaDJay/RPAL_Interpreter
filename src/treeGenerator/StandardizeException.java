package treeGenerator;

/*
 * StandardizeException.java
 * 
 * The `StandardizeException` class represents a custom exception that is thrown when an error occurs
 * during the standardization process of an Abstract Syntax Tree (AST).
 * 
 * Author: Unknown
 */

public class StandardizeException extends RuntimeException{
  private static final long serialVersionUID = 1L;
  
  public StandardizeException(String message){
    super(message);
  }

}
