package cseMachine;

import treeGenerator.ASTNode;
import treeGenerator.ASTNodeType;

/*
 * Eta.java
 * 
 * The `Eta` class represents the fixed-point resulting from the application (Y F).
 * In the CSE (Compiled String Execution) machine, we never actually evaluate the fixed-point.
 * The hope is that the program will (in the recursion's base case) choose the option that
 * doesn't have the fixed point (and hence will not lead to our evaluating the fixed point again).
 * 
 * The `Eta` node contains a `Delta` instance representing the lambda closure associated with the
 * fixed-point expression. It provides a mechanism for implementing recursion in RPAL (Right-reference
 * Persistent Abstract Language) programs.
 */
public class Eta extends ASTNode{
  private Delta delta;
  
  public Eta(){
    setType(ASTNodeType.ETA);
  }
  
  //used if the program evaluation results in a partial application
  @Override
  public String getValue(){
    return "[eta closure: "+delta.getBoundVars().get(0)+": "+delta.getIndex()+"]";
  }
  
  // Accepts a `NodeCopier` to create a deep copy of the `Eta` node.
  public Eta accept(NodeCopier nodeCopier){
    return nodeCopier.copy(this);
  }
  
  // Retrieves the `Delta` instance representing the lambda closure associated with the fixed-point expression.
  public Delta getDelta(){
    return delta;
  }
  
  // Sets the `Delta` instance representing the lambda closure associated with the fixed-point expression.
  public void setDelta(Delta delta){
    this.delta = delta;
  }
  
}
