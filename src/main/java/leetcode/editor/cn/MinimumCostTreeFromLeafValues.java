//2023-05-31 15:01:25
//第1130题
//给你一个正整数数组 arr，考虑所有满足以下条件的二叉树：
//
//
// 每个节点都有 0 个或是 2 个子节点。
// 数组 arr 中的值与树的中序遍历中每个叶节点的值一一对应。
// 每个非叶节点的值等于其左子树和右子树中叶节点的最大值的乘积。
//
//
// 在所有这样的二叉树中，返回每个非叶节点的值的最小可能总和。这个和的值是一个 32 位整数。
//
// 如果一个节点有 0 个子节点，那么该节点为叶节点。
//
//
//
// 示例 1：
//
//
//输入：arr = [6,2,4]
//输出：32
//解释：有两种可能的树，第一种的非叶节点的总和为 36 ，第二种非叶节点的总和为 32 。
//
//
// 示例 2：
//
//
//输入：arr = [4,11]
//输出：44
//
//
//
//
// 提示：
//
//
// 2 <= arr.length <= 40
// 1 <= arr[i] <= 15
// 答案保证是一个 32 位带符号整数，即小于 2³¹ 。
//
//
// Related Topics 栈 贪心 数组 动态规划 单调栈 👍 338 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MinimumCostTreeFromLeafValues{
    public static void main(String[] args){
        Solution solution = new MinimumCostTreeFromLeafValues().new Solution();
        System.out.println(solution.mctFromLeafValues(new int[]{6,2,4}));
        System.out.println(solution.mctFromLeafValues(new int[]{4,11}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<String, Integer> cache = new HashMap<>();
    public int mctFromLeafValues(int[] arr) {
        return dfs(arr, 0, arr.length - 1);
    }

    private int dfs(int[] arr, int left, int right) {
        if (cache.containsKey(left+ "," + right)) {
            return cache.get(left+ "," + right);
        }
        if (left == right) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int i = left; i < right; i++) {
            int leftMax = 0;
            for (int j = left; j <= i; j++) {
                leftMax = Math.max(leftMax, arr[j]);
            }
            int rightMax = 0;
            for (int j = i + 1; j <= right; j++) {
                rightMax = Math.max(rightMax, arr[j]);
            }
            res = Math.min(res, leftMax * rightMax + dfs(arr, left, i) + dfs(arr, i + 1, right));
        }
        cache.put(left+ "," + right, res);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}