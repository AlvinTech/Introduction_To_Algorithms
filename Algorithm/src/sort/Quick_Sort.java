package sort;

import java.util.Random;

public class Quick_Sort {

	/**
	 * @param args
	 */
	public static void quickSort(int[] array,int start,int end){
		if(start < end){
			//int mid  = partition(array, start, end);  //get the position of the prvit
			int mid  = randomized_partiton(array,start,end);
			quickSort(array,start,mid-1);   // sort the left
			quickSort(array,mid+1,end);     // sort the right
		}
	}
	
	public static int partition(int[] array, int start, int end){
		int key = array[start];      // choose the first element as the prvit
		int i = end;               
		for(int j = end; j > start;j--){  // from the end to the first  find the element biger than the privt
			if(array[j] > key){
				exchange(array,i,j);      //if the element biger than the element exchange the 2 elements
				i--;
			}
		}
		exchange(array,start,i);   // put the element to the right position
		return i;
	}
	public static int randomized_partiton(int[] array, int start, int end){
		Random r = new Random();
		int a  = r.nextInt(end);
		while(a < start){
			a = r.nextInt(end);
		}
		exchange(array,a,end);
		return partition(array,start,end);
	}
	public static void exchange(int[] array,int i,int j){     //exchange 2 elements array[i] and array[j]; i and j is the index of the array.   
		if(j!=i){
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
	}
	public static void main(String[] args) {
		RandomArr  random = new RandomArr();
		int n =100;
		int[] array = random.getArr(n);
		new Quick_Sort().quickSort(array, 0, n-1);
		new PrintArray().print(array);
	}

}
