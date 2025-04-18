//2025-04-18 10:28:37
//第2364题
//给你一个下标从 0 开始的整数数组 nums 。如果 i < j 且 j - i != nums[j] - nums[i] ，那么我们称 (i, j) 是一
//个 坏数对 。
//
// 请你返回 nums 中 坏数对 的总数目。
//
//
//
// 示例 1：
//
// 输入：nums = [4,1,3,3]
//输出：5
//解释：数对 (0, 1) 是坏数对，因为 1 - 0 != 1 - 4 。
//数对 (0, 2) 是坏数对，因为 2 - 0 != 3 - 4, 2 != -1 。
//数对 (0, 3) 是坏数对，因为 3 - 0 != 3 - 4, 3 != -1 。
//数对 (1, 2) 是坏数对，因为 2 - 1 != 3 - 1, 1 != 2 。
//数对 (2, 3) 是坏数对，因为 3 - 2 != 3 - 3, 1 != 0 。
//总共有 5 个坏数对，所以我们返回 5 。
//
//
// 示例 2：
//
// 输入：nums = [1,2,3,4,5]
//输出：0
//解释：没有坏数对。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// 1 <= nums[i] <= 10⁹
//
//
// Related Topics 数组 哈希表 数学 计数 👍 51 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfBadPairs{
    public static void main(String[] args){
        Solution solution = new CountNumberOfBadPairs().new Solution();
        System.out.println(solution.countBadPairs(new int[]{4,1,3,3}));
        System.out.println(solution.countBadPairs(new int[]{1,2,3,4,5}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            int diff = nums[i] - i;
            if(map.containsKey(diff)){
                count += map.get(diff);
                map.put(diff, map.get(diff) + 1);
            }else{
                map.put(diff, 1);
            }
        }
        return (long) nums.length * (nums.length - 1) / 2 - count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}