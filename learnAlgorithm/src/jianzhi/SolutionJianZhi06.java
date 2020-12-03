package jianzhi;

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SolutionJianZhi06 {

    public int[] reversePrint(ListNode head) {
        if (head==null){
            return new int[]{};
        }
        Stack<Integer> stack=new Stack<>() ;
        while (head.next!=null){
            stack.add(head.val);
            head=head.next;
        }
        Object[] objects = stack.toArray();
        int size = stack.size();
        int[] a= new int[size];
        for (int i = 0; i < size; i++) {
            a[i]=stack.pop();
        }
        return a;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}