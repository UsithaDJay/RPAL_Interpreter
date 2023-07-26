package cseMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import treeGenerator.ASTNode;

/**
 * NodeCopier.java
 * 
 * The `NodeCopier` class is responsible for creating copies of nodes in the Abstract Syntax Tree (AST)
 * for the CSE (Compiled String Execution) machine. These copies are used to pass back duplicates of
 * environment bindings, ensuring that later uses of those bindings are not affected by any changes made
 * in earlier deltas.
 * 
 * <p>The class uses the Visitor pattern to avoid using instanceof checks and maintain cleaner code.
 */
public class NodeCopier{
  
  // Creates a copy of the given ASTNode and its descendants.
  public ASTNode copy(ASTNode astNode){
    ASTNode copy = new ASTNode();
    if(astNode.getChild()!=null)
      copy.setChild(astNode.getChild().accept(this));
    if(astNode.getSibling()!=null)
      copy.setSibling(astNode.getSibling().accept(this));
    copy.setType(astNode.getType());
    copy.setValue(astNode.getValue());
    copy.setSourceLineNumber(astNode.getSourceLineNumber());
    return copy;
  }
  
  // Creates a copy of the given Beta and its descendants.
  public Beta copy(Beta beta){
    Beta copy = new Beta();
    if(beta.getChild()!=null)
      copy.setChild(beta.getChild().accept(this));
    if(beta.getSibling()!=null)
      copy.setSibling(beta.getSibling().accept(this));
    copy.setType(beta.getType());
    copy.setValue(beta.getValue());
    copy.setSourceLineNumber(beta.getSourceLineNumber());
    
    Stack<ASTNode> thenBodyCopy = new Stack<ASTNode>();
    for(ASTNode thenBodyElement: beta.getThenBody()){
      thenBodyCopy.add(thenBodyElement.accept(this));
    }
    copy.setThenBody(thenBodyCopy);
    
    Stack<ASTNode> elseBodyCopy = new Stack<ASTNode>();
    for(ASTNode elseBodyElement: beta.getElseBody()){
      elseBodyCopy.add(elseBodyElement.accept(this));
    }
    copy.setElseBody(elseBodyCopy);
    
    return copy;
  }
  
  // Creates a copy of the given Eta and its descendants.
  public Eta copy(Eta eta){
    Eta copy = new Eta();
    if(eta.getChild()!=null)
      copy.setChild(eta.getChild().accept(this));
    if(eta.getSibling()!=null)
      copy.setSibling(eta.getSibling().accept(this));
    copy.setType(eta.getType());
    copy.setValue(eta.getValue());
    copy.setSourceLineNumber(eta.getSourceLineNumber());
    
    copy.setDelta(eta.getDelta().accept(this));
    
    return copy;
  }
  
  // Creates a copy of the given Delta and its descendants.
  public Delta copy(Delta delta){
    Delta copy = new Delta();
    if(delta.getChild()!=null)
      copy.setChild(delta.getChild().accept(this));
    if(delta.getSibling()!=null)
      copy.setSibling(delta.getSibling().accept(this));
    copy.setType(delta.getType());
    copy.setValue(delta.getValue());
    copy.setIndex(delta.getIndex());
    copy.setSourceLineNumber(delta.getSourceLineNumber());
    
    Stack<ASTNode> bodyCopy = new Stack<ASTNode>();
    for(ASTNode bodyElement: delta.getBody()){
      bodyCopy.add(bodyElement.accept(this));
    }
    copy.setBody(bodyCopy);
    
    List<String> boundVarsCopy = new ArrayList<String>();
    boundVarsCopy.addAll(delta.getBoundVars());
    copy.setBoundVars(boundVarsCopy);
    
    copy.setLinkedEnv(delta.getLinkedEnv());
    
    return copy;
  }
  
  // Creates a copy of the given Tuple and its descendants.
  public Tuple copy(Tuple tuple){
    Tuple copy = new Tuple();
    if(tuple.getChild()!=null)
      copy.setChild(tuple.getChild().accept(this));
    if(tuple.getSibling()!=null)
      copy.setSibling(tuple.getSibling().accept(this));
    copy.setType(tuple.getType());
    copy.setValue(tuple.getValue());
    copy.setSourceLineNumber(tuple.getSourceLineNumber());
    return copy;
  }
}
