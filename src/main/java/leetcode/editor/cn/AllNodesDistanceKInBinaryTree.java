//第863题
//给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。 
//
// 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//输出：[7,4,1]
//解释：
//所求结点为与目标结点（值为 5）距离为 2 的结点，
//值分别为 7，4，以及 1
//
//
//
//注意，输入的 "root" 和 "target" 实际上是树上的结点。
//上面的输入仅仅是对这些对象进行了序列化描述。
// 
//
// 
//
// 提示： 
//
// 
// 给定的树是非空的。 
// 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。 
// 目标结点 target 是树上的结点。 
// 0 <= K <= 1000. 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 315 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllNodesDistanceKInBinaryTree{
    public static void main(String[] args){
        AllNodesDistanceKInBinaryTree tree = new AllNodesDistanceKInBinaryTree();
        TreeNode node7 = tree.new TreeNode(7, null, null);
        TreeNode node4 = tree.new TreeNode(4, null, null);
        TreeNode node0 = tree.new TreeNode(0, null, null);
        TreeNode node8 = tree.new TreeNode(8, null, null);
        TreeNode node6 = tree.new TreeNode(6, null, null);
        TreeNode node2 = tree.new TreeNode(2, node7, node4);
        TreeNode node5 = tree.new TreeNode(5, node6, node2);
        TreeNode node1 = tree.new TreeNode(1, node0, node8);
        TreeNode root = tree.new TreeNode(3, node5, node1);
        Solution solution = tree.new Solution();
        System.out.println(solution.distanceK(root, node5, 2));
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int x, TreeNode left, TreeNode right){
            this.val= x;
            this.left = left;
            this.right = right;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> result = new ArrayList<>();
    Map<Integer, TreeNode> parentMap = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParent(root);
        findResult(target, null, 0, k);
        return result;
    }

    public void findParent(TreeNode node){
        if(node.left != null){
            parentMap.put(node.left.val, node);
            findParent(node.left);
        }
        if(node.right != null){
            parentMap.put(node.right.val, node);
            findParent(node.right);
        }
    }

    //加上一个 from 判断，避免父子节点间反复横跳，产生重复数据
    public void findResult(TreeNode node, TreeNode from, int deep, int k){
        if(node == null){
            return;
        }
        if(deep == k){
            result.add(node.val);
            return;
        }
        //左子树
        if(node.left != from){
            findResult(node.left, node,deep+1, k);
        }
        //右子树
        if(node.right != from){
            findResult(node.right, node,deep+1, k);
        }

        //父节点
        if(parentMap.get(node.val) != from) {
            findResult(parentMap.get(node.val), node, deep + 1, k);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
