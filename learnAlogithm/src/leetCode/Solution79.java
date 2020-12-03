package leetCode;

/**
 * 79. 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 *
 * 提示：
 *
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 * 通过次数102,750提交次数237,333
 *
 * (思路：回溯递归)
 */
public class Solution79 {
//    public boolean exist(char[][] board, String word) {
//        int ySize = board.length;
//        int xSize = board[0].length;
//        for (int y = 0; y < y;ySize++) {
//            for (int x = 0; x < xSize; x++) {
//                dfs(board,y,x,word,0);
//            }
//        }
//        return true;
//    }

//    private void dfs(char[][] board, int y, int x, String word, int index) {
//        if (board[y][x]!=word.charAt(index)){
//            return;
//        }
//
//        for (int i = y; i < board;i++) {
//            for (int j = 0; x < xSize; x++) {
//                dfs(board,y,x,word,0);
//            }
//        }
//
//    }
}
