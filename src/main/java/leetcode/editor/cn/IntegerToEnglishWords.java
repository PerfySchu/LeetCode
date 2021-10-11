//2021-10-11 11:16:42
//第273题
//将非负整数 num 转换为其对应的英文表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 123
//输出："One Hundred Twenty Three"
// 
//
// 示例 2： 
//
// 
//输入：num = 12345
//输出："Twelve Thousand Three Hundred Forty Five"
// 
//
// 示例 3： 
//
// 
//输入：num = 1234567
//输出："One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
// 
//
// 示例 4： 
//
// 
//输入：num = 1234567891
//输出："One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven 
//Thousand Eight Hundred Ninety One"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= num <= 2³¹ - 1 
// 
// Related Topics 递归 数学 字符串 👍 191 👎 0

package leetcode.editor.cn;
public class IntegerToEnglishWords{
    public static void main(String[] args){
        Solution solution = new IntegerToEnglishWords().new Solution();
        System.out.println(solution.numberToWords(123456));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num==0) {
            return "Zero";
        }
        StringBuffer sb = new StringBuffer();
        //最大不会超过10位，所以只需要迭代 3 次
        for (int i = 3, unit =1000000000; i >=0; i--,unit/=1000) {
            //当前位的数字
            int curNum = num / unit;
            if(curNum != 0){
                //参与下一次迭代的数字
                num -= curNum * unit;
                //当前三位数内的迭代
                StringBuffer curr = new StringBuffer();
                recursion(curr, curNum);
                curr.append(thousands[i]).append(" ");
                sb.append(curr);
            }
        }
        return sb.toString().trim();
    }

    private void recursion(StringBuffer curr, int num){
        if(num == 0){
        }else if (num<10){
            //个位
            curr.append(singles[num]).append(" ");
        }else if(num<20){
            //20以内
            curr.append(teens[num-10]).append(" ");
        }else if(num<100){
            //100以内的两位数字，先处理十位，再迭代处理个位
            curr.append(tens[num/10]).append(" ");
            recursion(curr, num%10);
        }else{
            //1000以内的三位数，先处理百位，再迭代处理十位，然后迭代处理个位
            curr.append(singles[num/100]).append(" Hundred ");
            recursion(curr, num%100);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
