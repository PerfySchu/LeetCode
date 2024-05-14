//2024-05-14 10:06:05
//第2244题
//给你一个下标从 0 开始的整数数组 tasks ，其中 tasks[i] 表示任务的难度级别。在每一轮中，你可以完成 2 个或者 3 个 相同难度级别 的任
//务。
//
// 返回完成所有任务需要的 最少 轮数，如果无法完成所有任务，返回 -1 。
//
//
//
// 示例 1：
//
// 输入：tasks = [2,2,3,3,2,4,4,4,4,4]
//输出：4
//解释：要想完成所有任务，一个可能的计划是：
//- 第一轮，完成难度级别为 2 的 3 个任务。
//- 第二轮，完成难度级别为 3 的 2 个任务。
//- 第三轮，完成难度级别为 4 的 3 个任务。
//- 第四轮，完成难度级别为 4 的 2 个任务。
//可以证明，无法在少于 4 轮的情况下完成所有任务，所以答案为 4 。
//
//
// 示例 2：
//
// 输入：tasks = [2,3,3]
//输出：-1
//解释：难度级别为 2 的任务只有 1 个，但每一轮执行中，只能选择完成 2 个或者 3 个相同难度级别的任务。因此，无法完成所有任务，答案为 -1 。
//
//
//
//
// 提示：
//
//
// 1 <= tasks.length <= 10⁵
// 1 <= tasks[i] <= 10⁹
//
//
// Related Topics 贪心 数组 哈希表 计数 👍 38 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MinimumRoundsToCompleteAllTasks{
    public static void main(String[] args){
        Solution solution = new MinimumRoundsToCompleteAllTasks().new Solution();
        System.out.println(solution.minimumRounds(new int[]{2,2,3,3,2,4,4,4,4,4}));
        System.out.println(solution.minimumRounds(new int[]{2,3,3}));
        System.out.println(solution.minimumRounds(new int[]{66,66,63,61,63,63,64,66,66,65,66,65,61,67,68,66,62,67,61,64,66,60,69,66,65,68,63,60,67,62,68,60,66,64,60,60,60,62,66,64,63,65,60,69,63,68,68,69,68,61}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int task : tasks) {
            countMap.put(task, countMap.getOrDefault(task, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> next : countMap.entrySet()) {
            Integer value = next.getValue();
            if (value == 1) {
                return -1;
            }else {
                ans += (value+2)/3;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}