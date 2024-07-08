//2024-07-08 10:18:39
//第面试题 16.05题
//设计一个算法，算出 n 阶乘有多少个尾随零。
//
// 示例 1:
//
// 输入: 3
//输出: 0
//解释: 3! = 6, 尾数中没有零。
//
// 示例 2:
//
// 输入: 5
//输出: 1
//解释: 5! = 120, 尾数中有 1 个零.
//
// 说明: 你算法的时间复杂度应为 O(log n) 。
//
// Related Topics 数学 👍 101 👎 0

package leetcode.editor.cn;
public class FactorialZerosLcci{
    public static void main(String[] args){
        Solution solution = new FactorialZerosLcci().new Solution();
        System.out.println(solution.trailingZeroes(3));
        System.out.println(solution.trailingZeroes(5));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trailingZeroes(int n) {
        int ans = 0;
        while(n != 0){
            n /=5;
            ans += n;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}