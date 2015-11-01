package combofcoins;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<List<Integer>> ans = new ArrayList<List<Integer>>();
	public static void main(String[] args){
		Solution s = new Solution();
		int[] coins = {5,2,1};
		int target = 11;
		for(List<Integer> x:s.combinations(target, coins)){
			for(Integer y:x){
				System.out.print(y);
			}
			System.out.println();
		}
	}
	  public List<List<Integer>> combinations(int target, int[] coins) {
	    // write your solution here
	    List<Integer> comb = new ArrayList<Integer>();
	    for(int i = 0; i < coins.length; i++){
	      comb.add(0);
	    }
	    
	    if(target <= 0 || coins == null || coins.length < 1){
	      ans.add(comb);
	      return ans;
	    }
	    
	    permute(target,coins,0,comb);
	    return ans;
	  }
	  
	  public void permute(int target, int[] coins, int level, List<Integer> comb){
	    if(level == coins.length){
	      if(target == 0){
	    	  
	        ans.add(new ArrayList<Integer>(comb));
	      }
	      return;
	    }
	    int n = 0;
	    while((target - n * coins[level]) >= 0){
	      comb.set(level,comb.get(level)+n);
	      permute(target-n * coins[level], coins, level+1, comb);
	      comb.set(level,comb.get(level)-n);
	      n++;
	    }
	  }
	}