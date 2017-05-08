import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
/*
4-SUM. Given an array a[] of n integers, the 4-SUM problem is to determine
 if there exist distinct indices i, j, k, and l such that a[i]+a[j]=a[k]+a[l].
Design an algorithm for the 4-SUM problem that takes time proportional to n2 (under suitable technical assumptions).
*/
public class FourSum {

	public static void main(String[] args) {
		int[] arr= {12, 3, 4, 1, 6, 9};
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(foursome(arr)));
		
	}
	
	public static int[] foursome(int[] arr) {
		int[] ret = new int[4];
		
		Map<Integer,int[]> twosum = new HashMap<>();
		for(int i=0; i< arr.length-1; i++)
			for(int j=i+1; j< arr.length; j++) {
				int[] index = {i,j};
				int sum = arr[i]+arr[j];
				//System.out.println("i=["+i +"] j=["+j +"] Sum["+sum+"]"); 	
				if(twosum.containsKey(sum)) {
					int[] val = twosum.get(sum);
					ret[0] = arr[val[0]];
					ret[1] = arr[val[1]];
					ret[2] = arr[i];
					ret[3] = arr[j];
					return ret;
				}				
				twosum.put(sum,index);
			}
		
		return ret;
		
	}
}