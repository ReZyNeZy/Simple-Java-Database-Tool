import java.io.*;
import java.util.*;



public class Account 
{
    
    Scanner input = new Scanner(System.in);
    ArrayList<String> data = new ArrayList<>();

    public void CreateOrAccess()
        {
            System.out.println("1) Access existing DataBase");
            System.out.println("2) Create new Database");
            String response = input.nextLine();

        if (response.equals("1"))
        {
            accessDB();
        }

        if (response.equals("2"))
        {
            createDB();
        }

    }//end CreateOrAccess

    public void accessDB()
    {

    }

    public void createDB()
    {

    }

}//end Account
