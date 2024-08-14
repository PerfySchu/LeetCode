//2024-08-14 10:02:25
//第3152题
//如果数组的每一对相邻元素都是两个奇偶性不同的数字，则该数组被认为是一个 特殊数组 。
//
// 周洋哥有一个整数数组 nums 和一个二维整数矩阵 queries，对于 queries[i] = [fromi, toi]，请你帮助周洋哥检查子数组
//nums[fromi..toi] 是不是一个 特殊数组 。
//
// 返回布尔数组 answer，如果 nums[fromi..toi] 是特殊数组，则 answer[i] 为 true ，否则，answer[i] 为
//false 。
//
//
//
// 示例 1：
//
//
// 输入：nums = [3,4,1,2,6], queries = [[0,4]]
//
//
// 输出：[false]
//
// 解释：
//
// 子数组是 [3,4,1,2,6]。2 和 6 都是偶数。
//
// 示例 2：
//
//
// 输入：nums = [4,3,1,6], queries = [[0,2],[2,3]]
//
//
// 输出：[false,true]
//
// 解释：
//
//
// 子数组是 [4,3,1]。3 和 1 都是奇数。因此这个查询的答案是 false。
// 子数组是 [1,6]。只有一对：(1,6)，且包含了奇偶性不同的数字。因此这个查询的答案是 true。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// 1 <= nums[i] <= 10⁵
// 1 <= queries.length <= 10⁵
// queries[i].length == 2
// 0 <= queries[i][0] <= queries[i][1] <= nums.length - 1
//
//
// Related Topics 数组 二分查找 前缀和 👍 20 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class SpecialArrayIi{
    public static void main(String[] args){
        Solution solution = new SpecialArrayIi().new Solution();
        System.out.println(Arrays.toString(solution.isArraySpecial(new int[]{3, 4, 1, 2, 6}, new int[][]{{0, 4}})));
        System.out.println(Arrays.toString(solution.isArraySpecial(new int[]{1,4}, new int[][]{{0, 1}})));
        System.out.println(Arrays.toString(solution.isArraySpecial(new int[]{4, 3, 1, 6}, new int[][]{{0, 2}, {2, 3}})));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] maxLen = new int[nums.length];
        Arrays.fill(maxLen, 1);
        for (int i = 1; i < nums.length; i++) {
            if((nums[i] & 1) != (nums[i-1] & 1)){
                maxLen[i] = maxLen[i-1]+1;
            }
        }
        boolean[] ans = new boolean[queries.length];
        Arrays.fill(ans, true);
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            if (query[1] - query[0] + 1 > maxLen[query[1]]) {
                ans[i] = false;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}