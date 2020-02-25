import java.util.Arrays;

// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author
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

		 //todo: implement the sort
    	return null;
    }//end mergesortIterative
    
    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {
    	

    	//todo: implement the sort
    	return null;
   }//end mergeSortRecursive
    	
    

    static void swap (double a[], int index1, int index2) {
    	double temp = a[index1];
    	a[index1] = a[index2];
    	a[index2] = temp;
    }
    
    static boolean isSorted(double a[]) {
    	for(int i=0;i<a.length-1;i++) {
    		if(a[i]>a[i+1]) return false;
    	}
    	return true;
    }
   
    public static void main(String[] args) {
    	System.out.println("hello");
    	double a[] = new double[] {-100,-9,-31314,2377.88,2910.66,8458.14,1522.08,5855.37,1934.75,8106.23,1735.31,4849.83,1518.63,3669.57,4917.36,9100.94,2652.57,8931.88,2203.51,6317.98,5710.77,3321.58,1044.55,5029.31,5673.94,8541.65,401.409,1080.22,6393.96,131.11,7201.84,1018.14,4829.45,2543.55,6766.97,8967.82,7598.96,7202.92,9076.23,9286.11,3776.63,8997.56,7788.8,3242.55,1942.31,9955.53,1612.96,7080.34,5015.19,9363.01,7163.23,1051.9,2092.05,5593.97,7054.32,782.337,5105.3,1961.97,2742.11,6386.02,4482.08,398.718,4672.51,777.565,381.004,1600.44,3978.32,6888.98,5347.12,6869.2,2724.57,4659.33,2765.55,4500.86,9350.69,869.318,4538.89,9456.25,8557.19,1209.76,141.639,2345.15,8663.13,4373.9,7695.48,8740.03,3769.34,9443.28,7984.93,8386.34,9466.56,5860.52,5991.63,3193.47,4211.62,9041.07,1584.62,8351.59,7319.42,4918.37,2121.29,1197.52,483.631,};
    	long start = System.currentTimeMillis();
    	quickSort(a);
    	long end = System.currentTimeMillis();
    	System.out.println(end - start + "ns");
    	System.out.println(isSorted(a));
        //todo: do experiments as per assignment instructions
    }

 }//end class

