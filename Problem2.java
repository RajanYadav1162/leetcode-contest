import java.util.*;

class Solution {

  public long countCompleteDayPairs(int[] A) {

    long count[] = new long[24];
    int n = A.length;
    long res = 0L;
    for(int a : A){
      int required = (24 - a %24)%24;
      res+=count[required];
      count[a%24]++;
    }
    return res;
  }
}