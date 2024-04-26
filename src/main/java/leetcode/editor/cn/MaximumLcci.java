//2024-04-26 11:16:36
//第面试题 16.07题
//编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
// 示例：
// 输入： a = 1, b = 2
//输出： 2
//
//
// Related Topics 位运算 脑筋急转弯 数学 👍 151 👎 0

package leetcode.editor.cn;
public class MaximumLcci{
    public static void main(String[] args){
        Solution solution = new MaximumLcci().new Solution();
        System.out.println(solution.maximum(1, 2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximum(int a, int b) {
        long c = a, d = b;
        return (int)((Math.abs(c-d) + c + d) / 2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}