import java.util.List;
import java.util.ArrayList;

public class HappyNumber202 {
    public static boolean isHappy(int n) {
        List<Integer> list = new ArrayList<>();
        int sum, r;
        while (true) {
            sum = 0;
            while (n > 0) {
                r = n % 10;
                sum += r * r;
                n /= 10;
            }
            if (sum == 1)
                return true;
            if (list.contains(sum))
                return false;
            list.add(sum);
            n = sum;
        }
    }

    public static void main(String[] args) {
        System.out.println(isHappy(10));
    }
}