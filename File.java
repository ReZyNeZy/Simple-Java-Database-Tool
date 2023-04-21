import java.io.*;


public class File implements Serializable
{

    String dataName;

    public File() 
    {
        this.dataName = "";
    }

    public File(String name) 
    {
        this.dataName = name;

    }

    public String getDataName()
    {
        return dataName;
    }

    public void setDataName(String dataName)
    {
        this.dataName = dataName;
    }
}
