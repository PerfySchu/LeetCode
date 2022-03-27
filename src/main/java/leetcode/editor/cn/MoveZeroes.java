//2022-03-27 19:22:13
//第283题
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
//
//
// 1,2,0,0,0,4,5
//1, 2
// 2, 0,0,0,4,5
// 0,0,0,4,5
//
//
// 示例 1:
//
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
//
// 示例 2:
//
//
//输入: nums = [0]
//输出: [0]
//
//
//
// 提示:
//
//
//
// 1 <= nums.length <= 10⁴
// -2³¹ <= nums[i] <= 2³¹ - 1
//
//
//
//
// 进阶：你能尽量减少完成的操作次数吗？
// Related Topics 数组 双指针 👍 1512 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class MoveZeroes{
    public static void main(String[] args){
        Solution solution = new MoveZeroes().new Solution();
        int[] nums = {1,2,0,0,0,4,5};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int a=0, b=1;
        while (a< len && b<len){
            if(nums[a] == 0){
                if(nums[b] != 0){
                    nums[a] = nums[b];
                    nums[b] = 0;
                    a++;
                    b = a+1;
                }else{
                    b++;
                }
            }else{
                a++;
                b = a+1;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}