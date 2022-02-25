//2022-02-25 09:18:34
//第537题
//复数 可以用字符串表示，遵循 "实部+虚部i" 的形式，并满足下述条件：
//
//
// 实部 是一个整数，取值范围是 [-100, 100]
// 虚部 也是一个整数，取值范围是 [-100, 100]
// i² == -1
//
//
// 给你两个字符串表示的复数 num1 和 num2 ，请你遵循复数表示形式，返回表示它们乘积的字符串。
//
//
//
// 示例 1：
//
//
//输入：num1 = "1+1i", num2 = "1+1i"
//输出："0+2i"
//解释：(1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
//
//
// 示例 2：
//
//
//输入：num1 = "1+-1i", num2 = "1+-1i"
//输出："0+-2i"
//解释：(1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。
//
//
//
//
// 提示：
//
//
// num1 和 num2 都是有效的复数表示。
//
// Related Topics 数学 字符串 模拟 👍 84 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class ComplexNumberMultiplication{
    public static void main(String[] args){
        Solution solution = new ComplexNumberMultiplication().new Solution();
        System.out.println(solution.complexNumberMultiply("1+-1i", "1+-1i"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String[] num1s = num1.split("[+i]");
        String[] num2s = num2.split("[+i]");
        //(a + bi) * (c + di) = a*c + a*di + bi*c + bi*di
        int a = Integer.parseInt(num1s[0]);
        int b = Integer.parseInt(num1s[1]);
        int c = Integer.parseInt(num2s[0]);
        int d = Integer.parseInt(num2s[1]);
        int A = a * c - b * d;
        int B = b * c + a * d;
        return A + "+" + B + "i";
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}