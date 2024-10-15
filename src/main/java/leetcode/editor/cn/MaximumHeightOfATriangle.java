//2024-10-15 10:05:59
//第3200题
//给你两个整数 red 和 blue，分别表示红色球和蓝色球的数量。你需要使用这些球来组成一个三角形，满足第 1 行有 1 个球，第 2 行有 2 个球，第
//3 行有 3 个球，依此类推。
//
// 每一行的球必须是 相同 颜色，且相邻行的颜色必须 不同。
//
// 返回可以实现的三角形的 最大 高度。
//
//
//
// 示例 1：
//
//
// 输入： red = 2, blue = 4
//
//
// 输出： 3
//
// 解释：
//
//
//
// 上图显示了唯一可能的排列方式。
//
// 示例 2：
//
//
// 输入： red = 2, blue = 1
//
//
// 输出： 2
//
// 解释：
//
// 上图显示了唯一可能的排列方式。
//
// 示例 3：
//
//
// 输入： red = 1, blue = 1
//
//
// 输出： 1
//
// 示例 4：
//
//
// 输入： red = 10, blue = 1
//
//
// 输出： 2
//
// 解释：
//
// 上图显示了唯一可能的排列方式。
//
//
//
// 提示：
//
//
// 1 <= red, blue <= 100
//
//
// Related Topics 数组 枚举 👍 14 👎 0

package leetcode.editor.cn;
public class MaximumHeightOfATriangle{
    public static void main(String[] args){
        Solution solution = new MaximumHeightOfATriangle().new Solution();
        System.out.println(solution.maxHeightOfTriangle(1,1));
        System.out.println(solution.maxHeightOfTriangle(2,4));
        System.out.println(solution.maxHeightOfTriangle(10, 1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxHeightOfTriangle(int red, int blue) {

        return Math.max(getMaxHeight(red,blue), getMaxHeight(blue,red));
    }

    private int getMaxHeight(int red, int blue){
        int level = 1;
        while(red>0){
            if (red>=level) {
                red-=level;
                level++;
            }else{
                break;
            }
            if(blue>=level){
                blue-=level;
                level++;
            }else{
                break;
            }
        }
        return level-1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}