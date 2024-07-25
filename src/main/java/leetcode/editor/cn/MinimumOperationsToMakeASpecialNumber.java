//2024-07-25 11:11:03
//第2844题
//给你一个下标从 0 开始的字符串 num ，表示一个非负整数。
//
// 在一次操作中，您可以选择 num 的任意一位数字并将其删除。请注意，如果你删除 num 中的所有数字，则 num 变为 0。
//
// 返回最少需要多少次操作可以使 num 变成特殊数字。
//
// 如果整数 x 能被 25 整除，则该整数 x 被认为是特殊数字。
//
//
//
//
//
// 示例 1：
//
//
//输入：num = "2245047"
//输出：2
//解释：删除数字 num[5] 和 num[6] ，得到数字 "22450" ，可以被 25 整除。
//可以证明要使数字变成特殊数字，最少需要删除 2 位数字。
//
// 示例 2：
//
//
//输入：num = "2908305"
//输出：3
//解释：删除 num[3]、num[4] 和 num[6] ，得到数字 "2900" ，可以被 25 整除。
//可以证明要使数字变成特殊数字，最少需要删除 3 位数字。
//
// 示例 3：
//
//
//输入：num = "10"
//输出：1
//解释：删除 num[0] ，得到数字 "0" ，可以被 25 整除。
//可以证明要使数字变成特殊数字，最少需要删除 1 位数字。
//
//
//
//
// 提示
//
//
// 1 <= num.length <= 100
// num 仅由数字 '0' 到 '9' 组成
// num 不含任何前导零
//
//
// Related Topics 贪心 数学 字符串 枚举 👍 32 👎 0

package leetcode.editor.cn;
public class MinimumOperationsToMakeASpecialNumber{
    public static void main(String[] args){
        Solution solution = new MinimumOperationsToMakeASpecialNumber().new Solution();
        System.out.println(solution.minimumOperations("2245047"));
        System.out.println(solution.minimumOperations("2908305"));
        System.out.println(solution.minimumOperations("15"));
        System.out.println(solution.minimumOperations("10"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumOperations(String num) {
        char[] chars = num.toCharArray();
        boolean find0 = false;
        boolean find5 = false;
        for (int i = chars.length - 1; i >= 0; i--) {
            if(chars[i] == '0' || chars[i] == '5'){
                if(find0){
                    return chars.length-i-2;
                }
                if(chars[i] == '0'){
                    find0 = true;
                }else{
                    find5 = true;
                }
            }else if(chars[i] == '2' || chars[i] == '7'){
                if(find5){
                    return chars.length - i -2;
                }
            }
        }
        if(find0){
            return chars.length-1;
        }
        return chars.length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}