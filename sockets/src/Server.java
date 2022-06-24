import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    ArrayList<ClientThread> clients = new ArrayList<>();
    ArrayList<Thread> threads = new ArrayList<>();
    ArrayList<ClientUDP> clientsUDP = new ArrayList<>();
    Thread thread;

    public void joinThread(int id) throws InterruptedException {
        int index = -1;
        int i = 0;
        for(ClientThread ct: clients) {
            if(ct.id == id) {
                index = i;
                break;
            }
            i++;
        }
        if(index != -1) {
            threads.get(index).join();
            clients.remove(index);
        }
    }

    public void joinThreadUDP() throws InterruptedException {
        this.thread.join();
    }

    public void main() throws IOException {
        System.out.println("CHAT SERVER");
        System.out.println("-----------");
        int portNumber = 12345;
        ServerSocket serverSocket = null;
        DatagramSocket serverUDP = null;
        int numberOfClients = 0;

        try {
            serverSocket = new ServerSocket(portNumber);
            serverUDP = new DatagramSocket(portNumber);
            ClientThreadUDP threadUDP = new ClientThreadUDP(serverUDP,this);
            thread = new Thread(threadUDP);
            thread.start();
            while(true) {
                Socket client = serverSocket.accept();
                System.out.println("New client connected: " + client.getInetAddress() + " | " + client.getPort());
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String name = in.readLine();
                String portString = in.readLine();
                int cudpPort = Integer.parseInt(portString);
                ClientThread thread = new ClientThread(numberOfClients,name,client,this);
                ClientUDP cUDP = new ClientUDP(name,numberOfClients,client.getInetAddress(),cudpPort);
                clients.add(thread);
                clientsUDP.add(cUDP);
                numberOfClients++;
                Thread t = new Thread(thread);
                threads.add(t);
                t.start();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (serverSocket != null){
                serverSocket.close();
                serverUDP.close();
            }
        }
    }

    static class RunServer {
        public static void main (String [] args) throws IOException, InterruptedException {
            Server s1 = new Server();
            s1.main();
        }
    }
}

class ClientUDP {
    String name;
    int id;
    InetAddress address;
    int portNumber;

    public ClientUDP(String n, int i, InetAddress a, int p) {
        this.name = n;
        this.id = i;
        this.address = a;
        this.portNumber = p;
    }
}
