/*******************************************************
 * MaxTreap extends AbstractTreap
 * 
 * by Abigail Dodd
 * 
 * Contains the logic for properly heapifying a max
 * treap
 ******************************************************/
public class MaxTreap extends AbstractTreap{
	
	public MaxTreap(){
		super();
	}//end maxTreap

	@Override
	public void heapify() {
		heapify(super.getRealRoot());
	}//end wrapper heapify
	
	
	private void heapify(Node root){
		/*
		 * The algorithm for this method
		 * 
		 * If root is a leaf, return root
		 * 
		 * Otherwise:
		 * 	Recurse left
		 * 	Recurse right
		 * 	
		 * 	Compare root's left and right child for the max
		 *  If the max is larger than the root, swap the root and max's
		 *  frequency, word, and connotation values. Then, return the root
		 */
		//As long as we're not at a leaf
		Node left = root.getLeftChild();
		Node right = root.getRightChild();
		if (left!=null && right!=null){
			//If left isn't null, recurse left
			if (left != null)
				heapify(left);
			//If right isn't null, recurse right
			if (right != null)
				heapify(right);
			
			//If the right child has the higher connotation
			if (right.getConnotation()>left.getConnotation()){
				//If we need to swap the values in the root and right children
				if (right.getConnotation()>root.getConnotation()){
					double tmpCon = root.getConnotation();
					int tmpFreq = root.getFrequency();
					String tmpWord = root.getWord();
					
					//Change the root's references
					root.setWord(right.getWord());
					root.setConnotation(right.getConnotation());
					root.setFrequency(right.getFrequency());
					
					//Now, change the right's references
					right.setWord(tmpWord);
					right.setConnotation(tmpCon);
					right.setFrequency(tmpFreq);
				}//end if
			}//end if
			
			//Otherwise, the left child has the higher connotation
			else {
				//If we need to swap the values in the root and right children
				if (left.getConnotation()>root.getConnotation()){
					double tmpCon = root.getConnotation();
					int tmpFreq = root.getFrequency();
					String tmpWord = root.getWord();
					
					//Change the root's references
					root.setWord(left.getWord());
					root.setConnotation(left.getConnotation());
					root.setFrequency(left.getFrequency());
					
					//Now, change the right's references
					left.setWord(tmpWord);
					left.setConnotation(tmpCon);
					left.setFrequency(tmpFreq);
				}//end if
			}//end else
		}//end if
		//If right is 
				else if (left!=null){
					heapify(left);
					// If we need to swap the values in the root and right children
					if (left.getConnotation() > root.getConnotation()) {
						double tmpCon = root.getConnotation();
						int tmpFreq = root.getFrequency();
						String tmpWord = root.getWord();

						// Change the root's references
						root.setWord(left.getWord());
						root.setConnotation(left.getConnotation());
						root.setFrequency(left.getFrequency());

						// Now, change the right's references
						left.setWord(tmpWord);
						left.setConnotation(tmpCon);
						left.setFrequency(tmpFreq);
					}// end if
				}//end else if 
				
				else if (right!=null){
					heapify(right);
					
					
					//If we need to swap the values in the root and right children
					if (right.getConnotation()>root.getConnotation()){
						double tmpCon = root.getConnotation();
						int tmpFreq = root.getFrequency();
						String tmpWord = root.getWord();
						
						//Change the root's references
						root.setWord(right.getWord());
						root.setConnotation(right.getConnotation());
						root.setFrequency(right.getFrequency());
						
						//Now, change the right's references
						right.setWord(tmpWord);
						right.setConnotation(tmpCon);
						right.setFrequency(tmpFreq);
					}//end if
					
				}//end else if 
	}//end heapify

	



}
