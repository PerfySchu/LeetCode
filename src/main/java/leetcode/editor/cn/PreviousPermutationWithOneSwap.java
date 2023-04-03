//2023-04-03 09:05:59
//第1053题
//给你一个正整数数组 arr（可能存在重复的元素），请你返回可在 一次交换（交换两数字 arr[i] 和 arr[j] 的位置）后得到的、按字典序排列小于
//arr 的最大排列。
//
// 如果无法这么操作，就请返回原数组。
//
//
//
// 示例 1：
//
//
//输入：arr = [3,2,1]
//输出：[3,1,2]
//解释：交换 2 和 1
//
//
// 示例 2：
//
//
//输入：arr = [1,1,5]
//输出：[1,1,5]
//解释：已经是最小排列
//
//
// 示例 3：
//
//
//输入：arr = [1,9,4,6,7]
//输出：[1,7,4,6,9]
//解释：交换 9 和 7
//
//
//
//
// 提示：
//
//
// 1 <= arr.length <= 10⁴
// 1 <= arr[i] <= 10⁴
//
//
// Related Topics 贪心 数组 👍 66 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class PreviousPermutationWithOneSwap{
    public static void main(String[] args){
        Solution solution = new PreviousPermutationWithOneSwap().new Solution();
        System.out.println(Arrays.toString(solution.prevPermOpt1(new int[]{3, 2, 1})));
        System.out.println(Arrays.toString(solution.prevPermOpt1(new int[]{1, 9, 4, 6, 7})));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        int i = n - 2;
        // 从后往前找到第一个不是降序的位置
        while (i >= 0 && arr[i] <= arr[i + 1]) {
            i--;
        }
        //如果都是升序，直接返回
        if (i < 0) {
            return arr;
        }
        // 从后往前找到第一个比arr[i]小的位置
        int j = n - 1;
        while (j >= 0 && arr[j] >= arr[i]) {
            j--;
        }
        // 从后往前找到第一个和arr[j]不相等的位置
        while (j >= 0 && arr[j] == arr[j - 1]) {
            j--;
        }
        // 交换 i 和 j 位置的元素
        swap(arr, i, j);
        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}