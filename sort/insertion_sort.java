package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//²åÈëÅÅĞò
public class insertion_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[10];
		a[0] = 10;
		a[1] = 54;
		a[2] = 9;
		a[3] = 67;
		a[4] = 12;
		a[5] = 19;
		a[6] = 42;
		a[7] = 19;
		a[8] = 8;
		a[9] = 1;
		int[] b = sort(a);
		for(int i : b){
			System.out.println(i);
		}
	}
	private static int[] sort(int[] a){
		int[] b = {a[a.length-1]};
		a = Arrays.copyOfRange(a, 0, a.length-1);
		if(a.length >= 1)
			return sort(a, b);
		else
			return b;
	}
	private static int[] sort(int[] a, int[] b ){
		List<Integer> list = new ArrayList<Integer>();
//		list.add(a[a.length-1]);
		boolean c = false;
		for(int i : b){
			if(!c && i > a[a.length-1]){
				c = true;
				list.add(a[a.length-1]);
				list.add(i);
			}
			else
				list.add(i);
		}
		if(!c){list.add(a[a.length-1]);}
		b = new int[b.length+1];
		int j = 0;
		for(int i : list){
			b[j] = i;
			j++;
		}
		a = Arrays.copyOfRange(a, 0, a.length-1);
		if(a.length >= 1)
			return sort(a, b);
		else
			return b;
	}
}
