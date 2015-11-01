package allanagrams;
import java.util.*;

public class Solution {
	public static Set<String> set = new HashSet<String>();
	public static void main(String[] args){
		List<Integer> ans = allAnagrams("abc","bacbabc");
		for(Integer a : ans){
			System.out.print(a);
		}
	}
  public static List<Integer> allAnagrams(String s, String l) {
    // Write your solution here.
    List<Integer> ans = new ArrayList<Integer>();
    
    if(s == null || s.length() < 1 || l == null || l.length() < 1)
      return ans;
    StringBuilder sb = new StringBuilder();
    char[] sarray = s.toCharArray();
    permute(sarray,sb,0);
    for(int i = 0; i < l.length() - s.length()+1; i++){
      if(set.contains(l.substring(i,i+s.length()))){
        ans.add(i);
      }
    }
    return ans;
  }
  public static void permute(char[] l, StringBuilder sb, int level){
    if(sb.length() == l.length){
      set.add(sb.toString());
      return;
    }
    for(int i = level; i < l.length; i++){
      swap(i,level,l);
      permute(l,sb.append(l[i]),level+1);
      swap(i,level,l);
    }
  }
  public static void swap(int i, int j, char[] l){
    char temp = l[i];
    l[i] = l[j];
    l[j] = temp;
  }
}
