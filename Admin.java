public class Admin
{
    String username;
    String password;


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

    public void Menu()
    {
        System.out.println("SPECIAL ADMIN MENU");
        System.out.println("______________________");
        System.out.println("1) View All users");
        System.out.println("2) Delete User");
        System.out.println("3) View  User Data");
    }
}