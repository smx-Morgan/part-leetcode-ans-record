public class homework066 {
    public static void main(String[] args) {
        int[] a = new int[2];
        a[0] = 8;
        a[1] = 9;
        int[] test_sl = Solution.plusOne(a);
        for (int i = 0; i < test_sl.length; i++) {
            System.out.println(test_sl[i]);
        }
    }

}
class Solution {
    public static int[] plusOne(int[] digits) {
        int last = digits[digits.length - 1];
        if(last != 9 ){
            last = last +1;
            digits[digits.length - 1] = last;
            return digits;
        }else{
            int[] arr = new int[digits.length+1];
            for(int i = digits.length-1; i >= 0;i--){
                if (digits[i] < 9) {
                    digits[i] = digits[i] + 1;
                    return digits;
                } else {
                    digits[i] = 0;
                    continue;
                }
            }
            arr[0] = 1;
            return arr;
        }
    }
}
class Solution021{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //定义一个虚拟头节点
        ListNode dummyHead = new ListNode();
        dummyHead.next = l1;
        ListNode cur1 = dummyHead;
        //遍历l2的辅助节点
        ListNode cur2 = l2;
        //记录l2的下一位
        ListNode next = null;
        //遍历合并两个链表
        while (cur2 != null){
            //l1链表的最大值比l2链表小(包括了空链表的情况)
            if (cur1.next == null && cur2 != null){
                cur1.next = cur2;
                break;
            }
            if (cur1.next.val < cur2.val){
                cur1 = cur1.next;
            }else {
                next = cur2.next;
                cur2.next = cur1.next;
                cur1.next = cur2;
                cur2 = next;
            }
        }
        return dummyHead.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }