//2023-01-10 21:31:46
//第753题
//有一个需要密码才能打开的保险箱。密码是 n 位数, 密码的每一位是 k 位序列 0, 1, ..., k-1 中的一个 。
//
// 你可以随意输入密码，保险箱会自动记住最后 n 位输入，如果匹配，则能够打开保险箱。
//
// 举个例子，假设密码是 "345"，你可以输入 "012345" 来打开它，只是你输入了 6 个字符.
//
// 请返回一个能打开保险箱的最短字符串。
//
//
//
// 示例1:
//
// 输入: n = 1, k = 2
//输出: "01"
//说明: "10"也可以打开保险箱。
//
//
//
//
// 示例2:
//
// 输入: n = 2, k = 2
//输出: "00110"
//说明: "01100", "10011", "11001" 也能打开保险箱。
//
//
//
//
// 提示：
//
//
// n 的范围是 [1, 4]。
// k 的范围是 [1, 10]。
// k^n 最大可能为 4096。
//
//
//
//
// Related Topics 深度优先搜索 图 欧拉回路 👍 207 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class CrackingTheSafe{
    public static void main(String[] args){
        Solution solution = new CrackingTheSafe().new Solution();
        System.out.println(solution.crackSafe(3, 3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    StringBuilder sb = new StringBuilder();
    int n,k,mod;
    Set<Integer> vis = new HashSet<>();
    public String crackSafe(int N, int K) {
        n = N;
        k = K;
        mod = (int) Math.pow(10, n-1);
        dfs(0);
        sb.append("0".repeat(n-1));
        return sb.toString();
    }

    void dfs(int u){
        for (int i = 0; i < k; i++) {
            int v = u*10 +i;
            if(vis.contains(v)){
                continue;
            }
            vis.add(v);
            dfs(v % mod);
            sb.append(i);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}