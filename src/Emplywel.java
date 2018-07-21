
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.JOptionPane;


public class Emplywel implements ActionListener
{
    private JFrame f;
    private JPanel p;
    private JButton bnew,breg,bchk,blogout;
    private JLabel lrc,ltitle,lbak;
    private JTextField trc;
    
    
    Emplywel()
    {
        JFrame.setDefaultLookAndFeelDecorated(true);   
        f = new JFrame("Welcome page");
        f.setSize(1366,768);
        //f.setLocation(450,200);
        f.setVisible(true);
        p = new JPanel();
        f.add(p);
        p.setLayout(null);
       // f.setResizable(false);
        
        //Labels
        
        lbak = new JLabel(new ImageIcon("C:\\Users\\NtN\\Downloads\\Pictures\\2017_ford_gt_4-wallpaper-1366x768.jpg"));
        lbak.setBounds(0,0,1366,768);
        p.add(lbak);
        
        ltitle = new JLabel("WELCOME TO THE SERVICE CENTER");
        ltitle.setFont(new Font("Fixedsys",Font.BOLD,25));
        lbak.add(ltitle);
        ltitle.setForeground(Color.WHITE);
        ltitle.setBounds(125,200,650,30);
        Font font = ltitle.getFont(); //For storing title
        Map attributes = font.getAttributes(); //for underline
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON); //For underline
        ltitle.setFont(font.deriveFont(attributes));//For underline
        
        
        lrc = new JLabel("ENTER CUSTOMERS RC NUMBER:");
        lrc.setFont(new Font("Aharoni",Font.BOLD,18));
        lbak.add(lrc);
        lrc.setForeground(Color.WHITE);
        lrc.setBounds(90,300,300,30);
        
      //TextField
        trc = new JTextField();
        lbak.add(trc);
        trc.setFont(new Font("Aharoni",Font.BOLD,18));
        trc.setBounds(400,300,200,30);
               
        //Buttons
        breg =new JButton("Registered Customer");
        lbak.add(breg);
        breg.setBounds(275,430,200,30);
        breg.addActionListener(this);
        
        bnew = new JButton("New Customer");
        lbak.add(bnew);
        bnew.setBounds(275,480,200,30);
        bnew.addActionListener(this);
        
        bchk = new JButton("Check");
        lbak.add(bchk);
        bchk.setBounds(315,370,100,30);
        bchk.addActionListener(this);
        
        blogout = new JButton("Logout");
        lbak.add(blogout);
        blogout.setBounds(780,200,100,30);
        blogout.addActionListener(this);
        
        f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
     }
    
    public static void main(String args[])
    {
         new Emplywel();
       
    }
    public void actionPerformed(ActionEvent e)
    {
         String rcn = trc.getText();
        if(e.getSource()==breg)
        {
           Customer_Details cd;
             try {
                 cd = new Customer_Details();
                  Thread t = new Thread(cd);
             t.start();
             } 
             catch (SQLException ex) {} catch (ParseException ex) { }
            
             f.dispose();
        }
        else if(e.getSource()==bnew)
        {
            try {
                new C_Registration();
            } catch (SQLException ex)
            {} catch (ParseException ex) { }
            f.dispose();
            
        }
        else if(e.getSource()==blogout)
        {
            JOptionPane.showMessageDialog(f,"You r successfully logged out");
             try {
                 new Start();
             } catch (SQLException ex) {}
            f.dispose();
        }
        else
        {
            if(Customer_Dteail_DB.validate(rcn))
            {
                JOptionPane.showMessageDialog(f,"RC number exists welcome REGISTERED USER!");
               Customer_Details cd;
             try {
                 cd = new Customer_Details();
                  Thread t = new Thread(cd);
             t.start();
             
             } 
             catch (SQLException ex) {} catch (ParseException ex) { }
            f.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(f,"RC number  do not exists please register the customer");
                
        }
    }
  }
}    
