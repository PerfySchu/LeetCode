//2025-02-20 11:18:52
//第2595题
//给你一个 正 整数 n 。
//
// 用 even 表示在 n 的二进制形式（下标从 0 开始）中值为 1 的偶数下标的个数。
//
// 用 odd 表示在 n 的二进制形式（下标从 0 开始）中值为 1 的奇数下标的个数。
//
// 请注意，在数字的二进制表示中，位下标的顺序 从右到左。
//
// 返回整数数组 answer ，其中 answer = [even, odd] 。
//
//
//
// 示例 1：
//
//
// 输入：n = 50
//
//
// 输出：[1,2]
//
// 解释：
//
// 50 的二进制表示是 110010。
//
// 在下标 1，4，5 对应的值为 1。
//
// 示例 2：
//
//
// 输入：n = 2
//
//
// 输出：[0,1]
//
// 解释：
//
// 2 的二进制表示是 10。
//
// 只有下标 1 对应的值为 1。
//
//
//
// 提示：
//
//
// 1 <= n <= 1000
//
//
// Related Topics 位运算 👍 24 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class NumberOfEvenAndOddBits{
    public static void main(String[] args){
        Solution solution = new NumberOfEvenAndOddBits().new Solution();
        System.out.print(Arrays.toString(solution.evenOddBit(50)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] evenOddBit(int n) {
        int[] ans = new int[2];
        int index = 0;
        while (n != 0){
            if (n % 2 == 1){
                ans[index % 2]++;
            }
            index++;
            n /= 2;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}