//2022-08-26 13:50:05
//第658题
//给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
//
// 整数 a 比整数 b 更接近 x 需要满足：
//
//
// |a - x| < |b - x| 或者
// |a - x| == |b - x| 且 a < b
//
//
//
//
// 示例 1：
//
//
//输入：arr = [1,2,3,4,5], k = 4, x = 3
//输出：[1,2,3,4]
//
//
// 示例 2：
//
//
//输入：arr = [1,2,3,4,5], k = 4, x = -1
//输出：[1,2,3,4]
//
//
//
//
// 提示：
//
//
// 1 <= k <= arr.length
// 1 <= arr.length <= 10⁴
//
// arr 按 升序 排列
// -10⁴ <= arr[i], x <= 10⁴
//
//
// Related Topics 数组 双指针 二分查找 排序 堆（优先队列） 👍 432 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements{
    public static void main(String[] args){
        Solution solution = new FindKClosestElements().new Solution();
        System.out.println(solution.findClosestElements(new int[]{1,2,3,4,5}, 4, 3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int left = 0;
        int right = n -1;

        while(left < right){
            int mid = left + right + 1 >>1;
            if(arr[mid] <= x){
                left = mid;
            }else {
                right = mid -1;
            }
        }
        if(right + 1 < n && Math.abs(arr[right+1] -x) < Math.abs(arr[right] - x)){
            right = right + 1;
        }
        int i = right - 1;
        int j = right + 1;
        while (j - i - 1 < k){
            if(i >= 0 && j < n){
                if(Math.abs(arr[j] - x) < Math.abs(arr[i] - x)){
                    j++;
                }else {
                    i--;
                }
            }else if(i>=0){
                i--;
            }else {
                j++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int p = i+1; p<=j-1; p++){
            ans.add(arr[p]);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}