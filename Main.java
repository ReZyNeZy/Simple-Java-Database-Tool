import java.io.*;
import java.util.*;

public class Main 
{
    Scanner input = new Scanner(System.in);
    boolean keepGoing = true;
    ArrayList<User> creds = new ArrayList<User>();
    Admin a = new Admin();
    User u = new User();
    Account ac = new Account();


public static void main(String[] args)
{
    new Main();
}

public Main()
{
    Menu();
}

public void Menu()
{
    System.out.println("DataBase Builder");
    
    while (keepGoing)
    {
        System.out.println("________________");
        System.out.println("1) Log In");
        System.out.println("2) Create Account");
        System.out.println("________________");
    
        String loc = input.nextLine();

        if (loc.equals("1"))
        {
            keepGoing = false;
            logMenu();
        }

        if (loc.equals("2"))
        {
            keepGoing = false;
            createAccount();
        }

        else
        {
            System.out.println("Invalid Input. Try Again");
        }
    }
}// end Menu

public void logMenu()
{
    loadAccounts();
    System.out.println("");
    System.out.println("Insert Account Username");
    String actCred = input.nextLine();

    while (keepGoing)
    {

        if (actCred.equals(a.getUsername()))
        {
            System.out.println("Please Enter Admin Password");
            actCred = input.nextLine();

            if(actCred.equals(a.getPassword()))
            {
                a.Menu();
            }
        }

        for (int i = 0; i < creds.size(); i++)
        {
            if (creds.get(i).getUsername().equals(actCred))
            {
                System.out.println("Please input Password");
                actCred = input.nextLine();

                if (creds.get(i).getPassword().equals(actCred))
                {
                    ac.CreateOrAccess();
                }
            }
        }
    }
}//end logMenu

public void createAccount()
{
    System.out.println("Insert new Account username");
    String username = input.nextLine();

    keepGoing = true;
    while (keepGoing)
    {
        System.out.println("Insert New Account Password");
        String password = input.nextLine();

        System.out.println("Please Confirm Password");
        String confirm = input.nextLine();

        if (password.equals(confirm))
        {
            keepGoing = false;

            u.setUsername(username);
            u.setPassword(password);
            creds.add(u);

            try (FileOutputStream out = new FileOutputStream("users.dat");
                 ObjectOutputStream outFile = new ObjectOutputStream(out);)
                 {
                    outFile.writeObject(creds);
                 }
            catch (IOException e)
                 {
                    System.out.println("e.getMessage");
                 }

        }

        else
        {
            System.out.println("Passwords do not match. Try Again");
        }
    }
}//end Create Account


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

}//end Main

