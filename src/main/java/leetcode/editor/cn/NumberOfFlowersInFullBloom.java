//2023-09-28 09:33:33
//第2251题
//给你一个下标从 0 开始的二维整数数组 flowers ，其中 flowers[i] = [starti, endi] 表示第 i 朵花的 花期 从
//starti 到 endi （都 包含）。同时给你一个下标从 0 开始大小为 n 的整数数组 people ，people[i] 是第 i 个人来看花的时间。
//
// 请你返回一个大小为 n 的整数数组 answer ，其中 answer[i]是第 i 个人到达时在花期内花的 数目 。
//
//
//
// 示例 1：
//
//
//
//
//输入：flowers = [[1,6],[3,7],[9,12],[4,13]], people = [2,3,7,11]
//输出：[1,2,2,2]
//解释：上图展示了每朵花的花期时间，和每个人的到达时间。
//对每个人，我们返回他们到达时在花期内花的数目。
//
//
// 示例 2：
//
//
//
//
//输入：flowers = [[1,10],[3,3]], people = [3,3,2]
//输出：[2,2,1]
//解释：上图展示了每朵花的花期时间，和每个人的到达时间。
//对每个人，我们返回他们到达时在花期内花的数目。
//
//
//
//
// 提示：
//
//
// 1 <= flowers.length <= 5 * 10⁴
// flowers[i].length == 2
// 1 <= starti <= endi <= 10⁹
// 1 <= people.length <= 5 * 10⁴
// 1 <= people[i] <= 10⁹
//
//
// Related Topics 数组 哈希表 二分查找 有序集合 前缀和 排序 👍 78 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class NumberOfFlowersInFullBloom{
    public static void main(String[] args){
        Solution solution = new NumberOfFlowersInFullBloom().new Solution();
        System.out.println(Arrays.toString(solution.fullBloomFlowers(new int[][]{{1, 6}, {3, 7}, {9, 12}, {4, 13}}, new int[]{2, 3, 7, 11})));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        TreeMap<Integer, Integer> cnt = new TreeMap<>();
        for (int[] flower : flowers) {
            cnt.put(flower[0], cnt.getOrDefault(flower[0], 0) + 1);
            cnt.put(flower[1] + 1, cnt.getOrDefault(flower[1]+1, 0) -1);
        }
        int m = people.length;
        Integer[] indices = IntStream.range(0, m).boxed().toArray(Integer[]::new);
        Arrays.sort(indices, Comparator.comparingInt(i -> people[i]));
        int[] ans = new int[m];
        int curr = 0;
        for (Integer x : indices) {
            while (!cnt.isEmpty() && cnt.firstKey() <= people[x]){
                curr += cnt.pollFirstEntry().getValue();
            }
            ans[x] = curr;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}