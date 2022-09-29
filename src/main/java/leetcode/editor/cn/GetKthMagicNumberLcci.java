//2022-09-28 11:02:05
//第面试题 17.09题
//有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，
//5，7，9，15，21。
//
// 示例 1:
//
// 输入: k = 5
//
//输出: 9
//
//
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 148 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class GetKthMagicNumberLcci{
    public static void main(String[] args){
        Solution solution = new GetKthMagicNumberLcci().new Solution();
        System.out.println(solution.getKthMagicNumber(5));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getKthMagicNumber(int k) {
        int[] nums = new int[]{3, 5, 7};
        PriorityQueue<Long> q = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        q.add(1L);
        set.add(1L);
        while (!q.isEmpty()) {
            long t = q.poll();
            if (--k == 0) {
                return (int) t;
            }
            for (int x : nums) {
                if (!set.contains(x * t)) {
                    q.add(x * t);
                    set.add(x * t);
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}