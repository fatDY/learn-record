package test.nowCoderHuawei;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 *
 * 输入描述:
 * 第一行输入一个有字母和数字以及空格组成的字符串，第二行输入一个字符。
 *
 * 输出描述:
 * 输出输入字符串中含有该字符的个数
 * https://www.nowcoder.com/practice/a35ce98431874e3a820dbe4b2d0508b1?tpId=37&tags=&title=&diffculty=0&judgeStatus=0&rp=1
 */
public class HJ2 {
    public static void main(String[] args) {
        String emptyStr;
        Scanner in=new Scanner(System.in);
        int count=0;
        while(in.hasNext()){
            String str = in.nextLine();
            String segFlag = in.next();
            char c1 = segFlag.toUpperCase().charAt(0);
            for(int i =0;i<str.length();++i){
                char c = str.toUpperCase().charAt(i);
              if (c==c1){
                  ++count;
              }
            }
            System.out.println(count);
        }
    }
}
