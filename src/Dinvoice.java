

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;


public class Dinvoice implements ActionListener
{
    private JFrame f;
    private JPanel p;
    private JLabel ldetail,lwheels,lwax,lwash,lengine,lseats,lsteer,lbak;
    private JTextField twheels,twax,twash,tengine,tseats,tsteer;
    private JButton bfinish,bhome;
    static String weehls,wa,ws,en,se,st;
    
    Dinvoice(String whel,String wax,String was,String eng,String seat,String steer)
    {
        weehls = whel;wa = wax;ws =was;en=eng;se=seat;st=steer;
        JFrame.setDefaultLookAndFeelDecorated(true);
        f = new JFrame();
        p = new JPanel();
        f.add(p);
        f.setVisible(true);
        f.setSize(1366,768);
        f.setLocation(0,0);
        p.setLayout(null);
        
        //Labels
        
        lbak = new JLabel(new ImageIcon("C:\\Users\\NitiN\\Downloads\\Pictures\\payday_2_dallas_heist_art_99969_1366x768.jpg"));
        p.add(lbak);
        lbak.setBounds(0,0,1366,768);
        
        ldetail = new JLabel("DETAILED INVOICE");
        ldetail.setFont(new Font("Arohoni",Font.CENTER_BASELINE,25));
        lbak.add(ldetail);
        ldetail.setForeground(Color.white);
        ldetail.setBounds(200,150,300,30);
        
        lwheels = new JLabel("WHEELS");
        lbak.add(lwheels);
        lwheels.setFont(new Font("Arohoni",Font.PLAIN,18));
        lwheels.setForeground(Color.white);
        lwheels.setBounds(170,240,100,30);
        
        lwax = new JLabel("WAXING");
        lbak.add(lwax);
        lwax.setFont(new Font("Arohoni",Font.PLAIN,18));
        lwax.setForeground(Color.white);
        lwax.setBounds(170,300,100,30);
        
        lwash = new JLabel("WASHING");
        lbak.add(lwash);
        lwash.setFont(new Font("Arohoni",Font.PLAIN,18));
        lwash.setForeground(Color.white);
        lwash.setBounds(170,360,100,30);
        
        lengine = new JLabel("ENGINE");
        lbak.add(lengine);
        lengine.setFont(new Font("Arohoni",Font.PLAIN,18));
        lengine.setForeground(Color.white);
        lengine.setBounds(170,420,100,30);
        
        lseats = new JLabel("SEATS");
        lseats.setFont(new Font("Arohoni",Font.PLAIN,18));
        lbak.add(lseats);
        lseats.setForeground(Color.white);
        lseats.setBounds(170,480,100,30);
        
        lsteer = new JLabel("STEERING");
        lbak.add(lsteer);
        lsteer.setFont(new Font("Arohoni",Font.PLAIN,18));
        lsteer.setForeground(Color.white);
        lsteer.setBounds(170,540,100,30);
        
        //Text Fileds
        twheels = new JTextField();
        lbak.add(twheels);
        twheels.setFont(new Font("",Font.PLAIN,18));
        twheels.setBounds(300,240,150,30);
        twheels.setEditable(false);
        
        twax = new JTextField();
        lbak.add(twax);
        twax.setFont(new Font("",Font.PLAIN,18));
        twax.setBounds(300,300,150,30);
        twax.setEditable(false);
        
        twash = new JTextField();
        lbak.add(twash);
        twash.setFont(new Font("",Font.PLAIN,18));
        twash.setBounds(300,360,150,30);
        twash.setEditable(false);
        
        tengine = new JTextField();
        lbak.add(tengine);
        tengine.setFont(new Font("",Font.PLAIN,18));
        tengine.setBounds(300,420,150,30);
        tengine.setEditable(false);
        
        tseats = new JTextField();
        lbak.add(tseats);
        tseats.setFont(new Font("",Font.PLAIN,18));
        tseats.setBounds(300,480,150,30);
        tseats.setEditable(false);
        
        tsteer = new JTextField();
        lbak.add(tsteer);
        tsteer.setFont(new Font("",Font.PLAIN,18));
        tsteer.setBounds(300,540,150,30);
        tsteer.setEditable(false);
        
        //Buttons
        
        bfinish = new JButton("Finish");
        lbak.add(bfinish);
        bfinish.setBounds(245,630,100,30);
        bfinish.addActionListener(this);
        
        bhome = new JButton("HOME");
        lbak.add(bhome);
        bhome.setBounds(65,90,100,30);
        bhome.addActionListener(this);
        twheels.setText("Rs. " +  whel);
        twax.setText("Rs. " +  wax);
        twash.setText("Rs. " +  was);
        tengine.setText("Rs. " +  eng);
        tseats.setText("Rs. " +  seat);
        tsteer.setText("Rs. " +  steer);
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[])
    {
        new Dinvoice(weehls,wa,ws,en,se,st);
        System.out.print(weehls);
         System.out.print(wa);
          System.out.print(ws);
           System.out.print(en);
            System.out.print(se); System.out.print(st);
            
    }

    //Actions
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bfinish)
        {   
            JOptionPane.showMessageDialog(f,"Thanx for ur Visit we will be egarly waiting for you"); 
            f.dispose();
            new Emplywel();
        }   
        else
        {
          f.dispose();
          new Emplywel();  
        
        }
        
    }
    
    
}
