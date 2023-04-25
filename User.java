import java.io.*;
import java.io.File;
import java.util.*;



public class User extends Account implements Serializable
{
    static Scanner input = new Scanner(System.in);
    ArrayList<Database> data = new ArrayList<Database>();

    String username;
    String password;
    String name;
    boolean keepGoing;


public User()
{
    this.username = "";
    this.password = "";
}//end null construct

public User (String username, String password)
{
    this.username = username;
    this.password = password;
}// end user and pass construct


    public void CreateOrAccess()
        {
            loadDBs();
 
                System.out.println("");
                System.out.println("Welcome to Database Manager");
                System.out.println("");
                System.out.println("______________________________");
                System.out.println("1) Access existing DataBase");
                System.out.println("2) Create new Database");
                System.out.println("3) Delete Database");
                System.out.println("4) Log Out");
                System.out.println("______________________________");
                System.out.println("");
                String response = input.nextLine();

                if (response.equals("1"))
                {
                    accessDB();
                }

                if (response.equals("2"))
                {
                    createDB();
                }

                if (response.equals("3"))
                {
                    deleteDB();
                }

                if (response.equals("4"))
                {
                    keepGoing = false;
                }

                else
                {
                    System.out.println("Invalid Input");
                    CreateOrAccess();
                }

        }//end CreateOrAccess

    public void accessDB()
    {

            System.out.println("Select DB to Access. Or Press Q to Quit.");

            for (int i = 0; i < data.size(); i++)
            {
                System.out.println(i + ")" + data.get(i).getFileName());
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
                    int confirm = Integer.parseInt(response);
                    data.get(confirm).Menu();
                }

                catch (Exception e)
                {
                    System.out.println("");
                    System.out.println("Your Response is not a number associated with your DataBases!");
                }
            }
        
        }  // end access
     

    public void createDB()
    {
        System.out.println("Insert name for DataBase");
       
        String dbName = input.nextLine();


        // f.setDataName(name);
        
        data.add(new Database(dbName));

        try
        {
            File database = new File(dbName);

            if (database.createNewFile())
            {
                System.out.println("File Created For " + dbName);
            }

            else 
            {
                System.out.println("WARNING. You have created a databases with matching names. THis could cause issues with storing your data.");
            }
        }

        catch (IOException e )
        {
            System.out.println(e.getMessage());
        }
        // data.add(f);

        try (FileOutputStream out = new FileOutputStream(username);
             ObjectOutputStream outFile = new ObjectOutputStream(out);)
             {
                outFile.writeObject(data);
                outFile.close();
                out.close();
             }
        catch (IOException e)
        {
            System.out.println("e.getMessage");
        }
    
    }//end create

    public void loadDBs()
    {
         try
         {
             FileInputStream file = new FileInputStream(username);
             ObjectInputStream inFile = new ObjectInputStream(file);

             data = (ArrayList<Database>)inFile.readObject();
             inFile.close();
             file.close();
         }

         catch (Exception e)
         {
            System.out.println(e.getMessage());
         }
    }

    public void deleteDB()
    {
       System.out.println("Select DB to Delete. Or Press Q to Return to Menu");
       System.out.println("");

       for (int i = 0; i < data.size(); i++)
       {
            System.out.println(i + ")" + data.get(i).getFileName());
       }

            String response = input.nextLine();

            response = response.toUpperCase();

            if (response.equals("Q"))
            {
                System.out.println("Returning to Menu");
            }

            else
            {
                System.out.println("Are You Sure You Want to Delete this Entry? Type 1 for Yes and 2 for No");

                String confirm = input.nextLine();

                if (confirm.equals("1"))
                {

                    try
                    {
                    int remove = Integer.parseInt(response);
                    data.remove(remove);

                    System.out.println("Successfully Deleted");
                    }

                    catch (Exception e)
                    {
                        System.out.println("Your initial entry must not be correct. Make sure you input the number assciated with the DB you wish to delete");
                    }

                    try 
                    {
                        FileOutputStream out = new FileOutputStream(username);
                         ObjectOutputStream outFile = new ObjectOutputStream(out);
                    
                       outFile.writeObject(data);
                       outFile.close();
                       out.close();
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                }

                if (confirm.equals("2"))
                {
                    System.out.println("Returning to Menu");
                }

                else
                {
                
                }//end else
            }// end else Q

    }//end delete




public void AdminCheck()
{
    loadDBs();
    System.out.println("IN ADMIN CHECK");
    System.out.println("Select User DB to Access");
    
    for (int i = 0; i < data.size(); i++)
    {
        
        System.out.println(i + ") " + data.get(i).getFileName());
        System.out.println("");
    }

    String viewContent = input.nextLine();
    viewContent = viewContent.toUpperCase();

    if (viewContent.equals("Q"))
    {
        System.out.println("Returning to Menu");
    }

    else
    {
        try
        {
            int send = Integer.parseInt(viewContent);

            System.out.println("All Entries in " + data.get(send).getFileName());
            System.out.println("Select Entry to Flag or Press Q to Return to Menu");

            data.get(send).AdminView();

        }

        catch(Exception e)
        {
            System.out.println("Something Went Wrong");
        }
    }
}










    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }




}//end Account