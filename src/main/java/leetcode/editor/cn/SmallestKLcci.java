//2021-09-03 15:38:36
//第面试题 17.14题
//设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。 
//
// 示例： 
//
// 输入： arr = [1,3,5,7,2,4,6,8], k = 4
//输出： [1,2,3,4]
// 
//
// 提示： 
//
// 
// 0 <= len(arr) <= 100000 
// 0 <= k <= min(100000, len(arr)) 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 121 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class SmallestKLcci{
    public static void main(String[] args){
        Solution solution = new SmallestKLcci().new Solution();
        System.out.println(solution.smallestK(new int[]{1,3,5,7,2,4,6,8}, 4));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] smallestK(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
