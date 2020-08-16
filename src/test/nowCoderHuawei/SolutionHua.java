package test.nowCoderHuawei;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 有这样一道智力题：“某商店规定：
 * 三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，
 * 她最多可以换多少瓶汽水喝？”答案是5瓶，方法如下：
 * 先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，
 * 这时候剩2个空瓶子。然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。
 * 如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
 */
public class SolutionHua {
   public  static int count=0;
   public static int calNums;
   final static BigDecimal limitChangeSize=BigDecimal.valueOf(3);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int num = in.nextInt();
            count=0;
            dfs(num);
            System.out.println(calNums);
        }

      //  return calNums;
    }

   public static void dfs(int num){
       if (num==0){
           calNums=num;
       }
       else if (0<num&&num<=3){
           calNums=++count;
       }
       else {
           BigDecimal[] bigDecimals = BigDecimal.valueOf(num).divideAndRemainder(limitChangeSize);
           BigDecimal bigDecimalNum = bigDecimals[0];
           count+=bigDecimalNum.intValue();
           BigDecimal bigDecimalLast = bigDecimals[1];
           dfs(bigDecimalNum.add(bigDecimalLast).intValue());
       }
   }
}
