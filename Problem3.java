
import java.util.*;

class Problem3 {

  public long maximumTotalDamage(int[] power) {

    int n = power.length;
    long[] dp = new long[n];
    Arrays.sort(power);
    long[] suffix = new long[n];
    suffix[n - 1] = power[n - 1];
    dp[n - 1] = power[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      dp[i] = power[i];

      if (power[i] == power[i + 1]) {
        dp[i] += dp[i + 1];
      } else {
        int idx = find(power, power[i] + 2, i + 1);
        if (idx != power.length) {
          dp[i] += suffix[idx];
        }
      }
      suffix[i] = Math.max(dp[i], suffix[i + 1]);
    }

    return Arrays.stream(dp).max().getAsLong();
  }

  int find(int[] A, int target, int left) {
    int right = A.length;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (A[mid] > target) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
}