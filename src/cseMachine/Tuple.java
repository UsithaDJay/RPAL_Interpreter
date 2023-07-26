package cseMachine;

import treeGenerator.ASTNode;
import treeGenerator.ASTNodeType;

/*
 * Tuple.java
 * 
 * The `Tuple` class represents a tuple node in the Abstract Syntax Tree (AST) for the CSE (Compiled String Execution) machine.
 * It is a specific type of ASTNode with the ASTNodeType.TUPLE type.
 */

public class Tuple extends ASTNode{
  
  public Tuple(){
    setType(ASTNodeType.TUPLE);
  }
  
  // Returns a string representation of the Tuple node.
  @Override
  public String getValue(){
    ASTNode childNode = getChild();
    if(childNode==null)
      return "nil";
    
    String printValue = "(";
    while(childNode.getSibling()!=null){
      printValue += childNode.getValue() + ", ";
      childNode = childNode.getSibling();
    }
    printValue += childNode.getValue() + ")";
    return printValue;
  }
  
  // Accepts a NodeCopier to create a deep copy of the Tuple node.
  public Tuple accept(NodeCopier nodeCopier){
    return nodeCopier.copy(this);
  }
  
}
