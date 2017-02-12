// Gruppmedlemmar: Annika Svedin ansv9785, Felix Törnqvist fetr0498

package alda.heap;

public class DHeap<AnyType extends Comparable<? super AnyType>> {
	private static final int DEFAULT_CAPACITY = 10;
	private final int dSize;

	private int currentSize;
	private AnyType[] array;

	public DHeap() {
		this(2);
	}

	public DHeap(int d) {
		if (d < 2)
			throw new IllegalArgumentException("d have to be greater than 1");
		dSize = d;
		currentSize = 0;
		array = (AnyType[]) new Comparable[DEFAULT_CAPACITY + 1];
	}

	public void insert(AnyType x) {
		if (currentSize == array.length - 1)
			enlargeArray(array.length * 2 + 1);

		int hole = ++currentSize;
		insertAt(hole, x);
	}

	private void insertAt(int hole, AnyType x) {
		if (hole < 2)
			array[1] = x;
		else {
			while (hole > 1 && x.compareTo(array[parentIndex(hole)]) < 0) {
				array[hole] = array[parentIndex(hole)];
				hole = parentIndex(hole);
			}
			array[hole] = x;
		}
	}

	public int firstChildIndex(int node) {
		if (node < 1)
			throw new IllegalArgumentException();
		return (node-1) * dSize + 2;
	}

	public int parentIndex(int node) {
		if (node < 2)
			throw new IllegalArgumentException();
		int firstChild = node - (node - 2) % dSize;
		return (firstChild - 2)/ dSize + 1;

	}

	public int size() {
		return currentSize;
	}

	public AnyType get(int index) {
		return array[index];
	}


	private void enlargeArray(int newSize) {
		AnyType[] old = array;
		array = (AnyType[]) new Comparable[newSize];
		for (int i = 0; i < old.length; i++)
			array[i] = old[i];
	}

	public AnyType findMin() {
		if (isEmpty())
			throw new UnderflowException();
		return array[1];
	}

	public AnyType deleteMin() {
		if (isEmpty())
			throw new UnderflowException();

		AnyType minItem = findMin();

		// percolate down
		int currNode = 1;
		int smallestChild = getSmallestChild(currNode);
		int hole = currNode;

		while (smallestChild > 0) {
			array[currNode] = array[smallestChild];
			array[smallestChild] = null;
			hole = smallestChild;

			currNode = smallestChild;
			smallestChild = getSmallestChild(smallestChild);
		}

		if (array[size()] != null) {
			insertAt(hole, array[size()]);
			array[size()] = null;
		}

		currentSize--;
		return minItem;
	}

	private int getSmallestChild(int parent) {
		int child = firstChildIndex(parent);
		if (child > size())
			return -1;

		int smallestChild = (array[child] != null) ? child : -1;
		int stop = child + dSize;
		stop = (stop > size())? size() : stop;

		for(int curr = child + 1; curr < stop; curr++) {
			if(array[curr] != null && array[smallestChild].compareTo(array[curr]) > 0) {
				smallestChild = curr;
			}
		}
		return smallestChild;
	}

	public boolean isEmpty() {
		return currentSize == 0;
	}

	public void makeEmpty() {
		currentSize = 0;
	}

	public String toString() {
		String ret = "[";
		for (AnyType node : array) {
			ret += node + ", ";
		}
		return ret+"]";
	}
}
