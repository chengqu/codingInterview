package removetraillingspaces;

public class Solution {
	public static void main(String[] args){
		String input = "ILove Yahoo";
		System.out.print(removeSpaces(input));
	}
	  public static String removeSpaces(String input) {
	    // Write your solution here.
	    if(input == null || input.length() < 1)
	      return input;
	    char[] str = input.toCharArray();
	    int i = 0;
	    int start = 0;
	    int count = 0;
	   
	    while(start < str.length && str[start] == ' '){
	      start++;
	    }
	    int j = start + 1;
	    
	    while(j < str.length){
	      if(str[j] == ' '){
	        if(count >= 1){
	          j++;
	        } else {
	          count ++;
	          i++;
	        }
	      } else {
	        count = 0;
	        str[++i] = str[j++];
	      }
	    }
	    return new String(str, start , i+1);
	  }
	}