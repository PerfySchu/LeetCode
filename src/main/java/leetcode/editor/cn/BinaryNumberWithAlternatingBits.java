//2022-03-28 09:16:57
//第693题
//给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
//
//
//
// 示例 1：
//
//
//输入：n = 5
//输出：true
//解释：5 的二进制表示是：101
//
//
// 示例 2：
//
//
//输入：n = 7
//输出：false
//解释：7 的二进制表示是：111.
//
// 示例 3：
//
//
//输入：n = 11
//输出：false
//解释：11 的二进制表示是：1011.
//
//
//
// 提示：
//
//
// 1 <= n <= 2³¹ - 1
//
// Related Topics 位运算 👍 133 👎 0

package leetcode.editor.cn;
public class BinaryNumberWithAlternatingBits{
    public static void main(String[] args){
        Solution solution = new BinaryNumberWithAlternatingBits().new Solution();
        System.out.println(solution.hasAlternatingBits(5));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean hasAlternatingBits(int n) {
        int a = n ^ (n>>1);
        return (a & (a+1)) == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}