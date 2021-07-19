//第119题
//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组 动态规划 
// 👍 304 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangleIi{
    public static void main(String[] args){
        Solution solution = new PascalsTriangleIi().new Solution();
        System.out.println(solution.getRow(30));
        System.out.println(solution2(6));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        //杨辉三角指定行列公式
        // n行，i列 C(n,i)=n!/(i!*(n-i)!)
        //那么 【n行 i+1列】 相对于 【n行 i列】的比值关系是 （n-i)/(i+1)
        //List<Integer> result = new ArrayList<>(rowIndex+1);
        Integer[] res = new Integer[rowIndex+1];
        long currentNum = 1;
        for (int i = 0; i < rowIndex/2+1; i++) {
            res[i] = res[rowIndex-i] = (int)currentNum;
            currentNum = currentNum * (rowIndex-i)/(i+1);
        }
        return Arrays.asList(res);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 递归解法，时间复杂度不符合要求
     * @param rowIndex
     * @return
     */
    public static List<Integer> solution2(int rowIndex){
        if(rowIndex==0){
            return Arrays.asList(1);
        }

        Integer[] result = new Integer[rowIndex+1];

        for (int i = 0; i < rowIndex/2+1; i++) {
            int num = getNum(rowIndex, i);
            result[i] = num;
            result[rowIndex-i] = num;
        }
        return Arrays.asList(result);
    }


    //获取指定行列的值
    private static int getNum(int row, int column){
        if(row == 0 || column == 0 || row == column){
            return 1;
        }
        return getNum(row-1, column-1) + getNum(row-1, column);
    }
}
