package dedup;

import java.util.*;
public class Solution {
	public static void main(String[] args){
		System.out.print(deDup("abc"));
	}
  public static String deDup(String input) {
    // write your solution here
    if(input == null || input.length() < 2)
      return input;
      
    Stack<Character> stack = new Stack<Character>();
    
    
    for(int i = 0; i < input.length(); i++){
      if(stack.isEmpty()){
        stack.push(input.charAt(i));
        continue;
      }
      if(stack.peek() != input.charAt(i)){
        stack.push(input.charAt(i));
      } else {
        stack.pop();
      }
    }
    String ans = "";
    while(!stack.isEmpty()){
      ans = stack.pop() + ans;
    }
    return ans;
  }
}

