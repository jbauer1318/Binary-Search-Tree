public class BinarySearchTree<T> extends BinaryTree<T> {
//Default constructor

	public BinarySearchTree() {       
		super();
	}

	public boolean search(T item) {
		return recSearch(root, item);
	}
//helper: recursive method called by search

	public boolean recSearch(BinaryTreeNode<T> tree, T item) {
		if(tree == null)
			return false;
		else {

	Comparable<T> temp = (Comparable<T>) tree.info;
	if (temp.compareTo(item) == 0)
		return true;
	
	else if (temp.compareTo(item) > 0)
		return recSearch(tree.lLink, item);
	else
		return recSearch(tree.rLink, item);
		}
	}
	public void insert(T item) {
		root = recInsert(root, item);
	}
//helper: recursive method called by insert

	public BinaryTreeNode<T> recInsert(BinaryTreeNode<T> tree, T item) {
		if(tree == null) {
//create new node
			tree = new BinaryTreeNode<T>(item);
		}
		else {
			Comparable<T> temp = (Comparable<T>) tree.info;
			if (temp.compareTo(item) == 0) {
				System.err.print("Already in ­ duplicates are not allowed.");
				return null;
			}
			
			else if (temp.compareTo(item) > 0)
				tree.lLink = recInsert(tree.lLink, item);
			else
				tree.rLink = recInsert(tree.rLink, item);
		}
		return tree;
	}
	public void delete(T item) {
		root = recDelete(root, item);
	}
//helper: recursive method called by delete

	public BinaryTreeNode<T> recDelete(BinaryTreeNode<T> tree, T item) {
		if(tree == null){ //empty tree
			System.err.println("Cannot delete from an empty tree.");
			return null;
		}

		else {
			Comparable<T> temp = (Comparable<T>) tree.info;
			if (temp.compareTo(item) > 0)
				tree.lLink = recDelete(tree.lLink, item);

			else if(temp.compareTo(item) < 0)
				tree.rLink = recDelete(tree.rLink, item);
			else if(tree.lLink != null && tree.rLink != null) {// 2 children
				tree.info = findMin(tree.rLink).info;
//tree.info = findMax(tree.lLink).info;
				tree.rLink = removeMin(tree.rLink);
			}
			else if(root.lLink != null) //1 left child
				tree = tree.lLink;
			else if(root.rLink != null) //1 right child
				tree = tree.rLink;
			return tree;
		}
	}
//helper: method called by recDelete

	protected BinaryTreeNode<T> findMin(BinaryTreeNode<T> tree) {
		if(tree != null)
			while(tree.lLink != null)
				tree = tree.lLink;
		return tree;
	}
//helper: method called by recDelete

	protected BinaryTreeNode<T> removeMin(BinaryTreeNode<T> tree) {
	if(tree == null){ //empty tree
		System.err.println("Cannot delete from an empty tree.");
		return null;
	}

	else if(tree.lLink != null) {
		tree.lLink = removeMin(tree.lLink);
		return tree;
	}

	else
		return tree.rLink;

	}
}