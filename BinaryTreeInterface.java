/**
 * An interface for a binary tree. 
 * @param <T> The data type for the element stored in tree. 
 */
public interface BinaryTreeInterface<T> {
	
	/**
	 * The Data element in the root node. 
	 * @return The Data element of the Root Node. 
	 */
	public T getRootData(); 
	
	/**
	 * The root node. 
	 * @return The root node. 
	 */
	public BinaryNode<T> getRootNode(); 
	
	/**
	 * Sets the root node. 
	 * @param root The root node. 
	 */
	public void setRootNode(BinaryNode<T> root);
	
	/**
	 * The height of the tree. 
	 * @return The int value of height of the tree.
	 */
	public int getHeight(); 
	
	/**
	 * The number of Nodes inside the tree. 
	 * @return The int number of the Nodes. 
	 */
	public int getNumberOfNodes(); 
	
	/**
	 * If the tree is empty. 
	 * @return The boolean value of an empty tree. 
	 */
	public boolean isEmpty(); 
	
	/**
	 * Clears the tree. 
	 */
	public void clear(); 
	
}

