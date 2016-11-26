
public class SortMain {

	
	public static void main(String[] args) {
		int[] arr = new int[10];
		
		
		int[] anArray = { 
			    155, 200, 250,
			    400, 90, 60, 
			    900, 850, 90, 1000
			};

		BubbleSort b= new BubbleSort(anArray);
		b.printSortedList();
		//System.out.println(b.returnSortedList());
	}

}
