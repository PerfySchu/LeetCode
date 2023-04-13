//2023-04-13 15:06:40
//第2404题
//给你一个整数数组 nums ，返回出现最频繁的偶数元素。
//
// 如果存在多个满足条件的元素，只需要返回 最小 的一个。如果不存在这样的元素，返回 -1 。
//
//
//
// 示例 1：
//
// 输入：nums = [0,1,2,2,4,4,1]
//输出：2
//解释：
//数组中的偶数元素为 0、2 和 4 ，在这些元素中，2 和 4 出现次数最多。
//返回最小的那个，即返回 2 。
//
// 示例 2：
//
// 输入：nums = [4,4,4,9,2,4]
//输出：4
//解释：4 是出现最频繁的偶数元素。
//
//
// 示例 3：
//
// 输入：nums = [29,47,21,41,13,37,25,7]
//输出：-1
//解释：不存在偶数元素。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 2000
// 0 <= nums[i] <= 10⁵
//
//
// Related Topics 数组 哈希表 计数 👍 42 👎 0

package leetcode.editor.cn;
public class MostFrequentEvenElement{
    public static void main(String[] args){
        Solution solution = new MostFrequentEvenElement().new Solution();
        System.out.println(solution.mostFrequentEven(new int[]{0,1,2,2,4,4,1}));
        System.out.println(solution.mostFrequentEven(new int[]{8154,9139,8194,3346,5450,9190,133,8239,4606,8671,8412,6290}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mostFrequentEven(int[] nums) {
        int[] count = new int[100001];
        int max = 0;
        int maxNum = -1;
        int res = -1;
        for (int num : nums) {
            if (num % 2 == 0) {
                count[num]++;
                if (count[num] > max || count[num] == max && num < maxNum){
                    max = count[num];
                    maxNum = num;
                    res = num;
                }
            }
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}