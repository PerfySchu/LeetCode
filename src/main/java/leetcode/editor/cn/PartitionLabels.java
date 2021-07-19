//第763题
//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。 
//
// 
//
// 示例： 
//
// 
//输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
// 
//
// 
//
// 提示： 
//
// 
// S的长度在[1, 500]之间。 
// S只包含小写字母 'a' 到 'z' 。 
// 
// Related Topics 贪心 哈希表 双指针 字符串 
// 👍 529 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels{
    public static void main(String[] args){
        Solution solution = new PartitionLabels().new Solution();
        System.out.println(solution.partitionLabels("12341asdfa56785"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> partitionLabels(String s) {
        //记录每个字母最后出现的位置
        Map<Character,Integer> chMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            chMap.put(s.charAt(i), i);
        }

        int start = 0;
        int end = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, chMap.get(s.charAt(i)));
            if(end == i){
                result.add(end-start + 1);
                start = end+1;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
