public abstract class BinaryTreeExtension <T> extends BinaryTree <T> {

	public BinaryTreeExtension(){
		super();
	}
	
	
	public boolean isBinarySearchTree() {
		return isBST(root);
		}
		//helper method called by isBinarySearchTree
			public boolean isBST(BinaryTreeNode<T> t) {
			    if (t != null) {
			      Comparable<T> tmp = (Comparable<T>) t.info;
			      return (tmp.compareTo(t.rLink.info) < 0 && tmp.compareTo(t.lLink.info) > 0 && isBST(t.lLink) && isBST(t.rLink));
			    }
			    return true;
			  }
		
		
		
		public int treeLeavesCount() {
			return leavesCount(root);
			}
			//helper method called by treeLeavesCount
			private int leavesCount(BinaryTreeNode<T> t) {
				        if (t == null) {
				            return 0;
				        }
				        if (t.lLink == null && t.rLink == null) {
				            return 1;
				        }
				        return (leavesCount(t.rLink) + leavesCount(t.lLink));
				    }
			
	public int treeNodeCount() {
			return nodeCount(root);
			}
			
			//helper method called by treeNodeCount
			private int nodeCount(BinaryTreeNode<T> t) {
			    if (t == null) {
		            return 0;
		        } else {
		            return (1 + nodeCount(t.lLink) + nodeCount(t.rLink));
		        }
		    }
			
	

	public boolean similarTrees(BinaryTreeNode<T> otherTree) {
			return similar(root, otherTree);
			}
			//helper method called by similarTrees
	public boolean similar(BinaryTreeNode<T> tree1, BinaryTreeNode<T> tree2) {
		  if (tree1 == tree2) {
		        return true;
		    }
		    if (tree1 == null || tree2 == null) {
		        return false;
		    }
		    return tree1.equals(tree2) &&
		           equals(tree1.lLink(), tree2.lLink()) &&
		           equals(tree1.rLink(), tree2.rLink());
		} 
				
}
