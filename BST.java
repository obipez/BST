public class BST<E> {
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
		Node node = new Node();
		node = root;
		if(root == null) {
			root = new Node(item);
		}
		else {
			root.add(item) = new Node(item);  //not sure about this at all
		}
		else {
			if(root != null) {
				tree.addHelper();
			}
		}
	
		//code for add, maybe useful to have recursive helper method
		//		addHelper(root, item);
	
	public void addHelper(Node root, E item) {
		Node node = new Node();
		if(node == null) {
			node = new Node(item);
		} 
		else { 
			if (item < root.data) {
				root.left = add(root.left, item);
				root.left = new Node(item);
			}
			else (item > root.data) {
				root.right = add(root.right, item);
				root.right = new Node(item);
			}
			return;
		}
		}

	//find element with name item in tree
	public Node search(E item) {
		return null;
	}

	//mnumber of elements inside tree
	public void size() {

	}

	//height of the tree
	public void height() {

	}

	//minimum of subtree starting at root
	public E min(Node root) {
		return null;
	}

	//maximum of subtree starting at root
	public E max(Node root) {
		return null;
	}

	//successor of node with element item and 
	//the head of the subtree is at root
	public Node successor(Node root, E item) {
		return null;
	}

	public Node predecessor(Node root, E item) {
		return null;
	}

	//different traversals of the tree
	public void preorder() {
	}

	public void inOrder() {
		if(root == null) return;
		if(root != null) {
			inOrder(root.left);
			System.out.println(root.data);
			inOrder(root.right);
		}
	}

	public void postorder() {

	}

	//deletes the item from the tree
	public void delete(E item) {

	}

	//remove all from the tree
	public void clearAll() {

	}

	//check if tree is empty
	//-------- I DONT KNOW IF THIS WORKS YAYAYAYYAYA!! ---------//
	public void isEmpty() {
		if(root == null);
		root = null;
	}


	public static void main(String[] args) {
		//check each of the methods using at least 2 different tests
		//edge cases, all situations
		//BONUS: implement GUI version

		BST tree = new BST();
		Node root = null;

		root = tree.add(root, 47);
	}
}