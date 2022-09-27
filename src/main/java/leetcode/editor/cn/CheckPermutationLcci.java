//2022-09-27 13:41:57
//第面试题 01.02题
//给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
//
// 示例 1：
//
// 输入: s1 = "abc", s2 = "bca"
//输出: true
//
//
// 示例 2：
//
// 输入: s1 = "abc", s2 = "bad"
//输出: false
//
//
// 说明：
//
//
// 0 <= len(s1) <= 100
// 0 <= len(s2) <= 100
//
//
// Related Topics 哈希表 字符串 排序 👍 114 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutationLcci{
    public static void main(String[] args){
        Solution solution = new CheckPermutationLcci().new Solution();
        System.out.println(solution.CheckPermutation("abc", "cba"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (char aChar : s1.toCharArray()) {
            charMap.put(aChar, charMap.getOrDefault(aChar, 0) + 1);
        }
        for (char c : s2.toCharArray()) {
            if (!charMap.containsKey(c) || charMap.get(c) == 0) {
                return false;
            }
            charMap.put(c, charMap.getOrDefault(c, 0)-1);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}