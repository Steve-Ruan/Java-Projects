//********************************************************************
//  EncrypterDrive.java       Author: Steve Ruan
//
//  Driver class, runs the methods used in the standalone to get user info. 
//********************************************************************
import javax.swing.*;
public class EncrypterDriver
{
  public static void main(String[]args)
  {
    //create class variables
    int repeat = 0;
    Encrypter thing = new Encrypter();
    String name = "";
    String birth = "";
    String address = "";
    String username = "";
    String password = "";
    String encryptedPassword = "";
    //do while the yes option is clicked.
    do
    { 
      //create the jframe
      JFrame steveWorld = new JFrame("Steve's world");
      //Ask the user for name
      String nameInput = JOptionPane.showInputDialog ("Enter your name: ");
      thing.setName(nameInput);
      //Ask the user for dob
      String dobInput = JOptionPane.showInputDialog("Enter your date of birth. (mm-dd-yy) ");
      thing.setdob(dobInput);
      //Ask the user for their address
      String streetAddressInput = JOptionPane.showInputDialog ("Enter your street address: ");
      thing.setStreetAddress(streetAddressInput);
      //ask user for city
      String cityInput = JOptionPane.showInputDialog("Enter your city ");
      thing.setCity(cityInput);
      //ask user for state
      String stateInput = JOptionPane.showInputDialog("Enter your state ");
      thing.setState(stateInput);
      //ask user for zipcode
      String zipInput = JOptionPane.showInputDialog("Enter your zip code ");
      thing.setZip(zipInput);
      //Ask the user for their username
      String usernameInput = JOptionPane.showInputDialog ("Username: ");
      thing.setUsername(usernameInput);
      //Ask the user for their password   
      String inputPassword = JOptionPane.showInputDialog (steveWorld,"Enter your password: ");
      //set the password to the unencryptedPassword
      thing.setPassword(inputPassword);
      //combine all user info into one string called info
      String info = thing.toString(nameInput, dobInput, streetAddressInput, cityInput, stateInput, usernameInput, inputPassword);
      //show the info that the user has entered.
      JOptionPane.showMessageDialog(steveWorld, info);
      //encrypt the password
      String secret = thing.encrypt(inputPassword);
      //display encrypted password
      JOptionPane.showMessageDialog(steveWorld, "Your encrypted password is:" + " "+secret);
      //user controlled exit: ask user if he/she wants to continue.
      repeat = JOptionPane.showConfirmDialog (steveWorld, "Create another account?");
    }
    
    while(repeat==JOptionPane.YES_OPTION);
  }
}