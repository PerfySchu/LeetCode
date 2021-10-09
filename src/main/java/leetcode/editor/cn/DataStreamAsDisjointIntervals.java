//2021-10-09 09:20:34
//第352题
//给你一个由非负整数 a1, a2, ..., an 组成的数据流输入，请你将到目前为止看到的数字总结为不相交的区间列表。 
//
// 实现 SummaryRanges 类： 
//
// 
// 
// 
// SummaryRanges() 使用一个空数据流初始化对象。 
// void addNum(int val) 向数据流中加入整数 val 。 
// int[][] getIntervals() 以不相交区间 [starti, endi] 的列表形式返回对数据流中整数的总结。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", 
//"addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
//[[], [1], [], [3], [], [7], [], [2], [], [6], []]
//输出：
//[null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]],
// null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]
//
//解释：
//SummaryRanges summaryRanges = new SummaryRanges();
//summaryRanges.addNum(1);      // arr = [1]
//summaryRanges.getIntervals(); // 返回 [[1, 1]]
//summaryRanges.addNum(3);      // arr = [1, 3]
//summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3]]
//summaryRanges.addNum(7);      // arr = [1, 3, 7]
//summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3], [7, 7]]
//summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
//summaryRanges.getIntervals(); // 返回 [[1, 3], [7, 7]]
//summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
//summaryRanges.getIntervals(); // 返回 [[1, 3], [6, 7]]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= val <= 10⁴ 
// 最多调用 addNum 和 getIntervals 方法 3 * 10⁴ 次 
// 
// 
// 
//
// 
//
// 进阶：如果存在大量合并，并且与数据流的大小相比，不相交区间的数量很小，该怎么办? 
// Related Topics 设计 二分查找 有序集合 👍 83 👎 0

package leetcode.editor.cn;

import java.util.Map;
import java.util.TreeMap;

public class DataStreamAsDisjointIntervals{
    public static void main(String[] args){
        SummaryRanges solution = new DataStreamAsDisjointIntervals().new SummaryRanges();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class SummaryRanges {
    //left,right
    TreeMap<Integer, Integer> intervals;

    public SummaryRanges() {
        intervals = new TreeMap<>();
    }
    
    public void addNum(int val) {
        //获取左边界大于 val 的 第一个entry
        Map.Entry<Integer, Integer> interval1 = intervals.ceilingEntry(val+1);
        //获取右边界小于等于 val 的 第一个entry
        Map.Entry<Integer, Integer> interval0 = intervals.floorEntry(val);

        if(interval0 != null && interval0.getKey() <= val && val <=interval0.getValue()){
            //val 在现有的区间内
            return;
        }else{
            boolean leftAside = interval0 != null && interval0.getValue() + 1 == val;
            boolean rightAside = interval1 != null && interval1.getKey() -1 == val;
            // val 恰好处于两个边界中间，加入 val 后恰好能连接两个边界
            if(leftAside && rightAside){
                int left = interval0.getKey();
                int right = interval1.getValue();
                //合并两个区间
                intervals.remove(interval0.getKey());
                intervals.remove(interval1.getKey());
                intervals.put(left, right);
            }else if(leftAside){
                //val 与某一区间的右边界相连， 则直接扩展原区间右边界
                intervals.put(interval0.getKey(), val);
            }else if(rightAside){
                //val 与某一区间的左边界相连， 则直接扩展原区间左边界
                int right = interval1.getValue();
                intervals.remove(interval1.getKey());
                intervals.put(val, right);
            }else{
                //val 与所有区间都不相连，直接新增一个区间
                intervals.put(val, val);
            }
        }
    }
    
    public int[][] getIntervals() {
        int size = intervals.size();
        int[][] ans = new int[size][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : intervals.entrySet()) {
            ans[index][0] = entry.getKey();
            ans[index][1] = entry.getValue();
            index++;
        }
        return ans;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
