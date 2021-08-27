//2021-08-27 08:47:14
//第295题
//中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例： 
//
// addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2 
//
// 进阶: 
//
// 
// 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 👍 468 👎 0

package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream{
    public static void main(String[] args){
        MedianFinder solution = new FindMedianFromDataStream().new MedianFinder();
        solution.addNum(1);
        solution.addNum(2);
        solution.addNum(3);
        System.out.println(solution.findMedian());
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {
    PriorityQueue<Integer> maxQue;
    PriorityQueue<Integer> minQue;

    /** initialize your data structure here. */
    public MedianFinder() {
        //大顶堆
        maxQue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        //小顶堆
        minQue = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }
    
    public void addNum(int num) {
        //总是保证小顶堆的数据量不少于大顶堆
        if(minQue.isEmpty() || num < minQue.peek()){
            minQue.offer(num);
            if(maxQue.size() + 1 < minQue.size()){
                maxQue.offer(minQue.poll());
            }
        }else{
            maxQue.offer(num);
            if(minQue.size() < maxQue.size()){
                minQue.offer(maxQue.poll());
            }
        }
    }
    
    public double findMedian() {
        if(minQue.size() > maxQue.size()){
            return minQue.peek();
        }
        return (minQue.peek() + maxQue.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
