import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class ClientThread implements Runnable{
    String name;
    int id;
    Socket clientSocket;
    PrintWriter out;
    BufferedReader in;
    Server server;

    public ClientThread(int id, String n, Socket s, Server server) {
        this.id = id;
        this.name = n;
        this.clientSocket = s;
        this.server = server;
        System.out.println("------------------------------------------");
        System.out.println("New client data:");
        System.out.println("___client name: " + this.name);
        System.out.println("___client id: " + this.id);
        System.out.println("------------------------------------------");
    }

    public void run() {
        try {
            this.out = new PrintWriter(clientSocket.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String line;
            while(true) {
                line = in.readLine();
                System.out.println("{client " + this.id + "} @" + this.name +": " + line);
                for(ClientThread t: this.server.clients) {
                    if(t.id != this.id) {
                        t.out.println("@" + this.name + ": " + line);
                    }
                }
            }
        } catch (SocketException s){
            System.out.println("Connection to client " + this.id + " lost");
            try {
                this.server.joinThread(this.id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }catch (IOException e) {
            e.printStackTrace();
            //System.out.println("Connection lost");
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                    clientSocket.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

