//2021-11-24 10:08:35
//第423题
//给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "owoztneoer"
//输出："012"
// 
//
// 示例 2： 
//
// 
//输入：s = "fviefuro"
//输出："45"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] 为 ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"] 这些字符之一 
// s 保证是一个符合题目要求的字符串 
// 
// Related Topics 哈希表 数学 字符串 👍 96 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ReconstructOriginalDigitsFromEnglish{
    public static void main(String[] args){
        Solution solution = new ReconstructOriginalDigitsFromEnglish().new Solution();
        System.out.println(solution.originalDigits("owoztneoer"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String originalDigits(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charMap.put(s.charAt(i), charMap.getOrDefault(s.charAt(i), 0)+1);
        }
        // 0 到 9 数字出现的次数统计
        int[] count = new int[10];
        // z, w, u, x, g 都只在一个数字中，即 0, 2, 4, 6, 8 中出现
        count[0] = charMap.getOrDefault('z', 0);
        count[2] = charMap.getOrDefault('w', 0);
        count[4] = charMap.getOrDefault('u', 0);
        count[6] = charMap.getOrDefault('x', 0);
        count[8] = charMap.getOrDefault('g', 0);
        // h 只在 3, 8 中出现
        // f 只在 4, 5 中出现
        // s 只在 6, 7 中出现
        count[3] = charMap.getOrDefault('h', 0) - count[8];
        count[5] = charMap.getOrDefault('f', 0) - count[4];
        count[7] = charMap.getOrDefault('s', 0) - count[6];
        // o 只在 0, 1, 2, 4 中出现， 总次数减去 0,2,4 中的次数即可得到
        count[1] = charMap.getOrDefault('o', 0) - count[0] - count[2] - count[4];
        // i 在  5,6,8,9 中均出现了一次，总次数减去 5,6,8中的次数即可得到
        count[9] = charMap.getOrDefault('i', 0) - count[5] - count[6] - count[8];

        StringBuffer res = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < count[i]; j++) {
                res.append((char)(i+'0'));
            }
        }

        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
