//2021-11-16 10:34:09
//第391题
//给你一个数组 rectangles ，其中 rectangles[i] = [xi, yi, ai, bi] 表示一个坐标轴平行的矩形。这个矩形的左下顶点是
// (xi, yi) ，右上顶点是 (ai, bi) 。 
//
// 如果所有矩形一起精确覆盖了某个矩形区域，则返回 true ；否则，返回 false 。 
// 
//
// 示例 1： 
//
// 
//输入：rectangles = [[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]
//输出：true
//解释：5 个矩形一起可以精确地覆盖一个矩形区域。 
// 
//
// 示例 2： 
//
// 
//输入：rectangles = [[1,1,2,3],[1,3,2,4],[3,1,4,2],[3,2,4,4]]
//输出：false
//解释：两个矩形之间有间隔，无法覆盖成一个矩形。 
//
// 示例 3： 
//
// 
//输入：rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[3,2,4,4]]
//输出：false
//解释：图形顶端留有空缺，无法覆盖成一个矩形。 
//
// 示例 4： 
//
// 
//输入：rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[2,2,4,4]]
//输出：false
//解释：因为中间有相交区域，虽然形成了矩形，但不是精确覆盖。 
//
// 
//
// 提示： 
//
// 
// 1 <= rectangles.length <= 2 * 10⁴ 
// rectangles[i].length == 4 
// -10⁵ <= xi, yi, ai, bi <= 10⁵ 
// 
// Related Topics 数组 扫描线 👍 133 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class PerfectRectangle{
    public static void main(String[] args){
        Solution solution = new PerfectRectangle().new Solution();
        System.out.println(solution.isRectangleCover(new int[][]{{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        Set<String> points = new HashSet<>();
        int minLeft = Integer.MAX_VALUE, minBottom = Integer.MAX_VALUE;
        int maxRight = Integer.MIN_VALUE, maxTop = Integer.MIN_VALUE;
        int area = 0;
        for (int[] rectangle : rectangles) {
            int left = rectangle[0];
            int bottom = rectangle[1];
            int right = rectangle[2];
            int top = rectangle[3];
            area += (right - left) * (top - bottom);
            minLeft = Math.min(minLeft, left);
            minBottom = Math.min(minBottom, bottom);
            maxRight = Math.max(maxRight, right);
            maxTop = Math.max(maxTop, top);
            String bottomLeft = bottom+"-"+left;
            String bottomRight = bottom+"-"+right;
            String topLeft = top+"-"+left;
            String topRight = top+"-"+right;
            if (points.contains(bottomLeft)) {
                points.remove(bottomLeft);
            }else{
                points.add(bottomLeft);
            }
            if (points.contains(bottomRight)) {
                points.remove(bottomRight);
            }else{
                points.add(bottomRight);
            }
            if (points.contains(topLeft)) {
                points.remove(topLeft);
            }else{
                points.add(topLeft);
            }
            if (points.contains(topRight)) {
                points.remove(topRight);
            }else{
                points.add(topRight);
            }
        }
        if(points.size() == 4 && points.contains(minBottom+"-"+minLeft) && points.contains(maxTop+"-"+minLeft)
                && points.contains(minBottom+"-"+maxRight) && points.contains(maxTop+"-"+maxRight)){
            return area == (maxRight - minLeft) * (maxTop - minBottom);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
