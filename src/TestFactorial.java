/**
 * Created by Santer on 16.12.2015.
 */
public class TestFactorial {

    public static void main(String[] args) {
        int n = 6;

        System.out.println(factorianFor(n));
        System.out.println(factorianRecursive(n));
    }

    private static int factorianRecursive(int n) {
        int result = 1;

        if (n < 2) {
            result = 1;
        } else {
            result = n * factorianFor(n - 1);
        }

        return result;
    }

    private static int factorianFor(int n) {
        int result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
