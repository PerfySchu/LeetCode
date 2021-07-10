//数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1
//) 的解决方案。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,5,9,5,9,5,5,5]
//输出：5 
//
// 示例 2： 
//
// 
//输入：[3,2]
//输出：-1 
//
// 示例 3： 
//
// 
//输入：[2,2,1,1,1,2,2]
//输出：2 
// Related Topics 数组 计数 
// 👍 96 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class FindMajorityElementLcci{
    public static void main(String[] args){
        Solution solution = new FindMajorityElementLcci().new Solution();
        System.out.println(solution.majorityElement(new int[]{3,2,3}));
        System.out.println(solution2(new int[]{3,2,3}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        int max = 0;
        int maxNum = nums[0];
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) {
            int count = numMap.getOrDefault(num, 0)+1;
            if(count>=max){
                max = count;
                maxNum = num;
            }
            numMap.put(num, count);
        }
        if(max >= nums.length/2+1){
            return maxNum;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 摩尔投票 （最优解）
     * @param nums
     * @return
     */
    public static int solution2(int[] nums){
        int moreNum = -1;
        int count = 0;
        //逐个抵消
        for (int num : nums) {
            if(count == 0){
                moreNum = num;
            }
            if(moreNum == num){
                count ++;
            }else{
                count --;
            }
        }

        //判断所剩是否众数
        count = 0;
        for (int num : nums) {
            if(moreNum == num){
                count ++;
            }
        }
        if(count >= nums.length/2+1){
            return moreNum;
        }
        return -1;
    }
}
