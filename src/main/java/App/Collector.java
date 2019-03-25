package App;

import javax.swing.*;
import java.util.ArrayList;

public class Collector {

    private int startHeight;
    private int nodeId;
    private static final int LEFT_PAD = 5;
    private static final int HEIGHT = 20;
    private static final int WIDTH = 100;
    private static final int CHECKBOX_WIDTH = 40;
    private JComboBox item;
    private ArrayList<JCheckBox> diceNumbers;
    private ArrayList<Collector> recourceCollector;

    public Collector(int nodeId, int startHeight, String[] rec, int startPad){
        diceNumbers = new ArrayList();
        this.nodeId = nodeId;
        this.startHeight = startHeight;

        for(int i = 2; i < 13; i++){
            diceNumbers.add(constructCheckBox(i+"", i * CHECKBOX_WIDTH + startPad));
        }

        item = constructDropDown(startPad, rec);
    }

    private JCheckBox constructCheckBox(String name, int leftPad){
        JCheckBox number = new JCheckBox(name);
        number.setBounds(leftPad + 50, startHeight, CHECKBOX_WIDTH, HEIGHT);
        return number;
    }


    private JComboBox constructDropDown(int leftpad, String[] rec){
        JComboBox item = new JComboBox(rec);
        item.setBounds(LEFT_PAD + leftpad, startHeight, WIDTH, HEIGHT);
        item.setSelectedIndex(0);
        return item;
    }

    public JComboBox getItem() {
        return item;
    }

    public ArrayList<JCheckBox> getDiceNumbers() {
        return diceNumbers;
    }

}
