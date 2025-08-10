//2025-08-10 11:39:42
//第869题
//给定正整数 n ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
//
// 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
//
//
//
//
//
//
// 示例 1：
//
//
//输入：n = 1
//输出：true
//
//
// 示例 2：
//
//
//输入：n = 10
//输出：false
//
//
//
//
// 提示：
//
//
// 1 <= n <= 10⁹
//
//
// Related Topics 哈希表 数学 计数 枚举 排序 👍 194 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class ReorderedPowerOf2{
    public static void main(String[] args){
        Solution solution = new ReorderedPowerOf2().new Solution();
        System.out.println(solution.reorderedPowerOf2(10));
        System.out.println(solution.reorderedPowerOf2(1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Set<String> powerOf2Digits = new HashSet<>();
    public boolean reorderedPowerOf2(int n) {
        init();
        return powerOf2Digits.contains(countDigits(n));
    }

    public void init(){
        for (int i = 1; i <= 1e9; i<<=1) {
            powerOf2Digits.add(countDigits(i));
        }
    }

    public String countDigits(int n){
        char[] cnt = new char[10];
        while (n > 0) {
            cnt[n % 10]++;
            n /= 10;
        }
        return new String(cnt);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}