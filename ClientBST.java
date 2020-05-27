import java.util.Scanner;
public class ClientBST {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		Integer num;
		System.out.print("Enter integers(999 to stop): ");
		num = input.nextInt();
		
		while (num != 999) {
			bst.insert(num);
			num = input.nextInt();
		}
		
		System.out.println("Tree Height: " + bst.treeHeight());
		System.out.print("Enter value to search for: ");
		
		num = input.nextInt();

		if(bst.search(num))
			System.out.println(num + " was found in this tree");
		else
			System.out.println(num + " was NOT found in this tree");
		
		System.out.print("Inorder traversal: ");
		bst.inOrderTraversal();
		System.out.print("\nPreorder traversal: ");
		bst.preOrderTraversal();
		System.out.print("\nPostorder traversal: ");
		bst.postOrderTraversal();
		System.out.print("\nEnter value to be deleted from tree: ");
		num = input.nextInt();
		bst.delete(num);
		System.out.print("\nInorder traversal after removing " + num + ": ");
		bst.inOrderTraversal();
		System.out.print("\nPreorder traversal after removing " + num + ": ");
		bst.preOrderTraversal();
		System.out.print("\nPostorder traversal after removing " + num + ": ");
		bst.postOrderTraversal();
		System.out.println();

	}
}