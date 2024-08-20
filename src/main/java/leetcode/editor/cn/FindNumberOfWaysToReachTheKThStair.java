//2024-08-20 09:13:57
//第3154题
//给你有一个 非负 整数 k 。有一个无限长度的台阶，最低 一层编号为 0 。
//
// Alice 有一个整数 jump ，一开始值为 0 。Alice 从台阶 1 开始，可以使用 任意 次操作，目标是到达第 k 级台阶。假设 Alice 位
//于台阶 i ，一次 操作 中，Alice 可以：
//
//
// 向下走一级到 i - 1 ，但该操作 不能 连续使用，如果在台阶第 0 级也不能使用。
// 向上走到台阶 i + 2ʲᵘᵐᵖ 处，然后 jump 变为 jump + 1 。
//
//
// 请你返回 Alice 到达台阶 k 处的总方案数。
//
// 注意，Alice 可能到达台阶 k 处后，通过一些操作重新回到台阶 k 处，这视为不同的方案。
//
//
//
// 示例 1：
//
//
// 输入：k = 0
//
//
// 输出：2
//
// 解释：
//
// 2 种到达台阶 0 的方案为：
//
//
// Alice 从台阶 1 开始。
//
// 执行第一种操作，从台阶 1 向下走到台阶 0 。
//
// Alice 从台阶 1 开始。
//
// 执行第一种操作，从台阶 1 向下走到台阶 0 。
// 执行第二种操作，向上走 2⁰ 级台阶到台阶 1 。
// 执行第一种操作，从台阶 1 向下走到台阶 0 。
//
//
//
// 示例 2：
//
//
// 输入：k = 1
//
//
// 输出：4
//
// 解释：
//
// 4 种到达台阶 1 的方案为：
//
//
// Alice 从台阶 1 开始，已经到达台阶 1 。
// Alice 从台阶 1 开始。
//
// 执行第一种操作，从台阶 1 向下走到台阶 0 。
// 执行第二种操作，向上走 2⁰ 级台阶到台阶 1 。
//
// Alice 从台阶 1 开始。
//
// 执行第二种操作，向上走 2⁰ 级台阶到台阶 2 。
// 执行第一种操作，向下走 1 级台阶到台阶 1 。
//
// Alice 从台阶 1 开始。
//
// 执行第一种操作，从台阶 1 向下走到台阶 0 。
// 执行第二种操作，向上走 2⁰ 级台阶到台阶 1 。
// 执行第一种操作，向下走 1 级台阶到台阶 0 。
// 执行第二种操作，向上走 2¹ 级台阶到台阶 2 。
// 执行第一种操作，向下走 1 级台阶到台阶 1 。
//
//
//
//
//
// 提示：
//
//
// 0 <= k <= 10⁹
//
//
// Related Topics 位运算 记忆化搜索 数学 动态规划 组合数学 👍 21 👎 0

package leetcode.editor.cn;
public class FindNumberOfWaysToReachTheKThStair{
    public static void main(String[] args){
        Solution solution = new FindNumberOfWaysToReachTheKThStair().new Solution();
        System.out.println(solution.waysToReachStair(0));
        System.out.println(solution.waysToReachStair(1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int waysToReachStair(int k) {
        int n = 0;
        int npow = 1;
        int ans = 0;
        while (true) {
            if(npow - n - 1 <= k && k <= npow){
                ans += comb(n+1, npow-k);
            }else if(npow -n - 1 > k){
                break;
            }
            ++n;
            npow *= 2;
        }
        return ans;
    }

    public int comb(int n , int k){
        long ans = 1;
        for (int i = n; i >= n - k + 1; i--) {
            ans *= i;
            ans /= n-i+1;
        }
        return (int) ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}