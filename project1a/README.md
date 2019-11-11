### Project 1a: LinkedListDeque & ArrayDeque

Implement deque operations using doubly linked list and array list in java.

Operation of deque includes:
* `public void addFirst(Genus item)`: Adds an item of type `Genus` to the front of the deque.
* `public void addLast(Genus item)`: Adds an item of type `Genus` to the back of the deque.
* `public boolean isEmpty()`: Returns true if deque is empty, false otherwise.
* `public int size()`: Returns the number of items in the deque.
* `public void printDeque()`: Prints the items in the deque from first to last, separated by a space. Once all the items have been printed, print out a new line.
* `public Genus removeFirst()`: Removes and returns the item at the front of the deque. If no such item exists, returns null.
* `public Genus removeLast()`: Removes and returns the item at the back of the deque. If no such item exists, returns null.
* `public Genus get(int index)`: Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque!

File includes:
1. `LinkedListDeuqe.java`: A class implemening deque operations using a doubly linked list, where two sentinel nodes are used.
2. `ArrayDeque.java`: A class implemening deque operations using an array list.
3. `ArrayDequeCircular.java`: A class having the same functions as `ArrayDeque.java` but adding elements in a circular way.
