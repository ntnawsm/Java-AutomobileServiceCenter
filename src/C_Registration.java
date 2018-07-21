
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date.*;
import java.util.Map;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

// BRO ADD A LABEL WITH IMAGE ICON AND ADD ALL THE COMPONENTS IN THE LABEL :)


public class C_Registration 
{ 
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    private JFrame f;
    private JPanel p1;
   
    private JLabel lrcnum,ltitle,lreg,ldate,lname,lrcn,lphone,laddress,ltype,ldor,lvos,lbak,lbak1;
    private JTextField trcnum,ttime,tname,tphone,taddress,trcn,tdor,tvos;
    private JButton bsubmit,brsubmit,bclear,brclear,blogout;
    private JComboBox cb,cb1;
    
   
    
    C_Registration() throws SQLException, ParseException
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        f = new JFrame("AutoMobile Service Center");
       
        p1 = new JPanel();
        
        f.add(p1);
        
        f.setSize(1366,768);
        f.setLocation(0,0);
        f.setVisible(true);
        // f.setResizable(false);    Gives error 1 in 3
         
        //PANEL 
        p1.setLayout(null);
       
        
        //Labels
        
        lbak1 = new JLabel(new ImageIcon("C:\\Users\\NtN\\Downloads\\Pictures\\color_3d-wallpaper-1366x768.jpg"));
        p1.add(lbak1);
        lbak1.setBounds(0,0,1366,768);
        
        lreg = new JLabel("REGISTRATION PAGE");
        lreg.setFont(new Font("Aharoni",Font.PLAIN,25));
        lreg.setForeground(Color.WHITE);
        lbak1.add(lreg);
        lreg.setBounds(600,130,270,30);
        
        lrcn = new JLabel("ENTER RC NUMBER:");
        lbak1.add(lrcn);
        lrcn.setForeground(Color.WHITE);
        lrcn.setFont(new Font("Kristen ITC",Font.BOLD,18));
        lrcn.setBounds(450,230,300,30);
        
        lname = new JLabel("NAME");
        lbak1.add(lname);
        lname.setForeground(Color.WHITE);
        lname.setFont(new Font("Kristen ITC",Font.BOLD,18));
        lname.setBounds(450,280,300,30);
        
         
        ltype = new JLabel("VEHICLE TYPE:");
        lbak1.add(ltype);
        ltype.setForeground(Color.WHITE);
        ltype.setFont(new Font("Kristen ITC",Font.BOLD,18));
        ltype.setBounds(450,330,300,30);
        
        lphone = new JLabel("ENTER MOBILE NUMBER:");
        lbak1.add(lphone);
        lphone.setForeground(Color.WHITE);
        lphone.setFont(new Font("Kristen ITC",Font.BOLD,18));
        lphone.setBounds(450,380,300,30);
        
        laddress = new JLabel("ENTER ADDRESS:");
        lbak1.add(laddress);
        laddress.setForeground(Color.WHITE);       
        laddress.setFont(new Font("Kristen ITC",Font.BOLD,18));
        laddress.setBounds(450,430,300,30);
        
        ldor = new JLabel("DATE OF REGISTRATION:");
        lbak1.add(ldor);
        ldor.setForeground(Color.WHITE);
        ldor.setFont(new Font("Kristen ITC",Font.BOLD,18));
        ldor.setBounds(450,480,300,30);
        
        lvos = new JLabel("DATE OF VALIDITY:");
        lbak1.add(lvos);
        lvos.setForeground(Color.WHITE);        
        lvos.setFont(new Font("Kristen ITC",Font.BOLD,18));
        lvos.setBounds(450,530,300,30);
        
        //TextFields
        trcn = new JTextField();
        lbak1.add(trcn);
        trcn.setFont(new Font("",Font.BOLD,18));
        trcn.setBounds(750,230,200,30);
        
        tname = new JTextField();
        lbak1.add(tname);
        tname.setFont(new Font("",Font.BOLD,18));
        tname.setBounds(750,280,200,30);
        tname.addKeyListener(new KeyAdapter()
        {
        public void keyTyped(KeyEvent ke)
        {
            char ch = ke.getKeyChar();
            if(Character.isDigit(ch))
            {
		tname.setText("");
		JOptionPane.showMessageDialog(null, "WRONG! input");
            }
        }
        });
        
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        format.setMaximumIntegerDigits(14);
        tphone = new JFormattedTextField(formatter);
        lbak1.add(tphone);
        tphone.setFont(new Font("",Font.BOLD,18));
        tphone.setBounds(750,380,200,30);
        
        taddress = new JTextField();
        lbak1.add(taddress);    
        taddress.setFont(new Font("",Font.BOLD,18));
        taddress.setBounds(750,430,200,30);
         
      
        tdor = new JTextField();
        Date d = new Date();
        tdor.setText(d.getDate()+"/"+(d.getMonth()+1)+"/"+(d.getYear()+1900));
        lbak1.add(tdor);
        tdor.setFont(new Font("",Font.BOLD,18));
        tdor.setBounds(750,480,200,30);
        tdor.setEditable(false);
        

        tvos = new JTextField();
        tvos.setText(d.getDate()+"/"+(d.getMonth()+1)+"/"+(d.getYear()+1901));
        lbak1.add(tvos);       
        tvos.setFont(new Font("",Font.BOLD,18));
        tvos.setBounds(750,530,200,30);
        tvos.setEditable(false);
        
        //Button
        
        brsubmit = new JButton("SUBMIT");
        lbak1.add(brsubmit);
        brsubmit.setBounds(570,600,120,30);
        brsubmit.addActionListener(new Handler());
        
        brclear = new JButton("CLEAR");
        lbak1.add(brclear);
        brclear.setBounds(720,600,120,30);
        brclear.addActionListener(new Handler());
        
        bsubmit = new JButton("HOME");
        lbak1.add(bsubmit);
        bsubmit.setBounds(220,140,120,30);
        bsubmit.addActionListener(new Handler());
        
        //Combo Box
        String s[]={"Vehical Type","2 Wheeler","4 wheeler"};
        cb1 = new JComboBox(s);
        lbak1.add(cb1);
        cb1.setFont(new Font("",Font.BOLD,18));
        cb1.setBounds(750,330,200,30);
         //   cb1.setMaximumRowCount(1);
        
       
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   
    }
    
    
     void clear()
        {
         trcn.setText("");
         tname.setText("");
         cb1.setSelectedIndex(0);   //For selecting the default value cb1.setSelectedItem("");      
         tphone.setText("");
         taddress.setText("");
         
        }
    class Handler implements ActionListener 
    {
       @Override
    public void actionPerformed(ActionEvent e)  
    {
     
     if(e.getSource()==brclear)
     {
       clear();
     } 
     
     
     else if(e.getSource()==brsubmit)
     {
        String rcnum = trcn.getText();
        String name = tname.getText();
        String vt = (String)cb1.getSelectedItem();
        String address = taddress.getText();
        String phone = tphone.getText();
        String date = tdor.getText();
        String valdity = tvos.getText();
        boolean valid = false;
        
        if(rcnum.equals(""))
        {
            JOptionPane.showMessageDialog(f,"Please enter ur rc num");
        }
        else if(name.length()<2)
        {
            tname.setText("");
            JOptionPane.showMessageDialog(f,"Please enter ur name with atleast 2 letters");
        }
        else if(rcnum.equals(""))
        {
            JOptionPane.showMessageDialog(f,"Please enter ur RC Number");
        }
        else if(address.equals(""))
        {
            JOptionPane.showMessageDialog(f,"Please enter the address");
        }
        else if(vt.equals(""))
        {
            JOptionPane.showMessageDialog(f,"Please enter the vehical type");
        }
        else if(phone.length()!=13)
        {
            JOptionPane.showMessageDialog(f,"Please enter  10 digit  mobile number");
        }
        else
        {
            try
					{
						con=DB.getConnection();
						//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						//con=DriverManager.getConnection("jdbc:odbc:930batch");
						ps=con.prepareStatement("select c_rc from custmr");
						rs=ps.executeQuery();
						while(rs.next())
						{
							if(rcnum.equals(rs.getString("c_rc")))
							{
								valid=true;
							}
						}
						if(valid)
						{
							JOptionPane.showMessageDialog(f,rcnum+" already exist!!");
							
						}
						else
						{
							ps=con.prepareStatement("insert into custmr values(?, ?, ?, ?, ?, ?, ?)");
                                                        
							ps.setString(1, rcnum);
                                                        try
                                                        {
							ps.setString(2, name);
                                                        }catch(SQLException b){JOptionPane.showMessageDialog(null,"Only characters can be in name");}
							ps.setString(3, vt);
                                                        ps.setString(4, phone);
							//ps.setInt(4, Integer.parseInt(ephone)); if integer value is to be changed in string 
	                                                ps.setString(5, address);
                                                        try
                                                        {
                                                        ps.setString(6, date);
                                                        ps.setString(7, valdity);
                                                        }catch(SQLException b){JOptionPane.showMessageDialog(null,"Please Check date");}
							ps.executeUpdate();
							con.close();
							JOptionPane.showMessageDialog(f,"Message : "+rcnum+" Successfully inserted");
						}
					}
					catch(SQLException | HeadlessException ae)
					{
						System.out.println(ae);
					}
				}
				 
			}
			
    
     else
     {
         new Emplywel();
         f.dispose();
     }
    }
    }
    
    
    public static void main(String[] args) throws SQLException, ParseException
    {
        C_Registration r;
        r = new C_Registration();
       
    }

}
