
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;  
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

public class Employee_Details implements ActionListener
{
     Connection con;
     PreparedStatement ps;
     ResultSet rs;
     private JFrame f;
     private JPanel p;
     private JTextField teid,tname,taddress,tpass,tphone,tcode;
     private JLabel lid,ltitle,lname,laddress,lpass,lphone,bak;
     private JButton blogout,bupdate,bclear,bdelete,binsert;
     private JComboBox cb;
    
    
    Employee_Details() throws SQLException, ParseException
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        f = new JFrame("EMPLOYEE DETAILS");
        p = new JPanel();
        f.add(p);
        f.setResizable(false);
        f.setSize(1366,768);
        f.setVisible(true);
        p.setLayout(null);
        
        
        
        //labels
        bak = new JLabel(new ImageIcon("C:\\Users\\NtN\\Downloads\\Pictures\\paradise_minions_despicable_me_2-1366x768.jpg"));
        p.add(bak);
        bak.setBounds(0,0,1366,768);
        
        ltitle = new JLabel("EMPLOYEE DETAILS");
        ltitle.setFont(new Font("Curlz MT",Font.BOLD,25));
        bak.add(ltitle);
        ltitle.setForeground(Color.WHITE);
        ltitle.setBounds(600,150,270,30);
        
        lid = new JLabel("EMPLOYEE ID:");
        bak.add(lid);
        lid.setBounds(450,250,250,30);
        lid.setFont(new Font("Elephant",Font.BOLD,18));
        lid.setForeground(Color.WHITE);
        
        lname = new JLabel("EMPLOYEE NAME:");
        bak.add(lname);
        lname.setBounds(450,300,250,30);
        lname.setFont(new Font("Elephant",Font.BOLD,18));
        lname.setForeground(Color.WHITE);
        
        laddress = new JLabel("ADDRESS:");
        bak.add(laddress);
        laddress.setBounds(450,350,250,30);
        laddress.setFont(new Font("Elephant",Font.BOLD,18));
        laddress.setForeground(Color.WHITE);
        
        lpass = new JLabel("PASSWORD:");
        bak.add(lpass);
        lpass.setBounds(450,400,250,30);
        lpass.setFont(new Font("Elephant",Font.BOLD,18));
        lpass.setForeground(Color.WHITE);
        
        lphone = new JLabel("MOBILE NUMBER:");
        bak.add(lphone);
        lphone.setBounds(450,450,250,30);
        lphone.setFont(new Font("Elephant",Font.BOLD,18));
        lphone.setForeground(Color.WHITE);
        
        //Text Fields
        
        teid = new JTextField(2);
        bak.add(teid);
        teid.setFont(new Font("",Font.BOLD,18));
        teid.setBounds(720,250,90,30);
        
        tname = new JTextField();
        bak.add(tname);
        tname.setFont(new Font("",Font.BOLD,18));
        tname.setBounds(720,300,200,30);
        tname.addKeyListener(new KeyAdapter()
        {
        public void keyTyped(KeyEvent ke)
        {
            String name = tname.getText();
            char ch = ke.getKeyChar();
            if(Character.isDigit(ch))
            {
		tname.setText("");
		JOptionPane.showMessageDialog(null, "Name must be of atleast 2 letter with no numericin it");
            }
        }
        });
        
        taddress = new JTextField();
        bak.add(taddress);
        taddress.setFont(new Font("",Font.BOLD,18));
        taddress.setBounds(720,350,200,30);
        
        tpass = new JTextField();
        bak.add(tpass);
        tpass.setFont(new Font("",Font.BOLD,18));
        tpass.setToolTipText("Password must be of atleast 4 digits");
        tpass.setBounds(720,400,200,30);
        
        
        tcode = new JTextField("+91");
        bak.add(tcode);
        tcode.setFont(new Font("",Font.BOLD,18));
        tcode.setBounds(720,450,40,30);
        tcode.setEditable(false);
        
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        format.setMaximumIntegerDigits(13);
        //format.setMaximumFractionDigits(2);
        //formatter.setMaximum(11);
       //formatter.setAllowsInvalid(false);
        //JOptionPane.showMessageDialog(null,tphone);
       // MaskFormatter form = new MaskFormatter("##########");
        tphone = new JFormattedTextField(formatter);
        bak.add(tphone);
        tphone.setFont(new Font("",Font.BOLD,18));
        tphone.setBounds(760,450,160,30);
        /*tphone.addKeyListener(new KeyAdapter() 
        {
            public void KeyTyped(KeyEvent k)
            {
                String s = tphone.getText();
		if(s.length()<14)
		{
                  tphone.setText("");  
		}
             }
        });
        tphone.addKeyListener(new KeyAdapter()
        {
            public void KeyTyped(KeyEvent ke)
            {
                if(tphone.getText()<10 && tphone.getText()>=10 )
                {
                }
            }
                    
        });*/
        
        //buttons

        binsert = new JButton("INSERT");
        bak.add(binsert);
        binsert.setBounds(460,520,100,30);
        binsert.addActionListener(this);
        
        bupdate = new JButton("UPDATE");
        bak.add(bupdate);
        bupdate.setBounds(580,520,100,30);
        bupdate.addActionListener(this);
        
        bclear = new JButton("CLEAR");
        bak.add(bclear);
        bclear.setBounds(700,520,100,30);
        bclear.addActionListener(this);
        
        blogout = new JButton("LOGOUT");
        bak.add(blogout);
        blogout.setBounds(1100,140,100,30);
        blogout.addActionListener(this);
        
        bdelete = new JButton("DELETE");
        bak.add(bdelete);
        bdelete.setBounds(820,520,100,30);
        bdelete.addActionListener(this);
        
        //ComboBox
        
        cb = new JComboBox();
        bak.add(cb);
        cb.setBounds(820,250,100,30);
        cb.addActionListener(this);
        updateCombo();
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
     public void updateCombo() throws SQLException
    {
        try
        {
            con = DB.getConnection();
            ps = con.prepareStatement("Select e_id from emp");
            rs = ps.executeQuery();
            cb.removeAllItems();
            while(rs.next())
            {
                cb.addItem(rs.getString("e_id"));
                
            }
        }
        catch(Exception e)
        {}
    }
     void clear()
    {
      teid.setText("");
      tname.setText("");
      taddress.setText("");
      tpass.setText("");
      tphone.setText("");
    }
    
    
   
    public static void main(String args[]) throws SQLException, ParseException
    {
        new Employee_Details();
    }
     @Override
    public void actionPerformed(ActionEvent e)  
    {
        String eid=teid.getText();
	String ename=tname.getText();
	String eaddress=taddress.getText();
        String epass = tpass.getText();
	String ephone=tphone.getText();
      if(e.getSource()==blogout)
       {
           try {
               new Start();
           } catch (SQLException ex)
           {
               
           }
          f.dispose();
          JOptionPane.showMessageDialog(f,"u r Successfuly logged out");
       }
       else if(e.getSource()==bclear)
       {
          clear();
       }
       else if(e.getSource()==binsert)
			{
				
				boolean valid=false;
				if(eid.equals(""))
				{
					JOptionPane.showMessageDialog(f,"please fill Employee Id");
				}
				else if(ename.equals("") || ename.length()<2)
				{
					JOptionPane.showMessageDialog(f,"Employee Name must be of atleast 2 letters");
                                        tname.setText("");
				}
                                else if(epass.replaceAll("\u00A0","").length()<4)
				{
					JOptionPane.showMessageDialog(f,"please Enter a strong Pasword");
                                        tpass.setText("");
				}
				else if(eaddress.replaceAll("\u00A0","").length()<3)
				{
					JOptionPane.showMessageDialog(f,"Address must be of 3 digits atleast");
				}
				else if(ephone.replaceAll("\u00A0","").length()!=13)
				{
                                    JOptionPane.showMessageDialog(f,"Please correct mobile number");
                                    tphone.setText("");
				}
				else
				{
			    		try
					{
						con=DB.getConnection();
						//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						//con=DriverManager.getConnection("jdbc:odbc:930batch");
						ps=con.prepareStatement("select e_id from emp");
						rs=ps.executeQuery();
						while(rs.next())
						{
							if(eid.equals(rs.getString("e_id")))
							{
								valid=true;
							}
						}
						if(valid)
						{
							JOptionPane.showMessageDialog(f,eid+" already exist!!");
							
						}
						else
						{
							ps=con.prepareStatement("insert into emp values(?, ?, ?, ?, ?)");
							
                                                        ps.setString(1, eid);
							ps.setString(2, ename);
							ps.setString(3, eaddress);
                                                        ps.setString(4, epass);
							//ps.setInt(4, Integer.parseInt(ephone)); if integer value is to be changed in string 
	                                                ps.setString(5, ephone);
							ps.executeUpdate();
							clear();
							updateCombo();
							con.close();
							JOptionPane.showMessageDialog(f,"Message : "+eid+" Successfully inserted");
						}
					}
					catch(SQLException | HeadlessException ae)
					{
						System.out.println(ae);
					}
                                   /*int i = Employ_Dteail_DB.save(eid, ename, epass, eaddress, ephone);
                                    if(i>0)
                                    {
                                       JOptionPane.showMessageDialog(f,"Message : "+eid+" Successfully inserted");
                                    }*/
				}
				 
			}
			else if(e.getSource()==cb)
			{
				     eid=(String)cb.getSelectedItem();
				try
				{
					con=DB.getConnection();
					//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					//con=DriverManager.getConnection("jdbc:odbc:930batch");
					ps=con.prepareStatement("select * from emp");
					rs=ps.executeQuery();
					while(rs.next())
					{
						if(eid.equals(rs.getString(1)))
						{
                                                    teid.setText(rs.getString(1));
						    tname.setText(rs.getString(2));
						    taddress.setText(rs.getString(3));
						    //tfephone.setText(rs.getInt(4)+"");
                                                    tpass.setText(rs.getString(4));
                                                    tphone.setText(rs.getString(5));
						}
					}
					updateCombo();
                                        cb.setSelectedItem(eid);
					con.close();
				}
				catch(Exception ae){}
			}
			else if(e.getSource()==bupdate)
			{
				
				boolean valid=false;
                                if(eid.equals(""))
				{
					JOptionPane.showMessageDialog(f,"please fill Employee Id");
				}
				else if(ename.replaceAll("\u00A0","").length()<2)
				{
                                        tname.setText("");
					JOptionPane.showMessageDialog(f,"please fill Employee Name");
				}
                                else if(epass.replaceAll("\u00A0","").length()<4)
				{
                                        tpass.setText("");
					JOptionPane.showMessageDialog(f,"please Enter a strong password");
				}
				else if(eaddress.replaceAll("\u00A0","").length()<3)
				{
                                        taddress.setText("");
					JOptionPane.showMessageDialog(f,"please fill Employee Address");
				}
				else if(ephone.replaceAll("\u00A0","").length()!=13)
				{
                                        tphone.setText("");
					JOptionPane.showMessageDialog(f,"Mobie Number must be of 10 digits");
				}
				else
                                {
                                    try
				    {
                                        Class.forName("com.mysql.jdbc.Driver");
                                       Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/service_center","root","1234");
                                        // con.setAutoCommit(false);
                                         System.out.println(conn);
					ps=conn.prepareStatement("update emp set e_name=?,e_address=?,e_pass=?,e_phone=? where e_id=?");
					
                                        System.out.println(ps);
                                        
                                       ps.setString(1,ename);
					//ps.setInt(3,Integer.parseInt(ephone));
                                        ps.setString(2,eaddress);
                                        ps.setString(3,epass);
					ps.setString(4,ephone);
                                       ps.setString(5,eid);
					
                                        System.out.println(ephone);
					 int i = ps.executeUpdate();
                                     JOptionPane.showMessageDialog(f,"Message :" +i+" Successfully updated");
                                          
                                         
                                      }
			            catch(SQLException ae)
			            {
                                        System.out.print(ae);
                                    } catch (ClassNotFoundException ex) {
                                        Logger.getLogger(Employee_Details.class.getName()).log(Level.SEVERE, null, ex);
                                    } 
                                }		
		}
			else if(e.getSource()==bdelete)
			{
				     eid=teid.getText();
				try
				{
					con=DB.getConnection();
					ps=con.prepareStatement("delete from emp where e_id=?");
					ps.setString(1,eid);
					ps.executeUpdate();
					updateCombo();
					JOptionPane.showMessageDialog(f,"Message : "+eid+" Successfully deleted");
                                         teid.setText("");
                                         tname.setText("");
                                         taddress.setText("");
                                         tpass.setText("");
                                         tphone.setText("");
				}
			catch(Exception ae)
			{
				System.out.println(e);
			}
		}
       
       
        
       
        
   }
           
}
    

