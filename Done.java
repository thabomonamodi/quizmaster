
/**
 * Write a description of class Done here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Container;
public class Done extends JFrame
{
    private Container pane;

    private JLabel lblmsg;
    private JButton exit;
    public Done()
    {
        super("Ex_Quiz");
        pane = getContentPane();
        intiliazeComponents();
    }


    private void intiliazeComponents()
    {
        lblmsg = new JLabel("Thank you for participating");
        exit = new JButton("Exit");
        ExitButtonHandler exitButton = new ExitButtonHandler();
        exit.addActionListener(exitButton);

        pane = getContentPane();
        pane.setLayout(null);

        lblmsg.setLocation(79,72);
        exit.setLocation(149,207);

        lblmsg.setSize(80,20);
        exit.setSize(75,20);
        
        pane.add(lblmsg);
        pane.add(exit);
        setVisible(false);
    }
    public class ExitButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == exit)
            {
                System.exit(0);
            }
        }
    }
}
