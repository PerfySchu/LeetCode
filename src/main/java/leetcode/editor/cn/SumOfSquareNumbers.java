//2024-11-04 09:45:35
//第633题
//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a² + b² = c 。
//
//
//
// 示例 1：
//
//
//输入：c = 5
//输出：true
//解释：1 * 1 + 2 * 2 = 5
//
//
// 示例 2：
//
//
//输入：c = 3
//输出：false
//
//
//
//
// 提示：
//
//
// 0 <= c <= 2³¹ - 1
//
//
// Related Topics 数学 双指针 二分查找 👍 474 👎 0

package leetcode.editor.cn;
public class SumOfSquareNumbers{
    public static void main(String[] args){
        Solution solution = new SumOfSquareNumbers().new Solution();
        System.out.println(solution.judgeSquareSum(5));
        System.out.println(solution.judgeSquareSum(3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean judgeSquareSum(int c) {
        long left = 0;
        long right = (long) Math.sqrt(c);
        while (left <= right){
            long sum = left * left + right * right;
            if (sum == c){
                return true;
            }else if (sum > c){
                right--;
            }else {
                left++;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}