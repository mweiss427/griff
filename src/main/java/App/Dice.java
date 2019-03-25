package App;

import java.lang.reflect.Array;

public class Dice {
    Die die1;
    Die die2;

    public Dice(){
        die1 = new Die();
        die2 = new Die();
    }


    public int[] roll(int times) {
        int[] results = new int[times];
        for(int i = 0; i < times; i++){
            results[i] = die1.roll() + die2.roll();
        }

        return results;
    }
}
