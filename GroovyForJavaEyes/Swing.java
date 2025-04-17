/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Swing {
  public static void main(String[] args) {
    final JFrame frame = new JFrame();
    JButton button = new JButton("click");
    frame.getContentPane().add(button);
    
    // Java code
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        JOptionPane.showMessageDialog(frame, "You clicked!");
      }
    });
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
