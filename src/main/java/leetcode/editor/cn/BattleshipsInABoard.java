//2024-06-11 09:40:58
//第419题
//给你一个大小为 m x n 的矩阵 board 表示甲板，其中，每个单元格可以是一艘战舰 'X' 或者是一个空位 '.' ，返回在甲板 board 上放置的
// 战舰 的数量。
//
// 战舰 只能水平或者垂直放置在 board 上。换句话说，战舰只能按 1 x k（1 行，k 列）或 k x 1（k 行，1 列）的形状建造，其中 k 可以
//是任意大小。两艘战舰之间至少有一个水平或垂直的空位分隔 （即没有相邻的战舰）。
//
//
//
// 示例 1：
//
//
//输入：board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
//输出：2
//
//
// 示例 2：
//
//
//输入：board = [["."]]
//输出：0
//
//
//
//
// 提示：
//
//
// m == board.length
// n == board[i].length
// 1 <= m, n <= 200
// board[i][j] 是 '.' 或 'X'
//
//
//
//
// 进阶：你可以实现一次扫描算法，并只使用 O(1) 额外空间，并且不修改 board 的值来解决这个问题吗？
//
// Related Topics 深度优先搜索 数组 矩阵 👍 274 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class BattleshipsInABoard{
    public static void main(String[] args){
        Solution solution = new BattleshipsInABoard().new Solution();
        //System.out.println(solution.countBattleships(new char[][]{{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}}));
        //System.out.println(solution.countBattleships(new char[][]{{'.'}}));
        System.out.println(solution.countBattleships(new char[][]{{'X','.','.','X','.','.','.','.','.','.','.','.','.','.','X'},{'.','X','X','.','X','X','X','X','X','X','X','X','X','X','.'},{'X','.','.','X','.','.','.','.','.','.','.','.','.','.','X'},{'X','.','X','.','X','.','X','.','.','.','.','.','X','.','.'},{'X','.','.','X','.','X','.','X','X','X','X','X','.','X','X'},{'X','.','X','.','X','.','.','.','.','.','.','.','X','.','.'},{'X','.','.','.','.','X','X','X','X','X','X','.','X','.','X'},{'X','.','X','X','.','.','.','.','.','.','.','.','X','.','.'},{'X','.','.','.','X','X','.','X','X','X','X','.','X','.','X'},{'.','.','X','.','.','.','X','.','.','.','.','.','X','.','X'},{'.','X','.','X','.','.','X','.','.','X','.','.','X','.','X'},{'X','.','.','X','.','.','X','.','.','X','.','.','X','.','X'},{'.','X','.','X','.','.','X','.','X','.','.','X','.','.','X'},{'.','X','.','X','.','.','X','.','.','.','.','X','.','X','.'},{'X','.','.','X','.','.','X','.','.','X','.','X','.','.','X'}}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        int w = board.length;
        int h = board[0].length;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                char c = board[i][j];
                if (c == 'X') {
                    //左回溯
                    if(i>0 && board[i-1][j] == 'X') {
                        continue;

                    }
                    //上回溯
                    if(j>0 && board[i][j-1] == 'X') {
                        continue;
                    }
                    count++;
                }
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}