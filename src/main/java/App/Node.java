package App;

import javax.swing.*;
import java.util.ArrayList;

public class Node {

    private static final int LEFT_PAD = 5;
    private static final int HEIGHT = 20;
    private static final int WIDTH = 100;
    private JLabel nodeName;
    private ArrayList<Collector> recourceCollector;

    public Node(int id, int startHeight, String[] rec){
        nodeName = new JLabel("Node " + id);
        nodeName.setBounds(LEFT_PAD, startHeight, WIDTH, HEIGHT);

        recourceCollector = new ArrayList<>();
        for(int i = 0; i < 2; i++){
            Collector collector = new Collector(id, startHeight, rec, 100 + i * 600);
            recourceCollector.add(collector);
        }
    }

    public ArrayList<Collector> getRecourceCollector() {
        return recourceCollector;
    }

    public JLabel getNodeName() {
        return nodeName;
    }
}
