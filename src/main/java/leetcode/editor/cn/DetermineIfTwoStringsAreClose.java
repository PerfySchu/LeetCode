//2023-11-30 09:08:29
//第1657题
//如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：
//
//
// 操作 1：交换任意两个 现有 字符。
//
//
//
// 例如，abcde -> aecdb
//
//
// 操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
//
// 例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
//
//
//
//
// 你可以根据需要对任意一个字符串多次使用这两种操作。
//
// 给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
//输入：word1 = "abc", word2 = "bca"
//输出：true
//解释：2 次操作从 word1 获得 word2 。
//执行操作 1："abc" -> "acb"
//执行操作 1："acb" -> "bca"
//
//
// 示例 2：
//
//
//输入：word1 = "a", word2 = "aa"
//输出：false
//解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
//
// 示例 3：
//
//
//输入：word1 = "cabbba", word2 = "abbccc"
//输出：true
//解释：3 次操作从 word1 获得 word2 。
//执行操作 1："cabbba" -> "caabbb"
//执行操作 2："caabbb" -> "baaccc"
//执行操作 2："baaccc" -> "abbccc"
//
//
// 示例 4：
//
//
//输入：word1 = "cabbba", word2 = "aabbss"
//输出：false
//解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
//
//
//
// 提示：
//
//
// 1 <= word1.length, word2.length <= 10⁵
// word1 和 word2 仅包含小写英文字母
//
//
// Related Topics 哈希表 字符串 排序 👍 88 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DetermineIfTwoStringsAreClose{
    public static void main(String[] args){
        Solution solution = new DetermineIfTwoStringsAreClose().new Solution();
        System.out.println(solution.closeStrings("abc", "bca"));
        System.out.println(solution.closeStrings("a", "aa"));
        System.out.println(solution.closeStrings("cabbba", "abbccc"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean closeStrings(String word1, String word2) {
        Map<Character, Integer> charMap1 = new HashMap<>();
        Map<Character, Integer> charMap2 = new HashMap<>();
        for (char c : word1.toCharArray()) {
            charMap1.put(c, charMap1.getOrDefault(c, 0)+1);
        }
        for (char c : word2.toCharArray()) {
            charMap2.put(c, charMap2.getOrDefault(c, 0)+1);
        }
        Set<Character> set1 = charMap1.keySet();
        Set<Character> set2 = charMap2.keySet();
        List<Integer> value1 = new ArrayList<>(charMap1.values());
        List<Integer> value2 = new ArrayList<>(charMap2.values());
        if (set1.size() != set2.size() || !set1.containsAll(set2)) {
            return false;
        }
        Collections.sort(value1);
        Collections.sort(value2);
        for (int i = 0; i < value1.size(); i++) {
            if (!value1.get(i).equals(value2.get(i))) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}