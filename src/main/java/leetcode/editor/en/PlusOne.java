//Given a non-empty array of digits representing a non-negative integer, plus one to the integer. 
//
// The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit. 
//
// You may assume the integer does not contain any leading zero, except the number 0 itself. 
//
// Example 1: 
//
// 
//Input: [1,2,3]
//Output: [1,2,4]
//Explanation: The array represents the integer 123.
// 
//
// Example 2: 
//
// 
//Input: [4,3,2,1]
//Output: [4,3,2,2]
//Explanation: The array represents the integer 4321.
// Related Topics Array
package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class PlusOne{
    public static void main(String[] args){
        Solution solution = new PlusOne().new Solution();
        //int[] num = {6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3};
        int[] num = {0};
        int[] res = solution.plusOne(num);
        for (int re : res) {
            System.out.print(re+",");
        }
    }

    /**
     * 这题乍看可以用数组算出一个大数，再把数拆分取余得到最终数组的每一位，
     * 但是算到最后超过了Long型的最大值，只能作罢
     * 老老实实遍历数组，处理掉开头的 0， 并且在最后加上一位加 1，并处理可能存在的进位问题
     * 没错，这题的重点就是进位的问题
     */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> tempArr = new ArrayList<>();
        for(int dig : digits){
            if(tempArr.size() == 0 && dig == 0){
                continue;
            }
            tempArr.add(dig);
        }
        int len = tempArr.size();
        if(len == 0){
            return new int[]{1};
        }
        tempArr.set(len-1, tempArr.get(len-1)+1);
        int flag = 0;
        for(int i=len-1; i>=0; i--){
            if(tempArr.get(i) + flag == 10){
                tempArr.set(i, 0);
                flag=1;
            }else{
                tempArr.set(i, tempArr.get(i) + flag);
                flag = 0;
            }
        }
        List<Integer> res = new ArrayList<>();
        if(flag == 1){
            res.add(flag);
            len++;
        }
        res.addAll(tempArr);
        int[] result = new int[len];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
