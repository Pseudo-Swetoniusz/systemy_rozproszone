import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Arrays;
import java.util.Scanner;

public class Client {
    String clientName = null;
    Scanner nameIn = new Scanner(System.in);
    int portNumber;
    Socket socket = null;
    DatagramSocket socketUDP = null;
    InetAddress address = null;
    String hostName = "localhost";
    PrintWriter out = null;
    BufferedReader in = null;
    Thread write = null;
    Thread read = null;
    Thread readUDP = null;
    InetAddress addressClients = null;
    MulticastSocket mSocket = null;
    int mPort = 23456;
    Thread readMulticast;

    public Client(int nr) {
        this.portNumber = nr;
    }


    public void joinThreads() throws InterruptedException, IOException {
        System.out.println("Connection to server lost");
        this.write.join();
        this.read.join();
        this.readUDP.join();
        this.readMulticast.join();
        if (this.socket != null){
            this.socket.close();
        }
        if (this.socketUDP != null){
            this.socketUDP.close();
        }
        if (this.mSocket != null){
            this.mSocket.close();
        }
        System.exit(-1);
    }

    public void establishClient() throws IOException {
        System.out.println("Please, choose your username:");
        String n = nameIn.nextLine();
        setClientName(n);
        System.out.println("Your username is: " + this.clientName);
        System.out.println("------------------------");
        this.socket = new Socket(this.hostName,this.portNumber);
        this.out = new PrintWriter(this.socket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        this.socketUDP = new DatagramSocket();
        this.address = InetAddress.getByName("localhost");
        out.println(this.clientName);
        out.println(this.socketUDP.getLocalPort());
        this.mSocket = new MulticastSocket(mPort);
        this.addressClients = InetAddress.getByName("239.0.0.0");
        this.mSocket.joinGroup(this.addressClients);
    }

    public void setClientName(String n) {
        this.clientName = n;
    }

    public void runThreads() {
        ReadThread readTh = new ReadThread(this.in, this);
        WriteThread writeTh = new WriteThread(this.nameIn, this.out, this, this.socketUDP, this.address, this.portNumber, this.mSocket, this.mPort, this.addressClients, this.clientName);
        ReadThreadUDP readUTH = new ReadThreadUDP(this,this.socketUDP);
        ReadThreadMulticast readM = new ReadThreadMulticast(this.clientName, this.mSocket, this.addressClients, this.mPort, this);
        this.read = new Thread(readTh);
        this.write = new Thread(writeTh);
        this.readUDP = new Thread(readUTH);
        this.readMulticast =  new Thread(readM);
        this.read.start();
        this.write.start();
        this.readUDP.start();
        this.readMulticast.start();
    }

    public void runClient () throws IOException, InterruptedException {
        System.out.println("CLIENT - WELCOME TO CHAT");
        System.out.println("------------------------");
        try{
            establishClient();
            runThreads();
        }catch (SocketException s) {
            System.out.println("Connection lost");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class RunClient {
        public static void main (String [] args) throws IOException, InterruptedException {
            Client c1 = new Client(12345);
            c1.runClient();
        }
    }
}

class ReadThread implements Runnable {
    BufferedReader in;
    Client client;

    public ReadThread(BufferedReader in, Client c) {
        this.in = in;
        this.client = c;
    }

    public void run() {
        while(true) {
            try {
                String response = in.readLine();
                System.out.println(response);
            } catch(SocketException s) {
                //System.out.println(this.client.working);
                //this.client.working = false;
                try {
                    this.client.joinThreads();
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class WriteThread implements Runnable {
    Scanner in;
    PrintWriter out;
    Client client;
    DatagramSocket socket;
    InetAddress address;
    int portNumber;
    InetAddress addressM;
    int portM;
    MulticastSocket socketM;
    String name;

    public WriteThread(Scanner in, PrintWriter out, Client c, DatagramSocket s, InetAddress a, int p, MulticastSocket m, int pm, InetAddress am, String n) {
        this.in = in;
        this.out = out;
        this.client = c;
        this.socket = s;
        this.address = a;
        this.portNumber = p;
        this.addressM = am;
        this.portM = pm;
        this.socketM = m;
        this.name = n;
    }

    public void run() {
        while(true) {
            String msg = in.nextLine();
            if(msg.charAt(0) == 'U' && msg.charAt(1) == ' ' && msg.charAt(2) == '#') {
                //System.out.println("UDP");
                String newLine = msg.substring(4);
                String parts[] = newLine.split("#");
                int nrOfLines = Integer.parseInt(parts[0]);
                newLine = "";
                int z =0;
                if(parts.length > 1) {
                    for(String s: parts) {
                        if(z != 0) {
                            newLine = newLine + s;
                        }
                        z++;
                    }
                    byte[] sendBuffer = newLine.getBytes();
                    DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, address, portNumber);
                    try {
                        socket.send(sendPacket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    for(int i=0; i<nrOfLines; i++) {
                        String msg1 = in.nextLine();
                        byte[] sendB = msg1.getBytes();
                        DatagramPacket sendP = new DatagramPacket(sendB, sendB.length, address, portNumber);
                        socket.send(sendP);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if(msg.charAt(0) == 'M' && msg.charAt(1) == ' ' && msg.charAt(2) == '#') {
                //System.out.println("Multicast");
                String newLine = msg.substring(4);
                String parts[] = newLine.split("#");
                int nrOfLines = Integer.parseInt(parts[0]);
                newLine = "@" + this.name + ": ";
                //newLine = "@" + this.name + ": " + newLine;
                int z =0;
                if(parts.length > 1) {
                    for(String s: parts) {
                        if(z != 0) {
                            newLine = newLine + s;
                        }
                        z++;
                    }
                    byte[] sendBuffer = newLine.getBytes();
                    DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, this.addressM, this.portM);
                    try {
                        socketM.send(sendPacket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                for(int i=0; i<nrOfLines; i++) {
                    String msg1 = in.nextLine();
                    msg1 = "@" + this.name + ": " + msg1;
                    byte[] sendB = msg1.getBytes();
                    DatagramPacket sendP = new DatagramPacket(sendB, sendB.length, this.addressM, this.portM);
                    try {
                        socketM.send(sendP);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            else {
                out.println(msg);
            }
        }
    }
}

class ReadThreadUDP implements Runnable{
    DatagramSocket socket;
    Client client;

    public ReadThreadUDP(Client c, DatagramSocket s) {
        this.socket = s;
        this.client = c;
    }

    public void run() {
        byte[] receiveBuffer = new byte[1024];
        while(true) {
            Arrays.fill(receiveBuffer, (byte)0);
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            try {
                socket.receive(receivePacket);
                String msg = new String(receivePacket.getData());
                System.out.println(msg);
            } catch(SocketException s) {
                //System.out.println(this.client.working);
                //this.client.working = false;
                try {
                    //System.out.println("x");
                    this.client.joinThreads();
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}

class ReadThreadMulticast implements Runnable{
    String name;
    MulticastSocket socket;
    InetAddress address;
    int port;
    String msgStart;
    Client client;

    public ReadThreadMulticast(String n, MulticastSocket s, InetAddress a, int p, Client c) {
        this.name = n;
        this.socket = s;
        this.address = a;
        this.port = p;
        this.msgStart = "@" + this.name + ":";
        this.client = c;
    }

    public void run() {
        byte[] receiveBuffer = new byte[1024];
        while(true) {
            Arrays.fill(receiveBuffer, (byte)0);
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length, this.address, this.port);
            try {
                socket.receive(receivePacket);
                String msg = new String(receivePacket.getData());
                //System.out.println(msg);
                if(!msg.startsWith(this.msgStart)) {
                    System.out.println(msg);
                }
            } catch(SocketException s) {
                //System.out.println(this.client.working);
                //this.client.working = false;
                try {
                    //System.out.println("x");
                    this.client.joinThreads();
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
