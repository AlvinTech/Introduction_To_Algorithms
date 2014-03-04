package sort;

public class Insertion_Sort {

	/**
	 * @param args
	 */
	public static int[] sort(int array[]){
		for(int i = 1;i < array.length;i++){
			int key = array[i];
			int j = i-1;
			while(  j>=0 &&  key < array[j]){
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = key;
		}
		return array;
	}
	public static void main(String[] args) {
		PrintArray print = new PrintArray();
		Insertion_Sort sort = new Insertion_Sort();
		print.print(sort.sort(new RandomArr().getArr(10)));
	}

}
