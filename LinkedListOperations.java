// Haik Shougarian HW1

class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }
}

public class LinkedListOperations {
	
	public int getSize(ListNode head){
		int size = 0;
		while(head!=null){
			size += 1;
			head = head.next;
		}
		return size;
	}
	
	//Please implement other functions

	public boolean isNull(ListNode head){
		// return true if head is null and false otherwise
		if (head == null)
		{
			return true;
		}
		return false;
	}

	public void display(ListNode head)
	{
		// while the head node is not null
		while (!isNull(head))
		{
			// print out the value of head and set head equal to the next node
			System.out.print(head.val + " ");
			head = head.next;
		}
		// print new line character
		System.out.println();
	}
	public void insert(ListNode head, int n, int val)
	{
		// set counter variable equal to 0
		int count = 0;
		// create a new node containing the value
		ListNode node = new ListNode(val);
		// while the count is less than the desired position
		while (count < n - 1)
		{
			// itterate head to the next node and increment count
			head = head.next;
			count++;
		}
		// create a new node called temp and set it equal to the node after head
		ListNode temp = head.next;
		node.next = temp; // node next points to temp
		head.next = node; // head next points to node
	}
	public void remove(ListNode head, int n)
	{
		// create a new node representing previous node and set equal to head
		ListNode prev = head;
		// set count equal to 1
		int count = 1;
		// itterate until you reach the desired postion
		while(count < n)
		{
			// set prev equal to the next node and itterate count
			prev = prev.next;
			count++;
		}
		// create a new node called temp and set equal to node after prev
		ListNode temp = prev.next;
		// set node after prev equal to the node after temp
		prev.next = temp.next;
		// set node after temp to null
		temp.next = null;
	}
	public void removeVal(ListNode head, int val)
	{
		// Create a new node representing previous and set it equal to null
		ListNode previous = null;
		// while the next is not a null node
		while (head.next != null)
		{
			// if the current value is equal to target value
			if (head.val == val)
			{
				// set previous next the the value after head
				previous.next = head.next;
				head = previous; // set head to the previous node
				previous = head.next; // make previous point to head next
			}
			else
			{
				// otherwise, set previous equal to head
				previous = head;
			}
			// itterate your head
			head = head.next;
		}
	}
	public ListNode reverse(ListNode head)
	{
		// create new list node called prevNode and set equal to null
		ListNode prevNode = null;
		// create new list node called temp and set equal to what is after head
		ListNode temp = head.next;
		// while the temp node is not null
		while (!isNull(temp))
		{
			// set temp equal to the node after head
			temp = head.next;
			// set node afte head equal to prevNode
			head.next = prevNode;
			// set prevnode equal to the head
			prevNode = head;
			// set head equal to temp
			head = temp;
		}
		return prevNode;
	}
	
	public static void main(String[] args){
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(4);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		LinkedListOperations l = new LinkedListOperations();
		System.out.print("Currently displaying l1: ");
		l.display(l1);
		l1 = l.reverse(l1);
		System.out.print("Currently displaying reversed l1: ");
		l.display(l1);
		l1 = l.reverse(l1);
		System.out.println("The size of LinkedList l1 is: " + l.getSize(l1));
		System.out.print("Displaying l1 with 75 inserted at position 3: "); 
		l.insert(l1, 3, 75);
		l.display(l1);
		System.out.print("Displaying l1 with 75 removed from position 3: ");
		l.remove(l1, 3);
		l.display(l1);
		System.out.print("Displaying l1 with all 2's removed: ");
		l.removeVal(l1, 2);
		l.display(l1);
		System.out.print("Currently displaying l5: ");
		l.display(l5);
		System.out.println("The size of LinkedList l5 is: " + l.getSize(l5));
		System.out.print("Currently displaying empty list: ");
		l.display(null);
		System.out.println("The size of empty LinkedList is: " + l.getSize(null));
	}    
}
