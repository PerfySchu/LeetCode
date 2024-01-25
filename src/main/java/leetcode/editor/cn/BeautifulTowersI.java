//2024-01-24 10:19:04
//第2865题
//给你一个长度为 n 下标从 0 开始的整数数组 maxHeights 。
//
// 你的任务是在坐标轴上建 n 座塔。第 i 座塔的下标为 i ，高度为 heights[i] 。
//
// 如果以下条件满足，我们称这些塔是 美丽 的：
//
//
// 1 <= heights[i] <= maxHeights[i]
// heights 是一个 山脉 数组。
//
//
// 如果存在下标 i 满足以下条件，那么我们称数组 heights 是一个 山脉 数组：
//
//
// 对于所有 0 < j <= i ，都有 heights[j - 1] <= heights[j]
// 对于所有 i <= k < n - 1 ，都有 heights[k + 1] <= heights[k]
//
//
// 请你返回满足 美丽塔 要求的方案中，高度和的最大值 。
//
//
//
// 示例 1：
//
//
//输入：maxHeights = [5,3,4,1,1]
//输出：13
//解释：和最大的美丽塔方案为 heights = [5,3,3,1,1] ，这是一个美丽塔方案，因为：
//- 1 <= heights[i] <= maxHeights[i]
//- heights 是个山脉数组，峰值在 i = 0 处。
//13 是所有美丽塔方案中的最大高度和。
//
// 示例 2：
//
//
//输入：maxHeights = [6,5,3,9,2,7]
//输出：22
//解释： 和最大的美丽塔方案为 heights = [3,3,3,9,2,2] ，这是一个美丽塔方案，因为：
//- 1 <= heights[i] <= maxHeights[i]
//- heights 是个山脉数组，峰值在 i = 3 处。
//22 是所有美丽塔方案中的最大高度和。
//
// 示例 3：
//
//
//输入：maxHeights = [3,2,5,5,2,3]
//输出：18
//解释：和最大的美丽塔方案为 heights = [2,2,5,5,2,2] ，这是一个美丽塔方案，因为：
//- 1 <= heights[i] <= maxHeights[i]
//- heights 是个山脉数组，最大值在 i = 2 处。
//注意，在这个方案中，i = 3 也是一个峰值。
//18 是所有美丽塔方案中的最大高度和。
//
//
//
//
// 提示：
//
//
// 1 <= n == maxHeights <= 10³
// 1 <= maxHeights[i] <= 10⁹
//
//
// Related Topics 栈 数组 单调栈 👍 27 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BeautifulTowersI{
    public static void main(String[] args){
        Solution solution = new BeautifulTowersI().new Solution();
        System.out.println(solution.maximumSumOfHeights(new ArrayList<>(List.of(5,3,4,1,1))));
        System.out.println(solution.maximumSumOfHeights(new ArrayList<>(List.of(6,5,3,9,2,7))));
        System.out.println(solution.maximumSumOfHeights(new ArrayList<>(List.of(3,2,5,5,2,3))));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long res = 0;
        for (int i = 0; i < n; i++) {
            int pre = maxHeights.get(i);
            long sum = pre;
            for (int j = i - 1; j >= 0; j--) {
                pre = Math.min(pre, maxHeights.get(j));
                sum += pre;
            }
            int suf = maxHeights.get(i);
            for (int j = i+1; j < n; j++) {
                suf = Math.min(suf, maxHeights.get(j));
                sum += suf;
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}