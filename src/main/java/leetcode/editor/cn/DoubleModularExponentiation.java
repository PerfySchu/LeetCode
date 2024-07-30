//2024-07-30 11:11:34
//第2961题
//给你一个下标从 0 开始的二维数组 variables ，其中 variables[i] = [ai, bi, ci, mi]，以及一个整数 target
//。
//
// 如果满足以下公式，则下标 i 是 好下标：
//
//
// 0 <= i < variables.length
// ((aibi % 10)ci) % mi == target
//
//
// 返回一个由 好下标 组成的数组，顺序不限 。
//
//
//
// 示例 1：
//
//
//输入：variables = [[2,3,3,10],[3,3,3,1],[6,1,1,4]], target = 2
//输出：[0,2]
//解释：对于 variables 数组中的每个下标 i ：
//1) 对于下标 0 ，variables[0] = [2,3,3,10] ，(2³ % 10)³ % 10 = 2 。
//2) 对于下标 1 ，variables[1] = [3,3,3,1] ，(3³ % 10)³ % 1 = 0 。
//3) 对于下标 2 ，variables[2] = [6,1,1,4] ，(6¹ % 10)¹ % 4 = 2 。
//因此，返回 [0,2] 作为答案。
//
//
// 示例 2：
//
//
//输入：variables = [[39,3,1000,1000]], target = 17
//输出：[]
//解释：对于 variables 数组中的每个下标 i ：
//1) 对于下标 0 ，variables[0] = [39,3,1000,1000] ，(39³ % 10)¹⁰⁰⁰ % 1000 = 1 。
//因此，返回 [] 作为答案。
//
//
//
//
// 提示：
//
//
// 1 <= variables.length <= 100
// variables[i] == [ai, bi, ci, mi]
// 1 <= ai, bi, ci, mi <= 10³
// 0 <= target <= 10³
//
//
// Related Topics 数组 数学 模拟 👍 16 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class DoubleModularExponentiation{
    public static void main(String[] args){
        Solution solution = new DoubleModularExponentiation().new Solution();
        System.out.println(solution.getGoodIndices(new int[][]{{2,3,3,10},{3,3,3,1},{6,1,1,4}}, 2));
        System.out.println(solution.getGoodIndices(new int[][]{{39,3,1000,1000}}, 17));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int[] v = variables[i];
           if(powMod(powMod(v[0], v[1], 10), v[2], v[3]) == target){
               ans.add(i);
           }
        }
        return ans;
    }

    public int powMod(int x, int y, int mod){
        int res = 1;
        while(y != 0){
            if((y&1) != 0){
                res = res * x % mod;
            }
            x = x * x % mod;
            y >>= 1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}