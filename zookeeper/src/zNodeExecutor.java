import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

public class zNodeExecutor implements Watcher {
    String zNode;
    ZooKeeper zooKeeper;
    boolean running = false;
    String exec;
    Runtime runTime = Runtime.getRuntime();
    Process process;
    int descNumber = -1;

    public zNodeExecutor(String zNode,ZooKeeper zooKeeper, String exec) throws KeeperException, InterruptedException, IOException {
        this.zNode = zNode;
        this.zooKeeper = zooKeeper;
        this.exec = exec;
        Stat z = this.zooKeeper.exists(this.zNode, this);
        if (z!= null) {
            System.out.println("Node already exists");
            execute_program();
            watchChildren(this.zNode);
            countDescendants();
        }
    }
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getType() == Event.EventType.NodeCreated) {
            System.out.println("Node was created -- starting program");
            try {
                execute_program();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                watchChildren(this.zNode);
            } catch (KeeperException | InterruptedException e) {
                System.out.println("Watch error");
                e.printStackTrace();
            }
        }
        else if (watchedEvent.getType() == Event.EventType.NodeChildrenChanged) {
            try {
                if(running) {
                    countDescendants();
                    watchChildren(this.zNode);
                }
            } catch (KeeperException | InterruptedException e) {
                System.out.println("Watch error");
                e.printStackTrace();
            }
        }
        else if (watchedEvent.getType() == Event.EventType.NodeDeleted) {
            try {
                Stat s = this.zooKeeper.exists(this.zNode, false);
                if(this.running && s == null) {
                    System.out.println("Node was deleted -- stopping program");
                    stop_program();
                }
            } catch (KeeperException | InterruptedException e) {
                System.out.println("Watch error");
                e.printStackTrace();
            }
        }
        try {
            this.zooKeeper.exists(this.zNode, this);
        } catch (KeeperException | InterruptedException e) {
            System.out.println("Watch error");
            e.printStackTrace();
        }
    }

    public void execute_program() throws IOException {
        this.running = true;
        this.process = runTime.exec(this.exec);
    }

    public void stop_program() {
        this.running = false;
        this.process.destroy();
    }

    public void watchChildren(String node) throws KeeperException, InterruptedException {
        List<String> children = this.zooKeeper.getChildren(node, this);
        for(String child : children) {
            String fullChild = node + "/" + child;
            watchChildren(fullChild);
        }
    }

    public void countDescendants() throws KeeperException, InterruptedException {
        int d = countDescendantsOfNode(this.zNode);
        if (d < this.descNumber) {
            System.out.println("Descendant was deleted");
            this.descNumber = d;
        }
        else if (d > this.descNumber && this.descNumber != -1) {
            System.out.println("Descendant was addded");
            this.descNumber = d;
        }
        else if(this.descNumber == -1) {
            this.descNumber = d;
        }
        else {
            System.out.println("Change in descendant occurred");
            this.descNumber = d;
        }
        System.out.println("Number of z node descendants: " + this.descNumber);
    }

    public int countDescendantsOfNode(String node) throws KeeperException, InterruptedException {
        int number = 0;
        List<String> children = this.zooKeeper.getChildren(node, false);
        for(String child : children) {
            String fullChild = node + "/" + child;
            int childDesc = countDescendantsOfNode(fullChild);
            number += childDesc + 1;
        }
        return number;
    }
}
