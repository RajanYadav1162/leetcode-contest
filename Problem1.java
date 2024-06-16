import java.util.*;


class Problem1 {
  public int countCompleteDayPairs(int[] A) {
    int count = 0;
    for(int i = 0; i < A.length; i++){
      for(int j = i+1; j< A.length; j++){
        if((A[i] + A[j]) % 24 == 0){
          count++;
        }
      }
    }
    return count;
  }
}
