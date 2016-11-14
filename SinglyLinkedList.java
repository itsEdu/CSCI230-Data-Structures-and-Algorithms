
package edu.cofc.cs.csci230;

/**
 * Singly LinkedList Data Structure
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2016
 * 
 * @param <AnyType>
 */

public class SinglyLinkedList<AnyType extends Comparable> implements List<AnyType> {
	// instance variables
	
	private Node<AnyType> headNode = null;
	private int size = 0;

	/**
	 * Appends the specified element to the end of this list.
	 * 
	 * @param t
	 */
	public void add(AnyType t) {
		
		addNode(new Node<AnyType>(t));

	} // end add() method
	
	/**
	 * implementation for public add(AnyType t) method
	 * 
	 * @param t
	 */
	private void addNode(Node<AnyType> t) {
		
		if (isEmpty())
			headNode = t;
		else
			getNode(size - 1).setNextNode(t);
		size++;
		
	} // end addNote() method

	/**
	 * Inserts the specified element at the specified position in this list.
	 * 
	 * @param index
	 * @param t
	 * @throws IndexOutOfBoundsException
	 */
	public void add(int index, AnyType t) throws IndexOutOfBoundsException {

		addNode(index, new Node<AnyType>(t));

	} // end add() method

	/**
	 * Implementation for public add(int index, AnyType t) method
	 *
	 * @param index
	 * @param t
	 * @throws IndexOutOfBoundsException
	 */
	private void addNode(int index, Node<AnyType> t) throws IndexOutOfBoundsException {
		
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Invalid index was given.");
		} else {
			
			Node<AnyType> currentNode = headNode;
			
			if (index == 0) {
				t.setNextNode(headNode);
				headNode = t;
			} else {
				
				currentNode = getNode(index - 1);
				t.setNextNode(currentNode.getNextNode());
				currentNode.setNextNode(t);
			}
			
			size++;
			
		}
		
	} // end addNode() method

	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element.
	 *
	 * @param index
	 * @param t
	 * @throws IndexOutOfBoundsException
	 */
	public void set(int index, AnyType t) throws IndexOutOfBoundsException {
		
		setNode(index, new Node<AnyType>(t));
		
	} // end set() method

	/**
	 *
	 * Implementation for public set( int index, AnyType t ) method
	 *
	 * @param index
	 * @param t
	 * @throws IndexOutOfBoundsException
	 */
	private void setNode(int index, Node<AnyType> t) throws IndexOutOfBoundsException {

		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Invalid index was given.");
		} else {

			Node<AnyType> currentNode = headNode;
			Node<AnyType> previousNode = null;

			if (index == 0) {
				
				t.setNextNode(headNode.getNextNode());
				headNode = t;
				
			} else {
				
				currentNode = getNode(index);
				previousNode = getNode(index - 1);

				previousNode.setNextNode(t);
				t.setNextNode(currentNode.getNextNode());
			}

		}

	} // end setNode() method

	/**
	 * Removes the element at the specified position in this list.
	 * 
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	public AnyType remove(int index) throws IndexOutOfBoundsException {

		return removeNode(index).getData();

	} // end remove() method

	/**
	 *
	 * Implementation for public remove( int index ) method
	 *
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	private Node<AnyType> removeNode(int index) throws IndexOutOfBoundsException {

		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Invalid index was given.");
		} else {

			Node<AnyType> currentNode = headNode;

			if (index == 0) {
				headNode = headNode.getNextNode();
			} else {
				
				currentNode = getNode(index - 1);
				currentNode.setNextNode(currentNode.getNextNode().getNextNode());

			}
			
			size--;
			return currentNode;

		}

	} // end removeNode() method

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	public AnyType get(int index) throws IndexOutOfBoundsException {
		
		return getNode(index).getData();

	} // end get() method

	/**
	 * 
	 * Implementation for public get(int index) method
	 * 
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	private Node<AnyType> getNode(int index) throws IndexOutOfBoundsException {
		
		if (index >= size || index < 0) {
			
			throw new IndexOutOfBoundsException("Invalid index was given.");

		} else {

			Node<AnyType> currentNode = headNode;

			for (int i = 0; i < index; i++) {
				
				currentNode = currentNode.getNextNode();

			}

			return currentNode;

		}

	} // end get() method

	/**
	 * Returns the number of elements in this list.
	 * 
	 * @return
	 */
	public int size() {
		
		return size;

	} // end size() method

	/**
	 * Returns true if this list contains no elements.
	 * 
	 * @return
	 */
	public Boolean isEmpty() {

		return (size == 0) ? true : false;

	} // end isEmpty() method

	/**
	 * Removes all of the elements from this list.
	 * 
	 */
	public void clear() {
		
		headNode = null;
		size = 0;

	} // end clear method

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		SinglyLinkedList<Integer> linked_list = new SinglyLinkedList<Integer>();

		//Add node test
		linked_list.add(new Integer(1));
		linked_list.add(new Integer(8));
		linked_list.add(new Integer(5));
		linked_list.add(new Integer(3));
		linked_list.add(new Integer(4));
		
		//Add node with index test
		linked_list.add(3, new Integer(2));
		linked_list.add(5, new Integer(9));

		for (int i = 0; i < linked_list.size(); i++) {
			
			Node<Integer> currentNode = linked_list.getNode(i);
			System.out.println(currentNode.toString());

		}
		
		// addNode error test case
		try {
			
			// an out of bounds index
			linked_list.add(50, new Integer(15));
			
		} catch (IndexOutOfBoundsException e) {
			
			System.err.println("Error: " + e);
			
		}

		// removeNode test cases
		linked_list.remove(3);

		for (int i = 0; i < linked_list.size(); i++) {
			
			Node<Integer> currentNode = linked_list.getNode(i);
			System.out.println(currentNode.toString());

		}

		linked_list.remove(4);

		for (int i = 0; i < linked_list.size(); i++) {

			Node<Integer> currentNode = linked_list.getNode(i);
			System.out.println(currentNode.toString());

		}

		// removeNode error test case
		try {
			
			// an out of bounds index
			linked_list.remove(-2);

		} catch (IndexOutOfBoundsException e) {

			System.err.println("Error: " + e);

		}

		// setNode test cases
		linked_list.set(2, new Integer(12));
		linked_list.set(4, new Integer(31));

		for (int i = 0; i < linked_list.size(); i++) {

			Node<Integer> currentNode = linked_list.getNode(i);
			System.out.println(currentNode.toString());

		}

		// setNode error test case
		try {

			// an out of bounds index
			linked_list.set(-1, new Integer(0));

		} catch (IndexOutOfBoundsException e) {

			System.err.println("Error: " + e);

		}

		// getNode error test case
		try {
			
			Integer errorNode = linked_list.get(25);
			
		} catch (IndexOutOfBoundsException e) {
			
			System.err.println("Error: " + e);

		}

		// clear test case
		linked_list.clear();

		if (linked_list.isEmpty()) {

			System.out.println("List is empty.");

		} else {

			System.out.println("List is not empty.");

		}

	} // end main() method

} // end SinglyLinkedList class definition