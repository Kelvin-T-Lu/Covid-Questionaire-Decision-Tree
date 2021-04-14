import java.util.ArrayList; 
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

/**
 * A CovidHealth Builder that builds a tree questionnaire.  
 */
public class CovidHealthBuilder {
	/** 
	 * The Decision Tree for the questionaire. 
	 */
	private DecisionTreeInterface<String> healthTree; 
	
	/**
	 * A getter method for the health tree. 
	 * @return The health tree. 
	 */
	public DecisionTreeInterface<String> getHealthTree(){
		return this.healthTree;
	}
	/**
	 * A questionnaire using a decision tree. 
	 * @param fileName The name of the file being read. 
	 * @throws IOException If the file is unreadable.  
	 */
	public CovidHealthBuilder(String fileName){
		healthTree = new DecisionTree<String>(); 
		try{
			healthTree.setRootNode(buildTree(readData(fileName), null, 0));
		} 
		catch (IOException e) {
			System.out.printf("Invalid File.\n");
		}   
	}
	/**
	 * Reads that data from a file and places the content into an ArrayList. 
	 * @param fileName The file name. 
	 * @return The ArrayList with node content content. 
	 * @throws IOException If file can not be open. 
	 */
	public ArrayList<String> readData(String fileName) throws IOException{
		ArrayList<String> temp = new ArrayList<String>(); 
		File text = new File(fileName);
		Scanner scnr = new Scanner(text); 
		
		//If file is unreachable. 
		if(!scnr.hasNextLine()) { 
			scnr.close(); 
			throw new IOException(); 
		}
		
		while(scnr.hasNextLine()) {
			String s = scnr.nextLine(); 
			if(s.length() == 0) {
				break;
			}
			String[] segments = s.split(","); 
			for(String i: segments) {
				temp.add(i); 
			}  
		}
		scnr.close(); 
		return temp;
	}
	
	/**
	 * Builds a tree with a given content Array list. 
	 * @param data The data of the ArrayList. 
	 * @param current The current Node. 
	 * @param index The index of the ArrayList. 
	 * @return The root node for the health tree. 
	 */
	public BinaryNode<String> buildTree(ArrayList<String> data, BinaryNode<String> current, int index) {
		//System.out.println(data); 
		//System.out.printf("Index: %d ", index);
		if(index > data.size()-1) {
			return null; 
		}
		else if(data.get(index).equals("null")) {//FIX ME
			return null; 
		}

		BinaryNode<String> next = new BinaryNode<String>(data.get(index)); 
	
		next.setLeftChild(buildTree(data, next, 2*index + 1));
		next.setRightChild(buildTree(data,next, 2*index + 2));
		
		return next;
	}
	
	/**
	 * A method that iterates through the tree using the System Input (yes/no) with Scanner class."
	 */
	public void decide() {
		Scanner scnr = new Scanner(System.in); 
		String input;
		
		healthTree.resetCurrentNode(); 
		do{
			System.out.printf("%s\n", healthTree.getCurrentData()); 
			input = scnr.nextLine().toLowerCase();
				
			if(input.contains("yes")) {
				healthTree.moveToYes(); 
			}
			else if(input.contains("no")) {
				healthTree.moveToNo(); 
			}
		}while(!healthTree.isAnswer());
		//Answer Line
		System.out.printf("%s\n\n" , healthTree.getCurrentData()); 
		
		
		System.out.println("Satisfied by my intelligence?\n"); 
		input = scnr.nextLine(); 
		if(input.contains("no")) {
			learn(); 
		}
	}
	
	/**
	 * Activates if a user is not satisfied with the response. 
	 * Gets the User to generate a new question for a new node and updates the tree accordingly. 
	 */
	public void learn() {
		Scanner scrn = new Scanner(System.in);
		String s,t; //User inputs. 
		
		System.out.printf("What should be the answer?\n"); 
		s = scrn.nextLine(); 
		
		System.out.printf("Give me a question whose answer is yes for %s but no for %s\n", s, healthTree.getCurrentData());
		t = scrn.nextLine(); 
		
		updateTree(t, healthTree.getCurrentData(), s); 
		
		
	}
	
	/**
	 * Updates the tree with a new question and answer. 
	 * @param question The new question node. 
	 * @param noAnswer The no answer to the node. 
	 * @param yesAnswer The yes answer to the node. 
	 */
	public void updateTree(String question, String noAnswer, String yesAnswer) {
		
		healthTree.getCurrentNode().setData(question);
		healthTree.getCurrentNode().setLeftChild(new BinaryNode<String>(noAnswer));
		healthTree.getCurrentNode().setRightChild(new BinaryNode<String>(yesAnswer));
	}
}
