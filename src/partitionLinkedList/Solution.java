package partitionLinkedList;


 class ListNode {
    public int value;
    public ListNode next;
    public ListNode(int value) {
      this.value = value;
      next = null;
    }
  }
 
public class Solution {
	public static void main(String[] args){
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(1);
		head = partition(head, 3);
		while(head != null){
			System.out.println(head.value);
			head = head.next;
		}
	}
  public static ListNode partition(ListNode head, int target) {
    // write your solution here
    if(head == null || head.next == null)
      return head;
    
    ListNode dummyHead = new ListNode(0);
    ListNode dummyMid = new ListNode(0);
    ListNode left = dummyHead;
    ListNode right = dummyMid;
    while(head != null){
      if(head.value < target){
       left.next = head;
       left = left.next;
      } else {
        right.next = head;
        right = right.next;
      }
      head = head.next;
    }
    left.next = dummyMid.next;
    right.next = null;
    return dummyHead.next;
  }
}