//2023-09-05 10:08:12
//第2605题
//给你两个只包含 1 到 9 之间数字的数组 nums1 和 nums2 ，每个数组中的元素 互不相同 ，请你返回 最小 的数字，两个数组都 至少 包含这个数
//字的某个数位。
//
//
//
// 示例 1：
//
// 输入：nums1 = [4,1,3], nums2 = [5,7]
//输出：15
//解释：数字 15 的数位 1 在 nums1 中出现，数位 5 在 nums2 中出现。15 是我们能得到的最小数字。
//
//
// 示例 2：
//
// 输入：nums1 = [3,5,2,6], nums2 = [3,1,7]
//输出：3
//解释：数字 3 的数位 3 在两个数组中都出现了。
//
//
//
//
// 提示：
//
//
// 1 <= nums1.length, nums2.length <= 9
// 1 <= nums1[i], nums2[i] <= 9
// 每个数组中，元素 互不相同 。
//
//
// Related Topics 数组 哈希表 枚举 👍 37 👎 0

package leetcode.editor.cn;


public class FormSmallestNumberFromTwoDigitArrays{
    public static void main(String[] args){
        Solution solution = new FormSmallestNumberFromTwoDigitArrays().new Solution();
        System.out.println(solution.minNumber(new int[]{4,1,3}, new int[]{5, 7}));
        System.out.println(solution.minNumber(new int[]{3,5,2,6}, new int[]{3,1,7}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int min = Integer.MAX_VALUE;
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                if (num1 == num2) {
                    min = Math.min(num1, min);
                }else{
                    min = Math.min(min, Math.min(num1, num2)*10 + Math.max(num1, num2));
                }
            }
        }
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}