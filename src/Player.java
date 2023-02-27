package src;


/**
 * @author Trever Hartman
 * @author Ander Stanley-Camba
 * @since 2023-02-26
 * @version 1.0
 */


public class Player {

    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public void toss(Dice dice) {
        dice.roll();
        this.score += dice.view();

    }
}
