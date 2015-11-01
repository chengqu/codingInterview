package mergesort;

public class Solution {
	public static void main(String[] args){
		Solution s = new Solution();
		int[] array = {2,3,4,2,1,2,3,4,5,2,1,2,3,4};
		for(int x :s.mergeSort(array)){
			System.out.print(x);
		}
	}
	  public int[] mergeSort(int[] array) {
	    // Write your solution here.
	    if(array == null || array.length < 2)
	      return array;
	      
	    int[] helper = new int[array.length];
	    sort(array, 0, array.length-1, helper);
	    return array;
	  }
	  
	  public void sort(int[] array, int left, int right, int[] helper){
		  if(left < right){
			int mid = left + (right - left) / 2;
	    	sort(array, left, mid, helper);
	    	sort(array, mid+1,right, helper);
	    	merge(array, left, right,mid, helper);
		  }
	  }
	  
	  public void merge(int[] array, int left, int right,int mid, int[] helper){
	    for(int i = left; i <= right; i++){
	      helper[i] = array[i];
	    }
	    int i = left;
	    int j = mid + 1;
	    int index = left;
	    while(i <= mid && j <= right){
	      if(helper[i] <= helper[j]){
	        array[index] = helper[i++];
	      } else {
	        array[index] = helper[j++];
	      }
	      index ++;
	    }
	    while(i <= mid){
	      array[index++] = helper[i++];
	    }
	    while(j <= right){
	      array[index++] = helper[j++];
	    }
	  }
	}
