//2024-11-26 11:33:57
//第3206题
//给你一个整数数组 colors ，它表示一个由红色和蓝色瓷砖组成的环，第 i 块瓷砖的颜色为 colors[i] ：
//
//
// colors[i] == 0 表示第 i 块瓷砖的颜色是 红色 。
// colors[i] == 1 表示第 i 块瓷砖的颜色是 蓝色 。
//
//
// 环中连续 3 块瓷砖的颜色如果是 交替 颜色（也就是说中间瓷砖的颜色与它 左边 和 右边 的颜色都不同），那么它被称为一个 交替 组。
//
// 请你返回 交替 组的数目。
//
// 注意 ，由于 colors 表示一个 环 ，第一块 瓷砖和 最后一块 瓷砖是相邻的。
//
//
//
// 示例 1：
//
//
// 输入：colors = [1,1,1]
//
//
// 输出：0
//
// 解释：
//
//
//
// 示例 2：
//
//
// 输入：colors = [0,1,0,0,1]
//
//
// 输出：3
//
// 解释：
//
//
//
// 交替组包括：
//
//
//
//
//
// 提示：
//
//
// 3 <= colors.length <= 100
// 0 <= colors[i] <= 1
//
//
// Related Topics 数组 滑动窗口 👍 14 👎 0

package leetcode.editor.cn;
public class AlternatingGroupsI{
    public static void main(String[] args){
        Solution solution = new AlternatingGroupsI().new Solution();
        System.out.println(solution.numberOfAlternatingGroups(new int[]{0,1,0,0,1}));
        System.out.println(solution.numberOfAlternatingGroups(new int[]{1,1,1}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int[] array = new int[colors.length+2];
        System.arraycopy(colors, 0, array, 0, colors.length);
        System.arraycopy(colors, 0, array, colors.length, 2);
        int ans = 0;
        for (int i = 2; i < array.length; i++) {
            if (array[i] != array[i-1] && array[i-1]!= array[i-2]) {
                ans++;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}