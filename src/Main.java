import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try {
            Server();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage() + " : " + ex.getCause());
        }
    }
    public static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    public static void Server() throws Exception
    {
        ServerSocket server = new ServerSocket(PORT);
        Socket socket = server.accept();

        Scanner in = new Scanner(socket.getInputStream());
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        System.out.print("Input awaited....");
        int A = in.nextInt();
        int B = in.nextInt();

        out.println(gcd(A, B));
        socket.close();
    }
}