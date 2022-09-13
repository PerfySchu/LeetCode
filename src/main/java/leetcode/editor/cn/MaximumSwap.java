//2022-09-13 10:55:56
//第670题
//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
//
// 示例 1 :
//
//
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
//
//
// 示例 2 :
//
//
//输入: 9973
//输出: 9973
//解释: 不需要交换。
//
//
// 注意:
//
//
// 给定数字的范围是 [0, 10⁸]
//
//
// Related Topics 贪心 数学 👍 303 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumSwap{
    public static void main(String[] args){
        Solution solution = new MaximumSwap().new Solution();
        System.out.println(solution.maximumSwap(2736));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumSwap(int num) {
        List<Integer> list = new ArrayList<>();
        int a = num;
        while(a > 0){
            list.add(a % 10);
            a /= 10;
        }
        System.out.println(list);
        List<Integer> numInorder = new ArrayList<>(list);
        numInorder.sort(Integer::compareTo);
        outer: for (int i = numInorder.size() - 1; i >= 0; i--) {
            if(!numInorder.get(i).equals(list.get(i))){
                for (int j = 0; j < list.size(); j++) {
                    if(list.get(j).equals(numInorder.get(i))){
                        int temp = list.get(i);
                        list.set(i, list.get(j));
                        list.set(j, temp);
                        break outer;
                    }
                }
            }
        }
        int res = 0;
        for (int size = list.size()-1; size >= 0; size--) {
            res += list.get(size) * Math.pow(10, size);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}