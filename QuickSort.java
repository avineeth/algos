import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class QuickSort {
    
    //1. shuffle
    //2. partition
    //3. sort
    
    public static int partition(Comparable[] a, int lo, int hi) {
        
        int i= lo;
        int j=hi+1;
        
        while(true) {
            
            while(less(a[++i],a[lo]))
                if(i==hi) break;
				
			while(less(a[lo],a[--j])) 
				if(j==lo) break;
                
            if(i>=j) break;
            exch(a, i, j);
        }
        
        exch(a,lo,j);
		return j;
    }
    
	
	public static void sort(Comparable[] a, int lo, int hi) {		
		
		if(lo >= hi) return;
		
		int part = partition(a, lo, hi);
		sort(a,lo,part-1);
		sort(a, part+1, hi);
		
	}
	//helper functions
    public static boolean less(Comparable a, Comparable b) {
        return (a.compareTo(b) < 0);
    }
    
    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
	
	public static String[] readFile(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		List<String> data = new ArrayList<String>();
		String line = null;
		while((line = br.readLine())!=null) {
			data.add(line);
		}
		
		return data.toArray(new String[]{});
		
	}
	
    public static void main(String[] a) throws IOException{
     
        //String[] val = {"Q", "U", "I", "C", "K", "S","O","R","T"};
		String[] val = readFile("../data/words5-knuth.txt");
        QuickSort.sort(val,0, val.length-1);
        System.out.println(Arrays.asList(val));
    }
}