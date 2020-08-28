
/**
 * Write a description of class ITRW211 here.
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
public class ITRW211 extends JFrame
{
    private Container pane;

    private JLabel lblq1,lblq2,lblq3,lblq4,lblq5;
    private String question1,question2,question3,question4,question5;
    
    private JRadioButton answer1 = new JRadioButton();
    private JRadioButton answer2 = new JRadioButton();
    private JRadioButton answer3 = new JRadioButton();

    private JButton back = new JButton();
    public ITRW211()
    {
        super("Ex_Quiz");
        setLayout(null);
        Details [] arrQuiz = new Details[100];
        int count = 0;

        /*try
        {
        Scanner scan = new Scanner(new FileReader("ITRW211.txt"));
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
        }*/
        pane = getContentPane();
        initializeComponents();

    }

    private void initializeComponents()
    {
        answer1 = new JRadioButton("MenuIem",true);
        answer2 = new JRadioButton("ComboBox",true);
        answer3 = new JRadioButton("All of the above",true);

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

        ButtonHandler btn = new ButtonHandler();
        back.addActionListener(btn);
        back.setBounds(500,800,100,35);

        int q1;
        int score =0;
        Scanner input = new Scanner(System.in);
        question1 = JOptionPane.showInputDialog(null, "1. The MenuStrip control that is used to create menu can contain:", JOptionPane.QUESTION_MESSAGE);
        //menuItem,comboBox,textBox
        question2 = JOptionPane.showInputDialog(null, "2. to which namespace does the File class belong:", JOptionPane.QUESTION_MESSAGE);
        //System.IO
        question3 = JOptionPane.showInputDialog(null, "3. MDI is an abbreviation for:", JOptionPane.QUESTION_MESSAGE);
        //multiple document interface
        question4 = JOptionPane.showInputDialog(null, "4. When you are done processing a text file, you should", JOptionPane.QUESTION_MESSAGE);
        //call the Close()method.
        question5 = JOptionPane.showInputDialog(null, "5. Which class allows you to use the Write() and WriteLine() method to write data to a text file?", JOptionPane.QUESTION_MESSAGE);
        pane.add(lblq1);
        pane.add(answer1);
        pane.add(answer2);
        pane.add(answer3);
        setVisible(false);
    }
    private class RadioButtonHandler implements ItemListener
    {
        public void itemStateChanged(ItemEvent e)
        {
            if (answer1.isSelected())
            {
                setVisible(true);
                answer2.setVisible(false);
                answer3.setVisible(false);
            }
            if (answer2.isSelected())
            {
                setVisible(true);
                answer1.setVisible(false);
                answer3.setVisible(false);
            }
            if (answer3.isSelected())
            {
                setVisible(true);
                answer1.setVisible(false);
                answer2.setVisible(false);
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
