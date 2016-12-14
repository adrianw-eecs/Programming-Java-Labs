package LinkedList;

public class LinkedList {

	/**
	 * head - The first node in the Linked List
	 */
	private Node head;
	/**
	 * size - The size of the Linked List
	 */
	private int size;

	/**
	 * LinkedList() - Creates a new null linked list with size zero
	 */
	public LinkedList() {
		this.head = null;
		this.size = 0;
	}

	/**
	 * Adds nodes to the end of a given Linked List
	 * 
	 * @param data
	 */
	public void addToHead(String data) {
		// Creates new node, with the required data, and link to old head
		Node n = new Node(data, this.head);
		// makes new head the created head
		this.head = n;
		// increases the size of the node
		this.size = this.size + 1;

	}

	/**
	 * Adds data to node of index i, old node of index i goes to the index i + 1
	 * 
	 * @param data
	 * @param i
	 */
	public void add(String data, int i) {

		// first, if list is empty
		if (i == 0) {
			addToHead(data);
		} else {
			// creates new node, with data required and link that the ith node
			// would have
			Node n = new Node(data, getNode(i));

			// gets the (i-1)'th node
			Node previous = getNode(i - 1);
			// ensures that the node is not empty/null (don't actually exist)
			if (previous != null) {
				// makes previous node's next reference be the new node
				previous.setNext(n);
				// adds one to size
				this.size = this.size + 1;
			}
		}
	}

	/**
	 * Adds a Node at the end of the list, with the data passed into it
	 * 
	 * @param data
	 */
	public void addToEnd(String data) {
		// adds a node to the end of list using add method
		this.add(data, this.size());
	}

	public void deleteFromHead() {

		// makes sure list is not empty
		if (this.head != null) {
			// makes head the next node after original head
			this.head = this.head.getNext();
			// subtracts one from size
			this.size = this.size - 1;
		}

	}

	public void delete(int i) {

		// if user wants to delete head, do that
		if (i == 0) {
			deleteFromHead();
			// else if user does not want to delete head
		} else {
			// gets previous node
			Node previous = getNode(i - 1);
			// this is the node that is being deleted
			Node nodeToDelete = getNode(i);

			// if both nodes are not null
			if ((previous != null) && (nodeToDelete != null)) {
				// sets previous node's next to the next of the node to delete
				previous.setNext(nodeToDelete.getNext());
				// subtracts one from size
				this.size = this.size - 1;
			}
		}

	}

	/**
	 * Deletes the node at the end of list
	 */
	public void deleteFromEnd() {
		this.delete(this.size() - 1);
	}

	/**
	 * returns the size of the linked list
	 * 
	 * @return size of the linked list
	 */
	public int size() {
		// returns the size of linked list
		return this.size;
	}

	/**
	 * returns the data from the i'th index
	 * 
	 * @param i
	 *            - the index of the node whose data is required
	 * @return the data of the i'th node
	 */
	public String getData(int i) {
		// gets the corresponding node
		Node current = getNode(i);
		// if the node is not null (i.e. data does not exist in code)
		if (current != null) {
			// returns the data of that node
			return current.getData();
		}
		// if the above is not true, node must be null
		return null;
	}

	/**
	 * *(not for the client's eyes)*
	 * 
	 * Gets the node in the i'th index
	 * 
	 * @param i
	 *            - the index of the node to be returned
	 * @return the node in index i, null if node does not exist in list
	 */
	private Node getNode(int i) {
		// current node is head, pivot point
		Node current = this.head;
		// traverse the list to node i
		// j is smaller than the i'th index and current node is not null (i.e.
		// last node)
		for (int j = 0; (j < i) && (current != null); j++) {
			current = current.getNext();
		}
		// returns current node
		return current;

	}

	public void Reverse() {
		ListReverse(this.head);
	}

	public void ListReverse(Node currentNode) {
		// Empty list
		if (currentNode == null)
			// exit
			return;

		// Base case, LinkedList of length 1
		if (currentNode.getNext() == null) {
			// set head to current tail
			this.head = currentNode;
			// exit
			return;
		}

		// Calls method again, with currentNode =
		// next of original Current Node
		ListReverse(currentNode.next);
		currentNode.next.next = currentNode;
		// As currentNode is now tail, set next to null
		currentNode.next = null;
	}

	// * Not for the client's eyes! *
	// private class of the node
	private class Node {

		// the data to be stored in the node
		private String data;
		// the next node in the list
		private Node next;

		// Constructor one creates a node with empty data and no next
		@SuppressWarnings("unused")
		public Node() {
			this.data = "";
			this.next = null;
		}

		// Constructor two creates a node with data "data" and next "next"
		public Node(String data, Node next) {
			this.data = data;
			this.next = next;
		}

		// returns the data part of the node
		public String getData() {
			return this.data;
		}

		// returns the next part of the node
		public Node getNext() {
			return this.next;
		}

		// sets the next part of the node
		public void setNext(Node next) {
			this.next = next;
		}

		// sets the data part of the node
		@SuppressWarnings("unused")
		public void setData(String data) {
			this.data = data;
		}

	}

}
