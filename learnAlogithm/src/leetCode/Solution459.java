package leetCode;

/**
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * 示例 1:
 *
 * 输入: "abab"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 *
 * 输入: "aba"
 *
 * 输出: False
 * 示例 3:
 *
 * 输入: "abcabcabcabc"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-substring-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution459 {
    public boolean repeatedSubstringPattern(String s) {
        StringBuilder stringBuilder=new StringBuilder();
        int size = s.length();
        int i=0;
        boolean compareFla=false;
        while (i<(size>>1)&&!compareFla){
            stringBuilder.append(s.charAt(i));
            if(size% stringBuilder.toString().length()==0){
                compareFla= checkRepeat(stringBuilder.toString(),s);
            }
            ++i;
        }
        return compareFla;
    }

    public boolean checkRepeat(String str,String compareStr){
        StringBuilder stringBuilder=new StringBuilder(str);
        while (stringBuilder.toString().length()<compareStr.length()){
            stringBuilder.append(str);
        }
       return stringBuilder.toString().equals(compareStr);
    }

    public static void main(String[] args) {
        Solution459 solution459=new Solution459();
        boolean aba = solution459.repeatedSubstringPattern("aba");
        System.out.println(aba);

    }
}
