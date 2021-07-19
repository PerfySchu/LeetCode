//第59题
//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 447 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class SpiralMatrixIi{
    public static void main(String[] args){
        Solution solution = new SpiralMatrixIi().new Solution();
        System.out.printf(Arrays.deepToString(solution.generateMatrix(1)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0;
        int right = n-1;
        int bottom = n-1;
        int left = 0;
        int num = 1;
        while (left<right && top<bottom){
            for (int i = left; i<right; i++){
                matrix[top][i] = num++;
            }
            for (int i = top; i<bottom; i++){
                matrix[i][right] = num++;
            }
            for (int i=right; i>left; i--){
                 matrix[bottom][i] = num++;
            }
            for (int i=bottom; i>top; i--){
                matrix[i][left] = num++;
            }
            top++;
            right--;
            bottom--;
            left++;
        }
        if(left==right){
            matrix[left][left] = num;
        }
        return matrix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}