import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
/**
 * Created by yiyangtan on 9/13/15.
 */
public class UglyNumber2 {
    public boolean isUgly(int num) {
        if(num<1) return false;
        if(num==1||num==2||num==3||num==5) return true;
        if(num%2==0) return isUgly(num/2);
        else if(num%3==0) return isUgly(num/3);
        else if(num%5==0) return isUgly(num/5);
        else return false;
    }
    public static void main(String [] args){
        UglyNumber2 u = new UglyNumber2();
        List<Integer> l = new LinkedList<>();
        for(int i = 0;i<30;i++){
            if(u.isUgly(i)){
                l.add(i);
            }
        }
        System.out.println(l);
    }
}
