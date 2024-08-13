//2024-08-13 09:18:01
//第3151题
//如果数组的每一对相邻元素都是两个奇偶性不同的数字，则该数组被认为是一个 特殊数组 。
//
// Aging 有一个整数数组 nums。如果 nums 是一个 特殊数组 ，返回 true，否则返回 false。
//
//
//
// 示例 1：
//
//
// 输入：nums = [1]
//
//
// 输出：true
//
// 解释：
//
// 只有一个元素，所以答案为 true。
//
// 示例 2：
//
//
// 输入：nums = [2,1,4]
//
//
// 输出：true
//
// 解释：
//
// 只有两对相邻元素： (2,1) 和 (1,4)，它们都包含了奇偶性不同的数字，因此答案为 true。
//
// 示例 3：
//
//
// 输入：nums = [4,3,1,6]
//
//
// 输出：false
//
// 解释：
//
// nums[1] 和 nums[2] 都是奇数。因此答案为 false。
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 1 <= nums[i] <= 100
//
//
// Related Topics 数组 👍 6 👎 0

package leetcode.editor.cn;
public class SpecialArrayI{
    public static void main(String[] args){
        Solution solution = new SpecialArrayI().new Solution();
        System.out.println(solution.isArraySpecial(new int[]{1,2,3,4,5,6,7,8,9,10}));
        System.out.println(solution.isArraySpecial(new int[]{1}));
        System.out.println(solution.isArraySpecial(new int[]{2,1,4}));
        System.out.println(solution.isArraySpecial(new int[]{2,1,3,4}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isArraySpecial(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] % 2 + nums[i-1] % 2 != 1){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}