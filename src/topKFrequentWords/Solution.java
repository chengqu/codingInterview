package topKFrequentWords;

import java.util.*;


public class Solution {
	public static void main(String[] args){
		String[] combo = {"a","a","b"};
		int k = 2;
		String[] ans = topKFrequent(combo, k);
		for(String a : ans)
		System.out.print(a); 
	}
  public static String[] topKFrequent(String[] combo, int k) {
    // Write your solution here.
    if(combo == null || combo.length < 1 || k < 1)
      return combo;
      
    Map<String, Integer> map = new HashMap<>();
    PriorityQueue<Map.Entry> queue = new PriorityQueue<Map.Entry>(k,new Comparator<Map.Entry>(){
      public int compare(Map.Entry x, Map.Entry y){
        return ((int)x.getValue() - (int)y.getValue());
      }
    });
    String[] ans = new String[k];
    
    for(int i = 0; i < combo.length; i++){
      if(!map.containsKey(combo[i])){
        map.put(combo[i],1);
      } else {
        map.put(combo[i],map.get(combo[i])+1);
      }
    }
    
    if(k >= map.size()){
      for(Map.Entry entry: map.entrySet()){
       queue.add(entry);
      }
    } else { 
    for(Map.Entry entry: map.entrySet()){
      if(queue.size() == k){
        if((int)queue.peek().getValue() <= (int)entry.getValue()){
          queue.add(entry);
          queue.poll();
        }
      } else {
        queue.add(entry);
      }
    }
    }
    for(int i = k-1; i >= 0; i--){
      ans[i] = (String)queue.poll().getKey();
    }
    return ans;
    
  }

}