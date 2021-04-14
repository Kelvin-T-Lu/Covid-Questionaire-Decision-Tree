/**
 * A binary Node inside a binary tree. 
 * @param <T> The type stored in binary node. 
 */
public class BinaryNode<T> {
	/**
	 * The data stored inside current node. 
	 */
	private T data; 

	
	/**
	 * Gets the data of current Node. 
	 * @return The data stored inside the node. 
	 */
	public T getData() {
		return this.data; 
	}
	
	/**
	 * Sets the data of the current node. 
	 * @param data The data that's being set. 
	 */
	public void setData(T data) {
		this.data = data; 
	}
	
	/**
	 * The left and right sub-trees of this current Node. 
	 */
	private BinaryNode<T> left, right; 
	
	/**
	 * Gets the left child of the current node. 
	 * @return The left child node of current Node. 
	 */
	public BinaryNode<T> getLeftChild(){
		return this.left; 
	}
	
	/**
	 * Sets the left child of the current Node. 
	 * @param child The left child of current Node. 
	 */
	public void setLeftChild(BinaryNode<T> child) {
		this.left = child; 
	}
	
	/**
	 * Gets the right child of the current node. 
	 * @return The right child node of current Node. 
	 */
	public BinaryNode<T> getRightChild(){
		return this.right; 
	}
	
	/**
	 * Sets the right child of the current Node. 
	 * @param child The right child of current Node. 
	 */
	public void setRightChild(BinaryNode<T> child) {
		this.right = child; 
	}
	/**
	 * A binary node with given attribute. 
	 * @param data The data stored inside the node. 
	 * @param left The left child of the current Node. 
	 * @param right The right child of the current Node. 
	 */	
	
	//Constructors
	public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
		setData(data); 
		setLeftChild(left);  
		setRightChild(right); 
	}
	/**
	 * A BinaryNode with a set data but no child. 
	 * @param data The data being set. 
	 */
	public BinaryNode(T data) {
		this(data,null,null); 
	}
	/**
	 * An empty binary Node. 
	 */
	public BinaryNode() {
		this(null,null,null); 
	}
	
	/**
	 * Returns if a left child is present. 
	 * @return Boolean value if node has a left child. 
	 */
	public boolean hasLeftChild() {
		return (this.left != null); 
	}
	
	/**
	 * Returns if a right child is present. 
	 * @return Boolean value if node has a right child. 
	 */
	public boolean hasRightChild() {
		return (this.right != null); 
	}

	/**
	 * Returns if a node has no child. 
	 * @return The boolean value if a node is a leaf. 
	 */
	public boolean isLeaf() {
		return !(hasLeftChild() || hasRightChild());
	}
	
	/**
	 * Return the height of the tree. 
	 * Calls on the private version of method with Node. 
	 * @return The int Height of the tree. 
	 */
	public int getHeight() {
		return getHeight(this)-1; 
	}
	
	/**
	 * Recursively adds up the height of each sub tree. 
	 * @param node The child of this node. 
	 * @return The height of the overall node. 
	 */
	private int getHeight(BinaryNode<T> node) {
		//This method will assumed the root is the height of one. 
		if(node == null) {
			return 0; 
		}
		
		return 1+max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));
	}
	
	/**
	 * Return the maximum of two int value. 
	 * @param i Int value 1. 
	 * @param j Int value 2. 
	 * @return The Maximum of the two int parameters. 
	 */
	private int max(int i, int j) {
		if(i>j) {
			return i; 
		}
		return j; 
	}
	
	/**
	 * Return the number of nodes in this node. 
	 * @return The number of Nodes in current Node. 
	 */
	public int getNumberOfNodes() {
		return getNumberOfNodes(this); 
	}
	
	/**
	 * Return the number of nodes, child and itself. 
	 * @param node The parent Node. 
	 * @return The number of Nodes from a root. 
	 */
	private int getNumberOfNodes(BinaryNode<T> node) {
		if(node==null) {
			return 0; 
		}
		
		return 1 + getNumberOfNodes(node.getLeftChild()) + getNumberOfNodes(node.getRightChild()); 
	}
	
	/**
	 * Returns a copy of the subtree rooted. 
	 * @return The copy of the node's subtree. 
	 */
	public BinaryNode<T> copy(){
		BinaryNode<T> node = new BinaryNode<T>(data); 
		
		if(left!= null) {
			node.setLeftChild(getLeftChild().copy());
		}
		if(right != null) {
			node.setRightChild(getRightChild().copy());
		}
		return node; 
	}
}
