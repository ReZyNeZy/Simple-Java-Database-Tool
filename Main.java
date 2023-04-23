import java.io.*;

import java.io.File;

import java.util.*;

public class Main 
{
    Scanner input = new Scanner(System.in);
    boolean keepGoing;
    ArrayList<Account> accounts  = new ArrayList<Account>();
    Admin a = new Admin();
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
    loadAccounts();
    System.out.println("DataBase Builder");
    keepGoing = true;
    
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

    keepGoing = true;

    while (keepGoing)
    {
        System.out.println("");
        System.out.println("Insert Account Username or press ] to go Back");
        String actCred = input.nextLine();

        if (actCred.equals(a.getUsername()))
        {
            System.out.println("Please Enter Admin Password");
            actCred = input.nextLine();

            if(actCred.equals(a.getPassword()))
            {
                a.aMenu();
            }

            else 
            {
                System.out.println("Password Incorrect");
            }
        }// end admin log

        for (int i = 0; i < accounts.size(); i++)
        {
            if (accounts.get(i).getUsername().equals(actCred))
            {
                System.out.println("Please input Password");
                actCred = input.nextLine();

                if (accounts.get(i).getPassword().equals(actCred))
                {

                    try
                    {
                        File dbStorage = new File(accounts.get(i).getUsername());

                        if (dbStorage.createNewFile())
                        {
                            System.out.println("File " + accounts.get(i).getUsername() + "Created");
                            accounts.get(i).CreateOrAccess();
                        }
                        else
                        {
                            accounts.get(i).CreateOrAccess();
                        }
                    }

                    catch (IOException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    ac.setUsername(accounts.get(i).getUsername());
                }

                else
                {
                    System.out.println("Password Incorrect");
                }
            }

        }// end user log

        if (actCred.equals("]"))
        {
            System.out.println("");
            keepGoing = false;
            Menu();
        }

    }// end while

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
            
            accounts.add(new Account(username, password));

            try 
            
                {
                    FileOutputStream out = new FileOutputStream("users.dat");
                    ObjectOutputStream outFile = new ObjectOutputStream(out);
                 
                    outFile.writeObject(accounts);
                    
                    outFile.close();
                    out.close();
                 }
            catch (IOException e)
                 {
                    System.out.println(e.getMessage());
                 }
                 
        }

        else
        {
            System.out.println("Passwords do not match. Try Again");
        }
        Menu();
    }
}//end Create Account


public void loadAccounts()
{
    try  
        
        {
        FileInputStream file = new FileInputStream("users.dat");
         ObjectInputStream users = new ObjectInputStream(file);
         
            accounts = (ArrayList<Account>)users.readObject();

            users.close();
         }
    catch(Exception e)
    {
        System.out.println(e.getMessage());
    }
}


}//end Main

