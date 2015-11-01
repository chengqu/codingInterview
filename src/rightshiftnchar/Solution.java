package rightshiftnchar;

public class Solution {
	public static void main(String[] args){
		System.out.print(rightShift("abcde",2));
	}
	  public static String rightShift(String input, int n) {
	    // Write your solution here.
	    if(input == null || n < 0)
	      return input;
	    StringBuilder sb = new StringBuilder(input);
	    reverse(sb, 0, input.length()-1);
	    reverse(sb,0,n-1);
	    reverse(sb, n, input.length()-1);
	    return sb.toString();
	  }
	  public static void reverse(StringBuilder sb, int i, int j){
	    while(i < j){
	      char temp = sb.charAt(i);
	      sb.setCharAt(i, sb.charAt(j));
	      sb.setCharAt(j, temp);
	      i++;j--;
	    }
	  }
	}
