package coding.edu.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayChallange {
	
	public static void main(String[] args) {
		
//		System.out.println(findFirstUnique(new int[]{4,4,4,3}));
//		System.out.println(findFirstUnique(new int[]{4,5,1,2,0,4}));
//		
//		System.out.println(findFirstUnique1(new int[]{4,4,4,3}));
//		System.out.println(findFirstUnique1(new int[]{4,5,1,2,0,4}));
		//System.out.println(findSecondMaximum(new int[]{9,2,3,6}));
		//System.out.println(Arrays.toString(rotateArray(new int[] {1,2,3,4,5})));
		//System.out.println(Arrays.toString(reArrange(new int[] {-9,1,2,3,4,-5, -8, 7})));
		
		maxMin(new int[] {1,2,3,4,5,6,7});
	}
	
	public static void maxMin(int[] arr) {
		
		Arrays.sort(arr);
		int[] a2 = new int[arr.length];
		
		boolean s = true;
		int mx = arr.length - 1;
		int mn = 0;
		for (int i=0; i < arr.length; i++) {
			if (s) {
				a2[i] = arr[mx];
				s = false;
				mx--;
			} else {
				a2[i] = arr[mn];
				mn++;
				s = true;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = a2[i];
		}
		System.out.println(Arrays.toString(a2));
	    // Write - Your - Code
	  }
	
	static int[] reArrange(int[] arr) {
		int[] n = new int[arr.length];
		int[] p = new int[arr.length];
		int n_i = 0;
		int p_i = 0;
		//Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				n[n_i] = arr[i];
				n_i++;
			} else {
				p[p_i] = arr[i];
				p_i++;
			}
		}
		
		for (int j = 0; j < arr.length; j++) {
			if (j < n_i) {
				arr[j] = n[j];
			} else {
				arr[j] = p[j - n_i];
			}
		}
		return arr;
	}
	
	static int[] rotateArray(int[] arr) {
		
		int l = arr[arr.length-1];
		
		for (int i = arr.length -1; i > 0; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = l;
		
		return arr;
	}
	
	/*
	 * In this problem, you have to implement the int findFirstUnique(int[] arr)
	 * function that will look for a first unique integer which appears only once in
	 * the whole array.
	 * time complexity : O(n^2)
	 */
	public static int findFirstUnique(int[] arr) {
		boolean dup = false;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (j != i && arr[i] == arr[j]) {
					dup = true;
					continue;
				}
			}
			if(!dup) {
				return arr[i];
			}
			dup = false;
		}
		return 0;
	}
	
	
	public static int findFirstUnique1(int[] arr) {
		Map<Integer, Integer> m = new HashMap<>();
		
		for ( int i = 0; i < arr.length; i++) {
			if (m.get(arr[i]) == null)
				m.put(arr[i], 0);
			else
				m.put(arr[i], m.get(arr[i]) + 1);
				
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (m.get(arr[i]) == 0)
				return arr[i];
		}
		
		return 0;
		
	}
	
	public static int findSecondMaximum(int[] arr) {
		int m1 = Integer.MIN_VALUE;
		int m2 = Integer.MIN_VALUE;
		
		for ( int i = 0; i < arr.length; i++) {
			if (arr[i] > m1) {
				m2 = m1;
				m1 = arr[i];
			}	
			else if(m2 < arr[i]) {
				m2 = arr[i];
			}
		}
		
		return m2;
	}

}
