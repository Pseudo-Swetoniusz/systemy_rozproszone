import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class App implements Watcher {
    String zNode;
    ZooKeeper zooKeeper;
    zNodeExecutor zNodeExecutor;
    Thread readThread;

    public App(String host, String znode, String exec) throws IOException, KeeperException, InterruptedException {
        this.zNode = znode;
        this.zooKeeper = new ZooKeeper(host,3000,this);
        this.zNodeExecutor = new zNodeExecutor(this.zNode, this.zooKeeper,exec);
    }

    public void start() {
        ReadThread read = new ReadThread(this);
        this.readThread = new Thread(read);
        this.readThread.start();
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getType() == Event.EventType.None) {
            switch (watchedEvent.getState()) {
                case SyncConnected:
                    break;
                case Expired:
                    break;
            }
        }
    }

    public void drawTree() throws KeeperException, InterruptedException {
        Stat s = this.zooKeeper.exists(this.zNode,false);
        if (s == null) {
            System.out.println("Node doesn't exist");
            return;
        }
        System.out.println("-------------------------------");
        System.out.println("Drzewo znode: " + this.zNode);
        System.out.println("-------------------------------");
        drawNode(this.zNode, 0);
    }

    public void drawNode(String node, int level) throws KeeperException, InterruptedException {
        String s = "";
        for (int i=0; i<level; i++) {
            s = s + "  ";
        }
        s = s + node;
        System.out.println(s);
        List<String> children = this.zooKeeper.getChildren(node, false);
        for (String child : children) {
            String fullChild = node + "/" + child;
            drawNode(fullChild, level + 1);
        }
    }

    class ReadThread implements Runnable {
        App zookeeperApp;

        public ReadThread(App a) {
            this.zookeeperApp = a;
        }

        public void run() {
            Scanner scanner = new Scanner(System.in);
            while(true) {
                String command = scanner.nextLine();
                if (command.equals("exit")) {
                    break;
                }
                else if (command.equals("draw_tree")) {
                    try {
                        this.zookeeperApp.drawTree();
                    } catch (KeeperException | InterruptedException e) {
                        System.out.println("Error while drawing tree");
                        e.printStackTrace();
                    }
                }
                else {
                    System.out.println("Command not recognized");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        String host = args[0];
        String znode = args[1];
        String exec = args[2];
        App app = new App(host, znode, exec);
        app.start();
    }
}
