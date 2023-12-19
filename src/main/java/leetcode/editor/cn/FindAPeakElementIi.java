//2023-12-19 09:15:10
//第1901题
//一个 2D 网格中的 峰值 是指那些 严格大于 其相邻格子(上、下、左、右)的元素。
//
// 给你一个 从 0 开始编号 的 m x n 矩阵 mat ，其中任意两个相邻格子的值都 不相同 。找出 任意一个 峰值 mat[i][j] 并 返回其位置
// [i,j] 。
//
// 你可以假设整个矩阵周边环绕着一圈值为 -1 的格子。
//
// 要求必须写出时间复杂度为 O(m log(n)) 或 O(n log(m)) 的算法
//
//
//
//
//
// 示例 1:
//
//
//
//
//输入: mat = [[1,4],[3,2]]
//输出: [0,1]
//解释: 3 和 4 都是峰值，所以[1,0]和[0,1]都是可接受的答案。
//
//
// 示例 2:
//
//
//
//
//输入: mat = [[10,20,15],[21,30,14],[7,16,32]]
//输出: [1,1]
//解释: 30 和 32 都是峰值，所以[1,1]和[2,2]都是可接受的答案。
//
//
//
//
// 提示：
//
//
// m == mat.length
// n == mat[i].length
// 1 <= m, n <= 500
// 1 <= mat[i][j] <= 10⁵
// 任意两个相邻元素均不相等.
//
//
// Related Topics 数组 二分查找 矩阵 👍 94 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class FindAPeakElementIi{
    public static void main(String[] args){
        Solution solution = new FindAPeakElementIi().new Solution();
        System.out.println(Arrays.toString(solution.findPeakGrid(new int[][]{{1, 4}, {3, 2}})));
        System.out.println(Arrays.toString(solution.findPeakGrid(new int[][]{{10, 20, 15}, {21, 30, 14}, {7, 16, 32}})));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int low = 0;
        int high = m-1;
        while (low <= high){
            int i = (low+high)/2;
            int j = -1;
            int maxElement = -1;
            for (int k = 0; k < n; k++) {
                if (mat[i][k] > maxElement) {
                    j = k;
                    maxElement = mat[i][k];
                }
            }
            if(i-1 >= 0 && mat[i][j] < mat[i-1][j]){
                high = i - 1;
                continue;
            }
            if(i+1 < m && mat[i][j] < mat[i+1][j]){
                low = i + 1;
                continue;
            }
            return new int[]{i,j};
        }
        return new int[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}