//2022-08-12 14:38:11
//第1417题
//给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
//
// 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
//
// 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
//
//
//
// 示例 1：
//
// 输入：s = "a0b1c2"
//输出："0a1b2c"
//解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
//
//
// 示例 2：
//
// 输入：s = "leetcode"
//输出：""
//解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。
//
//
// 示例 3：
//
// 输入：s = "1229857369"
//输出：""
//解释："1229857369" 中只有数字，所以无法满足重新格式化的条件。
//
//
// 示例 4：
//
// 输入：s = "covid2019"
//输出："c2o0v1i9d"
//
//
// 示例 5：
//
// 输入：s = "ab123"
//输出："1a2b3"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 500
// s 仅由小写英文字母和/或数字组成。
//
//
// Related Topics 字符串 👍 83 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ReformatTheString{
    public static void main(String[] args){
        Solution solution = new ReformatTheString().new Solution();
        System.out.println(solution.reformat("a0b1c2"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reformat(String s) {
        char[] chars = s.toCharArray();
        List<Character> charList = new ArrayList<>();
        List<Character> numList = new ArrayList<>();
        for (char aChar : chars) {
            if (aChar >= 'a' && aChar <= 'z') {
                charList.add(aChar);
            }else{
                numList.add(aChar);
            }
        }
        int charSize = charList.size();
        int numSize = numList.size();
        if(Math.abs(charSize - numSize) > 1){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if(charSize > numSize){
            sb.append(charList.get(0));
            for (int i = 0; i < numSize; i++) {
                sb.append(numList.get(i));
                sb.append(charList.get(i+1));
            }
        }else if (charSize < numSize){
            sb.append(numList.get(0));
            for (int i = 0; i < charSize; i++) {
                sb.append(charList.get(i));
                sb.append(numList.get(i+1));
            }
        }else{
            for (int i = 0; i < charSize; i++) {
                sb.append(charList.get(i));
                sb.append(numList.get(i));
            }
        }

        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}