//2024-04-15 09:05:24
//第LCR 139题
//教练使用整数数组 actions 记录一系列核心肌群训练项目编号。为增强训练趣味性，需要将所有奇数编号训练项目调整至偶数编号训练项目之前。请将调整后的训练项
//目编号以 数组 形式返回。
//
//
//
// 示例 1：
//
//
//输入：actions = [1,2,3,4,5]
//输出：[1,3,5,2,4]
//解释：为正确答案之一
//
//
//
// 提示：
//
//
// 0 <= actions.length <= 50000
// 0 <= actions[i] <= 10000
//
//
//
//
// Related Topics 数组 双指针 排序 👍 333 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof{
    public static void main(String[] args){
        Solution solution = new DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
        System.out.println(Arrays.toString(solution.trainingPlan(new int[]{1, 2, 3, 4, 5})));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] trainingPlan(int[] actions) {
        int left =0;
        int right = actions.length-1;
        while (left<right){
            if(actions[left]%2==0){
                if(actions[right]%2 ==1){
                    int temp = actions[left];
                    actions[left] = actions[right];
                    actions[right] = temp;
                    left++;
                    right--;
                }else {
                    right--;
                }
            }else{
                left++;
            }
        }
        return actions;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}