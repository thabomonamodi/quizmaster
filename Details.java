
/**
 * Write a description of class Details here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.Container;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.FlowLayout;
import java.util.ArrayList;
public class Details extends JFrame
{
    private Quizable [] arrquiz = new Quizable[100];
    int count;

    private Container content;
    private JTextField name;
    private JTextField type,stnumber;
    private JTextArea textArea;

    private JLabel lblusername, lblplayertype, lblstudentnumber;
    private JPanel button_panel;
    private JButton proceed;
    private JButton display_button;

    private JPanel main;
    private int playerCount = 0;
    private int stnumberCount = 0;

    private String name1;
    private String stNumber;
    private String player;


    public Details()
    {
        super("Player Details");
        setLayout(null);
        content = getContentPane();
        initializeComponents();
    }

    private void initializeComponents()
    {
        JMenu fileMenu = new JMenu("Options");
        JMenuItem search = new JMenuItem("Search");
        fileMenu.add(search);
        JMenuItem save = new JMenuItem("Save");
        fileMenu.add(save);
        fileMenu.add(search);
        JMenuItem exit = new JMenuItem("Exit");
        fileMenu.add(exit);

        lblusername = new JLabel("Name");
        lblplayertype = new JLabel("Type of user");
        name = new JTextField();
        stnumber = new JTextField();

        display_button = new JButton("Display All");
        button_panel = new JPanel(new FlowLayout( FlowLayout.CENTER));
        button_panel.add(display_button);

        ButtonHandler handler = new ButtonHandler();
        display_button.addActionListener(handler);

        content.add(lblusername);
        content.add(lblplayertype);
        content.add(name);
        content.add(stnumber);
        setVisible(true);

        /*search.addActionListener(
        new ActionListener()
        {
        public void actionPerformed(ActionEvent e)
        {
        String results = JOptionPane.showInputDialog("Please enter a student number or name to search for ");
        for (int t = 0; t < count; t++)
        {
        if(arrquiz[t] instanceof Student)
        {
        Student access = (Student)arrquiz[t];
        if (access.getPoints().equalsIgnoreCase(results))
        {
        String name = JOptionPane.showMessageDialog(null,"The points scored by " + access.getName() + " is" + access.getPoints());
        }
        }
        }
        }
        });*/

        save.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    String files = JOptionPane.showInputDialog("Please enter ITRW211, ITRW212, ITRW213 or ITRW214");
                    try
                    {
                        PrintWriter write = new PrintWriter(files + "txt");
                        for (int t = 0; t < count; t++)
                        {
                            Ex_Quiz ex = (Ex_Quiz)arrquiz[t];
                            if (ex.getPlayerType().equalsIgnoreCase(files))
                            {
                                write.println(arrquiz[t]);
                            }
                        }
                        write.close();
                    }
                    catch (Exception exc)
                    {
                        JOptionPane.showMessageDialog(null,"Could not create a file");
                    }
                }
            });

        exit.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {

                    login log = new login();
                    log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    log.setSize(900, 700);
                    log.setVisible(true);
                    dispose();
                }
            }
        );

        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        bar.add(fileMenu);
    }
    private class ButtonHandler implements ActionListener  
    {
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == display_button)
            { 
                textArea.setText("List\n\n");
                for (int k = 0; k < count; k++)
                {
                    //textArea.append(arrquiz[k]);
                }

            }
        }
    }

    public static void StoreFile(String filename, Quizable [] arrQuiz, int Count)
    {
        try
        {
            PrintWriter output = new PrintWriter(filename+ "txt");
            for(int k = 0; k < Count;k++)
            {
                output.println(arrQuiz[k].toString());
            }  
            output.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();   
        }

    }
}
