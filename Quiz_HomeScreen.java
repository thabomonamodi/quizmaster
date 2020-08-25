

   
/**
 * Write a description of class Gui here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.awt.image.BufferedImage;
import java.awt.BorderLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

public class Quiz_HomeScreen extends JFrame
{
    //
    private JButton logoffButton; 
    private JPanel main_panel;
    private JPanel top_panel;
    private JPanel bottom_panel;
    
    private JTextArea textArea;
    private JButton btncontinue;
    private JLabel logoLabel;
    
    public Quiz_HomeScreen()
    {
        super("Ex_Quiz");
        setLayout(new BorderLayout());
        ButtonHandler ButtonHandler = new ButtonHandler();        
        main_panel = new JPanel(new BorderLayout());
        
        top_panel = new JPanel(new BorderLayout());
        top_panel.setBackground(Color.white);
        //textArea = new JTextArea("||");
        ImageIcon background = new ImageIcon("Stock.jpg");
        //background.ize(JFrame.MAXIMIZED_BOTH);
        JLabel label = new JLabel(background);
        //textArea.add(label);
        //add(label);
        top_panel.add(label );
        bottom_panel = new JPanel( new BorderLayout());
        btncontinue = new JButton("<<<CONTINUE>>>");
        btncontinue.setForeground(Color.red);
        btncontinue.setBackground(Color.black);
        btncontinue.addActionListener(ButtonHandler);
        bottom_panel.add( btncontinue );
                
        main_panel.add( top_panel, BorderLayout.NORTH );
        main_panel.add(bottom_panel, BorderLayout.SOUTH);
        
        add(main_panel);
        
        ButtonHandler handler = new ButtonHandler();
        //read_Button.addActionListener(handler);
    }
    
    private class ButtonHandler implements ActionListener  
    {
        public void actionPerformed(ActionEvent event)
        {                 
           if (event.getSource() == btncontinue)   
           {  
                    //setVisible(true);
                    //Gui start = new Gui();
                    ProgressWindow progress = new ProgressWindow();
                    progress.setVisible(true);
                    progress.setSize(450, 160);
                    progress.setResizable(false);
                    progress.setLocation(480, 340);
                    dispose();
                    //setVisible(false);
           }
        }
    }
}


