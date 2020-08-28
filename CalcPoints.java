
/**
 * Write a description of class CalcPoits here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.lang.NullPointerException;
import java.awt.Color;
public class CalcPoints extends JFrame
{
    private JLabel lblTitle, lblScore, lblScoreDetails, lblTimer, lblTimer2;
    static int interval;
    static Timer time;
    static Timer time1;

    static int totalTime = 0;

    int count = 0;
    int scoreCount = 0;
    int score = 0;
    public CalcPoints()
    {
        super("Ex_Quiz");
        setLayout(null);

        lblTitle = new JLabel("Title Of The Game");
        lblTitle.setBounds(240,5,240,30);

        lblScore = new JLabel("Score :");
        lblScore.setBounds(540,140,190,30);

        lblScoreDetails = new JLabel("Score Details");
        lblScoreDetails.setBounds(540,160,190,30);

        lblTimer = new JLabel("Time Remaining");
        lblTimer.setBounds(20,280,180,30);

        lblTimer2 = new JLabel("     300");
        lblTimer2.setBounds(20,310,150,50);

        add(lblTitle);
        add(lblScore);
        add(lblScoreDetails);
        add(lblTimer);
        add(lblTimer2);
    }
    /*public void countDown()
    {
    int delay = 1000;
    int period = 1000;
    time = new Timer();
    interval = Integer.parseInt("300");
    time.scheduleAtFixedRate(new TimerTask()
    {
    public void run()
    {
    lblTimer2.setText(" " + setInteval());

    if (interval == 0)
    {
    JOptionPane.showMessageDialog(null, "Time is up");
    getResults();
    JOptionPane.showMessageDialog(null,"Game results for ''"+getName()+
    + "\n\n" + "Questions answered :" + count + "Points :" + score);

    if (score >= 20)
    {
    JOptionPane.showMessageDialog(null,"Well done!");
    }
    else
    {
    JOptionPane.showMessageDialog(null,"Come prepared to class");
    }
    }
    }
    },delay,period);
    }
    public void countUp()
    {
    int delay = 1000;
    int period = 1000;
    timer2 = new Timer();
    interval2 = Integer.parseInt( "0" );
    //System.out.println(secs);
    timer2.scheduleAtFixedRate(new TimerTask() 
    {
    public void run() 
    {
    //lblTimer2.setText("Time Took : "+setIntervalTook()+" sec");
    }
    }, delay, period);
    }
    private static final int setInterval()
    {
    if( interval== 1) 
    timer.cancel();
    return --interval;
    }

    private static final int setIntervalTook()
    {
    if( interval2== 30) 
    timer2.cancel();
    return ++interval2;
    }
    public void getResults()
    {
    totalTime = totalTime + (setIntervalTook() - 2 - 4 + 1);
    }*/

    public void getScore()
    {
        score = score + 2;
        lblScoreDetails.setText(" "+score);
    }
}