public class BST<E extends Comparable<E>> {
	//root of the tree
	Node root;
	//size of the tree
	int size;

	BST() {
		root = null;
		size = 0;
	}

	class Node {
		Node left;
		Node right;
		E data;

		Node() {
			left = null;
			right = null;
			data = null;
		}
	}

	//add
	public void add(E item) {
		Node newNode = new Node();
		if(root == null) {
			newNode.data = item;
			root = newNode;
			return;
		}
//		//code for add, maybe useful to have recursive helper method
			addHelper(root, item);
		}

	public boolean addHelper(Node root, E item) {

		Node newNode = new Node();//Initializing a node

		//Check the data to see if already in tree.
		int value =  item.compareTo(root.data);

		if(value == 0) {

			return false;
		}

		if(value < 0) {
			//Check to see if left child node exists if not...
			if(root.left == null) {

				root.left = newNode;//Create left child.
				newNode.data = item;//Set its value.

			}else {

				//If left child already exists continue going left.
				addHelper(root.left, item);
			}

		}else { 

			//Check to see if right child node exists if not...
			if(root.right == null) {

				root.right = newNode;//New right child node.
				newNode.data = item;//Set its value.

			}else{

				//If left child already exists continue going right.
				addHelper(root.right, item);
			}
		}

		return true;
	}

	//find element with name item in tree
	public void search(E item) {
		Node found = searchHelper(root, item);
		if(found == null) {
			System.out.println("No item found.");
		}
		else {
			System.out.println("Found: " + found.data);
		}
	}

	private Node searchHelper(Node root, E item) {
		//item not in tree or first one is item
		if(root == null || root.data == item) {
			return root;
		}
		if(root.data.compareTo(item) > 0) {
			return searchHelper(root.left, item);
		}
		return searchHelper(root.right, item);
	}

	//number of elements inside tree
	public void size() {
		System.out.println("The size of this tree is " + sizeHelper(root) + " elements long."); 
	}
	private int sizeHelper(Node node) { 
		if (node == null) return(0); 
		else { 
			return(sizeHelper(node.left) + sizeHelper(node.right)) + 1; 
		} 
	}

	//height of the tree
	public void height() {
	System.out.println("The height of this tree is " + heightHelp(root) + " levels.");	
	}
	
	private int heightHelp(Node node) {
		if (node == null) 
			return 0;
		else {
			int heightL = heightHelp(node.left);
			int heightR = heightHelp(node.right);
			if (heightL > heightR)
				return (heightL + 1);
			else
				return (heightR + 1);
		}
	}

	//minimum of subtree starting at root
	public void min() {
		System.out.println("The minimum value in this tree is: " + minHelper(root));
	}
	
	private E minHelper(Node node) {
	        /* loops down to find the leftmost leaf */
	        while (node.left != null) {
	            node = node.left;
	        }
	        return (node.data);
	}

	//maximum of subtree starting at root
	public void max() {
		System.out.println("The maximum value in this tree is: " + maxHelper(root));
	}
	
	private E maxHelper(Node node) {
		while (node.right != null) {
			node = node.right;
		}
		return (node.data);
	}

	//successor of node with element item and 
	//the head of the subtree is at root
	public void successor() {
		if(root == null) {
			System.out.println("No possible successor.");
		}
		successorHelp(root);
	}
	
	private Node successorHelp(Node root, E item) {
		Node newNode = new Node();
		
		//Using search method to locate the node in question.
		Node successor = searchHelper(root, item);
		if(successor == null) {
			return null;
		}
		
		//Node has a right subtree
		if(successor.right != null) {
			
			newNode = successor.right;
			
			//Finding successor by going through the left of subtree
			while(newNode.left != null) {
				
//				return (BST<E>.Node) minHelper(newNode.right);
				newNode = newNode.left;
				return newNode;
			}
		}else{   //No right subtree
			
			Node ancestor = new Node();
			ancestor = root;
			
			while(ancestor != successor) {
				if(ancestor.left != null) {
					newNode = ancestor; //This is the successor.
					ancestor = ancestor.left;
				}else {
					ancestor = ancestor.right;
				}
			}
			return newNode;
		}
		return newNode;
	}

	public Node predecessor(Node root, E item) {
		int value = item.compareTo(root.data);
			// Example 3 or Example 4
			if (node.left != null)
				return max(node.left);

			// Example 1 or Example 2
			Node predecessor = null;
			// Start from root and search for predecessor down the tree
			
			while (root != null) {
			
				if (node.data == root.data) {
					// by now we might found our predecessor
					break;
				} else if (node.data < root.data) {
					root = root.left;
				} else if (node.data > root.data) {
					predecessor = root;
					root = root.right;
				}
			}
			return predecessor;
		}

	//different traversals of the tree
	public void preorder() {
		System.out.println("\nThe tree in preorder: ");
		preorderHelp(root);
		if(root == null) {
			System.out.println("Nothing to order.");
		}
	}
	
	private void preorderHelp(Node node) {
		if(node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preorderHelp(node.left);
		preorderHelp(node.right);
	}

	public void inorder() {
		if(root != null) {
		System.out.println("\nIn order: ");
		inorderHelp(root);
		System.out.println("\n");
		}
	}
	
	private void inorderHelp(Node node) {
		if(node == null) {
			return;
		}
		inorderHelp(node.left);
		System.out.print(node.data + " ");
		inorderHelp(node.right);
	}

	public void postorder() {
		System.out.println("In post order: ");
		postorderHelp(root);
		System.out.println("\n");
		
	}
	private void postorderHelp(Node node) {
		if(node == null) {
			return;
		}
		postorderHelp(node.left);
		postorderHelp(node.right);
		System.out.print(node.data + " ");
	}

	//deletes the item from the tree
	public void delete(E item) {
		root = delHelper(root, item);
		System.out.println("\n" + item + " successfully deleted!");
	}

	private Node delHelper(Node root, E item) {
		int value = item.compareTo(root.data);
		if(root == null) 
			return root;
		if(value < 0) 
			root.left = delHelper(root.left, root.data);
		else if(value > 0) 
			root.right = delHelper(root.right, root.data);

		else {
			if(root.left == null) 
				return root.right;
			else if(root.right == null) 
				return root.left;
			// node with two children: Get the inorder successor (smallest
			// in the right subtree)
			root.data = minHelper(root.right);

			// Delete the inorder successor
			root.right = delHelper(root.right, root.data);
		}
		return root;

	}

	//remove all from the tree
	public void clearAll() {
		clearAllHelp(root);
		System.out.println("\nAll elements cleared!");
	}
	
	private void clearAllHelp(Node node) {
		if(node != null) {
			clearAllHelp(node.left);
			clearAllHelp(node.right);
			root = null;
			node.data = null;
		}
	}

	//check if tree is empty
	public boolean isEmpty() {
		System.out.println("Is the tree empty?");
		if(root != null) {
			System.out.println("No, the tree is not empty.");
		}
		else {	
			if(root == null) {
				System.out.println("Yes the tree is empty!");
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		//check each of the methods using at least 2 different tests
		//edge cases, all situations
		//BONUS: implement GUI version
		BST<Integer> tree = new BST<Integer>();
		tree.add(Integer.valueOf(17));
		tree.add(Integer.valueOf(10));
		tree.add(Integer.valueOf(20));
		tree.add(Integer.valueOf(3));
		tree.add(Integer.valueOf(98));
		tree.inorder();
		
		tree.add(Integer.valueOf(5));
		tree.search(20);
		tree.delete(17);
		tree.inorder();
		tree.size();
		tree.height();
		System.out.println();
		tree.postorder();
		
		tree.min();
		tree.max();
		tree.preorder();
		System.out.println();
		tree.clearAll();
		
		tree.preorder();
		System.out.println();
		tree.isEmpty();
	}
}