
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

public class Customer_Details implements ActionListener,Runnable
{
     Connection con;
     PreparedStatement ps;
     ResultSet rs;
     private JFrame f;
     private JPanel p;
     private JTextField tcname,tcrcnum,tctype,tcphone,tcaddress,tcdor,tcvor,ttime,tcode;
     private JLabel ltitle,lname,lrcnum,ltype,lphone,laddress,ldor,lvor,lmsg,lbak,ldate;
     private JButton bnext,bupdate,bhome,bclear,bedit; 
     private JComboBox cb;
     
    
     public void run()
    {
        while(true)
        {
            Date d = new Date();
            if(d.getHours()>11)
            {
            ttime.setText("TIME: "+d.getHours()+":"+d.getMinutes()+":"+d.getSeconds()+"  PM");
            }
            else
            {
            ttime.setText("TIME: "+d.getHours()+":"+d.getMinutes()+":"+d.getSeconds()+"  AM");    
            }
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException | NullPointerException ae)
            {}
        }
    }
    
    Customer_Details() throws SQLException, ParseException
    {
        
            
        JFrame.setDefaultLookAndFeelDecorated(true);
        f = new JFrame("Details");
        p = new JPanel();
        f.add(p);
        f.setLocation(0,0);
        f.setSize(1366,768);
        f.setVisible(true);
        p.setLayout(null);
        
       
                
        
        //labels
        
        lbak = new JLabel(new ImageIcon("C:\\Users\\NtN\\Downloads\\Pictures\\min.jpg"));
        p.add(lbak);
        lbak.setBounds(0,0,1366,768);
        
        ltitle = new JLabel("CUSTOMER DETAILS");
        ltitle.setFont(new Font("Ahraoni",Font.BOLD,25));
        lbak.add(ltitle);
        ltitle.setBounds(150,100,270,30);
        
        lname = new JLabel("RC NUMBER:");
        lbak.add(lname);
        lname.setFont(new Font("Fixedsys",Font.BOLD,18));
        lname.setBounds(50,230,300,30);
        
        lrcnum = new JLabel("NAME");
        lbak.add(lrcnum);
        lrcnum.setFont(new Font("Fixedsys",Font.BOLD,18));
        lrcnum.setBounds(50,280,300,30);
        
        ltype = new JLabel("VEHICAL TYPE:");
        lbak.add(ltype);
        ltype.setFont(new Font("Fixedsys",Font.BOLD,18));
        ltype.setBounds(50,330,300,30);
        
        lphone = new JLabel("MOBILE NUMBER:");
        lbak.add(lphone);
        lphone.setFont(new Font("Fixedsys",Font.BOLD,18));
        lphone.setBounds(50,380,300,30);
        
        laddress = new JLabel("ADDRESS:");
        lbak.add(laddress);
        laddress.setFont(new Font("Fixedsys",Font.BOLD,18));
        laddress.setBounds(50,430,300,30);
        
        ldor = new JLabel("DATE OF REGISTRATION:");
        lbak.add(ldor);
        ldor.setFont(new Font("Fixedsys",Font.BOLD,18));
        ldor.setBounds(50,480,300,30);
        
        lvor = new JLabel("VALIDITY OF REGISTRATION:");
        lbak.add(lvor);
        lvor.setFont(new Font("Fixedsys",Font.BOLD,18));
        lvor.setBounds(50,530,300,30);
        
        ldate = new JLabel();
        Date d = new Date();
        ldate.setText("DATE: " + d.getDate()+"/"+(d.getMonth()+1)+"/"+(d.getYear()+1900));
        ldate.setForeground(Color.BLACK);
        ldate.setFont(new Font("Fixedsys",Font.BOLD,18));
        lbak.add(ldate);
        ldate.setBounds(20,170,300,30);
        
      /*  lmsg = new JLabel("If ur details are correct press next other wise make changes and press update");
        lbak.add(lmsg);
        lmsg.setBounds(50,390,600,20);
        lmsg.setFont(new Font("Ahraoni",Font.BOLD,16));
        Color custumclor = new Color(246,0,0); // using RGB code 
        lmsg.setForeground(custumclor);*/
        
        //Text Fields
        
        
       
        tcrcnum = new JTextField();
        lbak.add(tcrcnum);
        tcrcnum.setFont(new Font("",Font.BOLD,18));
        tcrcnum.setBounds(360,230,90,30);
        tcrcnum.setEditable(false);
        
        tcname = new JTextField();
        lbak.add(tcname);
        tcname.setFont(new Font("",Font.BOLD,18));
        tcname.setBounds(360,280,200,30);
        tcname.setEditable(false);
        tcname.addKeyListener(new KeyAdapter()
        {
        public void keyTyped(KeyEvent ke)
        {
            char ch = ke.getKeyChar();
            if(Character.isDigit(ch))
            {
		tcname.setText("");
		JOptionPane.showMessageDialog(null, "WRONG! input");
            }
        }
        });
        
        tctype = new JTextField();
        lbak.add(tctype);
        tctype.setFont(new Font("",Font.BOLD,18));
        tctype.setBounds(360,330,200,30);
        tctype.setEditable(false);
        
        tcode = new JTextField("+91");
        lbak.add(tcode);
        tcode.setFont(new Font("",Font.BOLD,18));
        tcode.setBounds(360,380,40,30);
        tcode.setEditable(false);
        
        //MaskFormatter form2 = new MaskFormatter("##########"); 
       NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        format.setMaximumIntegerDigits(14);
        tcphone = new JFormattedTextField(formatter);
        //tcphone = new JFormattedTextField(form2);
        lbak.add(tcphone);
        tcphone.setFont(new Font("",Font.BOLD,18));
        tcphone.setBounds(400,380,160,30);
        tcphone.setEditable(false);
        
        tcaddress = new JTextField();
        lbak.add(tcaddress);
        tcaddress.setFont(new Font("",Font.BOLD,18));
        tcaddress.setBounds(360,430,200,30);
        tcaddress.setEditable(false);
        
        //MaskFormatter form = new MaskFormatter("##/##/####");
        tcdor = new JTextField();
        lbak.add(tcdor);
        tcdor.setFont(new Font("",Font.BOLD,18));
        tcdor.setBounds(360,480,200,30);
        tcdor.setEditable(false);
        
       // MaskFormatter form1 = new MaskFormatter("##/##/####");        
        tcvor = new JTextField();
        lbak.add(tcvor);
        tcvor.setFont(new Font("",Font.BOLD,18));
        tcvor.setBounds(360,530,200,30);
        tcvor.setEditable(false);
        
        ttime = new JTextField();
        lbak.add(ttime);
        ttime.setBackground(Color.WHITE);
        ttime.setEditable(false);
        ttime.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,18));
        ttime.setBounds(430,170,180,30);

        
       //buttons
        
        bnext = new JButton("NEXT");
        lbak.add(bnext);
        bnext.setBounds(50,590,100,30);
        bnext.addActionListener(this);
        
        bupdate = new JButton("UPDATE");
        lbak.add(bupdate);
        bupdate.setBounds(180,590,100,30);
        bupdate.addActionListener(this);
        bupdate.setEnabled(false);
        
        bclear = new JButton("CLEAR");
        lbak.add(bclear);
        bclear.setBounds(310,590,100,30);
        bclear.addActionListener(this);
        
        bhome = new JButton("HOME");
        lbak.add(bhome);
        bhome.setBounds(20,50,120,30);
        bhome.addActionListener(this);
        
        bedit = new JButton("EDIT");
        lbak.add(bedit);
        bedit.setBounds(440,590,120,30);
        bedit.addActionListener(this);
        
        //Combo box
        cb = new JComboBox();
        lbak.add(cb);
        updateCombo();
        cb.setBounds(460,230,95,30);
        cb.addActionListener(this);
        
      // f.getContentPane().setBackground(new Color(255,255,255));
     
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   
    }
    
    
    
    public static void main (String args[]) throws SQLException, ParseException
    {
        Customer_Details cd = new Customer_Details();
        Thread t = new Thread(cd);
        t.start();
    }
    public void updateCombo() throws SQLException
    {
        try
        {
            con = DB.getConnection();
            ps = con.prepareStatement("Select c_rc from custmr");
            rs = ps.executeQuery();
            cb.removeAllItems();
            while(rs.next())
            {
                cb.addItem(rs.getString("c_rc"));
            }
        }
        catch(Exception e)
        {}
    }
    void clear()
    { 
       tcrcnum.setText("");
       tcname.setText("");
       tctype.setText("");
       tcphone.setText("");
       tcaddress.setText("");
       tcdor.setText("");
       tcvor.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        /*JOptionPane pane = new JOptionPane();
        JDialog dialod = pane.createDialog("If ur details are correct please click next"+"/n"+"otherwise make changes and click update");
        dialod.setLocation(10,10);*/
       if(e.getSource()==bhome)
       {
          new Emplywel();
         f.dispose();
       }
       else if(e.getSource()==bedit)
       {
           tcrcnum.setEditable(true);
           tcname.setEditable(true);
           tctype.setEditable(true);
           tcphone.setEditable(true);
           tcaddress.setEditable(true);
          // tcdor.setEditable(true);
          // tcvor.setEditable(true);
          bupdate.setEnabled(true);
       }
       else if(e.getSource()==bnext)
       { String rcno=tcrcnum.getText();
            String name=tcname.getText();
            String vt=tctype.getText();
            String phone=tcphone.getText();
	    String address=tcaddress.getText();
            String dor = tcdor.getText();
            String vor=tcvor.getText();
	    boolean valid=false;
            if(rcno.equals(""))
	    {
                JOptionPane.showMessageDialog(f,"please fill RC number");
	    }
            else if(name.equals("") || name.length()<2)
	    {
                tcname.setText("");
                JOptionPane.showMessageDialog(f,"Customer Name must be of atleast 2 letters");
	    }
            else if(vt.equals(""))
            {
                JOptionPane.showMessageDialog(f,"please fill Vehical type");
	    }
            else if(phone.replaceAll("\u00A0","").length()!=13)
            {
                JOptionPane.showMessageDialog(f,"Mobile number must be of 10 digits");
	    }
            else if(address.equals(""))
            {
                JOptionPane.showMessageDialog(f,"please fill Employee Mobie Number");
	    }
           
            else
            {
              new ExtraServic();
               f.dispose();
            }
       }
       else if(e.getSource()==bclear)
       {
          clear();
       }
       else if(e.getSource()==cb)
       {
        String rcnum = (String)cb.getSelectedItem();
           try
	     {
                 con=DB.getConnection();
		//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		//con=DriverManager.getConnection("jdbc:odbc:930batch");
		ps=con.prepareStatement("select * from custmr");
		rs=ps.executeQuery();
		while(rs.next())
		{
                    if(rcnum.equals(rs.getString(1)))
		     {
			tcrcnum.setText(rs.getString(1));
			tcname.setText(rs.getString(2));
			tctype.setText(rs.getString(3));
			//tfephone.setText(rs.getInt(4)+"");
                        tcphone.setText(rs.getString(4));
                        tcaddress.setText(rs.getString(5));
                        
                        tcdor.setText(rs.getString(6));
                        tcvor.setText(rs.getString(7));
                        
		     }
		}
		updateCombo();
                cb.setSelectedItem(rcnum);
		con.close();
	     }
	     catch(Exception ae)
             {
             }
         }
         else if(e.getSource()==bupdate)
	{
            
           
            String rcno=tcrcnum.getText();
            String name=tcname.getText();
            String vt=tctype.getText();
            String phone=tcphone.getText();
	    String address=tcaddress.getText();
            String dor = tcdor.getText();
            String vor=tcvor.getText();
	    boolean valid=false;
            
            if(rcno.equals(""))
	    {
                JOptionPane.showMessageDialog(f,"please fill RC number");
	    }
            else if(name.replaceAll("\u00A0","").length()<2)
	    {
                tcname.setText("");
                JOptionPane.showMessageDialog(f,"Customer Name must be of atleast 2 letters");
	    }
            else if(vt.equals(""))
            {
                JOptionPane.showMessageDialog(f,"please fill Vehical type");
	    }
            else if(phone.replaceAll("\u00A0","").length()!=13)
            {
                tcphone.setText("");
                JOptionPane.showMessageDialog(f,"Mobile number must be of 10 digits");
	    }
            else if(address.equals(""))
            {
                JOptionPane.showMessageDialog(f,"please fill Employee Mobie Number");
	    }
            else if(dor.replaceAll("\u00A0","").length()<9)
            {
                JOptionPane.showMessageDialog(f,"please fill Date of registration");
	    }
            else if(vor.replaceAll("\u00A0","").length()<9)
            {
                JOptionPane.showMessageDialog(f,"please fill Validity of registration");
	    }
            else
            {
                try
                {
                    con=DB.getConnection();
                    ps=con.prepareStatement("update custmr set c_name=?,c_vt=?,c_phone=?,c_address=?,c_dor=?,c_vor=? where c_rc=?");
                    ps.setString(7,rcno);
		    ps.setString(1,name);
		    //ps.setInt(3,Integer.parseInt(ephone));
                    ps.setString(2,vt);
                    ps.setString(3,phone);
		    ps.setString(4,address);
                     ps.setString(5,dor);
                    ps.setString(6,vor);
                    ps.executeUpdate();
		    JOptionPane.showMessageDialog(f,"Message : "+rcno+" Successfully updated");
		}catch(Exception ae) {System.out.println(e); }
            }
             
        }
     }
}
    
           

    

