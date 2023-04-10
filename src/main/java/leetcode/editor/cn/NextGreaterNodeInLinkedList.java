//2023-04-10 10:34:02
//第1019题
//给定一个长度为 n 的链表 head
//
// 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。
//
// 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点
//，设置 answer[i] = 0 。
//
//
//
// 示例 1：
//
//
//
//
//输入：head = [2,1,5]
//输出：[5,5,0]
//
//
// 示例 2：
//
//
//
//
//输入：head = [2,7,4,3,5]
//输出：[7,0,5,5,0]
//
//
//
//
// 提示：
//
//
// 链表中节点数为 n
// 1 <= n <= 10⁴
// 1 <= Node.val <= 10⁹
//
//
// Related Topics 栈 数组 链表 单调栈 👍 264 👎 0

package leetcode.editor.cn;
public class NextGreaterNodeInLinkedList{
    public static void main(String[] args){
        Solution solution = new NextGreaterNodeInLinkedList().new Solution();
    }

    public class ListNode {
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
    public int[] nextLargerNodes(ListNode head) {
        int[] res = new int[10000];
        int i = 0;
        while (head != null) {
            res[i++] = head.val;
            head = head.next;
        }
        int[] ans = new int[i];
        for (int j = 0; j < i; j++) {
            int k = j + 1;
            while (k < i && res[k] <= res[j]) {
                k++;
            }
            if (k == i) {
                ans[j] = 0;
            } else {
                ans[j] = res[k];
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}