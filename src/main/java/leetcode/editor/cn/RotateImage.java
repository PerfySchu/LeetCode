//第48题
//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。 
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[1]]
//输出：[[1]]
// 
//
// 示例 4： 
//
// 
//输入：matrix = [[1,2],[3,4]]
//输出：[[3,1],[4,2]]
// 
//
// 
//
// 提示： 
//
// 
// matrix.length == n 
// matrix[i].length == n 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
// Related Topics 数组 数学 矩阵 
// 👍 931 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class RotateImage{
    public static void main(String[] args){
        Solution solution = new RotateImage().new Solution();
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        //solution.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
        solution2(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //由外向内操作的层数
        for (int row = 0; row < n/2; row++) {
            //每层操作的次数
            for (int col = row; col < n-1-row; col++) {
                //每组4个元素相互交换位置
                int temp = matrix[row][col];
                //左下到左上
                matrix[row][col] = matrix[n-1 - col][row];
                //右下到左下
                matrix[n-1 - col][row] = matrix[n-1 - row][n-1 - col];
                //右上到右下
                matrix[n-1 - row][n-1 - col] = matrix[col][n-1 - row];
                //左上到右上
                matrix[col][n-1 - row] = temp;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 先翻转再对称和先对称再翻转结果是不同的
     * 翻转解法，水平+左对角线  或者   竖直+有对角线
     *
     *  m(row,col) --->  m(row, n-1-col)  --->   m(n-1-col, n-1-row)
     *
     *  1   2   水平翻转    2   1     左对角线      3   1
     *         =========>    /       ==========>
     *  3   4              4   3                   4   2
     *
     *
     *  m(row,col) ----> m(n-1-row,col) ---->  m(col, row)
     *  1   2   竖直翻转    3   4     右对角线      3   1
     *         =========>    \       ==========>
     *  3   4              1   2                   4   2
     *
     *  相对来讲, 竖直翻转+右对角线翻转 （等价于  右对角线+水平翻转），数据处理会友好一点
     * @param matrix
     */
    public static void solution2(int[][] matrix){
        int n = matrix.length;
        //右对角线翻转，只需要交换横纵坐标即可
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if(i != j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        System.out.println(Arrays.deepToString(matrix));

        //水平翻转，纵坐标不变，横坐标取差
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
}
