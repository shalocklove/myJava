//√∞≈›≈≈–Ú
package sort;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bubble_sort {

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
		for(int i: a){
			System.out.println(i);
		}
		sort(a, a.length-1);
		System.out.println("_________________");
		for(int i: a){
			System.out.println(i);
		}
	}
	private static void sort(int[] a, int i){
		int x, y, j;
		for(x = 0; x <= i; x++){
			if(a[0] < a[x]){
				j = a[0];
				a[0] = a[x];
				a[x] = j;
			}
			j = a[0];
			a[0] = a[i];
			a[i] = j;
		}
		if(i - 1 > 0)
			sort(a, i - 1);
	}
}
