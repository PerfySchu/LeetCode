//2023-03-09 22:39:00
//第746题
//给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
//
// 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
//
// 请你计算并返回达到楼梯顶部的最低花费。
//
//
//
// 示例 1：
//
//
//输入：cost = [10,15,20]
//输出：15
//解释：你将从下标为 1 的台阶开始。
//- 支付 15 ，向上爬两个台阶，到达楼梯顶部。
//总花费为 15 。
//
//
// 示例 2：
//
//
//输入：cost = [1,100,1,1,1,100,1,1,100,1]
//输出：6
//解释：你将从下标为 0 的台阶开始。
//- 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
//- 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
//- 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
//- 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
//- 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
//- 支付 1 ，向上爬一个台阶，到达楼梯顶部。
//总花费为 6 。
//
//
//
//
// 提示：
//
//
// 2 <= cost.length <= 1000
// 0 <= cost[i] <= 999
//
//
// Related Topics 数组 动态规划 👍 1133 👎 0

package leetcode.editor.cn;
public class MinCostClimbingStairs{
    public static void main(String[] args){
        Solution solution = new MinCostClimbingStairs().new Solution();
        System.out.println(solution.minCostClimbingStairs(new int[]{10,15,20}));
        System.out.println(solution.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] step = new int[cost.length+1];
        step[0] = 0;
        step[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            step[i] = Math.min(step[i-1]+cost[i-1], step[i-2]+ cost[i-2]) ;
        }
        return step[cost.length];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}