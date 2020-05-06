package list2;
/**
 *Location:  F:\Java\DataStructure\LinkedList\src\list2\LinkList.java
 *
 * LinkedList implementation. It contains:
 *  
 * @version 1.0   06-05-2020
 * 1. Insert at beginning, end, and at specified position.
 * 2. Remove at beginning, end, and at specified position.
 * 3. Traverse the List
 * @author  Shivam Singhal
 *_____________________________________________________
 *
 */

/*
 * This is the node class. It contains two parts:
 * 1. Data
 * 2. Reference or Pointer to the next node.
 * 
 */
class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		next = null;
	}
}

/*
 * LinkedList Class named as LinkList
 */
public class LinkList {
	Node head;
	static int size = 0;
	
	/*Insert element at the beginning of the list
	 * For Example: Given list is: 2 -> 1 -> Null
	 * now if we want to add 3 at start.
	 * Final list will be: 3 -> 2-> 1 -> Null
	*/
	public static LinkList insertAtStart_Or_Insert(LinkList list, int data) {
		Node new_node = new Node(data);
		new_node.next = null;

		if (list.head == null) {
			list.head = new_node;
			size++;
		} else {
			new_node.next = list.head;
			list.head = new_node;
			size++;
		}

		return list;
	}

	/*Insert element at the end of the list
	 * For Example: Given list is: 2 -> 1 -> Null
	 * now if we want to add 3 at end.
	 * Final list will be: 2-> 1 -> 3 -> Null
	*/
	public static LinkList insertAtEnd(LinkList list, int data) {
		Node new_node = new Node(data);
		new_node.next = null;

		if (list.head == null) {
			list.head = new_node;
			size++;
		} else {
			Node last = list.head;
			while (last.next != null) {
				last = last.next;

			}
			last.next = new_node;
			size++;
		}

		return list;
	}

	/*Insert element at the specified position of the list
	 * For Example: Given list is: 4 -> 2 -> 1 -> Null
	 * now if we want to add 3 at 1 position.
	 * Final list will be: 4 -> 3 -> 2-> 1 -> Null
	*/
	
	public static LinkList insertAtPosition(LinkList list, int index, int data) {
		Node new_node = new Node(data);
		new_node.next = null;

		if (index == 0) {
			insertAtStart_Or_Insert(list, data);
		} else if (index == size) {
			insertAtEnd(list, data);
		} else if (index < 0 || index > size) {
			System.out.println("Error in size");
		} else {
			Node n = list.head;
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			new_node.next = n.next;
			n.next = new_node;
			size++;
		}

		return list;
	}
	
	/*Remove element at the beginning of the list
	 * For Example: Given list is: 3 -> 2 -> 1 -> Null
	 * now if we want to remove from beginning.
	 * Final list will be: 2-> 1 -> Null
	*/

	public static void removeAtBegnning_Or_Remove(LinkList list) {
		Node head = list.head;
		Node new_head = head.next;
		list.head = new_head;
		size--;
	}
	
	/*Remove element at the specified index of the list
	 * For Example: Given list is: 3 -> 4-> 2 -> 1 -> Null
	 * now if we want to remove element at index 1.
	 * Final list will be: 3 -> 2-> 1 -> Null
	*/

	public static void removeAtIndex(LinkList list, int index) {
		if (index == 0) {
			removeAtBegnning_Or_Remove(list);
		}

		else if (index == size - 1) {
			removeAtEnd(list);
		}

		else if (index < 0 || index >= size) {
			System.out.println("Index out of bound");
		}

		else {
			Node rem_previous = list.head;

			for (int i = 0; i < index - 1; i++) {
				rem_previous = rem_previous.next;
			}

			Node rem = rem_previous.next;
			Node rem_next = rem.next;

			rem_previous.next = rem_next;

			size--;
		}
	}
	
	/*Remove element at the end of the list
	 * For Example: Given list is: 3 -> 2 -> 1 -> Null
	 * now if we want to remove from end.
	 * Final list will be: 3-> 2 -> Null
	*/

	public static void removeAtEnd(LinkList list) {
		Node head = list.head;
		int lastIndex = size - 1;
		for (int i = 0; i <= lastIndex - 2; i++) {
			head = head.next;
		}
		head.next = null;
		size--;
	}
	
	//Traverse the list and print the list element

	public static void printList(LinkList list) {
		Node currNode = list.head;

		System.out.print("\nLinkedList: ");

		while (currNode != null) {

			System.out.print(currNode.data + " -> ");

			currNode = currNode.next;
		}

		System.out.println("\n");
	}

	public static void main(String[] args) {
		LinkList list = new LinkList();

		list = insertAtStart_Or_Insert(list, 9);
		list = insertAtStart_Or_Insert(list, 10);
		list = insertAtEnd(list, 1);
		list = insertAtEnd(list, 2);
		list = insertAtEnd(list, 3);
		list = insertAtEnd(list, 4);
		list = insertAtEnd(list, 5);
		list = insertAtEnd(list, 6);
		list = insertAtEnd(list, 7);
		list = insertAtEnd(list, 8);

		printList(list);  // Output: 10 -> 9 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8

		removeAtBegnning_Or_Remove(list);
		
		list = insertAtPosition(list, 3, 100);
		printList(list);  //Output: 9 -> 1 -> 2 -> 100 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8

		removeAtEnd(list);
		printList(list);  //Output: 9 -> 1 -> 2 -> 100 -> 3 -> 4 -> 5 -> 6 -> 7

		removeAtIndex(list, -1);
		printList(list); //Output: Index out of bound

		list = insertAtPosition(list, size, 200);
		printList(list); //Output: 9 -> 1 -> 2 -> 100 -> 3 -> 4 -> 5 -> 6 -> 7 -> 200
		
	}
}
