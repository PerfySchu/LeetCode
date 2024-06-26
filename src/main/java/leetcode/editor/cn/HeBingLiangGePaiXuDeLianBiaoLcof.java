//2024-04-15 09:09:44
//第LCR 142题
//给定两个以 有序链表 形式记录的训练计划 l1、l2，分别记录了两套核心肌群训练项目编号，请合并这两个训练计划，按训练项目编号 升序 记录于链表并返回。
//
// 注意：新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例 1：
//
//
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
//
// 示例 2：
//
//
//输入：l1 = [], l2 = []
//输出：[]
//
// 示例 3：
//
//
//输入：l1 = [], l2 = [0]
//输出：[0]
//
//
//
// 提示：
//
// 0 <= 链表长度 <= 1000
//
//
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
//
//
//
// Related Topics 递归 链表 👍 389 👎 0

package leetcode.editor.cn;
public class HeBingLiangGePaiXuDeLianBiaoLcof{
    public static void main(String[] args){
        Solution solution = new HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();
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
    public ListNode trainningPlan(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 ==  null){
            return l1;
        }
        if(l1.val <= l2.val){
            l1.next = trainningPlan(l1.next, l2);
            return l1;
        }else {
            l2.next = trainningPlan(l1, l2.next);
            return l2;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}