//2022-07-27 09:26:05
//第592题
//给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果。
//
// 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为
// 2/1。
//
//
//
// 示例 1:
//
//
//输入: expression = "-1/2+1/2"
//输出: "0/1"
//
//
// 示例 2:
//
//
//输入: expression = "-1/2+1/2+1/3"
//输出: "1/3"
//
//
// 示例 3:
//
//
//输入: expression = "1/3-1/2"
//输出: "-1/6"
//
//
//
//
// 提示:
//
//
// 输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。
// 输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。
// 输入只包含合法的最简分数，每个分数的分子与分母的范围是 [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。
// 输入的分数个数范围是 [1,10]。
// 最终结果的分子与分母保证是 32 位整数范围内的有效整数。
//
// Related Topics 数学 字符串 模拟 👍 77 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class FractionAdditionAndSubtraction{
    public static void main(String[] args){
        Solution solution = new FractionAdditionAndSubtraction().new Solution();
//        System.out.println(solution.fractionAddition("-1/2+1/2+1/3"));
        System.out.println(solution.fractionAddition("1/3-1/2"));
        System.out.println(solution.fractionAddition("-1/2+1/2"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public String fractionAddition(String expression) {
            char[] chars = expression.toCharArray();
            List<Character> operation = new ArrayList<>();
            List<String> number = new ArrayList<>();
            StringBuilder numberBuilder = new StringBuilder();
            for (char aChar : chars) {
                if (aChar == '-' || aChar == '+') {
                    operation.add(aChar);
                    number.add(numberBuilder.toString());
                    numberBuilder = new StringBuilder();
                } else {
                    numberBuilder.append(aChar);
                }
            }
            number.add(numberBuilder.toString());
            String result = number.get(0);
            for (int i = 1; i < number.size(); i++) {
                result = calculate(result, number.get(i), operation.get(i-1));
            }

            return formatResult(result);
        }

        private String calculate(String a, String b, char operation){
            String result = "";
            if(a.length() == 0){
                if(operation == '-'){
                    return "-"+b;
                }
                return b;
            }
            if (b.length() == 0) {
                return a;
            }
            String[] achar = a.split("/");
            int a1 = Integer.parseInt(achar[0]);
            int a2 = Integer.parseInt(achar[1]);
            String[] bchar = b.split("/");
            int b1 = Integer.parseInt(bchar[0]);
            int b2 = Integer.parseInt(bchar[1]);

            int base = a2 * b2;
            int basea1 = a1 * b2;
            int baseb1 = b1 * a2;
            if(operation == '+'){
                result = basea1 + baseb1 + "/" + base;
            }else{
                result = basea1 - baseb1 + "/" + base;
            }
            return result;
        }

        private String formatResult(String result){
            String[] split = result.split("/");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            if (a == 0) {
                return "0/1";
            }
            int divider = maxDivider(a, b);
            return a/divider + "/" + b/divider;
        }

        private int maxDivider(int m, int n){
            m = Math.abs(m);
            n = Math.abs(n);
            int z=0;
            while(m%n!=0) {
                z=m%n;
                m=n;
                n=z;
            }
            return n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}