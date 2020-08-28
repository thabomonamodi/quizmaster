
/**
 * Write a description of class Lecturer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lecture extends Ex_Quiz
{
    public Lecture(String name, String stnumber, String player)
    {
        super(name,stnumber,player);
    }
    public boolean playerType()
    {
        if (super.getPlayerType() == "Lecturer")
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public String toString()
    {
        return String.format("%s\n",super.toString());
    }
}
