
/**
 * Abstract class Ex_Quiz - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Ex_Quiz implements Quizable
{
    private String name;
    private String stnumber;
    private String player_type;
    public String password;
    public Ex_Quiz(String username, String StudentNo, String Player)
    {
        name = username;
        stnumber = StudentNo;
        player_type = Player;
    }
    public String getName()
    {
        return name;
    }
    public String getStudentNo()
    {
        return stnumber;
    }
    public String getPlayerType()
    {
        return player_type;
    }
    public void setPassword(String Password)
    {
        password = Password;
    }
    public String getPassword()
    {
        return password;
    }
    public String toString()
    {
        return String.format("%s%s\n%s%s\n%s%s","Name : ",name,"Student number : ",stnumber,"Type of Player :",player_type);
    }
    public abstract boolean playerType();
}
