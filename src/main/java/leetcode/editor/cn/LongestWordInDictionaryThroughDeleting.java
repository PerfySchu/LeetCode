//2021-09-14 10:14:42
//第524题
//给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。 
//
// 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//输出："apple"
// 
//
// 示例 2： 
//
// 
//输入：s = "abpcplea", dictionary = ["a","b","c"]
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 1000 
// s 和 dictionary[i] 仅由小写英文字母组成 
// 
// Related Topics 数组 双指针 字符串 排序 👍 194 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting{
    public static void main(String[] args){
        Solution solution = new LongestWordInDictionaryThroughDeleting().new Solution();
        System.out.println(solution.findLongestWord("abpcplea", Arrays.asList("ale","apple","monkey","plea")));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        dictionary.sort(String::compareTo);
        for (String dict : dictionary) {
            int i=0, j=0;
            while (i<s.length() && j<dict.length()){
                if(s.charAt(i) == dict.charAt(j)){
                    i++;
                    j++;
                }else{
                    i++;
                }
            }
            if(j == dict.length()){
                if (res.length()<dict.length()){
                    res = dict;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
