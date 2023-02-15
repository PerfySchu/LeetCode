//2023-02-15 09:18:37
//第1124题
//给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
//
// 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
//
// 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
//
// 请你返回「表现良好时间段」的最大长度。
//
//
//
// 示例 1：
//
//
//输入：hours = [9,9,6,0,6,6,9]
//输出：3
//解释：最长的表现良好时间段是 [9,9,6]。
//
// 示例 2：
//
//
//输入：hours = [6,6,6]
//输出：0
//
//
//
//
// 提示：
//
//
// 1 <= hours.length <= 10⁴
// 0 <= hours[i] <= 16
//
//
// Related Topics 栈 数组 哈希表 前缀和 单调栈 👍 441 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LongestWellPerformingInterval{
    public static void main(String[] args){
        Solution solution = new LongestWellPerformingInterval().new Solution();
        System.out.println(solution.longestWPI(new int[]{9,9,6}));
        System.out.println(solution.longestWPI(new int[]{6,6,6}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestWPI(int[] hours) {
        int preSum = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < hours.length; i++) {
            preSum += hours[i] > 8 ? 1 : -1;
            if (preSum > 0) {// 从数组第一个元素到目前位置组成的子数组就是「表现良好时间段」
                res = i + 1;
            } else {
                // 因为求最大长度，所以这里不能覆盖，key如果存在就不再存储
                map.putIfAbsent(preSum, i);
                // 查找区间和为1的子数组
                if (map.containsKey(preSum - 1)) {
                    res = Math.max(res, i - map.get(preSum - 1));
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}