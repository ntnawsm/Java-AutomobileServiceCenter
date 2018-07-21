
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Invoice implements ActionListener
{
     private JFrame f;
     private JPanel p;
     private static JLabel ltitle,ltatbp,lbak;
     private static JTextField ta;
     private static JTextArea tadi;
     private JButton bdetails,bfinish,bhome,bback;
     static int amount;
     static String bla;
     static String weehls,wa,ws,en,se,st;
     
     Invoice(int i,String s)
     {
         amount = i;
         bla = s ;
         JFrame.setDefaultLookAndFeelDecorated(true);
        f = new JFrame("Invoice");
        p = new JPanel();
        f.add(p);
        f.setVisible(true);
        f.setSize(1366,768);
        f.setLocation(0,0);
        p.setLayout(null);
        //p.setBackground(Color.WHITE);
        //Lsbel
        lbak = new JLabel(new ImageIcon("C:\\Users\\NitiN\\Downloads\\Pictures\\b.jpg"));
        p.add(lbak);
        lbak.setBounds(0,0,1366,768);
        
        ltitle = new JLabel("INVOICE");
        lbak.add(ltitle);
        ltitle.setFont(new Font("",Font.BOLD,25));
        ltitle.setBounds(650,100,120,60);
        
        
        ltatbp = new JLabel("TOTAL AMOUNT TO BE PAID:");
        lbak.add(ltatbp);
         ltatbp.setFont(new Font("Constantia",Font.BOLD,20));
        ltatbp.setBounds(420,250,400,35);
       
        
        //Text Field
        ta = new JTextField();
        lbak.add(ta);
        ta.setBounds(740,250,200,30);
        ta.setEditable(false);
        
        //Text Area
        
        tadi = new JTextArea();
        String av="IF YOU ARE SATISFIED PLEASE PRESS FINISH"+"\n"+" OTHERWISE FOR DETAILED INVOICE PRESS DETAILS";
        tadi.setText("");
        MarqueePanel mp = new MarqueePanel(av,160);
        tadi.setEditable(false);
        lbak.add(tadi);
        tadi.setForeground(Color.blue);
        tadi.setFont(new Font("Harrington",Font.BOLD,25));
        tadi.setBounds(400,350,700,80);
        
        //Button
        
        bfinish = new JButton("FINISH");
        lbak.add(bfinish);
        bfinish.setFont(new Font("Arohoni",Font.PLAIN,18));
        bfinish.setBounds(550,460,130,30);
        bfinish.addActionListener(this);
        
        bdetails = new JButton("DETAILS");
        lbak.add(bdetails);
        bdetails.setFont(new Font("Arohoni",Font.PLAIN,18));
        bdetails.setBounds(750,460,130,30);
        bdetails.addActionListener(this);
       
        
        bhome = new JButton("HOME");
        lbak.add(bhome);
        bhome.setBounds(1150,55,120,30);
        bhome.addActionListener(this);
        
        bback = new JButton("BACK");
        lbak.add(bback);
        bback.setBounds(55,55,120,30);
        bback.addActionListener(this);
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ta.setText("Rs. " +amount);
     }
      
     
     public static void main(String args[])
     {
       
        new Invoice(amount,bla);
         System.out.print(amount); 
         System.out.print(weehls);System.out.print(wa);System.out.print(ws);
         System.out.print(en);System.out.print(se); System.out.print(st);
      }
     //Actions
     public void actionPerformed(ActionEvent e)
     {
         if(e.getSource()==bfinish)
         {
             JOptionPane.showMessageDialog(f,"Thanx for ur Visit we will be egarly waiting for you"); 
            new Emplywel();
         }
         else if(e.getSource()==bdetails)
         {
             System.out.print(e.getSource()==bdetails);
             
             if(ta.getText().equals("Rs. 1000"))
                     {
                       weehls= " 200";
                       wa = " 100";
                       ws=" 150";
                       en=" 350";
                       se=" 100";
                       st=" 100";
                        
                     }
             else if(ta.getText().equals("Rs. 900"))
                     {
                       weehls= " 200";
                       wa = " 0";
                       ws=" 150";
                       en=" 350";
                       se=" 100";
                       st=" 100";
                        
                     }
             else if(ta.getText().equals("Rs. 800"))
                     {
                       weehls= " 0";
                       wa = " 100";
                       ws=" 150";
                       en=" 350";
                       se=" 100";
                       st=" 100";
                        
                     }
             else if(ta.getText().equals("Rs. 350"))
                     {
                       weehls= " 0";
                       wa = " 0";
                       ws=" 0";
                       en=" 350";
                       se=" 0";
                       st=" 0";
                        
                     }
            
             new Dinvoice(weehls,wa,ws,en,se,st); 
             f.dispose();
         }
         else if(e.getSource()==bback)
         {
             new ExtraServic();
             f.dispose();
         }
         else
         {
             
           new Emplywel();
            f.dispose();
            
         }
     }
}     
     


   