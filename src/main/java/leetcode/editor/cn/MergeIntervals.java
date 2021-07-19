//第56题
//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 数组 排序 
// 👍 1004 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals{
    public static void main(String[] args){
        Solution solution = new MergeIntervals().new Solution();
        System.out.println(Arrays.deepToString(solution.merge(new int[][]{{1,3}, {2,6},{8,10},{15,18}})));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        //按左边界排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            int j=i+1;
            for (; j < intervals.length; j++) {
                if(intervals[j][0] <= right){
                    if(intervals[j][1] > right) {
                        right = intervals[j][1];
                    }
                }else{
                    break;
                }
            }
            i=j-1;
            result.add(new int[]{left, right});
        }
        return result.toArray(new int[result.size()][2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
