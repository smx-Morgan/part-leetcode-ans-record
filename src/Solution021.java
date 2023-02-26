public class Solution021{
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
