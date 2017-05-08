import java.util.Arrays;
/*
Find a triplet that sum to a given value
Given an array and a value, find if there is a triplet in array whose sum is equal to the given value.
If there is such a triplet present in array, then print the triplet and return true. Else return false.
For example, if the given array is {12, 3, 4, 1, 6, 9} and given sum is 24, 
then there is a triplet (12, 3 and 9) present in array whose sum is 24.
*/
public class ThreeSum {

	public static void main(String[] args) {
		
		int total = 24;
		int[] arr= {12, 3, 4, 1, 6, 9};
		
		int[] triplet =  nestedloopmethod(arr,total);
		System.out.println(Arrays.toString(triplet));
		int[] arr2 = Arrays.copyOf(arr, arr.length);
		triplet = sortingmethod(arr2,total);
		System.out.println(Arrays.toString(triplet));
	}
	
	/*
	Complexity - O(n^3)
	*/
	public static int[] nestedloopmethod(int[] arr, int total) {
		int[] triplet = new int[3];
		for(int i=0; i<arr.length; i++) 
			for(int j=i+1; j<arr.length; j++)
				for(int k=j+1; k<arr.length; k++) {
					//System.out.println("i=["+i +"] j="+j +"] k="+k+"]"); 
					if( (arr[i]+arr[j]+arr[k]) == total) {
						triplet[0] = arr[i];
						triplet[1] = arr[j];
						triplet[2] = arr[k];
						break;
					}					
				}
				
		return triplet;
	}
	
	public static int[] sortingmethod(int[] arr, int total) {
		int[] triplet = new int[3];
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		for(int i=0; i<arr.length-2; i++) {
			int low = i+1;
			int hi = arr.length -1;
			while(low < hi) {
				int sum = arr[i]+arr[low]+arr[hi];
				//System.out.println("i=["+i +"] low=["+low +"] hi=["+hi+"] -Sum["+sum+"]"); 		
				if(sum<total)	low = low+1;
				else if(sum> total) hi = hi -1;
				else {
					triplet[0] = arr[i];
					triplet[1] = arr[low];
					triplet[2] = arr[hi];
					return triplet;
				}
			}			
		}		
		return triplet;
	}
}