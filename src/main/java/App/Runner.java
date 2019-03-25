package App;

import javax.swing.*;
import java.util.ArrayList;

public class Runner {


    private static JFrame mainFrame;
    private static Calculator calculator;

    public static void main(String[] args) {

        mainFrame = new JFrame();//creating instance of JFrame

        calculator = new Calculator("Roll", mainFrame);

        mainFrame.setSize(1600, 900);
        mainFrame.setLayout(null);//using no layout managers
        mainFrame.setVisible(true);//making the frame visible
    }
}
