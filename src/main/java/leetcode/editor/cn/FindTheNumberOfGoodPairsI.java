//2024-10-10 08:49:35
//第3162题
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
// 1 <= n, m <= 50
// 1 <= nums1[i], nums2[j] <= 50
// 1 <= k <= 50
//
//
// Related Topics 数组 哈希表 👍 7 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class FindTheNumberOfGoodPairsI{
    public static void main(String[] args){
        Solution solution = new FindTheNumberOfGoodPairsI().new Solution();
        System.out.println(solution.numberOfPairs(new int[]{1, 3, 4}, new int[]{1, 3, 4}, 1));
        System.out.println(solution.numberOfPairs(new int[]{1, 2, 4, 12}, new int[]{2, 4}, 3));
        System.out.println(solution.numberOfPairs(new int[]{1, 2, 4, 12}, new int[]{2, 4}, 5));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int ans = 0;
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                ans += (num1 % (num2 * k)) == 0 ? 1 : 0;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public int numberOfPairs2(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i : nums1) {
            map1.put(i, map1.getOrDefault(i, 0) + 1);
        }
        for (int num : nums2) {
            num = num * k;
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            int k1 = entry.getKey();
            int v1 = entry.getValue();
            for (Map.Entry<Integer, Integer> entry2 : map2.entrySet()) {
                Integer k2 = entry2.getKey();
                Integer v2 = entry2.getValue();
                if (k1 % k2 == 0) {
                    ans += v1 * v2;
                }
            }
        }
        return ans;
    }
}