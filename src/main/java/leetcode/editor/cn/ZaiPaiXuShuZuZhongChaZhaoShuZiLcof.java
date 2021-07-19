//第剑指 Offer 53 - I题
//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 165 👎 0

package leetcode.editor.cn;
public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof{
    public static void main(String[] args){
        Solution solution = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
        System.out.println(solution.search(new int[]{2,2}, 3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right = nums.length-1;
        while (left<=right){
            if(nums[left] == target && nums[right] == target){
                break;
            }
            if(nums[left]<target){
                left ++;
            }
            if(nums[right]>target){
                right--;
            }
        }
        return right-left+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 二分法
     * @param nums
     * @param target
     * @return
     */
    private static int solution2(int[] nums, int target){

        return 0;
    }
}
