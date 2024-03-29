//第面试题 10.02题
//编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。 
//
// 注意：本题相对原题稍作修改 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 排序 
// 👍 25 👎 0

package leetcode.editor.cn;

import java.util.*;

public class GroupAnagramsLcci{
    public static void main(String[] args){
        Solution solution = new GroupAnagramsLcci().new Solution();
        System.out.println(solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (groupMap.containsKey(key)) {
                groupMap.get(key).add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                groupMap.put(key, list);
            }
        }
        return new ArrayList<>(groupMap.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}