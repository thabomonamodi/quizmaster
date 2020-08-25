
/**
 * Write a description of class Question here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import java.util.Scanner;
import javax.swing.JTextArea;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import java.io.File;
import java.io.FileNotFoundException;
public class Question extends JFrame
{
    private Container pane;
    
    private JTextArea txtArea;
    private ButtonGroup rdbGroup;
    
    private BorderLayout layout;
    private JButton next;
    private JButton back;

    private JLabel lblmodule,lbltime,lblquestion,lblq1;
    private JRadioButton ITRW211,ITRW212,ITRW213,ITRW214;

    //setVisible(true);
    public Question()
    {
        super("Ex_Quiz");
        pane = getContentPane();
        initializeComponents();
    }

    private void initializeComponents()
    {
        setLayout(new FlowLayout());
        
        ITRW211 = new JRadioButton("ITRW211", false);
        ITRW212 = new JRadioButton("ITRW212", false);
        ITRW213 = new JRadioButton("ITRW213", false);
        ITRW214 = new JRadioButton("ITRW214", false);
        add(ITRW211);
        add(ITRW212);
        add(ITRW213);
        add(ITRW214);
        
        txtArea = new JTextArea();
        
        rdbGroup = new ButtonGroup();
        rdbGroup.add(ITRW211);
        rdbGroup.add(ITRW212);
        rdbGroup.add(ITRW213);
        rdbGroup.add(ITRW214);
        
        RadioButtonHandler rdb = new RadioButtonHandler();
        ITRW211.addItemListener(rdb);
        ITRW212.addItemListener(rdb);
        ITRW213.addItemListener(rdb);
        ITRW214.addItemListener(rdb);
        back = new JButton("Back");
        add(back);
        
        ButtonHandler btn = new ButtonHandler();
        
        back.addActionListener(btn);
    }
 
    private class RadioButtonHandler implements ItemListener
    {
        public void itemStateChanged(ItemEvent e)
        {
            if (ITRW211.isSelected())
            {
                ITRW211 my = new ITRW211();
                my.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                my.setSize(900, 700);
                my.setVisible(true);
                dispose();
            }
            if (ITRW212.isSelected())
            {
                ITRW212 my = new ITRW212();
                my.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                my.setSize(900, 700);
                my.setVisible(true);
                dispose();
            }
            if (ITRW213.isSelected())
            {
                ITRW213 my = new ITRW213();
                my.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                my.setSize(1200, 1000);
                my.setVisible(true);
                dispose();
            }
            if (ITRW214.isSelected())
            {
                ITRW214 my = new ITRW214();
                my.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                my.setSize(900, 700);
                my.setVisible(true);
                dispose();
            }
        }
    }
    private class ButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {      
            if (e.getSource() == back)
            {
                //Loggedin in = new Loggedin();
                Loggedin my = new Loggedin();
                my.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                my.setSize(900, 700);
                my.setVisible(true);
                dispose();
            }
            /*if (e.getSource() == next)
            {
                ITRW211 my = new ITRW211();
                my.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                my.setSize(1200, 1000);
                my.setVisible(true);
                dispose();
            }*/
        }
    }
}
