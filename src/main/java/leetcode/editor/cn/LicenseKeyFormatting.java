//2024-09-05 14:13:57
//第482题
//给定一个许可密钥字符串 s，仅由字母、数字字符和破折号组成。字符串由 n 个破折号分成 n + 1 组。你也会得到一个整数 k 。
//
// 我们想要重新格式化字符串 s，使每一组包含 k 个字符，除了第一组，它可以比 k 短，但仍然必须包含至少一个字符。此外，两组之间必须插入破折号，并且应该将
//所有小写字母转换为大写字母。
//
// 返回 重新格式化的许可密钥 。
//
//
//
// 示例 1：
//
//
//输入：S = "5F3Z-2e-9-w", k = 4
//输出："5F3Z-2E9W"
//解释：字符串 S 被分成了两个部分，每部分 4 个字符；
//     注意，两个额外的破折号需要删掉。
//
//
// 示例 2：
//
//
//输入：S = "2-5g-3-J", k = 2
//输出："2-5G-3J"
//解释：字符串 S 被分成了 3 个部分，按照前面的规则描述，第一部分的字符可以少于给定的数量，其余部分皆为 2 个字符。
//
//
//
//
// 提示:
//
//
// 1 <= s.length <= 10⁵
// s 只包含字母、数字和破折号 '-'.
// 1 <= k <= 10⁴
//
//
// Related Topics 字符串 👍 174 👎 0

package leetcode.editor.cn;
public class LicenseKeyFormatting{
    public static void main(String[] args){
        Solution solution = new LicenseKeyFormatting().new Solution();
        System.out.println(solution.licenseKeyFormatting("2",2));
        System.out.println(solution.licenseKeyFormatting("5F3Z-2e-9-w",4));
        System.out.println(solution.licenseKeyFormatting("2-5g-3-J",2));
        System.out.println(solution.licenseKeyFormatting("2-4A0r7-4k",4));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String licenseKeyFormatting(String s, int k) {
        String newStr = s.replace("-", "").toUpperCase();
        StringBuilder sb = new StringBuilder();
        int group = newStr.length() / k;
        int last = newStr.length() % k;
        if (group==0) {
            return newStr;
        }
        if (last != 0) {
            sb.append(newStr, 0, last).append("-");
        }
        for (int i = 0; i < group; i++) {
            sb.append(newStr, last+i*k, last+i*k+k);
            if(i!=group-1){
                sb.append("-");
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}