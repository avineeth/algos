import java.util.Arrays;

/**
 * Created by Vineeth on 4/16/2017.
 * Divides the dataset into groups of atmost two.
 *
 */
public class MergeSort {


    public static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high) {

        assert(isSorted(a,low,mid));
        assert(isSorted(a,mid+1,high));

        for(int i=low; i<= high; i++) {
            aux[i] = a[i];
        }

        int i= low;
        int j= mid+1;

        for(int k =low; k <= high; k++ ) {
            if(i > mid) a[k] = aux[j++];
            else if(j > high) a[k] = aux[i++];
            else if(less(aux[i],aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }

        assert(isSorted(a,low,high));
    }


    public static void sort(Comparable[] a, Comparable[] aux, int low, int high) {


        if(high <= low) return;

        int mid = low + (high-low)/2;
        //System.out.println("low=" + low + " mid="+mid+ " high="+high);

        sort(a,aux,low, mid);
        sort(a,aux, mid+1, high);
        merge(a,aux,low,mid,high);

    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length-1);

    }
    // helper classes
    public static boolean isSorted(Comparable[] a, int low, int high ) {

        for(int i=high; i> 0; i--) {
            if(less(a[i],a[i-1])) return false;
        }
        return true;
    }

    public static boolean less (Comparable a, Comparable b) {
        return (a.compareTo(b) < 0);

    }

    //test class
    public static void main(String[] args) {

        String[] a = {"Hello", "World", "How", "Do", "You", "Do"};
        sort(a);
        System.out.println(Arrays.asList(a));
    }
}
