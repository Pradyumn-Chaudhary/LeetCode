class Solution {
    public double myPow(double x, int n) {
        long nn = n;
        return calculate(x, nn);
    }

    public static double calculate(double x, long nn) {
        if (nn < 0) {
            x = 1 / x;
            nn = nn * (-1);
        }
        if (nn == 0)
            return 1;
        if (nn == 1)
            return x;
        if (nn % 2 != 0)
            return x * calculate(x, nn - 1);

        return calculate(x * x, nn / 2);
    }
}