import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;
import java.awt.Container;
import java.awt.Color;

import javax.imageio.ImageIO;
import java.io.File;
public class Loggedin extends JFrame
{
    private Quizable [] quiz = new Quizable[100];
    private int count = 0;
    private int t = 0;
    private Container pane;
    private JButton start;
    private JButton back;
    private JButton quit ;

    private JLabel lblmsg;
    private JLabel lblstart;

    public Loggedin()
    {
        super("main.jpg");
        setLayout(null);
        try
        {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("main.jpg")))));

        }catch (Exception ex)
        {;}
        ButtonHandler h = new ButtonHandler();

        JMenu fileMenu = new JMenu("Options");
        fileMenu.setMnemonic('f');
        JMenu file = new JMenu("Help");

        JMenuItem aboutItem = new JMenuItem("About");
        JMenuItem help = new JMenuItem("Help");
        aboutItem.setMnemonic('a');
        file.add(aboutItem);
        file.add(help);

        lblmsg = new JLabel("WELCOME TO QUIZ SITE!");
        lblmsg.setFont(new Font("Serif",Font.BOLD,21));
        lblmsg.setBounds(4,100,150,50);
        add(lblmsg);

        lblstart = new JLabel("PRESS STAR TO BEGIN !");
        lblstart.setFont(new Font("Serif",Font.ITALIC,15));
        lblstart.setForeground(Color.RED);

        back = new JButton("Back");
        start = new JButton("Start");
        quit = new JButton("Quit");

        pane = getContentPane();
        pane.setLayout(null);

        lblmsg.setLocation(180,150);
        lblstart.setLocation(200,350);

        ButtonHandler button = new ButtonHandler();
        
        back.addActionListener(button);
        start.addActionListener(button);

        back.setLocation(1600,900);
        start.setLocation(400,500);
        quit.setLocation(1700,900);
        quit.addActionListener(h);

        lblmsg.setSize(280,30);
        lblstart.setSize(210,30);
        back.setSize(100,30);
        start.setSize(100,30);
        quit.setSize(100,30);

        pane.add(lblmsg);
        pane.add(lblstart);
        pane.add(back);
        pane.add(start);
        pane.add(quit);
        setVisible(true);

        aboutItem.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    JOptionPane.showMessageDialog(Loggedin.this, "This program was designed\n to help you perform\n better\n your concentration", "Press about to get info about the Ex_Quiz", JOptionPane.PLAIN_MESSAGE);
                }
            }
        );
        help.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    JOptionPane.showMessageDialog(Loggedin.this, "visit www.nwu.ac.za/Ex_Quiz");
                }
            });

        JMenuItem logout = new JMenuItem("Logout");
        logout.setMnemonic('l');
        fileMenu.add(logout);

        logout.addActionListener(
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
        bar.add(file);
    }
    private class ButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {      

            if(e.getSource() == quit)
            {
                int exit = JOptionPane.showConfirmDialog(null,"Do you want exit?"," Exit Message", JOptionPane.YES_NO_OPTION);
                if (exit == JOptionPane.YES_OPTION)
                {
                    JOptionPane.showMessageDialog(null, "Have a great day.");
                    System.exit(0);
                }
            }
            if (e.getSource() == back)
            {
                login my = new login();
                my.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                my.setSize(900, 700);
                my.setVisible(true);
                dispose();
            }
            if (e.getSource() == start)
            {
                Question my = new Question();
                my.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                my.setSize(900, 700);
                my.setVisible(true);
                dispose();
            }

            /*if (e.getSource() == quit)
            {
            System.exit(0);
            }*/
        }

    }
}