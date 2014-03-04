package sort;

public class Counting_Sort {

	/**
	 * @param args
	 */
	
	public static  void countingSort(int[] arrIn, int[] arrOut,int top ){
		int [] array = new int[top];
		for(int i =0;i< top;i++)
			array[i] = 0;
		
		for(int i =0;i< arrIn.length;i++)
			array[arrIn[i]] = array[arrIn[i]] +1;
		
		for(int i =1;i< top;i++)
			array[i] = array[i-1]+ array[i];
		
		for(int j = arrIn.length -1;j>=0;j--){
			arrOut[array[arrIn[j]]-1] = arrIn[j];
			array[arrIn[j]] = array[arrIn[j]] -1;
		}
	}
	public static void main(String[] args) {
		RandomArr random  = new RandomArr();
		int n =50;
		int[] arrIn = random.getArr(n);
		int[] arrOut = new int[n];
		countingSort(arrIn,arrOut,100);
		new PrintArray().print(arrIn);

		new PrintArray().print(arrOut);
	}

}
