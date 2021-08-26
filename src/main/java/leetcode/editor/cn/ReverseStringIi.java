//第541题
//给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由小写英文组成 
// 1 <= k <= 104 
// 
// Related Topics 双指针 字符串 
// 👍 163 👎 0

package leetcode.editor.cn;
public class ReverseStringIi{
    public static void main(String[] args){
        Solution solution = new ReverseStringIi().new Solution();
        System.out.println(solution.reverseStr("abcd", 2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int index = 0;
        int length = chars.length;
        while (index < length){
            reverse(index, Math.min(index+k-1, length-1), chars);
            index = index+ 2*k;
        }
        return String.valueOf(chars);
    }

    private void reverse(int from, int to, char[] arr){
        while (from < to){
            char temp = arr[from];
            arr[from] = arr[to];
            arr[to] = temp;
            from ++;
            to--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
