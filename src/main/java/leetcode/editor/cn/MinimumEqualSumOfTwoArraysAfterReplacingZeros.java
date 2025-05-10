//2025-05-10 12:27:37
//第2918题
//给你两个由正整数和 0 组成的数组 nums1 和 nums2 。
//
// 你必须将两个数组中的 所有 0 替换为 严格 正整数，并且满足两个数组中所有元素的和 相等 。
//
// 返回 最小 相等和 ，如果无法使两数组相等，则返回 -1 。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [3,2,0,1,0], nums2 = [6,5,0]
//输出：12
//解释：可以按下述方式替换数组中的 0 ：
//- 用 2 和 4 替换 nums1 中的两个 0 。得到 nums1 = [3,2,2,1,4] 。
//- 用 1 替换 nums2 中的一个 0 。得到 nums2 = [6,5,1] 。
//两个数组的元素和相等，都等于 12 。可以证明这是可以获得的最小相等和。
//
//
// 示例 2：
//
//
//输入：nums1 = [2,0,2,0], nums2 = [1,4]
//输出：-1
//解释：无法使两个数组的和相等。
//
//
//
//
// 提示：
//
//
// 1 <= nums1.length, nums2.length <= 10⁵
// 0 <= nums1[i], nums2[i] <= 10⁶
//
//
// Related Topics 贪心 数组 👍 28 👎 0

package leetcode.editor.cn;
public class MinimumEqualSumOfTwoArraysAfterReplacingZeros{
    public static void main(String[] args){
        Solution solution = new MinimumEqualSumOfTwoArraysAfterReplacingZeros().new Solution();
        System.out.println(solution.minSum(new int[]{3,2,0,1,0},new int[]{6,5,0}));
        System.out.println(solution.minSum(new int[]{2,0,2,0},new int[]{1,4}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int zero1 = 0;
        long cnt1 = 0;
        int zero2 = 0;
        long cnt2 = 0;
        for (int i : nums1) {
            if (i==0) {
                zero1++;
            }
            cnt1 += i;
        }
        for (int i : nums2) {
            if (i==0) {
                zero2++;
            }
            cnt2 += i;
        }
        long diff = cnt1 - cnt2;
        if (diff==0) {
            if(zero1==0&&zero2==0) {
                return cnt1;
            }
            if(zero1>0&&zero2==0 || zero1==0&&zero2>0) {
                return -1;
            }
            return Math.max(cnt1+zero1,cnt2+zero2);
        }
        if (diff>0) {
            if(zero2==0){
                return -1;
            }
            if(zero1==0 && cnt2+zero2>cnt1){
                return -1;
            }
            return Math.max(cnt1+zero1,cnt2+zero2);
        }
        if (zero1==0) {
            return -1;
        }
        if(zero2==0 && cnt1+zero1>cnt2){
            return -1;
        }
        return Math.max(cnt1+zero1,cnt2+zero2);
    }
}
    //leetcode submit region end(Pro


//leetcode submit region end(Prohibit modification and deletion)

}