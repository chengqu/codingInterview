package median;
import java.util.*;

public class Solution {
	
	public static void main(String[] args){
		int[] nums1 = {4};
		int[] nums2 = {1,2,3,5};
		System.out.print(findMedianSortedArrays(nums1, nums2));
	}
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null )
            return 0;
        int n = nums1.length + nums2.length;
        Queue<Integer> min = new PriorityQueue<Integer>(n,new Comparator<Integer>(){
            public int compare(Integer x, Integer y){
                return x - y;
            }
        });
        Queue<Integer> max = new PriorityQueue<Integer>(n,new Comparator<Integer>(){
            public int compare(Integer x, Integer y){
                return y - x;
            }
            
        });
        
        for(int i = 0; i < nums1.length; i ++){
            if(min.size() == max.size()){
                if(min.peek() == null || nums1[i] > min.peek()){
                    min.add(nums1[i]);
                } else {
                    max.add(nums1[i]);
                }
            } else if (min.size() > max.size()){
                if(nums1[i] > min.peek()){
                    max.add(min.poll());
                    min.add(nums1[i]);
                } else {
                    max.add(nums1[i]);
                }
            } else {
                if(nums1[i] > min.peek()){
                    min.add(nums1[i]);
                } else {
                    min.add(max.poll());
                    max.add(nums1[i]);
                }
            }
        }
         for(int i = 0; i < nums2.length; i ++){
            if(min.size() == max.size()){
                if(min.peek() == null || nums2[i] > min.peek()){
                    min.add(nums2[i]);
                } else {
                    max.add(nums2[i]);
                }
            } else if (min.size() > max.size()){
                if(nums2[i] > min.peek()){
                    max.add(min.poll());
                    min.add(nums2[i]);
                } else {
                    max.add(nums2[i]);
                }
            } else {
                if(nums2[i] > min.peek()){
                    min.add(nums2[i]);
                } else {
                    min.add(max.poll());
                    max.add(nums2[i]);
                }
            }
        }
        
        if(max.size() == min.size()){
            if(max.peek() == null)
                return 0;
            return (max.peek()+min.peek())/2;
        } else if(max.size() > min.size()){
            return max.peek();
        } else {
            return min.peek();
        }
    }
}
