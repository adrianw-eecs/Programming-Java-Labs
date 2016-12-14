
public class MyArrayList<E> {

	public final int DEFAULT_SIZE = 10;
	private int size;
	private E[] myArray;

	public MyArrayList() {
		this.size = 0;
		myArray = (E[]) new Object[DEFAULT_SIZE];
	}

	public int getSize() {
		return this.size;
	}

	public void set(int index, E value) {
		myArray[index] = value;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		toString(0, sb);
		sb.append(" ]");
		return sb.toString();
	}

	private void toString(int index, StringBuilder sb) {
		if (index < (getSize() - 1)) {
			sb.append(myArray[index] + ", ");
			toString(index + 1, sb);
		}
		if (index < getSize()) {
			sb.append(myArray[index]);
		}
	}

	public void add(E c) {
		
		add(c, 0);
		//myArray[] = tempArray[];
	}

	private void add(E c, int index)
	{
		E[] tempArray = (E[]) new Object[2 * myArray.length]; 
		tempArray[index + 1] = myArray[index];
		
	}

	public void increaseSize() {
		E[] newArray = (E[]) new Object[myArray.length * 2];
		copyArray(newArray, myArray, 1);
		myArray = newArray;
	}

	public void copyArray(E[] to, E[] from, int index) {
		if (index < getSize()) {
			to[index] = from[index];
			copyArray(to, from, index + 1);
		}
	}

	public static void main(String[] args) {
		MyArrayList<Character> pussyBitch = new MyArrayList<Character>();
		// pussyBitch.add('0');
		pussyBitch.add('5');
		pussyBitch.add('4');
		pussyBitch.add('3');
		pussyBitch.add('2');
		pussyBitch.add('1');
		System.out.println(pussyBitch.getSize());
		System.out.println(pussyBitch.toString());
	}
}
