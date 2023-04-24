
import java.util.*;
import java.io.*;

public class Database implements Serializable

{
    boolean keepGoing;
    ArrayList<Entry> entries = new ArrayList<Entry>();
    String dbName;
    static Scanner input = new Scanner(System.in);
    Entry e = new Entry();

    

    public Database()
    {
        this.dbName = "";
    }

    public Database(String dbName)
    {
        this.dbName = dbName;
    }

    public void Menu()
    {
        loadEntries();

            System.out.println("");
            System.out.println(" Welcome to " + dbName);
            System.out.println("______________________________");
            System.out.println("1) View Entries");
            System.out.println("2) Create Entry");
            System.out.println("3) Remove Entry");
            System.out.println("4) Edit Description of Entry");
            System.out.println("5) Select New Database");
            System.out.println("______________________________");
            System.out.println("");


            String response = input.nextLine();

            if (response.equals("1"))
            {
                viewEntries();
            }

            if (response.equals("2"))
            {
                createEntry();
            }

            if (response.equals("3"))
            {
                removeEntry();
            }

            if (response.equals("4"))
            {
                editEntry();
            }

            if (response.equals("5"))
            {
                keepGoing = false;
                System.out.println("Returning to Select");
            }


            else
            {
                Menu();
            }
        
    }// end menu

    public void viewEntries()
    {
        System.out.println("");
        System.out.println("All Entries.");
       
            for (int i = 0; i < entries.size(); i++)
            {
                System.out.println("");
                System.out.println("Entry: " + entries.get(i).getEntry());
                System.out.println("Description: " + entries.get(i).getDescription());
                System.out.println("");
            }
        
    }// end view

    public void createEntry()
    {
        System.out.println("Input Entry Title");
        String entry = input.nextLine();
        
        System.out.println("Input Description of Entry");
        String description = input.nextLine();

        entries.add(new Entry(entry, description));

        try (FileOutputStream out = new FileOutputStream(dbName);
             ObjectOutputStream outFile = new ObjectOutputStream(out);)
             {
                outFile.writeObject(entries);
                outFile.close();
             }
        catch (IOException e)
        {
            System.out.println("e.getMessage");
        }
    }// end create

    public void removeEntry()
    {
        System.out.println("Select DB to Delete. Or Press Q to Return to Menu");  
        System.out.println("");

        for (int i = 0; i < entries.size(); i++)
        {
            System.out.println(i + ")" + entries.get(i).getEntry());        
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
                    entries.remove(remove);
                    }

                    catch (Exception e)
                    {
                        System.out.println("Your initial entry must not be correct. Make sure you input the number assciated with the Entry you wish to delete.");
                    }

                    try 
                    {
                        FileOutputStream out = new FileOutputStream(dbName);
                         ObjectOutputStream outFile = new ObjectOutputStream(out);
                    
                       outFile.writeObject(entries);
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
            }

    }//end remove

    public void editEntry()
    {
        System.out.println("Selecrt Entry To Edit. Or Press Q to quit");

        for (int i = 0; i < entries.size(); i++)
        {
            System.out.println(i + ")" + entries.get(i).getEntry());        
        }

        String response = input.nextLine();
        response = response.toUpperCase();

        if (response.equals("Q"))
        {
            System.out.println("");
            System.out.println("Returning to Menu");
        }

        else
        {
            try
            {
                int edit = Integer.parseInt(response);
                System.out.println("Input new description for " + entries.get(edit).getEntry());

                String newDesc = input.nextLine();

                entries.set(edit, new Entry(entries.get(edit).getEntry(), newDesc));

                try
                {
                    FileOutputStream out = new FileOutputStream(dbName);
                    ObjectOutputStream outFile = new ObjectOutputStream(out);
                                 
                    outFile.writeObject(entries);
                    outFile.close();
                    out.close();
                }

                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }

            catch(Exception e)
            {
                System.out.println("Something Went Wrong. Make Sure You are Entering a Valid Number");
            }
        }

    }//end edit


    public void AdminView()
    {
        loadEntries();
        for (int i = 0; i < entries.size(); i++)
        {
            System.out.println("");
            System.out.println(i + ") Entry: " + entries.get(i).getEntry());
            System.out.println("   Description: " + entries.get(i).getDescription());
            System.out.println("");
        }

        String flag = input.nextLine();

        if (flag.equals("Q"))
        {
            System.out.println("Returning to Menu");
        }

        else
        {
            try
            {
                
                System.out.println("Type 1 to confirm. Press any other Key to Return to Menu");

                String aConfirm = input.nextLine();

                if (aConfirm.equals("1"))
                {
                    int aDelete = Integer.parseInt(flag);

                    entries.remove(aDelete);

                    String eWarning = "WARNING";
                    String dWarning = "One of your entries was flaged for malicious content and deleted.";

                    entries.add(new Entry(eWarning, dWarning));

                    try
                    {
                        FileOutputStream out = new FileOutputStream(dbName);
                        ObjectOutputStream outFile = new ObjectOutputStream(out);
                                 
                        outFile.writeObject(entries);
                        outFile.close();
                        out.close();
                    }

                    catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                }

                else
                {
                    System.out.println("Returning to Menu");
                }
                
            }

            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        }


    }// end Admin Eyes

    public void loadEntries()
    {
        try
        {
            FileInputStream file = new FileInputStream(dbName);
            ObjectInputStream inFile = new ObjectInputStream(file);

            entries = (ArrayList<Entry>)inFile.readObject();
            inFile.close();
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }// end load entries

    
    public String getFileName()
    {
        return dbName;
    }

    public void setFileName(String dbName)
    {
        this.dbName = dbName;
    }

}//end Database