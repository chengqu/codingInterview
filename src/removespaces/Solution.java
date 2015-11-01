package removespaces;

public class Solution {
		public static void main(String[] args){
			System.out.print(removeSpaces(" a "));
		}
		public static String removeSpaces(String input) {
		    // Write your solution here.
		    if(input == null || input.length() < 1)
		      return input;
		    int i = 0;
		    char[] array = input.toCharArray();
		    while(i < array.length && array[i] == ' '){
		      i++;
		    }
		    if(i >= array.length){
        return "";			   
		    }
		    int start = i;
		    int end = 0;
		    int j = i;
		    int count = 0;
		    while(j < array.length){
		      if(array[j] != ' '){
		    	  count = 0;
		        char temp = array[j];
		        array[j] = array[i];
		        array[i] = temp;
		        end = i;
		        j++; i++;
		      } else if(count == 0){
		        j++;
		        i++;
		        count++;
		      } else {
		        j++;
		      }
		    }
		     return new String(array, start, end);
		  }
	}
