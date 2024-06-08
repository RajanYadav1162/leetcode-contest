import java.util.*;

class Problem1 {

  public String clearDigits(String s) {

    Deque<Character> stack = new LinkedList<>();
    for (var ch : s.toCharArray()) {
      if (Character.isDigit(ch)) {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } else {
        stack.push(ch);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (var item : stack) {
      sb.append(item);
    }
    return sb.reverse().toString();
  }
}