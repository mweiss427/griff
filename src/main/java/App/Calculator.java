package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Calculator extends Frame implements ActionListener {

    private ArrayList<Resource> resources;
    private static final int LEFT_PAD = 5;
    private static  final String[] RESOURCE = { "wood", "stone", "cattle", "wheat" };
    ArrayList<Node> nodes = new ArrayList<>();
    JButton rollButton;
    JFrame mainFrame;
    JTextField diceNum;

    public Calculator(String title, JFrame mainFrame) {
        super(title);

        this.mainFrame = mainFrame;
        resources = new ArrayList<>();

        Resource wood = new Resource(0,"wood", 0);
        Resource stone = new Resource(1, "stone", 250);
        Resource cattle = new Resource(2, "cattle", 500);
        Resource wheat = new Resource(3, "wheat", 750);

        resources.add(wood);
        resources.add(stone);
        resources.add(cattle);
        resources.add(wheat);

        setLayout(new FlowLayout());
        rollButton = new JButton(title);//creating instance of JButton
        rollButton.setBounds(200, 750, 100, 40);//x axis, y axis, width, height

        rollButton.addActionListener(this);

        for(int i = 1; i < 32; i++){
            Node node = new Node(i, 10 + i * 20, RESOURCE);
            nodes.add(node);
            addNode(node);
        }

        setupTurns();
        setupButton();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Dice dice = new Dice();
        String numberOfRolls = diceNum.getText();

        int[] numbersRolled = dice.roll(Integer.parseInt(numberOfRolls));
        for(Resource resource: resources){
            resource.reset();
            calculateFrequency(resource);
            calculateDiceOptions(resource);





            for(int diceRoll: numbersRolled){
                calculateRecourcesCollected(resource, diceRoll);
            }


            resource.resetFrequencyText();
            resource.resetDiceNumberText();
            resource.resetResourceAmountTotalText();
        }
    }

    private void calculateRecourcesCollected(Resource resource, int diceRoll) {
        for(Node node: nodes){
            for(Collector collector: node.getRecourceCollector()){
                //only check if the collector is set to grab that resource
                if(collector.getItem().getSelectedIndex() == resource.getIndex()){
                    for(JCheckBox box :collector.getDiceNumbers()){
                        System.out.print(box.getName());
                        if(box.isSelected() && diceRoll == Integer.parseInt(box.getText())){
                            resource.addResource();
                        }
                    }
                }
            }
        }
    }

    private void calculateDiceOptions(Resource resource) {
        for(Node node: nodes){
            for(Collector collector: node.getRecourceCollector()){
                //only check if the collector is set to grab that resource
                if(collector.getItem().getSelectedIndex() == resource.getIndex()){
                   for(JCheckBox box :collector.getDiceNumbers()){
                       if(box.isSelected()){
                           resource.addDiceNumber();
                       }
                   }
                }
            }
        }
    }

    private void calculateFrequency(Resource resource) {
        for(Node node: nodes){
            for(Collector collector: node.getRecourceCollector()){
                if(collector.getItem().getSelectedIndex() == resource.getIndex()){
                    resource.addFrequency();
                }
            }
        }
    }

    public JButton getButton() {
       return rollButton;
    }

    public ArrayList<Resource> getResources(){
        return resources;
    }

    public void addNode(Node node){
        mainFrame.add(node.getNodeName());
        for(Collector collector: node.getRecourceCollector()){
            mainFrame.add(collector.getItem());
            for(JCheckBox diceNumber: collector.getDiceNumbers()){
                mainFrame.add(diceNumber);
            }
        }
    }


    public void setupTurns(){

        JLabel diceLabel = new JLabel("Number of Turns");
        diceLabel.setBounds(LEFT_PAD, 700, 100, 40);

        diceNum = new JTextField("#");
        diceNum.setBounds(LEFT_PAD, 750, 100, 40);//x axis, y axis, width, height

        mainFrame.add(diceNum);
        mainFrame.add(diceLabel);
    }




    public void setupButton(){

        mainFrame.add(getButton());//adding button in JFrame
        for(Resource resource : getResources()){
            mainFrame.add(resource.getFrequencyText());//adding button in JFrame
            mainFrame.add(resource.getDiceNumberTotalText());
            mainFrame.add(resource.getResourceAmountTotalText());
        }

    }
}
