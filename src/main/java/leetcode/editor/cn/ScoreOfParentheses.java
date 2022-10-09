//2022-10-09 09:57:46
//第856题
//给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
//
//
// () 得 1 分。
// AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
// (A) 得 2 * A 分，其中 A 是平衡括号字符串。
//
//
//
//
// 示例 1：
//
// 输入： "()"
//输出： 1
//
//
// 示例 2：
//
// 输入： "(())"
//输出： 2
//
//
// 示例 3：
//
// 输入： "()()"
//输出： 2
//
//
// 示例 4：
//
// 输入： "(()(()))"
//输出： 6
//
//
//
//
// 提示：
//
//
// S 是平衡括号字符串，且只含有 ( 和 ) 。
// 2 <= S.length <= 50
//
//
// Related Topics 栈 字符串 👍 358 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class ScoreOfParentheses{
    public static void main(String[] args){
        Solution solution = new ScoreOfParentheses().new Solution();
        System.out.println(solution.scoreOfParentheses("(()(()))"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (char c : s.toCharArray()) {
            if(c == '('){
                stack.push(0);
            }else{
                int top = stack.peek();
                int count = top == 0 ? 1 : 2*stack.pop();
                stack.pop();
                stack.push(stack.peek() == 0 ? count : count + stack.pop());
            }
        }
        return stack.peek();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}