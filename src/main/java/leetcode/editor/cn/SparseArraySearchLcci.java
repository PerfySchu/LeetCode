//2024-08-02 16:22:28
//第面试题 10.05题
//稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
//
// 示例1:
//
//  输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""],
// s = "ta"
// 输出：-1
// 说明: 不存在返回-1。
//
//
// 示例2:
//
//  输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""],
//s = "ball"
// 输出：4
//
//
// 提示:
//
//
// words的长度在[1, 1000000]之间
//
//
// Related Topics 数组 字符串 二分查找 👍 86 👎 0

package leetcode.editor.cn;
public class SparseArraySearchLcci{
    public static void main(String[] args){
        Solution solution = new SparseArraySearchLcci().new Solution();
        System.out.println(solution.findString(new String[]{"at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""}, "ta"));
        System.out.println(solution.findString(new String[]{"at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""}, "ball"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findString(String[] words, String s) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(s)) {
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}