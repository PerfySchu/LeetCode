//2023-05-25 10:01:09
//第2451题
//给你一个字符串数组 words ，每一个字符串长度都相同，令所有字符串的长度都为 n 。
//
// 每个字符串 words[i] 可以被转化为一个长度为 n - 1 的 差值整数数组 difference[i] ，其中对于 0 <= j <= n - 2
// 有 difference[i][j] = words[i][j+1] - words[i][j] 。注意两个字母的差值定义为它们在字母表中 位置 之差，也就是
//说 'a' 的位置是 0 ，'b' 的位置是 1 ，'z' 的位置是 25 。
//
//
// 比方说，字符串 "acb" 的差值整数数组是 [2 - 0, 1 - 2] = [2, -1] 。
//
//
// words 中所有字符串 除了一个字符串以外 ，其他字符串的差值整数数组都相同。你需要找到那个不同的字符串。
//
// 请你返回 words中 差值整数数组 不同的字符串。
//
//
//
// 示例 1：
//
//
//输入：words = ["adc","wzy","abc"]
//输出："abc"
//解释：
//- "adc" 的差值整数数组是 [3 - 0, 2 - 3] = [3, -1] 。
//- "wzy" 的差值整数数组是 [25 - 22, 24 - 25]= [3, -1] 。
//- "abc" 的差值整数数组是 [1 - 0, 2 - 1] = [1, 1] 。
//不同的数组是 [1, 1]，所以返回对应的字符串，"abc"。
//
//
// 示例 2：
//
//
//输入：words = ["aaa","bob","ccc","ddd"]
//输出："bob"
//解释：除了 "bob" 的差值整数数组是 [13, -13] 以外，其他字符串的差值整数数组都是 [0, 0] 。
//
//
//
//
// 提示：
//
//
// 3 <= words.length <= 100
// n == words[i].length
// 2 <= n <= 20
// words[i] 只含有小写英文字母。
//
//
// Related Topics 数组 哈希表 字符串 👍 30 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class OddStringDifference{
    public static void main(String[] args){
        Solution solution = new OddStringDifference().new Solution();
        //System.out.println(solution.oddString(new String[]{"adc","wzy","abc"}));
        //System.out.println(solution.oddString(new String[]{"aaa","bob","ccc","ddd"}));
        System.out.println(solution.oddString(new String[]{"abm","bcn","alm"}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String oddString(String[] words) {
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> coutnMap = new HashMap<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            char[] chars = word.toCharArray();
            for (int i = 1; i < chars.length; i++) {
                sb.append(chars[i] - chars[i-1]).append(",");
            }
            map.put(word, sb.toString());
            coutnMap.put(sb.toString(), coutnMap.getOrDefault(sb.toString(), 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : coutnMap.entrySet()) {
            if (entry.getValue() == 1) {
                for (Map.Entry<String, String> entry1 : map.entrySet()) {
                    if (entry1.getValue().equals(entry.getKey())) {
                        return entry1.getKey();
                    }
                }
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}