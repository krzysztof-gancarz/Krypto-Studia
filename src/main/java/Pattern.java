import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pattern extends JFrame
{  private JTextField Input = new JTextField();

   public void init()
   {  Input.addActionListener(new TextFieldEx());
      this.getContentPane().add(Input);
   }
   
   private class TextFieldEx implements ActionListener
   {  public void actionPerformed(ActionEvent evt)
      {  
         System.out.println("hi");
      }
   }
}