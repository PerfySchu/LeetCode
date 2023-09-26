//2023-09-26 10:32:42
//第2582题
//n 个人站成一排，按从 1 到 n 编号。
//
// 最初，排在队首的第一个人拿着一个枕头。每秒钟，拿着枕头的人会将枕头传递给队伍中的下一个人。一旦枕头到达队首或队尾，传递方向就会改变，队伍会继续沿相反方向传
//递枕头。
//
//
// 例如，当枕头到达第 n 个人时，TA 会将枕头传递给第 n - 1 个人，然后传递给第 n - 2 个人，依此类推。
//
//
// 给你两个正整数 n 和 time ，返回 time 秒后拿着枕头的人的编号。
//
//
//
// 示例 1：
//
//
//输入：n = 4, time = 5
//输出：2
//解释：队伍中枕头的传递情况为：1 -> 2 -> 3 -> 4 -> 3 -> 2 。
//5 秒后，枕头传递到第 2 个人手中。
//
//
// 示例 2：
//
//
//输入：n = 3, time = 2
//输出：3
//解释：队伍中枕头的传递情况为：1 -> 2 -> 3 。
//2 秒后，枕头传递到第 3 个人手中。
//
//
//
//
// 提示：
//
//
// 2 <= n <= 1000
// 1 <= time <= 1000
//
//
// Related Topics 数学 模拟 👍 27 👎 0

package leetcode.editor.cn;
public class PassThePillow{
    public static void main(String[] args){
        Solution solution = new PassThePillow().new Solution();
        //System.out.println(solution.passThePillow(3, 2));
        //System.out.println(solution.passThePillow(4, 5));
        System.out.println(solution.passThePillow(18, 38));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int passThePillow(int n, int time) {
        //每经过 2*(n-1) 枕头回到原点
        time = time % (2*(n-1));
        // time<n，枕头未经过队尾，直接返回 time+1
        //time>=n，枕头经过队尾开始掉头，此时计算位置 n-(time-(n-1))
        return time < n ? time+1 : n-(time-(n-1));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}