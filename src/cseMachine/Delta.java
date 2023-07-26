package cseMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import treeGenerator.ASTNode;
import treeGenerator.ASTNodeType;

/**
 * Delta.java
 * 
 * The `Delta` class represents a lambda closure in the CSE machine. It is used to store and evaluate
 * lambda functions in RPAL programs.
 * 
 * A `Delta` node contains the following properties:
 * - `boundVars`: A list of bound variables (formal parameters) of the lambda function.
 * - `linkedEnv`: The environment in effect when this `Delta` was pushed onto the value stack.
 * - `body`: A stack of AST nodes representing the body of the lambda function.
 * - `index`: An integer representing the index of the `Delta` node.
 * 
 * The `Delta` node is crucial for handling lambda functions during program evaluation.
 * It allows proper closure and environment linking to correctly capture the lexical scope of
 * bound variables when the lambda function is created.
 */
public class Delta extends ASTNode{
  private List<String> boundVars;
  private Environment linkedEnv; //environment in effect when this Delta was pushed on to the value stack
  private Stack<ASTNode> body;
  private int index;
  
  public Delta(){
    setType(ASTNodeType.DELTA);
    boundVars = new ArrayList<String>();
  }
  
  // accepts a NodeCopier to create a deep copy of the Delta node
  public Delta accept(NodeCopier nodeCopier){
    return nodeCopier.copy(this);
  }
  
  // Returns a string representation of the Delta node.
  @Override
  public String getValue(){
    return "[lambda closure: "+boundVars.get(0)+": "+index+"]";
  }

  // Retrieves the list of bound variables (formal parameters) of the lambda function.
  public List<String> getBoundVars(){
    return boundVars;
  }
  
  // Adds a bound variable to the list of bound variables.
  public void addBoundVars(String boundVar){
    boundVars.add(boundVar);
  }
  
  // Sets the list of bound variables (formal parameters) of the lambda function.
  public void setBoundVars(List<String> boundVars){
    this.boundVars = boundVars;
  }
  
  // Retrieves the body of the lambda function.
  public Stack<ASTNode> getBody(){
    return body;
  }
  
  // Sets the body of the lambda function.
  public void setBody(Stack<ASTNode> body){
    this.body = body;
  }
  
  // Retrieves the index of the Delta node.
  public int getIndex(){
    return index;
  }
  
  // Sets the index of the Delta node.
  public void setIndex(int index){
    this.index = index;
  }

  // Retrieves the environment in effect when this Delta was pushed onto the value stack.
  public Environment getLinkedEnv(){
    return linkedEnv;
  }

  // Sets the environment in effect when this Delta was pushed onto the value stack.
  public void setLinkedEnv(Environment linkedEnv){
    this.linkedEnv = linkedEnv;
  }
}
