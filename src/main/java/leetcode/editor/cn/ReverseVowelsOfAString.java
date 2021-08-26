//第345题
//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 
//
// 示例 1： 
//
// 输入："hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 输入："leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 元音字母不包含字母 "y" 。 
// 
// Related Topics 双指针 字符串 
// 👍 182 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString{
    public static void main(String[] args){
        Solution solution = new ReverseVowelsOfAString().new Solution();
        System.out.println(solution.reverseVowels("hello"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        Set<Character> vowel = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        int left = 0, right = s.length()-1;
        while (left<right){
            if(!vowel.contains(chars[left])){
                left++;
            }
            if(!vowel.contains(chars[right])){
                right--;
            }
            if(vowel.contains(chars[left]) && vowel.contains(chars[right])){
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return String.valueOf(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
