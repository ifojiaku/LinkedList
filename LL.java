package Lab7;

public class LL {
	public static void main(String args[]) {
		int n = 2;
		addNode(50);
		addNode(11);
		addNode(33);
		addNode(21);
		addNode(40);
		addNode(71);
		display();
		removeFromEnd(n);

	}
	//--------------------------------------------
	static class Node{
		//creates data and next nodes where data holds the current value
		//and leads to next which is the following node
		int data;
		Node next;
		Node(int data){
			//sets input value as data, and creates a null node afterwards for
			//for later values to be stored
			this.data=data;
			this.next=null;
		}
	}
	 //--------------------------------------------
	static Node head;
	static Node tail;
	
	public static void addNode(int data) {
		Node newNode = new Node(data);
		//checks to see if node list is empty in order to populate it first
		if(head == null) {
			head = newNode;
			tail = newNode;
		}else {
			//creates a new node with input value after the current data
			tail.next = newNode;
			tail = newNode;
		}
		
		
	}
	//--------------------------------------------
	public static void display() {
		Node current=head;
		//if head starts off with null data, then the list has no elements
		if(head == null) {
			System.out.println("*List is empty*");
			return;
		}
		//prints each value in the list until the pointer reaches a null position
		//which is at the end of the list
		while(current!=null) {
			System.out.print(current.data+" ");
			current = current.next;
		}
		System.out.println();
	}
	//--------------------------------------------
	public static void removeFromEnd(int index) {
		//stops method if list is empty
		if(head == null) {
			System.out.print("*No values to be removed*");
			return;
		}
		//dummy pointer is created to measure current pointer's position from end of list
		Node dummy = head;
		Node current = head;
		//head starts the dummy pointer N places, so that it is ahead of current
		for(int i = 1; i < index;i++) {
			if(dummy.next != null) {
				dummy = dummy.next;
			}
		}
		try {
			while(current!=null) {
				//once dummy pointer reaches the end, the current pointer will skip its
				//current value to remove the value
				if(dummy != null && dummy.next == null) {
					current = current.next;
				}
				//prints each indicated value until current reaches a null position at the end
				System.out.print(current.data+" ");
				current = current.next;
				if(dummy != null) {
					dummy = dummy.next;
				}
			}
		}catch(NullPointerException e) {
			
		}
	}
	//Test Case 1: If an empty list uses print or removeFromEnd, returns message for no values
	/*Test Case 2: If N is a value past the max/min index of the list, the most right/left elements
	               are removed*/
}
