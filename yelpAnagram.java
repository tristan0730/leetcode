/**
 * Created by yiyangtan on 9/8/15.
 * ================
 2. anagram check
 ================

 第二部分 20分钟的编程 anagram check， 看两个string是不是anagram.
 输入stdin不太懂，输出stdout应该就是System.out.println
 所以程序写了没有跑出来

 ---

 Coding problem:
 1. leetcode anagram
 2. Follow up: 怎么用map reduce做？
 */
import java.util.HashMap;
import java.util.Scanner;

public class yelpAnagram {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        if(s1.length()!=s2.length()){
            System.out.println("false");
            return;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i<s1.length();i++){
            char c1  = s1.charAt(i);
            if(map.containsKey(c1)){
                map.put(c1,map.get(c1)+1);
            }
            else{
                map.put(c1,1);
            }
        }
        for(int i = 0; i<s2.length();i++){
            char c1  = s2.charAt(i);
            if(!map.containsKey(c1)||map.get(c1)==0){
                System.out.println("false");
                return;
            }
            else{
                map.put(c1,map.get(c1)-1);
            }
        }
        System.out.println("true");
    }
}
