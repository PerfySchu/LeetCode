//2025-04-24 13:48:17
//第2799题
//给你一个由 正 整数组成的数组 nums 。
//
// 如果数组中的某个子数组满足下述条件，则称之为 完全子数组 ：
//
//
// 子数组中 不同 元素的数目等于整个数组不同元素的数目。
//
//
// 返回数组中 完全子数组 的数目。
//
// 子数组 是数组中的一个连续非空序列。
//
//
//
// 示例 1：
//
// 输入：nums = [1,3,1,2,2]
//输出：4
//解释：完全子数组有：[1,3,1,2]、[1,3,1,2,2]、[3,1,2] 和 [3,1,2,2] 。
//
//
// 示例 2：
//
// 输入：nums = [5,5,5,5]
//输出：10
//解释：数组仅由整数 5 组成，所以任意子数组都满足完全子数组的条件。子数组的总数为 10 。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 1000
// 1 <= nums[i] <= 2000
//
//
// Related Topics 数组 哈希表 滑动窗口 👍 72 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class CountCompleteSubarraysInAnArray{
    public static void main(String[] args){
        Solution solution = new CountCompleteSubarraysInAnArray().new Solution();
        System.out.println(solution.countCompleteSubarrays(new int[]{1,3,1,2,2}));
        System.out.println(solution.countCompleteSubarrays(new int[]{5,5,5,5}));
        System.out.println(solution.countCompleteSubarrays(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int count = 0;
        int len = map.size();
        for(int i=0;i<nums.length;i++){
            Map<Integer,Integer> map1 = new HashMap<>();
            for(int j=i;j<nums.length;j++){
                map1.put(nums[j],map1.getOrDefault(nums[j],0)+1);
                if(map1.size()==len){
                    count++;
                }
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}