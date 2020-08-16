package test.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 *
 * 重复出现的子串要计算它们出现的次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-binary-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 *
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 *
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-binary-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int countBinarySubstrings(String s) {
        List<Integer> countList=new ArrayList<>();
        int length = s.length();
        int j=0;
        while (j<length){
            char c = s.charAt(j);
            int count=0;
            while (j<length&&c==s.charAt(j)){
                ++count;
                ++j;
            }
            countList.add(count);
        }
        System.out.println(countList.toString());
        int calCount=0;
        for (int i = 0; i < countList.size(); i++) {
            if (i<countList.size()-1){
                calCount+= Math.min(countList.get(i),countList.get(i + 1));
            }
        }
        return calCount;
    }
    public int countBinarySubstrings2(String s) {
        List<Integer> counts = new ArrayList<Integer>();
        int ptr = 0, n = s.length();
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                ++ptr;
                ++count;
            }
            counts.add(count);
        }
        int ans = 0;
        System.out.println(counts.toString());
        for (int i = 1; i < counts.size(); ++i) {
            ans += Math.min(counts.get(i), counts.get(i - 1));
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution solution=new Solution();
        int i2 = solution.countBinarySubstrings("00110011");
        int i = solution.countBinarySubstrings2("00110011");
        System.out.println(i);
    }
}
