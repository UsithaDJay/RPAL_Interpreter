package cseMachine;

import java.util.HashMap;
import java.util.Map;

import treeGenerator.ASTNode;

/*
 * Environment.java
 * 
 * The `Environment` class represents an environment in the CSE (Compiled String Execution) machine,
 * which maintains a mapping of variable names to their corresponding ASTNode values.
 * Each environment can have a parent environment, forming a hierarchy.
 */
public class Environment{
  private Environment parent;
  private Map<String, ASTNode> nameValueMap;
  
  public Environment(){
    nameValueMap = new HashMap<String, ASTNode>();
  }

  // Returns the parent environment of this environment.
  public Environment getParent(){
    return parent;
  }

  // Sets the parent environment of this environment.
  public void setParent(Environment parent){
    this.parent = parent;
  }
  
  /**
   * Tries to find the binding of the given key in the mappings of this Environment's
   * inheritance hierarchy, starting with the Environment this method is invoked on.
   * 
   * @param key key the mapping of which to find
   * @return ASTNode that corresponds to the mapping of the key passed in as an argument
   *         or null if no mapping was found
   */
  public ASTNode lookup(String key){
    ASTNode retValue = null;
    Map<String, ASTNode> map = nameValueMap;
    
    retValue = map.get(key);
    
    if(retValue!=null)
      return retValue.accept(new NodeCopier());
    
    // if no mapping was found, try to find the mapping in the parent environment
    if(parent!=null)
      return parent.lookup(key);
    else
      return null;
  }
  
  // Adds a mapping of the given key to the given value to this environment.
  public void addMapping(String key, ASTNode value){
    nameValueMap.put(key, value);
  }
}
