package leetCode;

import java.util.LinkedList;
import java.util.Stack;

public class Solution20 {

    final static char left_sign_1='(';
    final static char left_sign_2=')';
    final static char left_sign_3='{';
    final static char left_sign_4='}';
    final static char left_sign_5='[';
    final static char left_sign_6=']';
    public boolean isValid(String s) {
        int length=s.length();
        LinkedList<Character> list= new LinkedList<>();
        for(int i=0;i<length;++i){

            char c=s.charAt(i);
            char seg =' ';
            if (list.isEmpty()){
                list.add(c);
                continue;
            }
            switch (c){
                case left_sign_1:{
                    seg=left_sign_2;
                    break;
                }
                case left_sign_2:
                {
                    seg=left_sign_1;
                    break;
                }

                case left_sign_3:
                {
                    seg=left_sign_4;
                    break;
                }
                case left_sign_4:
                {
                    seg=left_sign_3;
                    break;
                }
                case left_sign_5: {
                    seg=left_sign_6;
                    break;
                }
                case left_sign_6:
                {
                    seg=left_sign_5;
                    break;
                }
                default:break;
            }
            if (seg!=' ')
            {
                boolean containsFlag = list.contains(seg);
                Character last = list.getLast();
                if (last==seg){
                    list.removeLast();
                }
                else {
                    list.add(c);
                }
            }

        }
       return list.isEmpty();
    }
    public boolean isValid2(String s) {
        int size=  s.length();
        Stack<Character> list= new Stack<>();
        for(int i=0;i<size;++i){
            char c=s.charAt(i);
            if (list.isEmpty()){
                list.add(c);
                continue;
            }
            Character pop = list.pop();
            if ((c=='('&&pop==')')||(c==')'&&pop=='(')){
                continue;
            }
            else if ((c=='{'&&pop=='}'||(c=='}'&&pop=='{'))){
                continue;
            }
            else if ((c=='['&&pop==']')||(c==']'&&pop=='[')){
                continue;
            }
            else{
                list.push(pop);
                list.push(c);
            }

        }
        return list.isEmpty();
    }
    public static void main(String[] args) {
        Solution20 solution20=new Solution20();
        boolean valid = solution20.isValid2("([)]");
    }
}
