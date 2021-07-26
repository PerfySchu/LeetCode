//第43题
//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 模拟 
// 👍 676 👎 0

package leetcode.editor.cn;

public class MultiplyStrings{
    public static void main(String[] args){
        Solution solution = new MultiplyStrings().new Solution();
        System.out.println(solution.multiply("123", "456"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        char[] num1s = num1.toCharArray();
        char[] num2s = num2.toCharArray();

        StringBuilder res = new StringBuilder("0");
        for (int i = num1s.length-1; i >=0 ; i--) {
            StringBuilder sb = new StringBuilder();
            //除了第一位，后面的都要进位补0
            for(int zero = num1s.length-1; zero>i; zero--){
                sb.append("0");
            }
            int carry = 0;
            int n1 = num1s[i] - '0';
            for (int j = num2s.length-1; j >=0 ; j--) {
                int n2 = num2s[j] - '0';
                int n = n1 * n2 + carry;
                carry = n/10;
                sb.append(n%10);
            }
            if(carry>0){
                sb.append(carry);
            }
            res = addStr(res.toString(), sb.reverse().toString());
        }

        return res.toString();
    }

    public StringBuilder addStr(String num1, String num2){
        int l1 = num1.length()-1;
        int l2 = num2.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (l1 >=0 || l2 >= 0 || carry>0){
            int n1 = l1>=0 ? num1.charAt(l1) - '0' : 0;
            int n2 = l2>=0 ? num2.charAt(l2) - '0' : 0;
            int sum = n1 + n2 + carry;
            sb.append(sum%10);
            carry = sum/10;
            l1--;
            l2--;
        }
        sb.reverse();
        return sb;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
