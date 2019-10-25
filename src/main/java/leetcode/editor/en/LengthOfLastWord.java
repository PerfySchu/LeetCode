//Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string. 
//
// If the last word does not exist, return 0. 
//
// Note: A word is defined as a character sequence consists of non-space characters only. 
//
// Example: 
//
// 
//Input: "Hello World"
//Output: 5
// 
//
// 
// Related Topics String
package leetcode.editor.en;
public class LengthOfLastWord{
    public static void main(String[] args){
        Solution solution = new LengthOfLastWord().new Solution();
        System.out.println(solution.lengthOfLastWord("hello world "));
    }

    /**
     * 字符串倒序判断，处理好末尾空格就可以了。
     * 这题没什么营养啊
     */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        s = s.trim();
        for(int i=s.length()-1 ; i>=0; i--){
            if(s.charAt(i) != ' '){
                len++;
            }else{
                break;
            }
        }
        return len;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
