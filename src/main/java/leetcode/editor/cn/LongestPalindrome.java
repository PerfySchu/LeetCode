//第409题
//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。 
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。 
//
// 注意: 
//假设字符串的长度不会超过 1010。 
//
// 示例 1: 
//
// 
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
// Related Topics 贪心 哈希表 字符串 
// 👍 309 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome{
    public static void main(String[] args){
        Solution solution = new LongestPalindrome().new Solution();
        System.out.println(solution.longestPalindrome("a"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindrome(String s) {
        //题目本身不要求将回文串构建出来，所有题目本质上是要求寻找出现次数为奇数的字母个数
        //当奇数字母只有一个的时候，可以放在回文串中间，超过1个的时候，则需要舍弃
        int count = s.length();
        Map<Character, Integer> characterMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            characterMap.put(character, characterMap.getOrDefault(character, 0)+1);
        }
        int evenCount = 0;
        for (Map.Entry<Character, Integer> entry : characterMap.entrySet()) {
            if (entry.getValue()%2 == 1){
                evenCount++;
            }
        }
        return count - (evenCount<=1 ? 0 : evenCount-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
