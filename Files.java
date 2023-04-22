import java.io.*;


public class Files implements Serializable
{

    String dataName;

    public Files() 
    {
        this.dataName = "";
    }

    public Files(String name) 
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
