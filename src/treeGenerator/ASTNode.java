package treeGenerator;

import cseMachine.NodeCopier;

/**
 * ASTNode.java
 * 
 * The `ASTNode` class represents a node in the Abstract Syntax Tree (AST) using a first-child, next-sibling representation.
 * It contains information about the type, value, children, sibling, and source line number of the node.
 */
public class ASTNode{
  private ASTNodeType type;
  private String value;
  private ASTNode child;
  private ASTNode sibling;
  private int sourceLineNumber;
  
  // Get the name of the AST node type (enum value name)
  public String getName(){
    return type.name();
  }

  // Getters and Setters for the ASTNode properties

  public ASTNodeType getType(){
    return type;
  }

  public void setType(ASTNodeType type){
    this.type = type;
  }

  public ASTNode getChild(){
    return child;
  }

  public void setChild(ASTNode child){
    this.child = child;
  }

  public ASTNode getSibling(){
    return sibling;
  }

  public void setSibling(ASTNode sibling){
    this.sibling = sibling;
  }

  public String getValue(){
    return value;
  }

  public void setValue(String value){
    this.value = value;
  }

  
  // Accepts a NodeCopier to create a deep copy of the ASTNode
  public ASTNode accept(NodeCopier nodeCopier){
    return nodeCopier.copy(this);
  }

  // Get the line number in the source code where the node was encountered
  public int getSourceLineNumber(){
    return sourceLineNumber;
  }

  // Set the line number in the source code where the node was encountered
  public void setSourceLineNumber(int sourceLineNumber){
    this.sourceLineNumber = sourceLineNumber;
  }
}
