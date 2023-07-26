package parser;

/*
 * ParseException.java
 * 
 * This class extends the `RuntimeException` class to represent exceptions that occur during parsing.
 * The `ParseException` class is specifically designed for handling errors encountered while parsing RPAL programs.
 * It allows for the creation of custom exceptions with informative error messages to aid in debugging and error reporting.
 * 
 * When the parser encounters an error, it throws a `ParseException` with a specific error message to indicate the nature of the error.
 * The error message will help developers identify the cause of the parsing issue and fix the RPAL program accordingly.
 * 
 */

public class ParseException extends RuntimeException{
  private static final long serialVersionUID = 1L;
  
  public ParseException(String message){
    super(message);
  }

}
