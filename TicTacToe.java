/**********************************************************************
 * @file TicTacToe.java
 * @brief I was having a trouble figuring out how to avoid using a lot of if statements, but from a discussion with Maahla and Dr. Pauca,
 *          I reached an understanding of how Math.floor can be used. I had never used this before, but it makes sense now.
 * @author Alantis Green
 * @date: 10/05/2022
 * @acknowledgement: Maahla Fofak and I bounced ideas off of each other in class.
 ***********************************************************************/
import java.awt.*;

public class TicTacToe {
    public static void main(String[] args) {

        int moves = 0;
        int x, y;
        // currentPlayer should be set to 1 or 2
        int currentPlayer = 1;

        StdDraw.setCanvasSize(500, (int)(500*1.3));
        StdDraw.setXscale(-0.1, 3.1);
        StdDraw.setYscale(-0.1, 4.1);

        StdDraw.setPenRadius(0.005);

        drawBoard();

        // Announce that it's player 1's turn
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text(1.5, 3.75, "Player " + currentPlayer + ": your turn");

        double mx,  my;
        while(moves <9){
            if(StdDraw.isMousePressed() == true){
                mx = StdDraw.mouseX();
                my = StdDraw.mouseY();
                if(mx>=0 && mx<=3 && my>=0 && my<=3){
                    mx = Math.floor(mx);
                    my = Math.floor(my);
                    if(currentPlayer == 1){
                        StdDraw.setPenColor(Color.WHITE);
                        StdDraw.filledRectangle(1.5, 3.75, .5,.5);
                        StdDraw.setPenColor(Color.BLACK);
                        StdDraw.text(1.5, 3.75, "Player " + 2 + ": your turn");
                        StdDraw.setPenColor(Color.blue);
                        StdDraw.circle(mx + .5, my +.5, .45);
                        currentPlayer = 2;
                    }
                    else{
                        StdDraw.setPenColor(Color.WHITE);
                        StdDraw.filledRectangle(1.5, 3.75, .5,.5);
                        StdDraw.setPenColor(Color.BLACK);
                        StdDraw.text(1.5, 3.75, "Player " + 1 + ": your turn");
                        StdDraw.setPenColor(Color.red);
                        StdDraw.line(mx, my, mx+1, my+1);
                        StdDraw.line(mx, my+1, mx+1, my);
                        currentPlayer = 1;
                    }
                    moves++;
                    StdDraw.pause(300);
                }
            }


        }

    }

    /*
     * draws a 3 x 3 tic tac toe board
     */
    private static void drawBoard() {
        StdDraw.setPenColor(Color.BLACK);
        for (int i = 0; i < 4; i++) {
            StdDraw.line(0, i, 3, i);
            StdDraw.line(i, 0, i, 3);
        }
    }


}
