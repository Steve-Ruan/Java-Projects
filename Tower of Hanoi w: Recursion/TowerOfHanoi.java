import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
//TowerOfHanoi
//Steve Ruan
//Creates the solve algorithim, and a GUI to display solution
public class TowerOfHanoi extends JPanel
{
  //declares the necessary variable that will be used
  private int count, repeat;
  private String move, info;
  private ArrayList<String> moveList;
  private JLabel blocks, list, total;
  private JTextField input;
  private JComboBox showList;
  public TowerOfHanoi()
  {
    //instantiate variables
    moveList = new ArrayList<String>();
    blocks = new JLabel ("How many discs are in the puzzle?");
    total = new JLabel("Minimum number of moves: ");
    input = new JTextField(5);
    input.addActionListener(new Listener());
    info="";
    repeat = 0;
    count = 0;
    move = "";
    setPreferredSize (new Dimension(600, 100));  
    //adds the labels to the Jpanel
    add(blocks);
    add(input);
    add(total); 
  }
  //public void solve
  //Steve Ruan
  //solve algorithim to show how to solve a tower of hanoi puzzle 
  //parameters: discs: number of discs, pole1: pole1, pole3: third pole
  public void solve(int discs, int pole1, int pole3) 
  {
    //bas case, if there are no more discs to move
    if (discs== 0)
    {
      //return
      return; 
    }
    //else, 
    //create the middle pole
    int pole2 = 6-pole1-pole3;
    //call the method recusively
    solve(discs-1, pole1, pole2);
    //store the move
    info = ("Move disc" + discs + " from pole" + pole1 + " to pole" + pole3);
    //add the move to the moveList
    moveList.add(info);
    //call the method recusively
    solve(discs-1, pole2, pole3);
    count++;
  }
  //private class Listener
  //Steve Ruan
  //interacts with the GUI; asks for user input, then shows the amount of minimum moves
  //Finally shows the solution through a scroll bar. 
  private class Listener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      //if the repeat greater than 0
      if(repeat > 0)
      {
        //remove the prior comboBox
        remove(showList);
      }
      //gets the input that the user has given and converts it into an integer value
      String text = input.getText();
      int stuff = Integer.parseInt(text);
      //creates the tab.
      move = "Scroll for Solution";
      moveList.add(move);
      //calls the solve method to solve the tower
      solve(stuff, 1, 3);
      //shows the number of moves
      total.setText("Minimum number of moves: " + count);
      showList = new JComboBox(moveList.toArray());
      //adds the comboBox into the panel
      add(showList);
      //resets the count and the moveList
      count = 0;
      repeat++;
      moveList = new ArrayList<String>();
    }
  }
  
}