//2022-03-01 09:19:14
//第6题
//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
//
//
//P   A   H   N
//A P L S I I G
//Y   I   R
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
//
// 请你实现这个将字符串进行指定行数变换的函数：
//
//
//string convert(string s, int numRows);
//
//
//
// 示例 1：
//
//
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
//
//示例 2：
//
//
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
//
//
// 示例 3：
//
//
//输入：s = "A", numRows = 1
//输出："A"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 由英文字母（小写和大写）、',' 和 '.' 组成
// 1 <= numRows <= 1000
//
// Related Topics 字符串 👍 1510 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class ZigzagConversion{
    public static void main(String[] args){
        Solution solution = new ZigzagConversion().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            StringBuffer result = new StringBuffer();
            int len = s.length();
            if(len<= numRows || numRows==1){
                return s;
            }
            int numCols = 0;
            int parts = len%(numRows+numRows-2);
            if(parts == 0){
                numCols = (numRows-1) * len/(numRows + numRows-2);
            }else{
                numCols = (numRows-1) * len/(numRows + numRows-2) + (parts<=numRows ? 1:(parts-numRows+1));
            }
            char[][] chars = new char[numRows][numCols];
            int index = 0;
            for(int i=0; i<numCols; i++){
                if(i%(numRows-1) == 0){
                    for(int j=0; j<numRows; j++){
                        if(index<len){
                            chars[j][i] = s.charAt(index);
                            index ++;
                        }else{
                            break;
                        }

                    }
                }else{
                    if(index<len){
                        chars[numRows-1 - i%(numRows-1)][i] = s.charAt(index);
                        index ++;
                    }else {
                        break;
                    }

                }
            }

            for(int i=0; i<numRows; i++){
                for(int j=0; j<numCols; j++){
                    if(chars[i][j] != 0) {
                        result.append(chars[i][j]);
                    }
                }
            }

            return result.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}