import java.io.*;
import java.util.*;

public class Admin extends Account
{
    String username;
    String password;
    Scanner input = new Scanner(System.in);
    boolean keepGoing;
    ArrayList<User> accounts = new ArrayList<User>();


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

    public void aMenu()
    {
        loadAccounts();

            System.out.println("");
            System.out.println("SPECIAL ADMIN MENU");
            System.out.println("______________________");
            System.out.println("1) View All users");
            System.out.println("2) Delete User");
            System.out.println("3) View User Data. Delete User Data");
            System.out.println("4) Log Out");
            System.out.println("______________________");
            System.out.println("");

            String response = input.nextLine();


            if (response.equals("1"))
            {
                System.out.println("Current Users in System");
                System.out.println("");
                viewUser();
            }

            if (response.equals("2"))
            {
                deleteUser();
            }

            if(response.equals("3"))
            {
                System.out.println("Select User to Access. Or press Q to quit");
                System.out.println("");
                viewFiles();
            }
        
            if (response.equals("4"))
            {
                System.out.println("Logout Successful");
                keepGoing = false;
            }
            else
            {
                System.out.println("");
                aMenu();
            }
        
    }

    public void viewUser()
    {

        for (int i = 0; i< accounts.size(); i++)
        {
            System.out.println(i + ") " + "Username: " + accounts.get(i).getUsername());
            System.out.println("   Password: " + accounts.get(i).getPassword());
            System.out.println("");
        }
    }

    public void deleteUser()
    {
        System.out.println("Select User to Remove. or type Q to quit");
        System.out.println("");
        for (int i = 0; i < accounts.size(); i++)
        {
            System.out.println(i + ") Username: " + accounts.get(i).getUsername());
        }

        String response = input.nextLine();

        response = response.toUpperCase();

        if (response.equals("Q"))
        {
            System.out.println("Returning to Menu");
        }


        else
        {

            System.out.println("Type 1 to confirm. Type any other key to return to menu");

            String confirm = input.nextLine();

            if (confirm.equals("1"))
            {
                int remove = Integer.parseInt(response);
                accounts.remove(remove);

                try
                    {
                        FileOutputStream out = new FileOutputStream("users.dat");
                        ObjectOutputStream outFile = new ObjectOutputStream(out);

                        outFile.writeObject(accounts);
                    
                        outFile.close();
                        out.close();
                    }

                catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
            }
        
            else
            {
                System.out.println("Returning to Menu");
            }

        }
    }// end delete

    public void viewFiles()
    {
        viewUser();

        String reply = input.nextLine();
        reply = reply.toUpperCase();

        if (reply.equals("Q"))
        {
            System.out.println("Returning to Menu");
        }//end quit

        else
        {
            try
            {
                int select = Integer.parseInt(reply);

               String user = accounts.get(select).getUsername();

               System.out.println("All data Belonging to " + user);
               

               accounts.get(select).AdminCheck();
            }

            catch(Exception e)
            {
                System.out.println("Something Went Wrong");
            }
        }


    }// ends view/delete



    public void loadAccounts()
    {
    try (FileInputStream file = new FileInputStream("users.dat");
         ObjectInputStream inFile = new ObjectInputStream(file);)
         {
            accounts = (ArrayList<User>)inFile.readObject();

            inFile.close();
            file.close();
         }
    catch(Exception e)
    {
        System.out.println(e.getMessage());
    }
    }// end load

}// end class



