package App;

import javax.swing.*;

public class Resource {

    private static final int LEFT_PAD = 5;
    private static final int HEIGHT = 40;
    private static final int WIDTH = 100;
    private static final int RESULTS_LEFT_PAD = 300;

    private JLabel frequencyText;
    private JLabel diceNumberTotalText;
    private JLabel resourceAmountTotalText;


    private int frequencyTotal = 0;
    private int diceNumberTotal = 0;
    private int resourceTotal = 0;

    private int index;


    String name;

    public Resource(int index, String name, int padLeft){
        this.name = name;
        this.index = index;

        frequencyText = new JLabel(name + " total: " + frequencyTotal);
        frequencyText.setBounds(400 + padLeft, 750, 300, 40);//x axis, y axis, width, height

        diceNumberTotalText = new JLabel(name + " total resources collected: " + diceNumberTotal);
        diceNumberTotalText.setBounds(400 + padLeft, 775, 300, 40);//x axis, y axis, width, height

        resourceAmountTotalText = new JLabel(name + " total dice options: " + resourceTotal);
        resourceAmountTotalText.setBounds(400 + padLeft, 800, 300, 40);//x axis, y axis, width, height
        
    }


    public int getFrequencyTotal(){
        return frequencyTotal;
    }

    public void addFrequency() {
        frequencyTotal = frequencyTotal + 1 ;
    }

    public void addDiceNumber() {
        diceNumberTotal = diceNumberTotal + 1 ;
    }

    public void addResource() {
        resourceTotal = resourceTotal + 1 ;
    }

    public JLabel getFrequencyText(){
        return frequencyText;
    }

    public JLabel getResourceAmountTotalText(){
        return resourceAmountTotalText;
    }

    public JLabel getDiceNumberTotalText(){
        return diceNumberTotalText;
    }

    public void reset() {
        frequencyTotal = 0;
        diceNumberTotal = 0;
        resourceTotal = 0;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public void resetFrequencyText() {
        frequencyText.setText(getName() + " total: " + frequencyTotal);
    }

    public void resetDiceNumberText() {
        diceNumberTotalText.setText(getName() + " total dice options: " + diceNumberTotal);
    }
    public void resetResourceAmountTotalText() {
        resourceAmountTotalText.setText(getName() + " total resources collected: " + resourceTotal);
    }
}
