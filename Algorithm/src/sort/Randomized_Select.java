package sort;

import java.util.Random;

public class Randomized_Select {

	/**
	 * @param args
	 */
	
	public static int randomSelect(int[] array, int start, int end, int index){
		if(start  == end)
			return array[start];
		else{
			int q = randomized_partiton(array,start,end);
			int k = q - start +1;
			 if(k ==index)
				 return array[q];
			 else if(index < k)
				 return randomSelect(array,start,q-1,index);
			 else
				 return randomSelect(array,q+1,end,index -k);
			 
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
		// TODO Auto-generated method stub
		int[] array = new RandomArr().getArr(10);
		System.out.println(new Randomized_Select().randomSelect(array, 0, 9, 10));

	}

}
