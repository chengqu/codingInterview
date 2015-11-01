package allsubsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[] nums = {1,2,3};
    	
    	for(List<Integer> x : s.subsets(nums)){
    		for(Integer y : x){
    			System.out.print(y+" ");
    		}
    		System.out.println();
    	}
    }
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length < 1){
            ans.add(new ArrayList<Integer>());
            return ans;
        }
        List<Integer> subset = new ArrayList<Integer>();
        permute(nums,0,subset);
        return ans;
    }
    
    public void permute(int[]nums, int level, List<Integer> subset){
    	for(Integer x: subset){
    		System.out.print(x);
    	}
    	System.out.println();
        ans.add(new ArrayList<Integer>(subset));
        for(int i = level; i < nums.length; i ++){
            subset.add(nums[i]);
            permute(nums, i+1, subset);
            subset.remove(subset.size()-1);
        }
    }
}