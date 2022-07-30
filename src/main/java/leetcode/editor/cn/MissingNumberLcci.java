//2022-07-30 11:42:29
//第面试题 17.04题
//数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
//
// 注意：本题相对书上原题稍作改动
//
// 示例 1：
//
// 输入：[3,0,1]
//输出：2
//
//
//
// 示例 2：
//
// 输入：[9,6,4,2,3,5,7,0,1]
//输出：8
//
// 位运算怎么做？
// 0  0000
// 1  0001
// 2  0010
// 3  0011
// 4  0100
// 5  0101
// 6  0110
//
// Related Topics 位运算 数组 哈希表 数学 排序 👍 71 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class MissingNumberLcci{
    public static void main(String[] args){
        Solution solution = new MissingNumberLcci().new Solution();
        System.out.println(solution.missingNumber(new int[]{3,0,1}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                continue;
            }
            return i;
        }
        return nums.length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}