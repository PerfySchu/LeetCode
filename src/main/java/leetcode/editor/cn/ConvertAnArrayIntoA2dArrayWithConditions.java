//2025-03-19 08:36:14
//第2610题
//给你一个整数数组 nums 。请你创建一个满足以下条件的二维数组：
//
//
// 二维数组应该 只 包含数组 nums 中的元素。
// 二维数组中的每一行都包含 不同 的整数。
// 二维数组的行数应尽可能 少 。
//
//
// 返回结果数组。如果存在多种答案，则返回其中任何一种。
//
// 请注意，二维数组的每一行上可以存在不同数量的元素。
//
//
//
// 示例 1：
//
// 输入：nums = [1,3,4,1,2,3,1]
//输出：[[1,3,4,2],[1,3],[1]]
//解释：根据题目要求可以创建包含以下几行元素的二维数组：
//- 1,3,4,2
//- 1,3
//- 1
//nums 中的所有元素都有用到，并且每一行都由不同的整数组成，所以这是一个符合题目要求的答案。
//可以证明无法创建少于三行且符合题目要求的二维数组。
//
// 示例 2：
//
// 输入：nums = [1,2,3,4]
//输出：[[4,3,2,1]]
//解释：nums 中的所有元素都不同，所以我们可以将其全部保存在二维数组中的第一行。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 200
// 1 <= nums[i] <= nums.length
//
//
// Related Topics 数组 哈希表 👍 30 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertAnArrayIntoA2dArrayWithConditions{
    public static void main(String[] args){
        Solution solution = new ConvertAnArrayIntoA2dArrayWithConditions().new Solution();
        System.out.println(solution.findMatrix(new int[]{1,3,4,1,2,3,1}));
        System.out.println(solution.findMatrix(new int[]{1,2,3,4}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!map.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                list.add(entry.getKey());
            }
            res.add(list);
            for (Integer num : list) {
                if (map.get(num) == 1) {
                    map.remove(num);
                } else {
                    map.put(num, map.get(num) - 1);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}