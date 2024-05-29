import java.io.*;
import java.net.*;
import java.util.*;

class TcpEchoServer {

  public static void main(String args[]) throws Exception {
    try {
      int port = 4444;
      ServerSocket sck = new ServerSocket(port);
      System.out.println(" server is ready to receive message ");
      Socket s0 = sck.accept();
      if (s0.isConnected() == true) {
        System.out.println(" socket is connected successfully");
      }
      InputStream in = s0.getInputStream();
      OutputStream out = s0.getOutputStream();
      PrintWriter pr = new PrintWriter(out);
      while (true) {
        BufferedReader buf = new BufferedReader(new InputStreamReader(in));
        String str = buf.readLine();
        System.out.println("Message from client = " + str);
        //System.out.println("socke5t is connected successfully");
        //pr.println(str);
        //pr.flush();
        System.out.println(" enter message");
        buf = new BufferedReader(new InputStreamReader(System.in));
        str = buf.readLine();
        pr.println(str);
        pr.flush();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
