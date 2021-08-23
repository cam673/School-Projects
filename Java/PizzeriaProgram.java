//Christopher Masferrer
//1266556
//Assignment 9

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;


public class PizzeriaProgram
{
   public static void main( String [] args )
   {
      String fName = JOptionPane.showInputDialog("Enter your first name:");
         
      JOptionPane.showMessageDialog(null, "Hello ", fName,
         JOptionPane.PLAIN_MESSAGE);
   }
}