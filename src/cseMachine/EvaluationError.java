package cseMachine;

/*
 * EvaluationError.java
 * 
 * The `EvaluationError` class is a utility class used to print evaluation errors during program execution
 * in the CSE (Compiled String Execution) machine.
 */

public class EvaluationError{
  
  public static void printError(int sourceLineNumber, String message){
    System.out.println(":"+sourceLineNumber+": "+message);
    System.exit(1);
  }

}
