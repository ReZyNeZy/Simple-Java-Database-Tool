import java.io.*;
import java.util.*;



public class Account 
{
    Database d = new Database();
    Scanner input = new Scanner(System.in);
    ArrayList<String> data = new ArrayList<>();
    String username;
    String name;
    boolean keepGoing;

    public void CreateOrAccess()
        {
            keepGoing = true;
            while (keepGoing)
            {
                System.out.println("______________________________");
                System.out.println("1) Access existing DataBase");
                System.out.println("2) Create new Database");
                System.out.println("3) Delete Database");
                System.out.println("4) Log Out");
                System.out.println("______________________________");
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
            }//end while

        }//end CreateOrAccess

    public void accessDB()
    {
        loadDBs();
        keepGoing = true;

        System.out.println("Select Database to Access or press Q to return to menu");
        for (int i = 0; i < data.size(); i++)
        {
            System.out.println(i + ") " + data.get(i));
        }

            int response = input.nextInt();
            d.setFileName(data.get(response));
            d.Menu();
            

    }

    public void createDB()
    {
        loadDBs();
        System.out.println("Insert name for DataBase");
        String name = input.nextLine();
        name = name + ".dat";
        

        System.out.println(name);
        System.out.println(username);
        data.add(name);

        try (FileOutputStream out = new FileOutputStream(username);
             ObjectOutputStream outFile = new ObjectOutputStream(out);)
             {
                outFile.writeObject(data);
                outFile.close();
             }
        catch (IOException e)
        {
            System.out.println("e.getMessage");
        }
    }

    public void loadDBs()
    {
         try
         {
             FileInputStream file = new FileInputStream(username);
             ObjectInputStream inFile = new ObjectInputStream(file);

             data = (ArrayList<String>)inFile.readObject();
             inFile.close();
         }

         catch (Exception e)
         {
            System.out.println(e.getMessage());
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

    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }

    public void deleteDB()
    {
        loadDBs();
        keepGoing = true;
        System.out.println("Select Database to Delete or Press Q to Quit");

        for (int i = 0; i < data.size(); i++)
        {
            System.out.println(i + ") " + data.get(i));
        }
        
        while (keepGoing)
        {

            String response = input.nextLine();
            response = response.toUpperCase();

            if (response.equals("Q"))
            {
                keepGoing = false;
                CreateOrAccess();
            }

        }// end while
        

    }// end delete



}//end Account
