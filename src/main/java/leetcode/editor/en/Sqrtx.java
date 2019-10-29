//Implement int sqrt(int x). 
//
// Compute and return the square root of x, where x is guaranteed to be a non-negative integer. 
//
// Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned. 
//
// Example 1: 
//
// 
//Input: 4
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since 
//             the decimal part is truncated, 2 is returned.
// 
// Related Topics Math Binary Search
package leetcode.editor.en;
public class Sqrtx{
    public static void main(String[] args){
        Solution solution = new Sqrtx().new Solution();
        System.out.println(solution.mySqrt(15));
    }

    /**
     * 基础思路是使用二分法，从数字x自身开始计算平方值，对比数字本身
     * 若太大，则用数字的一半 x/2（取整）来计算平方值，
     * 若太小，则用(x + x/2)/2 以此类推,逐步逼近最接近的整数值
     * 而结束的标识就是  上下限的距离不超过 1 相差不大于 1
     */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        if(x == 1){
            return x;
        }
        int min = 0;
        int max = x;
        while((max-min) > 1){
            int ave = (max+min)>>1;
            if(ave*ave > x){
                max = ave;
            }else {
                min = ave;
            }
        }
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
