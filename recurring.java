import java.util.HashMap;
import java.util.Map;

/**
 * Created by yiyangtan on 9/7/15.
 */

public class recurring {

    public static String fractionToDecimal(int numerator, int denominator) {
        boolean isNegative = (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) ? true : false;
        long numeratorL = Math.abs((long) numerator);
        long denominatorL = Math.abs((long) denominator);
        Map<Long, Integer> previousRemains = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        long quotian = numeratorL / denominatorL;
        sb.append(quotian);

        numeratorL %= denominatorL;

        if (numeratorL != 0) {
            sb.append(".");
        }

        int quotianIndex = 0;
        while (numeratorL != 0) {
            numeratorL *= 10;
            quotian = (numeratorL / denominatorL);
            if (!previousRemains.containsKey(numeratorL)) {
                sb.append(quotian);
                previousRemains.put(numeratorL, quotianIndex++);
            } else {
                int firstIndex = 1 + previousRemains.get(numeratorL) + sb.indexOf(".");
                sb.insert(firstIndex, '(');
                sb.append(")");
                break;
            }
            numeratorL %= denominatorL;
        }

        if (isNegative) {
            sb.insert(0, "-");
        }
        return sb.toString();
    }
    public static void main(String [] args) {
        int numerator = 1;
        int denominator = 6;
        System.out.print(fractionToDecimal(numerator, denominator));

    }
}
