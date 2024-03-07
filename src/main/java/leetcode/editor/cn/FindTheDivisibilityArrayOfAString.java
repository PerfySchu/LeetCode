//2024-03-07 10:00:27
//第2575题
//给你一个下标从 0 开始的字符串 word ，长度为 n ，由从 0 到 9 的数字组成。另给你一个正整数 m 。
//
// word 的 可整除数组 div 是一个长度为 n 的整数数组，并满足：
//
//
// 如果 word[0,...,i] 所表示的 数值 能被 m 整除，div[i] = 1
// 否则，div[i] = 0
//
//
// 返回 word 的可整除数组。
//
//
//
// 示例 1：
//
//
//输入：word = "998244353", m = 3
//输出：[1,1,0,0,0,1,1,0,0]
//解释：仅有 4 个前缀可以被 3 整除："9"、"99"、"998244" 和 "9982443" 。
//
//
// 示例 2：
//
//
//输入：word = "1010", m = 10
//输出：[0,1,0,1]
//解释：仅有 2 个前缀可以被 10 整除："10" 和 "1010" 。
//
//
//
//
// 提示：
//
//
// 1 <= n <= 10⁵
// word.length == n
// word 由数字 0 到 9 组成
// 1 <= m <= 10⁹
//
//
// Related Topics 数组 数学 字符串 👍 34 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class FindTheDivisibilityArrayOfAString{
    public static void main(String[] args){
        Solution solution = new FindTheDivisibilityArrayOfAString().new Solution();
        System.out.println(Arrays.toString(solution.divisibilityArray("998244353", 3)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] divisibilityArray(String word, int m) {
        //问题关键： (a×10+b) mod m=(a mod m × 10 + b) mod m
        //否则长字符串直接转数字运算会爆
        int[] ans = new int[word.length()];
        long cur = 0;
        for (int i = 0; i < word.length(); i++) {
            char chr = word.charAt(i);
            int num = chr - '0';
            cur = (cur* 10 + num) % m;
            ans[i] = cur == 0 ? 1 : 0;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}