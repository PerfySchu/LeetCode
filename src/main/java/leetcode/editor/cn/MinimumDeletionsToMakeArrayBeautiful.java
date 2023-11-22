//2023-11-21 09:52:19
//第2216题
//给你一个下标从 0 开始的整数数组 nums ，如果满足下述条件，则认为数组 nums 是一个 美丽数组 ：
//
//
// nums.length 为偶数
// 对所有满足 i % 2 == 0 的下标 i ，nums[i] != nums[i + 1] 均成立
//
//
// 注意，空数组同样认为是美丽数组。
//
// 你可以从 nums 中删除任意数量的元素。当你删除一个元素时，被删除元素右侧的所有元素将会向左移动一个单位以填补空缺，而左侧的元素将会保持 不变 。
//
// 返回使 nums 变为美丽数组所需删除的 最少 元素数目。
//
//
//
// 示例 1：
//
// 输入：nums = [1,1,2,3,5]
//输出：1
//解释：可以删除 nums[0] 或 nums[1] ，这样得到的 nums = [1,2,3,5] 是一个美丽数组。可以证明，要想使 nums 变为美丽数组
//，至少需要删除 1 个元素。
//
// 示例 2：
//
// 输入：nums = [1,1,2,2,3,3]
//输出：2
//解释：可以删除 nums[0] 和 nums[5] ，这样得到的 nums = [1,2,2,3] 是一个美丽数组。可以证明，要想使 nums 变为美丽数组
//，至少需要删除 2 个元素。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// 0 <= nums[i] <= 10⁵
//
//
// Related Topics 栈 贪心 数组 👍 53 👎 0

package leetcode.editor.cn;
public class MinimumDeletionsToMakeArrayBeautiful{
    public static void main(String[] args){
        Solution solution = new MinimumDeletionsToMakeArrayBeautiful().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDeletion(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if ((i - cnt) % 2 == 0 && i + 1 < n && nums[i] == nums[i + 1]) {
                cnt++;
            }
        }
        return (n - cnt) % 2 != 0 ? cnt + 1 : cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}