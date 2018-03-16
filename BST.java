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
//		//code for add, maybe useful to have recursive helper method
			addHelper(root, item);
		}

	public Node addHelper(Node root, E item) {
		int value = item.compareTo(root.data);
		if(value == 0) {
			Node newNode = new Node();
			newNode.data = item;
			root = newNode;
			return root;
		}
		if (value < 0) {
			if(root.left == null) {
				Node newNode = new Node();
				newNode.data = item;
			}
			else {
				addHelper(root.left, item);
			}
		}
		else {
			if(root.right == null) {
				Node newNode = new Node();
				newNode.data = item;
			}
			else {
				addHelper(root.right, item);
			}
		}
		return root;
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
		System.out.println(sizeHelper(root)); 
	}
	private int sizeHelper(Node node) { 
		if (node == null) return 0; 
		else { 
			return(sizeHelper(node.left) + sizeHelper(node.right)) + 1; 
		} 
	}

	//height of the tree
	public int height(Node node) {
		if (node == null) 
			return 0;
		else {
			int heightL = height(node.left);
			int heightR = height(node.right);
			if (heightL > heightR)
				return (heightL + 1);
			else
				return (heightR + 1);
		}
	}

	//minimum of subtree starting at root
	//   ~~~~~~~~~~~~~FIX THIS~~~~~~~~~~~~~~~~~~  //
	public E min(Node root) {
		Node node = root;  
	        while (node.left != null) {
	            node = node.left;
	        }
	        System.out.println("The minimum value is: " + node.data);
	        return(node.data);
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
	public void preorder(Node node) {
		if(node == null) {
			return;
		}
		System.out.printf("%s " + node.data);
		preorder(node.left);
		preorder(node.right);
	}

	public void inorder() {
		inorderHelper(root);
	}
	
	private void inorderHelper(Node node) {
		if(node == null) {
			return;
		}
		inorderHelper(node.left);
		System.out.printf("%s " + node.data);
		inorderHelper(node.right);
	}

	public void postorder(Node node) {
		if(node == null) {
			return;
		}
		postorder(node.left);
		postorder(node.right);
		System.out.printf("%s " + node.data);
	}

	//deletes the item from the tree
	public void delete(E item) {
		root = delHelper(root, item);
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
			root.data = min(root.right);

			// Delete the inorder successor
			root.right = delHelper(root.right, root.data);
		}
		return root;

	}

	//remove all from the tree
	public void clearAll(Node node) {
		if(node != null) {
			clearAll(node.left);
			clearAll(node.right);
			node = null;
		}
	}

	//check if tree is empty
	public void isEmpty() {
		if(root == null);
		root = null;}

	public static void main(String[] args) {
		//check each of the methods using at least 2 different tests
		//edge cases, all situations
		//BONUS: implement GUI version
		BST<Integer> tree = new BST<Integer>();
		tree.add(9);
		tree.add(42);
		tree.add(17);
		tree.add(15);
		tree.add(3);
		tree.add(6);
		tree.add(1);
		tree.inorder();
	}
}