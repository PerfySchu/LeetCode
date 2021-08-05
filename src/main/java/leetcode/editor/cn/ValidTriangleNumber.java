//第611题
//给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。 
//
// 示例 1: 
//
// 
//输入: [2,2,3,4]
//输出: 3
//解释:
//有效的组合是: 
//2,3,4 (使用第一个 2)
//2,3,4 (使用第二个 2)
//2,2,3
// 
//
// 注意: 
//
// 
// 数组长度不超过1000。 
// 数组里整数的范围为 [0, 1000]。 
// 
// Related Topics 贪心 数组 双指针 二分查找 排序 
// 👍 276 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class ValidTriangleNumber{
    public static void main(String[] args){
        Solution solution = new ValidTriangleNumber().new Solution();
        System.out.println(solution.triangleNumber(new int[]{2,2,3,4}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int triangleNumber(int[] nums) {
        if(nums == null || nums.length<3){
            return 0;
        }
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j <nums.length-1 ; j++) {
                int k = j+1;
                while (k< nums.length){
                    if(nums[i] + nums[j] > nums[k]){
                        res ++;
                    }else{
                        break;
                    }
                    k++;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
