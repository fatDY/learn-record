package test.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 647. 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 */
public class Solution647 {

    public int countSubstrings(String s) {
        int length = s.length();
        List<Integer> listCount=new ArrayList<>();
        int i=0;
        while (i<length){
            int count=0;
            char c = s.charAt(i);
            char next=c;
            int j=i;
            while (next==c){
                ++i;
                ++count;
                if ((j+1)<length){
                    ++j;
                    next=s.charAt(j);
                }
                else {
                    next =0;
                }

            }
            ++i;
            listCount.add(Sum_Solution(count));
        }

        int count2=0;
        for (Integer integer : listCount) {
            count2+=+integer;
        }
        return count2;
    }
    public int Sum_Solution(int n) {
        int sum = n;
        boolean ans = (n>0)&&((sum+=Sum_Solution(n-1))>0);
        return sum;
    }

    public static void main(String[] args) {
        Solution647 solution647=new Solution647();
        int aaa = solution647.countSubstrings("aaa");
        System.out.println(aaa);
    }
}
