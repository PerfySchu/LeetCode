//2021-09-26 11:41:27
//第371题
//给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和。 
//
// 
//
// 示例 1： 
//
// 
//输入：a = 1, b = 2
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：a = 2, b = 3
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// -1000 <= a, b <= 1000 
// 
// Related Topics 位运算 数学 👍 489 👎 0

package leetcode.editor.cn;
public class SumOfTwoIntegers{
    public static void main(String[] args){
        Solution solution = new SumOfTwoIntegers().new Solution();
        System.out.println(solution.getSum(2,3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getSum(int a, int b) {
        while ((a & b) != 0){
            int carry = (a & b)<<1;
            b = a ^ b;
            a = carry;
        }
        return a ^ b;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
