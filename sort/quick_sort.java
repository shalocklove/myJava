package sort;

import java.util.ArrayList;
import java.util.List;

public class quick_sort {

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
		newsort(a, 0, a.length-1);
		for(int b : a){
			System.out.print(b+"   ");
		}
	}
	private static void sort(int[] a, int i, int j){
		System.out.print(a[i]+"   ");
		List<Integer> big = new ArrayList<Integer>();
		List<Integer> smore = new ArrayList<Integer>();
		int record = a[i];
		for(int r = i+1; r <= j-1; r++){
			if(a[i] > a[r]){
				smore.add(a[r]);
			}
			else{
				big.add(a[r]);
			}
		}
		int change = 0;
		int min = i;
		int max = j;
		for(change = 0; change < smore.size(); min++ ,change++){
			a[min] = smore.get(change);
		}
		a[min] = record;
		for(min++,change = 0; change < big.size();change++, min++){
			a[min] = big.get(change);
		}
		for(int d : a){System.out.print(d+",");}
		System.out.println();
		if(smore.size()> 1)
			sort(a, i, i+smore.size());
		if(big.size() > 1)
			sort(a, j-big.size(), j);
	}
	public static void newsort(int[] a, int left, int right){
		int bd;
		if(left < right){
			bd = change(a, left, right);
			newsort(a, left, bd-1);
			newsort(a, bd+1, right);
		}
	}
	public static int change(int[] a, int left, int right){
		int i = a[left];
		while(left < right){
			while(left < right && a[right] > i)
				right--;
			if(left < right)
				a[left++] = a[right];
			while(left < right && a[left] < i)
				left++;
			if(left < right)
				a[right--] = a[left];
		}
		a[left] = i;
		return left;
	}
}





