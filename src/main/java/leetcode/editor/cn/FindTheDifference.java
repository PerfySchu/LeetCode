//2025-03-21 10:41:05
//第389题
//给定两个字符串 s 和 t ，它们只包含小写字母。
//
// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
//
// 请找出在 t 中被添加的字母。
//
//
//
// 示例 1：
//
//
//输入：s = "abcd", t = "abcde"
//输出："e"
//解释：'e' 是那个被添加的字母。
//
//
// 示例 2：
//
//
//输入：s = "", t = "y"
//输出："y"
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 1000
// t.length == s.length + 1
// s 和 t 只包含小写字母
//
//
// Related Topics 位运算 哈希表 字符串 排序 👍 504 👎 0

package leetcode.editor.cn;


public class FindTheDifference{
    public static void main(String[] args){
        Solution solution = new FindTheDifference().new Solution();
        System.out.println(solution.findTheDifference("abcd","abcde"));
        System.out.println(solution.findTheDifference("","y"));
        System.out.println(solution.findTheDifference("a","aa"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char findTheDifference(String s, String t) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c-'a']++;
        }
        for (char c : t.toCharArray()) {
            if(arr[c-'a']==0) return c;
            arr[c-'a']--;
        }
        return ' ';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}