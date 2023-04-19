//2023-04-19 13:49:55
//第1043题
//给你一个整数数组 arr，请你将该数组分隔为长度 最多 为 k 的一些（连续）子数组。分隔完成后，每个子数组的中的所有值都会变为该子数组中的最大值。
//
// 返回将数组分隔变换后能够得到的元素最大和。本题所用到的测试用例会确保答案是一个 32 位整数。
//
//
//
// 示例 1：
//
//
//输入：arr = [1,15,7,9,2,5,10], k = 3
//输出：84
//解释：数组变为 [15,15,15,9,10,10,10]
//
// 示例 2：
//
//
//输入：arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
//输出：83
//
//
// 示例 3：
//
//
//输入：arr = [1], k = 1
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= arr.length <= 500
// 0 <= arr[i] <= 10⁹
// 1 <= k <= arr.length
//
//
// Related Topics 数组 动态规划 👍 211 👎 0

package leetcode.editor.cn;
public class PartitionArrayForMaximumSum{
    public static void main(String[] args){
        Solution solution = new PartitionArrayForMaximumSum().new Solution();
        System.out.println(solution.maxSumAfterPartitioning(new int[]{1,15,7,9,2,5,10}, 3));
        System.out.println(solution.maxSumAfterPartitioning(new int[]{1,4,1,5,7,3,6,1,9,9,3}, 4));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                max = Math.max(max, arr[i - j + 1]);
                dp[i] = Math.max(dp[i], (i >= j ? dp[i - j] : 0) + max * j);
            }
        }
        return dp[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}