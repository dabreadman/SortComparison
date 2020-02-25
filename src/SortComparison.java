import java.util.Arrays;

// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author	Yi Xiang Tan a.k.a dabreadman
 *  @version HT 2020
 */

class SortComparison {

	/**
	 * Sorts an array of doubles using InsertionSort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order.
	 *
	 */
	static double [] insertionSort (double a[]){
		//select
		for (int i=1; i<a.length;i++) {
			int index=i;
			//swap to right location
			while(a[index]<a[index-1]) {
				swap(a,index,index-1);
				index--;
				if(index==0) break;
			}
		}
		return a;
	}

	/**
	 * Sorts an array of doubles using Selection Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double [] selectionSort (double a[]){
		//outer for loop
		for(int i=0; i<a.length;i++) {
			double min = a[i];
			int index = i;
			//find min
			for(int j=i+1;j<a.length;j++) {
				if(a[j]<min) {
					min = a[j];
					index = j;
				}
			}
			//swap elements
			swap(a,index,i);
		}
		return a;
	}

	/**
	 * Sorts an array of doubles using Quick Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double [] quickSort (double a[]){

		quickSort(a,0,a.length-1); 
		return a;
	}

	static void quickSort(double a[],int i, int j) {
		//one element left
		if(j-i<1) return;
		double pivot = a[j];
		int left = i;
		int right = j-1;
		boolean leftMatch = false;
		boolean rightMatch = false;

		while(true) {
			//find left item
			while(left<j &&!leftMatch) {
				if(a[left]>pivot)
					leftMatch = true;
				else
					left++;
			}

			//pivot is largest
			if(!leftMatch)
				break;

			//find right item
			while(right>=i && !rightMatch) {
				if(a[right]<pivot)
					rightMatch = true;
				else
					right--;
			}

			//pivot is smallest
			if(!rightMatch) {
				left = i;
				break;
			}

			//if both found match
			if(leftMatch && rightMatch) {
				//if crossed
				if(left>right)
					break;
				else {
					swap(a,left,right);
					leftMatch = false;
					rightMatch = false;
				}
			}
		}

		//swap pivot with left item
		swap(a,left,j);

		quickSort(a,i,left-1);
		quickSort(a,left+1,j);
	}
	/**
	 * Sorts an array of doubles using Merge Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	/**
	 * Sorts an array of doubles using iterative implementation of Merge Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a: An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted order.
	 */

	static double[] mergeSortIterative (double a[]) {
		sortIterative(a);
		return a;
	}

	 static void sortIterative(double[] a) {
		int len = a.length;
		double[] aux = new double[len];
		//bottom up
		for(int size = 1; size<len; size*=2) {
			//merge from bottom
			for(int left = 0; left<len-size; left+=2*size) {
				merge(a, aux, left, left+size-1,(left+2*size-1<len-1? left+2*size-1:len-1));
			}
		}
		
	}

	/**
	 * Sorts an array of doubles using recursive implementation of Merge Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a: An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted order.
	 */
	static double[] mergeSortRecursive (double a[]) {
		sort(a,new double[a.length], 0,a.length-1);
		return a;
	}
	
	static void sort(double[]a, double[]aux, int i, int j) {
		if(j<=i) return;
		int mid = i + (j-i)/2;
		//recursively calling sort
		sort(a, aux, i, mid);
		sort(a, aux, mid+1, j);
		//merging two sorted partition
		merge(a, aux, i, mid, j);
	}
	
	static void merge(double[]a, double[]aux, int i, int mid, int j) {
		//copies element into aux array
		for(int k=i; k<=j; k++) {
			aux[k] = a[k];
		}
		int left = i;
		int right = mid+1;
		//go through all elements in partition
		for(int k=left; k<=j; k++) {
			//left partition finished
			if(left>mid)	
				a[k] = aux[right++];
			//right partition finished
			else if(right>j)
				a[k] = aux[left++];
			//right element smaller
			else if(aux[right]<aux[left])
				a[k] = aux[right++];
			//left element smaller
			else
				a[k] = aux[left++];
		}
	}

	/**
	 * Swap two element of a double array given the indexes.
	 * @param a: an array of doubles.
	 * @param index1: index of element to be sorted.
	 * @param index2: index of another element to be sorted.
	 */
	static void swap (double a[], int index1, int index2) {
		double temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}

	/**
	 * Check if a double array is sorted.
	 * @param a: the array to be checked.
	 * @return 1 if sorted, 0 if not.
	 */
	static boolean isSorted(double a[]) {
		for(int i=0;i<a.length-1;i++) {
			if(a[i]>a[i+1]) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println("hello");
		double a[] = new double[] {1,2,3,4,5,6,7,8,9,10,-1,-1,-1,-1,-1,-1,-1};
		long start = System.currentTimeMillis();
		System.out.println(Arrays.toString(a));
		mergeSortIterative(a);
		System.out.println(Arrays.toString(a));
		long end = System.currentTimeMillis();
		System.out.println(end - start + "ns");
		System.out.println(isSorted(a));
	}

}

