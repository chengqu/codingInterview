package reverseLinkedListBetween;



   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 
public class Solution {
	public static void main(String args[]){
		Solution s = new Solution();
		ListNode head = new ListNode(1);
		ListNode runner = head;
		System.out.print("1,");
		for(int i = 2; i < 3; i++){
			runner.next = new ListNode(i);
			runner = runner.next;
			System.out.print(i+",");
		}
		System.out.println();
		ListNode newHead = s.reverseBetween(head,1,2);
		while(newHead != null){
			System.out.print(newHead.val + ",");
			newHead = newHead.next;
		}
	}
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m < 1 || m > n){
            return null;
        }
        if(head == null || head.next == null || m == n){
            return head;
        }
        ListNode dummyHead = head;
        ListNode start = head;
        ListNode end = head;
        ListNode left = null;
        ListNode right = null;
        while(m > 1 && start != null){
            left = start;
            start = start.next;
            m--;
        }
        
        while(n > 1 && end != null){
            end = end.next;
            right = end.next;
            n--;
        }
        reverse(start, end);
        start.next = right;
        
        if(left != null){
            left.next = end;
        } else {
        	return end;
        }
        return dummyHead;
    }
    
    public void reverse(ListNode head, ListNode end){
        ListNode prev = null;
        while(head != end){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            
        }
        end.next = prev;
    }
}
