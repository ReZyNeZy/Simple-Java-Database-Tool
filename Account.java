import java.io.*;
import java.util.*;



public class Account 
{
    
    Scanner input = new Scanner(System.in);
    ArrayList<String> data = new ArrayList<>();
    String username;
    String name;

    public void CreateOrAccess()
        {
            System.out.println("1) Access existing DataBase");
            System.out.println("2) Create new Database");
            System.out.println("3) Log Out");
            String response = input.nextLine();

        if (response.equals("1"))
        {
            accessDB();
        }

        if (response.equals("2"))
        {
            createDB();
        }

        if (response.equals("3"));

    }//end CreateOrAccess

    public void accessDB()
    {

    }

    public void createDB()
    {
        System.out.println("Insert name for DataBase");
        String name = input.nextLine();
        name = name + ".dat";

        System.out.println(name);
        System.out.println(username);
    }

    public void loadDBs()
    {
        
    }


    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }



}//end Account
