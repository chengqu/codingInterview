package removecertainchar;

public class Solution {
	  public static void main(String[] args){
		  System.out.print(remove("ababcab","gc"));
	  }
	  public static String remove(String input, String t) {
	    // Write your solution here.
	    if(input == null || input.length() < 1)
	    return input;
	    if(t == null || t.length() < 1)
	    return input;
	    char[] s = input.toCharArray();
	    char[] r = t.toCharArray();
	    
	    replace(s,r);
	    return removespace(s);
	  
	  }
	  public static void replace(char[] input, char[] t){
	    for(int i = 0; i < t.length; i++){
	      for(int j = 0; j < input.length; j++){
	        if(input[j] == t[i])
	          input[j] = ' ';
	      }
	    }
	  }
	  public static String removespace(char[] input){
	    int slow = 0;
	    int fast = 0;
	    while(fast < input.length && input[fast] == ' '){
	      fast++;
	    }
	    if(fast >= input.length){
	      return "";
	    }
	    int start = fast;
	    int end = 0;
	    slow = fast;
	    while(fast < input.length){
	      if(input[fast] == ' '){
	        fast++;
	      } else {
	    	  end = slow;
	        input[slow++] = input[fast++];
	      }
	    }
	    return new String(input, start, end);
	  }
	}