package longestunique;
import java.util.*;

public class Solution {
	public static void main(String[] args){
		System.out.print(lengthOfLongestSubstring("abcdef"));
	}
	public static int lengthOfLongestSubstring(String s) {
	    if(s == null || s.length() < 1)
	      return 0;
	      
	    Set<Character> set = new HashSet<Character>();
	    int max = 0;
	    int i = 0;
	    int j = 0;
	    while (i < s.length()){
	      if(!set.contains(s.charAt(i))){
	        set.add(s.charAt(i++));
	      } else {
	        max = Math.max(max, i-j);
	        set.remove(s.charAt(j++));
	      }
	    }
	    max = Math.max(max, i-j);
	    return max;
	  }
}
