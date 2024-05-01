public class RemoveDuplicates {

  public static String removeDuplicates(String str) {
    if (str == null || str.length() <= 1) {
      return str;
    }

    StringBuilder sb = new StringBuilder();
    char prev = str.charAt(0);
    sb.append(prev);

    for (int i = 1; i < str.length(); i++) {
      char curr = str.charAt(i);
      if (curr != prev) {
        sb.append(curr);
        prev = curr;
      }
    }
    return sb.toString();
  }

}
