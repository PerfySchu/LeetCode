//第415题
//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 数学 字符串 模拟 
// 👍 399 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddStrings{
    public static void main(String[] args){
        Solution solution = new AddStrings().new Solution();
        System.out.println(solution.addStrings("1", "9"));
        System.out.println(solution2("1", "9"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        //进位
        boolean carry = false;
        List<String> result = new ArrayList<>();
        String[] num1s = num1.split("");
        String[] num2s = num2.split("");
        int c = 0;
        while (c<num1s.length && c<num2s.length){
            Integer sum = Integer.parseInt(num1s[num1.length()-1-c]) + Integer.parseInt(num2s[num2.length()-1-c]);
            sum += carry? 1:0;
            if(sum>9){
                carry = true;
                sum-=10;
            }else{
                carry = false;
            }
            result.add(String.valueOf(sum));
            c++;
        }
        String[] head = null;
        if(num1s.length > num2s.length){
            head = Arrays.copyOf(num1s, num1s.length-c);
        }else if(num1s.length < num2s.length){
            head = Arrays.copyOf(num2s, num2s.length-c);
        }
        if(head != null){
            for (int i = head.length-1; i >=0; i--) {
                int sum = Integer.parseInt(head[i]) + (carry?1:0);
                if(sum > 9){
                    carry = true;
                    head[i] = String.valueOf(sum-10);
                }else{
                    carry = false;
                    head[i] = String.valueOf(sum);
                }
            }
            sb.append(carry ? "1" : "");
            for (String chara : head) {
                sb.append(chara);
            }
        }else if (carry){
            sb.append("1");
        }

        for (int i = result.size()-1; i >=0; i--) {
            sb.append(result.get(i));
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 简洁版
     * @param num1
     * @param num2
     * @return result
     */
    public static String solution2(String num1, String num2){
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
        return sb.toString();
    }
}
