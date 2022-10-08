//2022-10-08 14:33:38
//第777题
//在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。一次移动操作指用一个"LX"替换一个"XL"，或
//者用一个"XR"替换一个"RX"。现给定起始字符串start和结束字符串end，请编写代码，当且仅当存在一系列移动操作使得start可以转换成end时， 返回
//True。
//
//
//
// 示例 :
//
// 输入: start = "RXXLRXRXL", end = "XRLXXRRLX"
//输出: True
//解释:
//我们可以通过以下几步将start转换成end:
//RXXLRXRXL ->
//XRXLRXRXL ->
//XRLXRXRXL ->
//XRLXXRRXL ->
//XRLXXRRLX
//
//
//
//
// 提示：
//
//
// 1 <= len(start) = len(end) <= 10000。
// start和end中的字符串仅限于'L', 'R'和'X'。
//
//
// Related Topics 双指针 字符串 👍 260 👎 0

package leetcode.editor.cn;
public class SwapAdjacentInLrString{
    public static void main(String[] args){
        Solution solution = new SwapAdjacentInLrString().new Solution();
        System.out.println(solution.canTransform("RXXLRXRXL", "XRLXXRRLX"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canTransform(String start, String end) {
        int len = start.length();
        int i=0, j=0;
        while (i<len || j<len){
            while(i<len && start.charAt(i) == 'X') i++;
            while(j<len && end.charAt(j) == 'X') j++;
            if (i==len || j==len) {
                break;
            }
            if(start.charAt(i) != end.charAt(j)) return false;
            if(start.charAt(i) == 'L' && i<j) return false;
            if(start.charAt(i) == 'R' && i>j) return false;
            i++;
            j++;
        }
        return i == j;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}