1. Admin

    Non Method class items
        Variables to include
        String for username
        String for password

    Other includes
        A Scanner for input that has a System.in
        An ArrayList
            ArrayList has type Account
                Name it accounts

    Implements Account class

     a method for setting the username
        Method has a parameter of string
            Set the parameter to what ever desired admin username is

    Include a method for getting the username
        Method has type string
        Method returns the username string

    Include a method for setting the password
        Method has a parameter of string
        Set the parameter to what ever desired admin password is
    
    Include a method for getting the password
        Method has type string
        Method returns the password string

    Include a method for menu
        Menu will output a list of options for the user to select from
            View users
            Delete User
            Access USer Data/Delete user data
            Log out
        User can select one of these values with a string input and will achieve the desired outcome from the input
        Program will loop with misinputs

    Include a method for viewing all users
        A for loop is created to list all user’s username and password along with their index value in the system

    Include a method for deleting a user
        A for loop lists all usernames and their index value in the system
        The Admin enters a string value of the index selected
        Admin is prompted to confirm their choice 
            Upon confirm
            Admin’s string value is converted to an integer
                If this is not possible, a catch will catch the exception and keep the program running
        Integer value deletes the user in question

    Include a method for viewing user data and deleting if necessary.
        A for loop lists all usernames and their index value in the system
        The Admin enters a string value of the index selected
        The admin is sent to the user class associated with the index value selected
        Sent to a method inaccessible to the user

2. Main

    Non method Includes
        A Scanner for input that gets System.in
        A boolean called keepGoing
        An ArrayList of type User
            Called accounts
        Admin class
            Called a.
    Public static void main(String[] args)

    Constructor Main
        Calls the method for menu

    Method for menu
        Menu gives 2 options
            Options are to create an account or log in
            Each take to to the respective page

    Method for create account
        User is prompted to input their new username
            User gives their username with the input scanner
    User is prompted to enter a password
        User inputs their password
            User confirms password
                Prompted to input the password again
                    If passwords match
                        Values are added to the array list through class constructor.
                        A try catch is opened for a object output stream
                        The arraylist is then written to a file

                    If passwords dont match
                        Program returns to log in or create account

    Method for login menu
        User is prompted to input their username and password
            User inputs their username and password
        An if else is opened to see if there is a file with the user’s username in existence
            A file is opened if no
            A file is not opened if yes
        The user is taken to their specific menu via a for loop to find matching username and password
            Method for loading the accounts
        A object input stream is opened in a try catch 
            The arraylist is then opened and rewritten with the data in the file. This is used to load the data in menu 

3. Account
        Non Method Includes
            String for username
            String for password

    Abstract class
        Implemented by User and admin

    Include a method for getting the username
        Method has type string

    Include a method for setting the username
        Method has parameter string

    Include a method for getting the password
        Method has type string

    Include a method for setting the password
        Method has parameter string

    INclude method for adminChecking
        Once an admin selects this class to view
        A for loop prints out the databases associated with this user
    Admin then is prompted to select a database 
        Input scanner gets an integer value
    Integer value is used to prompt the arraylist to send the user to that db’s menu

4. User
    Implements account and is serializable
    Non Method inclusions
        String for username
        String for password
        String for name
        Boolean keepGoing
        A scanner input for System.in
        An ArrayList with Type Database

    Constructor with no parameters
        Sets the username and password to empty strings

    COnstructor with 2 string parameters
    These parameters are what the empty strings are set to

    Method for loading the databases.
        This method will ber a try catch and have an object input stream to load all the DBs

    Method for menu
        Gives the user a list of options and  and a number value associated with the options
        The user then inputs a string value and loops if the value is not equal to a valid option

    Method for adding a db
        USer inputs a name for the db
            Name is sent the the parameter constructor of the database class and saved to an Array list
            Class is serialized in the arraylist with an object output stream and try catch

    Delete a db
        User is given the names of the db’s and the index value associated with such
            User is prompted to select a db to delete
        USr is prompted to confirm delete with an ther input string
            DB is deleted if user inputs legal value
                All done with string inputs and integer parsing

    Access a db Method
        User is given the names of the db’s and the index value associated with such
            Program is prompted to create a file with the name of the file being the name of the db
        If such a file exists . the file is not created

    INclude method for adminChecking
            Once an admin selects this class to view
            A for loop prints out the databases associated with this user
        Admin then is prompted to select a database 
            Input scanner gets an integer value
        Integer value is used to prompt the arraylist to send the user to that db’s menu

5. Database
    Implements serializable
    Not method includes
        Boolean keepGoing
        AN Arraylist of type entry 
        A string for database name
        An Entry class instantiation

    Constructor with no parameters
        Sets database name string to an empty string

    Constructor with parameters of string 
        The emty string is set to the string in the parameter

    Method for loading the entries
        A try catch is used for an object input stream
        Arraylist is loaded with data inside the file

    Method for menu
        Menu lists numbers associated with options for the user
        User can select to add, view , edit, and delete entries along with the ability to log out of the system
        load Entries is also called at this time

    Method for View Entry
        A for loop lists all the entries and their description 

    Method for Add Entry
        The user is prompted to add a title for their entry
            The user gives a title with a string input
        User is prompted to give a description for their entry
            The user gives a description for their entry with a string input
        The entry is saved to the arraylist via the 2 string parameter constructor in the entry class

    Method for Edit entry
        A for loop lists all the entry titles
        User gives the index value associated with their entry of choice
            The Entry title is saved to a variable via the getEntry method of the entry class
        The user is prompted to give a new description for the entry
            User inputs a new description
        The user sets the entry with the entry title to the new description value

    Method for delete entry
        A for loop lists all the entry titles
            User gives the index value associated with their entry of choice
        The user is prompted with a choice to confirm their entry
            USer confirms entry with a string input
    Entry is converted into an integer value and a remove method deletes the value from the arraylist

Method for admin access
    Admin is given the values in the DB with the admin acces upon selecting a DB
        Admin decides if they want to flag entries. 
    Admin flags entry
        Entry is deleted from system along with a new entry replacing the deleted on informing the user that their entry was flagged and has been deleted

6. Entry
    Used by the Database class to save data
    Includes a string for Entry title
    Includes a string for entry description

    Includes a constructor
        Constructor sets the name and description variable to empty strings

    Includes a parameter constructor
        Parameters are both variables for entry and description
        Set both this.variables to get another variable
            This will be used in the Database area

    Include a method for getting the entry title
        Method has type string
            Method returns the title string

    Includes a method for setting entry title
        Has a parameter of a string
        Set the this.variable to get the parameter

    Include a method for setting the description
        Method has a parameter of string
            Set the this.variable to get the string parameter

    Include a method for getting the description
        Method has type string
        Method returns description
