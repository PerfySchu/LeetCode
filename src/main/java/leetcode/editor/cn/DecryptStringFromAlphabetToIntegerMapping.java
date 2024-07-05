//2024-07-05 10:22:56
//第1309题
//给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
//
//
// 字符（'a' - 'i'）分别用（'1' - '9'）表示。
// 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。
//
//
// 返回映射之后形成的新字符串。
//
// 题目数据保证映射始终唯一。
//
//
//
// 示例 1：
//
//
//输入：s = "10#11#12"
//输出："jkab"
//解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
//
//
// 示例 2：
//
//
//输入：s = "1326#"
//输出："acz"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s[i] 只包含数字（'0'-'9'）和 '#' 字符。
// s 是映射始终存在的有效字符串。
//
//
// Related Topics 字符串 👍 88 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class DecryptStringFromAlphabetToIntegerMapping{
    public static void main(String[] args){
        Solution solution = new DecryptStringFromAlphabetToIntegerMapping().new Solution();
        System.out.println(solution.freqAlphabets("10#11#12"));
        System.out.println(solution.freqAlphabets("1326#"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String freqAlphabets(String s) {
        List<Character> list = new ArrayList<>();
        for (int n = s.length()-1; n >= 0; n--) {
            if (s.charAt(n) == '#') {
                String substring = s.substring(n - 2, n);
                list.add((char) (Integer.parseInt(substring) + 96));
                n -= 2;
            }else{
                list.add((char) (s.charAt(n) + 48));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            stringBuilder.append(list.get(i));
        }
        return stringBuilder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}