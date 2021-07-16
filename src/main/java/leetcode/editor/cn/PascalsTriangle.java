//第118题
//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 动态规划 
// 👍 530 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle{
    public static void main(String[] args){
        Solution solution = new PascalsTriangle().new Solution();
        System.out.println(solution.generate(6));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        //杨辉三角指定行列公式
        // n行，i列 C(n,i)=n!/(i!*(n-i)!)
        //那么 【n行 i+1列】 相对于 【n行 i列】的比值关系是 （n-i)/(i+1)
        //List<Integer> result = new ArrayList<>(rowIndex+1);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            Integer[] currentRow = new Integer[i+1];
            long currentNum = 1;
            for (int j = 0; j < i/2+1; j++) {
                currentRow[j] = currentRow[i-j] = (int)currentNum;
                currentNum = currentNum * (i-j)/(j+1);
            }
            result.add(Arrays.asList(currentRow));
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
