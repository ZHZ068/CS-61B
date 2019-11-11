public class LinkedListDeque<Genus> {

	private class ListNode {
		public Genus value;
		public ListNode prev;
		public ListNode next;

		public ListNode(Genus i, ListNode p, ListNode q) {
			value = i;
			prev = p;
			next = q;
		}
	}

	private ListNode sentFront;
	private ListNode sentEnd;
	private int size;

	public LinkedListDeque() {
		sentFront = new ListNode(null, null, null);
		sentEnd = new ListNode(null, null, null);
		sentFront.next = sentEnd;
		sentEnd.prev = sentFront;
		size = 0;
	}

	public LinkedListDeque(Genus x) {
		sentFront = new ListNode(null, null, null);
		sentEnd = new ListNode(null, null, null);
		ListNode temp = new ListNode(x, sentFront, sentEnd);
		sentFront.next = temp;
		sentEnd.prev = temp;
		size = 1;
	}


	/** Adds an item of type T to the front of the deque. */
	public void addFirst(Genus item) {
		size += 1;
		sentFront.next = new ListNode(item, sentFront, sentFront.next);
		sentFront.next.next.prev = sentFront.next;
	}
	
	/** Adds an item of type T to the back of the deque.*/
	public void addLast(Genus item) {
		size += 1;
		sentEnd.prev = new ListNode(item, sentEnd.prev, sentEnd);
		sentEnd.prev.prev.next = sentEnd.prev;
	}
	
	/** Returns true if deque is empty, false otherwise. */
	public boolean isEmpty() {
		return size == 0;
	}

	/** Returns the number of items in the deque. */
	public int size() {
		return size;
	}

	/** Prints the items in the deque from first to last, separated by a space. 
	* Once all the items have been printed, print out a new line.*/
	public void printDeque(){
		for (int i = 0; i < size; i++) {
			System.out.print(get(i));
			System.out.print(" ");
		}
		System.out.print('\n');
	}

	/** Removes and returns the item at the front of the deque. 
	* If no such item exists, returns null. */
	public Genus removeFirst() {
		size -= 1;
		ListNode removedNode = sentFront.next;
		sentFront.next = sentFront.next.next;
		sentFront.next.prev = sentFront;
		return removedNode.value;
	}

	/** Removes and returns the item at the end of the deque. 
	* If no such item exists, returns null. */
	public Genus removeLast() {
		size -= 1;
		ListNode removedNode = sentEnd.prev;
		sentEnd.prev = sentEnd.prev.prev;
		sentEnd.prev.next = sentEnd;
		return removedNode.value;
	}

	/** Gets the item at the given index.
	* If no such item exists, returns null. Must not alter the deque! */
	public Genus get(int index) {
		if (index < size) {
			ListNode runner = sentFront.next;
			for (int i = 0; i < index; i++) {
				runner = runner.next;
			}
			return runner.value;
		}
		return null;
	}

}
