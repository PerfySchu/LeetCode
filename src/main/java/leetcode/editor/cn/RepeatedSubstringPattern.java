//2024-09-05 10:42:19
//第459题
//给定一个非空的字符串
// s ，检查是否可以通过由它的一个子串重复多次构成。
//
//
//
// 示例 1:
//
//
//输入: s = "abab"
//输出: true
//解释: 可由子串 "ab" 重复两次构成。
//
//
// 示例 2:
//
//
//输入: s = "aba"
//输出: false
//
//
// 示例 3:
//
//
//输入: s = "abcabcabcabc"
//输出: true
//解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
//
//
//
//
// 提示：
//
//
//
//
//
// 1 <= s.length <= 10⁴
// s 由小写英文字母组成
//
//
// Related Topics 字符串 字符串匹配 👍 1208 👎 0

package leetcode.editor.cn;


public class RepeatedSubstringPattern{
    public static void main(String[] args){
        Solution solution = new RepeatedSubstringPattern().new Solution();
        System.out.println(solution.repeatedSubstringPattern("abab"));
        System.out.println(solution.repeatedSubstringPattern("aba"));
        System.out.println(solution.repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(solution.repeatedSubstringPattern("ababba"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if (n == 1) {
            return false;
        }
        for (int i = 1; i <= n / 2; i++) {
            if (n % i!= 0) {
                continue;
            }
            boolean match = true;
            for (int j = i; j < n; j++) {
                if(s.charAt(j) != s.charAt(j-i)){
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}