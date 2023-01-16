//2023-01-16 14:48:32
//第1813题
//一个句子是由一些单词与它们之间的单个空格组成，且句子的开头和结尾没有多余空格。比方说，"Hello World" ，"HELLO" ，"hello
//world hello world" 都是句子。每个单词都 只 包含大写和小写英文字母。
//
// 如果两个句子 sentence1 和 sentence2 ，可以通过往其中一个句子插入一个任意的句子（可以是空句子）而得到另一个句子，那么我们称这两个句子
//是 相似的 。比方说，sentence1 = "Hello my name is Jane" 且 sentence2 = "Hello Jane" ，我们可以往
// sentence2 中 "Hello" 和 "Jane" 之间插入 "my name is" 得到 sentence1 。
//
// 给你两个句子 sentence1 和 sentence2 ，如果 sentence1 和 sentence2 是相似的，请你返回 true ，否则返回
//false 。
//
//
//
// 示例 1：
//
// 输入：sentence1 = "My name is Haley", sentence2 = "My Haley"
//输出：true
//解释：可以往 sentence2 中 "My" 和 "Haley" 之间插入 "name is" ，得到 sentence1 。
//
//
// 示例 2：
//
// 输入：sentence1 = "of", sentence2 = "A lot of words"
//输出：false
//解释：没法往这两个句子中的一个句子只插入一个句子就得到另一个句子。
//
//
// 示例 3：
//
// 输入：sentence1 = "Eating right now", sentence2 = "Eating"
//输出：true
//解释：可以往 sentence2 的结尾插入 "right now" 得到 sentence1 。
//
//
// 示例 4：
//
// 输入：sentence1 = "Luky", sentence2 = "Lucccky"
//输出：false
//
//
//
//
// 提示：
//
//
// 1 <= sentence1.length, sentence2.length <= 100
// sentence1 和 sentence2 都只包含大小写英文字母和空格。
// sentence1 和 sentence2 中的单词都只由单个空格隔开。
//
//
// Related Topics 数组 双指针 字符串 👍 64 👎 0

package leetcode.editor.cn;
public class SentenceSimilarityIii{
    public static void main(String[] args){
        Solution solution = new SentenceSimilarityIii().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");
        if (words1.length < words2.length) {
            String[] t = words1;
            words1 = words2;
            words2 = t;
        }
        int l1 = words1.length, l2 = words2.length;
        int i = 0, j = 0;
        //最长公共前缀
        while (i < l2 && words1[i].equals(words2[i])) {
            ++i;
        }
        //最长公共后缀
        while (j < l2 && words1[l1 - 1 - j].equals(words2[l2 - 1 - j])) {
            ++j;
        }
        return i + j >= l2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}