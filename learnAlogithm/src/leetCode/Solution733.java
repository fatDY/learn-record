package leetCode;

/**
 * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
 * <p>
 * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
 * <p>
 * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
 * <p>
 * 最后返回经过上色渲染后的图像。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flood-fill
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution733 {
    public int element;
    public int[][] calImage;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        element = image[sr][sc];
        if (element==newColor){
            return calImage;
        }
        calImage=image;
        dfs(sr,sc,newColor);
        return calImage;
    }

    public void dfs(int sr, int sc,int newColor) {
       if (element==calImage[sr][sc]) {
           calImage[sr][sc]=newColor;
           /*左*/
           if (sc > 0) {
               dfs(sr, sc - 1,newColor);
           }
           /*右*/
           if (sc < calImage[0].length-1) {
               dfs(sr, sc + 1,newColor);
           }
           /*左*/
           if (sr > 0) {
               dfs(sr - 1, sc,newColor);
           }
           /*右*/
           if (sr < calImage.length-1) {
               dfs(sr + 1, sc,newColor);
           }
        }
    }

    public static void main(String[] args) {
        Solution733 solution733=new Solution733();
        solution733.floodFill(new int[][]{{0,0,0},{0,1,1}},1,1,1);
    }
}
