//第240题
//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性： 
//
// 
// 每行的元素从左到右升序排列。 
// 每列的元素从上到下升序排列。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 5
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 20
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= n, m <= 300 
// -109 <= matix[i][j] <= 109 
// 每行的所有元素从左到右升序排列 
// 每列的所有元素从上到下升序排列 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 分治 矩阵 
// 👍 670 👎 0

package leetcode.editor.cn;
public class SearchA2dMatrixIi{
    public static void main(String[] args){
        Solution solution = new SearchA2dMatrixIi().new Solution();
        System.out.println(solution.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 20));
        System.out.println(solution2(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 10));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length == 0){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        //右上角为基准
        int i=0,j=col-1;
        while (i<row && j>=0){
            if(target == matrix[i][j]){
                return true;
            }
            if(target < matrix[i][j]){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 左下角解法
     * @param matrix
     * @param target
     * @return
     */
    private static boolean solution2(int[][] matrix, int target){
        int i=matrix.length-1,j=0;
        while (i>=0 && j<matrix[0].length){
            if(target == matrix[i][j]){
                return true;
            }
            if(target > matrix[i][j]){
                j++;
            }else{
                i--;
            }
        }
        return false;
    }
}
