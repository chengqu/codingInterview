package rainbowsort;


public class Solution {
	public static void main(String[] args){
		Solution s  = new Solution();
		int[] array = {1,-1};
		for(int x : s.rainbowSort(array)){
			System.out.print(x);
		}
	}
  public int[] rainbowSort(int[] array) {
    // Write your solution here
    if(array == null || array.length < 2)
    return array;
    int red = -1;
    int green = 0;
    int blue = 1;
    int i = 0;
    int j = i + 1;
    int end = array.length -1;
    int k = 0;
    while(k < end && j < array.length){
      if(array[k] == red){
        swap(i,k,array);
        j = i+1;
        i++;
      } else if(array[k] == green){
        swap(j,k,array);
        j++;
      } else {
        swap(end, k, array);
        end -- ;
      }
      k++;
    }
    return array;
    
  }
  public void swap(int i, int j, int[] array){
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}

