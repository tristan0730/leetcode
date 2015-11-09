import java.util.Scanner;

/**
 * Created by yiyangtan on 9/8/15.
 */
public class yelpReverseWord {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.trim().replaceAll(" +"," ");
        String [] sp = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=sp.length-1;i>=0;i--){
            sb.append(sp[i]);
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
