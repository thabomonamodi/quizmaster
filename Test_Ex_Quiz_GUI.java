
/**
 * Write a description of class TestEx_Quiz_GUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.IOException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
public class Test_Ex_Quiz_GUI
{
   public static void main(String args[])
   {
      try
      {
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      }
      catch (Exception look)
      {
          JOptionPane.showMessageDialog(null,"System failed!");
      }
      Quiz_HomeScreen textArea = new Quiz_HomeScreen();
      
      textArea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      textArea.setSize(900,700);
      //textArea.setExtendedState(JFrame.MAXIMIZED_BOTH);
      textArea.setVisible(true);
      
   }
}
