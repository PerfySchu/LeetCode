//2024-07-22 16:25:45
//第128题
//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
//
//
//
// 示例 1：
//
//
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
//
// 示例 2：
//
//
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 10⁵
// -10⁹ <= nums[i] <= 10⁹
//
//
// Related Topics 并查集 数组 哈希表 👍 2138 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence{
    public static void main(String[] args){
        Solution solution = new LongestConsecutiveSequence().new Solution();
        System.out.println(solution.longestConsecutive(new int[]{100,4,200,1,3,2}));
        System.out.println(solution.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, Integer> countMap = new HashMap<>();

    int ans = 1;
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        for (int num : nums) {
            map.put(num, num);
            countMap.put(num, 1);
        }
        for (int num : nums) {
            if(!map.containsKey(num -1) && !map.containsKey(num+1)){
                continue;
            }
            if (map.containsKey(num-1)) {
                match(num-1, num);
            }
            if(map.containsKey(num+1)){
                match(num+1, num);
            }
        }
        return ans;
    }

    public int find(int x){
        if(map.get(x) != x){
            map.put(x, find(map.get(x)));
        }
        return map.get(x);
    }

    public void match(int a, int b){
        int x = find(a);
        int y = find(b);
        if (x != y) {
            map.put(x, y);
            countMap.put(y, countMap.get(y) + countMap.get(x));
            ans = Math.max(ans, countMap.get(y));
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}