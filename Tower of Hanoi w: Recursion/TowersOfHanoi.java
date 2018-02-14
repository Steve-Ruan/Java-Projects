import javax.swing.JFrame;
//public class TowersOfHanoi
//Steve Ruan
//The driver class which runs the gui and solves the program
public class TowersOfHanoi
{
  public static void main(String [] args)
  {
    //creates a new frame
    JFrame frame = new JFrame("Hanoi Solver");
    //sets the default close to X
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //creates a new TowerOfHanoi object named hanoi
    TowerOfHanoi hanoi = new TowerOfHanoi();
    //gets the content and displays it
    frame.getContentPane().add(hanoi);
    frame.pack();
    frame.setVisible(true);
  }
}