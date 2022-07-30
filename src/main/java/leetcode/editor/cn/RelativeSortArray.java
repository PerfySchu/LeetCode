//2022-07-30 10:21:54
//第1122题
//给你两个数组，arr1 和 arr2，arr2 中的元素各不相同，arr2 中的每个元素都出现在 arr1 中。
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。
//
//
//
// 示例 1：
//
//
//输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
//
//
// 示例 2:
//
//
//输入：arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
//输出：[22,28,8,6,17,44]
//
//
//
//
// 提示：
//
//
// 1 <= arr1.length, arr2.length <= 1000
// 0 <= arr1[i], arr2[i] <= 1000
// arr2 中的元素 arr2[i] 各不相同
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中
//
//
// Related Topics 数组 哈希表 计数排序 排序 👍 228 👎 0

package leetcode.editor.cn;

import java.util.*;

public class RelativeSortArray{
    public static void main(String[] args){
        Solution solution = new RelativeSortArray().new Solution();
        System.out.println(Arrays.toString(solution.relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19},
                new int[]{2, 1, 4, 3, 9, 6})));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : arr1) {
            countMap.put(i, countMap.getOrDefault(i, 0)+1);
        }
        int[] ans = new int[arr1.length];
        int index=0;
        for (int i : arr2) {
            int num = countMap.get(i);
            for (int idx = 0; idx < num; idx++) {
                ans[index++] = i;
            }
            countMap.remove(i);
        }
        List<Integer> otherKey = new ArrayList<>();
        for (Integer integer : countMap.keySet()) {
            otherKey.add(integer);
        }
        otherKey.sort(Integer::compareTo);
        for (Integer integer : otherKey) {
            Integer num = countMap.get(integer);
            for (int idx = 0; idx < num; idx++) {
                ans[index++] = integer;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}