//2022-03-08 10:13:01
//第504题
//给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
//
//
//
// 示例 1:
//
//
//输入: num = 100
//输出: "202"
//
//
// 示例 2:
//
//
//输入: num = -7
//输出: "-10"
//
//
//
//
// 提示：
//
//
// -10⁷ <= num <= 10⁷
//
// Related Topics 数学 👍 170 👎 0

package leetcode.editor.cn;
public class Base7{
    public static void main(String[] args){
        Solution solution = new Base7().new Solution();
        System.out.println(solution.convertToBase7(100));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convertToBase7(int num) {
        boolean flag = num < 0;
        if (flag) {
            num = -num;
        }
        StringBuilder builder = new StringBuilder();
        do{
            builder.append(num % 7);
            num /= 7;
        }while(num!=0);
        builder.reverse();
        return flag ? "-" + builder.toString() : builder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}