//2022-03-02 09:16:31
//第564题
//给定一个表示整数的字符串 n ，返回与它最近的回文整数（不包括自身）。如果不止一个，返回较小的那个。
//
// “最近的”定义为两个整数差的绝对值最小。
//
//
//
// 示例 1:
//
//
//输入: n = "123"
//输出: "121"
//
//
// 示例 2:
//
//
//输入: n = "1"
//输出: "0"
//解释: 0 和 2是最近的回文，但我们返回最小的，也就是 0。
//
//
//
//
// 提示:
//
//
// 1 <= n.length <= 18
// n 只由数字组成
// n 不含前导 0
// n 代表在 [1, 10¹⁸ - 1] 范围内的整数
//
// Related Topics 数学 字符串 👍 130 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class FindTheClosestPalindrome{
    public static void main(String[] args){
        Solution solution = new FindTheClosestPalindrome().new Solution();
        System.out.println(solution.nearestPalindromic("123"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public String nearestPalindromic(String s) {
            int n = s.length();
            long cur = Long.parseLong(s);
            Set<Long> set = new HashSet<>();
            set.add((long) Math.pow(10, n - 1) - 1);
            set.add((long) Math.pow(10, n) + 1);
            long t = Long.parseLong(s.substring(0, (n + 1) / 2));
            for (long i = t - 1; i <= t + 1; i++) {
                long temp = -1;
                if (n % 2 == 0) temp = getNum(i, true);
                else temp = getNum(i, false);
                if (temp != cur) set.add(temp);
            }
            long ans = -1;
            for (long i : set) {
                if (ans == -1) ans = i;
                else if (Math.abs(i - cur) < Math.abs(ans - cur)) ans = i;
                else if (Math.abs(i - cur) == Math.abs(ans - cur) && i < ans) ans = i;
            }
            return String.valueOf(ans);
        }

        long getNum(long k, boolean isEven) {
            StringBuilder sb = new StringBuilder();
            sb.append(k);
            int idx = isEven ? sb.length() - 1 : sb.length() - 2;
            while (idx >= 0) sb.append(sb.charAt(idx--));
            return Long.parseLong(sb.toString());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}