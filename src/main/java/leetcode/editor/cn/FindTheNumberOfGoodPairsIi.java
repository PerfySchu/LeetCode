//2024-10-11 09:27:26
//第3164题
//给你两个整数数组 nums1 和 nums2，长度分别为 n 和 m。同时给你一个正整数 k。
//
// 如果 nums1[i] 可以被 nums2[j] * k 整除，则称数对 (i, j) 为 优质数对（0 <= i <= n - 1, 0 <= j <=
// m - 1）。
//
// 返回 优质数对 的总数。
//
//
//
// 示例 1：
//
//
// 输入：nums1 = [1,3,4], nums2 = [1,3,4], k = 1
//
//
// 输出：5
//
// 解释：
//
// 5个优质数对分别是 (0, 0), (1, 0), (1, 1), (2, 0), 和 (2, 2)。
//
// 示例 2：
//
//
// 输入：nums1 = [1,2,4,12], nums2 = [2,4], k = 3
//
//
// 输出：2
//
// 解释：
//
// 2个优质数对分别是 (3, 0) 和 (3, 1)。
//
//
//
// 提示：
//
//
// 1 <= n, m <= 10⁵
// 1 <= nums1[i], nums2[j] <= 10⁶
// 1 <= k <= 10³
//
//
// Related Topics 数组 哈希表 👍 30 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class FindTheNumberOfGoodPairsIi{
    public static void main(String[] args){
        Solution solution = new FindTheNumberOfGoodPairsIi().new Solution();
        System.out.println(solution.numberOfPairs(new int[]{1, 3, 4}, new int[]{1, 3, 4}, 1));
        System.out.println(solution.numberOfPairs(new int[]{1, 2, 4, 12}, new int[]{2, 4}, 3));
        System.out.println(solution.numberOfPairs(new int[]{1, 2, 4, 12}, new int[]{2, 4}, 5));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int max1 = 0;
        for (int i : nums1) {
            map1.put(i, map1.getOrDefault(i, 0) + 1);
            max1 = Math.max(max1,  i);
        }
        for (int num : nums2) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }
        long ans = 0L;
        for (Integer a : map2.keySet()) {
            for(int b = a * k; b <= max1; b += a * k) {
                if(map1.containsKey(b)){
                    ans += (long) map1.get(b) * map2.getOrDefault(a, 0);
                }
            }

        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}