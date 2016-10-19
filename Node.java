/*******************************************************
 * Node
 * 
 * by Abigail Dodd
 * 
 * Node objects which can be used inside of min and 
 * max treaps. Each node contains a word, connotation,
 * frequency, and references for its left and right
 * children and parent
 ******************************************************/
public class Node {
	private String word;
	private double connotation;
	private int frequency;
	private Node leftChild;
	private Node rightChild;
	private Node parent;
	
	public Node(String word, int connotation){
		if (word != null)
			this.word = word.toLowerCase();
		this.connotation = connotation;
		frequency = 1;
		parent = null;
		leftChild = null;
		rightChild = null;
	}//end constructor

	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}

	public double getConnotation() {
		return connotation;
	}

	public void setConnotation(double connotation) {
		this.connotation = connotation;
	}
	
	public int getFrequency(){
		return frequency;
	}
	
	public void setFrequency(int frequency){
		this.frequency = frequency;
	}

	public Node getLeftChild() {
		return leftChild;
	}
	
	/*
	 * Also makes this the leftChild's parent
	 */
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
		if (leftChild != null)
			leftChild.setParent(this);
	}

	public Node getRightChild() {
		return rightChild;
	}

	/*
	 * Also make this the rightchild's parent
	 */
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
		if (rightChild!=null)
			rightChild.setParent(this);
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Node [word=" + word + ", connotation=" + connotation + "]\n";
	}
	

	public int compareTo(Node other){
		return compareTo(other.getWord());
	}
	
	
	
	public int compareTo(String otherWord){
		return word.compareTo(otherWord);
	}//end compareTo
	
	/*
	 * Returns the absolute value of the distance between this letter and M.
	 * 
	 * NOTE: Only works on lowercase letters
	 */
	public int distanceToM(char letter){
		return Math.abs(letter - 'm');
	}
	
	/*
	 * Anytime the analyzer "hears" a word again, it will increase the word's frequency
	 * and adjust the connotation of the word based on its frequency and connotation of
	 * the sentence it's used in. So, a newly learned word will have its frequency 
	 * greatly affected by the connotations it's used in, but words that are used a lot
	 * will not be significantly affected by the connotations where they're used.
	 * 
	 * Basically, it averages the connotations for all the times that it is heard, but a
	 * little extra weight is put on the connotation where the word was first heard
	 */
	public void hear(double newCon){
		double total = connotation * frequency;
		frequency++;
		total += newCon;
		connotation = total/frequency;
	}//end encounter
	
	
}//end class
