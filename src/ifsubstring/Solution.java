package ifsubstring;


public class Solution {
	public static void main(String[] args){
		System.out.print(strstr("bcabc","ab"));
	}
  public static int strstr(String large, String small) {
    // write your solution here
    if(large == null || large.length() < 1 || small == null || small.length() < 1)
      return 0;
    
    int count = 1;
    for(int i = 0; i < large.length(); i++){
      if(large.charAt(i) == small.charAt(0)){
        for(int j = 1; j < small.length(); j++){
          if(large.charAt(i+j) != small.charAt(j)){
            count = 1;
            break;
          }
          else 
            count++;
        }
      }
      if(count == small.length()){
        return i;
      }
    }
    return 0;
  }
}

