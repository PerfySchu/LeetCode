//2023-05-19 11:01:20
//第1079题
//你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
//
// 注意：本题中，每个活字字模只能使用一次。
//
//
//
// 示例 1：
//
//
//输入："AAB"
//输出：8
//解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
//
//
// 示例 2：
//
//
//输入："AAABBC"
//输出：188
//
//
// 示例 3：
//
//
//输入："V"
//输出：1
//
//
//
// 提示：
//
//
// 1 <= tiles.length <= 7
// tiles 由大写英文字母组成
//
//
// Related Topics 哈希表 字符串 回溯 计数 👍 191 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class LetterTilePossibilities{
    public static void main(String[] args){
        Solution solution = new LetterTilePossibilities().new Solution();
        System.out.println(solution.numTilePossibilities("AAB"));
        System.out.println(solution.numTilePossibilities("AAABBC"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        char[] chars = tiles.toCharArray();
        boolean[] visited = new boolean[chars.length];
        dfs(chars, visited, "", set);
        return set.size();
    }

    private void dfs(char[] chars, boolean[] visited, String s, Set<String> set) {
        if (s.length() > 0) {
            set.add(s);
        }
        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(chars, visited, s + chars[i], set);
            visited[i] = false;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}