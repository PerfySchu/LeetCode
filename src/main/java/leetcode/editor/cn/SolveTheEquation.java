//2022-08-10 13:44:32
//第640题
//求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。
//
// 如果方程没有解，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。
//
// 题目保证，如果方程中只有一个解，则 'x' 的值是一个整数。
//
//
//
// 示例 1：
//
//
//输入: equation = "x+5-3+x=6+x-2"
//输出: "x=2"
//
//
// 示例 2:
//
//
//输入: equation = "x=x"
//输出: "Infinite solutions"
//
//
// 示例 3:
//
//
//输入: equation = "2x=x"
//输出: "x=0"
//
//
//
//
// 提示:
//
//
// 3 <= equation.length <= 1000
// equation 只有一个 '='.
// equation 方程由整数组成，其绝对值在 [0, 100] 范围内，不含前导零和变量 'x' 。
//
//
// Related Topics 数学 字符串 模拟 👍 142 👎 0

package leetcode.editor.cn;

public class SolveTheEquation{
    public static void main(String[] args){
        Solution solution = new SolveTheEquation().new Solution();
        System.out.println(solution.solveEquation("-x=-1"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String solveEquation(String equation) {
        String[] split = equation.split("=");
        Integer[] left = expressionFormat(split[0]);
        Integer[] right = expressionFormat(split[1]);
        int xNum = left[0] - right[0];
        int num = right[1] - left[1];
        if(xNum==0){
            if(xNum == num){
                return "Infinite solutions";
            }
            return "No solution";
        }
        return "x="+ (num/xNum);
    }

    private Integer[] expressionFormat(String expression){
        int xNum=0, num=0;
        String[] split = expression.split("\\+");
        for (String s : split) {
            if(s.contains("-")) {
                String[] arr = s.split("-");
                for (int i = 0; i < arr.length; i++) {
                    if (i==0) {
                        if (arr[i].contains("x")) {
                            if(arr[i].length() == 1){
                                xNum += 1;
                            }else{
                                xNum += Integer.parseInt(arr[i].replace("x", ""));
                            }
                        } else {
                            num += Integer.parseInt(arr[i].length()==0 ? "0" : arr[i]);
                        }
                    }else{
                        if (arr[i].contains("x")) {
                            if(arr[i].length() == 1){
                                xNum -= 1;
                            }else {
                                xNum -= Integer.parseInt(arr[i].replace("x", ""));
                            }
                        } else {
                            num -= Integer.parseInt(arr[i]);
                        }
                    }
                }
            }else{
                if (s.contains("x")) {
                    if(s.length() == 1){
                        xNum += 1;
                    }else {
                        xNum += Integer.parseInt(s.replace("x", ""));
                    }
                } else {
                    num += Integer.parseInt(s);
                }
            }
        }
        return new Integer[]{xNum, num};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}