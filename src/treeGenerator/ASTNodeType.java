package treeGenerator;

/**
 * ASTNodeType.java
 * 
 * The `ASTNodeType` enum defines the types of nodes in the Abstract Syntax Tree (AST) as specified in the RPAL phrase structure grammar.
 * Each enum value represents a specific type of AST node and provides a human-readable representation for printing the AST.
 */
public enum ASTNodeType{
  //General
  IDENTIFIER("<ID:%s>"),
  STRING("<STR:'%s'>"),
  INTEGER("<INT:%s>"),
  
  //Expressions
  LET("let"),
  LAMBDA("lambda"),
  WHERE("where"),
  
  //Tuple expressions
  TAU("tau"),
  AUG("aug"),
  CONDITIONAL("->"),
  
  //Boolean Expressions
  OR("or"),
  AND("&"),
  NOT("not"),
  GR("gr"),
  GE("ge"),
  LS("ls"),
  LE("le"),
  EQ("eq"),
  NE("ne"),
  
  //Arithmetic Expressions
  PLUS("+"),
  MINUS("-"),
  NEG("neg"),
  MULT("*"),
  DIV("/"),
  EXP("**"),
  AT("@"),
  
  //Rators and Rands
  GAMMA("gamma"),
  TRUE("<true>"),
  FALSE("<false>"),
  NIL("<nil>"),
  DUMMY("<dummy>"),
  
  //Definitions
  WITHIN("within"),
  SIMULTDEF("and"),
  REC("rec"),
  EQUAL("="),
  FCNFORM("function_form"),
  
  //Variables
  PAREN("<()>"),
  COMMA(","),
  
  //Post-standardize
  YSTAR("<Y*>"),
  
  //For program evaluation only. Will never appear in a standardized or non-standardized AST. 
  BETA(""),
  DELTA(""),
  ETA(""),
  TUPLE("");
  
  private String printName; //used for printing AST representation
  
  // Constructor for ASTNodeType enum
  private ASTNodeType(String name){
    printName = name;
  }

  // Returns a string representation of the AST node type.
  public String getPrintName(){
    return printName;
  }
}
