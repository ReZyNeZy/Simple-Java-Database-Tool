import java.io.*;
import java.util.*;



public class Account 
{
    Database d = new Database();
    File f = new File();
    Scanner input = new Scanner(System.in);
    ArrayList<File> data = new ArrayList<>();

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


            System.out.println("Select DB to Access");

            for (int i = 0; i < data.size(); i++)
            {
                System.out.println(i + ")" + data.get(i).getDataName());
            }

            int response = input.nextInt();

            d.setFileName(data.get(response).getDataName());

            d.testName();
            //d.Menu();
    }

    public void createDB()
    {
        loadDBs();
        System.out.println("Insert name for DataBase");
        String name = input.nextLine();


        f.setDataName(name);
        
        data.add(f);

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

             data = (ArrayList<File>)inFile.readObject();
             inFile.close();
         }

         catch (Exception e)
         {
            System.out.println(e.getMessage());
         }
    }

    public void deleteDB()
    {
        System.out.println("Select Database to Delete");

        for (int i = 0; i < data.size(); i++)
        {
            System.out.println(i + ")" + data.get(i).getDataName());
        }

        int response = input.nextInt();

        while (keepGoing)
        {
            System.out.println("Are You Sure You Want to Delete" + data.get(response).getDataName());
            System.out.println("press Y to confirm, and Q to cancel");

            String delete = input.nextLine();

            delete = delete.toUpperCase();

            if (delete.equals("Y"))
            {
                keepGoing = false;
                data.remove(response);

                try (FileOutputStream out = new FileOutputStream(username);
                     ObjectOutputStream outFile = new ObjectOutputStream(out);)
                     {
                        outFile.writeObject(data);
                        outFile.close();
                     }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }

            if (delete.equals("Q"))
            {
                keepGoing = false;
                System.out.println("Returning to Menu");
            }

            else
            {
                System.out.println("Invalid Input");
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



}//end Account