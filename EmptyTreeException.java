/**
 * Exception for an empty tree. 
 */
public class EmptyTreeException extends RuntimeException {
	
	/**
	 * Thrown if an Empty Tree is unexpected. 
	 */
	public EmptyTreeException() {
		super(); 
	}

	/**
	 * Empty Tree Exception with a custom message. 
	 * @param msg Custom message of the exeception. 
	 */
	public EmptyTreeException(String msg) {
		super(msg); 
	}
}
