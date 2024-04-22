/**********************************************************************
 * @file BlackJack.java
 * @brief I initially got caught up in using methods without planning ahead for the necessary loops. The biggest thing I had to tackle was
 *        rereading the instructions to get a grasp on the rules of the game in terms of what is a hit VS a stand, how player or dealer
 *        wins, and what constitutes a tie. I was able to get virtual help from my boyfriend who understands real life black jack.
 * @author Alantis Green
 * @date: 10/05/2022
 * @acknowledgement: I received help comments from Dr. Pauca through a GitHub
 ***********************************************************************/
import java.util.Scanner;
import java.util.Random;
public class BlackJack {

    public static void main(String[] args) {
        Scanner scnr = new Scanner (System.in);
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Welcome To the Blackjack Table");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        String input;
        int playerScore=0, dealerScore=0, playerRounds=0, dealerRounds=0, ties=0;
        input = "yes";
        while(input.charAt(0)== 'y'|| input.charAt(0)=='Y') {
            playerScore = PlayerTurn();
            dealerScore = DealerTurn();
            if (playerScore <= 21 && dealerScore <= 21) {           //Rounds when both are under 21
                if (playerScore > dealerScore) {                        //Player has better score
                    playerRounds = playerRounds + 1;
                } else if (playerScore == dealerScore) {                //Both have same score
                    ties = ties + 1;
                } else {                                               //Dealer has better score
                    dealerRounds = dealerRounds + 1;
                }
            } else if (playerScore > 21 && dealerScore > 21) {         //Rounds when both player and dealer bust
                ties = ties + 1;
            } else if (playerScore <= 21 && dealerScore > 21) {          //Rounds when player does not bust but dealer does
                playerRounds = playerRounds + 1;
            }
            else{                                                       //Rounds when player busts but dealer does not
                dealerRounds = dealerRounds +1;
            }
            System.out.print("Play again? [y/n]");
            input = scnr.next();
            while(input.charAt(0) != 'y'&& input.charAt(0) != 'Y'&&input.charAt(0) != 'n'&&input.charAt(0)!='N'){
                System.out.print("Play again? [y/n]");
                input = scnr.next();
            }

        }
        System.out.println("GAME STATISTICS -----------");
        System.out.println("Player won " + playerRounds + " times");
        System.out.println("Dealer won " + dealerRounds + " times");
        System.out.println(ties + " ties");
    }

    public static int userChoice(char PlayerMove) {
        int choice;
        if (PlayerMove == 'h'||PlayerMove == 'H') {
            choice = 1;
        } else if (PlayerMove == 's'||PlayerMove == 'S') {
            choice = 0;
        } else {
            choice = 2;
        }

        return choice;
    }

    public static int PlayerTurn() {
        Random rand = new Random();
        Scanner scnr = new Scanner(System.in);
        System.out.println("Player's Turn +-+-+-+-+-+-+-+-+-+-+-+-");
        int total = 0;
        int first = rand.nextInt(11) + 1;
        total = total + first;
        System.out.println("Card: " + first + " Current Total: " + total);
        int second = rand.nextInt(11) + 1;
        total = total + second;
        System.out.println("Card: " + second + " Current Total: " + total);
        while(total<=21) {
            char decision;
            System.out.print("(h)it or (s)tand?: ");
            String input = scnr.next();
            decision = input.charAt(0);
            int choice = userChoice(decision);
            if (choice == 2) {
                System.out.print("(h)it or (s)tand?: ");
                input = scnr.next();
                decision = input.charAt(0);
                choice = userChoice(decision);
            } else if (choice == 0) {
                break;
            } else if (choice == 1) {
                    int next = rand.nextInt(11) + 1;
                    total = total + next;
                    System.out.println("Card: " + next + " Current Total: " + total);

            }

        }
        System.out.println("Player's total is: " + total);
        return total;
    }

    public static int DealerTurn(){
        System.out.println("Dealer's Turn +-+-+-+-+-+-+-+-+-+-+-+-");
        Random rand = new Random();
        Scanner scnr = new Scanner(System.in);
        int total = 0;
        while(total<17) {
            int card = rand.nextInt(11) + 1;
            total = total + card;
            System.out.println("Card: " + card + " Current Total: " + total);

        }
        System.out.println("Dealer's total is: "+ total);
        return total;
    }
}
