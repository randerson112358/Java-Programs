
public class BubbleSort {
  
	int[] array;
	
	public BubbleSort(int [] arr){
		array = arr;
		
		for(int i=0; i< arr.length; i++)
			for(int j =0; j<arr.length; j++)
			{
				if(arr[i] < arr[j])
					array = arr = swap(arr, i,j);
			}
			
		
	}
	
	public int[] swap(int [] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i]= arr[j];
		arr[j] = temp;
		
		return  arr;
	}
	
	public void printSortedList(){
		
		for(int i=0; i<array.length; i++){
			System.out.println(array[i]);
		}
	}
}
