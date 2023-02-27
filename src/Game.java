package src;

import java.util.Objects;
import java.util.Scanner;
import java.util.random.RandomGenerator;


/**
 * @author Trever Hartman
 * @author Ander Stanley-Camba
 * @since 2023-02-26
 * @version 1.0
 */


public class Game {
    Player p1;
    Player p2;
    Dice die;

    public Game(Player p1, Player p2, Dice die) {
        this.p1 = p1;
        this.p2 = p2;
        this.die = die;
    }

    public void play() {
        Player current = this.p1;
        takeTurn(current);
        current = nextPlayer(current);
        takeTurn(current);
        System.out.println(announceWinner());
    }

    public Player nextPlayer(Player current) {
        Player newCurrent;
        if (current == this.p1) {
            newCurrent = this.p2;
            return newCurrent;
        }
        newCurrent = this.p1;
        return newCurrent;
    }

    public void takeTurn(Player player) {
        player.toss(this.die);
    }

    public String announceWinner() {
        String announcement = p1.getName() + " : " + p1.getScore() + "\n" + p2.getName() + " : " + p2.getScore() + "\nThe winner is...\n";
        if (this.p1.getScore() > this.p2.getScore()) {
            announcement += p1.getName();
            return announcement;
        }
        else if (this.p1.getScore() == this.p2.getScore()) {
            announcement += "Wait a minute... *wipes glasses* it's a tie!";
            return announcement;
        }
        announcement += p2.getName();
        return announcement;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\nWelcome to the dice game!\n\nThe rules are simple: Each player rolls a dice, whoever has the highest score, wins!\n\nPlease enter a name for Player 1: ");
        String name = sc.nextLine();
        Player player1 = new Player(name);
        System.out.println("\nPlease enter a name for Player 2: ");
        name = sc.nextLine();
        Player player2 = new Player(name);
        if (Objects.equals(player1.getName(), player2.getName())) {
            System.err.println("What?? You can't play against yourself silly!\nLet's try that again...");
            main(null);
        }
        System.out.println("\nIf you would like to change these names, please enter 'rename'\nIf you are ready to play, just press enter");
        String choice = sc.nextLine();
        if (Objects.equals(choice, "rename")) {
            System.err.println("restarting...\n\n");
            main(null);
        }
        System.out.println("Alright, now enter a number for how many sides you would like the dice to have: ");

        try {
            int sides = sc.nextInt();
            Dice dice = new Dice(sides);
            System.out.println("Perfect, game start!\n\n" + player1.getName() + " skillfully throws the dice on the table...\n" + player2.getName() + " throws their dice just as intently...\n");
            Game game = new Game(player1, player2, dice);
            game.play();
            System.out.println("\n\nAnd that's all folks! Have a good night!");
            System.err.println("\n If you would like to do a new game, enter 'new game'");
            sc.nextLine();
            choice = sc.nextLine();
            if (Objects.equals(choice, "new game")) {
                main(null);

            }
            System.err.println("now exiting...");
            return;
        }
        catch (Exception e) {
            System.err.println("uh oh, you did not type a number (or you did a ridiculously large number)!\n\nNow you get to start from the beginning :)\n\n");
            main(null);
        }



    }
}
