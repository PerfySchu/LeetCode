//2022-07-30 12:08:30
//第面试题 17.01题
//设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。
//
// 示例:
//
// 输入: a = 1, b = 1
//输出: 2
//
//
//
// 提示：
//
//
// a, b 均可能是负数或 0
// 结果不会溢出 32 位整数
//
//
// Related Topics 位运算 数学 👍 79 👎 0

package leetcode.editor.cn;
public class AddWithoutPlusLcci{
    public static void main(String[] args){
        Solution solution = new AddWithoutPlusLcci().new Solution();
        System.out.println(solution.add(1, 1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int add(int a, int b) {
        int m = a ^ b;
        int shift = (a & b) << 1;
        while(shift != 0){
            int temp = m ^ shift;
            shift = (m & shift) << 1;
            m = temp;
        }
        return m;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}