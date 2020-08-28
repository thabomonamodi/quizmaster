
/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Container;

public class Play extends JFrame
{
    private JButton start,options,help,back,exit;

    private Container pane;

    private JPanel main;
    private JPanel mainpanel;

    public Play()
    {
        super("Ex_Quiz");
        pane = getContentPane();
        initializeComponents(); 
    }
    private void initializeComponents()
    {
        JLabel option = new JLabel();
        start = new JButton("Play");
        
        start.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Details details = new Details();
                setVisible(false);
            }
        });
        help = new JButton("Help");
        help.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(null,"Please visit wwww.NWU.ac.za/Ex_Quiz");
            }
        });
        options = new JButton("Options");
        options.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Options option = new Options();
                setVisible(false);
            }
        });
        
        mainpanel = new JPanel();
        GroupLayout layout = new GroupLayout(mainpanel);
        mainpanel.setLayout(layout);
        
        
                      
        mainpanel.setBackground(Color.GREEN);
        pane.add(mainpanel);
        pack();
        setVisible(true);
    }
}
