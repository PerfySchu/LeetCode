//2025-05-13 11:17:12
//第3335题
//给你一个字符串 s 和一个整数 t，表示要执行的 转换 次数。每次 转换 需要根据以下规则替换字符串 s 中的每个字符：
//
//
// 如果字符是 'z'，则将其替换为字符串 "ab"。
// 否则，将其替换为字母表中的下一个字符。例如，'a' 替换为 'b'，'b' 替换为 'c'，依此类推。
//
//
// 返回 恰好 执行 t 次转换后得到的字符串的 长度。
//
// 由于答案可能非常大，返回其对 10⁹ + 7 取余的结果。
//
//
//
// 示例 1：
//
//
// 输入： s = "abcyy", t = 2
//
//
// 输出： 7
//
// 解释：
//
//
// 第一次转换 (t = 1)
//
//
//
// 'a' 变为 'b'
// 'b' 变为 'c'
// 'c' 变为 'd'
// 'y' 变为 'z'
// 'y' 变为 'z'
// 第一次转换后的字符串为："bcdzz"
//
//
// 第二次转换 (t = 2)
//
// 'b' 变为 'c'
// 'c' 变为 'd'
// 'd' 变为 'e'
// 'z' 变为 "ab"
// 'z' 变为 "ab"
// 第二次转换后的字符串为："cdeabab"
//
//
// 最终字符串长度：字符串为 "cdeabab"，长度为 7 个字符。
//
//
// 示例 2：
//
//
// 输入： s = "azbk", t = 1
//
//
// 输出： 5
//
// 解释：
//
//
// 第一次转换 (t = 1)
//
//
//
// 'a' 变为 'b'
// 'z' 变为 "ab"
// 'b' 变为 'c'
// 'k' 变为 'l'
// 第一次转换后的字符串为："babcl"
//
//
// 最终字符串长度：字符串为 "babcl"，长度为 5 个字符。
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁵
// s 仅由小写英文字母组成。
// 1 <= t <= 10⁵
//
//
// Related Topics 哈希表 数学 字符串 动态规划 计数 👍 24 👎 0

package leetcode.editor.cn;
public class TotalCharactersInStringAfterTransformationsI{
    public static void main(String[] args){
        Solution solution = new TotalCharactersInStringAfterTransformationsI().new Solution();
        System.out.println(solution.lengthAfterTransformations("abcyy",2));
        System.out.println(solution.lengthAfterTransformations("azbk",1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int mod = 1000000007;
        int n = s.length();
        int ans = 0;
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        for (int i = 0; i < t; i++) {
            int[] next = new int[26];
            next[0] = charCount[25];
            next[1] = (charCount[25] + charCount[0]) % mod;
            for (int j = 2; j < 26; j++) {
                next[j] = charCount[j - 1];
            }
            charCount = next;
        }
        for (int i = 0; i < 26; i++) {
            ans = (ans + charCount[i]) % mod;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}