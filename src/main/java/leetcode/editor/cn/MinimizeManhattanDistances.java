//2024-07-09 10:10:19
//第3102题
//给你一个下标从 0 开始的数组 points ，它表示二维平面上一些点的整数坐标，其中 points[i] = [xi, yi] 。
//
// 两点之间的距离定义为它们的曼哈顿距离。
//
// 请你恰好移除一个点，返回移除后任意两点之间的 最大 距离可能的 最小 值。
//
//
//
// 示例 1：
//
//
//输入：points = [[3,10],[5,15],[10,2],[4,4]]
//输出：12
//解释：移除每个点后的最大距离如下所示：
//- 移除第 0 个点后，最大距离在点 (5, 15) 和 (10, 2) 之间，为 |5 - 10| + |15 - 2| = 18 。
//- 移除第 1 个点后，最大距离在点 (3, 10) 和 (10, 2) 之间，为 |3 - 10| + |10 - 2| = 15 。
//- 移除第 2 个点后，最大距离在点 (5, 15) 和 (4, 4) 之间，为 |5 - 4| + |15 - 4| = 12 。
//- 移除第 3 个点后，最大距离在点 (5, 15) 和 (10, 2) 之间的，为 |5 - 10| + |15 - 2| = 18 。
//在恰好移除一个点后，任意两点之间的最大距离可能的最小值是 12 。
//
//
// 示例 2：
//
//
//输入：points = [[1,1],[1,1],[1,1]]
//输出：0
//解释：移除任一点后，任意两点之间的最大距离都是 0 。
//
//
//
//
// 提示：
//
//
// 3 <= points.length <= 10⁵
// points[i].length == 2
// 1 <= points[i][0], points[i][1] <= 10⁸
//
//
// Related Topics 几何 数组 数学 有序集合 排序 👍 28 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinimizeManhattanDistances{
    public static void main(String[] args){
        Solution solution = new MinimizeManhattanDistances().new Solution();
        System.out.println(solution.minimumDistance(new int[][]{{3,10},{5,15},{10,2},{4,4}}));
        System.out.println(solution.minimumDistance(new int[][]{{1,1},{1,1},{1,1}}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumDistance(int[][] points) {
        int n = points.length;
        List<int[]> sx = new ArrayList<>();
        List<int[]> sy = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = points[i][0];
            int y = points[i][1];
            sx.add(new int[]{x-y, i});
            sy.add(new int[]{x+y, i});
        }
        sx.sort(Comparator.comparingInt(a -> a[0]));
        sy.sort(Comparator.comparingInt(a -> a[0]));
        int maxVal1 = sx.get(sx.size()-1)[0] - sx.get(0)[0];
        int maxVal2 = sy.get(sy.size()-1)[0] - sy.get(0)[0];
        int res = Integer.MAX_VALUE;
        if(maxVal1 >= maxVal2){
            int i = sx.get(0)[1];
            int j = sx.get(sx.size()-1)[1];
            res = Math.min(res, Math.max(remove(sx, i), remove(sy, i)));
            res = Math.min(res, Math.max(remove(sx, j), remove(sy, j)));
        }else{
            int i = sy.get(0)[1];
            int j = sy.get(sy.size()-1)[1];
            res = Math.min(res, Math.max(remove(sy, i), remove(sx, i)));
            res = Math.min(res, Math.max(remove(sy, j), remove(sx, j)));
        }
        return res;
    }

    private int remove(List<int[]> list, int i){
        int n = list.size();
        if (list.get(0)[1] == i) {
            return list.get(n-1)[0] - list.get(1)[0];
        }else if(list.get(n-1)[1] == i){
            return list.get(n-2)[0] - list.get(0)[0];
        }else{
            return list.get(n-1)[0] -  list.get(0)[0];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}