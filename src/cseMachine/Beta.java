package cseMachine;

import java.util.Stack;

import treeGenerator.ASTNode;
import treeGenerator.ASTNodeType;

/*
 * Beta.java
 * 
 * The `Beta` class represents a node in the abstract syntax tree (AST) used for evaluating conditionals in RPAL programs.
 * In the RPAL grammar, the rule 'cond -> then | else' is handled by introducing a `Beta` node on the control stack.
 * The `Beta` node contains the standardized versions of the 'then' and 'else' branches of the conditional expression.
 * 
 * The `Beta` node is crucial for implementing program order evaluation, especially in cases of recursion.
 * By inverting the order of evaluation and placing the `cond` node before the `Beta` node in the control stack, 
 * the evaluation of the condition ('cond') is done first. In the base case, the non-recursive option is chosen,
 * allowing the evaluation to break out of infinite recursion. This inversion of control ensures proper evaluation
 * of conditionals and prevents infinite loops during recursive function calls.
 */
public class Beta extends ASTNode{
  private Stack<ASTNode> thenBody;
  private Stack<ASTNode> elseBody;
  
  public Beta(){
    setType(ASTNodeType.BETA);
    thenBody = new Stack<ASTNode>();
    elseBody = new Stack<ASTNode>();
  }
  
  // Accepts a `NodeCopier` to create a deep copy of the `Beta` node.
  public Beta accept(NodeCopier nodeCopier){
    return nodeCopier.copy(this);
  }

  // Retrieves the standardized 'then' branch of the conditional expression.
  public Stack<ASTNode> getThenBody(){
    return thenBody;
  }

  // Retrieves the standardized 'else' branch of the conditional expression.
  public Stack<ASTNode> getElseBody(){
    return elseBody;
  }

  // Sets the standardized 'then' branch of the conditional expression.
  public void setThenBody(Stack<ASTNode> thenBody){
    this.thenBody = thenBody;
  }

  // Sets the standardized 'else' branch of the conditional expression.
  public void setElseBody(Stack<ASTNode> elseBody){
    this.elseBody = elseBody;
  }
  
}
