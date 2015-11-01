package nqueens;

import java.util.ArrayList;
import java.util.List;


public class Solution {
	public static void main(String[] args){
		Solution s = new Solution();
//		List<Integer> comb = new ArrayList<Integer>();
//		comb.add(1);comb.add(3);
//		System.out.print(s.validate(comb, 2,0, 3));
		for(List<Integer> x :s.nqueens(4)){
			for(Integer y:x){
				System.out.print(y);
			}
			System.out.println();
		}
	}
  public List<List<Integer>> nqueens(int n) {
    // write your solution here
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> comb = new ArrayList<Integer>();
    for(int i =0; i < n; i++){
      comb.add(-1);
    }
    if(n <= 0){
      ans.add(new ArrayList<Integer>());
      return ans;
    }
    
    permute(n-1,comb,ans, 0);
    return ans;
  }
  public void permute(int n, List<Integer> comb, List<List<Integer>> ans, int level){
    if(level == n+1){
      ans.add(new ArrayList<Integer>(comb));
      return;
    }
    for(int i = 0; i <= n; i++){
     comb.set(level, i);
     if(validate(comb,level,i,n)){
    	 permute(n,comb,ans,level+1);
     }
    }
  }
  public boolean validate(List<Integer> comb, int x, int y, int size){
    for(int i = 0; i < x; i++){
      if(comb.get(i) == y || comb.get(i) == -1){
        return false;
      }
      int left = y + (x-i);
      int right = y - (x-i);
      if(left <= size && left >= 0){
        if(comb.get(i) == left){
          return false;
        }
      }
      if(right >= 0 && right <= size){
        if(comb.get(i) == right){
          return false;
        }
      }
    }
    return true;
  }
}

