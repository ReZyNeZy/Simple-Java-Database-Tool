import java.util.*;
import java.io.*;

public class Database

{
    boolean keepGoing;
    ArrayList<Entry> entries = new ArrayList<>();
    String name;
    Scanner input = new Scanner(System.in);
    Entry e = new Entry();

    

    public void Menu()
    {
        keepGoing = true;

        while (keepGoing)
        {
            System.out.println("1) View Entries");
            System.out.println("2) Create Entry");
            System.out.println("3) Remove Entry");
            System.out.println("4) Edit Description of Entry");
            System.out.println("5) Select New Database");

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
                
            }

            if (response.equals("4"))
            {
                
            }

            if (response.equals("5"))
            {
                keepGoing = false;
                System.out.println("Returning to Select");
            }


            else
            {
                System.out.println("Invalid Input");
            }
        }
    }

    public String getFileName()
    {
        return name;
    }

    public void setFileName(String name)
    {
        this.name = name;
    }

    public void viewEntries()
    {
        System.out.println("All Entries.");

        for (int i = 0; i < entries.size(); i++)
        {
            System.out.println("Entry: " + entries.get(i).getEntry());
            System.out.println("Description: " + entries.get(i).getDescription());
        }
    }// view

    public void createEntry()
    {
        System.out.println("Input Entry Title");
        String entry = input.nextLine();
        
        System.out.println("Input Description of Entry");
        String description = input.nextLine();

        e.setEntry(entry);
        e.setDescription(description);

        entries.add(e);

        try (FileOutputStream out = new FileOutputStream(name);
             ObjectOutputStream outFile = new ObjectOutputStream(out);)
             {
                outFile.writeObject(entries);
             }
        catch (IOException e)
        {
            System.out.println("e.getMessage");
        }
    }// end create

    public void removeEntry()
    {

    }//end remove

    public void editEntry()
    {

    }//end edit

    

}//end Database
