
/*******************************************************
 * WordTree
 * 
 * by Abigail Dodd
 * 
 * Holds all of the words, positive and negative, 
 * that make up the analyzer's dictionary. The current
 * idea is to have one tree with two children. The left
 * child is a max treap, and it holds all words with
 * negative connotations, and the right is a min treap
 * that holds all words with positive connotations
 * 
 ******************************************************/
public class WordTree {
	
	private MaxTreap negativeWords;
	private MinTreap positiveWords;
	private Node root;
	
	public WordTree(){
		root = new Node(null, 0);
		negativeWords = new MaxTreap();
		positiveWords = new MinTreap();
		root.setLeftChild(negativeWords.getRoot());
		root.setRightChild(positiveWords.getRoot());
	}//end WordTree
	
	
}
