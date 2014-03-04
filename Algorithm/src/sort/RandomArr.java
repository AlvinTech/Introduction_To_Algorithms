package sort;
import java.util.Random;


public class RandomArr {

	/**
	 * @param args
	 */
	public static int[] getArr(int n){
		int [] array = new int[n];
		Random random  = new Random();
		System.out.println("*******************unsort array  NO:"+n+"************");
		for(int i =0; i < n;i++){
			array[i] = random.nextInt(100);
			System.out.print(array[i]+" ");
		}
		System.out.println();
		return array;
	}
	public static void main(String[] args) {
		new RandomArr().getArr(10);
	}

}
