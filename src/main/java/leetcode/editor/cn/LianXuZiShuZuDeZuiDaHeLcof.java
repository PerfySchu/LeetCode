//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
// Related Topics 数组 分治 动态规划 
// 👍 344 👎 0

package leetcode.editor.cn;
public class LianXuZiShuZuDeZuiDaHeLcof{
    public static void main(String[] args){
        Solution solution = new LianXuZiShuZuDeZuiDaHeLcof().new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        //不要求输出最大和的子数字，只需要求和即可
        //基本思路就是：如果前n项和<=0,则可以直接舍弃，从n+1重新开始计算
        //每往后添加一位，都对比添加前后的子数组之和大小，总是记录下最大的那个值
        int sum = 0;
        int res = nums[0];
        for (int num : nums) {
            if(sum > 0){
                sum += num;
            }else{
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}