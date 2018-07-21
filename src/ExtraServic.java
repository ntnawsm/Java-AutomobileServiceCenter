
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
//import static nneo.Invoice.st;

public class ExtraServic implements ActionListener
{
   private JFrame f;
   private JPanel p;
   private JLabel lextra,lbak,linfo;
   private JRadioButton cb1,cb2,cb3,cb4;
   private JButton bnext,bhome,bback;
   //private MarqueePanel1 mp;
   int amount;
   String s;
   
   ExtraServic()
   {
       JFrame.setDefaultLookAndFeelDecorated(true);
       f = new JFrame("EXTRA SERVICE");
       p = new JPanel();
       f.add(p);
       f.setVisible(true);
       f.setSize(1366,768);
       f.setLocation(0,0);
       p.setLayout(null);
       p.setBackground(Color.WHITE);
       
       //Label
       
    /*   mp = new MarqueePanel1(); 
       p.add(mp);*/
      
      /* lbak = new JLabel(new ImageIcon("C:\\Users\\NitiN\\Downloads\\artsfon.com-55793.jpg"));
       mp.add(lbak);
       lbak.setBounds(0,500,1366,268);*/
       
       
       lextra = new JLabel("SELECT A PACK FOR YOUR SERVICE");
       lextra.setFont(new Font("Arohoni",Font.BOLD,25));
       p.add(lextra);
       lextra.setBounds(450,100,500,30);
       
       linfo = new JLabel();
       linfo.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,22));
       p.add(linfo);
       linfo.setBounds(350,380,800,350);
       
       
        //checkbox       
        ButtonGroup cb = new ButtonGroup();
        
        cb1 = new JRadioButton("PLATINUM");cb.add(cb1);p.add(cb1);
        cb1.setBackground(Color.WHITE);
        cb1.setFont(new Font("",Font.BOLD,18));
        cb1.setBounds(550,230,190,30);
        
        cb1.addActionListener(this);
        
	cb2 = new JRadioButton("GOLD");cb.add(cb2);p.add(cb2);
        cb2.setBackground(Color.WHITE);
        cb2.setFont(new Font("",Font.BOLD,18));
        cb2.setBounds(550,270,190,30);
        cb2.addActionListener(this);
        
	cb3 = new JRadioButton("SILVER");cb.add(cb3);p.add(cb3);
        cb3.setBackground(Color.WHITE);
        cb3.setFont(new Font("",Font.BOLD,18));
        cb3.setBounds(550,310,190,30);
        cb3.addActionListener(this);
        
        cb4 = new JRadioButton("BRONZE");cb.add(cb4);p.add(cb4);
        cb4.setBackground(Color.WHITE);
        cb4.setFont(new Font("",Font.BOLD,18));
        cb4.setBounds(550,350,190,30);
        cb4.addActionListener(this);
        
        
        
        //Button
        bnext = new JButton("NEXT");
        p.add(bnext);
        bnext.setBounds(750,290,100,30);
        bnext.addActionListener(this);
        
        bhome = new JButton("HOME");
        p.add(bhome);
        bhome.setBounds(1150,55,80,30);
        bhome.addActionListener(this);
        
        bback = new JButton("BACK");
        p.add(bback);
        bback.setBounds(55,55,120,30);
        bback.addActionListener(this);
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   public static void main(String args[])
   {
       new ExtraServic();
   }
   //ACtions
    @Override
        public void actionPerformed(ActionEvent e)
        {
           
            //System.out.print(e.getSource()==bnext);
          if(e.getSource()==bnext)
          {
              System.out.print(amount);
             System.out.print(s);
              
               
              
              if(cb1.isSelected()==true||cb2.isSelected()==true||cb3.isSelected()==true||cb4.isSelected() == true)
              {
                   new Invoice(amount,s);
                   f.dispose();
                  
              //Invoice.Total_Amount(1000);
              }
              else
              {
                  JOptionPane.showMessageDialog(null,"Please Select A pack first");
              }/*
              else if(e.getSource()==cb2)
              {
                  new Invoice(800);
              // Invoice.Total_Amount(800);   
              }
              else if(e.getSource()==cb3)
              {
                  new Invoice(500);
              // Invoice.Total_Amount(500);   
              }
              else if(e.getSource()==cb4)
              {
                  new Invoice(300);
              // Invoice.Total_Amount(300);   
              }
              else
              {
                  JOptionPane.showMessageDialog(null,"no option selected");
              }*/
              
          }
          else if (e.getSource()==bhome)
          {
             new Emplywel();
              f.dispose();
              
          }
          else if(e.getSource()==bback)
          {
              Customer_Details cd;
              try {
                  cd = new Customer_Details();
                   Thread t = new Thread(cd);
                   t.start();
              } catch (SQLException ex) {
                  
              } catch (ParseException ex) {
                  
              }
             
            
             f.dispose();
          }
          else if(e.getSource()==cb1)
          {
              linfo.setText("This Pack avails you the premiun servicing of your vehicle");
              //st="₹ ";
              amount= 1000;
              
              
          }
          else if(e.getSource()==cb2)
          {
              linfo.setText("This Pack avails servicing of your vehicle except Waxing");
              amount= 900;
              //st="₹ ";
          }
          else if(e.getSource()==cb3)
          {
              linfo.setText("This Pack avails servicing of your vehicle except Wheels");
              amount= 800;
             // st="₹ ";
          }
          else
          {
              linfo.setText("This Pack avails servicing of only Engine of your vehicle");
              amount= 350;
             // st="₹ ";
          }
         
        }
 }
