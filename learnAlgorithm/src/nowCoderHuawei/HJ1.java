package nowCoderHuawei;

import java.util.Scanner;

public class HJ1 {
    public static void main(String[] args) {
        String emptyStr=" ";
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String next = in.next();
            String[] split = next.split(emptyStr);
            if (split.length>1){
                int length = split[(split.length - 1)].length();
                System.out.println(length);
            }
            else {
                System.out.println(split[0].length());
            }
        }
    }
}
