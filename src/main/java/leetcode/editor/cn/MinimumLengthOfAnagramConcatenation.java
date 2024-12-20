//2024-12-20 09:19:55
//第3138题
//给你一个字符串 s ，它由某个字符串 t 和若干 t 的 同位字符串 连接而成。
//
// 请你返回字符串 t 的 最小 可能长度。
//
// 同位字符串 指的是重新排列一个单词得到的另外一个字符串，原来字符串中的每个字符在新字符串中都恰好只使用一次。
//
//
//
// 示例 1：
//
//
// 输入：s = "abba"
//
//
// 输出：2
//
// 解释：
//
// 一个可能的字符串 t 为 "ba" 。
//
// 示例 2：
//
//
// 输入：s = "cdef"
//
//
// 输出：4
//
// 解释：
//
// 一个可能的字符串 t 为 "cdef" ，注意 t 可能等于 s 。
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁵
// s 只包含小写英文字母。
//
//
// Related Topics 哈希表 字符串 计数 👍 16 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MinimumLengthOfAnagramConcatenation{
    public static void main(String[] args){
        Solution solution = new MinimumLengthOfAnagramConcatenation().new Solution();
        System.out.println(solution.minAnagramLength("abba"));
        System.out.println(solution.minAnagramLength("cdef"));
        System.out.println(solution.minAnagramLength("aabb"));
        System.out.println(solution.minAnagramLength("aabbabab"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minAnagramLength(String s) {
        int length = s.length();
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0)+1);
        }
        Integer maxTimes  = charMap.values().stream().sorted().findFirst().orElse(1);
        // 最大可能长度
        int minLenth = length / maxTimes;
        for (int i = minLenth; i <= s.length(); i++) {
            if(length % i == 0 && isAnagram(s, i, length/i)) {
                return i;
            }
        }
        return s.length();
    }

    private boolean isAnagram(String s, int length, int times){
        // 初始化第一个times内，各个字符出现的计数
        Map<Character, Integer> baseMap = new HashMap<>();
        for (int j = 0; j < length; j++) {
            baseMap.put(s.charAt(j), baseMap.getOrDefault(s.charAt(j), 0) + 1);
        }
        //对比每个times内，各个字符出现的计数，如果不一致则返回false
        for (int i = 1; i < times; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < length; j++) {
                char c = s.charAt(i * length + j);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            //对比Map和baseMap
            for (Map.Entry<Character, Integer> entry : baseMap.entrySet()) {
                Character key = entry.getKey();
                if(!map.containsKey(key) || !map.get(key).equals(baseMap.get(key))){
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}