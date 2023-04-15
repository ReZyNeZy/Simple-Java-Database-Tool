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

    public void aMenu()
    {
        keepGoing = true;
        while (keepGoing)
        {
            System.out.println("SPECIAL ADMIN MENU");
            System.out.println("______________________");
            System.out.println("1) View All users");
            System.out.println("2) Delete User");
            System.out.println("3) View  User Data");
            System.out.println("4) Log Out");
            System.out.println("______________________");

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
                System.out.println("Logout Successful");
                keepGoing = false;
            }
            else
            {
                System.out.println("Input Invalid. Try Again");
                System.out.println("");
            }
        }
    }

    public void viewUser()
    {
        loadAccounts();

        System.out.println("Current Users In System");

        for (int i = 0; i< creds.size(); i++)
        {
            int num = i + 1;
            System.out.println(num + ") " + "Username: " + creds.get(i).getUsername() + " " + "Password: " + creds.get(i).getPassword());
            System.out.println("");
        }
    }

    public void deleteUser()
    {
        System.out.println("Select User to Delete");

        int i;

        for (i = 0; i< creds.size(); i++)
        {
            System.out.println(i + ") " + "Username: " + creds.get(i).getUsername() + "Password: " + creds.get(i).getPassword());
            System.out.println("");

            
        }
        // int legal = i;
        // System.out.println(legal);
        int response = input.nextInt();

       // if (response == legal)

        System.out.println("Confirm delete of " + creds.get(response).getUsername());
  
        keepGoing = true;

        while (keepGoing)
        {
            System.out.println("Type Y to confirm. Type C to Cancel");
            String delete = input.nextLine();
            delete = delete.toUpperCase();
            if (delete.equals("Y"))
            {
                keepGoing = false;
                creds.remove(response);

                try (FileOutputStream out = new FileOutputStream("valut.dat");
                     ObjectOutputStream outFile = new ObjectOutputStream(out);)
                     {
                        outFile.writeObject(creds);
                     }

                     catch (Exception e)
                     {
                        System.out.println(e.getMessage());
                     }
                System.out.println("Delete Successful");
            }

            if (delete.equals("C"))
            {
                keepGoing = false;
                System.out.println("Returning to Menu");
                System.out.println("");
            }

            else 
            {
                System.out.println("Response invalid");
            }

        }


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