
class Problem3 {

  private Integer[][][] memo;

  public int maximumLength(int[] nums, int k) {

    int n = nums.length;
    memo = new Integer[n + 1][k + 1][n + 1];
    return dp(nums, 0, k, n);
  }

  public int dp(int[] A, int i, int k, int prev) {

    if (i == A.length) {
      return 0;
    }
    if (memo[i][k][prev] != null) {
      return memo[i][k][prev];
    }

    int c = Integer.MIN_VALUE;
    int n = A.length;
    //not take
    c = Math.max(c, dp(A, i + 1, k, prev));

    //take
    if (prev == n) {
      c = Math.max(c, dp(A, i + 1, k, i) + 1);
    } else {
      if (A[prev] != A[i]) {
        if (k > 0) {
          c = Math.max(c, dp(A, i + 1, k - 1, i) + 1);
        }
      } else {
        c = Math.max(c, dp(A, i + 1, k, i) + 1);
      }
    }

    return memo[i][k][prev] = c;
  }
}