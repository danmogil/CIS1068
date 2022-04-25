package wk9;

//worked alone

public class IntArrayWrapper {
	public static final int CAPACITY = 4;
	protected int[] arr;
	protected int numItems;

	public IntArrayWrapper() {
		arr = new int[CAPACITY];
		numItems = 0;
	}

	public int get(int index) {
		return arr[index];
	}

	public boolean append(int newItem) {
		if (numItems == CAPACITY)
			return false;
		arr[numItems++] = newItem;
		return true;
	}

	public void clear() {
		for (int i = 0; i < numItems; i++)
			arr[i] = 0;
		numItems = 0;
	}

	@Override
	public String toString() {
		var sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < numItems; i++)
			sb.append(arr[i] + (i < numItems - 1 ? ", " : ""));
		sb.append("]");
		return sb.toString();
	}

	public boolean equals(IntArrayWrapper other) {
		if (numItems != other.numItems)
			return false;
		for (int i = 0; i < numItems; i++) {
			if (arr[i] != other.get(i))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		var a = new IntArrayWrapper();
		System.out.print(a.toString());
		System.out.println("\tnum items: " + a.numItems);
		a.append(16);
		a.append(19);
		System.out.print(a.toString());
		System.out.println("\tnum items: " + a.numItems);
		a.append(7);
		a.append(8);
		System.out.print(a.toString());
		System.out.println("\tnum items: " + a.numItems);
		// append once capacity reached
		System.out.println(a.append(-1));
		// equals
		var b = new IntArrayWrapper();
		b.append(16);
		b.append(19);
		b.append(7);
		b.append(8);
		System.out.println("a == b ? " + a.equals(b));
		// clear
		a.clear();
		System.out.println(a.toString());
	}

}
