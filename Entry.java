import java.io.Serializable;

public class Entry implements Serializable
{
    String entry;
    String description;


    public Entry()
    {
        this.entry = "";
        this.description = "";
    }

    public Entry(String entry, String description)
    {
        this.entry = entry;
        this.description = description;
    }
    
    public void setEntry(String entry)
    {
        this.entry = entry;
    }

    public String getEntry()
    {
        return entry;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
}
