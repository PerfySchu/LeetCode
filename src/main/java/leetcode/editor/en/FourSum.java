//Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target. 
//
// Note: 
//
// The solution set must not contain duplicate quadruplets. 
//
// Example: 
//
// 
//Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
//
//A solution set is:
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics Array Hash Table Two Pointers
package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum{
    public static void main(String[] args){
        Solution solution = new FourSum().new Solution();
        int[] nums = new int[]{-1,2,2,-5,0,-1,4};
        System.out.println(solution.fourSum(nums, 3));
    }

    /**
     * 解法类似之前的 3数和求解
     * 先将原始数组排序
     * 固定两个数，使用双指针获取剩余两个数，指针初始位置为【固定数的后一位】和【数组的最后一位】，求和与目标值对比，
     * 根据结果移动两个指针，如果偏小，则指针1后移，如果偏大则指针2前移
     * 其中，固定的两个数值并不是固定死，而是分别做循环，
     * 第一个数从 0 到 length -3
     * 第二个数从 1 到 length -2
     *
     * 另外需要注意的是结果集重复的问题
     * 从最外层循环开始，每层都需要判断元素是否重复（数值相等）
     */
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length<4){
            return Arrays.asList();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        //第一个数字的位置
        for(int i=0; i < nums.length-3; i++){
            //避免重复
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            //第二个数字的位置
            for(int j=i+1; j<nums.length-2; j++){
                //避免重复
                if(j>i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int k = j+1;
                int m = nums.length -1;
                while(k < m){
                    //避免重复
                    if(k>(j+1) && nums[k] == nums[k-1]){
                        k++;
                        continue;
                    }
                    //避免重复
                    if(m<( nums.length -1) && nums[m] == nums[m+1]){
                        m--;
                        continue;
                    }
                    int sum = nums[i] + nums[j] + nums[k] + nums[m];
                    if(sum == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[m]);
                        result.add(list);
                        k++;
                        m--;
                    }else if(sum < target){
                        k++;
                    }else{
                        m--;
                    }
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
