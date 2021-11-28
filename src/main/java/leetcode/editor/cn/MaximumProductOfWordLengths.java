//2021-11-17 16:28:44
//第318题
//给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为
//每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。 
//
// 
//
// 示例 1: 
//
// 
//输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
//输出: 16 
//解释: 这两个单词为 "abcw", "xtfn"。 
//
// 示例 2: 
//
// 
//输入: ["a","ab","abc","d","cd","bcd","abcd"]
//输出: 4 
//解释: 这两个单词为 "ab", "cd"。 
//
// 示例 3: 
//
// 
//输入: ["a","aa","aaa","aaaa"]
//输出: 0 
//解释: 不存在这样的两个单词。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= words.length <= 1000 
// 1 <= words[i].length <= 1000 
// words[i] 仅包含小写字母 
// 
// Related Topics 位运算 数组 字符串 👍 255 👎 0
//
// 题解：
// 因为 words 当中的单词只有小写字母，因此可以用一个整数 int(32位）的低 26 位来表示单词中每个字母是否出现
// 题目只需要判断单词之间是否存在重复字母，因此只需要对比每个单词的 26 个字母出现的情况即可
// 采用位运算，对 int 的低 26 位逐个设置值
//
package leetcode.editor.cn;
public class MaximumProductOfWordLengths{
    public static void main(String[] args){
        Solution solution = new MaximumProductOfWordLengths().new Solution();
        System.out.println(solution.maxProduct(new String[] {"abcw","baz","foo","bar","xtfn","abcdef"}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(String[] words) {
        int n = words.length, idx = 0;
        int[] masks = new int[n];
        for (String w : words) {
            int t = 0;
            for (int i = 0; i < w.length(); i++) {
                int u = w.charAt(i) - 'a';
                t |= (1 << u);
            }
            masks[idx++] = t;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if ((masks[i] & masks[j]) == 0) ans = Math.max(ans, words[i].length() * words[j].length());
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
