package sort;

public class Heap_Sort {

	/**
	 * @param args
	 */
	public static void heapSort(int[] array){
		buildMaxHeap(array);
		int heapSize = array.length;

		for(int i =  array.length-1; i>=0;i--){
			exchange(array,i,0);
			 heapSize = heapSize -1 ;
			 maxHeapify(array,0,heapSize);

		}
	}
	
	private static void maxHeapify(int[] array, int index, int heapSize) {
		int left  =  index*2;
		int right = index*2 + 1;
		int largest = index ;
		if(left < heapSize && array[left] > array[index])
			largest  = left;
		if(right < heapSize && array[right] > array[largest])
			largest  = right;      //if the array[index]  is the largest element means that, his left tree and  right tree are match the condition
		if(index != largest){     // if array[index] is not the largest element then maxHeapify index and maxHeapify the elements under the index
			exchange(array,index,largest);
			maxHeapify(array,largest,heapSize);
		}
	}

	private static void buildMaxHeap(int[] array) {
		int heapSize  = array.length;
		for(int i = array.length /2 -1 ; i>=0;i--){
			maxHeapify(array,i,heapSize);
		}
	}

	public static void exchange(int[] array, int i,int j){
		if(i != j){
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp ;
		}
	}
	public static void main(String[] args) {
		int n =99;
		int[] array  = new RandomArr().getArr(n);
		new Heap_Sort().heapSort(array);
		new PrintArray().print(array);
	}

}
