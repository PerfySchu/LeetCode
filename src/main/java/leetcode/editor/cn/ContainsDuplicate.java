//2021-11-24 11:10:27
//第217题
//给定一个整数数组，判断是否存在重复元素。 
//
// 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3,1]
//输出: true 
//
// 示例 2: 
//
// 
//输入: [1,2,3,4]
//输出: false 
//
// 示例 3: 
//
// 
//输入: [1,1,1,3,3,4,3,2,4,2]
//输出: true 
// Related Topics 数组 哈希表 排序 👍 546 👎 0

package leetcode.editor.cn;


import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate{
    public static void main(String[] args){
        Solution solution = new ContainsDuplicate().new Solution();
        System.out.println(solution.containsDuplicate(new int[]{1,2,3,4,5}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            if(numSet.contains(num)){
                return true;
            }
            numSet.add(num);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
