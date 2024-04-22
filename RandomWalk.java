 @file RandomWalk.java
 * @brief I struggled with the order of the code regarding where to put my own code in relation to the provided codes. I got help with this in
 *           office hours, but I still think I struggle with determining the right order of the code.
 * @author Alantis Green
 * @date: 10/05/2022
 * @acknowledgement: Maahla Fofak and I bounced ideas off of each other in class and I attended office hours and collaborated with other students
 *                 there.
 ***********************************************************************/
import java.awt.*;
import java.util.Scanner;
import java.util.Random;

public class RandomWalk {
   public static void main(String[] args) {
      Random rand = new Random();
      Scanner kb = new Scanner(System.in);
      int n;                 // Grid size [0 n] x [0 n]
      System.out.print("Desired grid size? ");
      n = kb.nextInt();
      // Set up the size of the canvas to be 600 pixels in width and
      // adjust the height so that the grid appears square and not
      // rectangular.
      StdDraw.setCanvasSize(500, 520);
      StdDraw.setXscale(-1, n+1); // x goes from -1 to n+1
      double maxY = n + (.1 * n)+1;
      StdDraw.setYscale(-1, maxY); // y goes from -1 to n+10

      drawGrid(n);    // Draw the grid at the bottom of the canvas

      // Draw the robots' paths with a slightly thicker pen
      StdDraw.setPenRadius(0.007);

      int r1_currX = n/2, r1_currY= n/2;
      int r1_prevX, r1_prevY;
      int r1_steps = 0;
      int r1_moveX;
      int r1_moveY;
      r1_prevX = n/2;
      r1_prevY = n/2;

      int r2_currX = n/2, r2_currY= n/2;
      int r2_prevX, r2_prevY;
      int r2_steps = 0;
      int r2_moveX;
      int r2_moveY;
      r2_prevX = n/2;
      r2_prevY = n/2;

      int r3_currX = n/2, r3_currY= n/2;
      int r3_prevX, r3_prevY;
      int r3_steps = 0;
      int r3_moveX;
      int r3_moveY;
      r3_prevX = n/2;
      r3_prevY = n/2;
      //the while loop below is true as long as one of the robots can move. The loop is false if all three robots cannot move
      while((((r1_currX<=n)&&(r1_currX>=0)&&(r1_currY<=n)&&(r1_currY>=0)))||(((r2_currX<=n)&&(r2_currX>=0)&&(r2_currY<=n)&&(r2_currY>=0)))||(((r3_currX<=n)&&(r3_currX>=0)&&(r3_currY<=n)&&(r3_currY>=0)))){
         //Each if statement below decides whether or not the 1+ robots moving is robot 1, 2, or 3
         if((((r1_currX<=n)&&(r1_currX>=0)&&(r1_currY<=n)&&(r1_currY>=0)))) {
            r1_moveX = rand.nextInt(3) - 1;
            if (r1_moveX == 0) {
               r1_moveY = rand.nextInt(2);
               if (r1_moveY == 0) {
                  r1_moveY = -1;
               }
            } else {
               r1_moveY = 0;
            }
            r1_prevX = r1_currX;
            r1_prevY = r1_currY;
            r1_currX = r1_prevX + r1_moveX;
            r1_currY = r1_prevY + r1_moveY;
            drawStep(r1_prevX, r1_prevY, r1_currX, r1_currY, Color.black);
            r1_steps++;
         }





         if((((r2_currX<=n)&&(r2_currX>=0)&&(r2_currY<=n)&&(r2_currY>=0)))) {
            r2_moveX = rand.nextInt(3) - 1;
            if (r2_moveX == 0) {
               r2_moveY = rand.nextInt(2);
               if (r2_moveY == 0) {
                  r2_moveY = -1;
               }
            } else {
               r2_moveY = 0;
            }
            r2_prevX = r2_currX;
            r2_prevY = r2_currY;
            r2_currX = r2_prevX + r2_moveX;
            r2_currY = r2_prevY + r2_moveY;
            drawStep(r2_prevX, r2_prevY, r2_currX, r2_currY, Color.blue);
            r2_steps++;
         }



         if((((r3_currX<=n)&&(r3_currX>=0)&&(r3_currY<=n)&&(r3_currY>=0)))) {
            r3_moveX = rand.nextInt(3) - 1;
            if (r3_moveX == 0) {
               r3_moveY = rand.nextInt(2);
               if (r3_moveY == 0) {
                  r3_moveY = -1;
               }
            } else {
               r3_moveY = 0;
            }
            r3_prevX = r3_currX;
            r3_prevY = r3_currY;
            r3_currX = r3_prevX + r3_moveX;
            r3_currY = r3_prevY + r3_moveY;
            drawStep(r3_prevX, r3_prevY, r3_currX, r3_currY, Color.green);
            r3_steps++;
         }
      }









      // Print final results
      Color r1_color = Color.black;
      Color r2_color = Color.blue;
      Color r3_color = Color.green;
      StdDraw.setPenColor(r1_color);
      StdDraw.text(n/2, maxY*.99, "Robot 1: steps = " + r1_steps);
      StdDraw.setPenColor(r2_color);
      StdDraw.text(n/2, maxY*.965, "Robot 2: steps = "+r2_steps);
      StdDraw.setPenColor(r3_color);
      StdDraw.text(n/2, maxY*.94, "Robot 3: steps = "+r3_steps);
      StdDraw.setPenColor(Color.black);
      StdDraw.text(n/2, maxY*.915, "average: " +
            String.format("%.2f", (r1_steps + r2_steps + r3_steps) / 3.0));

   }

   /*
    * drawStep(x0, y0, x1, y1, c) draws a line between points (x0, y0)
    * and (x1, y1) using color c. Note that the actual locations of
    * points (x0, y0) and (x1, y1) in the canvas depend on the X and
    * Y scales previously set up.
    */
   private static void drawStep(int prevX, int prevY, int currX, int currY, Color color) {
      StdDraw.setPenColor(color);
      StdDraw.line(prevX, prevY, currX, currY);
   }

   /**
    * Draw a grid using red lines and methods in the StdDraw class.
    * @param n size of the grid
    */
   private static void drawGrid(int n) {
      StdDraw.setPenColor(Color.red);
      for (int i = 0; i <= n; i++) {
         StdDraw.line(i, 0, i, n);
         StdDraw.line(0, i, n, i);
      }
   }
}
