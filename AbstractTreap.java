import java.util.ArrayList;

/*******************************************************
 * AbstractTreap
 * 
 * by Abigail Dodd
 * 
 * Contains all of the logic for implementing a treap
 * where the nodes contain word objects and the BST
 * invariant is based on the spelling of the word in
 * order to ease lookup and help ensure nlogn performance.
 * All of the logic for heapifying the tree is in any
 * class that implements the abstract treap, to allow
 * both min and max treaps to be written based on 
 * this abstract class
 ******************************************************/
/*
 * Abstract class with the code for finding, rotating, and creating
 * Treaps
 */
public abstract class AbstractTreap{
	
	private Node root;
	
	/*
	 * Create a new abstract treap
	 */
	public AbstractTreap(){
		//Root is a dummy head
		root = new Node(null, 0);
		root.setLeftChild(null);
		root.setRightChild(null);
	}//end constructor
	
	public Node getRoot(){
		return root;
	}//end getRoot
	
	/*
	 * Since the roots are dummy roots, here's an option to return
	 * the real root of a tree
	 */
	public Node getRealRoot(){
		return root.getLeftChild();
	}//end 
	
	/*
	 * Recursively search a tree for a particular name
	 */
	public Node find(String name){
		if (this.getRealRoot()==null)
			return null;
		return find(name, this.getRealRoot());
	}//end find
	
	
	private Node find(String name, Node subroot){
		int comparison = subroot.compareTo(name);
		//If i found it, return it!
		if (comparison==0)
			return subroot;
		//If it's not in the tree, return that
		else if (subroot.getLeftChild()==null && subroot.getRightChild()==null)
			return null;
		//Otherwise, recurse right or left depending on comparison
		else if (comparison <0){
			//If the left child isn't real, then it's not in tree
			if (subroot.getLeftChild()==null)
				return null;
			else return find(name, subroot.getLeftChild());
		}
		else{
			if (subroot.getRightChild()==null)
				return null;
			else
				return find(name, subroot.getRightChild());
		}
			
	}//end find
	
	/*
	 * Inserts a word into a BST in alphabetical order
	 */
	private void insert(Node nd){
		//If the treap is empty, insert it
		if (this.getRealRoot()==null)
			root.setLeftChild(nd);
		else
			insert(nd, this.getRealRoot());
	}//end insert
	
	
	private void insert(Node nd, Node subroot){
		int comp = nd.compareTo(subroot);
		//If the word should go to the left of the subroot
		if (nd.compareTo(subroot) <0){
			//If there's an open spot there
			if (subroot.getLeftChild()==null){
				subroot.setLeftChild(nd);
			}
			//Otherwise, recurse left
			else {
				insert(nd, subroot.getLeftChild());
			}//end else
		}//end if
		//Otherwise, the word should go to the right of the subroot
		else {
			//If there's an open spot to the right
			if (subroot.getRightChild()==null){
				subroot.setRightChild(nd);
			}
			else {
				insert(nd, subroot.getRightChild());
			}
		}//end else
	}//end insert helper method
	
	
	public String preorderToString(){
		return preorderToString(this.getRealRoot());
	}//end preorderToString
	
	private String preorderToString(Node subroot){
		String pre = "";
		
		if (subroot.getLeftChild()!=null)
			pre = pre + preorderToString(subroot.getLeftChild());
		//Then add the subroot
		pre = pre + subroot.toString();
		if (subroot.getRightChild()!=null)
			pre = pre + preorderToString(subroot.getRightChild());
		return pre;
	}//end 
	
	
	public void hear(String word, int conn){
		//Just in case, make this word lower case
		word = word.toLowerCase();
		//Check if it's already in the tree
		Node wordNd = find(word);
		
		//If it wasn't in the tree, insert it
		if (wordNd==null){
			wordNd = new Node(word, conn);
			this.insert(wordNd);
		}//end if
		//Otherwise, hear the word and then heapify the tree
		else{
			wordNd.hear(conn);
		}//end else
		//No matter what though, heapify
		this.heapify();
	}
	
	/*
	 * Print out a breadth first search representation of this tree to
	 * check that the heap invariant is obeyed
	 */
	public String toStringBFS(){
		ArrayList<Node> queue = new ArrayList<Node>();
		String bfs = "";
		Node tmp;
		
		queue.add(getRealRoot());
		
		//while the queue isn't empty
		while (!queue.isEmpty()){
			tmp = queue.remove(0);
			bfs = bfs + tmp.getWord() + " - " + tmp.getConnotation() + "\n";
			if (tmp.getLeftChild()!=null)
				queue.add(tmp.getLeftChild());
			if (tmp.getRightChild()!=null)
				queue.add(tmp.getRightChild());
		}//end while
		
		return bfs;
	}//end toStringBFS
	
	
	/*********************************The Abstract Classes***********************************/
	public abstract void heapify();
	
}
