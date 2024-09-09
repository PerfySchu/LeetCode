//2024-09-09 11:02:49
//第2181题
//给你一个链表的头节点 head ，该链表包含由 0 分隔开的一连串整数。链表的 开端 和 末尾 的节点都满足 Node.val == 0 。
//
// 对于每两个相邻的 0 ，请你将它们之间的所有节点合并成一个节点，其值是所有已合并节点的值之和。然后将所有 0 移除，修改后的链表不应该含有任何 0 。
//
// 返回修改后链表的头节点 head 。
//
//
//
// 示例 1：
//
//
//输入：head = [0,3,1,0,4,5,2,0]
//输出：[4,11]
//解释：
//上图表示输入的链表。修改后的链表包含：
//- 标记为绿色的节点之和：3 + 1 = 4
//- 标记为红色的节点之和：4 + 5 + 2 = 11
//
//
// 示例 2：
//
//
//输入：head = [0,1,0,3,0,2,2,0]
//输出：[1,3,4]
//解释：
//上图表示输入的链表。修改后的链表包含：
//- 标记为绿色的节点之和：1 = 1
//- 标记为红色的节点之和：3 = 3
//- 标记为黄色的节点之和：2 + 2 = 4
//
//
//
//
// 提示：
//
//
// 列表中的节点数目在范围 [3, 2 * 10⁵] 内
// 0 <= Node.val <= 1000
// 不 存在连续两个 Node.val == 0 的节点
// 链表的 开端 和 末尾 节点都满足 Node.val == 0
//
//
// Related Topics 链表 模拟 👍 47 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class MergeNodesInBetweenZeros{
    public static void main(String[] args){
        Solution solution = new MergeNodesInBetweenZeros().new Solution();
        ListNode node7 = new ListNode(0);
        ListNode node6 = new ListNode(2, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(0, node4);
        ListNode node2 = new ListNode(1, node3);
        ListNode node1 = new ListNode(3, node2);
        ListNode root = new ListNode(0, node1);
        root = solution.mergeNodes(root);
        while(root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode vHead = new ListNode(0);
        ListNode ansHead = vHead;
        int sum = 0;
        while (head!= null) {
            if(head.val == 0) {
                if(sum!= 0) {
                    head.val = sum;
                    vHead.next = head;
                    vHead = vHead.next;
                    sum = 0;
                }else{
                    sum += head.val;
                }
            }else {
                sum += head.val;
            }
            head = head.next;
        }
        return ansHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}