//package src;

//import com.sun.tools.javac.Main;

public class EvaluationError{

  public static void printError(int sourceLineNumber, String message){
//    System.out.println(fileName+":"+sourceLineNumber+": "+message);
      System.out.println(":"+sourceLineNumber+": "+message);
    System.exit(1);
  }

}
