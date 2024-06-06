//2024-06-06 09:24:39
//第2938题
//桌子上有 n 个球，每个球的颜色不是黑色，就是白色。
//
// 给你一个长度为 n 、下标从 0 开始的二进制字符串 s，其中 1 和 0 分别代表黑色和白色的球。
//
// 在每一步中，你可以选择两个相邻的球并交换它们。
//
// 返回「将所有黑色球都移到右侧，所有白色球都移到左侧所需的 最小步数」。
//
//
//
// 示例 1：
//
//
//输入：s = "101"
//输出：1
//解释：我们可以按以下方式将所有黑色球移到右侧：
//- 交换 s[0] 和 s[1]，s = "011"。
//最开始，1 没有都在右侧，需要至少 1 步将其移到右侧。
//
// 示例 2：
//
//
//输入：s = "100"
//输出：2
//解释：我们可以按以下方式将所有黑色球移到右侧：
//- 交换 s[0] 和 s[1]，s = "010"。
//- 交换 s[1] 和 s[2]，s = "001"。
//可以证明所需的最小步数为 2 。
//
//
// 示例 3：
//
//
//输入：s = "0111"
//输出：0
//解释：所有黑色球都已经在右侧。
//
//
//
//
// 提示：
//
//
// 1 <= n == s.length <= 10⁵
// s[i] 不是 '0'，就是 '1'。
//
//
// Related Topics 贪心 双指针 字符串 👍 21 👎 0

package leetcode.editor.cn;
public class SeparateBlackAndWhiteBalls{
    public static void main(String[] args){
        Solution solution = new SeparateBlackAndWhiteBalls().new Solution();
        //System.out.println(solution.minimumSteps("101"));
        //System.out.println(solution.minimumSteps("100"));
        //System.out.println(solution.minimumSteps("011"));
        System.out.println(solution.minimumSteps("010101011"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long minimumSteps(String s) {
        if (s.length() == 1) {
            return 0;
        }
        char[] balls = s.toCharArray();
        int left = 0;
        int right = 1;
        long ans = 0;
        while(right < balls.length){
            if(balls[left] == '1'){
                if(balls[right] == '0'){
                    ans += right-left;
                    char temp = balls[left];
                    balls[left] = balls[right];
                    balls[right] = temp;
                    left++;
                    right++;
                }else{
                    right++;
                }
            }else {
                if(balls[right] == '0'){
                    left = right+1;
                    right = left+1;
                }else{
                    left = right;
                    right = left+1;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}