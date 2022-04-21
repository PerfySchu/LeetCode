//2022-03-31 10:13:15
//第2002题
//给你一个字符串 s ，请你找到 s 中两个 不相交回文子序列 ，使得它们长度的 乘积最大 。两个子序列在原字符串中如果没有任何相同下标的字符，则它们是 不相
//交 的。
//
// 请你返回两个回文子序列长度可以达到的 最大乘积 。
//
// 子序列 指的是从原字符串中删除若干个字符（可以一个也不删除）后，剩余字符不改变顺序而得到的结果。如果一个字符串从前往后读和从后往前读一模一样，那么这个字符
//串是一个 回文字符串 。
//
//
//
// 示例 1：
//
//
//
// 输入：s = "leetcodecom"
//输出：9
//解释：最优方案是选择 "ete" 作为第一个子序列，"cdc" 作为第二个子序列。
//它们的乘积为 3 * 3 = 9 。
//
//
// 示例 2：
//
// 输入：s = "bb"
//输出：1
//解释：最优方案为选择 "b" （第一个字符）作为第一个子序列，"b" （第二个字符）作为第二个子序列。
//它们的乘积为 1 * 1 = 1 。
//
//
// 示例 3：
//
// 输入：s = "accbcaxxcxx"
//输出：25
//解释：最优方案为选择 "accca" 作为第一个子序列，"xxcxx" 作为第二个子序列。
//它们的乘积为 5 * 5 = 25 。
//
//
//
//
// 提示：
//
//
// 2 <= s.length <= 12
// s 只含有小写英文字母。
//
// Related Topics 位运算 字符串 动态规划 回溯 状态压缩 👍 37 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class MaximumProductOfTheLengthOfTwoPalindromicSubsequences{
    public static void main(String[] args){
        Solution solution = new MaximumProductOfTheLengthOfTwoPalindromicSubsequences().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(String s) {
        int max = 1 << s.length();
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < max; i++) {
            if(check(s, i)){
                list.add(new int[]{i, getNum1(i)});
            }
        }
        int n = list.size();
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if((list.get(i)[0] & list.get(j)[0]) == 0){
                    res = Math.max(list.get(i)[1] * list.get(j)[1], res);
                }
            }
        }
        return res;
    }

        /**
         * @param n 选择的情况
         * @return 当前情况下回文串的长度
         */
        private int getNum1(Integer n) {
            int count = 0;
            while (n != 0) {
                count++;
                n = n & (n - 1);
            }
            return count;
        }

        /**
         * @param n 选择的情况
         * @return 当前情况是否是回文子串
         */
        private boolean check(String s, int n) {
            StringBuilder ss = new StringBuilder();
            int index = 0;
            while (n != 0) {
                if ((n & 1) == 1) {
                    ss.append(s.charAt(index));
                }
                n = n >> 1;
                index++;
            }
            int len = ss.length();
            for (int i = 0; i * 2 < len; i++) {
                if (ss.charAt(i) != ss.charAt(len - 1 - i)) return false;
            }
            return true;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}