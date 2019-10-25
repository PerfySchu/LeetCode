//Given two binary strings, return their sum (also a binary string). 
//
// The input strings are both non-empty and contains only characters 1 or 0. 
//
// Example 1: 
//
// 
//Input: a = "11", b = "1"
//Output: "100" 
//
// Example 2: 
//
// 
//Input: a = "1010", b = "1011"
//Output: "10101" 
// Related Topics Math String
package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class AddBinary{
    public static void main(String[] args){
        Solution solution = new AddBinary().new Solution();
        String a = "100";
        String b = "110010";
        System.out.println(solution.addBinary(a, b));
    }

    /**
     * 除了暴力循环，并没有找到其他优雅的解法
     * 这题恶心的地方在于给定的两个字符串长度可能不一致
     * 既要处理进位，又要考虑长度溢出的情况，代码非常丑陋
     */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        String tmpa = a;
        String tmpb = b;
        if(b.length()>a.length()){
            tmpa = b;
            tmpb = a;
        }
        int alen = tmpa.length();
        int blen = tmpb.length();
        List<Integer> charList = new ArrayList<>();
        int flag = 0;
        for (int i=0; i<alen; i++) {
            if(i<blen) {
                if (tmpa.charAt(alen - 1 - i) == '1' && tmpb.charAt(blen - 1 - i) == '1') {
                    charList.add(flag);
                    flag = 1;
                } else if (tmpa.charAt(alen - 1 - i) == '0' && tmpb.charAt(blen - 1 - i) == '0') {
                    charList.add(flag);
                    flag = 0;
                } else {
                    if (flag == 1) {
                        charList.add(0);
                    } else {
                        charList.add(1);
                    }
                }
            }else{
                if(flag == 1 && tmpa.charAt(alen-1-i)=='1'){
                    charList.add(0);
                }else if(flag == 0 && tmpa.charAt(alen-1-i)=='0'){
                    charList.add(0);
                }else{
                    flag = 0;
                    charList.add(1);
                }
            }

        }
        StringBuilder res = new StringBuilder();
        if(flag == 1){
            res.append(flag);
        }
        for (int i = charList.size()-1; i >=0; i--) {
            res.append(charList.get(i));
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
