//2021-09-27 10:58:05
//第583题
//给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。 
//
// 
//
// 示例： 
//
// 输入: "sea", "eat"
//输出: 2
//解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
// 
//
// 
//
// 提示： 
//
// 
// 给定单词的长度不超过500。 
// 给定单词中的字符只含有小写字母。 
// 
// Related Topics 字符串 动态规划 👍 314 👎 0

package leetcode.editor.cn;
public class DeleteOperationForTwoStrings{
    public static void main(String[] args){
        Solution solution = new DeleteOperationForTwoStrings().new Solution();
        System.out.println(solution.minDistance("leetcode", "teetcoee"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        //求最长公共子串
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            char c1 = word1.charAt(i-1);
            for (int j= 1; j<=n; j++){
                char c2 = word2.charAt(j-1);
                if(c1 == c2){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return m + n - 2 * dp[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
