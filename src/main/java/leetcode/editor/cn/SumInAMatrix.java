//2023-07-04 10:19:11
//第2679题
//给你一个下标从 0 开始的二维整数数组 nums 。一开始你的分数为 0 。你需要执行以下操作直到矩阵变为空：
//
//
// 矩阵中每一行选取最大的一个数，并删除它。如果一行中有多个最大的数，选择任意一个并删除。
// 在步骤 1 删除的所有数字中找到最大的一个数字，将它添加到你的 分数 中。
//
//
// 请你返回最后的 分数 。
//
//
//
// 示例 1：
//
//
//输入：nums = [[7,2,1],[6,4,2],[6,5,3],[3,2,1]]
//输出：15
//解释：第一步操作中，我们删除 7 ，6 ，6 和 3 ，将分数增加 7 。下一步操作中，删除 2 ，4 ，5 和 2 ，将分数增加 5 。最后删除 1 ，2
// ，3 和 1 ，将分数增加 3 。所以总得分为 7 + 5 + 3 = 15 。
//
//
// 示例 2：
//
//
//输入：nums = [[1]]
//输出：1
//解释：我们删除 1 并将分数增加 1 ，所以返回 1 。
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 300
// 1 <= nums[i].length <= 500
// 0 <= nums[i][j] <= 10³
//
//
// Related Topics 数组 矩阵 排序 模拟 堆（优先队列） 👍 28 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class SumInAMatrix{
    public static void main(String[] args){
        Solution solution = new SumInAMatrix().new Solution();
        System.out.println(solution.matrixSum(new int[][]{{7,2,1},{6,4,2},{6,5,3},{3,2,1}}));
        System.out.println(solution.matrixSum(new int[][]{{1}}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int matrixSum(int[][] nums) {
        for (int[] num : nums) {
            Arrays.sort(num);
        }
        int ans = 0;
        for (int i = 0; i < nums[0].length; i++) {
            int max = nums[0][i];
            for (int j = 1; j < nums.length; j++) {
                max = Math.max(max, nums[j][i]);
            }
            ans += max;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}