//2022-04-01 09:58:44
//第954题
//给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i
//+ 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。
//
//
//
// 示例 1：
//
//
//输入：arr = [3,1,3,6]
//输出：false
//
//
// 示例 2：
//
//
//输入：arr = [2,1,2,6]
//输出：false
//
//
// 示例 3：
//
//
//输入：arr = [4,-2,2,-4]
//输出：true
//解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
//
//
//
//
// 提示：
//
//
// 0 <= arr.length <= 3 * 10⁴
// arr.length 是偶数
// -10⁵ <= arr[i] <= 10⁵
//
// Related Topics 贪心 数组 哈希表 排序 👍 92 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ArrayOfDoubledPairs{
    public static void main(String[] args){
        Solution solution = new ArrayOfDoubledPairs().new Solution();
        System.out.println(solution.canReorderDoubled(new int[]{4,-2,2,-4}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int N = 100010, M = N * 2;
    int[] cnts = new int[M * 2];
    public boolean canReorderDoubled(int[] arr) {
        Arrays.fill(cnts, 0);
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(Math::abs));
        for (int i : arr) {
            q.add(i);
        }
        while (!q.isEmpty()) {
            int x = q.poll();
            int t = x * 2;
            if(cnts[x+M] != 0 && --cnts[x + M] >= 0){
                continue;
            }
            cnts[t+M]++;
        }
        for (int i = 0; i < M * 2; i++) {
            if(cnts[i] != 0){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}