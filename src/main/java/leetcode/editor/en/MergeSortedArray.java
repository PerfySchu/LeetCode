//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array. 
//
// Note: 
//
// 
// The number of elements initialized in nums1 and nums2 are m and n respectively. 
// You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 
// 
//
// Example: 
//
// 
//Input:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//Output: [1,2,2,3,5,6]
// Related Topics Array Two Pointers
package leetcode.editor.en;
public class MergeSortedArray{
    public static void main(String[] args){
        Solution solution = new MergeSortedArray().new Solution();
        int[] nums1 = new int[]{1,3,5,8,0,0,0,0};
        int[] nums2 = new int[]{2,3,5,7};
        solution.merge(nums1, 4, nums2, 4);
        for(int i=0; i<8; i++){
            System.out.print(nums1[i]+",");
        }
    }

    /**
     * 此题的难点可能就在于 不开辟新数组，在原数组上实现合并操作
     * 默认数组1第 m 位之后有足够的空间
     * 那么 采用倒序比较，从最大的值开始填充，可以避免数据覆盖的问题
     */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=m+n-1; i>=0; i--){
            if(n==0){
                break;
            }
            if(m>0 && nums1[m-1] > nums2[n-1]){
                nums1[i] = nums1[m-1];
                m--;
            }else{
                nums1[i] = nums2[n-1];
                n--;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
