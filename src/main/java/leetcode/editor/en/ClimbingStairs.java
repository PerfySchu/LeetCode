//You are climbing a stair case. It takes n steps to reach to the top. 
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? 
//
// Note: Given n will be a positive integer. 
//
// Example 1: 
//
// 
//Input: 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
// 
//
// Example 2: 
//
// 
//Input: 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
// 
// Related Topics Dynamic Programming
package leetcode.editor.en;
public class ClimbingStairs{
    public static void main(String[] args){
        Solution solution = new ClimbingStairs().new Solution();
        System.out.println(solution.climbStairs(10));
    }

    /**
     * 力扣大神点拨，说这是一道斐波那契数列问题   （动态规划）
     * 初看我是懵逼的，不止从何下手，尝试跟着大神的思路理解一下
     * 1.为了到达第 n 级台阶，有两种方法：
     *      ①从第 n-1 级台阶一次走一步
     *      ②从第 n-2 级台阶一次走两步
     * 2.以此类推，为了到达第 n-1 级台阶，也有两种方法：
     *      ①从第 n-1-1 级台阶一次走一步
     *      ②从第 n-1-2 级台阶一次走两步
     * 3.所以，到达第 n 级 台阶的方法 f(n) =  f(n-1) + f(n-2)
     *
     * 此题采用递归反向计算和采用循环正向计算均可
     * 不过貌似使用递归求解会超时(会有冗余的计算，不过使用字典记录每一步计算结果可以避免冗余计算)
     */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        if(n==1 || n==2){
            return n;
        }
        int[] step = new int[n+1];
        step[1] = 1;
        step[2] = 2;
        for(int i=3; i<=n; i++){
            //从第3级台阶起，每一级完成的方法等于 完成 n-1 级 和 n-2 级 的方法之和
            step[i] = step[i-1] + step[i-2];
        }
        return step[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
