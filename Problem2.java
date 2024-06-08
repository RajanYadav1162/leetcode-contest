import java.util.*;
class Problem2 {

  public int findWinningPlayer(int[] skills, int k) {

    Map<Integer, Integer> map = new HashMap<>();
    int n = skills.length;

    k = Math.min(k, n - 1);
    int val = 0;
    Deque<Integer> deq = new LinkedList<>();
    for (var item : skills) {
      deq.addLast(item);
    }

    while (true) {
      int v1 = deq.pollFirst();
      int v2 = deq.pollFirst();

      if (v1 > v2) {
        map.merge(v1, 1, Integer::sum);
        if (map.get(v1) == k) {
          val = v1;
          break;
        }
        deq.addLast(v2);
        deq.addFirst(v1);
      } else {
        map.merge(v2, 1, Integer::sum);
        if (map.get(v2) == k) {
          val = v2;
          break;
        }
        deq.addLast(v1);
        deq.addFirst(v2);
      }

    }

    for (int i = 0; i < n; i++) {
      if (skills[i] == val) {
        return i;
      }
    }

    return -1;
  }
}
