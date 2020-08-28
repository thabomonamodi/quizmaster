
/**
 * Write a description of class Student here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Student extends Ex_Quiz
{
    private int points;
    public Student(String name, String stnumber,String player,int Points)
    {
        super(name,stnumber,player);
        points = Points;
    }
    public int getPoints()
    {
        return points;
    }
    public boolean playerType()
    {
        if (super.getPlayerType() == "Student")
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
