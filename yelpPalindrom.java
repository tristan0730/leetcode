import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by yiyangtan on 9/8/15.
 * =================
 3.	palidrom check
 =================

 Code test:
 palidrom test

 if can be turned into palindrome return 'true' example 'aab'->'true'
 'abc'->'false'
 otherwise 'false'
 Bless!!!

 ---

 check palindrom : if  yes, return true; if no, return false .
 public class{
 public static void main(String [] args) {
 // read from std input;
 }
 }

 这个function本事是毫无难度。但是我到现在都没弄明白的是,这个题目是希望
 我们把这个function 写在main methon 里面嘛？然后这个online judge 到底是
 怎么test 的？ 是给一个input.txt 和一个output.txt.然后要read from input.txt;
 再write to output.txt?

 我自己是单独在solution class写了一个 checkPalindrom class, 再在main metho里面
 加了一个file reader 和write ,一边read from file,一边call checkPalindrom 这个function
 很明显不对。。

 用BufferedReader去读System.in,然后输出就是System.out.println啥的，hackerrank很多题目都是在main里面写的。
 http://www.mkyong.com/java/how-to-get-the-standard-input-in-java/


 */
public class yelpPalindrom {
    public static void main(String [] args) {
        // read from std input;
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char [] arr = s.toCharArray();
        Arrays.sort(arr);
        int count = 0;
        int index = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]!=arr[i]){
                count += (i-index)%2;
                if(count>1){
                    System.out.println("false");
                    return;
                }
                index = i;
            }
        }
        System.out.println("true");
    }
}
