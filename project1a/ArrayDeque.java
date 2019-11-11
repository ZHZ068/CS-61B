public class ArrayDeque<Genus> {
	private Genus[] arr;
	private int size;
	private int rfactor;

	public ArrayDeque(int x, int y) {
		arr = (Genus[]) new Object[x];
		rfactor = y;
		size = 0;
	}

	public void addFirst(Genus item) {
		if (size == 0) {
			arr[0] = item;
		}else {
			Genus[] newArr = (Genus[]) new Object[size * rfactor];
			newArr[0] = item;
			System.arraycopy(arr, 0, newArr, 1, size);
			arr = newArr;
		}
		size += 1;
		
	}

	public void addLast(Genus item) {
		if (arr[arr.length - 1] != null) {
			Genus[] newArr = (Genus[]) new Object[size * rfactor];
			System.arraycopy(arr, 0, newArr, 0, size);
			newArr[size] = item;
			arr = newArr;
		}else{
			arr[size] = item;
		}
		size += 1;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void printDeque(){
		for (int i = 0; i < size; i++) {
			System.out.print(get(i));
			System.out.print(" ");
		}
		// System.out.print('\n');
		System.out.println(" ");
	}

	public Genus removeFirst() {
		if (size == 0) {
			return null;
		}else{
			Genus[] newArr = (Genus[]) new Object[size];
			Genus temp = arr[0];
			System.arraycopy(arr, 1, newArr, 0, size - 1);
			size -= 1;
			arr = newArr;
			return temp;
		}
	}

	public Genus removeLast() {
		if (size == 0) {
			return null;
		}else{
			Genus temp = arr[size - 1];
			arr[size - 1] = null;
			size -= 1;
			return temp;
		}
	}

	public Genus get(int index) {
		if (index >= size) {
			return null;
		}else {
			return arr[index];
		}
	}

}





/**
public void printDeque(): 
Prints the items in the deque from first to last, separated by a space. 
Once all the items have been printed, print out a new line.

public T get(int index): 
Gets the item at the given index.
If no such item exists, returns null. Must not alter the deque!

*/