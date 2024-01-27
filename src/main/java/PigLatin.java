import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PigLatin {
    
    public void tester() {
        // String[] lines = loadStrings("words.txt");
        String[] lines = new String[8]; 
        try{
            File myFile = new File("words.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[counter] = data;
                counter++;
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
	    System.out.println("there are " + lines.length + " lines");
	    for (int i = 0 ; i < lines.length; i++) {
	        System.out.println(pigLatin(lines[i]));
	    }
    }
   public int findFirstVowel(String sWord) {
         for(int i=0;i<sWord.length();i++)
  {
    if(sWord.substring(i,i+1).equals("a")||sWord.substring(i,i+1).equals("e")||sWord.substring(i,i+1).equals("i")||sWord.substring(i,i+1).equals("u")||sWord.substring(i,i+1).equals("o"))
    {
      return i;
    }
  }
  return -1;
        
    }
public int findqu(String sWord)
  {
  if(sWord.substring(0,2).equals("qu"))
  {
  return 1;
  }
  return 2;
  }
    public String pigLatin(String sWord) {
      boolean b = true;
        //precondition: sWord is a valid String of length greater than 0
        //postcondition: returns the pig latin equivalent of sWord
        // more code should go here
        if(findqu(sWord)==1)
      {
    return (sWord.substring(2,sWord.length())+"quay");
      }
      if(findFirstVowel(sWord) == -1) {
        return sWord + "ay";
      }
      else if(findFirstVowel(sWord)==0)
      {
    return sWord+"away";
      }
      int l=0;
      while(b==true)
      {
        if(sWord.substring(l,l+1).equals("a")||sWord.substring(l,l+1).equals("e")||sWord.substring(l,l+1).equals("i")||sWord.substring(l,l+1).equals("u")||sWord.substring(l,l+1).equals("o"))
      {
        b=false;
      }
      else
      {
      l=l+1;
      
      }
      }
      
    return(sWord.substring(l,sWord.length())+sWord.substring(0,l)+"ay");
      }
    
    
