
/**
 * Write a description of class Register_Form here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.io.BufferedWriter;;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class Register_Form extends JFrame
{
    private JLabel lblusername,lblemail;
    private JLabel lblpassword1,lblconfirm;
    private JPasswordField passwordField,confirmField;
    private JTextField JTextusername2,JTextemail1;
    private JRadioButton remember, agree, subscribe;
    private JTextArea outputJTextArea;
    private JButton back, register;
    private ButtonGroup radioGroup;
    private JRadioButton lecture, student;
    private boolean lecture1;
    private boolean student1;

    private String name;
    private String stnumber;
    private int points;
    private String player;

    private Container pane;
    //ArrayList <Student> student = new <Student>ArrayList();
    //ArrayList <Lecture> lectures = new <Lecture>ArrayList();
    private Quizable [] quiz = new Quizable[100];
    private int count;
    public Register_Form()
    {
        super("Ex_Quiz");
        setLayout(null);
        pane = getContentPane();
        initializeComponents();

    }

    private void initializeComponents()
    {

        lblemail = new JLabel("E-mail address :", SwingConstants.RIGHT);
        lblusername = new JLabel("Username :", SwingConstants.RIGHT);
        lblpassword1 = new JLabel("Password :", SwingConstants.RIGHT);
        lblconfirm = new JLabel("Confirm Password :", SwingConstants.RIGHT);

        lecture = new JRadioButton("Lecture",false);
        add(lecture);
        lecture.setBounds(350,130,100,50);
        lecture.setBackground(Color.green);

        student = new JRadioButton("Student",false);
        add(student);
        student.setBounds(450,130,150,50);
        student.setBackground(Color.green);

        RadioButtonHandler check = new RadioButtonHandler();
        lecture.addItemListener(check);
        student.addItemListener(check);

        radioGroup = new ButtonGroup();
        radioGroup.add(lecture);
        radioGroup.add(student);

        JTextusername2 = new JTextField(20);
        remember = new JRadioButton();
        agree = new JRadioButton();
        subscribe = new JRadioButton();
        passwordField = new JPasswordField();
        confirmField = new JPasswordField();
        JTextemail1 = new JTextField(20);

        register = new JButton("Register");
        back = new JButton("Back");

        pane = getContentPane();
        pane.setLayout(null);

        register.setLocation(200,150);
        back.setLocation(200,400);
        lblusername.setLocation(200,200);
        JTextusername2.setLocation(350,200);
        lblemail.setLocation(200,210);
        JTextemail1.setLocation(350,240);
        lblpassword1.setLocation(200,280);
        passwordField.setLocation(350,280);
        lblconfirm.setLocation(200,280);
        confirmField.setLocation(350,320);

        register.setSize(90,20);
        back.setSize(80,20);
        lblusername.setSize(82,32);
        JTextusername2.setSize(140,25);
        lblemail.setSize(102,92);
        JTextemail1.setSize(140,25);
        lblpassword1.setSize(82,32);
        passwordField.setSize(140,25);
        lblconfirm.setSize(122,102);
        confirmField.setSize(140,25);

        pane.add(register);
        pane.add(back);
        pane.add(lblusername);
        pane.add(JTextusername2);
        pane.add(lblemail);
        pane.add(JTextemail1);
        pane.add(lblpassword1);
        pane.add(passwordField);
        pane.add(lblconfirm);
        pane.add(confirmField);
        pane.add(agree);
        setVisible(true);

        register.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {

                    if (e.getSource() == register)
                    {
                        
                        if ((student1 == true))
                        {
                            Student learners = new Student(name,stnumber,player,points);
                            JOptionPane.showMessageDialog(null,"You are logged in as a student");
                            Loggedin in = new Loggedin();
                            in.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            in.setSize(900, 700);
                            in.setVisible(true);
                            dispose();
                        }
                        else if ((lecture1 == true))
                        {
                            Lecture teachers = new Lecture(name,stnumber,player);
                            JOptionPane.showMessageDialog(null,"You are logged in as a lecture");
                            Details my = new Details();
                            my.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            my.setSize(1500, 1000);
                            my.setVisible(true);
                            dispose();
                        }
                        StoreFile("Participants",quiz, count);
                        JOptionPane.showMessageDialog(null,"Data has been saved");

                    }
                }
            });
        back.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    if (e.getSource() == back)
                    {
                        login my = new login();
                        my.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        my.setSize(900, 700);
                        my.setVisible(true);
                        dispose();
                    }
                }
            });
    }
    private class RadioButtonHandler implements ItemListener
    {    
        public void itemStateChanged(ItemEvent event)
        {
            if (lecture.isSelected()== true)
            {
                lecture1 = true;
            }
            if (student.isSelected()== true)
            {
                student1 = true;
            }

        }
    }

    public static void StoreFile(String filename, Quizable [] arrQuiz, int Count)
    {
        try
        {
            PrintWriter output = new PrintWriter(filename + "txt");
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
        /*try
        {
        FileWriter file = new FileWriter("register.txt");

        BufferedWriter buff = new BufferedWriter(file);
        PrintWriter print = new PrintWriter(buff);

        for (int t = 0; t < student.size(); t++)
        {
        print.println(student.get(t).getName()+" "+student.get(t).getPassword());
        }
        for (int t = 0; t < lecture.size(); t++)
        {
        print.println(lecture.get(t).getName()+" "+lecture.get(t).getPassword());
        }
        print.close();
        }
        catch (Exception err)
        {
        JOptionPane.showMessageDialog(null,"File could not be saved!");
        }*/
    }
}