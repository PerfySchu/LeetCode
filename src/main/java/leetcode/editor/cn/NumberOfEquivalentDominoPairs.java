//2022-07-30 10:45:18
//第1128题
//给你一个由一些多米诺骨牌组成的列表 dominoes。
//
// 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
//
// 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且
//b==c。
//
// 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i,
// j) 的数量。
//
//
//
// 示例：
//
// 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= dominoes.length <= 40000
// 1 <= dominoes[i][j] <= 9
//
//
// Related Topics 数组 哈希表 计数 👍 141 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class NumberOfEquivalentDominoPairs{
    public static void main(String[] args){
        Solution solution = new NumberOfEquivalentDominoPairs().new Solution();
        System.out.println(solution.numEquivDominoPairs(new int[][]{{1,2},{2,1},{3,4},{5,6}}));
        System.out.println(solution.numEquivDominoPairs(new int[][]{{1,2},{1,2},{1,1},{1,2},{2,2}}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> pairs = new HashMap<>();
        int ans = 0;
        for (int[] dominoe : dominoes) {
            if(dominoe[0] > dominoe[1]){
                int temp = dominoe[0];
                dominoe[0] = dominoe[1];
                dominoe[1] = temp;
            }
            String key = dominoe[0] + "," + dominoe[1];
            ans += pairs.getOrDefault(key, 0);
            pairs.put(key, pairs.getOrDefault(key, 0)+1);

        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}