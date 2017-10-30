
public class BinaryHeap {
	public static final int SIZE = 10;
	private int[] heap;
	private int size;
	
	public BinaryHeap() {
		heap = new int[SIZE];
		size =0;
	}
public void add(int priority) {
	if(heap.length ==size) {
		grow_heap();
	}
	heap[size++]= priority;
	int index = size-1;
	while(index>0&& heap[index]<heap[parent(index)]) {
		swap(index, parent(index));
		index = parent(index);
	}

}

public int remove() {
	if(size>0) {
	int temp = heap[0];
	heap[0]= heap[--size];
	bubble_down(0);
	return temp;
	}
	return 0;
	
}



private int parent(int index) {
	return index / 2;
	}
private int left_child(int index) {
	return 2 * index;
}
private int right_child(int index) {
	return 2 * index + 1;
}
private void grow_heap() {
	 int[] new_heap = new int[heap.length*2];
	 System.arraycopy(heap,0, new_heap, 0, heap.length);
	 heap = new_heap;
}
private void swap(int index1, int index2) {
	int temp;
	temp = heap[index1];
	heap[index1] = heap[index2];
	heap[index2] = temp;
}
private boolean isLeaf(int pos) {
	return ((pos > size / 2) && (pos <= size));
}
private void bubble_down(int index) {
	int child;
	while (!isLeaf(index)) {
	        child = left_child(index); 
		if ((child < size) && (heap[child] > heap[child + 1]))
			child = child + 1; 

		if (heap[index] <= heap[child]) 
			return;
		swap(index, child);
		index = child;
	}
}

	
}

