//2024-04-18 09:53:09
//第2007题
//一个整数数组 original 可以转变成一个 双倍 数组 changed ，转变方式为将 original 中每个元素 值乘以 2 加入数组中，然后将所有
//元素 随机打乱 。
//
// 给你一个数组 changed ，如果 change 是 双倍 数组，那么请你返回 original数组，否则请返回空数组。original 的元素可以以
//任意 顺序返回。
//
//
//
// 示例 1：
//
// 输入：changed = [1,3,4,2,6,8]
//输出：[1,3,4]
//解释：一个可能的 original 数组为 [1,3,4] :
//- 将 1 乘以 2 ，得到 1 * 2 = 2 。
//- 将 3 乘以 2 ，得到 3 * 2 = 6 。
//- 将 4 乘以 2 ，得到 4 * 2 = 8 。
//其他可能的原数组方案为 [4,3,1] 或者 [3,1,4] 。
//
//
// 示例 2：
//
// 输入：changed = [6,3,0,1]
//输出：[]
//解释：changed 不是一个双倍数组。
//
//
// 示例 3：
//
// 输入：changed = [1]
//输出：[]
//解释：changed 不是一个双倍数组。
//
//
//
//
// 提示：
//
//
// 1 <= changed.length <= 10⁵
// 0 <= changed[i] <= 10⁵
//
//
// Related Topics 贪心 数组 哈希表 排序 👍 43 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindOriginalArrayFromDoubledArray{
    public static void main(String[] args){
        Solution solution = new FindOriginalArrayFromDoubledArray().new Solution();
        System.out.println(Arrays.toString(solution.findOriginalArray(new int[]{1, 3, 4, 2, 6, 8})));
        System.out.println(Arrays.toString(solution.findOriginalArray(new int[]{6,3,0,1})));
        System.out.println(Arrays.toString(solution.findOriginalArray(new int[]{1})));
        System.out.println(Arrays.toString(solution.findOriginalArray(new int[]{0,0,0,0})));
        System.out.println(Arrays.toString(solution.findOriginalArray(new int[]{4,4,16,20,8,8,2,10})));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n%2 != 0) {
            return new int[]{};
        }
        Map<Integer,Integer> numMap = new HashMap<>();
        for (int num : changed) {
            numMap.put(num, numMap.getOrDefault(num, 0)+1);
        }
        List<Integer> nums = new ArrayList<>();
        Arrays.sort(changed);
        for (int num : changed) {
            if (numMap.get(num) == 0) {
                continue;
            }
            numMap.put(num, numMap.getOrDefault(num, 0)-1);
            if(numMap.getOrDefault(num*2, 0) == 0){
                return new int[0];
            }
            numMap.put(num*2, numMap.getOrDefault(num*2, 0)-1);
            nums.add(num);
        }
        return nums.stream().mapToInt(Integer::intValue).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}