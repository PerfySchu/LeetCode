//2024-05-20 09:40:06
//第1542题
//给你一个字符串 s 。请返回 s 中最长的 超赞子字符串 的长度。
//
// 「超赞子字符串」需满足满足下述两个条件：
//
//
// 该字符串是 s 的一个非空子字符串
// 进行任意次数的字符交换后，该字符串可以变成一个回文字符串
//
//
//
//
// 示例 1：
//
// 输入：s = "3242415"
//输出：5
//解释："24241" 是最长的超赞子字符串，交换其中的字符后，可以得到回文 "24142"
//
//
// 示例 2：
//
// 输入：s = "12345678"
//输出：1
//
//
// 示例 3：
//
// 输入：s = "213123"
//输出：6
//解释："213123" 是最长的超赞子字符串，交换其中的字符后，可以得到回文 "231132"
//
//
// 示例 4：
//
// 输入：s = "00"
//输出：2
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10^5
// s 仅由数字组成
//
//
// Related Topics 位运算 哈希表 字符串 👍 97 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class FindLongestAwesomeSubstring{
    public static void main(String[] args){
        Solution solution = new FindLongestAwesomeSubstring().new Solution();
        System.out.println(solution.longestAwesome("234121442"));
        System.out.println(solution.longestAwesome("3242415"));
        System.out.println(solution.longestAwesome("12345678"));
        System.out.println(solution.longestAwesome("213123"));
        System.out.println(solution.longestAwesome("00"));
        System.out.println(solution.longestAwesome("9498331"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestAwesome(String s) {
        int n = s.length();
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, -1);
        int ans = 0;
        int sequence =0;
        for (int j = 0; j < n; j++) {
            int digit = s.charAt(j) - '0';
            sequence ^= (1<<digit);
            if (prefix.containsKey(sequence)) {
                ans = Math.max(ans, j - prefix.get(sequence));
            }else {
                prefix.put(sequence, j);
            }
            for (int k = 0; k < 10; k++) {
                if(prefix.containsKey(sequence ^(1<<k))){
                    ans = Math.max(ans, j - prefix.get(sequence ^ (1<<k)));
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}