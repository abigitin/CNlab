import java.io.*;
import java.net.*;
import java.util.*;

class TcpEchoClient {

  public static void main(String args[]) throws Exception {
    try {
      int port = 4444;
      Socket sck = new Socket("localhost", port);
      if (sck.isConnected() == true) {
        System.out.println("server socket is connected successfully");
      }
      InputStream in = sck.getInputStream();
      OutputStream out = sck.getOutputStream();
      PrintWriter pr = new PrintWriter(out);
      while (true) {
        BufferedReader buf1 = new BufferedReader(
          new InputStreamReader(System.in)
        );
        BufferedReader buf2 = new BufferedReader(new InputStreamReader(in));
        String str1, str2;
        System.out.println(" enter message");
        str1 = buf1.readLine();
        pr.println(str1);
        pr.flush();
        System.out.println("message sent successfully");
        str2 = buf2.readLine();
        System.out.println("message from server = " + str2);
      }
    } catch (Exception e) {
      System.out.println("Error" + e.getMessage());
    }
  }
}
