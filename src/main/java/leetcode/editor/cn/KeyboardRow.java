//2024-09-05 14:31:47
//第500题
//给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
//
// 美式键盘 中：
//
//
// 第一行由字符 "qwertyuiop" 组成。
// 第二行由字符 "asdfghjkl" 组成。
// 第三行由字符 "zxcvbnm" 组成。
//
//
//
//
//
//
// 示例 1：
//
//
//输入：words = ["Hello","Alaska","Dad","Peace"]
//输出：["Alaska","Dad"]
//
//
// 示例 2：
//
//
//输入：words = ["omk"]
//输出：[]
//
//
// 示例 3：
//
//
//输入：words = ["adsdf","sfd"]
//输出：["adsdf","sfd"]
//
//
//
//
// 提示：
//
//
// 1 <= words.length <= 20
// 1 <= words[i].length <= 100
// words[i] 由英文字母（小写和大写字母）组成
//
//
// Related Topics 数组 哈希表 字符串 👍 265 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Set;

public class KeyboardRow{
    public static void main(String[] args){
        Solution solution = new KeyboardRow().new Solution();
        System.out.println(Arrays.toString(solution.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
        System.out.println(Arrays.toString(solution.findWords(new String[]{"omk"})));
        System.out.println(Arrays.toString(solution.findWords(new String[]{"adsdf", "sfd"})));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] findWords(String[] words) {
        Set<Character> row1 = Set.of('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p');
        Set<Character> row2 = Set.of('a','s', 'd', 'f', 'g', 'h', 'j', 'k', 'l');
        Set<Character> row3 = Set.of('z', 'x', 'c', 'v', 'b', 'n','m');
        String[] res = new String[words.length];
        int index = 0;
        for (String word : words) {
            boolean flag1 = true;
            boolean flag2 = true;
            boolean flag3 = true;
            char[] chars = word.toLowerCase().toCharArray();
            for (char c : chars) {
                if (!row1.contains(c)) {
                    flag1 = false;
                }
                if (!row2.contains(c)) {
                    flag2 = false;
                }
                if (!row3.contains(c)) {
                    flag3 = false;
                }
            }
            if(flag1 || flag2 || flag3) {
                res[index++] = word;
            }
        }
        return Arrays.copyOf(res, index);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}