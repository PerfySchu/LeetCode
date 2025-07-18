//2025-07-18 15:56:01
//第374题
//我们正在玩猜数字游戏。猜数字游戏的规则如下：
//
// 我会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
//
// 如果你猜错了，我会告诉你，我选出的数字比你猜测的数字大了还是小了。
//
// 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有三种可能的情况：
//
//
// -1：你猜的数字比我选出的数字大 （即 num > pick）。
// 1：你猜的数字比我选出的数字小 （即 num < pick）。
// 0：你猜的数字与我选出的数字相等。（即 num == pick）。
//
//
// 返回我选出的数字。
//
//
//
// 示例 1：
//
//
//输入：n = 10, pick = 6
//输出：6
//
//
// 示例 2：
//
//
//输入：n = 1, pick = 1
//输出：1
//
//
// 示例 3：
//
//
//输入：n = 2, pick = 1
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= n <= 2³¹ - 1
// 1 <= pick <= n
//
//
// Related Topics 二分查找 交互 👍 366 👎 0

package leetcode.editor.cn;
public class GuessNumberHigherOrLower{
    public static void main(String[] args){
        Solution solution = new GuessNumberHigherOrLower().new Solution();
        System.out.println(solution.guessNumber(10));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        if(guess(n) == 0){
            return n;
        }
        int left = 1;
        int right = n;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int guess = guess(mid);
            if(guess == 0){
                return mid;
            }
            if(guess == 1){
                left = mid + 1;
            }
            if(guess == -1){
                right = mid - 1;
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    abstract class GuessGame {
        abstract int guessNumber(int n);

        int guess(int num){
            return 0;
        }
    }
}