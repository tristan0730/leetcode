import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by yiyangtan on 9/8/15.
 * ==============
 4.	dot product
 ==============

 编程题就是给两个sparse vector,然后求dot product.
 Given two sparse Vectors, compute the Dot Product.
 Input Format : The first line will contain two numbers(k and n), which are the number of entries for the two vectors respectively.
 The next k lines are the entries for the first vector, of the form : x y
 where x is the position and y is the value at that position in the vector.
 The n lines are the entries of the second vector.
 Any entries not specified indicate zero at that position.
 The two vectors will always be of the same length

 Example input:
 3 3
 1 4
 4 2
 5 3
 1 7
 2 6
 5 1

 Sample Answer: Dot Product = 4*7+3*1 = 31 (only print 31)
 */

public class yelpDotProduct {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(k!=0){
            map.put(sc.nextInt(),sc.nextInt());
            k--;
        }
        while(n!=0){
            int temp = sc.nextInt();
            int temp2 = sc.nextInt();
            if(map.containsKey(temp)){
                result += map.get(temp)*temp2;
            }
            n--;
        }
        System.out.println(result);
    }
}
