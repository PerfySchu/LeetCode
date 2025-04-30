//2025-04-30 09:11:49
//第1295题
//给你一个整数数组 nums，请你返回其中包含 偶数 个数位的数字的个数。
//
//
//
// 示例 1：
//
//
//输入：nums = [12,345,2,6,7896]
//输出：2
//解释：
//12 是 2 位数字（位数为偶数） 
//345 是 3 位数字（位数为奇数）  
//2 是 1 位数字（位数为奇数） 
//6 是 1 位数字 位数为奇数） 
//7896 是 4 位数字（位数为偶数）  
//因此只有 12 和 7896 是位数为偶数的数字
//
//
// 示例 2：
//
//
//输入：nums = [555,901,482,1771]
//输出：1
//解释：
//只有 1771 是位数为偶数的数字。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 500
// 1 <= nums[i] <= 10⁵
//
//
// Related Topics 数组 数学 👍 101 👎 0

package leetcode.editor.cn;
public class FindNumbersWithEvenNumberOfDigits{
    public static void main(String[] args){
        Solution solution = new FindNumbersWithEvenNumberOfDigits().new Solution();
        System.out.println(solution.findNumbers(new int[]{12,345,2,6,7896}));
        System.out.println(solution.findNumbers(new int[]{555,901,482,1771}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}