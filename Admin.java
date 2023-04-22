import java.io.*;
import java.util.*;

public class Admin
{
    String username;
    String password;
    Scanner input = new Scanner(System.in);
    boolean keepGoing;
    ArrayList<User> creds = new ArrayList<>();
    ArrayList<Files> databases = new ArrayList<>();
    ArrayList<Entry> entries = new ArrayList<>();


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
            System.out.println("4) Log Out");
            System.out.println("______________________");
            System.out.println("");

            String response = input.nextLine();


            if (response.equals("1"))
            {
                viewUser();
            }

            if (response.equals("2"))
            {
                deleteUser();
            }

            if(response.equals("3"))
            {
                //viewFiles();
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

        System.out.println("Current Users In System");
        System.out.println("");

        for (int i = 0; i< creds.size(); i++)
        {
            int num = i + 1;
            System.out.println(num + ") " + "Username: " + creds.get(i).getUsername() + " " + "Password: " + creds.get(i).getPassword());
            System.out.println("");
        }
    }

    public void deleteUser()
    {
        System.out.println("Select User to Remove. or type Q to quit");
        System.out.println("");
        for (int i = 0; i < creds.size(); i++)
        {
            System.out.println(i + ") Username: " + creds.get(i).getUsername());
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
                creds.remove(remove);

                try
                    {
                        FileOutputStream out = new FileOutputStream("users.dat");
                        ObjectOutputStream outFile = new ObjectOutputStream(out);

                        outFile.writeObject(creds);
                    
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
        System.out.println("Select User to View Files from. Or Press Q to Return to Menu");

        for (int i = 0; i < creds.size(); i++)
        {
            System.out.println(i + ") Username: " + creds.get(i).getUsername());
        }

        String response = input.nextLine();

        response = response.toUpperCase();

        if (response.equals("Q"))
        {
            System.out.println("Returning to Menu");
        }

        else
        {
            try
            {
                int index  = Integer.parseInt(response);

                String whichUser = creds.get(index).getUsername();
                FileInputStream in = new FileInputStream(whichUser);
                ObjectInputStream inFile = new ObjectInputStream(in);

                databases = (ArrayList<Files>)inFile.readObject();

                inFile.close();
                in.close();
            }
            catch(IOException e)
            {
                System.out.println(e.getMessage());
            }

            catch(Exception e)
            {
                System.out.println("Invalid Index Value");
            }

            System.out.println("Select User DB to view Entries of.");
        }
    }

    public void loadAccounts()
{
    try (FileInputStream file = new FileInputStream("users.dat");
         ObjectInputStream accounts = new ObjectInputStream(file);)
         {
            creds = (ArrayList<User>)accounts.readObject();

            accounts.close();
            file.close();
         }
    catch(IOException e)
    {
        System.out.println(e.getMessage());
    }
}
}