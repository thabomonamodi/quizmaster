
/**
 * Write a description of class ITRW214 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Scanner;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
public class ITRW214 extends JFrame
{
    private Container pane;

    private JRadioButton answer1 = new JRadioButton();
    private JRadioButton answer2 = new JRadioButton();
    private JRadioButton answer3 = new JRadioButton();

    private JButton back = new JButton();
    public ITRW214()
    {
        super("Ex_Quiz");
          setLayout(null);
        Details [] arrQuiz = new Details[100];
        int count = 0;
        
        try
        {
            Scanner scan = new Scanner(new FileReader("ITRW214.txt"));
            while (scan.hasNextLine())
            {
                String line = scan.nextLine();
                String [] arrInfo = line.split(" & ");
                
                String username = arrInfo[0];
                int points = Integer.parseInt(arrInfo[1]);

                arrQuiz[count] = new Details();
                count++;
            }
            scan.close();
        }
        catch (FileNotFoundException error)
        {
            JOptionPane.showMessageDialog(null,"No new questions");
        }
        pane = getContentPane();
        initializeComponents();
    }

    private void initializeComponents()
    {
           // setLayout(null);
        answer1 = new JRadioButton("Option 1",true);
        answer2 = new JRadioButton("Option 2",true);
        answer3 = new JRadioButton("Option 3",true);

        RadioButtonHandler bhandler = new RadioButtonHandler();
        answer1.addItemListener(bhandler);
        answer2.addItemListener(bhandler);
        answer3.addItemListener(bhandler);

        answer1.setLocation(16,150);
        answer2.setLocation(16,180);
        answer3.setLocation(16,220);
        
        answer1.setSize(90,150);
        answer1.setSize(90,150);
        answer1.setSize(90,150);
        
        back = new JButton("Back");
        back.setBounds(500,800,100,35);
        
        ButtonHandler btn = new ButtonHandler();
        
        back.addActionListener(btn);
        
        pane.add(answer1);
        pane.add(answer2);
        pane.add(answer3);
        pane.add(back);
        setVisible(false);
    }
    private class RadioButtonHandler implements ItemListener
    {
        public void itemStateChanged(ItemEvent e)
        {
            if (answer1.isSelected())
            {
                setVisible(true);
            }
            if (answer2.isSelected())
            {
                setVisible(true);
            }
            if (answer3.isSelected())
            {
                setVisible(true);
            }
        }
    }
    private class ButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == back)
            {
                Question my = new Question();
                my.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                my.setSize(900, 700);
                my.setVisible(true);
                dispose();
            }
        }
    }
}
