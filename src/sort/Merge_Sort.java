package sort;

public class Merge_Sort {

	public static int[] mergeSort(int[] array,int start,int end){
		if(end - start >0){               //should >0
			int mid = (start+end) / 2;
			mergeSort(array,start,mid);   // sort left
			mergeSort(array,mid+1,end);     //  right mid need  add 1
			merge(array,start,mid,end);     // there do not add 1
		}
		return array;
	}
	
	public static void merge(int[] array,int start,int mid,int end){
		int[] left = new int[mid-start+1];   //need to add 1 ex: index is form 0 to 3  there are 4 elements;
		int[] right = new int[end - mid];
		for(int i=0; i<left.length;i++){
			left[i] = array[start+i];
		}
		for(int i=0; i<right.length;i++){
			right[i] = array[mid+1+i];
		}
		
		//union
		int i = 0,j =0;
		for(int index = start;index<=end;index++){    //index shoude <= end because the end element shoud be sort
			if(i == left.length){
				array[index] = right[j];
				j++;
			}
			else if(j == right.length){
				array[index] = left[i];
				i++;
			}
			else if(left[i]<= right[j]){
				array[index] = left[i];
				i++;
			}
			else{
				array[index] = right[j];
				j++;
			}
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrintArray print  = new PrintArray();
		Merge_Sort merge = new Merge_Sort();
		int n =100;
		print.print(merge.mergeSort(new RandomArr().getArr(n),0,n-1));
	}

}
