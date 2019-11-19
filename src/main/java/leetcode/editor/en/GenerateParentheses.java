//
//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
// 
//
// 
//For example, given n = 3, a solution set is:
// 
// 
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// Related Topics String Backtracking
package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses{
    public static void main(String[] args){
        Solution solution = new GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(3));
    }


    /**
     * 拿到这题目，第一想法就是暴力解法，
     * 因为之前有做过一个括号匹配的题目
     * 那么暴力解法即先列举出所有可能组合，然后套用之前的括号匹配验证可用的组合
     *
     * 但是，暴力解法毕竟不够优雅，时间复杂度太高
     * 看了一圈大神的解法，其中的回溯-剪枝法(深度优先)比较好理解
     * 对于给定数值，比如2, 即两组括号的组合方式，有如下解法，如图
     *
     *                        （
     *               /                      \
     *              ((                      ()
     *          /        \             /          \
     *       (((        (()         ()(           ())
     *      /  \      /    \       /   \        /    \
     *  ((((  ((()  (()(  (())  ()((  ()()   ())(   ()))
     *   x     x     x     √     x      √     x     x
     *
     * 其中 (()) 和 ()() 是符合要求的
     * 那么该如何在所有可能情况的回溯中剔除掉不合理的分支
     * 1.有个有意思的想法是：假设左括号是 -1，右括号是 1，
     * 因为排列是从左括号开始的，那么在任意时刻，字符串权重之和 >0，则表示出现了不合理的组合（即有多余的右括号出现了）
     * 2.当回溯到顶了，且权重之和不为0，也表示组合不合理
     * 综上两条，即可保证回溯结束后得到的字符串都是合理的组合
     */
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrace(result, "", n*2, 0);
        return result;
    }

    public void backtrace(List<String> result, String s,  int length, int curSum){
        if(s.length() == length && curSum == 0){
            result.add(s);
            return;
        }
        // 权重之和>0 || 回溯结束权重不为0，需要剔除的情况
        if(curSum > 0 || curSum!=0 && s.length()==length){
            return ;
        }
        backtrace(result, s+"(", length, curSum-1);
        backtrace(result, s+")", length, curSum+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
