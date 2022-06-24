import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Arrays;

public class ClientThreadUDP implements Runnable{
    DatagramSocket socket;
    Server server;

    public ClientThreadUDP( DatagramSocket s, Server server) {
        this.socket = s;
        this.server = server;
    }

    public void run() {
        try {
            byte[] receiveBuffer = new byte[1024];
            String line;
            while(true) {
                Arrays.fill(receiveBuffer, (byte)0);
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(receivePacket);
                String msg = new String(receivePacket.getData());
                int p = receivePacket.getPort();
                String cname = null;
                int cid = -1;
                for(ClientUDP t: this.server.clientsUDP){
                    if(p == t.portNumber) {
                        cid = t.id;
                        cname = t.name;
                    }
                }
                if(cid != -1 && cname != null) {
                    System.out.println("{client " + cid + " [UDP]} @" + cname +": " + msg);
                    String msgNew = "@" + cname + ": " + msg;
                    byte[] sendBuffer = msgNew.getBytes();
                    for(ClientUDP t: this.server.clientsUDP) {
                        if(cid != t.id) {
                            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, t.address, t.portNumber);
                            this.socket.send(sendPacket);
                        }
                    }
                }
                //System.out.println("{client " + this.id + " [UDP]} @" + this.name +": " + msg);
                //String msgNew = "@" + this.name + ": " + msg;
                //byte[] sendBuffer = msgNew.getBytes();
                //SocketAddress addrS = receivePacket.getSocketAddress();
                //DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, this.address, this.portNumber);
                //this.socket.send(sendPacket);
                //sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, addrS);
                //System.out.println(addrS);
                //this.socket.send(sendPacket);
            }
        } catch (SocketException s){
            System.out.println("Connection to clients lost");
            try {
                this.server.joinThreadUDP();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }catch (IOException e) {
            e.printStackTrace();
            //System.out.println("Connection lost");
        } finally {
            socket.close();
        }
    }
}
