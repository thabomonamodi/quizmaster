
/**
 * Write a description of class Answer here.
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
public class Answer extends JFrame
{
    public Answer()
    {
        super("Ex_Quiz");
        Details [] arrQuiz = new Details[100];
        int count = 0;

        try
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
        }
    }
}
