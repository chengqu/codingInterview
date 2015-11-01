package quicksort;


public class Solution {
	public static void main(String[] arg){
		Solution s = new Solution();
		int[] array = {1,2,3,2,2,3,1,1};
		for(int x :s.quickSort(array)){
			System.out.print(x);
		}
	}
  public int[] quickSort(int[] array) {
    // Write your solution here
    if(array == null || array.length < 2)
      return array;
    sort(array, 0, array.length-1);
    return array;
  }
  public void sort(int[] array, int left, int right){
    if(left < right){
      int pivot = partition(array, left, right);
      sort(array, left, pivot-1);
      sort(array, pivot + 1, right);
    }
  } 
  public int partition(int[] array, int left, int right){
    int pivot = array[left];
    int small = left+1;
    int index = left;
    for(int i = left+1; i <= right; i++){
      if(pivot >= array[i]){
        index = small;
        int temp = array[small];
        array[small++] = array[i];
        array[i] = temp;
      }
    }
    array[left] = array[index];
    array[index] = pivot;
    return index;
  }
}

