public class MergeSort{


	public static void mergesort(int [] array){

		mergesort(array, new int[array.length],0,array.length-1);
	}

	/**
	*	Recursive implementation of merge sort algorithm
	**/
	private static void mergesort(int [] array, int [] temp, int startIndex, int endIndex){

		if(startIndex < endIndex){

			int midPoint = (startIndex + endIndex) /2;

			//recursively sort left anf right half of the array
			mergesort(array, temp, startIndex, midPoint-1);
			mergesort(array,temp,midPoint+1,endIndex);

			//merge the sorted right and left half of the array
			merge(array, temp,startIndex,midPoint,endIndex);
		}
	}

	//Merge the left and right half of the array
	private static void merge(int[] array, int [] temp,int startIndex, int midPoint, int endIndex){

		int left =  startIndex;
		int right = midPoint+1;
		int index = startIndex;

		while(left <= midPoint && right <= endIndex){

			if(array[left] <= array[right])
				temp[index++] = array[left++];
			else
				temp[index++] = array[right++];
		}

		System.arraycopy(array,left,temp,index,midPoint-left+1);
		System.arraycopy(array,right,temp,index,endIndex-right+1);
		System.arraycopy(temp,startIndex,array,startIndex,endIndex-startIndex+1);
	}

	//Testing 
	public static void main(String[] args) {
		
		int [] array = {1,20,11,3,5,4,9,12};
		MergeSort.mergesort(array);

		//print array 

		for ( int i : array)
			System.out.print(i +  " ");
	}
}