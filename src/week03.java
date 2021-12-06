import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class week03 {
}
class Solution023 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }
    private ListNode merge(ListNode[] lists,int left,int right){
        if(left == right) return lists[left];
        int mid = left +(right - left) / 2;
        ListNode l1 = merge(lists,left,mid);
        ListNode l2 = merge(lists,mid+1,right);
        return mergeTwoLists(l1 , l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val<l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] lists = new ArrayList[numCourses];
        int[] points = new int[numCourses];
        for(int[] p : prerequisites){
            points[p[0]]++;
            if(lists[p[1]] == null){
                lists[p[1]] = new ArrayList<>();
            }
            lists[p[1]].add(p[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            //入度为 0，添加到队列中
            if(points[i] == 0){
                queue.add(i);
            }
        }
        int[] res = new int[numCourses];
        int idx = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int p = queue.poll();
                res[idx++] = p;
                List<Integer> list = lists[p];
                if(list == null){
                    continue;
                }
                for(int val : list){
                    points[val]--;
                    if(points[val] == 0){
                        queue.add(val);
                    }
                }
            }
        }
        return idx == numCourses ? res : new int[0];
    }
}

