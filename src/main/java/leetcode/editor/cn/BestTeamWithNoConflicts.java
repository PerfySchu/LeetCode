//2023-03-22 15:09:04
//第1626题
//假设你是球队的经理。对于即将到来的锦标赛，你想组合一支总体得分最高的球队。球队的得分是球队中所有球员的分数 总和 。
//
// 然而，球队中的矛盾会限制球员的发挥，所以必须选出一支 没有矛盾 的球队。如果一名年龄较小球员的分数 严格大于 一名年龄较大的球员，则存在矛盾。同龄球员之间
//不会发生矛盾。
//
// 给你两个列表 scores 和 ages，其中每组 scores[i] 和 ages[i] 表示第 i 名球员的分数和年龄。请你返回 所有可能的无矛盾球队
//中得分最高那支的分数 。
//
//
//
// 示例 1：
//
// 输入：scores = [1,3,5,10,15], ages = [1,2,3,4,5]
//输出：34
//解释：你可以选中所有球员。
//
// 示例 2：
//
// 输入：scores = [4,5,6,5], ages = [2,1,2,1]
//输出：16
//解释：最佳的选择是后 3 名球员。注意，你可以选中多个同龄球员。
//
//
// 示例 3：
//
// 输入：scores = [1,2,3,5], ages = [8,9,10,1]
//输出：6
//解释：最佳的选择是前 3 名球员。
//
//
//
//
// 提示：
//
//
// 1 <= scores.length, ages.length <= 1000
// scores.length == ages.length
// 1 <= scores[i] <= 10⁶
// 1 <= ages[i] <= 1000
//
//
// Related Topics 数组 动态规划 排序 👍 127 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class BestTeamWithNoConflicts{
    public static void main(String[] args){
        Solution solution = new BestTeamWithNoConflicts().new Solution();
        System.out.println(solution.bestTeamScore(new int[]{1,3,5,10,15}, new int[]{1,2,3,4,5}));
        System.out.println(solution.bestTeamScore(new int[]{4,5,6,5}, new int[]{2,1,2,1}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] arr = new int[scores.length][2];
        for (int i = 0; i < scores.length; i++) {
            arr[i][0] = ages[i];
            arr[i][1] = scores[i];
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        int[] dp = new int[scores.length];
        dp[0] = arr[0][1];
        int max = dp[0];
        for (int i = 1; i < scores.length; i++) {
            dp[i] = arr[i][1];
            for (int j = 0; j < i; j++) {
                if (arr[i][1] >= arr[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i][1]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}