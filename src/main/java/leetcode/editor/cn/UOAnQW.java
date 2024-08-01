//2024-08-01 09:08:09
//第LCP 40题
//「力扣挑战赛」心算项目的挑战比赛中，要求选手从 `N` 张卡牌中选出 `cnt` 张卡牌，若这 `cnt` 张卡牌数字总和为偶数，则选手成绩「有效」且得分为
// `cnt` 张卡牌数字总和。
//给定数组 `cards` 和 `cnt`，其中 `cards[i]` 表示第 `i` 张卡牌上的数字。 请帮参赛选手计算最大的有效得分。若不存在获取有效得分
//的卡牌方案，则返回 0。
//
//**示例 1：**
//
//> 输入：`cards = [1,2,8,9], cnt = 3`
//>
//> 输出：`18`
//>
//> 解释：选择数字为 1、8、9 的这三张卡牌，此时可获得最大的有效得分 1+8+9=18。
//
//**示例 2：**
//
//> 输入：`cards = [3,3,1], cnt = 1`
//>
//> 输出：`0`
//>
//> 解释：不存在获取有效得分的卡牌方案。
//
//**提示：**
//- `1 <= cnt <= cards.length <= 10^5`
//- `1 <= cards[i] <= 1000`
//
// Related Topics 贪心 数组 排序 👍 82 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class UOAnQW{
    public static void main(String[] args){
        Solution solution = new UOAnQW().new Solution();
        System.out.println(solution.maxmiumScore(new int[]{1,2,8,9},3));
        System.out.println(solution.maxmiumScore(new int[]{3,3,1},1));
        System.out.println(solution.maxmiumScore(new int[]{1,1000,1},1));
        System.out.println(solution.maxmiumScore(new int[]{9,5,9,1,6,10,3,4,5,1},2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        int n = cards.length;
        int ans = 0;
        int odd = -1;
        int even = -1;
        int end = n-cnt;
        int tmp = 0;
        for (int i = n - 1; i >= end; i--) {
            tmp += cards[i];
            if(cards[i] % 2 > 0){
                //记录数组中最小的奇数
                odd = cards[i];
            }else {
                //记录数组中最小的偶数
                even = cards[i];
            }
        }
        if (tmp % 2 == 0) {
            return tmp;
        }

        for (int i = n - cnt - 1; i >= 0; i--) {
            if (cards[i] % 2 > 0 && even != -1) {
                //找到剩余数字中最大的奇数，替换掉数组中最小的偶数
                ans = Math.max(ans, tmp - even + cards[i]);
                break;
            }
        }

        for (int i = n - cnt - 1; i > 0; i--) {
            if (cards[i] % 2 == 0 && odd != -1) {
                //找到剩余数字中最大的偶数，替换掉数组中最小的奇数
                ans = Math.max(ans, tmp - odd + cards[i]);
                break;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}