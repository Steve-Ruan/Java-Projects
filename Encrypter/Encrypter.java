//********************************************************************
// Encrypter.java       Author: Steve Ruan
//
// Standalone class that contain methods to store user entered info and encryption process. 
//********************************************************************
public class Encrypter
{
  //declare class variables
  public String name;
  public String birth;
  public String streetAddress, city, state, zip;
  public String user;
  public String password;
  public String encryptedPassword;
  
  //---------------------------------------------------------
  public void Encrypter()
  {
    //set strings to empty strings
    name = "";
    birth = "";
    streetAddress = "";
    city = "";
    state = "";
    zip = "";
    user = "";
    password = "";
    encryptedPassword = "";
  }
  //---------------------------------------------------------
  //get and set name
  public void setName(String name)
  {
    name = name;
  }
  public String getName()
  {
    return name;
  }
  
  //---------------------------------------------------------
  //get and set Date of birth
  public void setdob(String birth)
  {
    birth=birth;
  }
  public String getdob()
  {
    return birth;
  }
 //---------------------------------------------------------
  //get and set address
  public void setStreetAddress(String streetAddress)
  {
    streetAddress = streetAddress;
  }
  public String getstreetAddress()
  {
    return streetAddress;
  }
  //---------------------------------------------------------
  //get and set city name
    public void setCity(String city)
  {
    city=city;
  }
  public String getcity()
  {
    return city;
  }
  //---------------------------------------------------------
  //get and set state
    public void setState(String state)
  {
    state=state;
  }
  public String getState()
  {
    return state;
  }
  //---------------------------------------------------------
  //get and set zip
    public void setZip(String zip)
  {
    zip=zip;
  }
  public String getZip()
  {
    return zip;
  }
  //---------------------------------------------------------
  //get and set user name

  public void setUsername(String user)
  {
    user = user;
  }
  public String getUsername()
  {
    return user;
  }
  //---------------------------------------------------------
  //get/set password
  
  public void setPassword(String password)
  {
    password = password;
  }
  public String getPassword()
  {
    return password;
  }
   //---------------------------------------------------------
  //toString
  //combines all user info into one string and returns it to the user. 
  public String toString(String name, String birth, String streetAddress, String city, String state, String user, String password)
  {
    String info = "Name: " + name + "\nBirth: " + birth + "\n Street Address: " + streetAddress +
      "\n City: " + city + "\nState: " + state + "\nZip: " + zip + "\nUsername: " + user +
      "\nPassword: " + password;
    return info;
  }
  //---------------------------------------------------------
  //encryption method
  public String encrypt(String password)
  {
    //encryption process
    String s1 = removeWhitespaceAndConvertToUpper(password);
    String s2 = substitute(s1);
    String s3 = swapHalfsForEncrypt(s2);
    String s4 = swapFirst2WithLast2(s3);
    String encryptedPassword = swapMiddleChars(s4); 
    //return the encrypted password
    return encryptedPassword;
    //return s4;
  
  }
  //---------------------------------------------------------
  //remove white space and convert the string to upper case.
   private String removeWhitespaceAndConvertToUpper(String p1)
  {
    //Removing leading and trailing whitespace
   p1 = p1.trim();
    //Convert characters to uppercase
    p1 = p1.toUpperCase();
    return p1;
  }
   //---------------------------------------------------------
   //substitue appropriate values
  private String substitute(String p2)
  {
    p2 = p2;
   //substitutions
    p2 = p2.replace('A', '@');
    p2 = p2.replace('E', '=');
    p2 = p2.replace('I', '!');
    p2 = p2.replace('J', '?');
    p2 = p2.replace('O', '*');
    p2 = p2.replace('P', '#');
    p2 = p2.replace('R', '&');
    p2 = p2.replace('S', '$');
    p2 = p2.replace('T', '+');
    p2 = p2.replace('V', '^');
    p2 = p2.replace('X', '%');
    p2 = p2.replace(' ', '_');
    //return the string
    return p2;
  }
  //---------------------------------------------------------
  //cut string in half and swap the two halves
  private String swapHalfsForEncrypt(String p3)
  {
    //split the string in half into the following Strings
    String firstHalf = "";
    String secondHalf = "";
    //determine the String's length
    int length = p3.length();
    //if its an even number
    if(length%2 == 0)
    {
      //create the substrings
      firstHalf = p3.substring(0, (length/2));
      secondHalf = p3.substring((length/2), (length));
      //swap and return
      String p4 = secondHalf + firstHalf;
      return p4;
    }
    //if odd
    else if(length%2 == 1)
    {
      //first half take one more character
      firstHalf = p3.substring(0, ((length/2)+1));
      secondHalf = p3.substring(((length/2)+1), length);
      //swap and return
      p3 = secondHalf + firstHalf;
      return p3;
    }
    return null;
  }
 //---------------------------------------------------------
  //swap the first two letters with the last two
  private String swapFirst2WithLast2(String p4)
  {
    //stores the first two char of original string
    String first2 = "";
    //stores the last two char of original string
    String last2 = "";
    //stores the characters not stores in the above two strings
    String middle = "";
    //determine the length of the original string
    int length = p4.length();
    //create the substrings
    first2 = p4.substring(0, 2);
    last2 = p4.substring(length-2, length);
    middle = p4.substring(2, length-2);
    //swap the last and first two.
    p4 = last2 + middle + first2;
    //return the string
    return p4;
  }
  //---------------------------------------------------------
  //swap middle characters of the string
  private String swapMiddleChars(String p5)
  {
    //split the string into parts
    String first2 = "";
    String second2 = "";
    String firstMid = "";
    String secondMid = "";
    String body1 = "";
    String body2 = "";
    //get the length
    int length = p5.length();
    //if string is even
    if(length%2 == 0)
    {
      //split into two strings
      first2 = p5.substring(0, (length/2));
      second2 = p5.substring((length/2), (length));
    }
    //if the string has an odd number of characters
    else if(length%2 == 1)
    {
      //split string with the first part being longer than the first
      first2 = p5.substring(0, ((length/2)+1));
      second2 = p5.substring((length/2), length);
    }
    //first half of original string
    int length1 = first2.length();
    //create a substring of the first half containing the middle characters
    firstMid = first2.substring(length1-2, length1);
    body1 = first2.substring(0, length1-2);
    //create a substring of the second half containing the middle characters
    int length2 = second2.length();
    secondMid = second2.substring(0, 2);
    body2 = second2.substring(2, length2);
    //add the parts together
    p5 = body1+secondMid+firstMid+body2;
    return p5;
}
}