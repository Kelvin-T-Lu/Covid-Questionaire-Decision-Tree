/**
 * A Decision Tree Interface. 
 * @param <T> The data type stored in Decision Tree. 
 */
public interface DecisionTreeInterface<T> extends BinaryTreeInterface<T> {

	/**
	 * Checks if the current Node contains final answer. 
	 * @return The boolean value if current Node contains final answer. 
	 */
	public boolean isAnswer(); 
	
	/**
	 * Sets the current node to the left child. 
	 */
	public void moveToNo(); 
	
	/**
	 * Sets the current node to the right child. 
	 */
	public void moveToYes(); 
	
	/**
	 * Set the current Node to the root. 
	 */
	public void resetCurrentNode(); 
	
	/**
	 * Get the current Node. 
	 * @return The current Node in the Decision Tree. 
	 */
	public BinaryNode<T> getCurrentNode(); 
	
	/**
	 * Gets the current Data. 
	 * @return Get the current Data in Node. 
	 */
	public T getCurrentData(); 
	
	/**
	 * Sets the data in the children of its child, left and right. 
	 * @param responseForNo Left child. 
	 * @param responseForYes Right Child. 
	 */
	public void setResponses(T responseForNo, T responseForYes); 
}