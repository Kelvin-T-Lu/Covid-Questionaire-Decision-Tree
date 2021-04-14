/**
 * A Binary Tree class. 
 * @param <T> The data type stored in Binary Tree. 
 */
public class BinaryTree<T> implements BinaryTreeInterface<T> {
	/**
	 * The root node of a tree. 
	 */
	private BinaryNode<T> root; 
	
	//CONSTRUCTORS
	/**
	 * A binary tree with an assign root and subtrees. 
	 * @param data The data in the root. 
	 * @param left The left subtree. 
	 * @param right The right subtree. 
	 */
	public BinaryTree(T data, BinaryTree<T> left, BinaryTree<T> right) {
		setTree(data, left, right);
	}
	
	/**
	 * A binary tree with an assign root. 
	 * @param data The data of the root. 
	 */
	public BinaryTree(T data) {
		root = new BinaryNode<T>(data); 
	}
	
	/**
	 * An empty binary tree. 
	 */
	public BinaryTree() {
		root = null;
	}
	
	/**
	 * Set the root Node it subsequent child subtrees. 
	 * @param data The data of the root node. 
	 * @param left The left subchild. 
	 * @param right The right subchild. 
	 */
	public void setTree(T data, BinaryTree<T> left, BinaryTree<T> right) {
		/*if(data != null && left.getRootNode()!= null) {
			if(data.equals(left.getRootData())){
				throw new IllegalArgumentException(); 
			}
		}
		if(data != null && right.getRootNode()!= null) {
			if(data.equals(right.getRootData())){
				throw new IllegalArgumentException(); 
			}
		}*/ 
		root = new BinaryNode<T>(data); 
		
		if(left != null) {
			root.setLeftChild(left.getRootNode()); 
		}
		if(right!= null) {
			root.setRightChild(right.getRootNode());
		}
	}

	/**
	 * Prints all of the node's data in "In Order Traversal Order."
	 */
	public void inOrderTraversal() {
		if(root == null) {
			throw new EmptyTreeException(); 
		}
		inOrderTraversal(root);
	}
	
	/**
	 * Prints all of the node's data in In Order traversal order.
	 * @param node The node that's being iterated. 
	 */
	private void inOrderTraversal(BinaryNode<T> node) {
		if(node.hasLeftChild()) {
			inOrderTraversal(node.getLeftChild()); 
		}
		System.out.printf("%s ",node.getData().toString()); 
		if(node.hasRightChild()) {
			inOrderTraversal(node.getRightChild()); 
		}
	}
	/**
	 * {@inheritDoc} 
	 */
	@Override
	public T getRootData() {
		if(root == null) {
			throw new EmptyTreeException(); 
		}
		return root.getData(); 
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public BinaryNode<T> getRootNode() {
		return root; 
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRootNode(BinaryNode<T> root) {
		this.root = root; 
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getHeight() {
		if(root == null) {
			throw new EmptyTreeException(); 
		}
		return root.getHeight(); 
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getNumberOfNodes() {
		if(root == null) {
			throw new EmptyTreeException(); 
		}
		return root.getNumberOfNodes();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		return (root==null); 
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clear() {
		root = null; 
		
	}

}
