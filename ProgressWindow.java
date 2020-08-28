
/**
 * Write a description of class ProgressCount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.Timer;//works with intervals
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JOptionPane;
public class ProgressWindow extends JFrame
{
    private JProgressBar progress;
    private JLabel loadLabel, welcome_label;
    private JPanel panel; 
    private Timer timer;
    final static int interval = 50;
    private int count;
    public ProgressWindow()
    {
        super("Loading...");
        setLayout(null);        
        welcome_label = new JLabel("Welcome To the Quiz site");
        welcome_label.setBounds(120,20,400,30);
        progress = new JProgressBar(0, 100);
        progress.setSize(425, 40);
        progress.setValue(0);
        progress.setStringPainted(true);
        progress.setBounds(10,60, 420, 20);
        progress.setBackground(Color.RED);
        progress.setForeground(Color.BLACK);
        loadLabel = new JLabel("Please be patient while the quiz loads....");
        loadLabel.setBounds(20,80,400,30);
        ImageIcon background = new ImageIcon(" ");
        JLabel ImageLabel = new JLabel(background); 
        add(progress);
        add(ImageLabel);
        add(loadLabel);
        add(welcome_label);

        timer = new Timer(interval, new ActionListener()
            {

                public void actionPerformed(ActionEvent event)
                {
                    //timer.start();

                    if(count==100)
                    {
                        timer.stop();
                        //setVisible(false);
                        //JOptionPane.showMessageDialog(null,"Welcome to Keep Calm & Informate System","WELCOME",JOptionPane.PLAIN_MESSAGE);

                        login my = new login();
                        my.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        my.setSize(900,700);
                        //my.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        my.setVisible(true);
                        dispose();
                        //setVisible( false );

                    }
                    progress.setValue(count);
                    count++;
                }

            }
        );
        timer.start();

    }
}

