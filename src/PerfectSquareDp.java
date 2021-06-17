import java.util.Arrays;

public class PerfectSquareDp {
    int[] dp;

    public int numSquares(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int maxSquareRoot = (int) Math.sqrt(n) + 1;
        for (int i = 1; i < maxSquareRoot; i++)
            dp[i * i] = 1;

        return dp(n);
    }

    public int dp(int n) {
        if (dp[n] < Integer.MAX_VALUE)
            return dp[n];
        int maxSquareRoot = (int) Math.sqrt(n) + 1;
        int[] square = new int[maxSquareRoot];
        square[0] = Integer.MAX_VALUE;
        for (int i = 1; i < maxSquareRoot; i++)
            square[i] = dp(n - i * i) + 1;
        dp[n] = Arrays.stream(square).min().getAsInt();
        return dp[n];
    }
}
