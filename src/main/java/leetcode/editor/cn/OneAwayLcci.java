//2022-05-13 09:26:56
//第面试题 01.05题
//字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
//
//
//
// 示例 1:
//
// 输入:
//first = "pale"
//second = "ple"
//输出: True
//
//
//
// 示例 2:
//
// 输入:
//first = "pales"
//second = "pal"
//输出: False
//
// Related Topics 双指针 字符串 👍 148 👎 0

package leetcode.editor.cn;
public class OneAwayLcci{
    public static void main(String[] args){
        Solution solution = new OneAwayLcci().new Solution();
        System.out.println(solution.oneEditAway("pules", "ples"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean oneEditAway(String first, String second) {
        int m = first.length(), n = second.length();
        if (Math.abs(m - n) > 1) {
            return false;
        }
        int edit = 0;
        int i=0,j=0;
        while (i<m && j<n){
            if (first.charAt(i) != second.charAt(j)) {
                edit++;
                if (m == n) {
                    i++;
                    j++;
                }else if(m>n){
                    i++;
                }else{
                    j++;
                }
            }else{
                i++;
                j++;
            }
        }
        return edit<=1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}