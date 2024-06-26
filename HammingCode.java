import java.util.Scanner;

public class HammingCode {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the data to be transmitted: ");
    String data = sc.next();
    int m = data.length();
    StringBuilder rd = new StringBuilder();
    for (int i = m - 1; i >= 0; i--) {
      rd.append(data.charAt(i));
    }
    int r = 0;
    int power = 1;
    while (power < (m + r + 1)) {
      r++;
      power *= 2;
    }
    StringBuilder msg = new StringBuilder();
    int curr = 0;
    for (int i = 1; i <= m + r; i++) {
      if ((i & (i - 1)) != 0) {
        msg.append(rd.charAt(curr++));
      } else {
        msg.append('n');
      }
    }
    int bit = 0;
    for (int i = 1; i <= m + r; i *= 2) {
      int count = 0;
      for (int j = i + 1; j <= m + r; j++) {
        if ((j & (1 << bit)) != 0) {
          if (msg.charAt(j - 1) == '1') {
            count++;
          }
        }
      }
      if ((count & 1) != 0) {
        msg.setCharAt(i - 1, '1');
      } else {
        msg.setCharAt(i - 1, '0');
      }
      bit++;
    }
    System.out.println("The data to be sent: ");
    for (int i = m + r - 1; i >= 0; i--) {
      System.out.print(msg.charAt(i) + " ");
    }
    System.out.println("Enter the position to introduce an error: ");
    int ep = sc.nextInt();
    if (ep >= 1 && ep <= m + r) {
      msg.setCharAt(ep - 1, (msg.charAt(ep - 1) == '0') ? '1' : '0');
      System.out.println("Error is introduced at position" + ep);
      for (int i = m + r - 1; i >= 0; i--) {
        System.out.print(msg.charAt(i) + " ");
      }
    }
    StringBuilder ans = new StringBuilder();
    bit = 0;
    for (int i = 1; i <= m + r; i *= 2) {
      int count = 0;
      for (int j = i + 1; j <= m + r; j++) {
        if ((j & (1 << bit)) != 0) {
          if (msg.charAt(j - 1) == '1') {
            count++;
          }
        }
      }
      if ((count & 1) != 0) {
        if (msg.charAt(i - 1) == '1') {
          ans.append('0');
        } else {
          ans.append('1');
        }
      } else {
        if (msg.charAt(i - 1) == '0') {
          ans.append('0');
        } else {
          ans.append('1');
        }
      }
      bit++;
    }
    int error = 0;
    for (int i = 0; i < r; i++) {
      if (ans.charAt(i) == '1') {
        error += Math.pow(2, 1);
      }
    }
    if (error != 0) {
      System.out.println();
      System.out.println("Error detected in bit: " + error);
      if (msg.charAt(error - 1) == '0') {
        msg.setCharAt(error - 1, '0');
      } else {
        msg.setCharAt(error - 1, '0');
      }
      System.out.println("Error is corrected");
    }
    System.out.println("Corrected data: ");
    for (int i = m + r - 1; i >= 0; i--) {
      System.out.print(msg.charAt(i) + " ");
    }
  }
}
