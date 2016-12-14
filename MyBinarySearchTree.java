

import java.io.PrintStream;
import java.util.Scanner;

/**
 * This class encapsulates a binary search tree.
 * 
 * @author Steven Castellucci, 2015
 */
public class MyBinarySearchTree<E extends Comparable<? super E>>
// Ensure the parameterized type can be sorted.
{
	private Node<E> root;
	private int size = 0;
	private boolean contain = false;

	/**
	 * Initializes an empty binary search tree.
	 */
	public MyBinarySearchTree() {
		root = null;
	}

	/**
	 * Adds the passed value to the tree.
	 * 
	 * @param value
	 *            the value to add to the tree
	 */
	public void add(E value) {
		root = addNode(root, value);
	}

	// Solves 'add' recursively.
	private Node<E> addNode(Node<E> root, E value) {
		Node<E> result = null;
		if (root == null)
		// Base case, add node here.
		{
			result = new Node<E>(value, null, null);
		} else if (root.data.compareTo(value) > 0) // Recursive case, go left.
		{
			root.leftSubTree = addNode(root.leftSubTree, value);
			result = root;
		} else // Recursive case, go right.
		{
			root.rightSubTree = addNode(root.rightSubTree, value);
			result = root;
		}
		return result;
	}

	/**
	 * Removes the passed value from the tree. The tree is not changed if it
	 * does not contain the passed value.
	 * 
	 * @param value
	 *            the value to remove from the tree.
	 */
	public void remove(E value) {
		root = removeNode(root, value);
	}

	// Solves 'remove' recursively.
	private Node<E> removeNode(Node<E> root, E value) {
		Node<E> result = null;
		if (root != null && root.data.compareTo(value) == 0)
		// Base case, remove this node.
		{
			if (root.leftSubTree == null) // Case 1 or 2 (i.e., 0 or 1 child)
			{
				result = root.rightSubTree; // null if Case 1, not null if Case
											// 2
			} else if (root.rightSubTree == null) // Case 2 (i.e., 1 child on
													// left)
			{
				result = root.leftSubTree;
			} else // Case 3 (i.e., 2 children)
			{
				root.data = largestValue(root.leftSubTree);
				root.leftSubTree = removeLargestNode(root.leftSubTree);
			}
		} else if (root.data.compareTo(value) > 0) // Recursive case, go left.
		{
			root.leftSubTree = removeNode(root.leftSubTree, value);
			result = root;
		} else // Recursive case, go right.
		{
			root.rightSubTree = removeNode(root.rightSubTree, value);
			result = root;
		}
		return result;
	}

	public E largestValue() {
		return (largestValue(root));
	}

	// Returns the largest value in the subtree rooted at 'root'.
	private E largestValue(Node<E> root) {
		E result = null;
		if (root.rightSubTree == null) // Base case, this node has largest.
		{
			result = root.data;
		} else // Recursive case, keep going right.
		{
			result = largestValue(root.rightSubTree);
		}
		return result;
	}

	// Removes the node with the largest value in the subtree rooted at 'root'.
	private Node<E> removeLargestNode(Node<E> root) {
		Node<E> result = null;
		if (root.rightSubTree == null) // Case 1 or 2 (i.e., 0 or 1 child)
		{
			result = root.leftSubTree; // null if Case 1, not null if Case 2
		} else {
			root.rightSubTree = removeLargestNode(root.rightSubTree);
			result = root;
		}
		return root;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		infixPrint(root, sb);
		return sb.toString().trim();
	}

	// Prints the elements in infix order.
	private void infixPrint(Node<E> root, StringBuffer sb) {
		if (root != null) {
			infixPrint(root.leftSubTree, sb);
			sb.append(root.data + " ");
			infixPrint(root.rightSubTree, sb);
		}
	}

	public int size() {
		this.size = 0;
		size(this.root);
		return this.size;
	}

	private void size(Node<E> root) {
		// Base Case 1: Empty Tree
		if (root == null) {
			return;
		}

		// The recursion does not account for root of whole tree, this
		// compensates for that. size is set to 0 before this method is ran, so
		// this method is viable.
		if (this.size == 0) {
			this.size++;
		}

		// need to traverse binary tree and make this.size = size of tree
		if (root.rightSubTree != null) {
			size(root.rightSubTree);
			this.size++;
		}
		if (root.leftSubTree != null) {
			size(root.leftSubTree);
			this.size++;
		}

		// exit condition: there are no more children
		if (root.rightSubTree == null && root.leftSubTree == null) {
			return;
		}
	}

	public E smallestValue() {
		return smallestValue(this.root);
	}

	private E smallestValue(Node<E> root) {
		E result = null;
		// Base case 1: tree is empty
		if (root == null) {
			return null;
		}
		// Base case 2: There are no more subtrees to the left
		if (root.leftSubTree == null) {
			result = root.data;
		}
		// Recursive case, left subtree is not null
		else {
			smallestValue(root.leftSubTree);
		}
		return result;
	}

	public boolean contains(E target) {
		this.contain = false;
		return (contains(this.root, target));
	}

	public boolean contains(Node<E> root, E target) {
		// Base case 2: target = root.data!
		if (root.data == target) {
			this.contain = true;
		}
		// Recursive cases
		// target > root.data
		if (root.data.compareTo(target) > 0 && root.leftSubTree != null) {
			contains(root.leftSubTree, target);
			// target <= root.data
		} else if (root.rightSubTree != null) {
			contains(root.rightSubTree, target);
		} 
		return this.contain;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		PrintStream output = System.out;
		MyBinarySearchTree<Integer> bst = new MyBinarySearchTree<Integer>();

		output.println("Enter a list of non-negative integers. Enter -1 to end.");
		for (int i = input.nextInt(); i != -1; i = input.nextInt()) {
			bst.add(i);
		}
		output.println("\nIn sorted order:");
		output.println(bst.toString() + "\n");
		output.println("The size of the tree is: " + bst.size());
		output.println("The largest value in tree is: " + bst.largestValue());
		output.println("The smallest value in the tree is: " + bst.smallestValue());
		output.print("What value would you like to search for: ");
		int search = input.nextInt();
		System.out.println(bst.contains(search));
	}

	/*
	 * This static nested class encapsulates a node in the tree.
	 */
	private static class Node<E> {
		private E data;
		private Node<E> leftSubTree;
		private Node<E> rightSubTree;

		public Node(E data, Node<E> leftSubTree, Node<E> rightSubTree) {
			this.data = data;
			this.leftSubTree = leftSubTree;
			this.rightSubTree = rightSubTree;
		}
	}
}
