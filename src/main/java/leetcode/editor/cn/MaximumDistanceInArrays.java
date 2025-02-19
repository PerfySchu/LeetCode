//2025-02-19 14:15:33
//第624题
//给定 m 个数组，每个数组都已经按照升序排好序了。
//
// 现在你需要从两个不同的数组中选择两个整数（每个数组选一个）并且计算它们的距离。两个整数 a 和 b 之间的距离定义为它们差的绝对值 |a-b| 。
//
// 返回最大距离。
//
// 示例 1：
//
//
//输入：[[1,2,3],[4,5],[1,2,3]]
//输出：4
//解释：
//一种得到答案 4 的方法是从第一个数组或者第三个数组中选择 1，同时从第二个数组中选择 5 。
//
//
// 示例 2：
//
//
//输入：arrays = [[1],[1]]
//输出：0
//
//
//
//
// 提示：
//
//
// m == arrays.length
// 2 <= m <= 10⁵
// 1 <= arrays[i].length <= 500
// -10⁴ <= arrays[i][j] <= 10⁴
// arrays[i] 以 升序 排序。
// 所有数组中最多有 10⁵ 个整数。
//
//
//
//
// Related Topics 贪心 数组 👍 137 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumDistanceInArrays{
    public static void main(String[] args){
        Solution solution = new MaximumDistanceInArrays().new Solution();
        System.out.println(solution.maxDistance(List.of(List.of(1,2,3), List.of(4,5), List.of(1,2,3))));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int result = 0;
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size()-1);
        for (int i = 1; i < arrays.size(); i++) {
            result = Math.max(result, Math.max(Math.abs(arrays.get(i).get(0) - max), Math.abs(arrays.get(i).get(arrays.get(i).size()-1) - min)));
            min = Math.min(min, arrays.get(i).get(0));
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size()-1));
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}