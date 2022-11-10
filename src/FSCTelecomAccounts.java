// LinkedList.java
// Author: Dr. Jonathan Cazalas
// Class from which we can create fully functional Linked Lists
public class FSCTelecomAccounts {

    // head: reference variable to the first node of the list
    private Student head;
    
    // CONSTRUCTORS
    public FSCTelecomAccounts() {
        head = null;
    }
	
	/* Below are MANY methods that are used on Linked Lists.
	 * 
	 * Examples:
	 * search, insert, delete, isEmpty, sumNodes, and many more
	 */
	
	//
	// boolean | isEmpty()
	//
	public boolean isEmpty() {
		return head == null;
	}
	
	
	//
	// boolean | search(int)
	//
	public boolean search(int data) {
		return search(head, data);
	}
	//
	// boolean | search(LLnode, int)
	//
	private boolean search(Student p, int data) {
		Student helpPtr = p;
		while (helpPtr != null) {
			if (helpPtr.getID() == data)
				return true;
			helpPtr = helpPtr.getNext();			
		}
		return false;
	}


	//
	// LLnode | findNode(int)
	//
	public Student findNode(int data) {
		return findNode(head, data);
	}
	//
	// LLnode | findNode(LLnode, int)
	//
	private Student findNode(Student p, int data) {
		Student helpPtr = p;
		while (helpPtr != null) {
			if (helpPtr.getID() == data)
				return helpPtr;
			helpPtr = helpPtr.getNext();			
		}
		return null;
	}
	
	
	//
	// void | PrintList()
	//
	public void PrintList() {
		PrintList(head);
	}
	//
	// void | PrintList(LLnode)
	//
	private void PrintList(Student head) {
		// We need to traverse...so we need a help ptr
		Student helpPtr = head;
		// Traverse to correct insertion point
		while (helpPtr != null) {
			// Print the data value of the node
			System.out.print(helpPtr.getID() + ", ");
			// Step one node over
			helpPtr = helpPtr.getNext();
		}
		System.out.println();
	}
	
	
	//
	// void | PrintList()
	//
	public void ModifyAllNodes() {
		ModifyAllNodes(head);
	}
	//
	// void | PrintList(LLnode)
	//
	private void ModifyAllNodes(Student head) {
		// We need to traverse...so we need a help ptr
		Student helpPtr = head;
		// Traverse to correct insertion point
		while (helpPtr != null) {
			// We add 10 to the data value of each node
			helpPtr.setID(helpPtr.getID() + 10);
			// Step one node over
			helpPtr = helpPtr.getNext();
		}
	}
	
	
	//
	// int | sumNodes()
	//
	public int sumNodes() {
		return sumNodes(head);
	}
	//
	// int | sumNodes(BSTnode)
	//
	private int sumNodes(Student head) {
		// We need to traverse...so we need a help ptr
		Student helpPtr = head;
		int sum = 0; // counter
		// Traverse to correct insertion point
		while (helpPtr != null) {
			// Increase sum
			sum += helpPtr.getID();
			// Step one node over
			helpPtr = helpPtr.getNext();
		}
		return sum;
	}
	
	
	//
	// void | insert(int)
	//
	public void insert(Student data) {
		head = insert(head, data);
	}
        
	//
	// LLnode | insert(LLnode, value)
	//
	private Student insert(Student head, Student data) {
		// IF there is no list, newNode will be the first node, so just return it
		if (head == null) {
                                        data.setNext(head);
                                        head = data;
                                        return head;
		}
		
		// ELSE, we have a list. Insert the new node at the correct location
		else {
			// We need to traverse to the correct insertion location...so we need a help ptr
			Student helpPtr = head;
			// Traverse to correct insertion point
			while (helpPtr.getNext() != null) {
				if (helpPtr.getNext().getID() > data.getID()){
                                                                    break; // we found our spot and should break out of the while loop
                                                                }
				helpPtr = helpPtr.getNext();
			}
			// Now make the new node. Set its next to point to the successor node.
			// And then make the predecessor node point to the new node
                                                data.setNext(helpPtr.getNext());
			helpPtr.setNext(data);
                                                
                        
                        
		}
		// Return head
		return head;
	}
	
	
	//
	// void | delete(int)
	//
	public void delete(int data) {
		head = delete(head, data);
	}
	//
	// LLnode | delete(LLnode, value)
	//
	private Student delete(Student head, int data) {
		// We can only delete if the list has nodes (is not empty)
		if (!isEmpty()) {
			// IF the first node (at the head) has the data value we are wanting to delete
			// we found it. Delete by skipping the node and making head point to the next node.
			if (head.getID() == data) {
				head = head.getNext();
			}
			// ELSE, the data is perhaps somewhere else in the list...so we must traverse and look for it
			else {
				// We need to traverse to find the data we want to delete...so we need a help ptr
				Student helpPtr = head;
				// Traverse to correct deletion point
				while (helpPtr.getNext() != null) {
					if (helpPtr.getNext().getID() == data) {
						helpPtr.setNext(helpPtr.getNext().getNext());
						break; // we deleted the value and should break out of the while loop
					}
					helpPtr = helpPtr.getNext();
				}
			}
			// return the possibly updated head of the list
			return head;
		}
		return head;
	}
	
}

