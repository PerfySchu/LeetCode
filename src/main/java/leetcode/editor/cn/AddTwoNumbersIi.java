//2023-07-03 09:47:42
//第445题
//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
//
//
//
// 示例1：
//
//
//
//
//输入：l1 = [7,2,4,3], l2 = [5,6,4]
//输出：[7,8,0,7]
//
//
// 示例2：
//
//
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[8,0,7]
//
//
// 示例3：
//
//
//输入：l1 = [0], l2 = [0]
//输出：[0]
//
//
//
//
// 提示：
//
//
// 链表的长度范围为 [1, 100]
// 0 <= node.val <= 9
// 输入数据保证链表代表的数字无前导 0
//
//
//
//
// 进阶：如果输入链表不能翻转该如何解决？
//
// Related Topics 栈 链表 数学 👍 619 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class AddTwoNumbersIi{
    public static void main(String[] args){
        ListNode l1V3 = new AddTwoNumbersIi().new ListNode(3);
        ListNode l1V4 = new AddTwoNumbersIi().new ListNode(4, l1V3);
        ListNode l1V2 = new AddTwoNumbersIi().new ListNode(2, l1V4);
        ListNode l1 = new AddTwoNumbersIi().new ListNode(7, l1V2);
        ListNode l2V4 = new AddTwoNumbersIi().new ListNode(4);
        ListNode l2V6 = new AddTwoNumbersIi().new ListNode(6, l2V4);
        ListNode l2 = new AddTwoNumbersIi().new ListNode(5, l2V6);
        Solution solution = new AddTwoNumbersIi().new Solution();
        System.out.println(solution.addTwoNumbers(l1, l2));
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        while(l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode head = null;
        while(!stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
            int sum = carry;
            sum += stack1.isEmpty() ? 0 : stack1.pop();
            sum += stack2.isEmpty() ? 0 : stack2.pop();
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            carry = sum / 10;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}