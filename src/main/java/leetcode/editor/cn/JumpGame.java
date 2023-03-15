//2023-03-15 14:10:49
//第55题
//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
// 判断你是否能够到达最后一个下标。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
//
//
// 示例 2：
//
//
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 3 * 10⁴
// 0 <= nums[i] <= 10⁵
//
//
// Related Topics 贪心 数组 动态规划 👍 2241 👎 0

package leetcode.editor.cn;
public class JumpGame{
    public static void main(String[] args){
        Solution solution = new JumpGame().new Solution();
        System.out.println(solution.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(solution.canJump(new int[]{3,2,1,0,4}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canJump(int[] nums) {
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            if(maxDistance<i){
                return false;
            }
            maxDistance = Math.max(i+nums[i], maxDistance);
        }
        return maxDistance >= nums.length - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}