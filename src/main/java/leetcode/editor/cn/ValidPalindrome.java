//2021-11-23 09:52:04
//第125题
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 
//
// 示例 1: 
//
// 
//输入: "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串
// 
//
// 示例 2: 
//
// 
//输入: "race a car"
//输出: false
//解释："raceacar" 不是回文串
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// 字符串 s 由 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 👍 439 👎 0

package leetcode.editor.cn;
public class ValidPalindrome{
    public static void main(String[] args){
        Solution solution = new ValidPalindrome().new Solution();
        System.out.println(solution.isPalindrome("race a car"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        int left = 0, right = s.length()-1;
        while (left<right){
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if(Character.toLowerCase(leftChar) == Character.toLowerCase(rightChar)){
                left++;
                right--;
            }else if(!Character.isLetterOrDigit(leftChar)){
                left ++;
            }else if(!Character.isLetterOrDigit(rightChar)){
                right--;
            }else {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
