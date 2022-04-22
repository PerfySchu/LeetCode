//2022-04-22 09:10:48
//第396题
//给定一个长度为 n 的整数数组 nums 。
//
// 假设 arrk 是数组 nums 顺时针旋转 k 个位置后的数组，我们定义 nums 的 旋转函数 F 为：
//
//
// F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1]
//
//
// 返回 F(0), F(1), ..., F(n-1)中的最大值 。
//
// 生成的测试用例让答案符合 32 位 整数。
//
//
//
// 示例 1:
//
//
//输入: nums = [4,3,2,6]
//输出: 26
//解释:
//F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
//F(1) = (1 * 4) + (2 * 3) + (3 * 2) + (0 * 6) = 0 + 4 + 6 + 6 = 16
//F(2) = (2 * 4) + (3 * 3) + (0 * 2) + (1 * 6) = 0 + 6 + 8 + 9 = 23
//F(3) = (3 * 4) + (0 * 3) + (1 * 2) + (2 * 6) = 0 + 2 + 12 + 12 = 26
//
//F(1)-F(0) = 1*4 + 1*3 + 1*2 - 3*6
//F(2)-F(1) = 1*4 + 1*3 - 3*2 + 1*6
//设数组各元素之和为 C， 数组长度为 N
//则有 F(n) - F(n-1) = C - N*(arr(N-n+1))



//所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26 。
//
//
// 示例 2:
//
//
//输入: nums = [100]
//输出: 0
//
//
//
//
// 提示:
//
//
// n == nums.length
// 1 <= n <= 10⁵
// -100 <= nums[i] <= 100
//
// Related Topics 数组 数学 动态规划 👍 120 👎 0

package leetcode.editor.cn;
public class RotateFunction{
    public static void main(String[] args){
        Solution solution = new RotateFunction().new Solution();
        System.out.println(solution.maxRotateFunction(new int[]{4,3,2,6}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxRotateFunction(int[] nums) {
        int N = nums.length;
        int sum = 0;
        int fn = 0;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
            fn += (i * nums[i]);
        }
        int ans = fn;
        for (int i = 1; i < N; i++) {
            fn = fn + sum - N*nums[N-i];
            ans = Math.max(ans, fn);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}