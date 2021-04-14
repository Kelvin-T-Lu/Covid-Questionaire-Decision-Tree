/**
 * A Decision Tree. 
 * @param <T> The data type stored in Decision Tree. 
 */
public class DecisionTree<T> extends BinaryTree<T> implements DecisionTreeInterface<T> {
	/**
	 * The current node in the tree. 
	 */
	private BinaryNode<T> current;
	
	/**
	 * A Decision tree with a root data. 
	 * @param data The data of the root. 
	 */
	public DecisionTree(T data) {
		super(data); 
	}
	
	/**
	 * A decision tree without any root. 
	 */
	public DecisionTree() {
		super(); 
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isAnswer() {
		if(current == null) {
			throw new EmptyTreeException(); 
		}
		return current.isLeaf(); 
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void moveToNo() {
		if(current == null) {
			throw new EmptyTreeException(); 
		}
		current = current.getLeftChild(); 
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void moveToYes() {
		if(current == null) {
			throw new EmptyTreeException(); 
		}
		current = current.getRightChild(); 
	}
	/**
	 * {@inheritDoc} 
	 */
	@Override
	public void resetCurrentNode() {
		if(super.getRootNode() == null) {
			throw new EmptyTreeException(); 
		}
		current = super.getRootNode(); 
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BinaryNode<T> getCurrentNode() {
		if(current == null) {
			throw new EmptyTreeException(); 
		}
		return current; 
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T getCurrentData() {
		if(current == null) {
			throw new EmptyTreeException(); 
		}
		return current.getData(); 
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setResponses(T responseForNo, T responseForYes) {
		current.setLeftChild(new BinaryNode<T>(responseForNo)); 
		current.setRightChild(new BinaryNode<T> (responseForYes));
	} 
		
}
