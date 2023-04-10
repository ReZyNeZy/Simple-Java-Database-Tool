import java.io.*;
import java.util.*;

public class Admin
{
    String username;
    String password;
    Scanner input = new Scanner(System.in);
    boolean keepGoing;
    ArrayList<User> creds = new ArrayList<>();


    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        username = "admin";
        return username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        password = "password";
        return password;
    }

    public void Menu()
    {
        System.out.println("SPECIAL ADMIN MENU");
        System.out.println("______________________");
        System.out.println("1) View All users");
        System.out.println("2) Delete User");
        System.out.println("3) View  User Data");
        System.out.println("4) Log Out");

        String response = input.nextLine();


        if (response.equals("1"))
        {
            viewUser();
        }

        if (response.equals("2"))
        {
            deleteUser();
        }

        if (response.equals("3"))
        {
            viewData();
        }
        
        if (response.equals("4"))
        {
            
        }
        else
        {
            System.out.println("Input Invalid. Try Again");
            System.out.println("");
        }
    }

    public void viewUser()
    {
        loadAccounts();

        for (int i = 0; i< creds.size(); i++)
        {
            System.out.println("Current Users In System");
            System.out.println(i + ")" + creds.get(i).getUsername);
        }
    }

    public void deleteUser()
    {

    }

    public void viewData()
    {

    }

    public void loadAccounts()
{
    try (FileInputStream file = new FileInputStream("users.dat");
         ObjectInputStream accounts = new ObjectInputStream(file);)
         {
            creds = (ArrayList<User>)accounts.readObject();

            accounts.close();
         }
    catch(Exception e)
    {
        System.out.println(e.getMessage());
    }
}
}