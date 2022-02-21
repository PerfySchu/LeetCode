//2022-02-21 17:39:32
//第838题
//n 张多米诺骨牌排成一行，将每张多米诺骨牌垂直竖立。在开始时，同时把一些多米诺骨牌向左或向右推。
//
// 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
//
// 如果一张垂直竖立的多米诺骨牌的两侧同时有多米诺骨牌倒下时，由于受力平衡， 该骨牌仍然保持不变。
//
// 就这个问题而言，我们会认为一张正在倒下的多米诺骨牌不会对其它正在倒下或已经倒下的多米诺骨牌施加额外的力。
//
// 给你一个字符串 dominoes 表示这一行多米诺骨牌的初始状态，其中：
//
//
// dominoes[i] = 'L'，表示第 i 张多米诺骨牌被推向左侧，
// dominoes[i] = 'R'，表示第 i 张多米诺骨牌被推向右侧，
// dominoes[i] = '.'，表示没有推动第 i 张多米诺骨牌。
//
//
// 返回表示最终状态的字符串。
//
//
// 示例 1：
//
//
//输入：dominoes = "RR.L"
//输出："RR.L"
//解释：第一张多米诺骨牌没有给第二张施加额外的力。
//
//
// 示例 2：
//
//
//输入：dominoes = ".L.R...LR..L.."
//输出："LL.RR.LLRRLL.."
//
//
//
//
// 提示：
//
//
// n == dominoes.length
// 1 <= n <= 10⁵
// dominoes[i] 为 'L'、'R' 或 '.'
//
// Related Topics 双指针 字符串 动态规划 👍 213 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class PushDominoes{
    public static void main(String[] args){
        Solution solution = new PushDominoes().new Solution();
        System.out.println(solution.pushDominoes(".L.R...LR..L.."));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String pushDominoes(String dominoes) {
        char[] cs = dominoes.toCharArray();
        int n = cs.length;
        int[] g = new int[n];
        Deque<int[]> d = new ArrayDeque<>();
        //初始三元组（每张牌的 位置 loc, 时刻 time， 受力 dire）
        for (int i = 0; i < n; i++) {
            if (cs[i] == '.') {
                continue;
            }
            int dire = cs[i] == 'L' ? -1 : 1;
            d.add(new int[]{i, 1, dire});
            g[i] = 1;
        }
        //逐步演进
        while (!d.isEmpty()) {
            int[] info = d.pollFirst();
            int loc = info[0];
            int time = info[1];
            int dire = info[2];
            // ne 下一个受影响的位置
            int ne = loc + dire;
            //当前位置没有倾倒，或者倒向界外（不对其他骨牌产生影响）
            if (cs[loc] == '.' || (ne < 0 || ne >= n)) {
                continue;
            }
            if (g[ne] == 0) {//首次受力
                d.addLast(new int[]{ne, time+1, dire});
                g[ne] = time + 1;
                cs[ne] = dire == -1 ? 'L' : 'R';
            }else if(g[ne] == time + 1){//多次受力
                cs[ne] = '.';
            }
        }
        return String.valueOf(cs);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}