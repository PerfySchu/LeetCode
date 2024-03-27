//2024-03-27 09:07:29
//第2580题
//给你一个二维整数数组 ranges ，其中 ranges[i] = [starti, endi] 表示 starti 到 endi 之间（包括二者）的所有整
//数都包含在第 i 个区间中。
//
// 你需要将 ranges 分成 两个 组（可以为空），满足：
//
//
// 每个区间只属于一个组。
// 两个有 交集 的区间必须在 同一个 组内。
//
//
// 如果两个区间有至少 一个 公共整数，那么这两个区间是 有交集 的。
//
//
// 比方说，区间 [1, 3] 和 [2, 5] 有交集，因为 2 和 3 在两个区间中都被包含。
//
//
// 请你返回将 ranges 划分成两个组的 总方案数 。由于答案可能很大，将它对 10⁹ + 7 取余 后返回。
//
//
//
// 示例 1：
//
// 输入：ranges = [[6,10],[5,15]]
//输出：2
//解释：
//两个区间有交集，所以它们必须在同一个组内。
//所以有两种方案：
//- 将两个区间都放在第 1 个组中。
//- 将两个区间都放在第 2 个组中。
//
//
// 示例 2：
//
// 输入：ranges = [[1,3],[10,20],[2,5],[4,8]]
//输出：4
//解释：
//区间 [1,3] 和 [2,5] 有交集，所以它们必须在同一个组中。
//同理，区间 [2,5] 和 [4,8] 也有交集，所以它们也必须在同一个组中。
//所以总共有 4 种分组方案：
//- 所有区间都在第 1 组。
//- 所有区间都在第 2 组。
//- 区间 [1,3] ，[2,5] 和 [4,8] 在第 1 个组中，[10,20] 在第 2 个组中。
//- 区间 [1,3] ，[2,5] 和 [4,8] 在第 2 个组中，[10,20] 在第 1 个组中。
//
//
//
//
// 提示：
//
//
// 1 <= ranges.length <= 10⁵
// ranges[i].length == 2
// 0 <= starti <= endi <= 10⁹
//
//
// Related Topics 数组 排序 👍 28 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class CountWaysToGroupOverlappingRanges{
    public static void main(String[] args){
        Solution solution = new CountWaysToGroupOverlappingRanges().new Solution();
        System.out.println(solution.countWays(new int[][]{{6,10},{5,15}}));
        System.out.println(solution.countWays(new int[][]{{6,10},{5,15},{11,13}}));
        System.out.println(solution.countWays(new int[][]{{1,3},{10,20},{2,5},{4,8}}));
        System.out.println(solution.countWays(new int[][]{{0,0},{8,9},{12,13},{1,3}}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countWays(int[][] ranges) {
        int count = 1;
        Arrays.sort(ranges, Comparator.comparingInt(a -> a[0]));
        int size = ranges.length;
        for (int i = 0; i < size; ) {
            int r = ranges[i][1];
            int j = i+1;
            while(j < size && ranges[j][0]<=r) {
                //有交集
                r = Math.max(r, ranges[j][1]);
                j++;
            }
            i=j;
            //无交集
            count = count * 2 % 1000000007;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}