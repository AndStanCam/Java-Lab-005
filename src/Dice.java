package src;
import java.util.Random;

/**
 * @author Trever Hartman
 * @author Ander Stanley-Camba
 * @since 2023-02-26
 * @version 1.0
 */


public class Dice {
    private int sideFacingUp;
    private int sides;
    private Random randomgenerator;

    public Dice(int sides) {
        this.sides = sides;
        this.randomgenerator = new Random();
    }

    public void roll() {
        this.sideFacingUp = this.randomgenerator.nextInt(this.sides) + 1;
    }

    public int view() {
        return this.sideFacingUp;
    }

}
