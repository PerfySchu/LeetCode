//2022-10-08 10:10:30
//第870题
//给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数
//目来描述。
//
// 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
//输出：[2,11,7,15]
//
//
// 示例 2：
//
//
//输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
//输出：[24,32,8,12]
//
//
//
//
// 提示：
//
//
// 1 <= nums1.length <= 10⁵
// nums2.length == nums1.length
// 0 <= nums1[i], nums2[i] <= 10⁹
//
//
// Related Topics 贪心 数组 双指针 排序 👍 233 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.TreeMap;

public class AdvantageShuffle{
    public static void main(String[] args){
        Solution solution = new AdvantageShuffle().new Solution();
        System.out.println(Arrays.toString(solution.advantageCount(new int[]{718967141,189971378,341560426,23521218,339517772}, new int[]{967482459,978798455,744530040,3454610,940238504})));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int length = nums1.length;
        int[] ans = new int[length];
        for (int i = 0; i < nums2.length; i++) {
            Integer higher = map.higherKey(nums2[i]);
            if(higher == null){
                higher = map.firstKey();
            }
            ans[i] = higher;
            if (map.get(higher) == 1) {
                map.remove(higher);
            }else {
                map.put(higher, map.get(higher)-1);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}