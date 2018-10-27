public class QuickSort{

	public static void quicksort(int [] array){

		quicksort(array, 0, array.length-1);
	}

	private static void quicksort(int [] array, int low, int high){

		if(low < high){

			int partitionIndex = partition(array, low, high);

			//recursive calls 
			quicksort(array,low,partitionIndex-1);
			quicksort(array,partitionIndex+1,high);
		}

	}

	private static int partition(int [] array, int low, int high){

		int pivot = array[high];
		int pIndex = low;

		for( int i = low; i <= high-1; i++){
			if(array[i] < pivot){
				swap(array, i, pIndex);
				pIndex++;
			}
		}
		return pIndex;
	}

	private static void swap(int [] array, int i, int j){

		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

 	public static void main(String[] args) {
 		
		int [] array = {1,20,11,3,5,4,9,12};
		QuickSort.quicksort(array);

		//print array 

		for ( int i : array)
			System.out.print(i +  " ");
	}
}