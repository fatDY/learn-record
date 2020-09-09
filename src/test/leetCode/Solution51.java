package test.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N 皇后
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * <p>
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * <p>
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：4
 * 输出：[
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 */
public class Solution51 {
    public final String queen = "Q";
    public final String blank = ".";

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        String[][] map = new String[n][n];

        List<String> segList = new ArrayList<>();
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (y == 0 && x == 0) {
                    map[y][x] = queen;
                }
                if (checkQueenPosition(map, x, y, n)){
                    map[y][x] = queen;
                    continue;
                };
            }

        }

        return null;
    }

    public boolean checkQueenPosition(String[][] map, int x, int y, int n) {
        String[] strings = map[y];
        for (String s : map[y]) {
            if (s.equals(queen)) {
                return false;
            }
        }
        for (int i = 0; i < n; i++) {
          if (map[i][x].equals(queen)){
              return false;
          }
        }
        while (x>0&&y>0){
           if (map[--x][--y].equals(queen)){
               return false;
           }
        }
        while (x>0&&y>0){
            if (map[++x][++y].equals(queen)){
                return false;
            }
        }
        return true;
    }
}
