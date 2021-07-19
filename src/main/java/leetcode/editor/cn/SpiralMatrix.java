//第54题
//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 822 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix{
    public static void main(String[] args){
        Solution solution = new SpiralMatrix().new Solution();
        System.out.println(solution.spiralOrder(new int[][]{{1,2,3,},{4,5,6,},{7,8,9},{10,11,12}}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int top=0;
        int right = colNum-1;
        int bottom = rowNum -1;
        int left = 0;
        while (left<right && top<bottom) {
            //处理上边界
            for (int i = left; i < right; i++) {
                result.add(matrix[top][i]);
            }
            //处理右边界
            for (int i = top; i < bottom; i++) {
                result.add(matrix[i][right]);
            }
            //处理下边界
            for (int i=right; i>left; i--){
                result.add(matrix[bottom][i]);
            }
            //处理左边界
            for (int i=bottom; i>top; i--){
                result.add(matrix[i][left]);
            }
            top++;
            right--;
            bottom--;
            left++;
        }
        if(left ==right){
            //剩下一列
            for (int i=top; i<=bottom; i++){
                result.add(matrix[i][left]);
            }
        }else if(top == bottom){
            //剩下一行
            for (int i=left; i<=right; i++){
                result.add(matrix[top][i]);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}