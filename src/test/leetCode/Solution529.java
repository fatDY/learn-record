package test.leetCode;

import jdk.nashorn.internal.ir.CallNode;

/**
 * 让我们一起来玩扫雷游戏！
 *
 * 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
 *
 * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
 *
 * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
 * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minesweeper
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution529 {

    public char[][] record;

    public char target='M';
    public char unBlank='E';
    public char blank='B';
    public  int digit=0;
    public char openTarget='X';

    public int xLenght=0;
    public int yLenght=0;
    public char[][] updateBoard(char[][] board, int[] click) {
        record=board;
        int y = board.length;
        int x = board[0].length;
        xLenght=x;
        yLenght=y;
        if(record[click[0]][click[1]]==target){
            record[click[0]][click[1]]=openTarget;
        }
        else {
            dfs(click[0],click[1]);
        }

        return board;
    }

    public void dfs(int y,int x){
        if (record[y][x]==unBlank){
            /*查询周边炸弹*/
          int count=checkTarget(y,x);
          if (count!=0){
              record[y][x]= (char) ('0'+count);
          }
          else {
              record[y][x]=blank;
          }
            if (y!=0){
                dfs(y-1,x);
            }
            if (y<yLenght-1){
                dfs(y+1,x);
            }
            if (x!=0){
                dfs(y,x-1);
            }
            if (x<xLenght-1){
                dfs(y,x+1);
            }
        }
    }

    public int checkTarget(int y , int x ) {
        int count=0;
        boolean b = y != 0;
        boolean b1 = x != 0;
        boolean b2 =  x<(xLenght-1);
        boolean b3 =  y<(yLenght-1);

        if (b){

            count += target==record[x][y - 1]?1:0;
            if (b1){
                count += target== record[x-1][y - 1]?1:0;
                count += target== record[x+1][y - 1]?1:0;
                count += target==record[x-1][y + 1]?1:0;
            }
        }
        if (b3){
            count += target==record[x][y + 1]?1:0;
            if (b2){
                count += target== record[x+1][y + 1]?1:0;
            }
        }

        if ((x-1)!=0&&(x+1)<xLenght){
           count += target== record[x + 1][y]?1:0;
            char c1 = record[x - 1][y];
            if ((y-1)!=0&&(y+1)<yLenght){

            }

        }
        if ((y-1)!=0&&(y+1)<yLenght){

        }

        return count;

    }

    public static void main(String[] args) {
        char[][] chars = {{'E', 'E', 'E', 'E', 'E'},{'E', 'E', 'M', 'E', 'E'},{'E', 'E', 'E', 'E', 'E'},{'E', 'E', 'E', 'E', 'E'}};
        Solution529 solution529=new Solution529();
        solution529.updateBoard(chars,new int[]{3,0});
    }
}
