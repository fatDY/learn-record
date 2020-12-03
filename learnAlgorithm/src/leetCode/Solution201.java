package leetCode;

/**
 *
 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。

 示例 1:

 输入: [5,7]
 输出: 4
 示例 2:

 输入: [0,1]
 输出: 0
 */
public class Solution201 {
    public int rangeBitwiseAnd(int m, int n) {
            int shift =0;
            while (m<n){
                m= m>>1;
                n=n>>1;
                ++shift;
            }
            m<<=shift;

                return m;
    }



    /**
     * 关键是判断相同前缀，清除后几位不相同
     * @param args
     */
    public static void main(String[] args) {
        Solution201 soution201=new Solution201();
        int i = soution201.rangeBitwiseAnd(5, 7);
        System.out.println(i);
    }
}
