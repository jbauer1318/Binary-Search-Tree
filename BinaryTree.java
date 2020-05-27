import java.util.NoSuchElementException;
public abstract class BinaryTree<T> implements BinaryTreeADT<T> {
//Definition of the BinaryTreeNode class

	protected class BinaryTreeNode<T> {
		public T info;
		public BinaryTreeNode<T> lLink;
		public BinaryTreeNode<T> rLink;
//Default constructor

		public BinaryTreeNode() {
			info = null;
					lLink = null;
					rLink = null;
		}
//Alternate constructor

		public BinaryTreeNode(T item) {
			info = item;
					lLink = null;
					rLink = null;
		}
//Alternate constructor

		public BinaryTreeNode(T item, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
			info = item;
					lLink = left;
					rLink = right;
		}
		public Object clone() {
			BinaryTreeNode<T> copy = null;
					try {
						copy = (BinaryTreeNode<T>) super.clone();
					}
			catch (CloneNotSupportedException e) {
				return null;
			}
			return copy;
		}
		public String toString() {
			return info.toString();
		}
	}
//Instance variable vor class BinaryTree

	protected BinaryTreeNode<T> root;
	
//Default constructor
	public BinaryTree() {
		root = null;
	}

	public Object clone() {
		BinaryTree<T> copy = null;
				try {
	copy = (BinaryTree<T>) super.clone();
				}
		catch (CloneNotSupportedException e) {
			return null;
		}
		if (root != null)
			copy.root = copyTree(root);
			return copy;
	}
//helper method called by clone
	
	private BinaryTreeNode<T> copyTree(BinaryTreeNode<T> otherTreeRoot) {
		BinaryTreeNode<T> temp;
		if (otherTreeRoot == null)
			temp = null;
			else {
				temp = (BinaryTreeNode<T>) otherTreeRoot.clone();
						temp.lLink = copyTree(otherTreeRoot.lLink);
						temp.rLink = copyTree(otherTreeRoot.rLink);
			}
		return temp;
	}
	public boolean isEmpty() {
		return (root == null);
	}
	public void inOrderTraversal() {
		inOrder(root);
	}
//helper method called by inOrderTraversal

	private void inOrder(BinaryTreeNode<T> t) {
		if (t != null) {
			inOrder(t.lLink);
			System.out.print(t.info + " ");
			inOrder(t.rLink);
		}
	}
	public void preOrderTraversal() {
		preOrder(root);
	}
//helper method called by preOrderTraversal

	private void preOrder(BinaryTreeNode<T> t) {
		if (t != null) {
			System.out.print(t.info + " ");
			preOrder(t.lLink);
			preOrder(t.rLink);
		}
	}
	public void postOrderTraversal() {
		postOrder(root);
	}
//helper method called by postOrderTraversal

	private void postOrder(BinaryTreeNode<T> t) {
		if (t != null) {
			postOrder(t.lLink);
			postOrder(t.rLink);
			System.out.print(t.info + " ");
		}
	}
	public int treeHeight() {
		return height(root);
	}
//helper method called by treeHeight

	private int height(BinaryTreeNode<T> t) {
		if (t == null)
			return 0;
					else if (t.lLink == null && t.rLink == null)
						return 0;
								else
									return 1 + Math.max(height(t.lLink), height(t.rLink));
	}
	public int treeNodeCount() {
		return nodeCount(root);
	}
//helper method called by treeNodeCount

	private int nodeCount(BinaryTreeNode<T> t) {
		System.out.println("To be done later.");
		return 0;
	}
	public int treeLeavesCount() {
		return leavesCount(root);
	}
//helper method called by treeLeavesCount

	private int leavesCount(BinaryTreeNode<T> t) {
		System.out.println("To be done later.");
		return 0;
	}
	public void destroyTree() {
		root = null;
	}
//abstract methods

	public abstract boolean search(T item);
	public abstract void insert(T item);
	public abstract void delete(T item);

	
	
	
}