//第802题
//在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。如果到达的节点是终点（即它没有连出的有向边），则停止。 
//
// 对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，则将该起始节点称作是 安全 的。 
//
// 返回一个由图中所有安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。 
//
// 该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是 graph 的节点数。图以下述形式给出：graph[i] 是编号 j 节点的一个列表，
//满足 (i, j) 是图的一条有向边。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
//输出：[2,4,5,6]
//解释：示意图如上。
// 
//
// 示例 2： 
//
// 
//输入：graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
//输出：[4]
// 
//
// 
//
// 提示： 
//
// 
// n == graph.length 
// 1 <= n <= 104 
// 0 <= graph[i].length <= n 
// graph[i] 按严格递增顺序排列。 
// 图中可能包含自环。 
// 图中边的数目在范围 [1, 4 * 104] 内。 
// 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 
// 👍 183 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class FindEventualSafeStates{
    public static void main(String[] args){
        Solution solution = new FindEventualSafeStates().new Solution();
        System.out.println(solution.eventualSafeNodes(new int[][]{{},{0,2,3,4},{3},{4},{}}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //拓扑排序解法
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        //记录节点的出度
        List<List<Integer>> out = new ArrayList<>();
        boolean[] mark = new boolean[graph.length];
        Queue<Integer> safeStack = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            List<Integer> list = new ArrayList<>(Arrays.stream(graph[i]).boxed().collect(Collectors.toList()));
            out.add(list);
            if(list.size() == 0){
                res.add(i);
                safeStack.offer(i);
                mark[i] = true;
            }
        }
        while(safeStack.size() > 0) {
            while (safeStack.size()>0) {
                Integer safePoint = safeStack.poll();
                for (List<Integer> ints : out) {
                    ints.remove(safePoint);
                }
            }
            for (int i = out.size() - 1; i >= 0; i--) {
                //出度为0，则一定是安全点
                if (out.get(i).size() == 0 && !mark[i]) {
                    res.add(i);
                    safeStack.offer(i);
                    mark[i] = true;
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
